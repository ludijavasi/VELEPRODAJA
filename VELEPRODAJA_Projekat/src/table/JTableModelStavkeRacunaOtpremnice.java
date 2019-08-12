package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.StavkeRacunaOtpremnice;

public class JTableModelStavkeRacunaOtpremnice extends AbstractTableModel {
	
		ArrayList<StavkeRacunaOtpremnice> lista = new ArrayList<>();
	
	public JTableModelStavkeRacunaOtpremnice(ArrayList<StavkeRacunaOtpremnice> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 4;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		
		StavkeRacunaOtpremnice sro = lista.get(r);
		switch (c) {
		case 0:
			return sro.getArtikal().getNaziv_artikla();
		case 1:
			return sro.getKolicinaProdaje();
		case 2:
			return sro.getArtikal().getNeto_cena_artikla();
		case 3:
			return sro.getArtikal().getStopa_PDV();	

		default:
			return "Greska";
		}
		
	}
	
	@Override
	public String getColumnName(int c) {
		
		switch (c) {
		case 0:
			return "Artikal";
		case 1:
			return "Kolicin";
		case 2:
				return "Jedinica";
		case 3:
			return "Neto cena";
		case 4:
			return "PDV";
		
		default:
			return "Greska";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}


}
