package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import controllers.AddCar_view_controller;

/**
 * @author ManiaK
 *
 */
public class AddCar_view extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel north_panel, south_panel, center_panel;
	private JLabel title_label, carBrand_label, carModel_label, carFinition_label, carKms_label, carBuyPrice_label,
			carSalePrice_label, carMec_label, carImmat_label, frevo_label;
	private JTextField carBrand_textfield, carModel_textfield, carFinition_textfield, carKms_textfield,
	carBuyPrice_textfield, carSalePrice_textfield, carMec_textfield, carImmat_textfield, frevo_textfield;
	private JButton carCustomer_button, back_button, addCar_button;
	private Insets insets;
	private GridBagConstraints constraints, constraints_addressPanel;
	private MainCardLayout_view view;

	/**
	 * 
	 * Constructeur de la vue du JOptionPane permettant l'ajout d'un nouveau
	 * client
	 * 
	 */
	public AddCar_view(MainCardLayout_view view) {
		this.view = view;
		initComponents();
		this.setVisible(true);
	}

	/**
	 * La fonction initialisant tous les composants de la vue
	 */
	private void initComponents() {
		north_panel = new JPanel();
		title_label = new JLabel("AJOUT D'UN NOUVEAU VEHICULE");
		title_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		north_panel.add(title_label);

		center_panel = new JPanel(new GridBagLayout());
		this.insets = new Insets(0, 3, 3, 3);
		this.constraints = new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, insets, 0, 0);
		this.constraints_addressPanel = new GridBagConstraints();

		carBrand_label = new JLabel("Marque :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		this.center_panel.add(this.carBrand_label, this.constraints);
		this.carBrand_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 0;
		this.center_panel.add(this.carBrand_textfield, this.constraints);

		this.carModel_label = new JLabel("Modèle :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.center_panel.add(this.carModel_label, this.constraints);
		this.carModel_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 1;
		this.center_panel.add(this.carModel_textfield, this.constraints);

		this.carFinition_label = new JLabel("Finition :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.center_panel.add(this.carFinition_label, this.constraints);
		this.carFinition_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 2;
		this.center_panel.add(this.carFinition_textfield, this.constraints);
		
		this.carImmat_label = new JLabel("Immatricualtion :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 3;
		this.center_panel.add(this.carImmat_label, this.constraints);
		this.carImmat_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 3;
		this.center_panel.add(this.carImmat_textfield, this.constraints);

		this.carMec_label = new JLabel("Année de mise en circulation :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 4;
		this.center_panel.add(this.carMec_label, this.constraints);
		this.carMec_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 4;
		this.center_panel.add(this.carMec_textfield, this.constraints);

		this.carKms_label = new JLabel("Kilométrage :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 5;
		this.center_panel.add(this.carKms_label, this.constraints);
		this.carKms_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 5;
		this.center_panel.add(this.carKms_textfield, this.constraints);

		this.carBuyPrice_label = new JLabel("Prix d'achat :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 6;
		this.center_panel.add(this.carBuyPrice_label, this.constraints);
		this.carBuyPrice_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 6;
		this.center_panel.add(this.carBuyPrice_textfield, this.constraints);
		this.carSalePrice_label = new JLabel("Prix de vente estimé :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 7;
		this.center_panel.add(this.carSalePrice_label, this.constraints);
		this.carSalePrice_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 7;
		this.center_panel.add(this.carSalePrice_textfield, this.constraints);
		this.frevo_label = new JLabel("FREVO estimés :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 8;
		this.center_panel.add(this.frevo_label, this.constraints);
		this.frevo_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 8;
		this.center_panel.add(this.frevo_textfield, this.constraints);

		//*************** SOUTH PANEL ***************//
		//******************************************//
		this.south_panel = new JPanel();
		this.constraints.gridx = 1;
		this.constraints.gridy = 8;
		this.center_panel.add(this.south_panel, this.constraints);
		this.carCustomer_button = new JButton("Assigner le véhicule à un client");
		this.constraints_addressPanel.gridx = 0;
		this.constraints_addressPanel.gridy = 0;
		this.south_panel.add(this.carCustomer_button, this.constraints_addressPanel);
		this.addCar_button = new JButton("Ajouter le véhicule");
		this.addCar_button.addActionListener(new AddCar_view_controller(this, view));
		this.constraints_addressPanel.gridx = 1;
		this.constraints_addressPanel.gridy = 1;
		this.south_panel.add(this.addCar_button, this.constraints_addressPanel);
		this.back_button = new JButton("Annuler");
		this.back_button.addActionListener(new AddCar_view_controller(this, view));
		this.constraints_addressPanel.gridx = 2;
		this.constraints_addressPanel.gridy = 2;
		this.south_panel.add(this.back_button, this.constraints_addressPanel);
		

		this.setLayout(new BorderLayout());
		this.add(this.north_panel, BorderLayout.NORTH);
		this.add(this.center_panel, BorderLayout.CENTER);
		this.add(this.south_panel, BorderLayout.SOUTH);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getNorth_panel() {
		return north_panel;
	}

	public JPanel getSouth_panel() {
		return south_panel;
	}

	public JPanel getCenter_panel() {
		return center_panel;
	}

	public JLabel getTitle_label() {
		return title_label;
	}

	public JButton getAddCar_button() {
		return addCar_button;
	}

	public void setAddCar_button(JButton addCar_button) {
		this.addCar_button = addCar_button;
	}

	public JLabel getFrevo_label() {
		return frevo_label;
	}

	public JTextField getFrevo_textfield() {
		return frevo_textfield;
	}

	public void setFrevo_label(JLabel frevo_label) {
		this.frevo_label = frevo_label;
	}

	public void setFrevo_textfield(JTextField frevo_textfield) {
		this.frevo_textfield = frevo_textfield;
	}

	public JLabel getCarBrand_label() {
		return carBrand_label;
	}

	public JLabel getCarModel_label() {
		return carModel_label;
	}

	public JLabel getCarFinition_label() {
		return carFinition_label;
	}

	public JLabel getCarKms_label() {
		return carKms_label;
	}

	public JLabel getCarBuyPrice_label() {
		return carBuyPrice_label;
	}

	public JLabel getCarSalePrice_label() {
		return carSalePrice_label;
	}

	public JLabel getCarMec_label() {
		return carMec_label;
	}

	public JLabel getCarImmat_label() {
		return carImmat_label;
	}

	public JButton getCarCustomer_button() {
		return carCustomer_button;
	}

	public Insets getInsets() {
		return insets;
	}

	public GridBagConstraints getConstraints() {
		return constraints;
	}

	public GridBagConstraints getConstraints_addressPanel() {
		return constraints_addressPanel;
	}

	public MainCardLayout_view getView() {
		return view;
	}

	public void setNorth_panel(JPanel north_panel) {
		this.north_panel = north_panel;
	}

	public void setSouth_panel(JPanel south_panel) {
		this.south_panel = south_panel;
	}

	public void setCenter_panel(JPanel center_panel) {
		this.center_panel = center_panel;
	}

	public void setTitle_label(JLabel title_label) {
		this.title_label = title_label;
	}

	public void setCarBrand_label(JLabel carBrand_label) {
		this.carBrand_label = carBrand_label;
	}

	public void setCarModel_label(JLabel carModel_label) {
		this.carModel_label = carModel_label;
	}

	public void setCarFinition_label(JLabel carFinition_label) {
		this.carFinition_label = carFinition_label;
	}

	public void setCarKms_label(JLabel carKms_label) {
		this.carKms_label = carKms_label;
	}

	public void setCarBuyPrice_label(JLabel carBuyPrice_label) {
		this.carBuyPrice_label = carBuyPrice_label;
	}

	public void setCarSalePrice_label(JLabel carSalePrice_label) {
		this.carSalePrice_label = carSalePrice_label;
	}

	public void setCarMec_label(JLabel carMec_label) {
		this.carMec_label = carMec_label;
	}

	public void setCarImmat_label(JLabel carImmat_label) {
		this.carImmat_label = carImmat_label;
	}

	public void setCarCustomer_button(JButton carCustomer_button) {
		this.carCustomer_button = carCustomer_button;
	}

	public void setInsets(Insets insets) {
		this.insets = insets;
	}

	public void setConstraints(GridBagConstraints constraints) {
		this.constraints = constraints;
	}

	public void setConstraints_addressPanel(GridBagConstraints constraints_addressPanel) {
		this.constraints_addressPanel = constraints_addressPanel;
	}

	public void setView(MainCardLayout_view view) {
		this.view = view;
	}

	public JButton getBack_button() {
		return back_button;
	}

	public void setBack_button(JButton back_button) {
		this.back_button = back_button;
	}

	/**
	 * @return carImmat_textfield, l'immatriculation du vsp
	 */
	public JTextField getCarImmat_textfield() {
		return carImmat_textfield;
	}

	/**
	 * @param carImmat_textfield
	 */
	public void setCarImmat_textfield(JTextField carImmat_textfield) {
		this.carImmat_textfield = carImmat_textfield;
	}

	/**
	 * @return carBrand_textfield, le champ à remplir pour la marque du vsp
	 */
	public JTextField getCarBrand_textfield() {
		return carBrand_textfield;
	}

	/**
	 * @return carModel_textfield, le champ à remplir pour le modèle du vsp
	 */
	public JTextField getCarModel_textfield() {
		return carModel_textfield;
	}

	/**
	 * @return carFinition_textfield, le champ à remplir pour la finition du vsp
	 */
	public JTextField getCarFinition_textfield() {
		return carFinition_textfield;
	}

	/**
	 * @return carKms_textfield, le champ à remplir pour le kilométrage du vsp
	 */
	public JTextField getCarKms_textfield() {
		return carKms_textfield;
	}

	/**
	 * @return carBuyPrice_textfield, le champ à remplir pour le prix d'achat du vsp
	 */
	public JTextField getCarBuyPrice_textfield() {
		return carBuyPrice_textfield;
	}

	/**
	 * @return carSalePrice_textfield, le champ à remplir pour le prix de vente estimé du vsp
	 */
	public JTextField getCarSalePrice_textfield() {
		return carSalePrice_textfield;
	}

	/**
	 * @return carMec_textfield, le champ à remplir pour l'année de mise en circulation du vsp
	 */
	public JTextField getCarMec_textfield() {
		return carMec_textfield;
	}

	/**
	 * @param carBrand_textfield
	 */
	public void setCarBrand_textfield(JTextField carBrand_textfield) {
		this.carBrand_textfield = carBrand_textfield;
	}

	/**
	 * @param carModel_textfield
	 */
	public void setCarModel_textfield(JTextField carModel_textfield) {
		this.carModel_textfield = carModel_textfield;
	}

	/**
	 * @param carFinition_textfield
	 */
	public void setCarFinition_textfield(JTextField carFinition_textfield) {
		this.carFinition_textfield = carFinition_textfield;
	}

	/**
	 * @param carKms_textfield
	 */
	public void setCarKms_textfield(JTextField carKms_textfield) {
		this.carKms_textfield = carKms_textfield;
	}

	/**
	 * @param carBuyPrice_textfield
	 */
	public void setCarBuyPrice_textfield(JTextField carBuyPrice_textfield) {
		this.carBuyPrice_textfield = carBuyPrice_textfield;
	}

	/**
	 * @param carSalePrice_textfield
	 */
	public void setCarSalePrice_textfield(JTextField carSalePrice_textfield) {
		this.carSalePrice_textfield = carSalePrice_textfield;
	}

	/**
	 * @param carMec_textfield
	 */
	public void setCarMec_textfield(JTextField carMec_textfield) {
		this.carMec_textfield = carMec_textfield;
	}
	
	

}
