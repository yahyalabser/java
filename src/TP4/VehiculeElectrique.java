package TP4;

public class VehiculeElectrique extends Vehicule{
    private double niveauBatterie;
    private int tempsRecharge;
    private int capaciteBatterie;

    public VehiculeElectrique(){
        super();
        niveauBatterie = 0;
        tempsRecharge = 0;
        capaciteBatterie = 0;
    }

    public VehiculeElectrique(String immatriculation, int capacite, double consommationBase,
                              double niveauBatterie, int tempsRecharge, int capaciteBatterie){
        super(immatriculation, capacite, consommationBase);
        this.niveauBatterie = niveauBatterie;
        this.tempsRecharge = tempsRecharge;
        this.capaciteBatterie = capaciteBatterie;
    }

    public double calculerAutonomie(){
        return niveauBatterie * 100 / (getConsommationBase() * 0.8);
    }
    public double calculerEfficacite(){
        return  (getCapacite() * calculerAutonomie()) / (capaciteBatterie * tempsRecharge / 60);
    }

    public double calculerTempsRechargeReel(){
        return tempsRecharge * (1 - niveauBatterie / capaciteBatterie);
    }

    @Override
    public String toString() {
        return ("immatriculation: " + this.getImmatriculation() +
                "\nautonomie,: " + this.calculerAutonomie() +
                "\nefficacité: " + this.calculerEfficacite() +
                "\ntemps de recharge réel: " + this.calculerTempsRechargeReel());
    }
}
