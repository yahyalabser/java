package exam1;

public class Responsable extends Employe{
    int age;
    String diplome;

    public Responsable(String m, String n, String p, String a, String d, int age, String diplome){
        super(m, n, p, a, d);
        this.age = age;
        this.diplome = diplome;
    }

    public String toString() {
        return super.toString() +
                "\nAge: " + age +
                "\nDiplome: " + diplome;
    }

    public double Calcul_salaire(int NBH){
        double s = 0.3 * Calcul_CAA(NBH) + NBH * 80;
        if (diplome.equalsIgnoreCase("ingenieur"))
            s += 500;
        return s;
    }
}
