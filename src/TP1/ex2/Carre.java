package TP1.ex2;

public class Carre {
    public static void main(String[] args){
        int n = -3;
        while (n <= 3){
            if (n == 0){
                n++;
                continue;
            }
            System.out.println(n * n);
            n++;
        }
    }
}
