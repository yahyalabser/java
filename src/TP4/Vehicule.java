package TP4;

public abstract class Vehicule {
    private String immatriculation;
    private int capacite;
    private double consommationBase;

    public Vehicule(){
        immatriculation = "default";
        capacite = 0;
        consommationBase = 0;
    }

    public Vehicule(String immatriculation, int capacite, double consommationBase){
        this.immatriculation = immatriculation;
        this.capacite = capacite;
        this.consommationBase = consommationBase;
    }

    public String getImmatriculation(){return immatriculation;}
    public int getCapacite(){return  capacite;}
    public double getConsommationBase(){return consommationBase;}

    public void setImmatriculation(String immatriculation){this.immatriculation = immatriculation;}
    public void setCapacite(int capacite){this.capacite = capacite;}
    public void setConsommationBase(double consommationBase){this.consommationBase = consommationBase;}

    public abstract double calculerAutonomie();
    public abstract double calculerEfficacite();
}
