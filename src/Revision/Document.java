package Revision;

import java.util.Comparator;

public abstract class Document implements Empruntable {

    private String titre;
    private int annee;

    public Document(String t, int a){
        titre = t;
        annee = a;
    }

    public int getAnnee() { return annee; }
    public String getTitre() { return titre; }

    public abstract String getInfo();

}
