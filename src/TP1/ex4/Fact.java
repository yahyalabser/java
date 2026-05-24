package TP1.ex4;

import java.util.Scanner;

public class Fact {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Entrez un entier : ");
        int nbr = Integer.parseInt(scan.nextLine());
        if (nbr < 0)
            System.exit(-1);
        int result = 1;
        for(int i=1; i<= nbr; i++)
            result *= i;
        System.out.println(result);
    }
}
