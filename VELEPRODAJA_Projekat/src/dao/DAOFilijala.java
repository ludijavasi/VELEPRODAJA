package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Filijala;

public class DAOFilijala {
	
	private Connection konekcija = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		konekcija = DriverManager.getConnection("jdbc:mysql://localhost/veleprodaja", "root", "");
	}

	public ArrayList<Filijala> getFilijala() throws ClassNotFoundException, SQLException {
		ArrayList<Filijala> lista = new ArrayList<Filijala>();

		connect();
		preparedStatement = konekcija.prepareStatement("select * from filijala");

		preparedStatement.execute();
		rs = preparedStatement.getResultSet();

		while (rs.next()) {
			int idFilijale = rs.getInt("id_filijale");			
			String adresaFilijale = rs.getString("adresa_filijale");
			String gradOpstinaFilijale = rs.getString("grad_opstina_filijale");
			String telefonFilijale = rs.getString("telefon_filijale");
			String emailFilijale = rs.getString("e_mail_filijale");
			int pibFilijale = rs.getInt("pib_filijale");
			String tekuciRacunFilijale = rs.getString("tekuci_racun_filijale");
			String status = rs.getString("status");	
						

			Filijala f = new Filijala(adresaFilijale, gradOpstinaFilijale, telefonFilijale, emailFilijale, pibFilijale, tekuciRacunFilijale, status);

			lista.add(f);
		}
		konekcija.close();
		return lista;
	}

	public void insertFilijala(Filijala f) throws SQLException, ClassNotFoundException {
		connect();
		
		preparedStatement = konekcija
				.prepareStatement("INSERT INTO filijala (adresa_filijale, grad_opstina_filijale, telefon_filijale, "
		                           +" e_mail_filijale, pib_filijale, tekuci_racun_filijale, status)"
						           +" VALUES (?, ?, ?, ?, ?, ?, ?)");

		preparedStatement.setString(1, f.getAdresaFilijale());
		preparedStatement.setString(2, f.getGradOpstinaFilijale());
		preparedStatement.setString(3, f.getTelefonFilijale());
		preparedStatement.setString(4, f.getEmailFilijale());
		preparedStatement.setInt(5, f.getPibFilijale());
		preparedStatement.setString(6, f.getTekuciRacunFilijale());
		preparedStatement.setString(7, f.getStatus());
		
		preparedStatement.execute();

		konekcija.close();
		
	}

}
