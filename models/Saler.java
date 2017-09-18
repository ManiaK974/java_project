package models;

/**
 * @author ManiaK
 *
 */
public class Saler {
	private String commercial_name, founder_firstname, founder_lastname;
	private int id_address;
	
	/**
	 * 
	 * Constructeur total d'une nouvelle instance d'une adresse
	 * 
	 * @param number le numéro de l'adresse
	 * @param street, le nom de la rue de l'adresse
	 * @param postal_code, le code postal de l'adresse
	 * @param number_type, le type de numéro de l'adresse (ex: bis, ter, ...)
	 * @param city, la ville de l'adresse
	 */
	public Saler(String commercial_name, String founder_firstname, String founder_lastname, int id_address) {
		this.commercial_name = commercial_name;
 		this.founder_firstname = founder_firstname;
		this.founder_lastname = founder_lastname;
		this.id_address = id_address;
	}
	
	/**
	 * 
	 * Constructeur vide d'une nouvelle instance d'une adresse
	 * 
	 */
	public Saler(){}

	
    /* ===== GETTERS AND SETTERS ===== */
	/**
	 * @return commercial_name, le nom commercial de l'entreprise partenaire
	 */
	public String getCommercial_name() {
		return commercial_name;
	}

	/**
	 * @return founder_firstname, le prénom du dirigeant de l'entreprise partenaire
	 */
	public String getFounder_firstname() {
		return founder_firstname;
	}

	/**
	 * @return founder_lastname, le nom de famille du dirigeant de l'entreprise partenaire
	 */
	public String getFounder_lastname() {
		return founder_lastname;
	}

	/**
	 * @param commercial_name
	 */
	public void setCommercial_name(String commercial_name) {
		this.commercial_name = commercial_name;
	}

	/**
	 * @param founder_firstname
	 */
	public void setFounder_firstname(String founder_firstname) {
		this.founder_firstname = founder_firstname;
	}

	/**
	 * @param founder_lastname
	 */
	public void setFounder_lastname(String founder_lastname) {
		this.founder_lastname = founder_lastname;
	}

	/**
	 * @return id_address, l'identifiant de l'adresse liée à l'entreprise partenaire
	 */
	public int getId_address() {
		return id_address;
	}

	/**
	 * @param id_address
	 */
	public void setId_address(int id_address) {
		this.id_address = id_address;
	}
}

