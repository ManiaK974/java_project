/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.MenuFichierQuitterController;
import controllers.MySociety_submenu_controller;
import views.ListCars_view;
import views.MainCardLayout_view;
import controllers.AddCar_submenu_controller;
import controllers.AddCustomer_submenu_controller;
import controllers.ImportExcel_submenu_controller;
import controllers.ListCars_submenu_controller;
import controllers.ListCustomers_submenu_controller;

/**
 *
 * @author Maniak
 */
public class JmenuBarModel extends JMenuBar {

	/**
	 * 
	 */
	private MainCardLayout_view m;
	private static final long serialVersionUID = 1L;
	private JMenu file_menu, customer_menu, stock_menu, prospect_menu, sale_menu, buy_menu, stats_menu;
	private JMenuItem param_submenu, mySociety_submenu, quit_submenu, addClient_submenu, listClients_submenu,
			importExcel_submenu, addStock_submenu, listStocks_submenu, makeRound_submenu,
			docProspect_submenu, offerSale_submenu, orderSale_submenu, docSale_submenu, offerBuy_submenu,
			orderBuy_submenu, docBuy_submenu, statsCustomers_submenu, statsStocks_submenu, statsBusiness_submenu;

	/**
	 * 
	 */
	public JmenuBarModel(MainCardLayout_view m) {
		this.m = m;
		/*---------------- MENUS -------------------*/
		/*------------------------------------------*/
		file_menu = new JMenu("Fichier");
		customer_menu = new JMenu("Clients");
		stock_menu = new JMenu("Stocks");
		prospect_menu = new JMenu("Prospection");
		sale_menu = new JMenu("Ventes");
		buy_menu = new JMenu("Achats");
		stats_menu = new JMenu("Statistiques");

		/*---------------- SOUS-MENUS -------------------*/
		/*-----------------------------------------------*/

		/*-------------------- FICHIER-------------------*/
		param_submenu = new JMenuItem("Paramètres");
		quit_submenu = new JMenuItem("Quitter");
		mySociety_submenu = new JMenuItem("Ma Société");

		/*------------------- CLIENTS --------------------*/
		addClient_submenu = new JMenuItem("Ajouter un client");
		listClients_submenu = new JMenuItem("Liste des clients");
		importExcel_submenu = new JMenuItem("Importer un fichier clients");

		/*-------------------- STOCKS -------------------*/
		addStock_submenu = new JMenuItem("Ajouter un VSP");
		listStocks_submenu = new JMenuItem("Liste des VSP");

		/*------------------- PROSPECTION ------------------*/
		makeRound_submenu = new JMenuItem("Générer une tournée");
		docProspect_submenu = new JMenuItem("Documents");

		/*-------------------- VENTE ----------------------*/
		offerSale_submenu = new JMenuItem("Générer une proposition");
		orderSale_submenu = new JMenuItem("Générer un bon de commande");
		docSale_submenu = new JMenuItem("Documents");

		/*-------------------- ACHAT ----------------------*/
		offerBuy_submenu = new JMenuItem("Générer une proposition");
		orderBuy_submenu = new JMenuItem("Générer une fiche de reprise");
		docBuy_submenu = new JMenuItem("Documents");

		/*------------------ STATISTIQUES ------------------*/
		statsCustomers_submenu = new JMenuItem("Statistiques clients");
		statsStocks_submenu = new JMenuItem("Statistiques stocks");
		statsBusiness_submenu = new JMenuItem("Statistiques business");

		/*------------------ AJOUT DES SOUS-MENUS -------------------*/
		/*-----------------------------------------------------------*/
		file_menu.add(param_submenu);
		file_menu.add(mySociety_submenu);
		file_menu.addSeparator();
		file_menu.add(quit_submenu);

		customer_menu.add(addClient_submenu);
		customer_menu.add(listClients_submenu);
		customer_menu.add(importExcel_submenu);

		stock_menu.add(addStock_submenu);
		stock_menu.add(listStocks_submenu);

		prospect_menu.add(makeRound_submenu);
		prospect_menu.add(docProspect_submenu);

		sale_menu.add(offerSale_submenu);
		sale_menu.add(orderSale_submenu);
		sale_menu.add(docSale_submenu);

		buy_menu.add(offerBuy_submenu);
		buy_menu.add(orderBuy_submenu);
		buy_menu.add(docBuy_submenu);

		stats_menu.add(statsCustomers_submenu);
		stats_menu.add(statsStocks_submenu);
		stats_menu.add(statsBusiness_submenu);

		/*------------------ AJOUT DES LISTENERS -------------------*/
		/*-----------------------------------------------------------*/
		this.quit_submenu.addActionListener(new MenuFichierQuitterController(this));
		this.mySociety_submenu.addActionListener(new MySociety_submenu_controller(this, m));
		this.addClient_submenu.addActionListener(new AddCustomer_submenu_controller(this, m));
		this.importExcel_submenu.addActionListener(new ImportExcel_submenu_controller(this));
		this.addStock_submenu.addActionListener(new AddCar_submenu_controller(this, m));
		this.listStocks_submenu.addActionListener(new ListCars_submenu_controller(this, m));
		this.listClients_submenu.addActionListener(new ListCustomers_submenu_controller(this));

	}

	public JMenuItem getMySociety_submenu() {
		return mySociety_submenu;
	}

	public void setMySociety_submenu(JMenuItem mySociety_submenu) {
		this.mySociety_submenu = mySociety_submenu;
	}

	/**
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public JMenu getFile_menu() {
		return file_menu;
	}

	/**
	 * @return
	 */
	public JMenu getCustomer_menu() {
		return customer_menu;
	}

	/**
	 * @return
	 */
	public JMenu getStock_menu() {
		return stock_menu;
	}

	/**
	 * @return
	 */
	public JMenu getProspect_menu() {
		return prospect_menu;
	}

	/**
	 * @return
	 */
	public JMenu getSale_menu() {
		return sale_menu;
	}

	/**
	 * @return
	 */
	public JMenu getBuy_menu() {
		return buy_menu;
	}

	/**
	 * @return
	 */
	public JMenu getStats_menu() {
		return stats_menu;
	}

	/**
	 * @return
	 */
	public JMenuItem getParam_submenu() {
		return param_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getQuit_submenu() {
		return quit_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getAddClient_submenu() {
		return addClient_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getImportExcel_submenu() {
		return importExcel_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getAddStock_submenu() {
		return addStock_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getMakeRound_submenu() {
		return makeRound_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getDocProspect_submenu() {
		return docProspect_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getOfferSale_submenu() {
		return offerSale_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getOrderSale_submenu() {
		return orderSale_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getDocSale_submenu() {
		return docSale_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getOfferBuy_submenu() {
		return offerBuy_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getOrderBuy_submenu() {
		return orderBuy_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getDocBuy_submenu() {
		return docBuy_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getStatsCustomers_submenu() {
		return statsCustomers_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getStatsStocks_submenu() {
		return statsStocks_submenu;
	}

	/**
	 * @return
	 */
	public JMenuItem getStatsBusiness_submenu() {
		return statsBusiness_submenu;
	}

	/**
	 * @param file_menu
	 */
	public void setFile_menu(JMenu file_menu) {
		this.file_menu = file_menu;
	}

	/**
	 * @param customer_menu
	 */
	public void setCustomer_menu(JMenu customer_menu) {
		this.customer_menu = customer_menu;
	}

	/**
	 * @param stock_menu
	 */
	public void setStock_menu(JMenu stock_menu) {
		this.stock_menu = stock_menu;
	}

	/**
	 * @param prospect_menu
	 */
	public void setProspect_menu(JMenu prospect_menu) {
		this.prospect_menu = prospect_menu;
	}

	/**
	 * @param sale_menu
	 */
	public void setSale_menu(JMenu sale_menu) {
		this.sale_menu = sale_menu;
	}

	/**
	 * @param buy_menu
	 */
	public void setBuy_menu(JMenu buy_menu) {
		this.buy_menu = buy_menu;
	}

	/**
	 * @param stats_menu
	 */
	public void setStats_menu(JMenu stats_menu) {
		this.stats_menu = stats_menu;
	}

	/**
	 * @param param_submenu
	 */
	public void setParam_submenu(JMenuItem param_submenu) {
		this.param_submenu = param_submenu;
	}

	/**
	 * @param quit_submenu
	 */
	public void setQuit_submenu(JMenuItem quit_submenu) {
		this.quit_submenu = quit_submenu;
	}

	/**
	 * @param addClient_submenu
	 */
	public void setAddClient_submenu(JMenuItem addClient_submenu) {
		this.addClient_submenu = addClient_submenu;
	}

	/**
	 * @param importExcel_submenu
	 */
	public void setImportExcel_submenu(JMenuItem importExcel_submenu) {
		this.importExcel_submenu = importExcel_submenu;
	}

	/**
	 * @param addStock_submenu
	 */
	public void setAddStock_submenu(JMenuItem addStock_submenu) {
		this.addStock_submenu = addStock_submenu;
	}

	/**
	 * @return listClients_submenu
	 */
	public JMenuItem getListClients_submenu() {
		return listClients_submenu;
	}

	/**
	 * @return listStocks_submenu
	 */
	public JMenuItem getListStocks_submenu() {
		return listStocks_submenu;
	}

	/**
	 * @param listClients_submenu
	 */
	public void setListClients_submenu(JMenuItem listClients_submenu) {
		this.listClients_submenu = listClients_submenu;
	}

	/**
	 * @param listStocks_submenu
	 */
	public void setListStocks_submenu(JMenuItem listStocks_submenu) {
		this.listStocks_submenu = listStocks_submenu;
	}

	/**
	 * @param makeRound_submenu
	 */
	public void setMakeRound_submenu(JMenuItem makeRound_submenu) {
		this.makeRound_submenu = makeRound_submenu;
	}

	/**
	 * @param docProspect_submenu
	 */
	public void setDocProspect_submenu(JMenuItem docProspect_submenu) {
		this.docProspect_submenu = docProspect_submenu;
	}

	/**
	 * @param offerSale_submenu
	 */
	public void setOfferSale_submenu(JMenuItem offerSale_submenu) {
		this.offerSale_submenu = offerSale_submenu;
	}

	/**
	 * @param orderSale_submenu
	 */
	public void setOrderSale_submenu(JMenuItem orderSale_submenu) {
		this.orderSale_submenu = orderSale_submenu;
	}

	/**
	 * @param docSale_submenu
	 */
	public void setDocSale_submenu(JMenuItem docSale_submenu) {
		this.docSale_submenu = docSale_submenu;
	}

	/**
	 * @param offerBuy_submenu
	 */
	public void setOfferBuy_submenu(JMenuItem offerBuy_submenu) {
		this.offerBuy_submenu = offerBuy_submenu;
	}

	/**
	 * @param orderBuy_submenu
	 */
	public void setOrderBuy_submenu(JMenuItem orderBuy_submenu) {
		this.orderBuy_submenu = orderBuy_submenu;
	}

	/**
	 * @param docBuy_submenu
	 */
	public void setDocBuy_submenu(JMenuItem docBuy_submenu) {
		this.docBuy_submenu = docBuy_submenu;
	}

	/**
	 * @param statsCustomers_submenu
	 */
	public void setStatsCustomers_submenu(JMenuItem statsCustomers_submenu) {
		this.statsCustomers_submenu = statsCustomers_submenu;
	}

	/**
	 * @param statsStocks_submenu
	 */
	public void setStatsStocks_submenu(JMenuItem statsStocks_submenu) {
		this.statsStocks_submenu = statsStocks_submenu;
	}

	/**
	 * @param statsBusiness_submenu
	 */
	public void setStatsBusiness_submenu(JMenuItem statsBusiness_submenu) {
		this.statsBusiness_submenu = statsBusiness_submenu;
	}

}
