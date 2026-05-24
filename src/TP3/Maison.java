package TP3;

public class Maison extends BienImmobilier{
    int nbrP;
    float surfaceJ;
    boolean existP;

    public Maison(){
        nbrP = 0;
        surfaceJ = 0;
        existP = false;
    }

    public  Maison(int nbrP, float surfaceJ, boolean existP){
        super();
        this.nbrP = nbrP;
        this.surfaceJ = surfaceJ;
        this.existP = existP;
    }

    public void affiche(){
        super.affiche();
        System.out.println("Nombre de pièces: " + nbrP);
        System.out.println("Surface du jardin: " + surfaceJ);
        System.out.println("Exist une piscine: " + existP);
    }

    public void calculeValeurLocative(){
        super.calculeValeurLocative();
        if (surfaceJ > 50)
            valeurEst *= (float)1.1;
        if (existP)
            valeurEst *= (float)1.2;
    }
}
