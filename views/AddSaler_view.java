package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import controllers.AddCar_view_controller;
import controllers.AddSaler_view_controller;

/**
 * @author ManiaK
 *
 */
public class AddSaler_view extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel north_panel, south_panel, center_panel;
	private JLabel title_label, commercialName_label, founderFirstname_label, founderLastname_label, street_label, postalCode_label, city_label;
	private JTextField commercialName_textfield, founderFirstname_textfield, founderLastname_textfield, street_textfield, postalCode_textfield, city_textfield;
	private JButton back_button, addSaler_button;
	private Insets insets;
	private GridBagConstraints constraints, constraints_addressPanel;
	private MainCardLayout_view view;
	private AddSaler_view_controller controller;

	/**
	 * 
	 * Constructeur de la vue du JOptionPane permettant l'ajout d'un nouveau
	 * client
	 * 
	 */
	public AddSaler_view(AddSaler_view_controller controller, MainCardLayout_view view) {
		this.view = view;
		initComponents();
		this.setVisible(true);
	}

	/**
	 * La fonction initialisant tous les composants de la vue
	 */
	private void initComponents() {
		north_panel = new JPanel();
		title_label = new JLabel("AJOUT D'UN NOUVEL AGENT LIGIER/MICROCAR");
		title_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		north_panel.add(title_label);

		center_panel = new JPanel(new GridBagLayout());
		this.insets = new Insets(0, 3, 3, 3);
		this.constraints = new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, insets, 0, 0);
		this.constraints_addressPanel = new GridBagConstraints();

		this.commercialName_label = new JLabel("Nom commercial :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		this.center_panel.add(this.commercialName_label, this.constraints);
		this.commercialName_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 0;
		this.center_panel.add(this.commercialName_textfield, this.constraints);

		this.founderFirstname_label = new JLabel("Prénom du dirigeant :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.center_panel.add(this.founderFirstname_label, this.constraints);
		this.founderFirstname_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 1;
		this.center_panel.add(this.founderFirstname_textfield, this.constraints);

		this.founderLastname_label = new JLabel("Nom du dirigeant :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.center_panel.add(this.founderLastname_label, this.constraints);
		this.founderLastname_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 2;
		this.center_panel.add(this.founderLastname_textfield, this.constraints);
		
		this.street_label = new JLabel("Adresse :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 3;
		this.center_panel.add(this.street_label, this.constraints);
		this.street_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 3;
		this.center_panel.add(this.street_textfield, this.constraints);

		this.postalCode_label = new JLabel("Code postal :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 4;
		this.center_panel.add(this.postalCode_label, this.constraints);
		this.postalCode_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 4;
		this.center_panel.add(this.postalCode_textfield, this.constraints);

		this.city_label = new JLabel("Ville :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 5;
		this.center_panel.add(this.city_label, this.constraints);
		this.city_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 5;
		this.center_panel.add(this.city_textfield, this.constraints);

		
		//*************** SOUTH PANEL ***************//
		//******************************************//
		this.south_panel = new JPanel();
		this.constraints.gridx = 1;
		this.constraints.gridy = 8;
		this.center_panel.add(this.south_panel, this.constraints);
		this.addSaler_button = new JButton("Ajouter le nouvel agent");
		this.constraints_addressPanel.gridx = 0;
		this.constraints_addressPanel.gridy = 0;
		this.south_panel.add(this.addSaler_button, this.constraints_addressPanel);
		this.back_button = new JButton("Annuler");
		this.constraints_addressPanel.gridx = 1;
		this.constraints_addressPanel.gridy = 1;
		this.south_panel.add(this.back_button, this.constraints_addressPanel);
		

		this.setLayout(new BorderLayout());
		this.add(this.north_panel, BorderLayout.NORTH);
		this.add(this.center_panel, BorderLayout.CENTER);
		this.add(this.south_panel, BorderLayout.SOUTH);

	}

	public JTextField getCommercialName_textfield() {
		return commercialName_textfield;
	}

	public JTextField getFounderFirstname_textfield() {
		return founderFirstname_textfield;
	}

	public JTextField getFounderLastname_textfield() {
		return founderLastname_textfield;
	}

	public JTextField getStreet_textfield() {
		return street_textfield;
	}

	public JTextField getPostalCode_textfield() {
		return postalCode_textfield;
	}

	public JTextField getCity_textfield() {
		return city_textfield;
	}

	public JButton getBack_button() {
		return back_button;
	}

	public JButton getAddSaler_button() {
		return addSaler_button;
	}

	public void setCommercialName_textfield(JTextField commercialName_textfield) {
		this.commercialName_textfield = commercialName_textfield;
	}

	public void setFounderFirstname_textfield(JTextField founderFirstname_textfield) {
		this.founderFirstname_textfield = founderFirstname_textfield;
	}

	public void setFounderLastname_textfield(JTextField founderLastname_textfield) {
		this.founderLastname_textfield = founderLastname_textfield;
	}

	public void setStreet_textfield(JTextField street_textfield) {
		this.street_textfield = street_textfield;
	}

	public void setPostalCode_textfield(JTextField postalCode_textfield) {
		this.postalCode_textfield = postalCode_textfield;
	}

	public void setCity_textfield(JTextField city_textfield) {
		this.city_textfield = city_textfield;
	}

	public void setBack_button(JButton back_button) {
		this.back_button = back_button;
	}

	public void setAddSaler_button(JButton addSaler_button) {
		this.addSaler_button = addSaler_button;
	}

}
