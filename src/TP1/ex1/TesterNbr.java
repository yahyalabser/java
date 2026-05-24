package TP1.ex1;

import java.util.Scanner;

public class TesterNbr {
    public static void main(String[] args)
    {
        int s = 0;
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while(!line.equals("0"))
        {
            s = s + Integer.parseInt(line);
            line = scan.nextLine();
        }
        System.out.println(s);
    }
}
