package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import controllers.ListCars_submenu_controller;
import controllers.ListCars_view_controller;
import database.CarDAO;
import models.Car;

/**
 * @author ManiaK
 *
 */
public class ListCars_view extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4128974709532861767L;
	private MainCardLayout_view view;
	private ListCars_submenu_controller listCars_submenu_controller;
	private JPanel north_panel, south_panel, center_panel, filter_panel, east_panel;
	private JLabel title_label, brandFilter_label, mecFilter_label, noVsp, stats_nbVsp_label, finitionFilter_label,
			maxKmsFilter_label;
	private JTable table;
	private JComboBox<String> brandFilter_box;
	private JButton back_button, filters_button, refresh_button;
	private String nbVsp;
	private JTextField mec_textfield, finition_textfield, maxKms_textfield;
	private ListCars_view_controller controller;

	/**
	 * 
	 * Constructeur de la vue du JOptionPane permettant l'ajout d'un nouveau
	 * client
	 * 
	 */
	public ListCars_view(MainCardLayout_view view, ListCars_view_controller controller) {
		this.controller = controller;
		this.view = view;
		initComponents();
		this.setVisible(true);
	}

	/**
	 * La fonction initialisant tous les composants de la vue
	 */
	private void initComponents() {
		north_panel = new JPanel();
		title_label = new JLabel("LISTE DES VEHICULES");
		title_label.setFont(new Font("Times", Font.BOLD, 24));
		title_label.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));
		north_panel.add(title_label);

		this.filter_panel = new JPanel();
		this.filter_panel.setPreferredSize(new Dimension(220, 700));
		this.filter_panel.setBorder(new TitledBorder("FILTRES"));

		this.brandFilter_label = new JLabel("Marque du VSP : ");
		this.filter_panel.add(brandFilter_label);

		Object[] elements = new Object[] { "Tous", "Ligier", "Microcar", "Chatenet", "Bellier", "Jdm", "Aixam" };
		this.brandFilter_box = new JComboBox(elements);
		JPanel brandFilter_panel = new JPanel();
		brandFilter_panel.add(brandFilter_box);
		this.filter_panel.add(brandFilter_panel);

		this.mecFilter_label = new JLabel("Année MEC : ");
		this.filter_panel.add(mecFilter_label);
		this.mec_textfield = new JTextField(10);
		this.filter_panel.add(mec_textfield);
		this.finitionFilter_label = new JLabel("Finition : ");
		this.filter_panel.add(this.finitionFilter_label);
		this.finition_textfield = new JTextField(10);
		this.filter_panel.add(this.finition_textfield);
		this.maxKmsFilter_label = new JLabel("Kms max : ");
		this.filter_panel.add(this.maxKmsFilter_label);
		this.maxKms_textfield = new JTextField(10);
		this.filter_panel.add(this.maxKms_textfield);

		this.filters_button = new JButton("Filtrer");
		this.filter_panel.add(filters_button);

		this.center_panel = new JPanel();
		this.center_panel.add(new JScrollPane(controller.getT()));

		this.refresh_button = new JButton("Rafraîchir la liste");
		this.center_panel.add(this.refresh_button);

		this.east_panel = new JPanel();
		this.east_panel.setBorder(new TitledBorder("LISTE DES VSP SELECTIONNES"));
		this.east_panel.setPreferredSize(new Dimension(250, 800));
		this.nbVsp = controller.showNbCarsStats();
		this.stats_nbVsp_label = new JLabel(this.nbVsp + " véhicules sans permis sélectionnés");
		this.east_panel.add(stats_nbVsp_label);

		// ****************** SOUTH PANEL *********************//
		// ****************************************************//
		this.back_button = new JButton("Retour au tableau de bord");
		this.south_panel = new JPanel();
		this.south_panel.add(back_button);

		this.setLayout(new BorderLayout());
		this.add(south_panel, BorderLayout.SOUTH);
		this.add(this.north_panel, BorderLayout.NORTH);
		this.add(this.center_panel, BorderLayout.CENTER);
		this.add(this.east_panel, BorderLayout.EAST);
		this.add(this.filter_panel, BorderLayout.WEST);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == controller & (arg1 instanceof String)) {
			this.east_panel.removeAll();
			this.nbVsp = controller.getNbVsp();
			if (nbVsp.equals("0")) {
				this.stats_nbVsp_label.setText("Aucun véhicule sans permis disponible");
			} else {
				this.stats_nbVsp_label.setText(nbVsp + " véhicules sans permis sélectionnés");
			}
			this.east_panel.add(stats_nbVsp_label);
			this.east_panel.revalidate();
			this.east_panel.repaint();
			this.center_panel.removeAll();
			this.center_panel.add(new JScrollPane(controller.getT()));
			this.center_panel.add(this.refresh_button);
			this.center_panel.revalidate();
			this.center_panel.repaint();
		} else if (arg1 instanceof Exception) {
			Exception e = (Exception) arg1;
			JOptionPane.showMessageDialog(this.getParent(), e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JButton getRefresh_button() {
		return refresh_button;
	}

	public void setRefresh_button(JButton refresh_button) {
		this.refresh_button = refresh_button;
	}

	public JTextField getMaxKms_textfield() {
		return maxKms_textfield;
	}

	public void setMaxKms_textfield(JTextField maxKms_textfield) {
		this.maxKms_textfield = maxKms_textfield;
	}

	public JTextField getFinition_textfield() {
		return finition_textfield;
	}

	public void setFinition_textfield(JTextField finition_textfield) {
		this.finition_textfield = finition_textfield;
	}

	public JTextField getMec_textfield() {
		return mec_textfield;
	}

	public void setMec_textfield(JTextField mec_textfield) {
		this.mec_textfield = mec_textfield;
	}

	public JLabel getNoVsp() {
		return noVsp;
	}

	public void setNoVsp(JLabel noVsp) {
		this.noVsp = noVsp;
	}

	public JComboBox getBrandFilter_box() {
		return brandFilter_box;
	}

	public void setBrandFilter_box(JComboBox brandFilter_box) {
		this.brandFilter_box = brandFilter_box;
	}

	public JButton getFilters_button() {
		return filters_button;
	}

	public void setFilters_button(JButton filters_button) {
		this.filters_button = filters_button;
	}

	public String getNbVsp() {
		return nbVsp;
	}

	public void setNbVsp(String nbVsp) {
		this.nbVsp = nbVsp;
	}

	public JButton getBack_button() {
		return back_button;
	}

	public void setBack_button(JButton back_button) {
		this.back_button = back_button;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ListCars_submenu_controller getListCars_submenu_controller() {
		return listCars_submenu_controller;
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

	public void setListCars_submenu_controller(ListCars_submenu_controller listCars_submenu_controller) {
		this.listCars_submenu_controller = listCars_submenu_controller;
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

}
