package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		preparedStatement = konekcija.prepareStatement("SELECT naziv_artikla,kolicina_prodaje,jedinica_mere,"
				+ "neto_cena_artikla,stopa_pdv_a FROM artikal,stavke_prodaje WHERE id_racuna = ?");
		preparedStatement.setInt(1, id_racuna);
		preparedStatement.execute();

		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			String naziv = rs.getString ("naziv_artikla");			
			double kolicina_prodaje = rs.getDouble("kolicina_prodaje");	
			String jedinica_mere = rs.getString("jedinica_mere");
			double neto_cena_artikla = rs.getDouble("neto_cena_artikla");
			int stopa_PDV = rs.getInt("stopa_pdv_a");
			
			Izvestaj ga = new Izvestaj(naziv, kolicina_prodaje, jedinica_mere, neto_cena_artikla, stopa_PDV);

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}

}
