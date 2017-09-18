package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controllers.ComboBoxController;
import controllers.ListCustomers_view_controller;
import database.CustomerDAO;
import database.SectorDAO;

public class ListCustomers_view extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1958253344330367500L;
	private MainCardLayout_view view;
	private ListCustomers_view_controller controller;
	private JButton back_button, filters_button;
	private JPanel south_panel, east_panel, north_panel, center_panel, filter_panel;
	private JLabel title_label, stats_nbCustomers_label, postalCodeFilter_label, nameFilter_label, sectorFilter_label;
	private String nbCustomers;
	private JTextField nameFilter_textfield;
	private Insets insets;
	private Vector postalCode_vector, sector_vector;
	private ArrayList<String> postalCode_list, sector_list;
	private JComboBox<String> postalCodeFilter_box, sectorFilter_box;
	private GridBagConstraints filter_constraints;

	public ListCustomers_view(MainCardLayout_view view, ListCustomers_view_controller controller) {
		this.controller = controller;
		this.view = view;
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		/*
		 * this.filter_constraints = new GridBagConstraints(0, 0, 1, 1, 0.5,
		 * 0.5, GridBagConstraints.LINE_START, GridBagConstraints.VERTICAL,
		 * insets, 0, 0);
		 */

		// ***************** NORTH PANEL *******************//
		// *************************************************//
		north_panel = new JPanel();
		title_label = new JLabel("LISTE DES CLIENTS");
		title_label.setFont(new Font("Times", Font.BOLD, 24));
		title_label.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));
		north_panel.add(title_label);

		// ***************** CENTER PANEL *******************//
		// **************************************************//
		this.center_panel = new JPanel();
		this.center_panel.add(new JScrollPane(controller.allCustomersJTable()));

		// ***************** FILTER PANEL *******************//
		// **************************************************//
		this.filter_panel = new JPanel();
		this.filter_panel.setPreferredSize(new Dimension(200, 700));
		this.filter_panel.setBorder(new TitledBorder("FILTRES"));

		/*this.postalCode_list = new CustomerDAO().findAllPostalCode();
		this.postalCode_list.remove(0);
		this.postalCode_list.add(0, "TOUS");*/

		this.sectorFilter_label = new JLabel("Secteur : ");
		this.filter_panel.add(this.sectorFilter_label);
		this.sector_list = new SectorDAO().findAllSectors();
		this.sector_list.add(0, "TOUS");
		this.sector_vector = new Vector(this.sector_list);
		this.sectorFilter_box = new JComboBox<String>(this.sector_vector);
		this.sectorFilter_box.addActionListener(new ComboBoxController(this));
		this.filter_panel.add(this.sectorFilter_box);

		this.postalCodeFilter_label = new JLabel("Code postal : ");
		this.filter_panel.add(this.postalCodeFilter_label);		
		this.postalCode_list = new ArrayList<String>();
		this.postalCode_list.add("44500");
		this.postalCode_list.add("44600");
		this.postalCode_list.add(0, "TOUS");
		this.postalCode_vector = new Vector<String>(postalCode_list);
		this.postalCodeFilter_box = new JComboBox<String>(this.postalCode_vector);
		this.filter_panel.add(this.postalCodeFilter_box); 

		this.nameFilter_label = new JLabel("Nom du client : ");
		this.filter_panel.add(this.nameFilter_label);
		this.nameFilter_textfield = new JTextField(8);
		this.filter_panel.add(this.nameFilter_textfield);

		this.filters_button = new JButton("Filtrer");
		JPanel button_panel = new JPanel();
		button_panel.add(this.filters_button);
		this.filter_panel.add(button_panel);

		// ***************** EAST PANEL *******************//
		// ************************************************//
		this.east_panel = new JPanel();
		this.east_panel.setPreferredSize(new Dimension(250, 800));
		this.east_panel.setBorder(new TitledBorder("LISTE DES CLIENTS SELECTIONNES"));
		this.nbCustomers = controller.showNbCustomersStats();
		this.stats_nbCustomers_label = new JLabel(this.nbCustomers + " client(s) sélectionné(s)");
		this.east_panel.add(this.stats_nbCustomers_label);

		// ***************** SOUTH PANEL *******************//
		// *************************************************//
		this.south_panel = new JPanel();
		this.back_button = new JButton("Retour au tableau de bord");
		this.south_panel.add(this.back_button);

		this.setLayout(new BorderLayout());
		this.add(this.south_panel, BorderLayout.SOUTH);
		this.add(this.north_panel, BorderLayout.NORTH);
		this.add(this.center_panel, BorderLayout.CENTER);
		this.add(this.east_panel, BorderLayout.EAST);
		this.add(this.filter_panel, BorderLayout.WEST);

	}

	public Vector getPostalCode_vector() {
		return postalCode_vector;
	}

	public Vector getSector_vector() {
		return sector_vector;
	}

	public ArrayList<String> getPostalCode_list() {
		return postalCode_list;
	}

	public ArrayList<String> getSector_list() {
		return sector_list;
	}

	public void setPostalCode_vector(Vector postalCode_vector) {
		this.postalCode_vector = postalCode_vector;
	}

	public void setSector_vector(Vector sector_vector) {
		this.sector_vector = sector_vector;
	}

	public void setPostalCode_list(ArrayList<String> postalCode_list) {
		this.postalCode_list = postalCode_list;
	}

	public void setSector_list(ArrayList<String> sector_list) {
		this.sector_list = sector_list;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof String) {
			this.east_panel.removeAll();
			this.nbCustomers = controller.getNbCustomers();
			if (nbCustomers.equals("0")) {
				this.stats_nbCustomers_label.setText("Aucun client disponible");
			} else {
				this.stats_nbCustomers_label.setText(nbCustomers + " client(s) sélectionné(s)");
			}
			this.east_panel.add(stats_nbCustomers_label);
			this.east_panel.revalidate();
			this.east_panel.repaint();
			this.center_panel.removeAll();
			this.center_panel.add(new JScrollPane(controller.getT()));
			this.center_panel.revalidate();
			this.center_panel.repaint();
		} else if (arg1 instanceof Exception) {
			Exception e = (Exception) arg1;
			JOptionPane.showMessageDialog(this.getParent(), e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	public MainCardLayout_view getView() {
		return view;
	}

	public JTextField getNameFilter_textfield() {
		return nameFilter_textfield;
	}

	public void setNameFilter_textfield(JTextField nameFilter_textfield) {
		this.nameFilter_textfield = nameFilter_textfield;
	}

	public JComboBox<String> getPostalCodeFilter_box() {
		return postalCodeFilter_box;
	}

	public void setPostalCodeFilter_box(JComboBox<String> postalCodeFilter_box) {
		this.postalCodeFilter_box = postalCodeFilter_box;
	}

	public JButton getFilters_button() {
		return filters_button;
	}

	public JComboBox<String> getSectorFilter_box() {
		return sectorFilter_box;
	}

	public void setSectorFilter_box(JComboBox<String> sectorFilter_box) {
		this.sectorFilter_box = sectorFilter_box;
	}

	public JLabel getStats_nbCustomers_label() {
		return stats_nbCustomers_label;
	}

	public String getNbCustomers() {
		return nbCustomers;
	}

	public void setFilters_button(JButton filters_button) {
		this.filters_button = filters_button;
	}

	public void setStats_nbCustomers_label(JLabel stats_nbCustomers_label) {
		this.stats_nbCustomers_label = stats_nbCustomers_label;
	}

	public void setNbCustomers(String nbCustomers) {
		this.nbCustomers = nbCustomers;
	}

	public JButton getBack_button() {
		return back_button;
	}

	public JPanel getSouth_panel() {
		return south_panel;
	}

	public JPanel getNorth_panel() {
		return north_panel;
	}

	public JLabel getTitle_label() {
		return title_label;
	}

	public JPanel getCenter_panel() {
		return center_panel;
	}

	public void setView(MainCardLayout_view view) {
		this.view = view;
	}

	public void setBack_button(JButton back_button) {
		this.back_button = back_button;
	}

	public void setSouth_panel(JPanel south_panel) {
		this.south_panel = south_panel;
	}

	public void setNorth_panel(JPanel north_panel) {
		this.north_panel = north_panel;
	}

	public void setTitle_label(JLabel title_label) {
		this.title_label = title_label;
	}

	public void setCenter_panel(JPanel center_panel) {
		this.center_panel = center_panel;
	}

}
