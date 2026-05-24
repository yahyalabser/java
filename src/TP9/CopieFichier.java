package TP9;

import java.io.*;

public class CopieFichier {

    public static int CopierLigne(String src, String dest)
    {
        int nbligne = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(src));
             BufferedWriter out = new BufferedWriter(new FileWriter(dest)))
        {
            String line;
            while ((line = in.readLine()) != null){
                out.write(line);
                out.newLine();
                nbligne++;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return nbligne;
    }

    public static int  CopierCar(String src, String dest)
    {
        int nbligne = 0;

        try (FileReader in = new FileReader(src);
             FileWriter out = new FileWriter(dest))
        {
            int c;
            while ((c = in.read()) != -1)
            {
                out.write(c);
                nbligne++;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return nbligne;
    }

    public static void afficherContenue(String src){
        System.out.println("=== Contenu de : " + src + " ===");
        try (BufferedReader rd = new BufferedReader(new FileReader(src)))
        {
            String line;
            while ((line = rd.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e) { throw new RuntimeException(e); }
        System.out.println("================================");
    }

    public static void main(String[] args) {

        afficherContenue("./src/TP9/facture_src.txt");

        int n1 = CopierCar("./src/TP9/facture_src.txt", "./src/TP9/facture_dest.txt");
        System.out.println("[M1] Lignes copiées : " + n1);

        int n2 = CopierLigne("./src/TP9/facture_src.txt", "./src/TP9/facture_dest.txt");
        System.out.println("[M2] Lignes copiées : " + n2);
    }
}
