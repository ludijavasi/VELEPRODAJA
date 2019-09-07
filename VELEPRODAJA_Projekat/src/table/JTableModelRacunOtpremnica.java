package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import model.Izvestaj;
import model.RacunOtpremnica;

public class JTableModelRacunOtpremnica<r> extends AbstractTableModel{
	
	ArrayList<Izvestaj> lista = new ArrayList<>();
	
	public JTableModelRacunOtpremnica(ArrayList<Izvestaj> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		
		return 12;
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
			return new Integer(r + 1);
		case 1:
			return ro.getIdArtikla();
		case 2:
			return ro.getNaziv_artikla();
		case 3:
			return ro.getKolicinaProdaje();
		case 4:
			return ro.getJedinica_mere();
		case 5:
			return ro.getNeto_cena_artikla();
		case 6:
			return ro.getRabatProdaje();
		case 7:
			return ro.getNeto_cena_artikla() - (ro.getNeto_cena_artikla()*ro.getRabatProdaje()/100);
		case 8:
			return ro.getStopa_PDV();
		case 9:
			return (ro.getNeto_cena_artikla() - (ro.getNeto_cena_artikla()*ro.getRabatProdaje()/100))
					*ro.getKolicinaProdaje();
		case 10:
			return ((ro.getNeto_cena_artikla() - (ro.getNeto_cena_artikla()*ro.getRabatProdaje()/100))
					*ro.getKolicinaProdaje())*ro.getStopa_PDV()/100;
		case 11:
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
			return "Redni broj";
		case 1:
			return "Sifra";
		case 2:
			return "Naziv Artikla";
		case 3:
			return "Kolicin";
		case 4:
			return "Jedinica";
		case 5:
			return "Cena/RSD";
		case 6:
			return "Rabat";
		case 7:
			return "Neto cena";
		case 8:
			return "PDV";
		case 9:
			return "Neto ";
		case 10:
			return "Vrednost PDV";
		case 11:
			return "Bruto";

		default:
			return "Greska";
		}		
	}
	
	public void clear() {
		lista.clear();;
		fireTableDataChanged();
	}


}
