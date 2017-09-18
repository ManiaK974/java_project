package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * @author ManiaK
 *
 */
public class ListTable_model extends AbstractTableModel{
	private Object[] data;
	private String[] title;

	/**
	 * 
	 * Constructeur total d'une nouvelle instance du modèle de JTable
	 * 
	 * @param data
	 * @param title
	 */
	public ListTable_model(Object[] data, String[] title) {
		this.data = data;
		this.title = title;
	}

	public int getColumnCount() {
	      return this.title.length;
	    }

	    //Retourne le nombre de lignes
	    public int getRowCount() {
	      return this.data.length;
	    }

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}  

}
