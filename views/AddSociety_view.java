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
public class AddSociety_view extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel north_panel, center_panel;
	private JLabel title_label, societyName_label, society_phoneNumber_label, society_faxNumber_label,
			society_commercialPhone_label, society_siretNumber_label, society_apeCode_label, society_addressName_label,
			society_addressPostalCode_label, society_addressCity_label;
	private JTextField societyName_textfield, society_phoneNumber_textfield, society_faxNumber_textfield, society_commercialPhone_textfield,
	society_siretNumber_textfield, society_apeCode_textfield, society_addressName_textfield, society_addressPostalCode_textfield, society_addressCity_textfield;
	private Insets insets;
	private GridBagConstraints constraints;
	private MainCardLayout_view view;

	/**
	 * 
	 * Constructeur de la vue du JOptionPane permettant l'ajout d'un nouveau
	 * client
	 * 
	 */
	public AddSociety_view(MainCardLayout_view view) {
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

		societyName_label = new JLabel("Nom commercial de votre société :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		this.center_panel.add(this.societyName_label, this.constraints);
		this.societyName_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 0;
		this.center_panel.add(this.societyName_textfield, this.constraints);

		this.society_phoneNumber_label = new JLabel("Numéro de téléphone du bureau :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.center_panel.add(this.society_phoneNumber_label, this.constraints);
		this.society_phoneNumber_textfield = new JTextField(40);
		this.constraints.gridx = 1;
		this.constraints.gridy = 1;
		this.center_panel.add(this.society_phoneNumber_textfield, this.constraints);

		this.society_faxNumber_label = new JLabel("Numéro de fax :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.center_panel.add(this.society_faxNumber_label, this.constraints);
		this.society_faxNumber_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 2;
		this.center_panel.add(this.society_faxNumber_textfield, this.constraints);

		this.society_siretNumber_label = new JLabel("Numéro de siret :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 3;
		this.center_panel.add(this.society_siretNumber_label, this.constraints);
		this.society_siretNumber_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 3;
		this.center_panel.add(this.society_siretNumber_textfield, this.constraints);

		this.society_apeCode_label = new JLabel("Code APE :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 4;
		this.center_panel.add(this.society_apeCode_label, this.constraints);
		this.society_apeCode_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 4;
		this.center_panel.add(this.society_apeCode_textfield, this.constraints);

		this.society_commercialPhone_label = new JLabel("Numéro commercial :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 5;
		this.center_panel.add(this.society_commercialPhone_label, this.constraints);
		this.society_commercialPhone_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 5;
		this.center_panel.add(this.society_commercialPhone_textfield, this.constraints);

		this.society_addressName_label = new JLabel("Adresse :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 6;
		this.center_panel.add(this.society_addressName_label, this.constraints);
		this.society_addressName_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 6;
		this.center_panel.add(this.society_addressName_textfield, this.constraints);

		this.society_addressPostalCode_label = new JLabel("Code Postal :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 7;
		this.center_panel.add(this.society_addressPostalCode_label, this.constraints);
		this.society_addressPostalCode_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 7;
		this.center_panel.add(this.society_addressPostalCode_textfield, this.constraints);

		this.society_addressCity_label = new JLabel("Ville :");
		this.constraints.gridx = 0;
		this.constraints.gridy = 8;
		this.center_panel.add(this.society_addressCity_label, this.constraints);
		this.society_addressCity_textfield = new JTextField();
		this.constraints.gridx = 1;
		this.constraints.gridy = 8;
		this.center_panel.add(this.society_addressCity_textfield, this.constraints);

		this.setLayout(new BorderLayout());
		this.add(this.north_panel, BorderLayout.NORTH);
		this.add(this.center_panel, BorderLayout.CENTER);
	}

	public JPanel getNorth_panel() {
		return north_panel;
	}

	public JPanel getCenter_panel() {
		return center_panel;
	}

	public JLabel getTitle_label() {
		return title_label;
	}

	public JLabel getSocietyName_label() {
		return societyName_label;
	}

	public JLabel getSociety_phoneNumber_label() {
		return society_phoneNumber_label;
	}

	public JLabel getSociety_faxNumber_label() {
		return society_faxNumber_label;
	}

	public JLabel getSociety_commercialPhone_label() {
		return society_commercialPhone_label;
	}

	public JLabel getSociety_siretNumber_label() {
		return society_siretNumber_label;
	}

	public JLabel getSociety_apeCode_label() {
		return society_apeCode_label;
	}

	public JLabel getSociety_addressName_label() {
		return society_addressName_label;
	}

	public JLabel getSociety_addressPostalCode_label() {
		return society_addressPostalCode_label;
	}

	public JLabel getSociety_addressCity_label() {
		return society_addressCity_label;
	}

	public JTextField getSocietyName_textfield() {
		return societyName_textfield;
	}

	public JTextField getSociety_phoneNumber_textfield() {
		return society_phoneNumber_textfield;
	}

	public JTextField getSociety_faxNumber_textfield() {
		return society_faxNumber_textfield;
	}

	public JTextField getSociety_commercialPhone_textfield() {
		return society_commercialPhone_textfield;
	}

	public JTextField getSociety_siretNumber_textfield() {
		return society_siretNumber_textfield;
	}

	public JTextField getSociety_apeCode_textfield() {
		return society_apeCode_textfield;
	}

	public JTextField getSociety_addressName_textfield() {
		return society_addressName_textfield;
	}

	public JTextField getSociety_addressPostalCode_textfield() {
		return society_addressPostalCode_textfield;
	}

	public JTextField getSociety_addressCity_textfield() {
		return society_addressCity_textfield;
	}

	public Insets getInsets() {
		return insets;
	}

	public GridBagConstraints getConstraints() {
		return constraints;
	}

	public MainCardLayout_view getView() {
		return view;
	}

	public void setNorth_panel(JPanel north_panel) {
		this.north_panel = north_panel;
	}

	public void setCenter_panel(JPanel center_panel) {
		this.center_panel = center_panel;
	}

	public void setTitle_label(JLabel title_label) {
		this.title_label = title_label;
	}

	public void setSocietyName_label(JLabel societyName_label) {
		this.societyName_label = societyName_label;
	}

	public void setSociety_phoneNumber_label(JLabel society_phoneNumber_label) {
		this.society_phoneNumber_label = society_phoneNumber_label;
	}

	public void setSociety_faxNumber_label(JLabel society_faxNumber_label) {
		this.society_faxNumber_label = society_faxNumber_label;
	}

	public void setSociety_commercialPhone_label(JLabel society_commercialPhone_label) {
		this.society_commercialPhone_label = society_commercialPhone_label;
	}

	public void setSociety_siretNumber_label(JLabel society_siretNumber_label) {
		this.society_siretNumber_label = society_siretNumber_label;
	}

	public void setSociety_apeCode_label(JLabel society_apeCode_label) {
		this.society_apeCode_label = society_apeCode_label;
	}

	public void setSociety_addressName_label(JLabel society_addressName_label) {
		this.society_addressName_label = society_addressName_label;
	}

	public void setSociety_addressPostalCode_label(JLabel society_addressPostalCode_label) {
		this.society_addressPostalCode_label = society_addressPostalCode_label;
	}

	public void setSociety_addressCity_label(JLabel society_addressCity_label) {
		this.society_addressCity_label = society_addressCity_label;
	}

	public void setSocietyName_textfield(JTextField societyName_textfield) {
		this.societyName_textfield = societyName_textfield;
	}

	public void setSociety_phoneNumber_textfield(JTextField society_phoneNumber_textfield) {
		this.society_phoneNumber_textfield = society_phoneNumber_textfield;
	}

	public void setSociety_faxNumber_textfield(JTextField society_faxNumber_textfield) {
		this.society_faxNumber_textfield = society_faxNumber_textfield;
	}

	public void setSociety_commercialPhone_textfield(JTextField society_commercialPhone_textfield) {
		this.society_commercialPhone_textfield = society_commercialPhone_textfield;
	}

	public void setSociety_siretNumber_textfield(JTextField society_siretNumber_textfield) {
		this.society_siretNumber_textfield = society_siretNumber_textfield;
	}

	public void setSociety_apeCode_textfield(JTextField society_apeCode_textfield) {
		this.society_apeCode_textfield = society_apeCode_textfield;
	}

	public void setSociety_addressName_textfield(JTextField society_addressName_textfield) {
		this.society_addressName_textfield = society_addressName_textfield;
	}

	public void setSociety_addressPostalCode_textfield(JTextField society_addressPostalCode_textfield) {
		this.society_addressPostalCode_textfield = society_addressPostalCode_textfield;
	}

	public void setSociety_addressCity_textfield(JTextField society_addressCity_textfield) {
		this.society_addressCity_textfield = society_addressCity_textfield;
	}

	public void setInsets(Insets insets) {
		this.insets = insets;
	}

	public void setConstraints(GridBagConstraints constraints) {
		this.constraints = constraints;
	}

	public void setView(MainCardLayout_view view) {
		this.view = view;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
