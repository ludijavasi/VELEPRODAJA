package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filijala;
import model.GlavnaGrupa;

public class DAOGlavnaGrupaArtikala {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<GlavnaGrupa> getGlavnaGrupaArtikala() throws ClassNotFoundException, SQLException {
		ArrayList<GlavnaGrupa> lista = new ArrayList<GlavnaGrupa>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from glavna_grupa");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idGlavneGrupe = rs.getInt("id_glavne_grupe");
			String nazivGlavneGrupeArtikala = rs.getString("naziv_glavne_grupe");	
			
			GlavnaGrupa gg = new GlavnaGrupa(idGlavneGrupe, nazivGlavneGrupeArtikala);			

			lista.add(gg);
		}
		konekcija.close();
		return lista;
	}

	public void insertGlavnaGrupaArtikala(GlavnaGrupa gg) throws SQLException, ClassNotFoundException {
		connect();
		
		preparedStatement = konekcija
				.prepareStatement("INSERT INTO glavna_grupa (naziv_glavne_grupe) VALUES (?)");
		
		preparedStatement.setString(1, gg.getNaziv_glavne_grupe());	
		
		preparedStatement.execute();

		konekcija.close();		
	}

}
