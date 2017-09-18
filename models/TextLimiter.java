/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Classe permettant de limiter le nombre de caractères entrés dans un champ.
 *
 * @author Maniak
 */
public class TextLimiter extends PlainDocument {

    private static final long serialVersionUID = 6016644222758009922L;

    private int max;

    /**
     * Instancie un nouveau TextLimiter avec une limite 'max' caractères.
     *
     * @param max le nombre de caractères maximum.
     */
    /*
        Le reste de la Javadoc n'est pas implémenté dans cette classe.
     */
    public TextLimiter(int max) {
        super();
        this.max = max;
    }

    /**
     * Cette méthode n'est pas documentée
     *
     * @param offset int
     * @param str String
     * @param attrs AttributeSet
     * @throws BadLocationException throws
     */

    public void insertString(int offset, String str, AttributeSet attrs) throws BadLocationException {
        if (str != null && getLength() + str.length() > max) {
            Toolkit.getDefaultToolkit().beep();
        } else {
            super.insertString(offset, str, attrs);
        }
    }

    /**
     * Cette méthode n'est pas documentée
     *
     * @param offset int
     * @param length int
     * @param str String
     * @param attrs AttributeSet
     * @throws BadLocationException throws
     */
    public void replace(int offset, int length, String str, AttributeSet attrs)
            throws BadLocationException {
        if (str != null && getLength() + str.length() - length > max) {
            Toolkit.getDefaultToolkit().beep();
        } else {
            super.replace(offset, length, str, attrs);
        }
    }
}
