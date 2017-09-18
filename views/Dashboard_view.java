package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import buttons.LargeButtonBusiness_dashboard;
import buttons.LargeButtonCustomer_dashboard;
import buttons.LargeButtonStats_dashboard;
import buttons.LargeButtonStock_dashboard;
import controllers.AddCustomer_submenu_controller;
import controllers.Dashboard_view_controller;
import controllers.ListCustomers_view_controller;

public class Dashboard_view extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dashboard_view_controller controller;
	private MainCardLayout_view view;
	private Insets insets;
	private GridBagConstraints constraints, mainConstraints;
	private JPanel main_panel, north_panel, customers_panel, stock_panel, business_panel, statistics_panel;
	private JButton showListCustomer_button;
	private LargeButtonCustomer_dashboard addNewCustomer_button, add_saler_button, showListSaler_button;
	private JButton addNewVsp_button, showListVsp_button, generateOrder_button, generateTour_button,
			generatePurchase_button, docsBusiness_button;
	private JButton stats_customers_button, stats_stock_button, stats_business_button;

	public Dashboard_view(MainCardLayout_view view) {
		this.view = view;
		initComponents();
		this.setVisible(true);

	}

	private void initComponents() {
		this.insets = new Insets(5, 5, 5, 5);
		this.constraints = new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, insets, 0, 0);
		this.mainConstraints = new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, insets, 0, 0);

		this.north_panel = new JPanel();
		JLabel title = new JLabel("MON TABLEAU DE BORD");
		title.setFont(new Font("Times", Font.BOLD, 24));
		title.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));
		this.north_panel.add(title);

		// **************** CUSTOMERS PANEL ****************//
		this.customers_panel = new JPanel(new GridBagLayout());
		JLabel customers_label = new JLabel("CLIENTS");
		customers_label.setFont(new Font("Times", Font.BOLD, 16));
		JPanel customers_title_panel = new JPanel();
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		customers_title_panel.add(customers_label);
		this.customers_panel.add(customers_title_panel, this.constraints);

		// ************* ADD CUSTOMERS BUTTON *************//
		ImageIcon adduser_icon = new ImageIcon("img/icon_add_user.png");
		this.addNewCustomer_button = new LargeButtonCustomer_dashboard("Ajouter un nouveau client", adduser_icon);
		this.addNewCustomer_button.addActionListener(new Dashboard_view_controller(this, view));
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.customers_panel.add(this.addNewCustomer_button, this.constraints);

		// ************** SHOW LIST CUSTOMERS BUTTON **************//
		ImageIcon listUsers_icon = new ImageIcon("img/icon_list_users.png");
		this.showListCustomer_button = new LargeButtonCustomer_dashboard("Voir la liste des clients", listUsers_icon);
		this.showListCustomer_button.addActionListener(new Dashboard_view_controller(this, view));
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.customers_panel.add(this.showListCustomer_button, this.constraints);

		// ************** SHOW LIST CUSTOMERS BUTTON **************//
		ImageIcon saler_icon = new ImageIcon("img/icon_list_users.png");
		this.add_saler_button = new LargeButtonCustomer_dashboard("Ajouter un nouvel agent", saler_icon);
		this.add_saler_button.addActionListener(new Dashboard_view_controller(this, view));
		this.constraints.gridx = 0;
		this.constraints.gridy = 3;
		this.customers_panel.add(this.add_saler_button, this.constraints);

		// ************** SHOW LIST SALER BUTTON **************//
		ImageIcon listSalers_icon = new ImageIcon("img/icon_list_users.png");
		this.showListSaler_button = new LargeButtonCustomer_dashboard("Voir la liste des agents", listSalers_icon);
		this.showListSaler_button.addActionListener(new Dashboard_view_controller(this, view));
		this.constraints.gridx = 0;
		this.constraints.gridy = 4;
		this.customers_panel.add(this.showListSaler_button, this.constraints);

		// ************** STOCK PANEL *************//
		this.stock_panel = new JPanel(new GridBagLayout());
		JLabel stocks_label = new JLabel("STOCKS");
		stocks_label.setFont(new Font("Times", Font.BOLD, 16));
		JPanel stock_title_panel = new JPanel();
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		stock_title_panel.add(stocks_label);
		this.stock_panel.add(stock_title_panel, this.constraints);

		// *************** ADD VSP BUTTON ***************//
		ImageIcon addVsp_icon = new ImageIcon("img/icon_add_car.png");
		this.addNewVsp_button = new LargeButtonStock_dashboard("Ajouter un nouveau VSP", addVsp_icon);
		this.addNewVsp_button.addActionListener(new Dashboard_view_controller(this, view));
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.stock_panel.add(this.addNewVsp_button, this.constraints);

		// ************* SHOW LIST CARS **************//
		ImageIcon listVsp_icon = new ImageIcon("img/icon_list_cars.png");
		this.showListVsp_button = new LargeButtonStock_dashboard("Voir la liste des VSP disponibles", listVsp_icon);
		this.showListVsp_button.addActionListener(new Dashboard_view_controller(this, view));
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.stock_panel.add(this.showListVsp_button, this.constraints);

		// ************** BUSINESS PANEL ***************//
		this.business_panel = new JPanel(new GridBagLayout());
		JPanel business_title_panel = new JPanel();
		JLabel business_label = new JLabel("COMMERCE");
		business_label.setFont(new Font("Times", Font.BOLD, 16));
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		business_title_panel.add(business_label);
		this.business_panel.add(business_title_panel, this.constraints);

		// ************** ORDER BUTTON *****************//
		ImageIcon order_icon = new ImageIcon("img/icon_order.png");
		this.generateOrder_button = new LargeButtonBusiness_dashboard("Générer un bon de commande", order_icon);
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.business_panel.add(this.generateOrder_button, this.constraints);

		// ************** PURCHASE BUTTON ***************//
		ImageIcon purchase_icon = new ImageIcon("img/icon_purchase.png");
		this.generatePurchase_button = new LargeButtonBusiness_dashboard("Générer une fiche de reprise", purchase_icon);
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.business_panel.add(this.generatePurchase_button, this.constraints);

		// ************** TOUR BUTTON *****************//
		ImageIcon tour_icon = new ImageIcon("img/icon_tour.png");
		this.generateTour_button = new LargeButtonBusiness_dashboard("Générer une tournée prospection", tour_icon);
		this.constraints.gridx = 0;
		this.constraints.gridy = 3;
		this.business_panel.add(this.generateTour_button, this.constraints);

		// ************** DOCS BUTTON ***************//
		ImageIcon docsBusiness_icon = new ImageIcon("img/icon_docs.png");
		this.docsBusiness_button = new LargeButtonBusiness_dashboard("Documents", docsBusiness_icon);
		this.constraints.gridx = 0;
		this.constraints.gridy = 4;
		this.business_panel.add(this.docsBusiness_button, this.constraints);

		// **************** STATS PANEL ****************//
		this.statistics_panel = new JPanel(new GridBagLayout());
		JPanel stats_title_panel = new JPanel();
		JLabel stats_label = new JLabel("STATISTIQUES");
		stats_label.setFont(new Font("Times", Font.BOLD, 16));
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		stats_title_panel.add(stats_label);
		this.statistics_panel.add(stats_title_panel, this.constraints);

		// ***************** STATS CUSTOMERS BUTTON *******************//
		ImageIcon statsCustomers_icon = new ImageIcon("img/icon_stats_customers.png");
		this.stats_customers_button = new LargeButtonStats_dashboard("Statistiques clients", statsCustomers_icon);
		this.stats_customers_button.addActionListener(new Dashboard_view_controller(this, view));
		this.constraints.gridx = 0;
		this.constraints.gridy = 1;
		this.statistics_panel.add(this.stats_customers_button, this.constraints);

		// **************** STATS STOCK BUTTON *********************//
		ImageIcon statsVsp_icon = new ImageIcon("img/icon_stats_vsp.png");
		this.stats_stock_button = new LargeButtonStats_dashboard("Statistiques stocks", statsVsp_icon);
		this.constraints.gridx = 0;
		this.constraints.gridy = 2;
		this.statistics_panel.add(this.stats_stock_button, this.constraints);

		ImageIcon statsBusiness_icon = new ImageIcon("img/icon_stats_business.png");
		this.stats_business_button = new LargeButtonStats_dashboard("Statistiques business", statsBusiness_icon);
		this.constraints.gridx = 0;
		this.constraints.gridy = 3;
		this.statistics_panel.add(this.stats_business_button, this.constraints);

		this.main_panel = new JPanel(new GridBagLayout());
		this.mainConstraints.gridx = 0;
		this.mainConstraints.gridy = 0;
		this.main_panel.add(this.customers_panel, this.mainConstraints);
		this.mainConstraints.gridx = 1;
		this.mainConstraints.gridy = 0;
		this.main_panel.add(this.business_panel, this.mainConstraints);
		this.mainConstraints.gridx = 2;
		this.mainConstraints.gridy = 0;
		this.main_panel.add(this.stock_panel, this.mainConstraints);
		this.mainConstraints.gridx = 3;
		this.mainConstraints.gridy = 0;
		this.main_panel.add(this.statistics_panel, this.mainConstraints);

		this.setLayout(new BorderLayout());
		this.add(north_panel, BorderLayout.NORTH);
		this.add(this.main_panel, BorderLayout.CENTER);
	}

	public Dashboard_view_controller getController() {
		return controller;
	}

	public LargeButtonCustomer_dashboard getAdd_saler_button() {
		return add_saler_button;
	}

	public LargeButtonCustomer_dashboard getShowListSaler_button() {
		return showListSaler_button;
	}

	public void setAdd_saler_button(LargeButtonCustomer_dashboard add_saler_button) {
		this.add_saler_button = add_saler_button;
	}

	public void setShowListSaler_button(LargeButtonCustomer_dashboard showListSaler_button) {
		this.showListSaler_button = showListSaler_button;
	}

	public Insets getInsets() {
		return insets;
	}

	public GridBagConstraints getConstraints() {
		return constraints;
	}

	public GridBagConstraints getMainConstraints() {
		return mainConstraints;
	}

	public JPanel getMain_panel() {
		return main_panel;
	}

	public JPanel getNorth_panel() {
		return north_panel;
	}

	public JPanel getCustomers_panel() {
		return customers_panel;
	}

	public JPanel getStock_panel() {
		return stock_panel;
	}

	public JPanel getBusiness_panel() {
		return business_panel;
	}

	public JPanel getStatistics_panel() {
		return statistics_panel;
	}

	public JButton getAddNewCustomer_button() {
		return addNewCustomer_button;
	}

	public JButton getShowListCustomer_button() {
		return showListCustomer_button;
	}

	public JButton getAddNewVsp_button() {
		return addNewVsp_button;
	}

	public MainCardLayout_view getView() {
		return view;
	}

	public void setView(MainCardLayout_view view) {
		this.view = view;
	}

	public JButton getShowListVsp_button() {
		return showListVsp_button;
	}

	public JButton getGenerateOrder_button() {
		return generateOrder_button;
	}

	public JButton getGenerateTour_button() {
		return generateTour_button;
	}

	public JButton getGeneratePurchase_button() {
		return generatePurchase_button;
	}

	public JButton getDocsBusiness_button() {
		return docsBusiness_button;
	}

	public JButton getStats_customers_button() {
		return stats_customers_button;
	}

	public JButton getStats_stock_button() {
		return stats_stock_button;
	}

	public JButton getStats_business_button() {
		return stats_business_button;
	}

	public void setController(Dashboard_view_controller controller) {
		this.controller = controller;
	}

	public void setInsets(Insets insets) {
		this.insets = insets;
	}

	public void setConstraints(GridBagConstraints constraints) {
		this.constraints = constraints;
	}

	public void setMainConstraints(GridBagConstraints mainConstraints) {
		this.mainConstraints = mainConstraints;
	}

	public void setMain_panel(JPanel main_panel) {
		this.main_panel = main_panel;
	}

	public void setNorth_panel(JPanel north_panel) {
		this.north_panel = north_panel;
	}

	public void setCustomers_panel(JPanel customers_panel) {
		this.customers_panel = customers_panel;
	}

	public void setStock_panel(JPanel stock_panel) {
		this.stock_panel = stock_panel;
	}

	public void setBusiness_panel(JPanel business_panel) {
		this.business_panel = business_panel;
	}

	public void setStatistics_panel(JPanel statistics_panel) {
		this.statistics_panel = statistics_panel;
	}

	public void setAddNewCustomer_button(LargeButtonCustomer_dashboard addNewCustomer_button) {
		this.addNewCustomer_button = addNewCustomer_button;
	}

	public void setShowListCustomer_button(JButton showListCustomer_button) {
		this.showListCustomer_button = showListCustomer_button;
	}

	public void setAddNewVsp_button(JButton addNewVsp_button) {
		this.addNewVsp_button = addNewVsp_button;
	}

	public void setShowListVsp_button(JButton showListVsp_button) {
		this.showListVsp_button = showListVsp_button;
	}

	public void setGenerateOrder_button(JButton generateOrder_button) {
		this.generateOrder_button = generateOrder_button;
	}

	public void setGenerateTour_button(JButton generateTour_button) {
		this.generateTour_button = generateTour_button;
	}

	public void setGeneratePurchase_button(JButton generatePurchase_button) {
		this.generatePurchase_button = generatePurchase_button;
	}

	public void setDocsBusiness_button(JButton docsBusiness_button) {
		this.docsBusiness_button = docsBusiness_button;
	}

	public void setStats_customers_button(JButton stats_customers_button) {
		this.stats_customers_button = stats_customers_button;
	}

	public void setStats_stock_button(JButton stats_stock_button) {
		this.stats_stock_button = stats_stock_button;
	}

	public void setStats_business_button(JButton stats_business_button) {
		this.stats_business_button = stats_business_button;
	}

}
