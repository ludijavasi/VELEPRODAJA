package kontroler;

import java.sql.SQLException;

import dao.DAOArtikli;
import model.Artikli;


public class Kontroler {
	
	public static Kontroler kontroler;

	private Kontroler() {
	}

	public static Kontroler getInstance() {
		if (kontroler == null)
			kontroler = new Kontroler();
		return kontroler;
	}
	
	public  int insertArikli(Artikli a) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
		return da.insertArtikli(a);
	}



}
