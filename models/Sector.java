package models;

public class Sector {
	private String name;
	
	/**
	 * 
	 * Constructeur total d'une nouvelle instance d'un secteur
	 * 
	 * @param name, le nom du secteur
	 */
	public Sector(String name){
		this.name = name;
	}
	
	/**
	 * 
	 * Constructeur vide d'une nouvelle instance d'un secteur
	 * 
	 */
	public Sector(){}

    /* ===== GETTERS AND SETTERS ===== */
	
	/**
	 * @return name, le nom du secteur
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
