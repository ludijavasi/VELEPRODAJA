package report;

import java.sql.SQLException;
import java.util.List;

import kontroler.Kontroler;
import model.Izvestaj;

public class IzvestajAdmin {
	
	public List<Izvestaj> PrikaziSve(){
		
		List<Izvestaj> lista;
		
		try {
			lista = Kontroler.getInstance().getStavkeRacunaOtpremniceIzvestaj(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
