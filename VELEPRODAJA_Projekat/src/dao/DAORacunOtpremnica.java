package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.RacunOtpremnica;

public class DAORacunOtpremnica {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<RacunOtpremnica> getRacun() throws ClassNotFoundException, SQLException {
		ArrayList<RacunOtpremnica> lista = new ArrayList<RacunOtpremnica>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from racun_otpremnica");
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idRacuna = rs.getInt("id_racuna");
			int idZaposlenog = rs.getInt("id_zaposlenog");
			int idKupca = rs.getInt("id_kupca");
			Date datumRacuna = rs.getDate("datum_racuna");
			Date datumNaplateRacuna = rs.getDate("datum_naplate_racuna");
			double poreskaOsnovica = rs.getFloat("poreska_osnovica_racuna");
			double ukupnoPdv = rs.getFloat("ukupna_vrednost_obracunatog_pdv_a_racuna");
			double ukupnaVrednostRacuna = rs.getFloat("ukupna_vrednost_racuna");
			RacunOtpremnica ro = new RacunOtpremnica(idRacuna, idZaposlenog, idKupca, datumRacuna, datumNaplateRacuna, poreskaOsnovica, ukupnoPdv, ukupnaVrednostRacuna);

			lista.add(ro);
		}
		konekcija.close();
		return lista;

	}

}
