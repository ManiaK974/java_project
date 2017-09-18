/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConnexionMySql;
import models.Saler;

/**
 * DAO dédiée à la table User
 *
 * @author Kévin Mèche, Yoanns Charpentier, Jimmy Rossignol
 */
public class SalerDAO extends DAO<Saler> {
	private ArrayList<Saler> salerList;

	@Override
	public Saler find(int id) {
		Saler saler = null;

		try {
			String sql = "SELECT * FROM saler WHERE id_saler=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				saler = new Saler(rs.getString("commercial_name"), rs.getString("founder_firstname"),
						rs.getString("founder_lastname"), rs.getInt("id_address"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (saler);
	}
	
	public Saler find(String admin_login) {
		Saler saler = null;

		try {
			String sql = "SELECT * FROM saler WHERE commercial_name=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, admin_login);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				saler = new Saler(rs.getString("commercial_name"), rs.getString("founder_firstname"),
						rs.getString("founder_lastname"), rs.getInt("id_address"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (saler);
	}

	/**
	 * Recherche une liste d'utilisateur
	 *
	 * @return une List de User
	 */
	public ArrayList<Saler> findAll() {
		this.salerList = new ArrayList<Saler>();

		try {
			String sql = "SELECT * FROM saler";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

			while (rs.next()) {
				this.salerList.add(new Saler(rs.getString("commercial_name"), rs.getString("founder_firstname"),
						rs.getString("founder_lastname"), rs.getInt("id_address")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return salerList;
	}

	/**
	 * Crée un nouvel utilisateur
	 *
	 * @param user
	 *            un objet avec les paramètres de base d'un User
	 * @return le même objet, amélioré de son identifiant d'utilisateur.
	 */
	public Saler create(Saler saler) {
		this.setChanged();
		try {
			String sql = "INSERT INTO saler (commercial_name, founder_firstname, founder_lastname, id_address) VALUES (?, ?, ?, ?) ";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, saler.getCommercial_name());
			pst.setString(2, saler.getFounder_firstname());
			pst.setString(3, saler.getFounder_lastname());
			pst.setInt(4, saler.getId_address());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(saler);
		return saler;
	}

	/**
	 * Met à jour un utilisateur
	 *
	 * @param user
	 *            l'utilisateur à mettre à jour
	 * @return l'objet correspondant, mis à jour.
	 */
	@Override
	public Saler update(Saler saler) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE saler SET commercial_name=?, founder_firstname=?, founder_lastname = ?, id_address = ? WHERE commercial_name=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, saler.getCommercial_name());
			pst.setString(2, saler.getFounder_firstname());
			pst.setString(3, saler.getFounder_lastname());
			pst.setInt(4, saler.getId_address());
			pst.setString(5, saler.getCommercial_name());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return saler; // Ici l'idée est de retourner la requete Find(p.getId)
	}

	public void delete(Saler saler) {
		this.setChanged();
		try {
			String sql = "DELETE FROM saler WHERE commercial_name = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, saler.getCommercial_name());
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
	 * @param id_user
	 *            l'utilisateur à rechercher
	 * @return un valeur booléenne (true/false).
	 */
	public Boolean isSaler(String commercial_name) {
		String sql = "SELECT * FROM saler WHERE commercial_name=?";
		try {
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, commercial_name);
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
		str = str.toLowerCase().replace("é", "e").replace("è", "e").replace("à", "a").replace("ù", "u")
				.replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o").replace("ü", "u")
				.replace("ÿ", "y").replace("ç", "c");

		return str;
	}
}
