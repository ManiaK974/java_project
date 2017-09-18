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
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConnexionMySql;
import models.Meeting;

/**
 * DAO dédiée à la table User
 *
 * @author Kévin Mèche, Yoanns Charpentier, Jimmy Rossignol
 */
public class MeetingDAO extends DAO<Meeting> {
	private ArrayList<Meeting> meetingList;

	@Override
	public Meeting find(int id) {
		Meeting meeting = null;

		try {
			String sql = "SELECT * FROM meeting WHERE id_meeting=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				meeting = new Meeting(rs.getDate("created_date"), rs.getInt("id_customer"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (meeting);
	}
	
	public Meeting findByDate(Date date) {
		Meeting meeting = null;

		try {
			String sql = "SELECT * FROM meeting WHERE date=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setDate(1, date);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				meeting = new Meeting(rs.getDate("created_date"), rs.getInt("id_customer"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (meeting);
	}

	/**
	 * Recherche une liste d'utilisateur
	 *
	 * @return une List de User
	 */
	public ArrayList<Meeting> findAll() {
		this.meetingList = new ArrayList<Meeting>();

		try {
			String sql = "SELECT * FROM meeting";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

			while (rs.next()) {
				this.meetingList.add(new Meeting(rs.getDate("date"), rs.getInt("id_customer")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return meetingList;
	}

	/**
	 * Crée un nouvel utilisateur
	 *
	 * @param user
	 *            un objet avec les paramètres de base d'un User
	 * @return le même objet, amélioré de son identifiant d'utilisateur.
	 */
	public Meeting create(Meeting meeting) {
		this.setChanged();
		try {
			String sql = "INSERT INTO meeting (date, id_customer) VALUES (?, ?)";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setDate(1, meeting.getCreated_date());
			pst.setInt(2, meeting.getId_customer());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(meeting);
		return meeting;
	}

	/**
	 * Met à jour un utilisateur
	 *
	 * @param user
	 *            l'utilisateur à mettre à jour
	 * @return l'objet correspondant, mis à jour.
	 */
	@Override
	public Meeting update(Meeting meeting) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE meeting SET id_customer=? WHERE date = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, meeting.getId_customer());
			pst.setDate(3, meeting.getCreated_date());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return meeting; // Ici l'idée est de retourner la requete Find(p.getId)
	}

	public void delete(Meeting meeting) {
		this.setChanged();
		try {
			String sql = "DELETE FROM meeting WHERE date = ? AND id_customer = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setDate(1, meeting.getCreated_date());
			pst.setInt(2, meeting.getId_customer());
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
