package exam1;

public class Employe implements Int_Cal{
    String Matricule;
    String Nom;
    String Prenom;
    String adress;
    String date_embauche;

    public Employe(String m, String n, String p, String a, String d){
        Matricule= m;
        Nom = n;
        Prenom = p;
        adress = a;
        date_embauche = d;
    }

    public double Calcul_salaire(int NBH){
        return this.Calcul_CAA(NBH);
    }

    public String toString(){
        return "Matricule :" + Matricule +
                "\nNom: " + Nom +
                "\nPrenom: " + Prenom +
                "\nAdress: " + adress +
                "\nDate d'embauche: " + date_embauche;
    }
}