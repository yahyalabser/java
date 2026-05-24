package TP1.ex5;

import java.util.Scanner;

public class Calcule {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre a: ");
        int a = Integer.parseInt(scan.nextLine());
        System.out.println("Entre b: ");
        int b = Integer.parseInt(scan.nextLine());
        System.out.println("Entre c: ");
        int c = Integer.parseInt(scan.nextLine());

        System.out.println("Entre l'operateur: ");
        String operator = scan.nextLine();

        int result;
        switch (operator){
            case "+" -> result= a + b + c;
            case "-" -> result= a - b - c;
            case "*" -> result= a * b * c;
            default -> {
                System.out.println("opreation n'est pas connais!");
                return;
            }
        };

        System.out.println("la resultat est : " + result);
    }
}
