package exam1;

public class Ouvrier extends Employe{
    int nbrEnfant;

    public Ouvrier(String m, String n, String p, String a, String d,int nbrEnfant){
        super(m, n, p, a, d);
        this.nbrEnfant = nbrEnfant;
    }

    public String toString() {
        return super.toString() + "\nNombre d'enfant: " + nbrEnfant;
    }

    public double Calcul_salaire(int NBH){
        return 0.1 * Calcul_CAA(NBH) + NBH * 30;
    }
}
