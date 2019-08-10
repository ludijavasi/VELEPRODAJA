package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Artikli;
import model.GrupaArtikala;
import model.Magacin;

public class JTableModelArtikal extends AbstractTableModel{
	
	ArrayList<Artikli> lista = new ArrayList<Artikli>();

	public JTableModelArtikal(ArrayList<Artikli> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 7;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}	

	@Override
	public Object getValueAt(int r, int c) {
		//Artikli a = new Artikli();
		Artikli a = lista.get(r);
		
		switch (c) {
		case 0:
			return a.getIdArtikla();
		case 1:
			return a.getIdgrupaArtikla();
		case 2:
			return a.getNaziv_artikla();
		case 3:
			return a.getJedinica_mere();
		case 4:
			return a.getNeto_cena_artikla();
		case 5:
			return a.getStopa_PDV();
		case 6:
			return a.getMarza_artikla();
		default:
			return "Greska!";
		}
	}
	
	@Override
	public String getColumnName(int c) {
		switch (c) {
		case 0:
			return "ID artikla";
		case 1:
			return "ID grupe artikala";
		case 2:
			return "Naziv artikla";
		case 3:
			return "Jedinica mere";
		case 4:
			return "Neto cena artikla";
		case 5:
			return "PDV";
		case 6:
			return "Marza";
			
		default:
			return "Greska!";
		}
	}

	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}

}
