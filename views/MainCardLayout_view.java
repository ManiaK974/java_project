package views;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.AddSaler_view_controller;
import controllers.ListCars_view_controller;
import controllers.ListCustomers_view_controller;
import controllers.MainCardLayout_view_controller;
import controllers.StatsCustomers_view_controller;
import models.JmenuBarModel;

public class MainCardLayout_view extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JmenuBarModel menuBar;
	private CardLayout layout;
	private MainCardLayout_view_controller mainCardLayout_controller;
	private JPanel main_panel;
	private JPanel dashboard_layout;
	private JPanel layout1;
	private JPanel layout2, layout3, layout4, layout5;
	private JPanel addSaler_panel;
	private ArrayList<String> listContent;

	public MainCardLayout_view() {
		this.setTitle("AutoServices");
		this.setSize(1600, 1000);
		this.setResizable(false);
		this.initcomponents();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initcomponents() {
		this.menuBar = new JmenuBarModel(this);
		this.menuBar.add(this.menuBar.getFile_menu());
		this.menuBar.add(this.menuBar.getCustomer_menu());
		this.menuBar.add(this.menuBar.getProspect_menu());
		this.menuBar.add(this.menuBar.getSale_menu());
		this.menuBar.add(this.menuBar.getBuy_menu());
		this.menuBar.add(this.menuBar.getStock_menu());
		this.menuBar.add(this.menuBar.getStats_menu());

		
		this.layout = new CardLayout();
		this.main_panel = new JPanel();
		this.listContent = new ArrayList<String>();
		this.listContent.add("Dashboard");
		this.listContent.add("List_cars");
		this.listContent.add("CARD 2");
		this.listContent.add("CARD 3");
		this.listContent.add("ListCustomers_view");
		this.listContent.add("StatsCustomers_view");
		this.listContent.add("AddSaler_view");
		this.dashboard_layout = new Dashboard_view(this);
		this.layout1 = new ListCars_view_controller(this).getView();
		this.layout2 = new AddCustomer_view(this);
		this.layout3 = new AddCar_view(this);
		this.layout4 = new ListCustomers_view_controller(this).getCustomers_view();
		this.layout5 = new StatsCustomers_view_controller(this).getView();
		this.addSaler_panel = new AddSaler_view_controller(this).getView();

	
		this.setJMenuBar(this.menuBar);
		this.getContentPane().add(main_panel);
		main_panel.setLayout(layout);
		main_panel.add(dashboard_layout, listContent.get(0));
		main_panel.add(layout1, listContent.get(1));
		main_panel.add(layout2, listContent.get(2));
		main_panel.add(layout3, listContent.get(3));
		main_panel.add(layout4, listContent.get(4));
		main_panel.add(layout5, listContent.get(5));
		main_panel.add(addSaler_panel, listContent.get(6));
	}

	public ArrayList<String> getListContent() {
		return listContent;
	}

	public void setListContent(ArrayList<String> listContent) {
		this.listContent = listContent;
	}

	public CardLayout getLayout() {
		return layout;
	}

	public JPanel getLayout1() {
		return layout1;
	}

	public JPanel getLayout2() {
		return layout2;
	}

	public void setLayout1(JPanel layout1) {
		this.layout1 = layout1;
	}

	public void setLayout2(JPanel layout2) {
		this.layout2 = layout2;
	}

	public JPanel getMain_panel() {
		return main_panel;
	}

	public void setMenuBar(JmenuBarModel menuBar) {
		this.menuBar = menuBar;
	}

	public void setLayout(CardLayout layout) {
		this.layout = layout;
	}

	public MainCardLayout_view_controller getMainCardLayout_controller() {
		return mainCardLayout_controller;
	}

	public void setMainCardLayout_controller(MainCardLayout_view_controller mainCardLayout_controller) {
		this.mainCardLayout_controller = mainCardLayout_controller;
	}

	public void setMain_panel(JPanel main_panel) {
		this.main_panel = main_panel;
	}

}
