package models;

public class Car {
	private String brand, model, finition, immat, mec;
	private Integer buy_price, sale_price, frevo, kms, id_customer, id_saler, isStock;
	
	/**
	 * 
	 * Constructeur total d'une nouvelle instance d'une voiture
	 * 
	 * @param id_car, l'identifiant de la voiture
	 * @param brand, la marque de la voiture
	 * @param model, le modèle de la voiture
	 * @param finition, la finition de la voiture
	 * @param kms, le nombre de kilomètres de la voiture
	 * @param buy_price, le prix d'achat de la voiture
	 * @param sale_price, le prix de revente de la voiture
	 * @param mec, la date de première immatriculation
	 */
	public Car(String immat, String brand, String model, String finition, String mec, int kms, int buy_price,
			int sale_price,int frevo, int id_customer, int id_saler, int isSotck) {
		this.immat = immat;
		this.brand = brand;
		this.model = model;
		this.finition = finition;
		this.frevo = frevo;
		this.kms = kms;
		this.buy_price = buy_price;
		this.sale_price = sale_price;
		this.mec = mec;
		this.id_customer = 0;
		this.id_saler = 0;
		this.isStock = 1;
	}
	
	/**
	 * 
	 * Constructeur vide d'une nouvelle instance d'une voiture
	 * 
	 */
	public Car(){}
	
    /* ===== GETTERS AND SETTERS ===== */

	
	
	/**
	 * @return brand, la marque de la voiture
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @return frevo, la valeur des frais de remise en état effectués
	 */
	public Integer getFrevo() {
		return frevo;
	}

	/**
	 * @param frevo
	 */
	public void setFrevo(Integer frevo) {
		this.frevo = frevo;
	}

	/**
	 * @param kms
	 */
	public void setKms(Integer kms) {
		this.kms = kms;
	}

	/**
	 * @return immat, l'immatriculation de la voiture
	 */
	public String getImmat() {
		return immat;
	}

	/**
	 * @param immat
	 */
	public void setImmat(String immat) {
		this.immat = immat; 
	}

	/**
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return model, le modèle de la voiture
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return finition, la finition de la voiture
	 */
	public String getFinition() {
		return finition;
	}

	/**
	 * @param finition
	 */
	public void setFinition(String finition) {
		this.finition = finition;
	}

	/**
	 * @return kms, le nombre de kilomètre de la voiture
	 */
	public int getKms() {
		return kms;
	}

	/**
	 * @param string
	 */
	public void setKms(int kms) {
		this.kms = kms;
	}

	/**
	 * @return buy_price, le prix d'achat de la voiture
	 */
	public Integer getBuy_price() {
		return buy_price;
	}

	/**
	 * @param buy_price
	 */
	public void setBuy_price(Integer buy_price) {
		this.buy_price = buy_price;
	}

	/**
	 * @return sale_price, le prix de vente de la voiture
	 */
	public Integer getSale_price() {
		return sale_price;
	}

	/**
	 * @param sale_price
	 */
	public void setSale_price(Integer sale_price) {
		this.sale_price = sale_price;
	}

	/**
	 * @return mec, la date de première immatriculation
	 */
	public String getMec() {
		return mec;
	}

	/**
	 * @param mec
	 */
	public void setMec(String mec) {
		this.mec = mec;
	}
}
