package kontroler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;

import dao.DAOArtikli;
import dao.DAOFilijala;
import dao.DAOGrupaArtikala;
import dao.DAOKupac;
import dao.DAOMagacin;
import dao.DAORacunOtpremnica;
import dao.DAOZaposleni;
import model.Artikli;
import model.Filijala;
import model.GrupaArtikala;
import model.Kupac;
import model.Magacin;
import model.RacunOtpremnica;
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
	
	public ArrayList<Artikli> getArtikli(int id_grupe_artikala) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
		ArrayList<Artikli> lista = da.getArtikli(id_grupe_artikala);
		return lista;
	}		
	
	public  void insertArikli(Artikli a) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
		da.insertArtikli(a);
	}
	
	public  Artikli getDetaljiArtikli(int ida) throws ClassNotFoundException, SQLException {
		DAOArtikli da = new DAOArtikli();
	    return da.getDetaljiArtikli(ida);
	}
	
	public void deleteArtikal(int rba) throws ClassNotFoundException, SQLException{
		DAOArtikli da = new DAOArtikli();
		da.deleteArtikal(rba);
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
	
	public  Zaposleni getDetaljiZaposleni(int idz) throws ClassNotFoundException, SQLException {
		DAOZaposleni dz = new DAOZaposleni();
	    return dz.getDetaljiZaposleni(idz);
	}	
	
	public void deleteZaposleni(int idz) throws ClassNotFoundException, SQLException{
		DAOZaposleni dz = new DAOZaposleni();
		dz.deleteZaposleni(idz);
	}
	
	public void updateZaposleni(Zaposleni z) throws ClassNotFoundException, SQLException{
		DAOZaposleni dz = new DAOZaposleni();
		dz.updateZaposleni(z);
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
	
	public void obrisiFilijalu(int rbf) throws ClassNotFoundException, SQLException{
		DAOFilijala df = new DAOFilijala();
		df.obrisiFilijalu(rbf);
	}
	
	public  Filijala getDetaljiFilijale(int idf) throws ClassNotFoundException, SQLException {
		DAOFilijala df = new DAOFilijala();
		return df.getDetaljiFilijale(idf);
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
	
	public void obrisiKupca(int idk) throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		dk.obrisiKupca(idk);
	}
	
	public Kupac getDetaljiKupca(int idk) throws ClassNotFoundException, SQLException {
		DAOKupac dk = new DAOKupac();
		return dk.getDetaljiKupca(idk);
		
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

	public void obrisiMagacin(int rbn) throws ClassNotFoundException, SQLException{
		DAOMagacin dm = new DAOMagacin();
		dm.obrisiMagacin(rbn);
	}
	public  Magacin getDetaljiMagacina(int idm) throws ClassNotFoundException, SQLException {
		DAOMagacin mg = new DAOMagacin();
		return mg.getDetaljiMagacina(idm);
	}		
	
	
	public ArrayList<GrupaArtikala> getGrupaArtikala() throws ClassNotFoundException, SQLException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		ArrayList<GrupaArtikala> lista = dga.getGrupaArtikala();
		return lista;
	}
	
	public ArrayList<GrupaArtikala> getGrupaArtikala(int id_grupe_artikla) throws ClassNotFoundException, SQLException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		ArrayList<GrupaArtikala> lista = dga.getGrupaArtikala(id_grupe_artikla);
		return lista;
	}
	
	public void insertGrupaArtikala(GrupaArtikala ga) throws SQLException, ClassNotFoundException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		dga.insertGrupaArtikala(ga);
	}	
	
	public  GrupaArtikala getDetaljiGrupaArtikala(int idga) throws ClassNotFoundException, SQLException {
		DAOGrupaArtikala dga = new DAOGrupaArtikala();
		return dga.getDetaljiGrupeArtikala(idga);
	}	
	
	public void deleteGrupaArtikala(int idga) throws ClassNotFoundException, SQLException{
		DAOGrupaArtikala dga = new DAOGrupaArtikala();		
		dga.deleteGrupaArtikala(idga);
	}
	
	public ArrayList<RacunOtpremnica> getRacun() throws ClassNotFoundException, SQLException {
		DAORacunOtpremnica dro = new DAORacunOtpremnica();
		ArrayList<RacunOtpremnica> lista = dro.getRacun();
		return lista;
	}
	public int insertRacunOtpremnicu(RacunOtpremnica ro) throws ClassNotFoundException, SQLException {
		DAORacunOtpremnica dro = new DAORacunOtpremnica();
		return dro.insertRacunOtpremnicu(ro);
	}

}
