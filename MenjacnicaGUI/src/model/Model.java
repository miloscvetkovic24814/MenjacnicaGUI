package model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Model extends DefaultTableModel {	
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
