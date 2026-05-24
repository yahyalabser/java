package TP2.ex2;

import java.util.Scanner;

public class Tableau {
    static void afficherTableau(int[] tab){
        int N = tab.length;
        for(int i=0; i < N ; i++){
            System.out.println("La valeur N"+ i +" est: "+ tab[i]);
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Entre la taille du tableau: ");
        int N = Integer.parseInt(scan.nextLine());

        int[] tab = new int[N];
        for(int i = 0; i<N; i++){
            System.out.println("Entree la valeur N"+i);
            tab[i] = Integer.parseInt(scan.nextLine());
        }
        afficherTableau(tab);
    }
}
