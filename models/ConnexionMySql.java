/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Singleton de connexion � la base de donnees MySQL utilisee par l'application.
 * 
 * @author Maniak
 */
public class ConnexionMySql {

    private final String DRIVERPASS = "com.mysql.jdbc.Driver";
    private final String UNKNOW = "unknow";
    private final String ERR_DBHOST = "dbHost inconnu";
    private final String ERR_DBNAME = "dbName inconnu";
    private final String ERR_USER = "user inconnu";
    private final String ERR_PASS = "pass inconnu";
    private final String ERR_FILE_CONF = "Erreur avec confConnect.txt..."
            + " \nFermez Solve IT et relancez l'application";
    private final String ERR_CONNECT = "Impossible de se connecter � la base de donn�es";

    private String dbHost;
    private String dbName;
    private String user;
    private String pass;

    private static boolean check = false;
    private static Connection instance;
    
/**
 * Constructeur de la classe
 */
    private ConnexionMySql() {
        this.check = true;
        readProperties();
        if (check) {
            try {
                Class.forName(DRIVERPASS);
                this.instance = DriverManager.getConnection(
                        "jdbc:mysql://" + this.dbHost + "/" + this.dbName,
                        this.user,
                        this.pass
                );
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                this.check = false;
                JOptionPane.showMessageDialog(null, ERR_CONNECT, "erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, ERR_FILE_CONF, "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Créee une instance de connexion à la base de données.
     * @return une instance de la connexion MySQL
     */
    public static Connection getInstance() {
        if (instance == null) {
            instance = new ConnexionMySql().instance;
        }
        return instance;
    }
    /**
     * Retourne une valeur booléenne de connexion à la base de données.
     * @return un boolén déterminant si la connexion est établie ou non.
     */
    public static boolean isCheck() {
        return check;
    }
    /**
     * Lecture des informations de issues du fichier de configuration.
     */
    private void readProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("confConnect.txt");
            properties.load(in);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            this.check = false;
        }
        if (this.check) {
            this.dbHost = properties.getProperty("dbHost", UNKNOW);
            this.dbName = properties.getProperty("dbName", UNKNOW);
            this.pass = properties.getProperty("pass", UNKNOW);
            this.user = properties.getProperty("user", UNKNOW);
            if (this.dbHost.equals(UNKNOW)) {
                this.check = false;
                JOptionPane.showMessageDialog(null, ERR_DBHOST, "erreur", JOptionPane.ERROR_MESSAGE);
            } else if (this.dbName.equals(UNKNOW)) {
                this.check = false;
                JOptionPane.showMessageDialog(null, ERR_DBNAME, "erreur", JOptionPane.ERROR_MESSAGE);
            } else if (this.user.equals(UNKNOW)) {
                this.check = false;
                JOptionPane.showMessageDialog(null, ERR_USER, "erreur", JOptionPane.ERROR_MESSAGE);
            } else if (this.pass.equals(UNKNOW)) {
                this.check = false;
                JOptionPane.showMessageDialog(null, ERR_PASS, "erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
/**
 * 
 */
    @Override
    public void finalize() {
        try {
            instance.close();
            instance = null;
            check = false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
