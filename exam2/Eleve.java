package exam2;

public abstract class Eleve {
    String nom;
    String prenom;
    int age;
    String niveau;
    String dateN;

    public abstract double Moyenne(double N1, double N2, double N3);

    public int getAge() {return age;}
    public String getNom() {return "L'eleve: " + prenom + " " + nom;}

    public Eleve(String nom, String prenom, int age, String niveau, String dateN){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.niveau = niveau;
        this.dateN = dateN;
    }

    public String toString() {
        return "Nom: " + getNom() +
                "\nPrenom: " + prenom +
                "\nAge: " + getAge() +
                "\nNiveau: " + niveau +
                "\nDate de naissance: " + dateN;
    }
}
