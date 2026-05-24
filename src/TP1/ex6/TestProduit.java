package TP1.ex6;

public class TestProduit {
    public static void main(String[] args)
    {
        Produit p1 = new Produit(1,30000);
        Produit p2 = new Produit(2,3500);

        p1.augmenter(300);
        p2.diminuer(3);

        p1.afficher();
        p2.afficher();
    }
}
