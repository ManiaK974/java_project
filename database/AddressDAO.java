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

import models.Address;
import models.ConnexionMySql;
import models.Saler;

/**
 * DAO dédiée à la table User
 *
 * @author Kévin Mèche, Yoanns Charpentier, Jimmy Rossignol
 */
public class AddressDAO extends DAO<Address> {
	private ArrayList<Address> addressList;

	@Override
	public Address find(int id) {
		Address address = null;

		try {
			String sql = "SELECT * FROM address WHERE id_address=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				address = new Address(rs.getString("name"), rs.getInt("postal_code"),
						rs.getString("city"), rs.getInt("id_sector"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (address);
	}
	
	public int findIdAddress(Address address) {
		int id = 0;
		try {
			String sql = "SELECT address.id_address FROM address WHERE name=? AND postal_code = ? AND city = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setInt(2, address.getPostal_code());
			pst.setString(3, address.getCity());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id_address");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (id);
	}
	
	public Address findBySector(int id_sector) {
		Address address = null;

		try {
			String sql = "SELECT * FROM address WHERE id_sector=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id_sector);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				address = new Address(rs.getString("name"), rs.getInt("postal_code"),
						rs.getString("city"), rs.getInt("id_sector"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (address);
	}

	/**
	 * Recherche une liste d'utilisateur
	 *
	 * @return une List de User
	 */
	public ArrayList<Address> findAll() {
		this.addressList = new ArrayList<Address>();

		try {
			String sql = "SELECT * FROM saler";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

			while (rs.next()) {
				this.addressList.add(new Address(rs.getString("name"), rs.getInt("postal_code"),
						rs.getString("city"), rs.getInt("id_sector")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return addressList;
	}

	/**
	 * Crée un nouvel utilisateur
	 *
	 * @param user
	 *            un objet avec les paramètres de base d'un User
	 * @return le même objet, amélioré de son identifiant d'utilisateur.
	 */
	public Address create(Address address) {
		this.setChanged();
		try {
			String sql = "INSERT INTO address (name, postal_code, city, id_sector) VALUES (?, ?, ?, ?)";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, address.getStreet());
			pst.setInt(2, address.getPostal_code());
			pst.setString(3, address.getCity());
			pst.setInt(4, address.getId_sector());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(address);
		return address;
	}

	/**
	 * Met à jour un utilisateur
	 *
	 * @param user
	 *            l'utilisateur à mettre à jour
	 * @return l'objet correspondant, mis à jour.
	 */
	@Override
	public Address update(Address address) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE address SET name=?, postal_code=?, city = ?, id_sector = ? WHERE name=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setInt(2, address.getPostal_code());
			pst.setString(3, address.getCity());
			pst.setInt(4, address.getId_sector());
			pst.setString(5, address.getStreet());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return address; // Ici l'idée est de retourner la requete Find(p.getId)
	}

	public void delete(Address address) {
		this.setChanged();
		try {
			String sql = "DELETE FROM address WHERE name = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, address.getStreet());
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

	public int findIdAddress(String name, int code, String city) {
		int id = 0;
		try {
			String sql = "SELECT address.id_address FROM address WHERE name = ? AND postal_code = ? AND city = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, code);
			pst.setString(3, city);
			ResultSet rs = pst.executeQuery();
			rs.next();
			id = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (id);
	}
}
