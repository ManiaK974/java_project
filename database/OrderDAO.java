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
import models.Order;

/**
 * DAO dédiée à la table User
 *
 * @author Kévin Mèche, Yoanns Charpentier, Jimmy Rossignol
 */
public class OrderDAO extends DAO<Order> {
	private ArrayList<Order> addressList;
	private ArrayList<Order> orderList;

	@Override
	public Order find(int id) {
		Order order = null;

		try {
			String sql = "SELECT * FROM order WHERE id_order=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				order = new Order(rs.getDate("created_date"), rs.getInt("id_customer"), rs.getInt("id_car"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (order);
	}
	
	public Order findByDate(Date date) {
		Order order = null;

		try {
			String sql = "SELECT * FROM order WHERE created_date=?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setDate(1, date);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				order = new Order(rs.getDate("created_date"), rs.getInt("id_customer"), rs.getInt("id_car"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (order);
	}

	/**
	 * Recherche une liste d'utilisateur
	 *
	 * @return une List de User
	 */
	public ArrayList<Order> findAll() {
		this.orderList = new ArrayList<Order>();

		try {
			String sql = "SELECT * FROM order";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

			while (rs.next()) {
				this.orderList.add(new Order(rs.getDate("created_date"), rs.getInt("id_customer"), rs.getInt("id_car")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return orderList;
	}

	/**
	 * Crée un nouvel utilisateur
	 *
	 * @param user
	 *            un objet avec les paramètres de base d'un User
	 * @return le même objet, amélioré de son identifiant d'utilisateur.
	 */
	public Order create(Order order) {
		this.setChanged();
		try {
			String sql = "INSERT INTO order (created_date, id_customer, id_car) VALUES (?, ?, ?)";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setDate(1, order.getCreated_date());
			pst.setInt(2, order.getId_customer());
			pst.setInt(3, order.getId_car());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(order);
		return order;
	}

	/**
	 * Met à jour un utilisateur
	 *
	 * @param user
	 *            l'utilisateur à mettre à jour
	 * @return l'objet correspondant, mis à jour.
	 */
	@Override
	public Order update(Order order) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE order SET id_customer=?, id_car=? WHERE created_date = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, order.getId_customer());
			pst.setInt(2, order.getId_car());
			pst.setDate(3, order.getCreated_date());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return order; // Ici l'idée est de retourner la requete Find(p.getId)
	}

	public void delete(Order order) {
		this.setChanged();
		try {
			String sql = "DELETE FROM order WHERE created_date = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setDate(1, order.getCreated_date());
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
