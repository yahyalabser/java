package TP4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GestionTransport {
    public static void main(String[] args) {
//        Création des données

        ArrayList<VehiculeThermique> l1 = new ArrayList<>();
        VehiculeThermique t1 = new VehiculeThermique();
        VehiculeThermique t2 = new VehiculeThermique();
        VehiculeThermique t3 = new VehiculeThermique();

        l1.add(t1);
        l1.add(t2);
        l1.add(t3);

        ArrayList<VehiculeElectrique> l2 = new ArrayList<>();
        VehiculeElectrique e1 = new VehiculeElectrique();
        VehiculeElectrique e2 = new VehiculeElectrique();
        VehiculeElectrique e3 = new VehiculeElectrique();

        l2.add(e1);
        l2.add(e2);
        l2.add(e3);

//        Affichage des métriques pour les véhicules thermiques

        System.out.println("-------Affichage des métriques pour les véhicules thermiques---------");

        ListIterator<VehiculeThermique> it = l1.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
        VehiculeThermique minV = l1.get(0);
        for (VehiculeThermique p : l1){
            if (p.calculerPollution() < minV.calculerPollution()) minV = p;
        }
        System.out.println("le véhicule thermique le plus écologique est : " + minV.toString());

//        Affichage des métriques pour les véhicules électriques

        System.out.println("-------Affichage des métriques pour les véhicules électriques---------");

        ListIterator<VehiculeElectrique> it2 = l2.listIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next().toString());
        }

        double moyE = 0;
        for (VehiculeElectrique p : l2){
            moyE += p.calculerAutonomie();
        }
        moyE /= l2.size();
        System.out.println("l'autonomie moyenne de tous les véhicules électriques:" + moyE);

//        Analyse comparative

        double seuil = 10;
        List<Vehicule> liste1 = new ArrayList<>();

        liste1.addAll(l1);
        liste1.addAll(l2);
        Iterator<Vehicule> it3 = liste1.iterator();

        while(it3.hasNext()){
            Vehicule v3 = it3.next();
            if (v3.calculerEfficacite() > seuil){
                v3.toString();
            }
        }

        double moyT = 0;
        for (VehiculeThermique p : l1){
            moyT += p.calculerAutonomie();
        }
        moyT /= l1.size();
        System.out.println("L'autonomie moyenne des véhicules thermiques vs électriques: " +
                "\nthermiques : " + moyT +
                "\nélectriques: " + moyE);

//        Simulation de trajet
        for (Vehicule v : liste1) {
            System.out.println(v.getImmatriculation() +
                    (v.calculerAutonomie() >= 200 ? " peut effectuer le trajet" : " ne peut pas effectuer le trajet"));
        }
    }
}
