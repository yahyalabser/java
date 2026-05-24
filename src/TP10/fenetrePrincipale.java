package TP10;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fenetrePrincipale extends JFrame {

    JPanel titlePanel;
    JPanel formPanel;
    JPanel buttonPanel;

    JLabel titre;

    JLabel lid;
    JTextField id;

    JLabel lprenom;
    JTextField prenom;

    JLabel lnom;
    JTextField nom;

    JLabel ladresse;
    JTextField adresse;

    JLabel ldateN;
    JTextField dateN;

    JLabel llieuN;
    JTextField lieuN;

    JLabel lsexe;
    JComboBox<String> sexe;

    JLabel lprofession;
    JTextField profession;

    JButton bAjouter;
    JButton bModifier;
    JButton bQuitter;

    Connection conn;

    public fenetrePrincipale() {

        // Connexion à MySQL
        try {
            String url = "jdbc:mysql://localhost:3306/t-membre"
                    + "?useSSL=false&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, "root", "yahya123");
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur de connexion : " + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        setTitle("Formulaire");
        setSize(650, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        titre = new JLabel("Formulaire d'inscription");
        titre.setFont(new Font("Serif", Font.BOLD, 28));
        titlePanel.add(titre);

        formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        formPanel.setLayout(new GridLayout(8, 2, 20, 20));

        lid         = new JLabel("IdMembre:");
        id          = new JTextField();
        lprenom     = new JLabel("Prenom:");
        prenom      = new JTextField();
        lnom        = new JLabel("Nom:");
        nom         = new JTextField();
        ladresse    = new JLabel("Adresse:");
        adresse     = new JTextField();
        ldateN      = new JLabel("Date de Naissance:");
        dateN       = new JTextField();
        llieuN      = new JLabel("Lieu de Naissance:");
        lieuN       = new JTextField();
        lsexe       = new JLabel("Sexe:");
        sexe        = new JComboBox<>();
        sexe.addItem("M");
        sexe.addItem("F");
        lprofession = new JLabel("Profession:");
        profession  = new JTextField();

        formPanel.add(lid);         formPanel.add(id);
        formPanel.add(lprenom);     formPanel.add(prenom);
        formPanel.add(lnom);        formPanel.add(nom);
        formPanel.add(ladresse);    formPanel.add(adresse);
        formPanel.add(ldateN);      formPanel.add(dateN);
        formPanel.add(llieuN);      formPanel.add(lieuN);
        formPanel.add(lsexe);       formPanel.add(sexe);
        formPanel.add(lprofession); formPanel.add(profession);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));

        bAjouter  = new JButton("Ajouter");
        bModifier = new JButton("Modifier");
        bQuitter  = new JButton("Quitter");

        Dimension d = new Dimension(120, 35);
        bAjouter.setPreferredSize(d);
        bModifier.setPreferredSize(d);
        bQuitter.setPreferredSize(d);

        // ─── BOUTON AJOUTER (TP 11 - question 1) ─────────────────
        // Insère les infos saisies dans T_Membre
        bAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (id.getText().isEmpty() || prenom.getText().isEmpty()
                        || nom.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "IdMembre, Prénom et Nom sont obligatoires !",
                            "Champs manquants", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String sql = "INSERT INTO T_Membre (IdMembre, Prenom, Nom, " +
                        "Adresse, DateNaissance, LieuNaissance, Sexe, Profession) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, id.getText());
                    ps.setString(2, prenom.getText());
                    ps.setString(3, nom.getText());
                    ps.setString(4, adresse.getText());
                    ps.setString(5, dateN.getText());
                    ps.setString(6, lieuN.getText());
                    ps.setString(7, (String) sexe.getSelectedItem());
                    ps.setString(8, profession.getText());

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,
                            "Membre ajouté avec succès !",
                            "Succès", JOptionPane.INFORMATION_MESSAGE);
                    viderChamps();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Erreur : " + ex.getMessage(),
                            "Erreur SQL", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ─── BOUTON MODIFIER (TP 11 - question 2) ─────────────────
        // Cherche le membre par IdMembre et affiche ses infos dans les champs
        bModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (id.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Veuillez saisir l'IdMembre à rechercher !",
                            "ID manquant", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String sql = "SELECT * FROM T_Membre WHERE IdMembre = ?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, id.getText());

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        // Afficher automatiquement les infos dans les champs
                        prenom.setText(rs.getString("Prenom"));
                        nom.setText(rs.getString("Nom"));
                        adresse.setText(rs.getString("Adresse"));
                        dateN.setText(rs.getString("DateNaissance"));
                        lieuN.setText(rs.getString("LieuNaissance"));
                        profession.setText(rs.getString("Profession"));

                        // Sélectionner le bon sexe dans le JComboBox
                        String s = rs.getString("Sexe");
                        if (s.equals("M")) {
                            sexe.setSelectedIndex(0);
                        } else {
                            sexe.setSelectedIndex(1);
                        }

                        JOptionPane.showMessageDialog(null,
                                "Membre trouvé ! Vous pouvez modifier les champs.",
                                "Trouvé", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Aucun membre trouvé avec cet IdMembre.",
                                "Introuvable", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Erreur : " + ex.getMessage(),
                            "Erreur SQL", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ─── BOUTON QUITTER ───────────────────────────────────────
        bQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        buttonPanel.add(bAjouter);
        buttonPanel.add(bModifier);
        buttonPanel.add(bQuitter);

        add(titlePanel,  BorderLayout.NORTH);
        add(formPanel,   BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void viderChamps() {
        id.setText("");
        prenom.setText("");
        nom.setText("");
        adresse.setText("");
        dateN.setText("");
        lieuN.setText("");
        profession.setText("");
        sexe.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new fenetrePrincipale();
    }
}