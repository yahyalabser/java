package TP9;

import java.io.*;
import java.lang.reflect.Array;

public class MultiplesReel {
    private double base;

    public MultiplesReel(double d)
    {
        base = d;
    }

    public void ecrireMultiples(String nomFichier, int n){
        try (DataOutputStream ou = new DataOutputStream(new FileOutputStream(nomFichier)))
        {
            for (int i = 1; i <= n ; i++)
            {
                double result = i * base;
                ou.writeInt(i);
                ou.writeDouble(result);
            }
        }
        catch (IOException e) { System.err.println("Erreur écriture : " + e.getMessage()); }
    }

    public void lireEtAfficher(String nomFichier){
        try (DataInputStream in = new DataInputStream( new FileInputStream(nomFichier)))
        {
            int cout = 0;
            double baseD = 0;
            int coeff = in.readInt();
            double result = in.readDouble();
            baseD = result / coeff;
            cout++;

            while(true)
            {
                try{
                    in.readInt();
                    in.readDouble();
                    cout++;
                } catch (EOFException e) {break;}
            }
            System.out.println("La valeur du réel base : " + baseD);
            System.out.println("Le nombre de multiples stockés : " + cout);
        }
        catch (IOException e) { System.err.println("Erreur lecture : " + e.getMessage());}
    }


    public static void main(String[] arg)
    {
        MultiplesReel m = new MultiplesReel(2.2);

        m.ecrireMultiples("./src/TP9/facture_dest.txt", 10);

        m.lireEtAfficher("./src/TP9/facture_dest.txt");
    }
}
