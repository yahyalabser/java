package exam2;

public class EleveIID extends Eleve{

    public EleveIID(String nom, String prenom, int age, String niveau, String dateN){
        super(nom, prenom, age, niveau, dateN);
    }

    @Override
    public double Moyenne(double N1, double N2, double N3) {
        return (N1 * 0.4 + N2 * 0.6) * 0.4 + N3 * 0.6;
    }
}
