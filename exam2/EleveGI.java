package exam2;

public class EleveGI extends Eleve{

    public EleveGI(String nom, String prenom, int age, String niveau, String dateN){
        super(nom, prenom, age, niveau, dateN);
    }

    public double Moyenne(double N1, double N2, double N3){
        return N1 * 0.3 + N2 * 0.4 + N3 * 0.3;
    }
}
