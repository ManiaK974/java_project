package models;

public class Admin {
	private String login, password;
	
	/**
	 * 
	 * Constructeur total d'une nouvelle instance d'un administrateur
	 * 
	 * @param login, le login de connexion de l'admin
	 * @param password, le mot de passe de connexion de l'admin
	 */
	public Admin(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	/* ===== GETTERS AND SETTERS ===== */

	/**
	 * @return login, le login de connexion de l'admin
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return password, le mot de passe de connexion de l'admin
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
