/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Classe de recuperation du chemin d'acces des fichiers de ressources.
 *
 * @author Maniak
 */
public class Recup_path_files {

    private final String PATHIMG = "/img/";
    private final String NAME_IMG_FILE = "dataNameFile.txt";
    private final String UNKNOW = "unknow";
    private final String ERR_IMG = "Erreur : Probleme avec les images de SolveIt";

    private static String imgSplash;
    private static String imgLogo;
    private boolean check;

    /**
     * Constructeur de la classe
     */
    public Recup_path_files() {
        this.imgSplash = null;
        this.imgLogo = null;
        this.check = true;
        readFile();
        if (this.check == false) {
            System.out.println("Probleme avec le fichier dataNameFile...");
            JOptionPane.showMessageDialog(null, ERR_IMG, "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Recupère les propriétés du fichier NAME_IMG_FILE et mets à jour isCheck
     * si probleme
     */
    private void readFile() {
        Properties properties = new Properties();
        String s = null;
        try {
            Path currentRelativePath = Paths.get("");
            s = currentRelativePath.toAbsolutePath().toString() + this.PATHIMG;
            FileInputStream data = new FileInputStream((s + this.NAME_IMG_FILE));
            properties.load(data);
            data.close();
        } catch (IOException ex) {
            this.check = false;
            ex.printStackTrace();
        }
        if (this.check) {
            String tmp = properties.getProperty("imgSplash", UNKNOW);
            this.check = tmp.equals(UNKNOW);
            if (this.check == false) {
                this.imgSplash = s + tmp;
                File test = new File(this.imgSplash);
                this.check = test.exists();
            } else {
                this.check = false;
            }
            if (this.check) {
                tmp = properties.getProperty("imgLogo", UNKNOW);
                this.check = tmp.equals(UNKNOW);
                if (this.check == false) {
                    this.imgLogo = s + tmp;
                    File test2 = new File(this.imgLogo);
                    this.check = test2.exists();
                } else {
                    this.check = false;
                }
            }
        }
    }

    /**
     * Retourne un élément de ressources
     *
     * @return le chemin de l'image du Splash Screnn
     */
    public static String getImgSplash() {
        if (imgSplash == null) {
            new Recup_path_files();
        }
        return imgSplash;
    }

    /**
     * Retourne un element�ment de ressources
     *
     * @return le chemin de l'image du logo
     */
    public static String getImgLogo() {
        if (imgLogo == null) {
            new Recup_path_files();
        }
        return imgLogo;
    }

    /**
     *
     */
    @Override
    public void finalize() {
        imgSplash = null;
        imgLogo = null;
        try {
            super.finalize();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return isCheck : true si aucun pb avec les fichiers images sinon false
     */
    public boolean isCheck() {
        return check;
    }

}
