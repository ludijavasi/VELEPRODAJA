package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.RacunOtpremnica;

public class JTableModelRacunOtpremnica extends AbstractTableModel{
	
	ArrayList<RacunOtpremnica> lista = new ArrayList<>();
	
	public JTableModelRacunOtpremnica(ArrayList<RacunOtpremnica> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 8;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		RacunOtpremnica ro = lista.get(r);
		switch (c) {
		case 0:
			return ro.getIdRacuna();
		case 1:
			return ro.getKupac().getNazivFirmeKupca();
		case 2:
			return ro.getArtikal().getNaziv_artikla();
		case 3:
			return ro.getDatumRacuna();
		case 4:
			return ro.getDatumNaplateRacuna();
		case 5:
			return ro.getPoreskaOsnovicaRacuna();
		case 6:
			return ro.getUkupanIznosObracunatogPdvaRacuna();
		case 7:
			return ro.getUkupnaVrednostRacuna();	

		default:
			return "Greska";
		}
		
	}
	
	@Override
	public String getColumnName(int c) {
		
		switch (c) {
		case 0:
			return "Broj racuna";
		case 1:
			return "Naziv firme kupca";
		case 2:
			return "Naziv artikla";
		case 3:
			return "Datum racuna";
		case 4:
			return "Datum naplate racuna";
		case 5:
			return "Poreska osnovica";
		case 6:
			return "Ukupna vrednost obra;unatog PDV-a";
		case 7:
			return "Ukupna vrednost racuna";	

		default:
			return "Greska";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}

}
