package TP2.ex3;

import java.util.Scanner;

public class TestEtudiant {
    static float calculerMoyenne(Etudiant[] tab){
        float s = 0;
        for (int i =0; i < tab.length; i++)
            s += tab[i].getNote();
        return s / tab.length;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Entree le nbr des etudiants: ");
        int N = Integer.parseInt(scan.nextLine());

        Etudiant[] tab = new Etudiant[N];
        for(int i = 0; i < N; i++){
            tab[i] = new Etudiant();
            System.out.println("Entre l'id d'etudiant " + i);
            tab[i].setId(Integer.parseInt(scan.nextLine()));
            System.out.println("Entree le nom d'etudiant " + i);
            tab[i].setNom(scan.nextLine());
            System.out.println("Entree la note d'etudiant " + i);
            tab[i].setNote(Float.parseFloat(scan.nextLine()));
        }

        System.out.println("Les etudiants:");
        for(int i = 0; i < N; i++)
            System.out.println(tab[i].toString());

        System.out.println("La moyenne des notes: " + calculerMoyenne(tab));

        System.out.println("Entre deux indices i et j :");
        int i = Integer.parseInt(scan.nextLine());
        int j = Integer.parseInt(scan.nextLine());

        if (i >= 0 && j >= 0 && i < N && j < N){
            if (tab[i].equals(tab[j]))
                System.out.println("Les deux etudiants sont identiques");
            else
                System.out.println("Les deux etudiants ne sont pas identiques");
        }
        else
            System.out.println("Indices invalides ! Doit être entre 0 et " + (N-1));
    }
}
