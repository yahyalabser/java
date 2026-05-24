package TP3;

public class BienImmobilier {
    String adresse;
    float surface;
    float prixAcha;
    float valeurEst;

    public BienImmobilier(){
        adresse = "Deafault";
        surface = 0;
        prixAcha = 0;
        valeurEst = 0;
    }

    public BienImmobilier(String adress, float surface, float prixAcha){
        this.adresse = adress;
        this.surface = surface;
        this.prixAcha = prixAcha;
    }

    public void affiche(){
        System.out.println("Adress: "+ adresse);
        System.out.println("Surface: " + surface);
        System.out.println("Prix d'achat: " + prixAcha);
        System.out.println("La valeur locative estimée: " + valeurEst);
    }

    public void calculeValeurLocative(){
        valeurEst = (float)0.005 * prixAcha;
    }
}
