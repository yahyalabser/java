package exam1;

import java.util.Hashtable;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args){
        Responsable R1 = new Responsable("R1","yahya","labser","khouringha", "2015", 24, "ingenieur");
        Responsable R2 = new Responsable("R2","ayoub","labser","khouringha", "2019", 20, "master");
        Responsable R3 = new Responsable("R3","adam","labser","agadir", "2026", 18, "deug");

        Ouvrier O1 = new Ouvrier("O1","hmed","omar","casa", "2024", 2);
        Ouvrier O2 = new Ouvrier("O2","jamal","kamal","rabat", "2022", 3);

        TreeMap<Double, Responsable> treeResp = new TreeMap<>();
        treeResp.put(R1.Calcul_salaire(10), R1);
        treeResp.put(R2.Calcul_salaire(15), R2);
        treeResp.put(R3.Calcul_salaire(15), R3);

        Hashtable<Double, Ouvrier> hashOuv = new Hashtable<>();
        hashOuv.put(O1.Calcul_salaire(50), O1);
        hashOuv.put(O2.Calcul_salaire(60), O2);

        Double[] Tresp = new Double[treeResp.size()];
        int i = 0;
        for(double d: treeResp.keySet()){
            Tresp[i] = d;
            i++;
        }

        Double[] TOuv = new Double[hashOuv.size()];
        int j = 0;
        for(double d: hashOuv.keySet()){
            TOuv[j] = d;
            j++;
        }

        try{
            System.out.println("Les salaire du Responsables: ");
            for(int i1 =0; i1 < Tresp.length; i1++){
                if (Tresp[i1] == null)
                    throw new NulleReferenceException("Un Salaire nulle!!");
                else System.out.println(Tresp[i1]);
            }

            System.out.println("Les salaire d'Ouvriers: ");
            for(int j1 =0; j1 < TOuv.length; j1++){
                if (TOuv[j1] == null)
                    throw new NulleReferenceException("Un Salaire nulle!!");
                else System.out.println(TOuv[j1]);
            }
        }
        catch(NulleReferenceException e) {System.out.println(e.getMessage());}
        finally {System.out.println("Fin de l'affichage.");}
    }
}
