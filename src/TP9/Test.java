package TP9;

//import TP7.Client;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Test {
    static public void main(String[] args) {
//        Exercice 1 : Fichier texte simple - Catalogue produits

//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("./catalogue.txt"));
//
//            bw.write("nom,prix unitaire");
//            bw.newLine();
//            bw.write("Stylo,5.00");
//            bw.newLine();
//            bw.write("Cahier,15.00");
//
//            bw.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("./catalogue.txt"));
//            String line;
//            while((line = br.readLine()) != null)
//                System.out.println(line);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        Exercice 2 :Lecture et analyse d’un fichier CSV - Commandes clients

        try {
            BufferedReader cmd = new BufferedReader(new FileReader("./src/TP9/commande.csv"));
            String line;
            List<String> l;
            float total;

            line = cmd.readLine();

            if (line != null)
            {
                System.out.println("id_commande, montant total");
                while((line = cmd.readLine()) != null){
                    l = Arrays.stream(line.split(",")).toList();
                    total = Float.parseFloat(l.get(3)) * Float.parseFloat(l.get(4));
                    System.out.println(l.get(0) + ": " + total);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
