package Revision;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        Bibliotheque b = new Bibliotheque();

        try {
        b.indexerDocument(new Livre("JAVA", 2005, "gherabi"));
        b.indexerDocument(new Livre("POO", 2015, "el-malki"));
        b.indexerDocument(new Livre("SQL", 2010, "rochd"));
        b.indexerDocument(new DVD("Journee d'integration", 2025, 5));
        b.indexerDocument(new DVD("DATAVERSE", 2026, 2));
        b.indexerDocument(new DVD("DATAVERSE", 2029, -2));
        b.indexerDocument(new Livre("", 2029, "rochd"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            b.rechercherParTitre("Python");
        } catch (DocumentNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            b.exporterVersTexte("bibliotheque.txt");
        } catch (DocumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

//        System.out.println("=== Tous les documents ===");
//        b.afficherTous();
//
//        System.out.println("=== Triés par année ===");
//        ArrayList<Document> s = b.documentParAnnee();
//        for (Document d : s)
//            System.out.println(d.getInfo());
    }

}
