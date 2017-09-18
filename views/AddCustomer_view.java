package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import controllers.AddCustomer_submenu_controller;
import controllers.AddCustomer_view_controller;

/**
 * @author ManiaK
 *
 */
public class AddCustomer_view extends JPanel {
	private static final long serialVersionUID = 1L;
	private MainCardLayout_view view;
	private JPanel north_panel, south_panel, center_panel, address_panel; 
	private JLabel title_label, customerName_label, customerLastname_label, customerAddress_label,
			customerPostalCode_label, customerCity_label, customerPhone_label, customerMail_label;
	private JTextField customerName_textfield, customerLastName_textfield, customerStreet_textfield,
			customerPostalCode_textfield, customerCity_textfield, customerPhone_textfield, customerMail_textfield;
	private JButton customerVsp_button, customerOrder_button, back_button;
	private JComboBox<Object> customerStreetNum_combo;
	private Insets insets;
	private GridBagConstraints constraints, constraints_addressPanel;

	/**
	 * 
	 * Constructeur de la vue du JOptionPane permettant l'ajout d'un nouveau client
	 * 
	 */
	public AddCustomer_view(MainCardLayout_view view) {
		this.view = view;
		initComponents();
		this.setVisible(true);
	}

	/**
	 * La fonction initialisant tous les composants de la vue
	 */
	private void initComponents() {
		north_panel = new JPanel();
		title_label = new JLabel("AJOUT D'UN NOUVEAU CLIENT");
		title_label.setFont(new Font("Arial", Font.PLAIN, 16));
		north_panel.add(title_label);

		center_panel = new JPanel(new GridBagLayout());
		this.insets = new Insets(0, 3, 3, 3);
		this.constraints = new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, insets, 0, 0);
		this.constraints_addressPanel = new GridBagConstraints();
		
		customerLastname_label = new JLabel("Nom :");
		customerLastname_label.setFont(new Font("Arial", Font.PLAIN, 14));
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		this.center_panel.add(this.customerLastname_label, this.constraints);
		this.customerLastName_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 0;
		this.center_panel.add(this.customerLastName_textfield, this.constraints);

		this.customerName_label = new JLabel("Prénom :");
		customerName_label.setFont(new Font("Arial", Font.PLAIN, 14));
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.center_panel.add(this.customerName_label, this.constraints);
		this.customerName_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 1;
		this.center_panel.add(this.customerName_textfield, this.constraints);
		
		
		this.customerAddress_label = new JLabel("Adresse :");
		customerAddress_label.setFont(new Font("Arial", Font.PLAIN, 14));
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.center_panel.add(this.customerAddress_label, this.constraints);
		
		this.address_panel = new JPanel(new GridBagLayout());
		this.constraints.gridx = 1;
		this.center_panel.add(this.address_panel, this.constraints);
		customerStreetNum_combo = new JComboBox<>();
		customerStreetNum_combo.setPreferredSize(new Dimension(55, 20));
		customerStreetNum_combo.addItem("N°");
		for (int i = 1; i <= 1500; i++) {
			customerStreetNum_combo.addItem(i);
		}
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		this.constraints_addressPanel.insets = new Insets(0,0,0,10);
		this.address_panel.add(this.customerStreetNum_combo, this.constraints_addressPanel);
		this.customerStreet_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 0;
		this.address_panel.add(this.customerStreet_textfield);
	

		this.customerPostalCode_label = new JLabel("Code postal :");
		customerPostalCode_label.setFont(new Font("Arial", Font.PLAIN, 14));
		this.constraints.gridx = 0;
		this.constraints.gridy = 3;
		this.center_panel.add(this.customerPostalCode_label, this.constraints);
		this.customerPostalCode_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 3;
		this.center_panel.add(this.customerPostalCode_textfield, this.constraints);

		this.customerCity_label = new JLabel("Ville :");
		customerCity_label.setFont(new Font("Arial", Font.PLAIN, 14));
		this.constraints.gridx = 0;
		this.constraints.gridy = 4;
		this.center_panel.add(this.customerCity_label, this.constraints);
		this.customerCity_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 4;
		this.center_panel.add(this.customerCity_textfield, this.constraints);
		
		this.customerPhone_label = new JLabel("Numéro de téléphone :");
		customerPhone_label.setFont(new Font("Arial", Font.PLAIN, 14));
		this.constraints.gridx = 0;
		this.constraints.gridy = 5;
		this.center_panel.add(this.customerPhone_label, this.constraints);
		this.customerPhone_textfield = new JTextField(30);
		this.constraints.gridx = 1;
		this.constraints.gridy = 5;
		this.center_panel.add(this.customerPhone_textfield, this.constraints);
		
		this.customerMail_label = new JLabel("E-mail :");
		customerMail_label.setFont(new Font("Arial", Font.PLAIN, 14));
		this.constraints.gridx = 0;
		this.constraints.gridy = 6;
		this.center_panel.add(this.customerMail_label, this.constraints);
		this.customerMail_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 6;
		this.center_panel.add(this.customerMail_textfield, this.constraints);
		
		this.south_panel = new JPanel();
		this.constraints.gridx = 1;
		this.constraints.gridy = 7;
		this.center_panel.add(this.south_panel, this.constraints);
		this.customerVsp_button = new JButton("Assigner un VSP");
		this.constraints_addressPanel.gridx = 0;
		this.constraints_addressPanel.gridy = 0;
		this.south_panel.add(this.customerVsp_button, this.constraints_addressPanel);
		this.customerOrder_button = new JButton("Etablir un bon de commande");
		this.constraints_addressPanel.gridx = 1;
		this.constraints_addressPanel.gridy = 1;
		this.south_panel.add(this.customerOrder_button, this.constraints_addressPanel);
		this.back_button = new JButton("Annuler");
		this.back_button.addActionListener(new AddCustomer_view_controller(this, view));
		this.constraints_addressPanel.gridx = 2;
		this.constraints_addressPanel.gridy = 2;
		this.south_panel.add(this.back_button, this.constraints_addressPanel);

		this.setLayout(new BorderLayout());
		this.add(this.north_panel, BorderLayout.NORTH);
		this.add(this.center_panel, BorderLayout.CENTER);
		this.add(this.south_panel, BorderLayout.SOUTH);

	}
	

	public JButton getBack_button() {
		return back_button;
	}

	public void setBack_button(JButton back_button) {
		this.back_button = back_button;
	}

	/**
	 * @return title_label, le label du titre de la fenêtre
	 */
	public JLabel getTitle() {
		return title_label;
	}

	/**
	 * @param title
	 */
	public void setTitle(JLabel title) {
		this.title_label = title;
	}

	/**
	 * @return customerName_textfield, le champ à remplir du prénom du client
	 */
	public JTextField getCustomerName_textfield() {
		return customerName_textfield;
	}

	/**
	 * @return customerLastName_textfield, le champ à remplir du nom du client
	 */
	public JTextField getCustomerLastName_textfield() {
		return customerLastName_textfield;
	}

	/**
	 * @return customerStreet_textfield, le champ à remplir du nom de la rue du client
	 */
	public JTextField getCustomerStreet_textfield() {
		return customerStreet_textfield;
	}

	/**
	 * @return customerPostalCode_textfield, le champ à remplir du code postal de la ville du client
	 */
	public JTextField getCustomerPostalCode_textfield() {
		return customerPostalCode_textfield;
	}

	/**
	 * @return customerCity_textfield, le champ à remplir de la ville du client
	 */
	public JTextField getCustomerCity_textfield() {
		return customerCity_textfield;
	}

	/**
	 * @return customerStreetNum_combo, la combobox du choix du numéro de rue du client
	 */
	public JComboBox<Object> getCustomerStreetNum_combo() {
		return customerStreetNum_combo;
	}

	/**
	 * @param customerName_textfield
	 */
	public void setCustomerName_textfield(JTextField customerName_textfield) {
		this.customerName_textfield = customerName_textfield;
	}

	/**
	 * @param customerLastName_textfield
	 */
	public void setCustomerLastName_textfield(JTextField customerLastName_textfield) {
		this.customerLastName_textfield = customerLastName_textfield;
	}

	/**
	 * @param customerStreet_textfield
	 */
	public void setCustomerStreet_textfield(JTextField customerStreet_textfield) {
		this.customerStreet_textfield = customerStreet_textfield;
	}

	/**
	 * @param customerPostalCode_textfield
	 */
	public void setCustomerPostalCode_textfield(JTextField customerPostalCode_textfield) {
		this.customerPostalCode_textfield = customerPostalCode_textfield;
	}

	/**
	 * @param customerCity_textfield
	 */
	public void setCustomerCity_textfield(JTextField customerCity_textfield) {
		this.customerCity_textfield = customerCity_textfield;
	}

	/**
	 * @param customerStreetNum_combo
	 */
	public void setCustomerStreetNum_combo(JComboBox<Object> customerStreetNum_combo) {
		this.customerStreetNum_combo = customerStreetNum_combo;
	}

	/**
	 * @return customerPhone_textfield, le champ à remplir du numéro de téléphone du client
	 */
	public JTextField getCustomerPhone_textfield() {
		return customerPhone_textfield;
	}

	/**
	 * @return customerMail_textfield, le champ à remplir de l'adresse mail du client
	 */
	public JTextField getCustomerMail_textfield() {
		return customerMail_textfield;
	}

	/**
	 * @return customerVsp_button, le bouton pour assigner un Vsp au client
	 */
	public JButton getCustomerVsp_button() {
		return customerVsp_button;
	}

	/**
	 * @return customerOrder_button, le bouton pour établir un bon de commande pour le client
	 */
	public JButton getCustomerOrder_button() {
		return customerOrder_button;
	}

	/**
	 * @param customerPhone_textfield
	 */
	public void setCustomerPhone_textfield(JTextField customerPhone_textfield) {
		this.customerPhone_textfield = customerPhone_textfield;
	}

	/**
	 * @param customerMail_textfield
	 */
	public void setCustomerMail_textfield(JTextField customerMail_textfield) {
		this.customerMail_textfield = customerMail_textfield;
	}

	/**
	 * @param customerVsp_button
	 */
	public void setCustomerVsp_button(JButton customerVsp_button) {
		this.customerVsp_button = customerVsp_button;
	}

	/**
	 * @param customerOrder_button
	 */
	public void setCustomerOrder_button(JButton customerOrder_button) {
		this.customerOrder_button = customerOrder_button;
	}
	
	
	

}
