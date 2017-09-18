/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import models.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Car;
import models.ConnexionMySql;

/**
 * DAO d�di�e � la table Customer
 *
 * @author Maniak
 */
public class CustomerDAO extends DAO<Customer> {

	private ArrayList<Customer> customersList;
	private AddressDAO addressDao;

	@Override
	public Customer find(int id) {
		Customer customer = null;
		try {
			String sql = "SELECT * FROM customers WHERE id_customer = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getString("lastname"), rs.getString("firstname"), rs.getString("mail"),
						rs.getString("phone_number"), rs.getInt("id_address"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (customer);
	}

	/**
	 * @param name
	 * @return
	 */
	public Customer find(String name) {
		Customer customer = null;
		try {
			String sql = "SELECT * FROM customers WHERE name = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getString("lastname"), rs.getString("firstname"), rs.getString("mail"),
						rs.getString("phone_number"), rs.getInt("id_address"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#findAll()
	 */
	public ArrayList<Customer> findAll() {
		this.customersList = new ArrayList<Customer>();

		try {
			String sql = "SELECT * FROM customers";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			while (rs.next()) {
				this.customersList.add(new Customer(rs.getString("lastname"), rs.getString("firstname"),
						rs.getString("mail"), rs.getString("phone_number"), rs.getInt("id_address")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return customersList;
	}

	public ArrayList<String> findAllPostalCode() {
		ArrayList<String> list = new ArrayList<String>();

		try {
			String sql = "SELECT DISTINCT address.postal_code FROM address INNER JOIN customers ON address.id_address = customers.id_address ORDER BY address.postal_code DESC";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("postal_code"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;
	}

	public ArrayList<Customer> findAllByPostalCode(String postal_code) {
		this.customersList = new ArrayList<Customer>();

		try {
			String sql = "SELECT * FROM customers INNER JOIN address ON customers.id_address = address.id_address WHERE customers.postal_code = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, postal_code);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.customersList.add(new Customer(rs.getString("lastname"), rs.getString("firstname"),
						rs.getString("mail"), rs.getString("phone_number"), rs.getInt("id_address")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return customersList;
	}

	public ArrayList<Customer> findCustomerByNameAndPostalCode(String name, String postal) {
		this.customersList = new ArrayList<Customer>();

		try {
			String sql = "SELECT * FROM customers INNER JOIN address ON customers.id_address = address.id_address WHERE customers.lastname = ? "
					+ "AND address.postal_code = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, postal);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.customersList.add(new Customer(rs.getString("lastname"), rs.getString("firstname"),
						rs.getString("mail"), rs.getString("phone_number"), rs.getInt("id_address")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return customersList;
	}

	public ArrayList<Customer> findCustomerByName(String name) {
		this.customersList = new ArrayList<Customer>();
		this.addressDao = new AddressDAO();
		try {
			String sql = "SELECT * FROM customers WHERE lastname = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.customersList.add(new Customer(rs.getString("lastname"), rs.getString("firstname"),
						rs.getString("mail"), rs.getString("phone_number"), rs.getInt("id_address")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return customersList;
	}

	public ArrayList<Customer>findAllWithAddress() {
		this.customersList = new ArrayList<>();

		try {
			String sql = "SELECT customers.lastname, customers.firstname, address.name, address.postal_code, address.city, "
					+ "customers.phone_number, customers.mail, customers.id_address FROM customers INNER JOIN address "
					+ "ON customers.id_address = address.id_address ORDER BY customers.lastname"; 
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			while (rs.next()) {
				this.customersList.add(new Customer(rs.getString("lastname"), rs.getString("firstname"), rs.getString("address.name")
						, rs.getString("address.postal_code"), rs.getString("address.city"), rs.getString("mail")
						, rs.getString("phone_number"), rs.getInt("id_address")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return customersList;
	}
	
	public ArrayList<Customer>findAllByNameWithAddress(String name) {
		this.customersList = new ArrayList<>();

		try {
			String sql = "SELECT customers.lastname, customers.firstname, address.name, address.postal_code, address.city, "
					+ "customers.phone_number, customers.mail, customers.id_address FROM customers INNER JOIN address "
					+ "ON customers.id_address = address.id_address WHERE customers.lastname = ? ORDER BY customers.lastname"; 
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.customersList.add(new Customer(rs.getString("lastname"), rs.getString("firstname"), rs.getString("address.name")
						, rs.getString("address.postal_code"), rs.getString("address.city"), rs.getString("mail")
						, rs.getString("phone_number"), rs.getInt("id_address")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return customersList;
	}

	public String findNbCustomersByPostalCode(String postal_code) {
		int nbCustomers = 0;
		try {
			String sql = "SELECT count(id_customers) AS nbCustomers FROM customers "
					+ "WHERE customers.postal_code  = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, postal_code);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCustomers = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCustomers));
	}

	public String findNbCustomersByName(String name) {
		int nbCustomers = 0;
		try {
			String sql = "SELECT count(id_customers) AS nbCustomers FROM customers WHERE customers.lastname = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCustomers = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCustomers));
	}

	public String findNbCustomersByNameAndPostalCode(String name, String postal_code) {
		int nbCustomers = 0;
		try {
			String sql = "SELECT count(id_customers) AS nbCustomers FROM customers INNER JOIN address ON customers.id_address = address.id_address"
					+ " WHERE customers.lastname = ? AND address.postal_code = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, postal_code);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCustomers = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCustomers));
	}

	public String findNbCustomers() {
		int nbCustomers = 0;
		try {
			String sql = "SELECT count(id_customers) AS nbCustomers FROM customers";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCustomers = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCustomers));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#create(java.lang.Object)
	 */
	public Customer create(Customer customer) {
		this.setChanged();
		try {
			String sql = "INSERT INTO customers (lastname, firstname, mail, phone_number, id_address) VALUES (?, ?, ?, ?, ?) ";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, customer.getLastname());
			pst.setString(2, customer.getFirstname());
			pst.setString(3, customer.getMail());
			pst.setString(4, customer.getPhone_number());
			pst.setInt(5, customer.getId_address());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(customer);
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#update(java.lang.Object)
	 */
	public Customer update(Customer customer) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE customers SET lastname=?, firstname = ?, mail = ?, phone_number = ? WHERE lastname = ? AND firstname = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, customer.getLastname());
			pst.setString(2, customer.getFirstname());
			pst.setString(3, customer.getMail());
			pst.setString(4, customer.getPhone_number());
			pst.setString(5, customer.getLastname());
			pst.setString(6, customer.getFirstname());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return customer; // Ici l'idée est de retourner la requete
							// Find(p.getId)
	}

	/**
	 * Supprime un client de la BDD
	 *
	 * @param customer,
	 *            le client � supprimer
	 * 
	 */
	public void delete(Customer customer) {
		this.setChanged();
		try {
			String sql = "DELETE FROM customers WHERE lastname = ? AND mail = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, customer.getLastname());
			pst.setString(2, customer.getMail());
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

	public ArrayList<Customer> findAllByName(String name) {
		this.customersList = new ArrayList<Customer>();

		try {
			String sql = "SELECT * FROM customers WHERE lastname = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.customersList.add(new Customer(rs.getString("lastname"), rs.getString("firstname"),
						rs.getString("mail"), rs.getString("phone_number"), rs.getInt("id_address")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return customersList;
	}

}
