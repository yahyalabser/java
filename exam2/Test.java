package exam2;

import java.util.Scanner;

public class Test {
    public static Eleve[] inisialisationtab(int N, int M) throws RefNul{
        Scanner scan = new Scanner(System.in);
        Eleve[] tab = new Eleve[N + M];

        int i;
        for(i = 0; i < N; i++){
            System.out.println("L'eleve IID numero" + (i + 1));
            System.out.println("Enter le nom: ");
            String nom = scan.nextLine();
            System.out.println("Enter le prenom: ");
            String prenom = scan.nextLine();
            System.out.println("Enter l'age: ");
            int age = Integer.parseInt(scan.nextLine());
            System.out.println("Enter le niveau: ");
            String niveau = scan.nextLine();
            System.out.println("Enter la date de naissance: ");
            String dataN = scan.nextLine();

            tab[i] = new EleveIID(nom, prenom, age, niveau, dataN);

            if (tab[i] == null)
                throw new RefNul("Reference null!");
        }

        for(int j = i; j < M; j++){
            System.out.println("L'eleve GI numero" + (j + 1));
            System.out.println("Enter le nom: ");
            String nom = scan.nextLine();
            System.out.println("Enter le prenom: ");
            String prenom = scan.nextLine();
            System.out.println("Enter l'age: ");
            int age = Integer.parseInt(scan.nextLine());
            System.out.println("Enter le niveau: ");
            String niveau = scan.nextLine();
            System.out.println("Enter la date de naissance: ");
            String dataN = scan.nextLine();

            tab[j] = new EleveGI(nom, prenom, age, niveau, dataN);

            if (tab[j] == null)
                throw new RefNul("Reference null!");
        }

        return tab;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre le nombre d'eleve IID");
        int N = Integer.parseInt(scan.nextLine());

        System.out.println("Entre le nombre d'eleve GI");
        int M = Integer.parseInt(scan.nextLine());


        try {
            Eleve[] tab = inisialisationtab(N, M);
            double[] moy = new double[tab.length];
            for(int i = 0; i < tab.length; i++){
                System.out.println("Entre les note d'eleve" + (i+1));
                System.out.println("Entrer note 1: ");
                double N1 = scan.nextDouble();
                System.out.println("Entrer note 2: ");
                double N2 = scan.nextDouble();
                System.out.println("Entrer note 3: ");
                double N3 = scan.nextDouble();
                scan.nextLine();
                moy[i] = tab[i].Moyenne(N1, N2, N3);
            }

            double s = 0;
            double max = moy[0];
            double min = moy[0];

            for(int i = 0; i < moy.length; i++){
                s += moy[i];

                if (moy[i] > max) max = moy[i];
                if (moy[i] < min) min = moy[i];

            }

            double moyenne = s / moy.length;
            System.out.println("Le moyenne de la class est: " + moyenne);
            System.out.println("Le max moyenne de la class est: " + max);
            System.out.println("Le min moyenne de la class est: " + min);

        }
        catch (RefNul e) {e.getMessage();}
    }
}
