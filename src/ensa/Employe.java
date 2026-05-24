package ensa;

import java.time.LocalDate;
import java.time.Period;

public class Employe {
    private int code;
    private String nom;
    private LocalDate DateN;
    private float salaire;

    public void Employe(int code, String nom, LocalDate DateN, float salaire){
        this.code = code;
        this.nom = nom;
        this.DateN = DateN;
        this.salaire = salaire;
    }

    // Getters/Setters
    public int getCode() {return code;}
    public String getNom() {return nom;}
    public LocalDate getDateN() {return DateN;}
    public float getSalaire() {return salaire;}

    public void setCode(int c) {code = c;}
    public void setNom(String n) {nom = n;}
    public void setDateN(LocalDate d) {DateN = d;}
    public void setSalaire(float s) {salaire = s;}

    public void updateSalaire(float salaire)
    {
        this.salaire = this.salaire + salaire;
    }

    public void AfficherEmploye()
    {
        System.out.println(code);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public int AgeEmploye()
    {
        return Period.between(DateN, LocalDate.now()).getYears();
    }

    public String toString()
    {
        return "Code "+code+" Nom: "+nom+" Date Naissance: "+DateN+" Salaire: "+salaire;
    }
}
