package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Artikli;
import model.Izvestaj;

public class DAOIzvestaj {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}
	
	public ArrayList<Izvestaj> getStavkeRacunaOtpremniceIzvestaj(int id_racuna) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT naziv_artikla,kolicina_prodaje,jedinica_mere,neto_cena_artikla, "
				+ "rabat_prodaje, stopa_pdv_a FROM stavke_prodaje "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla WHERE id_racuna = ?");
		preparedStatement.setInt(1, id_racuna);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			String naziv = rs.getString ("naziv_artikla");			
			double kolicina_prodaje = rs.getDouble("kolicina_prodaje");	
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			double rabatProdaje = rs.getDouble("rabat_prodaje");
			
			Izvestaj ga = new Izvestaj(naziv, kolicina_prodaje, jedinica_mere, neto_cena_artikla, stopa_PDV, rabatProdaje);
			
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijali(Integer id_filijale) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale, racun_otpremnica.id_racuna,datum_racuna,"
				+ "kupac.id_kupca,naziv_firme_kupca,username_zaposlenog, naziv_filijale,grupa_artikala.id_grupe_artikala,"
				+ "grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,naziv_artikla, artikal.neto_cena_artikla, "
				+ "artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje) "
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala"
				+ " WHERE filijala.id_filijale = ? "
				+ "group by stavke_prodaje.id_artikla, datum_racuna");
				
		
		// if(id_filijale > 0) { select+=" where id_filijale=" + Integer.parseInt(id_filijale.toString());
	//	 }

		/*
		 * else if(id_grupe_artikala > 0) { select+=" where id_grupe_artikala=" +
		 * id_grupe_artikala.toString(); } else if(id_artikla > 0) {
		 * select+=" where id_artikla=" + id_artikla.toString(); }
		 */
		
		
		/*
		 * preparedStatement = konekcija.
		 * prepareStatement("SELECT filijala.id_filijale, racun_otpremnica.id_racuna, "
		 * + "datum_racuna,kupac.id_kupca, naziv_firme_kupca,username_zaposlenog, " +
		 * "naziv_filijale,grupa_artikala.id_grupe_artikala, " +
		 * "grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, " +
		 * "naziv_artikla, artikal.neto_cena_artikla, artikal.marza_artikla, " +
		 * "artikal.stopa_pdv_a, SUM(kolicina_prodaje) FROM racun_otpremnica " +
		 * "join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
		 * + "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca " +
		 * "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
		 * + "join filijala on zaposleni.id_filijale = filijala.id_filijale " +
		 * "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla " +
		 * "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
		 * + "WHERE zaposleni.id_filijale = filijala.id_filijale " +
		 * "group by stavke_prodaje.id_artikla, datum_racuna");
		 */
	//	preparedStatement = konekcija.prepareStatement(1,id_filijale);
		
		preparedStatement.setInt(1,id_filijale);
		

		
		//preparedStatement.setInt(3,id_artikla);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("filijala.id_filijale");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idFilijale, idRacuna, datum_racuna, IdFirme,
					naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, 
					idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijaliPoGrupi(Integer id_filijale, Integer id_grupe_artikala) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale, racun_otpremnica.id_racuna,datum_racuna,"
				+ "kupac.id_kupca,naziv_firme_kupca,username_zaposlenog, naziv_filijale,"
				+ "grupa_artikala.id_grupe_artikala,grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,naziv_artikla, "
				+ "artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje) "
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
				+ "WHERE filijala.id_filijale = ? and grupa_artikala.id_grupe_artikala =? "
				+ "group by stavke_prodaje.id_artikla, datum_racuna");
				
		
		
	
		//preparedStatement.setInt(3,id_artikla);
		preparedStatement.setInt(1,id_filijale);
		
	    preparedStatement.setInt(2,id_grupe_artikala);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("filijala.id_filijale");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idFilijale, idRacuna, datum_racuna, IdFirme,
					naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, 
					idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoFilijaliPoGrupiPoArtiklu(Integer id_filijale, Integer id_grupe_artikala, Integer id_artikla) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT filijala.id_filijale, racun_otpremnica.id_racuna,datum_racuna,"
				+ "kupac.id_kupca,naziv_firme_kupca,username_zaposlenog, "
				+ "naziv_filijale,grupa_artikala.id_grupe_artikala,grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,"
				+ "naziv_artikla,artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, "
				+ "SUM(kolicina_prodaje) FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna"
				+ " join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join"
				+ " zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on zaposleni.id_filijale = filijala.id_filijale join"
				+ " artikal on stavke_prodaje.id_artikla = artikal.id_artikla join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala "
				+ "WHERE filijala.id_filijale = ? and grupa_artikala.id_grupe_artikala = ? and artikal.id_artikla = ? "
				+ "group by stavke_prodaje.id_artikla=artikal.id_artikla, datum_racuna");
				
		
		
	
		//preparedStatement.setInt(3,id_artikla);
		preparedStatement.setInt(1,id_filijale);
		
	    preparedStatement.setInt(2,id_grupe_artikala);
	    
	    preparedStatement.setInt(3,id_artikla);
	    
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idFilijale = rs.getInt("filijala.id_filijale");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idFilijale, idRacuna, datum_racuna, IdFirme,
					naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, 
					idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	
	public ArrayList<Izvestaj> getIzvestajProdajePoKupcu(Integer id_kupca) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
				+ "username_zaposlenog , naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, naziv_artikla,"
				+ " artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
				+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join zaposleni on "
				+ "racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on "
				+ "zaposleni.id_filijale = filijala.id_filijale join artikal on "
				+ "stavke_prodaje.id_artikla = artikal.id_artikla join "
				+ "grupa_artikala on artikal.id_grupe_artikala = "
				+ "grupa_artikala.id_grupe_artikala "
				+ "WHERE racun_otpremnica.id_kupca = kupac.id_kupca = ? "
				+ "group by stavke_prodaje.id_stavke_prodaje, datum_racuna");
		
		
		preparedStatement.setInt(1,id_kupca);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
		
		public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupi(Integer id_kupca, Integer id_grupe_artikala) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
			
			connect();
			preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
					+ "username_zaposlenog , naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, naziv_artikla,"
					+ " artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
					+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
					+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join zaposleni on "
					+ "racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on "
					+ "zaposleni.id_filijale = filijala.id_filijale join artikal on "
					+ "stavke_prodaje.id_artikla = artikal.id_artikla join "
					+ "grupa_artikala on artikal.id_grupe_artikala = "
					+ "grupa_artikala.id_grupe_artikala "
					+ "WHERE racun_otpremnica.id_kupca = kupac.id_kupca = ? and grupa_artikala.id_grupe_artikala = ? "
					+ "group by stavke_prodaje.id_stavke_prodaje, datum_racuna");
			
			
			preparedStatement.setInt(1,id_kupca);
			preparedStatement.setInt(2, id_grupe_artikala);
			
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
				Date datum_racuna = rs.getDate("datum_racuna");	
				int IdFirme = rs.getInt("kupac.id_kupca");
				String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
				String username_zaposlenog = rs.getString("username_zaposlenog");
				String naziv_filijale = rs.getString("naziv_filijale");
				String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
				int idArtikla = rs.getInt("artikal.id_artikla");
				String naziv_artikla = rs.getString("naziv_artikla");
				int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
				double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
				double marza_artikla = rs.getDouble("marza_artikla");
				double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
				
				Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
				

				lista.add(ga);
			}
			konekcija.close();
			return lista;		
	}
		
		
		public ArrayList<Izvestaj> getIzvestajProdajePoKupcuPoGrupiPoArtiklu(Integer id_kupca, Integer id_grupe_artikala, Integer id_artikla) throws ClassNotFoundException, SQLException {
			ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
			
			connect();
			preparedStatement = konekcija.prepareStatement("SELECT racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca,"
					+ "username_zaposlenog , naziv_filijale, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla, naziv_artikla,"
					+ " artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, SUM(kolicina_prodaje)"
					+ "FROM racun_otpremnica join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
					+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca join zaposleni on "
					+ "racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog join filijala on "
					+ "zaposleni.id_filijale = filijala.id_filijale join artikal on "
					+ "stavke_prodaje.id_artikla = artikal.id_artikla join "
					+ "grupa_artikala on artikal.id_grupe_artikala = "
					+ "grupa_artikala.id_grupe_artikala "
					+ "WHERE racun_otpremnica.id_kupca = kupac.id_kupca = ? and grupa_artikala.id_grupe_artikala = ? and artikal.id_artikla = ?"
					+ "group by stavke_prodaje.id_stavke_prodaje, datum_racuna");
			
			
			preparedStatement.setInt(1,id_kupca);
			preparedStatement.setInt(2, id_grupe_artikala);
			preparedStatement.setInt(3, id_artikla);
			
			preparedStatement.execute();

			rs = preparedStatement.getResultSet();

			while (rs.next()) {
				
				int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
				Date datum_racuna = rs.getDate("datum_racuna");	
				int IdFirme = rs.getInt("kupac.id_kupca");
				String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
				String username_zaposlenog = rs.getString("username_zaposlenog");
				String naziv_filijale = rs.getString("naziv_filijale");
				String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
				int idArtikla = rs.getInt("artikal.id_artikla");
				String naziv_artikla = rs.getString("naziv_artikla");
				int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
				double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
				double marza_artikla = rs.getDouble("marza_artikla");
				double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
				
				Izvestaj ga = new Izvestaj(idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, neto_cena_artikla, marza_artikla, stopa_pdv_a);
				

				lista.add(ga);
			}
			konekcija.close();
			return lista;		
	}
		
		
		
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenom(Integer id_zaposlenog) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT zaposleni.id_zaposlenog, "
				+ "zaposleni.ime_zaposlenog, zaposleni.prezime_zaposlenog,zaposleni.username_zaposlenog, "
				+ "racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca, "
				+ "naziv_filijale,grupa_artikala.id_grupe_artikala, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,"
				+ " naziv_artikla, artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, "
				+ "SUM(kolicina_prodaje) FROM racun_otpremnica "
				+ "join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala"
				+ " WHERE racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog = ?"
				+ "group by stavke_prodaje.id_artikla, "
				+ "datum_racuna");
		
		preparedStatement.setInt(1, id_zaposlenog);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idZaposlenog = rs.getInt("zaposleni.id_zaposlenog");
			String imeZaposlenog = rs.getString("zaposleni.ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("zaposleni.prezime_zaposlenog");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idZaposlenog, imeZaposlenog, prezimeZaposlenog, 
					idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, 
					naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, 
					neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenomPoGrupi(Integer id_zaposlenog, Integer id_grupe_artikala) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT zaposleni.id_zaposlenog, "
				+ "zaposleni.ime_zaposlenog, zaposleni.prezime_zaposlenog,zaposleni.username_zaposlenog, "
				+ "racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca, "
				+ "naziv_filijale,grupa_artikala.id_grupe_artikala, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,"
				+ " naziv_artikla, artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, "
				+ "SUM(kolicina_prodaje) FROM racun_otpremnica "
				+ "join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala"
				+ " WHERE racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog = ? and grupa_artikala.id_grupe_artikala = ?"
				+ "group by stavke_prodaje.id_artikla, "
				+ "datum_racuna");
		
		preparedStatement.setInt(1, id_zaposlenog);
		
		preparedStatement.setInt(2, id_grupe_artikala);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idZaposlenog = rs.getInt("zaposleni.id_zaposlenog");
			String imeZaposlenog = rs.getString("zaposleni.ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("zaposleni.prezime_zaposlenog");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idZaposlenog, imeZaposlenog, prezimeZaposlenog, 
					idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, 
					naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, 
					neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}
	
	public ArrayList<Izvestaj> getIzvestajProdajePoZposlenomPoGrupiPoArtiklu(Integer id_zaposlenog, Integer id_grupe_artikala, Integer id_artikla) throws ClassNotFoundException, SQLException {
		ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
		
		connect();
		preparedStatement = konekcija.prepareStatement("SELECT zaposleni.id_zaposlenog, "
				+ "zaposleni.ime_zaposlenog, zaposleni.prezime_zaposlenog,zaposleni.username_zaposlenog, "
				+ "racun_otpremnica.id_racuna, datum_racuna,kupac.id_kupca, naziv_firme_kupca, "
				+ "naziv_filijale,grupa_artikala.id_grupe_artikala, grupa_artikala.naziv_grupe_artikala,artikal.id_artikla,"
				+ " naziv_artikla, artikal.neto_cena_artikla, artikal.marza_artikla, artikal.stopa_pdv_a, "
				+ "SUM(kolicina_prodaje) FROM racun_otpremnica "
				+ "join stavke_prodaje on racun_otpremnica.id_racuna = stavke_prodaje.id_racuna "
				+ "join kupac on racun_otpremnica.id_kupca = kupac.id_kupca "
				+ "join zaposleni on racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog "
				+ "join filijala on zaposleni.id_filijale = filijala.id_filijale "
				+ "join artikal on stavke_prodaje.id_artikla = artikal.id_artikla "
				+ "join grupa_artikala on artikal.id_grupe_artikala = grupa_artikala.id_grupe_artikala"
				+ " WHERE racun_otpremnica.id_zaposlenog = zaposleni.id_zaposlenog = ? and grupa_artikala.id_grupe_artikala = ? and artikal.id_artikla = ?"
				+ "group by stavke_prodaje.id_artikla, "
				+ "datum_racuna");
		
		preparedStatement.setInt(1, id_zaposlenog);
		
		preparedStatement.setInt(2, id_grupe_artikala);
		
		preparedStatement.setInt(3, id_artikla);
		
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idZaposlenog = rs.getInt("zaposleni.id_zaposlenog");
			String imeZaposlenog = rs.getString("zaposleni.ime_zaposlenog");
			String prezimeZaposlenog = rs.getString("zaposleni.prezime_zaposlenog");
			int idRacuna = rs.getInt ("racun_otpremnica.id_racuna");
			Date datum_racuna = rs.getDate("datum_racuna");	
			int IdFirme = rs.getInt("kupac.id_kupca");
			String naziv_firme_kupca = rs.getString("naziv_firme_kupca");
			String username_zaposlenog = rs.getString("username_zaposlenog");
			String naziv_filijale = rs.getString("naziv_filijale");
			String grupa_artikala = rs.getString("grupa_artikala.naziv_grupe_artikala");
			int idArtikla = rs.getInt("artikal.id_artikla");
			String naziv_artikla = rs.getString("naziv_artikla");
			int koicina_prodaje = rs.getInt("SUM(kolicina_prodaje)");
			double neto_cena_artikla = rs.getDouble("artikal.neto_cena_artikla");
			double marza_artikla = rs.getDouble("marza_artikla");
			double stopa_pdv_a = rs.getDouble("artikal.stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(idZaposlenog, imeZaposlenog, prezimeZaposlenog, 
					idRacuna, datum_racuna, IdFirme, naziv_firme_kupca, username_zaposlenog, 
					naziv_filijale, grupa_artikala, idArtikla, naziv_artikla, koicina_prodaje, 
					neto_cena_artikla, marza_artikla, stopa_pdv_a);
			

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}


}
