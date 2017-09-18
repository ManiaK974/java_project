package models;

/**
 * @author ManiaK
 *
 */
public class Address {
	private Integer postal_code, id_sector;
	private String street, city;
	
	public Address(String street, Integer postal_code, String city, int id_sector) {
		this.street = street;
		this.postal_code = postal_code;
		this.city = city;
		this.id_sector = 0;
	}
	
	/**
	 * 
	 * Constructeur vide d'une nouvelle instance d'une adresse
	 * 
	 */
	public Address(){}
	
    /* ===== GETTERS AND SETTERS ===== */

	/**
	 * @return postal_code, le code postal de l'adresse
	 */
	public Integer getPostal_code() {
		return postal_code;
	}

	/**
	 * @param postal_code
	 */
	public void setPostal_code(Integer postal_code) {
		this.postal_code = postal_code;
	}

	/**
	 * @return street, le nom de la rue de l'adresse
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return city, la ville de l'adresse
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public Integer getId_sector() {
		return id_sector;
	}

	public void setId_sector(Integer id_sector) {
		this.id_sector = id_sector;
	}
	
}

