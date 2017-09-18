package models;

import java.math.BigInteger;

public class Society {
	private String commercial_name, address_name, address_city, phone_number, fax_number, ape_code, siret_number,
			commercial_phone;
	private int address_postal_code, id_address;

	public Society(String commercial_name, String phone_number, String fax_number, String commercial_phone, String siret_number,
			String ape_code, int id_address) {
		this.commercial_name = commercial_name;
		this.siret_number = siret_number;
		this.ape_code = ape_code;
		this.phone_number = phone_number;
		this.fax_number = fax_number;
		this.id_address = id_address;
		this.commercial_phone = commercial_phone;
	}

	public Society(String commercial_name, String address_name, int address_postal_code,
			String address_city, String phone_number, String fax_number, String commercial_phone, String siret_number,
			String ape_code) {
		this.commercial_name = commercial_name;
		this.commercial_phone = commercial_phone;
		this.siret_number = siret_number;
		this.ape_code = ape_code;
		this.address_city = address_city;
		this.address_name = address_name;
		this.phone_number = phone_number;
		this.fax_number = fax_number;
		this.address_postal_code = address_postal_code;
	}

	public Society(String commercial_name, String address_name, int address_postal_code, String address_city,
			String phone_number, String fax_number, String siret_number, String ape_code) {
		this.commercial_name = commercial_name;
		this.siret_number = siret_number;
		this.ape_code = ape_code;
		this.address_city = address_city;
		this.address_name = address_name;
		this.phone_number = phone_number;
		this.fax_number = fax_number;
		this.address_postal_code = address_postal_code;
	}

	public String getCommercial_name() {
		return commercial_name;
	}

	public String getAddress_name() {
		return address_name;
	}

	public String getAddress_city() {
		return address_city;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getCommercial_phone() {
		return commercial_phone;
	}

	public int getId_address() {
		return id_address;
	}

	public void setCommercial_phone(String commercial_phone) {
		this.commercial_phone = commercial_phone;
	}

	public void setId_address(int id_address) {
		this.id_address = id_address;
	}

	public String getFax_number() {
		return fax_number;
	}

	public int getAddress_postal_code() {
		return address_postal_code;
	}

	public String getSiret_number() {
		return siret_number;
	}

	public String getApe_code() {
		return ape_code;
	}

	public void setCommercial_name(String commercial_name) {
		this.commercial_name = commercial_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setFax_number(String fax_number) {
		this.fax_number = fax_number;
	}

	public void setAddress_postal_code(int address_postal_code) {
		this.address_postal_code = address_postal_code;
	}

	public void setSiret_number(String siret_number) {
		this.siret_number = siret_number;
	}

	public void setApe_code(String ape_code) {
		this.ape_code = ape_code;
	}

	@Override
	public String toString() {
		return this.commercial_name + "\n" + this.address_name + "\n"
				+ this.address_postal_code + " " + this.address_city + "\nTél : " + this.phone_number + "  Fax : "
				+ this.fax_number + "\nPortable commercial : " + this.commercial_phone + "\nSiret : "
				+ this.siret_number + " - APE " + this.ape_code;
	}

}
