package TP7;

import java.util.ArrayList;

public class Distributeur {

    private double fonds = 5000;

    public double getFonds() {
        return fonds;
    }
    public void setFonds(double fonds) {
        this.fonds = fonds;
    }

    public void retirer(double montant, String nomClient){
        System.out.println(nomClient + " vérifie le solde : " + getFonds());

        if (montant <= getFonds())
        {
            System.out.println("Solde suffisant.");
            setFonds(getFonds() - montant);
            try{ Thread.sleep(2000); }
            catch (InterruptedException e) { throw new RuntimeException(e); }
            System.out.println("Le nouveau solde : " + getFonds());
        }
        else
            System.out.println("Solde insuffisant.");
    }
}
