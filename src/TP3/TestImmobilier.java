package TP3;

import java.util.Scanner;

public class TestImmobilier {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre les info de la maison:");
        Maison m = new Maison();
        m.adresse = scan.nextLine();
        m.surface = Float.parseFloat(scan.nextLine());
        m.prixAcha = Float.parseFloat(scan.nextLine());
        m.nbrP = Integer.parseInt(scan.nextLine());
        m.existP = Boolean.parseBoolean(scan.nextLine());
        m.surfaceJ = Float.parseFloat(scan.nextLine());


        System.out.println("Entre les info de Local Commercial:");
        LocalCommercial l = new LocalCommercial();
        l.adresse = scan.nextLine();
        l.surface = Float.parseFloat(scan.nextLine());
        l.prixAcha = Float.parseFloat(scan.nextLine());
        l.typeC = scan.nextLine();
        l.locationM = Boolean.parseBoolean(scan.nextLine());
        l.loyerM = Float.parseFloat(scan.nextLine());


        m.calculeValeurLocative();
        l.calculeValeurLocative();

        m.affiche();
        l.affiche();
    }
}
