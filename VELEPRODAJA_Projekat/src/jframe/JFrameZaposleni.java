package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.color.CMMException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Filijala;
import model.Magacin;
import model.Zaposleni;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class JFrameZaposleni extends JFrame {

	private JPanel contentPaneDodajZaposlenog;
	private JTextField textIme;
	private JLabel lblPrezime;
	private JTextField textPrezime;
	private JLabel lblAdresa;
	private JTextField textAdresa;
	private JLabel lblGradostina;
	private JTextField textGrad_Ostina;
	private JPanel panelPodacioZaposlenju;
	private JLabel lblStrucnaSprema;
	private JComboBox comboBoxStrucnaSprema;
	private JLabel lblDatumPocetkaZaposlenja;
	private JLabel lblDatumPrestankaZaposlenja;
	private JLabel lblFilijalaPosla;
	private JComboBox comboBoxFilijalaPosla;
	private JLabel lblPlata;
	private JTextField textPlata;
	private JLabel lblTipZaposlenja;
	private JComboBox comboBoxTipZaposlenja;
	private JPanel panel;
	private JLabel lblUsername;
	private JTextField textUsername;
	private JLabel lblPassword;
	private JTextField textPassword;
	private JButton btnPonistiAkciju;
	private JLabel lblIdZaposlenog;
	private JTextField textIDZaposlenog;
	private JPanel panelPodaciOPosluZaposleni;
	private JTextField textTelefon;
	private JTextField textEMail;
	
	private JDateChooser dateChooserDatumZaposlenja;
	private JDateChooser dateChooserPrestankaZaposlenja;
	
	private JButton btnDodajZaposlenog;
	private JButton btnObrisiZaposlenog;
	
	

	public JButton getBtnDodajZaposlenog() {
		return btnDodajZaposlenog;
	}

	public void setBtnDodajZaposlenog(JButton btnDodajZaposlenog) {
		this.btnDodajZaposlenog = btnDodajZaposlenog;
	}	
	

	public JTextField getTextIme() {
		return textIme;
	}

	public void setTextIme(JTextField textIme) {
		this.textIme = textIme;
	}

	public JTextField getTextPrezime() {
		return textPrezime;
	}

	public void setTextPrezime(JTextField textPrezime) {
		this.textPrezime = textPrezime;
	}

	public JTextField getTextAdresa() {
		return textAdresa;
	}

	public void setTextAdresa(JTextField textAdresa) {
		this.textAdresa = textAdresa;
	}

	public JTextField getTextGrad_Ostina() {
		return textGrad_Ostina;
	}

	public void setTextGrad_Ostina(JTextField textGrad_Ostina) {
		this.textGrad_Ostina = textGrad_Ostina;
	}

	public JComboBox getComboBoxStrucnaSprema() {
		return comboBoxStrucnaSprema;
	}

	public void setComboBoxStrucnaSprema(JComboBox comboBoxStrucnaSprema) {
		this.comboBoxStrucnaSprema = comboBoxStrucnaSprema;
	}

	public JComboBox getComboBoxFilijalaPosla() {
		return comboBoxFilijalaPosla;
	}

	public void setComboBoxFilijalaPosla(JComboBox comboBoxFilijalaPosla) {
		this.comboBoxFilijalaPosla = comboBoxFilijalaPosla;
	}

	public JTextField getTextPlata() {
		return textPlata;
	}

	public void setTextPlata(JTextField textPlata) {
		this.textPlata = textPlata;
	}

	public JComboBox getComboBoxTipZaposlenja() {
		return comboBoxTipZaposlenja;
	}

	public void setComboBoxTipZaposlenja(JComboBox comboBoxTipZaposlenja) {
		this.comboBoxTipZaposlenja = comboBoxTipZaposlenja;
	}

	public JTextField getTextUsername() {
		return textUsername;
	}

	public void setTextUsername(JTextField textUsername) {
		this.textUsername = textUsername;
	}

	public JTextField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(JTextField textPassword) {
		this.textPassword = textPassword;
	}

	public JTextField getTextIDZaposlenog() {
		return textIDZaposlenog;
	}

	public void setTextIDZaposlenog(JTextField textIDZaposlenog) {
		this.textIDZaposlenog = textIDZaposlenog;
	}

	public JTextField getTextTelefon() {
		return textTelefon;
	}

	public void setTextTelefon(JTextField textTelefon) {
		this.textTelefon = textTelefon;
	}

	public JTextField getTextEMail() {
		return textEMail;
	}

	public void setTextEMail(JTextField textEMail) {
		this.textEMail = textEMail;
	}	
	

	public JDateChooser getDateChooserDatumZaposlenja() {
		return dateChooserDatumZaposlenja;
	}

	public void setDateChooserDatumZaposlenja(JDateChooser dateChooserDatumZaposlenja) {
		this.dateChooserDatumZaposlenja = dateChooserDatumZaposlenja;
	}

	public JDateChooser getDateChooserPrestankaZaposlenja() {
		return dateChooserPrestankaZaposlenja;
	}

	public void setDateChooserPrestankaZaposlenja(JDateChooser dateChooserPrestankaZaposlenja) {
		this.dateChooserPrestankaZaposlenja = dateChooserPrestankaZaposlenja;
	}	

	public JButton getBtnPonistiAkciju() {
		return btnPonistiAkciju;
	}

	public void setBtnPonistiAkciju(JButton btnPonistiAkciju) {
		this.btnPonistiAkciju = btnPonistiAkciju;
	}	

	public JButton getBtnObrisiZaposlenog() {
		return btnObrisiZaposlenog;
	}

	public void setBtnObrisiZaposlenog(JButton btnObrisiZaposlenog) {
		this.btnObrisiZaposlenog = btnObrisiZaposlenog;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameZaposleni frame = new JFrameZaposleni();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameZaposleni() {
		setTitle("ZAPOSLENI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 503);
		contentPaneDodajZaposlenog = new JPanel();
		contentPaneDodajZaposlenog.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneDodajZaposlenog);
		contentPaneDodajZaposlenog.setLayout(null);

		JPanel panelLicnipodaci = new JPanel();
		panelLicnipodaci
				.setBorder(new TitledBorder(null, "Licni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLicnipodaci.setBounds(10, 11, 265, 226);
		contentPaneDodajZaposlenog.add(panelLicnipodaci);
		panelLicnipodaci.setLayout(null);

		JLabel lblIme = new JLabel("Ime :");
		lblIme.setBounds(10, 30, 46, 14);
		panelLicnipodaci.add(lblIme);

		textIme = new JTextField();
		textIme.setBounds(102, 27, 134, 20);
		panelLicnipodaci.add(textIme);
		textIme.setColumns(10);

		lblPrezime = new JLabel("Prezime :");
		lblPrezime.setBounds(10, 67, 61, 14);
		panelLicnipodaci.add(lblPrezime);

		textPrezime = new JTextField();
		textPrezime.setBounds(102, 58, 134, 20);
		panelLicnipodaci.add(textPrezime);
		textPrezime.setColumns(10);

		lblAdresa = new JLabel("Adresa :");
		lblAdresa.setBounds(10, 104, 61, 14);
		panelLicnipodaci.add(lblAdresa);

		textAdresa = new JTextField();
		textAdresa.setBounds(102, 95, 134, 20);
		panelLicnipodaci.add(textAdresa);
		textAdresa.setColumns(10);

		lblGradostina = new JLabel("Grad/Ostina :");
		lblGradostina.setBounds(10, 136, 82, 14);
		panelLicnipodaci.add(lblGradostina);

		textGrad_Ostina = new JTextField();
		textGrad_Ostina.setBounds(102, 133, 134, 20);
		panelLicnipodaci.add(textGrad_Ostina);
		textGrad_Ostina.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setBounds(10, 173, 82, 14);
		panelLicnipodaci.add(lblTelefon);
		
		JLabel lblEMail = new JLabel("E mail :");
		lblEMail.setBounds(10, 198, 61, 14);
		panelLicnipodaci.add(lblEMail);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(102, 164, 134, 20);
		panelLicnipodaci.add(textTelefon);
		textTelefon.setColumns(10);
		
		textEMail = new JTextField();
		textEMail.setBounds(102, 195, 134, 20);
		panelLicnipodaci.add(textEMail);
		textEMail.setColumns(10);

		panelPodacioZaposlenju = new JPanel();
		panelPodacioZaposlenju.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Podaci o zaposlenju", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPodacioZaposlenju.setBounds(295, 22, 331, 200);
		contentPaneDodajZaposlenog.add(panelPodacioZaposlenju);
		panelPodacioZaposlenju.setLayout(null);

		lblStrucnaSprema = new JLabel("Strucna sprema :");
		lblStrucnaSprema.setBounds(10, 25, 122, 14);
		panelPodacioZaposlenju.add(lblStrucnaSprema);

		comboBoxStrucnaSprema = new JComboBox();
		comboBoxStrucnaSprema.setModel(
				new DefaultComboBoxModel(new String[] { "IV stepen", "V stepen", "VI stepen", "VII stepen" }));
		comboBoxStrucnaSprema.setBounds(190, 22, 131, 20);
		panelPodacioZaposlenju.add(comboBoxStrucnaSprema);

		lblDatumPocetkaZaposlenja = new JLabel("Datum pocetka zaposlenja :");
		lblDatumPocetkaZaposlenja.setBounds(10, 63, 158, 14);
		panelPodacioZaposlenju.add(lblDatumPocetkaZaposlenja);

		lblDatumPrestankaZaposlenja = new JLabel("Datum prestanka zaposlenja :");
		lblDatumPrestankaZaposlenja.setBounds(10, 109, 175, 14);
		panelPodacioZaposlenju.add(lblDatumPrestankaZaposlenja);

		/*JCheckBox chckbxDatumPrestankaPoslaNeodredjeno = new JCheckBox("Datum prestanka posla neodredjeno");
		chckbxDatumPrestankaPoslaNeodredjeno.setBounds(10, 141, 258, 23);
		panelPodacioZaposlenju.add(chckbxDatumPrestankaPoslaNeodredjeno);*/

		dateChooserDatumZaposlenja = new JDateChooser();
		dateChooserDatumZaposlenja.setBounds(190, 63, 131, 20);
		panelPodacioZaposlenju.add(dateChooserDatumZaposlenja);

		dateChooserPrestankaZaposlenja = new JDateChooser();
		dateChooserPrestankaZaposlenja.setBounds(190, 103, 131, 20);
		panelPodacioZaposlenju.add(dateChooserPrestankaZaposlenja);		

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Korisnicki podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(295, 254, 265, 131);
		contentPaneDodajZaposlenog.add(panel);
		panel.setLayout(null);

		lblUsername = new JLabel("Username :");
		lblUsername.setBounds(10, 23, 81, 14);
		panel.add(lblUsername);

		textUsername = new JTextField();
		textUsername.setBounds(101, 20, 128, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);

		lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 62, 81, 14);
		panel.add(lblPassword);

		textPassword = new JTextField();
		textPassword.setBounds(101, 59, 128, 20);
		panel.add(textPassword);
		textPassword.setColumns(10);

		textIDZaposlenog = new JTextField();
		textIDZaposlenog.setBounds(125, 90, 86, 20);
		panel.add(textIDZaposlenog);
		textIDZaposlenog.setColumns(10);

		lblIdZaposlenog = new JLabel("ID Zaposlenog :");
		lblIdZaposlenog.setBounds(20, 93, 90, 14);
		panel.add(lblIdZaposlenog);

		JButton btnDodajZaposlenog = new JButton("Dodaj Zaposlenog");
		btnDodajZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					
					

					String ime = textIme.getText();
					String prezime = textPrezime.getText();
					String adresa = textAdresa.getText();
					String grad = textGrad_Ostina.getText();
					String tel = textTelefon.getText();
					String email = textEMail.getText();

					String username = textUsername.getText();
					String password = textPassword.getText();

					String struc_sprema = (String) comboBoxStrucnaSprema.getSelectedItem();

					Date datum_poc = dateChooserDatumZaposlenja.getDate();
					Date datum_zav = dateChooserPrestankaZaposlenja.getDate();

					// boolean datum_prest = chckbxDatumPrestankaPoslaNeodredjeno.isSelected();

				    int idfilijale = ((Filijala)comboBoxFilijalaPosla.getSelectedItem()).getIdFilijale();
					Double plata = Double.parseDouble(textPlata.getText().trim());
					String tip_zaposlenja = (String) comboBoxTipZaposlenja.getSelectedItem();

					Zaposleni z = new Zaposleni(idfilijale, ime, prezime, adresa, grad, tel, email, struc_sprema, datum_poc, datum_zav, plata, tip_zaposlenja, username, password);

					Kontroler.getInstance().insertZaposleni(z);

					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novog zaposlenog!");

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDodajZaposlenog.setBounds(295, 396, 155, 23);
		contentPaneDodajZaposlenog.add(btnDodajZaposlenog);

		btnObrisiZaposlenog = new JButton("Obrisi Zaposlenog");
		btnObrisiZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int rbz = Integer.parseInt(textIDZaposlenog.getText().trim());
				
				try {
					Kontroler.getInstance().deleteZaposleni(rbz);
					JOptionPane.showMessageDialog(null, "Uspesno ste obrisali zaposlenog!");
					
					textIme.setText("");
					textPrezime.setText("");
					textAdresa.setText("");
					textGrad_Ostina.setText("");
					textTelefon.setText("");
					textEMail.setText("");
					textUsername.setText("");
					textPassword.setText("");
					comboBoxStrucnaSprema.setSelectedItem(null);
					textPlata.setText("");
					comboBoxFilijalaPosla.setSelectedItem(null);
					comboBoxTipZaposlenja.setSelectedItem(null);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnObrisiZaposlenog.setBounds(109, 430, 155, 23);
		contentPaneDodajZaposlenog.add(btnObrisiZaposlenog);

		JButton btnAzurirajZaposlenog = new JButton("Azuriraj Zaposlenog");
		btnAzurirajZaposlenog.setBounds(295, 430, 155, 23);
		contentPaneDodajZaposlenog.add(btnAzurirajZaposlenog);

		btnPonistiAkciju = new JButton("Ponisti akciju");
		btnPonistiAkciju.setBounds(109, 396, 155, 23);
		contentPaneDodajZaposlenog.add(btnPonistiAkciju);

		panelPodaciOPosluZaposleni = new JPanel();
		panelPodaciOPosluZaposleni.setBorder(
				new TitledBorder(null, "Podaci o poslu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodaciOPosluZaposleni.setBounds(10, 248, 270, 137);
		contentPaneDodajZaposlenog.add(panelPodaciOPosluZaposleni);
		panelPodaciOPosluZaposleni.setLayout(null);

		lblFilijalaPosla = new JLabel("Filijala posla :");
		lblFilijalaPosla.setBounds(10, 29, 78, 14);
		panelPodaciOPosluZaposleni.add(lblFilijalaPosla);
        
		comboBoxFilijalaPosla = new JComboBox();
		comboBoxFilijalaPosla.setBounds(114, 26, 131, 20);
		panelPodaciOPosluZaposleni.add(comboBoxFilijalaPosla);
		popuniComboBoxFilijala(comboBoxFilijalaPosla);

		lblPlata = new JLabel("Plata :");
		lblPlata.setBounds(10, 66, 46, 14);
		panelPodaciOPosluZaposleni.add(lblPlata);

		textPlata = new JTextField();
		textPlata.setBounds(114, 57, 131, 20);
		panelPodaciOPosluZaposleni.add(textPlata);
		textPlata.setColumns(10);

		comboBoxTipZaposlenja = new JComboBox();
		comboBoxTipZaposlenja.setBounds(114, 90, 131, 20);
		panelPodaciOPosluZaposleni.add(comboBoxTipZaposlenja);
		comboBoxTipZaposlenja
				.setModel(new DefaultComboBoxModel(new String[] { "Menadzer", "Komercijalista", "Magacioner" }));

		lblTipZaposlenja = new JLabel("Tip zaposlenja :");
		lblTipZaposlenja.setBounds(10, 91, 103, 14);
		panelPodaciOPosluZaposleni.add(lblTipZaposlenja);
	}
	
	private void popuniComboBoxFilijala(JComboBox<Filijala> comboBox) {
		try {
			ArrayList<Filijala> lista = Kontroler.getInstance().getFilijala();
            
			for (Filijala f : lista) {
				
				comboBox.addItem(f);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
}
