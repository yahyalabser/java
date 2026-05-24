package TP2.ex3;

public class Etudiant {
    private int id;
    private String nom;
    private float note;

    public Etudiant(){
        id = 0;
        nom = "Default";
        note = 0;
    }

    public Etudiant(int id, String nom, float note){
        this.id = id;
        this.nom = nom;
        this.note = note;
    }

    public int getId() {return id;}
    public String getNom() {return nom;}
    public float getNote() {return note;}

    public void setId(int id) {this.id = id;}
    public void setNom(String nom) {this.nom = nom;}
    public void setNote(float note) {this.note = note;}

    public String toString(){
        return "id: " + id + ", nom: " + nom + ", note: " + note;
    }

    public boolean equals(Etudiant other){
        return this.id == other.id && this.nom.equals(other.nom) && this.note == other.note;
    }
}
