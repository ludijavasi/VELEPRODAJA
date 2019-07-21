package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Magacin;

public class DAOMagacin {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Magacin> getMagacin() throws ClassNotFoundException, SQLException {
		ArrayList<Magacin> lista = new ArrayList<Magacin>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from magacin");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idMagacina = rs.getInt("id_magacina");			
			String adresaMagacina = rs.getString("adresa_magacina");
			String gradOpstinaMagacina = rs.getString("grad_opstina_magacina");			
			String telefonMagacina = rs.getString("telefon_magacina");
			String emailMagacina = rs.getString("e_mail_magacina");
			
			Magacin m = new Magacin(idMagacina, adresaMagacina, gradOpstinaMagacina, telefonMagacina, emailMagacina);			

			lista.add(m);
		}		
		
		konekcija.close();		
		
		return lista;
	}

	public void insertMagacin(Magacin m) throws SQLException, ClassNotFoundException {
		connect();		

		preparedStatement = konekcija
				.prepareStatement("INSERT INTO magacin (adresa_magacina, grad_opstina_magacina, telefon_magacina,e_mail_magacina) VALUES (?, ?, ?, ?)");

		preparedStatement.setString(1, m.getAdresaMagacina());
		preparedStatement.setString(2, m.getGradOpstinaMagacina());
		preparedStatement.setString(3, m.getTelefonMagacina());
		preparedStatement.setString(4, m.getEmailMagacina());		

		preparedStatement.execute();
		
		
	}	

}