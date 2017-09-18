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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConnexionMySql;
import models.Sector;

/**
 * DAO dédiée à la table User
 *
 * @author Kévin Mèche, Yoanns Charpentier, Jimmy Rossignol
 */
public class SectorDAO extends DAO<Sector> {

	private List<Sector> sectorList;
	
	
	/**
	 * Recherche un secteur en fonction de son identifiant
	 *
	 * @param id, l'identifiant du secteur � rechercher
	 *            
	 * @return un objet Sector correspondant � l'identifiant du secteur
	 */
	@Override
	public Sector find(int id) {
		Sector sector = null;
		try {
			String sql = "SELECT * FROM sector WHERE id_sector = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				sector = new Sector(rs.getString("name"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (sector);
	}

	/**
	 * Recherche un secteur en fonction de son nom
	 *
	 * @param name, le nom du secteur � rechercher
	 *           
	 * @return un objet Sector correspondant au nom
	 */
	public Sector findByName(String name) {
		Sector sector = null;
		try {
			String sql = "SELECT * FROM sector WHERE name = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				sector = new Sector(rs.getString("name"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (sector);
	}

	/**
	 * Recherche la liste des secteurs
	 *
	 * @return une List de Sector
	 */
	public List<Sector> findAll() {
		this.sectorList = new ArrayList();

		try {
			String sql = "SELECT * FROM sector";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

			while (rs.next()) {
				this.sectorList.add(new Sector(rs.getString("name")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return sectorList;
	}
	
	public ArrayList<String> findAllSectors() {
		ArrayList<String> list = new ArrayList<String>();

		try {
			String sql = "SELECT DISTINCT sector.name FROM sector ORDER BY sector.name";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("name"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;
	}

	public Sector create(Sector sector) {
		this.setChanged();
		try {
			String sql = "INSERT INTO sector (name) VALUES (?) ";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, sector.getName());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(sector);
		return sector;
	}

	@Override
	public Sector update(Sector sector) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE sector SET name = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, sector.getName());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return sector; // Ici l'idée est de retourner la requete Find(p.getId)
	}

	public void delete(Sector sector) {
		this.setChanged();
		try {
			String sql = "DELETE FROM sector WHERE name = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, sector.getName());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		this.notifyObservers();
	}
}
