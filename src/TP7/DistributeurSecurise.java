package TP7;

public class DistributeurSecurise {
    private double fonds = 5000;

    public synchronized double getFonds() {
        return fonds;
    }
    public synchronized void setFonds(double fonds) {
        this.fonds = fonds;
    }

    public synchronized void retirer(double montant, String nomClient){
        System.out.println(nomClient + " tente de retirer : " + montant);

        while (montant > getFonds())
        {
            System.out.println("Solde insuffisant, " + nomClient + " attend...");
            try {wait();}
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
        try{ Thread.sleep(2000); }
        catch (InterruptedException e) { throw new RuntimeException(e); }
        setFonds(getFonds() - montant);
        System.out.println("Le nouveau solde : " + getFonds());
    }

    public synchronized void deposer(double montant, String nomClient){
        System.out.println(nomClient + " dépose : " + montant);

        setFonds(getFonds() + montant);
        System.out.println("Le nouveau solde : " + getFonds());
        notifyAll();
    }
}
