package TP10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {

        String url  = "jdbc:mysql://localhost:3306/t-membre";
        String user = "root";
        String pwd  = "yahya123";

        try (Connection conn = DriverManager.getConnection(url, user, pwd)) {
            System.out.println("✓ Connexion MySQL réussie !");
        } catch (SQLException e) {
            System.out.println("✗ Erreur : " + e.getMessage());
        }
    }
}
