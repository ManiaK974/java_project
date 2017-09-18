package models;

public class Customer {
	public String lastname, firstname, mail, phone_number, address_name, address_postal_code, address_city;
	private int id_address;

	/**
	 * @param name
	 * @param lastname
	 */
	public Customer(String name, String firstname, String mail, String phone_number, int id_address) {
		this.lastname = name;
		this.firstname = firstname;
		this.mail = mail;
		this.phone_number = phone_number;
		this.id_address = id_address;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/* ===== GETTERS AND SETTERS ===== */

	public Customer(String name, String firstname, String address_name, String address_postal_code, String address_city
			, String mail, String phone_number, int id_address) {
		this.lastname = name;
		this.firstname = firstname;
		this.mail = mail;
		this.phone_number = phone_number;
		this.id_address = id_address;
		this.address_city = address_city;
		this.address_name = address_name;
		this.address_postal_code = address_postal_code;
	}
	
	/**
	 * @return address_name, le nunméro et nom de la rue du client
	 */
	public String getAddress_name() {
		return address_name;
	}

	/**
	 * @return address_postal_code, le code postal du client
	 */
	public String getAddress_postal_code() {
		return address_postal_code;
	}

	/**
	 * @return address_city, la ville du client
	 */
	public String getAddress_city() {
		return address_city;
	}

	/**
	 * @param address_name
	 */
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	/**
	 * @param address_postal_code
	 */
	public void setAddress_postal_code(String address_postal_code) {
		this.address_postal_code = address_postal_code;
	}

	/**
	 * @param address_city
	 */
	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	/**
	 * @return name, le prenom de la personne
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param name
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @param phone_number
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getId_address() {
		return id_address;
	}

	public void setId_address(int id_address) {
		this.id_address = id_address;
	}
	
}
