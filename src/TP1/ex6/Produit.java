package TP1.ex6;

public class Produit {
    int code;
    String intitule;
    float prix;
    String marque;

    public Produit() {
        code = 0;
        intitule = "Default";
        prix = 0;
        marque = "Default";
    }

    public Produit(int code, float prix) {
        this.code = code;
        this.intitule = "Default";
        this.prix = prix;
        this.marque = "Default";
    }

    public float getPrix() {
        return prix;
    }

    public String getMarque() {
        return marque;
    }

    public void afficher() {
        System.out.println("Code: " + code);
        System.out.println("Intitule: " + intitule);
        System.out.println("Prix: " + getPrix());
        System.out.println("Marque: " + getMarque());
    }

    public void augmenter(float m) {
        if (m <= 0.05 * prix)
            prix = prix + m;
        else
            System.out.println("Montant dépasse 5% du prix !");
    }

    public void diminuer(float n) {
        if (prix > 1000)
            prix = prix - (n / 100 * prix);
        else
            System.out.println("Prix doit être supérieur à 1000dh !");
    }
}
