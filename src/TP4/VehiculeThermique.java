package TP4;

public class VehiculeThermique extends Vehicule{
    private double niveauCarburant;
    private String typeCarburant;
    private int cylindree;

    public VehiculeThermique(){
        super();
        niveauCarburant = 0;
        typeCarburant = "Default";
        cylindree = 0;
    }

    public double getNiveauCarburant(){return niveauCarburant;}
    public String getTypeCarburant(){return typeCarburant;}
    public int getCylindree(){return cylindree;}

    public void setNiveauCarburant(double niveauCarburant){this.niveauCarburant = niveauCarburant;}
    public void setTypeCarburant(String typeCarburant){this.typeCarburant = typeCarburant;}
    public void setCylindree(int cylindree){this.cylindree = cylindree;}

    public double calculerAutonomie(){
        return niveauCarburant * 100 / getConsommationBase();
    };

    public double calculerEfficacite(){
        return (getCapacite() * 100) / (getConsommationBase() * cylindree / 1000);
    };

    public double calculerPollution(){
        return getConsommationBase() * cylindree * 0.02;
    }
    @Override
    public String toString(){
        return ("immatriculation: " + this.getImmatriculation() +
                "\nautonomie,: " + this.calculerAutonomie() +
                "\nefficacité: " + this.calculerEfficacite() +
                "\npollution: " + this.calculerPollution());
    }
}
