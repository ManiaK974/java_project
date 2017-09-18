package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LargeButtonCustomer_dashboard extends JButton implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LargeButtonCustomer_dashboard(String text, ImageIcon icon) {
		super(text, icon);
		setForeground(Color.WHITE);
		this.setBackground(new Color(0, 121, 107));
		this.setPreferredSize(new Dimension(100,80));
		this.setIconTextGap(40);
		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.RIGHT);

		setFocusPainted(false);
		setBorderPainted(false); // De même, on ne veut pas afficher les
									// bordures.
		setFocusPainted(false); // On n'affiche pas l'effet de focus.

		addMouseListener(this);
		setVisible(true);
	}

	public void mouseClicked(int mouseExited) {
		setBackground(Color.GREEN);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == this) {
			this.setBackground(new Color(38,166,154));
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this) {
			this.setBackground(new Color(0, 121, 107));

		}
	}

}
