package exam1;

public interface Int_Cal {
    double C = 5;

    double Calcul_salaire(int NBH);
    default double Calcul_CAA(int NHB){
        return NHB * C;
    }
}
