package TP3;

public class LocalCommercial extends BienImmobilier{
    String typeC;
    boolean locationM;
    float loyerM;

    public LocalCommercial(){
        typeC = "Default";
        locationM = false;
        loyerM = 0;
    }

    public LocalCommercial(String typeC, boolean locationM, float loyerM){
        super();
        this.typeC = typeC;
        this.locationM = locationM;
        this.loyerM = loyerM;
    }

    public void affiche(){
        super.affiche();
        System.out.println("Type de commerce: " + typeC);
        System.out.println("La location meublée: " + locationM);
        System.out.println("Loyer mensuel actuel: " + loyerM);
    }

    public void calculeValeurLocative() {
        valeurEst = prixAcha * (float)0.008;
        if (locationM)
            valeurEst *= (float)1.15;
        switch (typeC){
            case "Boutique" -> valeurEst *= (float)1.05;
            case "Entrepôt" -> valeurEst *= (float)0.9;
        }
        if (valeurEst < 0)
            valeurEst = 0;
    }
}
