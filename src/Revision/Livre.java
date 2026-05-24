package Revision;

public class Livre extends Document{

    private String auteur;

    public Livre(String t, int an, String a){
        super(t,an);

        if (t == null || t.isEmpty())
            throw new IllegalArgumentException("Titre invalide");
        if (an < 1000 || an > 2026)
            throw new IllegalArgumentException("Annee invalide : " + an);

        auteur = a;
    }

    public String getAuteur() {return auteur;}

    @Override
    public String getInfo() {
        return "Livre: " + getTitre() + " par " + getAuteur() + " (" + getAnnee() + ")" ;
    }
}
