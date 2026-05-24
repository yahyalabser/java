package TP7;

public class MainSecurise {

    public static void main(String []args) {
        DistributeurSecurise d = new DistributeurSecurise();

        ClientOperation c1 = new ClientOperation(d, "Ahmed", false, 3000, 3);
        ClientOperation c2 = new ClientOperation(d, "Amal", true, 2000, 2);
        ClientOperation c3 = new ClientOperation(d, "Amal", false, 3000, 1);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        Runnable afficheur = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("Solde actuel : " + d.getFonds());
                    try { Thread.sleep(3000); }
                    catch (InterruptedException e) { return; }
                }
            }
        };

        Thread c = new Thread(afficheur, "afficheur");

        c.setDaemon(true);

        c.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
