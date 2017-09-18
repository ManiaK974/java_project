package models;

import java.sql.Date;

/**
 * @author ManiaK
 *
 */
public class Order {
	private Date created_date;
	private int id_customer, id_car;
	
	public Order(Date created_date, int id_customer, int id_car) {
		this.created_date = created_date;
		this.id_car = id_car;
		this.id_customer = id_customer;
		
	}
	
	/**
	 * 
	 * Constructeur vide d'une nouvelle instance d'une adresse
	 * 
	 */
	public Order(){}

	
	//* ===== GETTERS AND SETTERS ===== *//
	public Date getCreated_date() {
		return created_date;
	}

	public int getId_customer() {
		return id_customer;
	}

	public int getId_car() {
		return id_car;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

	public void setId_car(int id_car) {
		this.id_car = id_car;
	}
}

