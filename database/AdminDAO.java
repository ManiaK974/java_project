/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import models.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConnexionMySql;

/**
 * DAO dédiée à la table User
 *
 * @author Kévin Mèche, Yoanns Charpentier, Jimmy Rossignol
 */
public class AdminDAO extends DAO<Admin> {

    private List<Admin> userList;

    /**
     * Recherche un utilisateur en fonction de son identifiant
     *
     * @param id_user l'identifiant de l'utilisateur à rechercher
     * @return un objet User correspondant à l'id_user
     */
    public Admin find(String admin_login) {
        Admin admin = null;

        try {
            String sql = "SELECT * FROM admin WHERE admin_login=?";
            PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
            pst.setString(1, admin_login);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                admin = new Admin(rs.getString("admin_login"),
                        rs.getString("admin_password")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (admin);
    }

    /**
     * Recherche une liste d'utilisateur
     *
     * @return une List de User
     */
    public List<Admin> findAll() {
        this.userList = new ArrayList();

        try {
            String sql = "SELECT * FROM admin";
            ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

            while (rs.next()) {
                this.userList.add(new Admin(
                        rs.getString("login"),
                        rs.getString("password")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return userList;
    }


    /**
     * Crée un nouvel utilisateur
     *
     * @param user un objet avec les paramètres de base d'un User
     * @return le même objet, amélioré de son identifiant d'utilisateur.
     */
    public Admin create(Admin admin) {
        this.setChanged();
        try {
            String sql = "INSERT INTO admin (admin_login, admin_password) VALUES (?, ?) ";
            PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, admin.getLogin());
            pst.setString(2, admin.getPassword());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        this.notifyObservers(admin);
        return admin;
    }

    /**
     * Met à jour un utilisateur
     *
     * @param user l'utilisateur à mettre à jour
     * @return l'objet correspondant, mis à jour.
     */
    @Override
    public Admin update(Admin admin) {
//        this.setChanged(); // voir le commentaire suivant
        try {
            String sql = "UPDATE admin SET admin_login=?, admin_password=? WHERE admin_login=?";
            PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
            pst.setString(1, admin.getLogin());
            pst.setString(2, admin.getPassword());
            pst.setString(3, admin.getLogin());
            pst.executeUpdate();
        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
//        this.notifyObservers(p); // Ici pas d'interet parce qu'on change directement le tableau....
        return admin; // Ici l'idée est de retourner la requete Find(p.getId)
    }

    public void delete(Admin admin) {
        this.setChanged();
        try {
            String sql = "DELETE FROM admin WHERE admin_login = ?";
            PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
            pst.setString(1, admin.getLogin());
            pst.executeUpdate();

        } catch (SQLException ex) {
            this.notifyObservers(ex);
            ex.printStackTrace();
        }
        this.notifyObservers();
    }

    /**
     * Recherche si un utilisateur est AdminTech
     *
     * @param id_user l'utilisateur à rechercher
     * @return un valeur booléenne (true/false).
     */
    public Boolean isAdmin(String login) {
        String sql = "SELECT * FROM admin WHERE admin_login=?";
        try {
            PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private String replaceSpecialCharacters(String str) {
        str = str.toLowerCase()
                .replace("é", "e")
                .replace("è", "e")
                .replace("à", "a")
                .replace("ù", "u")
                .replace("ä", "a")
                .replace("ë", "e")
                .replace("ï", "i")
                .replace("ö", "o")
                .replace("ü", "u")
                .replace("ÿ", "y")
                .replace("ç", "c");

        return str;
    }

	@Override
	public Admin find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
