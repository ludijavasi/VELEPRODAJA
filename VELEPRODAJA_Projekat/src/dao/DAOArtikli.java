package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Artikli;

public class DAOArtikli {

	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Artikli> getArtikli() throws ClassNotFoundException, SQLException {
		ArrayList<Artikli> lista = new ArrayList<Artikli>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from artikli");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idArtikla = rs.getInt("id_artikla");
			int idgrupaArtikla = rs.getInt("id_grupe_artikala");
			String naziv_artikla = rs.getString("naziv_artikla");
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			double marza_artikla = rs.getDouble("marza_artikla");

			Artikli a = new Artikli(idArtikla, idgrupaArtikla, naziv_artikla, jedinica_mere, neto_cena_artikla,
					stopa_PDV, marza_artikla);
			lista.add(a);
		}
		konekcija.close();
		return lista;
	}

	public int insertArtikli(Artikli a) throws SQLException, ClassNotFoundException {
		connect();

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO artikal (naziv_arikla, jedinica_mere, neto_cena_artikla,"
						+ " stopa_pdv_a, marza_artikla) VALUES (?, ?, ?, ?, ?)");

		preparedStatement.setString(1, a.getNaziv_artikla());
		preparedStatement.setString(2, a.getJedinica_mere());
		preparedStatement.setDouble(3, a.getNeto_cena_artikla());
		preparedStatement.setInt(4, a.getStopa_PDV());
		preparedStatement.setDouble(5, a.getMarza_artikla());

		preparedStatement.execute();

		int generisanId = -1;

		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) {
			generisanId = rs.getInt(1);
		}

		konekcija.close();

		return generisanId;
	}

	/*
	 * public int insertArtikal1 (Artikli a) throws ClassNotFoundException,
	 * SQLException { connect();
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	 * 
	 * String datum = sdf.format(n.getDatum_nabavke());
	 * 
	 * preparedStatement = konekcija.prepareStatement(
	 * "insert into nabavke(datum, vrednost, status, id_prodavnice) values (?,0,'KREIRANA',?)"
	 * , Statement.RETURN_GENERATED_KEYS);
	 * 
	 * preparedStatement.setString(1, datum); //preparedStatement.setFloat(2,
	 * n.getVrednost()); preparedStatement.setInt(2, n.getPrid());
	 * 
	 * preparedStatement.execute();
	 * 
	 * int generisanId = -1;
	 * 
	 * ResultSet rs = preparedStatement.getGeneratedKeys(); if (rs.next()) {
	 * generisanId = rs.getInt(1); }
	 * 
	 * konekcija.close();
	 * 
	 * return generisanId; }
	 */

}
