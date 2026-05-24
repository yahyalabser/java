package Revision;

import java.util.Comparator;

public class AnneeComparator implements Comparator<Document> {
    @Override
    public int compare(Document d1, Document d2) {
        return Integer.compare(d1.getAnnee(), d2.getAnnee());
    }
}

