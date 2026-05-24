package Revision;

public interface Empruntable {

    public String getInfo();
    public default Boolean isAvailable() { return true; }
}
