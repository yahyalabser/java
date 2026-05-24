package TP2.ex1;

import java.util.Scanner;

public class TexteOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrer un texte : ");
        String t = scan.nextLine();

        System.out.println("Entrer un mot : ");
        String a = scan.nextLine().toUpperCase();

        switch (a) {
            case "UNIVERSITE" -> t = t.replace("UNIVERSITE", "");
            case "FACULTE"    -> t = t.replace("FACULTE", "UNIVERSITE");
            case "ECOLE"      -> t = t + " ECOLE";
            default           -> {
                System.out.println("Opération non reconnue.");
                return;
            }
        }
        System.out.println(t);
    }
}
