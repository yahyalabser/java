package TP7;

public class Test {
    public static void main(String []args) {
        Distributeur d = new Distributeur();

        Client c1 = new Client(d, "Ahmed", 3000, 3);
        Client c2 = new Client(d, "Amal", 3000, 3);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();
    }
}
