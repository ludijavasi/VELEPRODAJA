package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Artikli;

public class JTableModelCenaArtikla extends AbstractTableModel {
	
	ArrayList<Artikli> lista = new ArrayList<Artikli>();

	public JTableModelCenaArtikla(ArrayList<Artikli> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
