package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import model.Kupac;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class JFrameKupac extends JFrame {

	private JPanel contentPane;
	private JTextField textNazivFirme;
	private JTextField textAdresaFirme;
	private JTextField textGradOpstinaFirme;
	private JTextField textTelefonFirme;
	private JPanel panelPoslovniPodaciKupca;
	private JLabel lblPib;
	private JTextField textPibKupca;
	private JLabel lblTekucracunKupca;
	private JLabel lblValutaPlacanja;
	private JLabel lblStatusKupca;
	private JTextField textTekuciRacunKupca;
	private JComboBox comboBoxValutaPlacanja;
	private JLabel lblIdKupca;
	private JTextField textFieldIdKupca;
	private JButton btnDodajKupca;
	private JButton btnObrisiKupca;
	private JButton btnAzurirajKupca;
	private JButton btnPonistiAkcijuKupac;
	private JTextField textEMailKipca;
	private JLabel lblDana;
	private JTextField textFieldKontakOsobaKupca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameKupac frame = new JFrameKupac();
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
	public JFrameKupac() {
		setTitle("KUPAC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelPodacioKupcu = new JPanel();
		panelPodacioKupcu.setBorder(
				new TitledBorder(null, "Podaci o kupcu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodacioKupcu.setBounds(10, 11, 242, 202);
		contentPane.add(panelPodacioKupcu);
		panelPodacioKupcu.setLayout(null);

		JLabel lblNazivFirme = new JLabel("Naziv firme :");
		lblNazivFirme.setBounds(10, 14, 82, 14);
		panelPodacioKupcu.add(lblNazivFirme);

		JLabel lblAdresaFirme = new JLabel("Adresa firme :");
		lblAdresaFirme.setBounds(10, 45, 82, 14);
		panelPodacioKupcu.add(lblAdresaFirme);

		JLabel lblGradOpstina = new JLabel("Grad/Opstina");
		lblGradOpstina.setBounds(10, 76, 82, 14);
		panelPodacioKupcu.add(lblGradOpstina);

		JLabel lblTelefonFirme = new JLabel("Telefon :");
		lblTelefonFirme.setBounds(10, 107, 82, 14);
		panelPodacioKupcu.add(lblTelefonFirme);

		JLabel lblKontakOsobaFirme = new JLabel("Kontakt osoba :");
		lblKontakOsobaFirme.setBounds(10, 172, 82, 14);
		panelPodacioKupcu.add(lblKontakOsobaFirme);

		textNazivFirme = new JTextField();
		textNazivFirme.setBounds(102, 11, 121, 20);
		panelPodacioKupcu.add(textNazivFirme);
		textNazivFirme.setColumns(10);

		textAdresaFirme = new JTextField();
		textAdresaFirme.setBounds(102, 42, 121, 20);
		panelPodacioKupcu.add(textAdresaFirme);
		textAdresaFirme.setColumns(10);

		textGradOpstinaFirme = new JTextField();
		textGradOpstinaFirme.setBounds(99, 73, 124, 20);
		panelPodacioKupcu.add(textGradOpstinaFirme);
		textGradOpstinaFirme.setColumns(10);

		textTelefonFirme = new JTextField();
		textTelefonFirme.setBounds(102, 104, 121, 20);
		panelPodacioKupcu.add(textTelefonFirme);
		textTelefonFirme.setColumns(10);

		JLabel lblEMail = new JLabel("E - mail :");
		lblEMail.setBounds(10, 138, 58, 14);
		panelPodacioKupcu.add(lblEMail);

		textEMailKipca = new JTextField();
		textEMailKipca.setBounds(102, 135, 121, 20);
		panelPodacioKupcu.add(textEMailKipca);
		textEMailKipca.setColumns(10);
		
		textFieldKontakOsobaKupca = new JTextField();
		textFieldKontakOsobaKupca.setBounds(102, 166, 121, 20);
		panelPodacioKupcu.add(textFieldKontakOsobaKupca);
		textFieldKontakOsobaKupca.setColumns(10);

		panelPoslovniPodaciKupca = new JPanel();
		panelPoslovniPodaciKupca.setBorder(
				new TitledBorder(null, "Poslovni podaci kupca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPoslovniPodaciKupca.setBounds(262, 11, 301, 202);
		contentPane.add(panelPoslovniPodaciKupca);
		panelPoslovniPodaciKupca.setLayout(null);

		lblPib = new JLabel("PIB :");
		lblPib.setBounds(10, 34, 107, 14);
		panelPoslovniPodaciKupca.add(lblPib);

		textPibKupca = new JTextField();
		textPibKupca.setBounds(127, 31, 130, 20);
		panelPoslovniPodaciKupca.add(textPibKupca);
		textPibKupca.setColumns(10);

		lblTekucracunKupca = new JLabel("Tekuci Racun :");
		lblTekucracunKupca.setBounds(10, 65, 107, 14);
		panelPoslovniPodaciKupca.add(lblTekucracunKupca);

		lblValutaPlacanja = new JLabel("Valuta placanja :");
		lblValutaPlacanja.setBounds(10, 90, 107, 14);
		panelPoslovniPodaciKupca.add(lblValutaPlacanja);

		lblStatusKupca = new JLabel("Status :");
		lblStatusKupca.setBounds(10, 125, 46, 14);
		panelPoslovniPodaciKupca.add(lblStatusKupca);

		textTekuciRacunKupca = new JTextField();
		textTekuciRacunKupca.setBounds(127, 62, 130, 20);
		panelPoslovniPodaciKupca.add(textTekuciRacunKupca);
		textTekuciRacunKupca.setColumns(10);

		comboBoxValutaPlacanja = new JComboBox();
		comboBoxValutaPlacanja.setModel(new DefaultComboBoxModel(new String[] { "30", "60", "90", "120" }));
		comboBoxValutaPlacanja.setBounds(127, 87, 65, 20);
		panelPoslovniPodaciKupca.add(comboBoxValutaPlacanja);

		lblIdKupca = new JLabel("ID Kupca :");
		lblIdKupca.setBounds(82, 154, 78, 14);
		panelPoslovniPodaciKupca.add(lblIdKupca);

		textFieldIdKupca = new JTextField();
		textFieldIdKupca.setBounds(192, 151, 65, 20);
		panelPoslovniPodaciKupca.add(textFieldIdKupca);
		textFieldIdKupca.setColumns(10);

		JRadioButton rdbtnAktivan = new JRadioButton("Aktivan");
		rdbtnAktivan.setBounds(126, 121, 78, 23);
		panelPoslovniPodaciKupca.add(rdbtnAktivan);

		JRadioButton rdbtnNeaktivan = new JRadioButton("Neaktivan");
		rdbtnNeaktivan.setBounds(206, 121, 83, 23);
		panelPoslovniPodaciKupca.add(rdbtnNeaktivan);

		ButtonGroup status = new ButtonGroup();
		status.add(rdbtnAktivan);
		status.add(rdbtnNeaktivan);

		lblDana = new JLabel("dana");
		lblDana.setBounds(202, 90, 46, 14);
		panelPoslovniPodaciKupca.add(lblDana);

		btnDodajKupca = new JButton("Dodaj Kupca");
		btnDodajKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String naziv = textNazivFirme.getText();
					String adresa = textAdresaFirme.getText();
					String grad = textGradOpstinaFirme.getText();
					String tel = textTelefonFirme.getText();
					String email = textEMailKipca.getText();
					String kont_osoba = textFieldKontakOsobaKupca.getText();
					int pib = Integer.parseInt(textPibKupca.getText());
					String tek_racun = textTekuciRacunKupca.getText();
					int valuta = Integer.parseInt(comboBoxValutaPlacanja.getSelectedItem().toString());
					String status = "";
					if (rdbtnAktivan.isSelected()) {
						status = "Aktivan";
					} else if (rdbtnNeaktivan.isSelected()) {
						status = "Neaktivan";
					}

					Kupac k = new Kupac(naziv, adresa, grad, tel, email, kont_osoba, pib, tek_racun, valuta, status);

					Kontroler.getInstance().insertKupac(k);

					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novog kupca!");

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDodajKupca.setBounds(272, 224, 118, 23);
		contentPane.add(btnDodajKupca);

		btnObrisiKupca = new JButton("Obrisi Kupca");
		btnObrisiKupca.setBounds(134, 259, 118, 23);
		contentPane.add(btnObrisiKupca);

		btnAzurirajKupca = new JButton("Azuriraj");
		btnAzurirajKupca.setBounds(282, 258, 118, 23);
		contentPane.add(btnAzurirajKupca);

		btnPonistiAkcijuKupac = new JButton("Ponisti akciju");
		btnPonistiAkcijuKupac.setBounds(134, 224, 118, 23);
		contentPane.add(btnPonistiAkcijuKupac);
	}
}
