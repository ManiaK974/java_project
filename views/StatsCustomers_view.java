package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import controllers.StatsCustomers_view_controller;

public class StatsCustomers_view extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainCardLayout_view view;
	private StatsCustomers_view_controller controller;
	private GridBagConstraints constraints, filter_constraints;
	private Insets insets;
	private JPanel south_panel, north_panel, center_panel, filter_panel;
	private JPanel filter_panel1, filter_panel2;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
	private JButton back_button, testButton;
	private JLabel title_label;

	public StatsCustomers_view(MainCardLayout_view view, StatsCustomers_view_controller controller) {
		this.view = view;
		this.controller = controller;
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		this.insets = new Insets(5, 5, 5, 5);
		this.constraints = new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, insets, 0, 0);
		this.filter_constraints = new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, insets, 0, 0);

		// ******************* NORTH PANEL *******************//
		// ***************************************************//
		this.north_panel = new JPanel();
		this.title_label = new JLabel("STATISTIQUES CLIENTS");
		this.title_label.setFont(new Font("Times", Font.BOLD, 24));
		this.title_label.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));
		this.north_panel.add(title_label);

		// ******************* FILTER PANEL ******************//
		// ***************************************************//
		this.filter_panel = new JPanel(new GridBagLayout());
		this.filter_panel.setPreferredSize(new Dimension(250, 800));
		this.filter_panel1 = new JPanel();
		this.filter_panel1.setBorder(new TitledBorder("FILTRES 1"));
		this.filter_constraints.gridx = 0;
		this.filter_constraints.gridy = 0;
		this.filter_panel.add(this.filter_panel1, this.filter_constraints);
		this.filter_panel2 = new JPanel();
		this.filter_panel2.setBorder(new TitledBorder("FILTRES 2"));
		this.filter_constraints.gridx = 0;
		this.filter_constraints.gridy = 1;
		this.filter_panel.add(this.filter_panel2, this.filter_constraints);

		// ******************* CENTER PANEL ******************//
		// ***************************************************//
		this.center_panel = new JPanel(new GridBagLayout());
		this.panel1 = new JPanel();
		this.panel1.setBackground(Color.RED);
		this.constraints.gridx = 1;
		this.constraints.gridy = 1;
		this.center_panel.add(this.panel1, this.constraints);
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.RED);
		this.constraints.gridx = 2;
		this.constraints.gridy = 1;
		this.center_panel.add(this.panel2, this.constraints);
		this.panel3 = new JPanel();
		this.panel3.setBackground(Color.RED);
		this.constraints.gridx = 3;
		this.constraints.gridy = 1;
		this.center_panel.add(this.panel3, this.constraints);
		this.panel4 = new JPanel();
		this.panel4.setBackground(Color.RED);
		this.constraints.gridx = 4;
		this.constraints.gridy = 1;
		this.center_panel.add(this.panel4, this.constraints);
		this.panel5 = new JPanel();
		this.panel5.setBorder(new TitledBorder("STATISTIQUES 5"));
		this.constraints.gridx = 1;
		this.constraints.gridy = 2;
		this.constraints.gridwidth = 4;
		this.center_panel.add(this.panel5, this.constraints);
		this.panel6 = new JPanel();
		this.panel6.setBorder(new TitledBorder("STATISTIQUES 6"));
		this.constraints.gridx = 1;
		this.constraints.gridy = 3;
		this.constraints.gridwidth = 4;
		this.center_panel.add(this.panel6, this.constraints);

		// ******************* SOUTH PANEL *******************//
		// ***************************************************//
		this.south_panel = new JPanel();
		this.back_button = new JButton("Retour au tableau de bord");
		this.testButton = new JButton("test");
		this.south_panel.add(back_button);
		this.south_panel.add(testButton);

		this.setLayout(new BorderLayout());
		this.add(this.north_panel, BorderLayout.NORTH);
		this.add(this.center_panel, BorderLayout.CENTER);
		this.add(this.south_panel, BorderLayout.SOUTH);
		this.add(this.filter_panel, BorderLayout.WEST);

	}

	public JButton getTestButton() {
		return testButton;
	}

	public void setTestButton(JButton testButton) {
		this.testButton = testButton;
	}

	public JButton getBack_button() {
		return back_button;
	}

	public void setBack_button(JButton back_button) {
		this.back_button = back_button;
	}

}
