package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Izvestaj;

public class JTableModelProdajaPoArtiklu extends AbstractTableModel {

	
	ArrayList<Izvestaj> lista = new ArrayList<>();
	
	public JTableModelProdajaPoArtiklu(ArrayList<Izvestaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 10;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		
		Izvestaj ro = lista.get(r);
		
		switch (c) {
		case 0:
			return ro.getNazivFilijale();
		case 1:
			return ro.getNaziv_artikla();
		case 2:
			return ro.getIdArtikla();
		case 3:
			return ro.getNaziv_artikla();
	/*	case 4:
			return //ro.getKolicinaProdaje();
		case 5:
			return ro.getNeto_cena_artikla();
		case 6:
			return //(ro.getNeto_cena_artikla()*ro.getKolicinaProdaje()*ro.getMarza_artikla()/100);
		case 7:
			return //(ro.getu
		*/case 8:
			return (ro.getNeto_cena_artikla() - (ro.getNeto_cena_artikla()*ro.getRabatProdaje()/100))
					*ro.getKolicinaProdaje();
		case 9:
			return ((ro.getNeto_cena_artikla() - (ro.getNeto_cena_artikla()*ro.getRabatProdaje()/100))
					*ro.getKolicinaProdaje())*ro.getStopa_PDV()/100;
		case 10:
			return ((ro.getNeto_cena_artikla() - (ro.getNeto_cena_artikla()*ro.getRabatProdaje()/100))
					*ro.getKolicinaProdaje())+
					(((ro.getNeto_cena_artikla() - (ro.getNeto_cena_artikla()*ro.getRabatProdaje()/100))
					*ro.getKolicinaProdaje())*ro.getStopa_PDV()/100);

		default:
			return "Greska";
		}
		
	}
	@Override
	public String getColumnName(int c) {
		
		switch (c) {
		case 0:
			return "FILIJALA";
		case 1:
			return "GRUPA";
		case 2:
			return "ID ARTIKLA";
		case 3:
			return "NAZIV";
		case 4:
			return "KOLICINA";
		case 5:
			return "NABAVNA CENA";
		case 6:
			return "MARZA";
		case 7:
			return "PROSECNA PRODAJNA CENA "
					+ "BEZ PDV-A";
		case 8:
			return "NABAVNA VREDNOST";
		case 9:
			return "OSNOVICA";

		default:
			return "GRESKA";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}

}
