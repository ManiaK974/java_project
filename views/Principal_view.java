package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JWindow;

import controllers.Principal_view_controller;
import models.JmenuBarModel;

public class Principal_view extends JFrame implements Observer {
	private JButton button;
	private JmenuBarModel menuBar;

	public Principal_view(Principal_view_controller controller) {
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		button = new JButton();
		button.setText("Cliquez moi !");
		this.menuBar = new JmenuBarModel(null);
		this.menuBar.add(this.menuBar.getFile_menu());
		this.menuBar.add(this.menuBar.getCustomer_menu());
		this.menuBar.add(this.menuBar.getProspect_menu());
		this.menuBar.add(this.menuBar.getSale_menu());
		this.menuBar.add(this.menuBar.getBuy_menu());
		this.menuBar.add(this.menuBar.getStock_menu());
		this.menuBar.add(this.menuBar.getStats_menu());

		this.getContentPane().add(button);
		this.setJMenuBar(this.menuBar);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
