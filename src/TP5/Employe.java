package TP5;

public class Employe implements Comparable<Employe>{
    private int id;
    private String nom;
    private String departement;
    private double salaire;

    public Employe(int id, String nom, String departement, double salaire)
    {
        this.id = id;
        this.nom = nom;
        this.departement = departement;
        this.salaire = salaire;
    }

    public int getId() {return id;}
    public String getNom() {return nom;}
    public String getDepartement() {return departement;}
    public double getSlaire() {return salaire;}

    public void setId (int id) {this.id = id;}
    public void setNom (String nom) {this.nom = nom;}
    public void setepartement (String departement) {this.departement = departement;}
    public void setSlaire (double salaire) {this.salaire = salaire;}

    @Override
    public String toString() {
        return "Id : " + id + "; Nom: " + nom + "Departement: " + departement + "Salaire: " + salaire;
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((Employe) obj).getId();
    }

    @Override
    public int compareTo(Employe autre){
        return Integer.compare(this.id, autre.id);
    }
}
