package views;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

import controllers.ConnexionView_controller;
import models.ConnexionMySql;
import models.Recup_path_files;

/**
 * Ecran de chargement de l'application
 *
 * @author Maniak
 */
@SuppressWarnings("serial")
public class Splash_view extends JWindow {

    private JLabel img;
    private Thread t;
    private JProgressBar bar;
    private boolean check;
    private ImageIcon icon;

    /**
     * Constructeur de la vue.
     */
    public Splash_view() {
        this.check = true;
        this.setSize(500, 290);
        this.setLocationRelativeTo(null);

        img = new JLabel(new ImageIcon(Recup_path_files.getImgSplash()));
        t = new Thread(new Traitement());
        bar = new JProgressBar();

        bar.setMaximum(500);
        bar.setMinimum(0);
        bar.setBackground(Color.WHITE);
        bar.setForeground(Color.ORANGE);
        bar.setStringPainted(false);
        t.start();

        this.getContentPane().add(bar, BorderLayout.SOUTH);
        this.getContentPane().add(img, BorderLayout.NORTH);
        this.setBackground(Color.white);
        this.setVisible(true);
    }

    /**
     * Classe Traitement lié uniquement au Thread de la SplashView
     */
    class Traitement implements Runnable {

        /**
         * lancement du Thread de gestion de la SplashView
         */
        @Override
        public void run() {
            if (ConnexionMySql.isCheck() == false) {
                ConnexionMySql.getInstance();
            }
            for (int val = 0; val <= 500; val++) {

                bar.setValue(val);
                bar.setStringPainted(true);
                if (val == 500) {
                    dispose();
                    if (ConnexionMySql.isCheck()) {
                        new ConnexionView_controller();
                    }
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

