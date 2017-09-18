/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import models.Car;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConnexionMySql;

/**
 * DAO d�di�e � la table Car
 * 
 * @author Maniak
 */
public class CarDAO extends DAO<Car> {
	private ArrayList<Car> carsList;

	public String findNbVsp() {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByBrand(String brand) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE brand = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByBrandAndKms(String brand, int kms) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE brand = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setInt(2, kms);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByMec(String mec) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE mec = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, mec);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByMecAndKms(String mec, int kms) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE mec = ? AND KMS <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, mec);
			pst.setInt(2, kms);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByKms(int kms) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, kms);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByFinition(String finition) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE finition = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, finition);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByFinitionAndKms(String finition, int kms) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE finition = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, finition);
			pst.setInt(2, kms);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByMecAndFinition(String mec, String finition) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE mec = ? AND finition = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, mec);
			pst.setString(2, finition);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByBrandAndMec(String brand, String mec) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE brand = ? AND mec = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByBrandAndMecAndKms(String brand, String mec, int kms) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE brand = ? AND mec = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			pst.setInt(3, kms);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByBrandAndMecAndFinition(String brand, String mec, String finition) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE brand = ? AND mec = ? AND finition = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			pst.setString(3, finition);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	public String findNbVspByBrandAndMecAndFinitionAndKms(String brand, String mec, String finition, int kms) {
		int nbCars = 0;
		try {
			String sql = "SELECT count(id_car) FROM car WHERE brand = ? AND mec = ? AND finition = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			pst.setString(3, finition);
			pst.setInt(4, kms);
			ResultSet rs = pst.executeQuery();
			rs.next();
			nbCars = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (Integer.toString(nbCars));
	}

	@Override
	public Car find(int id) {
		Car car = null;
		try {
			String sql = "SELECT * FROM car WHERE id_car = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				car = new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (car);
	}

	/**
	 * @param immat,
	 *            l'immatriculation du v�hicule recherch�
	 * @return le v�hicule recherch� par son immatriculation
	 */
	public Car findByImmat(String immat) {
		Car car = null;
		try {
			String sql = "SELECT * FROM car WHERE immat = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, immat);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				car = new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (car);
	}

	/**
	 * @param id,
	 *            l'id du v�hicule recherch�
	 * @return le v�hicule recherch� par son identifiant
	 */
	public Car findById(int id) {
		Car car = null;
		try {
			String sql = "SELECT * FROM car WHERE id_car = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				car = new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (car);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#findAll()
	 */
	public ArrayList<Car> findAll() {
		this.carsList = new ArrayList<Car>();
		this.setChanged();
		try {
			String sql = "SELECT * FROM car ORDER BY car.brand";
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);

			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		this.notifyObservers(carsList);
		return carsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#findAll()
	 */
	public ArrayList<Car> findAllByBrand(String brand) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE brand = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param brand,
	 *            la marque du v�hicule
	 * @param kms,
	 *            le kilom�trage maximum du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'une marque et d'une
	 *         kilom�trage maximum
	 */
	public ArrayList<Car> findAllByBrandAndKms(String brand, int kms) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE brand = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setInt(2, kms);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param brand,
	 *            la marque du v�hicule
	 * @param mec,
	 *            la mise en circulation du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'une marque et de
	 *         l'ann�e de la mise en circulation
	 */
	public ArrayList<Car> findAllByBrandAndMec(String brand, String mec) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE brand = ? AND mec = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param brand,
	 *            la marque du v�hicule
	 * @param mec,
	 *            la mise en circulation du v�hicule
	 * @param kms,
	 *            le kilom�trage maximum du v�hicule
	 * @return la liste des v�hicules en stock selon une marque, une date de
	 *         mise en circulation et un kilom�trage maximum
	 */
	public ArrayList<Car> findAllByBrandAndMecAndKms(String brand, String mec, int kms) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE brand = ? AND mec = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			pst.setInt(3, kms);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param brand,
	 *            la marque du v�hicule
	 * @param mec,
	 *            la mise en circulation du v�hicule
	 * @param finition,
	 *            la finition du v�hicule
	 * @return la liste de tous les v�hicules en stock en fonction d'une marque,
	 *         d'une finition et d'une mise en circulation
	 */
	public ArrayList<Car> findAllByBrandAndMecAndFinition(String brand, String mec, String finition) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE brand = ? AND mec = ? AND finition = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			pst.setString(3, finition);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param brand,
	 *            la marque du v�hicule
	 * @param mec,
	 *            l'ann�e de mise en circulation du v�hicule
	 * @param finition,
	 *            la finition du v�hicule
	 * @param kms,
	 *            le kilom�trage maximum du v�hicule
	 * @return la liste des v�hicules en stock en fonction d"une marque, d'une
	 *         ann�e de mise en circulation, d'une finition et d'un kilom�trage
	 *         maximum
	 */
	public ArrayList<Car> findAllByBrandAndMecAndFinitionAndKms(String brand, String mec, String finition, int kms) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE brand = ? AND mec = ? AND finition = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, brand);
			pst.setString(2, mec);
			pst.setString(3, finition);
			pst.setInt(4, kms);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param finition,
	 *            la finition du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'une finition
	 */
	public ArrayList<Car> findAllByFinition(String finition) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE finition = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, finition);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param finition,
	 *            la finition du v�hicule
	 * @param kms,
	 *            le kilom�trage maimum du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'une finition et
	 *         d'un kilom�trage maximum
	 */
	public ArrayList<Car> findAllByFinitionAndKms(String finition, int kms) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE finition = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, finition);
			pst.setInt(2, kms);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param mec,
	 *            l'ann�e de mise en circulation du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'une ann�e de mise
	 *         en circulation
	 */
	public ArrayList<Car> findAllByMec(String mec) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE mec = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, mec);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param mec,
	 *            l'ann�e de mise en circulation d'un v�hicule
	 * @param kms,
	 *            le kilom�trage maximum du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'une ann�e de mise
	 *         en circulation et d'un kilom�trage maximum
	 */
	public ArrayList<Car> findAllByMecAndKms(String mec, int kms) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE mec = ? AND kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, mec);
			pst.setInt(2, kms);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param mec,
	 *            l'ann�e de mise en circulation du v�hicule
	 * @param finition,
	 *            la finition du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'une ann�e de mise
	 *         en circulation et d'une finition
	 */
	public ArrayList<Car> findAllByMecAndFinition(String mec, String finition) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE mec = ? AND finition = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, mec);
			pst.setString(2, finition);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/**
	 * @param kms,
	 *            le kilom�trage maximum du v�hicule
	 * @return la liste des v�hicules en stock en fonction d'un kilom�trage
	 *         maximum
	 */
	public ArrayList<Car> findAllByKms(int kms) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE kms <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, kms);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#findAll()
	 */
	public List<Car> findAllByModel(String model) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE model = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, model);
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#findAll()
	 */
	/**
	 * @param maxPrice,
	 *            le prix maximum du v�hicule
	 * @return la liste de v�hicules en stock en fonction d'un prix de vente
	 *         maximum
	 */
	public List<Car> findAllByMaxPrice(int maxPrice) {
		this.carsList = new ArrayList<Car>();

		try {
			String sql = "SELECT * FROM car WHERE sale_price <= ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, maxPrice);
			ResultSet rs = ConnexionMySql.getInstance().createStatement().executeQuery(sql);
			while (rs.next()) {
				this.carsList.add(new Car(rs.getString("immat"), rs.getString("brand"), rs.getString("model"),
						rs.getString("finition"), rs.getString("mec"), rs.getInt("kms"), rs.getInt("buy_price"),
						rs.getInt("sale_price"), rs.getInt("frevo"), rs.getInt("id_customer"), rs.getInt("id_saler"),
						rs.getInt("is_in_stock")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return carsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#create(java.lang.Object)
	 */
	public Car create(Car car) {
		this.setChanged();
		try {
			String sql = "INSERT INTO car (immat, brand, model, finition, mec, kms, buy_price, sale_price, frevo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, car.getImmat());
			pst.setString(2, car.getBrand());
			pst.setString(3, car.getModel());
			pst.setString(4, car.getFinition());
			pst.setString(5, car.getMec());
			pst.setInt(6, car.getKms());
			pst.setInt(7, car.getBuy_price());
			pst.setInt(8, car.getSale_price());
			pst.setInt(9, car.getFrevo());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		this.notifyObservers(car);
		return car;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see database.DAO#update(java.lang.Object)
	 */
	public Car update(Car car) {
		// this.setChanged(); // voir le commentaire suivant
		try {
			String sql = "UPDATE car SET immat = ?, brand = ?, model = ? , finition = ?, mec = ?, kms = ?, buy_price = ?, sale_price = ?, frevo = ? WHERE id_car = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setString(1, car.getImmat());
			pst.setString(2, car.getBrand());
			pst.setString(3, car.getModel());
			pst.setString(4, car.getFinition());
			pst.setString(5, car.getMec());
			pst.setInt(6, car.getKms());
			pst.setInt(7, car.getBuy_price());
			pst.setInt(8, car.getSale_price());
			pst.setInt(8, car.getFrevo());
			pst.executeUpdate();
		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		// this.notifyObservers(p); // Ici pas d'interet parce qu'on change
		// directement le tableau....
		return car; // Ici l'idée est de retourner la requete
					// Find(p.getId)
	}

	public void deleteById(int id) {
		this.setChanged();
		try {
			String sql = "DELETE FROM car WHERE id_car = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();

		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		this.notifyObservers();
	}

	public void deleteByImmat(int immat) {
		this.setChanged();
		try {
			String sql = "DELETE FROM car WHERE car.immat = ?";
			PreparedStatement pst = ConnexionMySql.getInstance().prepareStatement(sql);
			pst.setInt(1, immat);
			pst.executeUpdate();

		} catch (SQLException ex) {
			this.notifyObservers(ex);
			ex.printStackTrace();
		}
		this.notifyObservers();
	}

	/*
	 * private String replaceSpecialCharacters(String str) { str =
	 * str.toLowerCase().replace("é", "e").replace("è", "e").replace("à",
	 * "a").replace("ù", "u") .replace("ä", "a").replace("ë",
	 * "e").replace("ï", "i").replace("ö", "o").replace("ü", "u")
	 * .replace("ÿ", "y").replace("ç", "c");
	 * 
	 * return str; }
	 */

	@Override
	public void delete(Car o) {
		// TODO Auto-generated method stub

	}

}
