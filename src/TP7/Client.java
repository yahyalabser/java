package TP7;

class Client implements Runnable{

    Distributeur distributeur;
    String nom;
    double montantRetrait;
    int nombreOperations;

    public Client(Distributeur d, String n, double m, int nbr){
        distributeur = d;
        nom = n;
        montantRetrait = m;
        nombreOperations = nbr;
    }

    @Override
    public void run() {
        int i = nombreOperations;
        while (i > 0){
            distributeur.retirer(montantRetrait, nom);
            try { Thread.sleep(1000); }
            catch (InterruptedException e) { throw new RuntimeException(e); }
            i--;
        }
    }
}
