package Revision;

public class DVD extends Document{

    private int duree;

    public DVD(String t, int a, int d) {
        super(t,a);
        if (d <= 0) throw new IllegalArgumentException("La duree doit etre positif!");
        duree = d;
    }

    public int getDuree() {return duree;}

    @Override
    public String getInfo() {
        return "DVD: " + getTitre() + " - " + getDuree() + "min (" + getAnnee() + ")" ;
    }
}
