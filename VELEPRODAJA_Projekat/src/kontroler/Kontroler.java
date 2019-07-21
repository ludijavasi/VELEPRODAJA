package kontroler;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOArtikli;
import dao.DAOFilijala;
import dao.DAOKupac;
import dao.DAOMagacin;
import dao.DAOZaposleni;
import dao.DAOZaposleni;
import model.Artikli;
import model.Filijala;
import model.Kupac;
import model.Magacin;
import model.Zaposleni;
import model.Zaposleni;


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
	
	public ArrayList<Zaposleni> getZaposleni() throws ClassNotFoundException, SQLException {
		DAOZaposleni dz = new DAOZaposleni();
		ArrayList<Zaposleni> lista = dz.getZaposleni();
		return lista;
	}
	
	public void insertZaposleni(Zaposleni z) throws ClassNotFoundException, SQLException {
		DAOZaposleni dz = new DAOZaposleni();
		dz.insertZaposleni(z);
	}
	
	public ArrayList<Filijala> getFilijala() throws ClassNotFoundException, SQLException {
		DAOFilijala df = new DAOFilijala();
		ArrayList<Filijala> lista = df.getFilijala();
		return lista;
	}
	
	public void insertFilijala(Filijala f) throws ClassNotFoundException, SQLException {
		DAOFilijala df = new DAOFilijala();
		df.insertFilijala(f);
	}
	
	public ArrayList<Kupac> getKupac() throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		ArrayList<Kupac> lista = dk.getKupac();
		return lista;
	}
	
	public void insertKupac(Kupac k) throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		dk.insertKupac(k);
	}
	
	public ArrayList<Magacin> getMagacin() throws ClassNotFoundException, SQLException {
		DAOMagacin dm = new DAOMagacin();
		ArrayList<Magacin> lista = dm.getMagacin();
		return lista;
	}
	
	public void insertMagacin(Magacin m) throws ClassNotFoundException, SQLException {
		DAOMagacin dm = new DAOMagacin();
		dm.insertMagacin(m);
	}



}
