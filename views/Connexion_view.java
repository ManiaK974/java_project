/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ConnexionView_controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Recup_path_files;
import models.TextLimiter;
import models.Recup_path_files;

/**
 * GUI de connexion à l'application
 *
 * @author Kévin Mèche
 * @author Yoanns Charpentier
 * @author Jimmy Rossignol
 */
public class Connexion_view extends JFrame implements Observer {

    private JPanel panNorth, panMain, panVide, panSouth, grid;
    private JLabel loginLabel, passwordLabel, titleConnection;
    private JLabel img;
    private JButton connectionButton;
    private JTextField loginTextfield;
    private JPasswordField passwordTextfield;
    @SuppressWarnings("FieldMayBeFinal")
    private ConnexionView_controller controller;

    /**
     * Constructeur de la vue
     *
     * @param controller le controller associé à cette vue
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Connexion_view(ConnexionView_controller controller) {
        this.controller = controller;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(520, 310);
        this.setTitle("Solve-IT");
        this.setLocationRelativeTo(null);
        this.initComposant();
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ManiaK\\Documents\\NetBeansProjects\\SolveIt\\IconeSolveIT.jpg"));
        this.setVisible(true);
    }

    /**
     * Méthode d'initialisation des différents éléments utilisés dans cette vue.
     */
    private void initComposant() {

        // -------------- PANNEAU NORD ----------------- //
        this.panNorth = new JPanel(new BorderLayout());
        this.panNorth.setBackground(Color.WHITE);
        this.panNorth.setPreferredSize(new Dimension(500, 120));

        this.titleConnection = new JLabel("                CONNEXION");
        this.titleConnection.setFont(new java.awt.Font("Bold", 1, 20));

        this.img = new JLabel(new ImageIcon(Recup_path_files.getImgLogo()));

        this.panNorth.add(titleConnection, BorderLayout.CENTER);
        this.panNorth.add(this.img, BorderLayout.WEST);

        // -------------- PANNEAU CENTRAL ----------------- //
        this.grid = new JPanel(new GridLayout(3, 2, 5, 25));
        this.grid.setBackground(Color.WHITE);

        this.panMain = new JPanel();
        this.panMain.setBackground(Color.WHITE);

        this.loginLabel = new JLabel("Entrez votre login : ");
        this.loginLabel.setFont(new java.awt.Font("Bold", 1, 18));

        this.loginTextfield = new JTextField(15);
        this.loginTextfield.setDocument(new TextLimiter(42));

        this.passwordLabel = new JLabel("Entrez votre mot de passe : ");
        this.passwordLabel.setFont(new java.awt.Font("Bold", 1, 18));

        this.passwordTextfield = new JPasswordField(15);
        this.passwordTextfield.addActionListener(this.controller);
        this.passwordTextfield.setDocument(new TextLimiter(42));

        this.connectionButton = new JButton("Je me connecte");
        this.connectionButton.setPreferredSize(new Dimension(160, 35));
        this.connectionButton.setFont(new java.awt.Font("Bold", 1, 16));
        this.connectionButton.addActionListener(this.controller);

        this.panVide = new JPanel();
        this.panVide.setBackground(Color.white);

        // ----------------- PANNEAU SUD ------------------ //
        this.panSouth = new JPanel();
        this.panSouth.setBackground(Color.WHITE);
        this.panSouth.add(this.connectionButton);

        // ------------------ AJOUT AU GRIDPAN -------------- //
        this.grid.add(this.loginLabel);
        this.grid.add(this.loginTextfield);
        this.grid.add(this.passwordLabel);
        this.grid.add(this.passwordTextfield);
        this.grid.add(this.panVide);

        // ----------------- AJOUT AU MAINPAN ---------------- //
        this.panMain.add(this.grid);

        this.getContentPane().add(this.panNorth, BorderLayout.NORTH);
        this.getContentPane().add(this.panMain, BorderLayout.CENTER);
        this.getContentPane().add(this.panSouth, BorderLayout.SOUTH);

    }

    /**
     * Méthode non utilisée
     *
     * @param observable Observable
     * @param arg Object
     */
    @Override
    public void update(Observable observable, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retourne l'instance de JButton correspondant à connectionButton
     *
     * @return l'instance de JButton "connectionButton"
     */
    public JButton getConnectionButton() {
        return this.connectionButton;
    }

    /**
     * Retourne l'instance de JButton correspondant à loginTextfield
     *
     * @return l'instance de JButton "loginTextfield"
     */
    public JTextField getLoginTextfield() {
        return this.loginTextfield;
    }

    /**
     * Retourne l'instance de JPasswordField correspondant à passwordTextfield
     *
     * @return l'instance de JPasswordField "passwordTextfield"
     */
    public JPasswordField getPasswordTextfield() {
        return passwordTextfield;
    }

    /**
     * Méthode appelée en cas d'erreur de saisie du login ou du mot de passe.
     */
    public void erreurLoginPwd() {
        JOptionPane.showMessageDialog(
                null,
                "Le Login ou le Mot de passe est incorrect.",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
    }

}
