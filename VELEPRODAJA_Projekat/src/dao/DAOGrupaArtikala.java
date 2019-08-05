package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GlavnaGrupa;
import model.Grupa_Artikla;

public class DAOGrupaArtikala {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Grupa_Artikla> getGrupaArtikala(Integer id_glavne_grupe) throws ClassNotFoundException, SQLException {
		ArrayList<Grupa_Artikla> lista = new ArrayList<Grupa_Artikla>();

		connect();
		
		String select = "select * from grupa_artikala";
		if(id_glavne_grupe != null)
		{
			select += " where id_glavne_grupe=" + id_glavne_grupe.toString();
		}
		
		//preparedStatement = konekcija.prepareStatement("select * from grupa_artikala");
		preparedStatement = konekcija.prepareStatement(select);

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			
			int idGrupeArtikala = rs.getInt("id_grupe_artikala");
			int idGlavneGrupe = rs.getInt("id_glavne_grupe");			
			String nazivGrupeArtikala = rs.getString("naziv_grupe_artikla");	
			
			Grupa_Artikla ga = new Grupa_Artikla(idGrupeArtikala, idGlavneGrupe, nazivGrupeArtikala);

			lista.add(ga);
		}
		konekcija.close();
		return lista;
	}

	public void insertGrupaArtikala(Grupa_Artikla ga) throws SQLException, ClassNotFoundException {
		connect();
		
		preparedStatement = konekcija
				.prepareStatement("INSERT INTO grupa_artikala VALUES (?)");
		
		preparedStatement.setString(1, ga.getNaziv_grupe_artikla());	
		
		preparedStatement.execute();

		konekcija.close();		
	}


}
