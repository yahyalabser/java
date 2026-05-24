package TP9;

import java.io.Serializable;

public class Client implements Serializable{

    private String nom;
    private String prenom;
    private String adress;
    private int idClient;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdress() {
        return adress;
    }

    public Client(int id, String n, String p, String a)
    {
        idClient = id;
        nom = n;
        prenom = p;
        adress = a;
    }
}
