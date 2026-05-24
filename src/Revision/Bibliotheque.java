package Revision;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bibliotheque {

    private ArrayList<Document> documents;
    private Map<String, Document> index = new HashMap<>();

    public Bibliotheque(){
        documents = new ArrayList<>() ;
    }

    public ArrayList<Document> getDocuments() {return documents;}

    public void ajouterDocument(Document d) throws DocumentException{
        if (d == null) throw new DocumentException("Document invalide: null");
        documents.add(d);
    }

    public void afficherTous(){
        for(Document d : getDocuments())
            System.out.println(d.getInfo());
    }

    public int compterDocuments(){ return documents.size(); }

    public void indexerDocument(Document d){
        documents.add(d);
        index.put(d.getTitre(), d);
    }

    public Document rechercherParTitre(String titre) throws DocumentNotFoundException{
        if (index.get(titre) == null ) throw new DocumentNotFoundException("Document introuvable: " + titre);
        return index.get(titre);
    }

    public ArrayList<Document> documentParAnnee(){
        ArrayList<Document> cp = new ArrayList<>(documents);
        cp.sort(new AnneeComparator());
        return cp;
    }

    public void exporterVersTexte(String nomFichier) throws DocumentException {
        try(FileWriter fw = new FileWriter(nomFichier)){
            for (Document d : documents)
                fw.write(d.getInfo() + "\n");
        } catch (IOException e) {
            throw new DocumentException("Erreur exception", e);
        }
    }
}
