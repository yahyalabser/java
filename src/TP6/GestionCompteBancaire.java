package TP6;

import java.time.LocalDate;
import java.util.Date;

public class GestionCompteBancaire {
    public static void main(String[] args){
//        Ajouter 3 comptes valides
        CompteBancaire c1 = new CompteBancaire("C1","yahya",100,50,false, new Date());
        CompteBancaire c2 = new CompteBancaire("C2","adam",1000,50,false, new Date());
        CompteBancaire c3 = new CompteBancaire("C3","ayoub",500,50,false, new Date());

//        Tenter d'ajouter un compte avec un numéro existant
        CompteBancaire c4 = new CompteBancaire("C3","ayoub",500,50,false, new Date());

//        Déposer de l'argent
        c1.deposer(200);

//        Retirer de l'argent
        c2.retirer(900);

//        Effectuer un virement
        CompteBancaire.effectuerVirement("C3","C1",200);

//        Tenter de retirer un montant supérieur au solde + découvert
        c2.retirer(60);

//        Tenter de déposer un montant négatif
        c3.deposer(-1);

//        Tenter d'effectuer un virement vers un compte inexistant
        CompteBancaire.effectuerVirement("C3","C7",10);

//        Tenter d'utiliser un compte bloqué
        CompteBancaire c5 = new CompteBancaire("C5","ayoub",500,50,true, new Date());
        c5.deposer(100);

//        CompteBancaire.afficherTousLesComptes();
    }
}