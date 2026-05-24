package TP6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompteBancaire {
    private String numeroCompte;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;
    private boolean bloque;
    private Date dateCreation;
    private ArrayList<String> historiqueOperations;

    private static List<CompteBancaire> listeTousLesComptes = new ArrayList<>();

// Constructeur
    public CompteBancaire(String numeroCompte, String titulaire, double solde, double decouvertAutorise, boolean bloque, Date dateCreation){
        try{
            for(CompteBancaire c : getTousLesComptes()){
                if(c.getNumeroCompte().equals(numeroCompte)) throw new BanqueException("Le compte du numero "+ numeroCompte+" est deja exist");
            }
        this.numeroCompte = numeroCompte;
        }catch(BanqueException e) {System.out.println(e.getMessage()); return;}

        this.titulaire = titulaire;
        this.solde = solde;
        this.decouvertAutorise = decouvertAutorise;
        this.bloque = bloque;
        this.dateCreation = dateCreation;
        this.historiqueOperations = new ArrayList<>();
        listeTousLesComptes.add(this);
    }
// Getters et Setters

    public static List<CompteBancaire> getTousLesComptes() {return listeTousLesComptes;}
    public static CompteBancaire getCompte(CompteBancaire Compte) throws CompteInexistantException
    {
        for (CompteBancaire c : getTousLesComptes()){
            if (c.getNumeroCompte().equals(Compte.getNumeroCompte())) return c;
        }
        throw new CompteInexistantException("le compte n'exist pas.");
    }
    public String getNumeroCompte() {return this.numeroCompte;}
    public String getTitulaire() {return this.titulaire;}
    public double getSolde() {return this.solde;}
    public double getDecouvertAutorise() {return this.decouvertAutorise;}
    public boolean getBloque(){return this.bloque;}
    public Date getDateCreation() {return this.dateCreation;}
    public ArrayList<String> getHistoriqueOperations() {return historiqueOperations;}

    public void setSolde(double d) {this.solde = d;}
    public void setHistoriqueOperations(String operation) {this.historiqueOperations.add(operation);}
    public static void setLesComptes(CompteBancaire c) {getTousLesComptes().add(c);}


    public void deposer(double nbr){
        try{
            if (nbr < 0) throw new MontantInvalideException("le montant doit etre positif");
            else if (getBloque() == true) throw new CompteBloqueException("le compte est bloqué");
        setSolde(getSolde() + nbr);
        setHistoriqueOperations("Deposer: " + nbr);
        }
        catch(MontantInvalideException | CompteBloqueException e) {System.out.println(e.getMessage());}
    }

    public void retirer(double nbr){
        try{
            if (nbr < 0) throw new MontantInvalideException("le montant doit etre positif");
            else if (getBloque() == true) throw new CompteBloqueException("le compte est bloqué");
            else if (getSolde() - nbr <  getDecouvertAutorise()) throw new DecouvertMaximumDepasseException("Insufisant");
        setSolde(getSolde() - nbr);
        setHistoriqueOperations("Retirer: " + nbr);
        }
        catch(MontantInvalideException | CompteBloqueException | DecouvertMaximumDepasseException e)
            {System.out.println(e.getMessage());}
    }

    public void transferer(CompteBancaire compteDestinataire, double montant){
        try{
            CompteBancaire n = getCompte(compteDestinataire);
            this.retirer(montant);
            compteDestinataire.deposer(montant);
        }
        catch(CompteInexistantException c) {System.out.println(c.getMessage());}
    }

    public void afficherHistorique(){
        System.out.println("Les opérations effectuées sur le compte: ");
        for(String s : getHistoriqueOperations())
            System.out.println(s);
    }

    static public void ajouterCompte (CompteBancaire compte){
        try{
            if (compte == null) throw new CompteInexistantException("le compte est null.");
            CompteBancaire n = getCompte(compte);
        }
        catch(CompteInexistantException c) {
            if (compte != null) setLesComptes(compte);
            else System.out.println(c.getMessage());
        }
    }


    static public CompteBancaire getCompte(String numeroCompte){
        try{
            for(CompteBancaire c : getTousLesComptes()){
                if (c.getNumeroCompte().equals(numeroCompte)) return c;
            }
            throw new CompteInexistantException("Le compte du nemuro " + numeroCompte + " n'exist pas.");
        }
        catch(CompteInexistantException c) {
            System.out.println(c.getMessage());
            return null;
        }
    }


    static public void effectuerVirement(String numeroSource, String numeroDestinataire, double montant){
            CompteBancaire s = getCompte(numeroSource);
            CompteBancaire d = getCompte(numeroDestinataire);

            if (!(d == null) && !(s == null)){
                s.retirer(montant);
                d.deposer(montant);
            }
    }


    static public void afficherTousLesComptes(){
        for(CompteBancaire c : getTousLesComptes()){
            System.out.println("Numero du compte: " + c.getNumeroCompte() +
                    "\nTitulaire : " + c.getTitulaire() +
                    "\nSolde: " + c.getSolde() +
                    "\nDecouvert Autorise :" + c.getDecouvertAutorise() +
                    "\nBloque: " + c.getBloque() +
                    "\nDate Creation :" + c.getDateCreation() +
                    "\nHistorique :" + c.getHistoriqueOperations() +
                    "\n-------------------------------------------------------------------------------------------");
        }
    }
}
