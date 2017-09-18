package models;

import java.sql.Date;

/**
 * @author ManiaK
 *
 */
public class Meeting {
	private Date created_date;
	private int id_customer;
	
	public Meeting(Date created_date, int id_customer) {
		this.created_date = created_date;
		this.id_customer = id_customer;
		
	}
	
	/**
	 * 
	 * Constructeur vide d'une nouvelle instance d'une adresse
	 * 
	 */
	public Meeting(){}

	//* ===== GETTERS AND SETTERS ===== *//
	public Date getCreated_date() {
		return created_date;
	}

	public int getId_customer() {
		return id_customer;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
}

