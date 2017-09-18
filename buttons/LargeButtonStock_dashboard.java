package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LargeButtonStock_dashboard extends JButton implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LargeButtonStock_dashboard(String text, ImageIcon icon) {
		super(text, icon);
		setForeground(Color.WHITE);
		this.setBackground(new Color(230,81,0));
		this.setPreferredSize(new Dimension(100, 80));
		if (text.length() > 20) {
			this.setIconTextGap(30);
		} else 
			this.setIconTextGap(80);
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
			this.setBackground(new Color(245,127,23));
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
			this.setBackground(new Color(230,81,0));

		}
	}

}
