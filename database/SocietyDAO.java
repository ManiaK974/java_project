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
import java.util.List;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConnexionMySql;
import models.Customer;
import models.Meeting;
import models.Society;

/**
 * DAO d�di�e � la table Society
 *
 * @author Maniak
 */
public class SocietyDAO extends DAO<Society> {
	private ArrayList<Society> societyList;
	private Society society;

	@Override
	public Society find(int id) {
		Society society = null;

		try {
			String sql = "SELECT * FROM society WHERE id_society = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				society = new Society(rs.getString("commercial_name"), rs.getString("phone_number"),
						rs.getString("fax_number"), rs.getString("commercial_phone"), rs.getString("siret_number"),
						rs.getString("ape_code"), rs.getInt("id_address"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (society);
	}
	
	public Society findWithAddress() {
		try {
			String sql = "SELECT commercial_name, address.name, address.postal_code, address.city, phone_number, fax_number"
					+ ", commercial_phone, siret_number, ape_code FROM society INNER JOIN address ON society.id_address = address.id_address"; 
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			while (rs.next()) {
				this.society = new Society(rs.getString("commercial_name"), rs.getString("address.name"), rs.getInt("address.postal_code")
						, rs.getString("address.city"), rs.getString("phone_number"), rs.getString("fax_number")
						, rs.getString("commercial_phone"), rs.getString("siret_number"), rs.getString("ape_code"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return this.society;
	}

	@Override
	public ArrayList<Society> findAll() {
		this.societyList = new ArrayList<Society>();

		try {
			String sql = "SELECT * FROM society";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

			while (rs.next()) {
				this.societyList.add(new Society(rs.getString("commercial_name"), rs.getString("phone_number"),
						rs.getString("fax_number"), rs.getString("commercial_phone"), rs.getString("siret_number"),
						rs.getString("ape_code"), rs.getInt("id_address")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return societyList;
	}

	public boolean isSocietyExist() {
		int i = 0;
		try {
			String sql = "SELECT count(id_society) AS nbSociety FROM society";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (i != 1)
			return false;
		else
			return true;
	}

	/**
	 * Crée un nouvel utilisateur
	 *
	 * @param user
	 *            un objet avec les paramètres de base d'un User
	 * @return le même objet, amélioré de son identifiant d'utilisateur.
	 */
	public Society create(Society society) {
		this.setChanged();
		try {
			String sql = "INSERT INTO society (commercial_name, phone_number, fax_number, commercial_phone, siret_number, ape_code, id_address)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, society.getCommercial_name());
			pst.setString(2, society.getPhone_number());
			pst.setString(3, society.getFax_number());
			pst.setString(4, society.getCommercial_phone());
			pst.setString(5, society.getSiret_number());
			pst.setString(6, society.getApe_code());
			pst.setInt(7, society.getId_address());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(society);
		return society;
	}

	/**
	 * Met à jour un utilisateur
	 *
	 * @param user
	 *            l'utilisateur à mettre à jour
	 * @return l'objet correspondant, mis à jour.
	 */
	@Override
	public Society update(Society society) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE society SET commercial_name=?, phone_number=?, fax_number = ?"
					+ ", commercial_phone = ?, siret_number = ?, ape_code = ?, id_address = ? WHERE commercial_name = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, society.getCommercial_name());
			pst.setString(2, society.getPhone_number());
			pst.setString(3, society.getFax_number());
			pst.setString(4, society.getCommercial_phone());
			pst.setString(5, society.getSiret_number());
			pst.setString(6, society.getApe_code());
			pst.setInt(7, society.getId_address());
			pst.setString(8, society.getCommercial_name());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return society; // Ici l'idée est de retourner la requete Find(p.getId)
	}

	public void delete(Society society) {
		this.setChanged();
		try {
			String sql = "DELETE FROM society WHERE commercial_name = ? AND siret_number = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, society.getCommercial_name());
			pst.setString(2, society.getSiret_number());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		this.notifyObservers();
	}

	private String replaceSpecialCharacters(String str) {
		str = str.toLowerCase().replace("é", "e").replace("è", "e").replace("à", "a").replace("ù", "u")
				.replace("ä", "a").replace("ë", "e").replace("ï", "i").replace("ö", "o").replace("ü", "u")
				.replace("ÿ", "y").replace("ç", "c");

		return str;
	}

}
