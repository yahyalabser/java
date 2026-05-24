package TP5;

import java.util.*;

public class GestionEmployes {
    public static void main(String[] arg) {
// Les collections Set :
        //HashSet:
        HashSet<Employe> ensembleEmployes = new HashSet<>();
        for (int i = 0; i < 5; i++)
            ensembleEmployes.add(new Employe(i, "Etudiant" + i + 1,
                    "D" + i + 1, (i + 1) * 1500));
        // TreeSet :
        TreeSet<Employe> ensembleTries = new TreeSet<>(ensembleEmployes);
        // Affichage et mesure des performances :
        long t0 = System.nanoTime();
        System.out.println(ensembleEmployes);
        long t1 = System.nanoTime();
        System.out.println("le temps pour afficher une hashset: " + (t1 - t0));

        t0 = System.nanoTime();
        System.out.println(ensembleTries);
        t1 = System.nanoTime();
        System.out.println("le temps pour afficher une treeset: " + (t1 - t0));
        // LinkedHashSet :
        LinkedHashSet<Employe> ensembleLinked = new LinkedHashSet<>();
        ensembleLinked.addAll(ensembleEmployes);
        ensembleLinked.addAll(ensembleTries);
        // Conversion en tableau :
        Employe[] tableauEmployes = new Employe[2];
        tableauEmployes = ensembleLinked.toArray(tableauEmployes);

// Les collections Map :
        // HashTable :
        Hashtable<Integer, String> mapEmployes = new Hashtable<>();
        ArrayList<String> listeNomsEmployes = new ArrayList<>();
        for (int i = 0; i < tableauEmployes.length; i++) {
            if (tableauEmployes[i].getSlaire() > 5000)
                listeNomsEmployes.add(tableauEmployes[i].getNom());
            else
                mapEmployes.put(tableauEmployes[i].getId(), tableauEmployes[i].getNom());
        }
        // Recherche dans la Hashtable
        System.out.println("Chaecher id = 103 et le Nom = Mohamed :");
        if (mapEmployes.containsKey(103))
            System.out.println("L'id 103 exist");
        if (mapEmployes.containsValue("Mohamed"))
            System.out.println("Le Nom Mohamed exist");
        // HashMap :
        HashMap<Integer, String> copieMapEmployes = new HashMap<>(mapEmployes);
// Utilisation des itérateurs :
        // Iterator :
        System.out.println("les éléments de listeNomsEmployes:");
        Iterator<String> iterator = listeNomsEmployes.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        // Enumeration :
        System.out.println("les valeurs de mapEmployes: ");
        Enumeration<String> e = mapEmployes.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement());
        // entrySet() :
        Set<Map.Entry<Integer, String>> entrees = copieMapEmployes.entrySet();
        for (Map.Entry<Integer, String> s : entrees) {
            System.out.println("Id : " + s.getKey() + " | Nom : " + s.getValue());
        }
// Test de performance :
        Set<Map.Entry<Integer, String>> e1 = mapEmployes.entrySet();
        System.out.println("Les elements du mapEmployes: ");
        t0 = System.nanoTime();
        for (Map.Entry<Integer, String> s : e1)
            System.out.println("Id : " + s.getKey() + " | Nom : " + s.getValue());
        t1 = System.nanoTime();
        long r0 = t1-t0;
        System.out.println("Le temps pour afficher les elements du mapEmployes est: " + r0);

        Set<Map.Entry<Integer, String>> e2 = copieMapEmployes.entrySet();
        System.out.println("Les elements du copieMapEmployes: ");
        t0 = System.nanoTime();
        for (Map.Entry<Integer, String> s : e2)
            System.out.println("Id : " + s.getKey() + " | Nom : " + s.getValue());
        t1 = System.nanoTime();
        long r1 = t1-t0;
        System.out.println("Le temps pour afficher les elements du copieMapEmployes est: " + r1);

        System.out.println("la différence de temps en nanosecondes: " + (r1-r0));
    }
}
