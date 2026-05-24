package TP9;

import java.io.*;

public class SerializationDemo
{
    public static void main(String [] args) throws IOException, ClassNotFoundException
    {
        Client[] clients = {
                new Client (1 , "Ali" , "Benali" , "Casablanca"),
                new Client (2 , "Fatima" , "El Amri" , "Rabat") ,
                new Client (3 , "Omar" , "Haddi" , "Khouribga")
                };

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/TP9/client.ser")))
        {
            for (Client c : clients) oos.writeObject(c);
        }
        String[] noms = new String[clients.length];
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/TP9/client.ser")))
        {
            for (int i = 0; i < noms.length ; i++)
            {
                Client c = (Client) ois.readObject();
                noms [i] = c.getPrenom() + " " + c.getNom();
            }
        }

        System.out.println("Noms complets : ");
        for (String n : noms) System.out.println (" " + n) ;
    }
}
