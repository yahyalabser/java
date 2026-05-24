package TP7;

public class ClientOperation implements Runnable{

    DistributeurSecurise distributeur;
    String nom;
    boolean estDepot;
    double montant;
    int nombreOperations;

    public ClientOperation(DistributeurSecurise d, String n, boolean i, double m, int nbr){
        distributeur = d;
        nom = n;
        estDepot = i;
        montant = m;
        nombreOperations = nbr;
    }

    @Override
    public void run() {
        int i = nombreOperations;
        while (i > 0){
            if (estDepot) distributeur.deposer(montant, nom);
            else distributeur.retirer(montant, nom);
            try { Thread.sleep(1000); }
            catch (InterruptedException e) { throw new RuntimeException(e); }
            i--;
        }
    }
}
