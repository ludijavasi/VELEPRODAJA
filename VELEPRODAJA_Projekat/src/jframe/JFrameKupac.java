package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class JFrameKupac extends JFrame {

	private JPanel contentPane;
	private JTextField textNazivFirme;
	private JTextField textAdresaFirme;
	private JTextField textGradOpstinaFirme;
	private JTextField textPostansiBrojFirme;
	private JTextField textE_MailFirme;
	private JTextField textTelefonFirme;
	private JPanel panelPoslovniPodaciKupca;
	private JLabel lblPib;
	private JTextField textPibKupca;
	private JLabel lblMaticniBroj;
	private JLabel lblTekucracunKupca;
	private JLabel lblValutaPlacanja;
	private JLabel lblStatusKupca;
	private JCheckBox chckbxAktivan;
	private JCheckBox chckbxInaktivan;
	private JTextField textMaticniBrojKupca;
	private JTextField textTekuciRacunKupca;
	private JComboBox comboBoxValutaPlacanja;
	private JPanel panelKontaktOsobaKupac;
	private JLabel lblImeKontakOsobeKupca;
	private JTextField textKontakOsobeKupca;
	private JLabel lblPrezimeKontaktOsobeKupca;
	private JTextField textPrezimeKontaktOsobeKupca;
	private JLabel lblTelefonKontaktOsobeKupca;
	private JTextField textTelefonKontaktOsobeKupca;
	private JLabel lblEmailKontaktOsobeKupca;
	private JTextField textEmailKontaktOsobeKupca;
	private JLabel lblIdKupca;
	private JTextField textField;
	private JButton btnDodajKupca;
	private JButton btnObrisiKupca;
	private JButton btnAzurirajKupca;
	private JButton btnPonistiAkcijuKupac;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelPodacioKupcu = new JPanel();
		panelPodacioKupcu.setBorder(
				new TitledBorder(null, "Podaci o kupcu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodacioKupcu.setBounds(10, 11, 242, 242);
		contentPane.add(panelPodacioKupcu);
		panelPodacioKupcu.setLayout(null);

		JLabel lblNazivFirme = new JLabel("Naziv firme :");
		lblNazivFirme.setBounds(10, 45, 82, 14);
		panelPodacioKupcu.add(lblNazivFirme);

		JLabel lblAdresaFirme = new JLabel("Adresa firme :");
		lblAdresaFirme.setBounds(10, 70, 82, 14);
		panelPodacioKupcu.add(lblAdresaFirme);

		JLabel lblGradOpstina = new JLabel("Grad/Opstina");
		lblGradOpstina.setBounds(10, 95, 82, 14);
		panelPodacioKupcu.add(lblGradOpstina);

		JLabel lblPostanskiBroj = new JLabel("Postanski broj :");
		lblPostanskiBroj.setBounds(10, 123, 82, 14);
		panelPodacioKupcu.add(lblPostanskiBroj);

		JLabel lblTelefonFirme = new JLabel("Telefon firme :");
		lblTelefonFirme.setBounds(10, 148, 82, 14);
		panelPodacioKupcu.add(lblTelefonFirme);

		JLabel lblEmailFirme = new JLabel("E-mail :");
		lblEmailFirme.setBounds(10, 173, 82, 14);
		panelPodacioKupcu.add(lblEmailFirme);

		textNazivFirme = new JTextField();
		textNazivFirme.setBounds(102, 42, 121, 20);
		panelPodacioKupcu.add(textNazivFirme);
		textNazivFirme.setColumns(10);

		textAdresaFirme = new JTextField();
		textAdresaFirme.setBounds(102, 67, 121, 20);
		panelPodacioKupcu.add(textAdresaFirme);
		textAdresaFirme.setColumns(10);

		textGradOpstinaFirme = new JTextField();
		textGradOpstinaFirme.setBounds(102, 92, 124, 20);
		panelPodacioKupcu.add(textGradOpstinaFirme);
		textGradOpstinaFirme.setColumns(10);

		textPostansiBrojFirme = new JTextField();
		textPostansiBrojFirme.setBounds(102, 120, 124, 20);
		panelPodacioKupcu.add(textPostansiBrojFirme);
		textPostansiBrojFirme.setColumns(10);

		textE_MailFirme = new JTextField();
		textE_MailFirme.setBounds(99, 170, 124, 20);
		panelPodacioKupcu.add(textE_MailFirme);
		textE_MailFirme.setColumns(10);

		textTelefonFirme = new JTextField();
		textTelefonFirme.setBounds(102, 145, 121, 20);
		panelPodacioKupcu.add(textTelefonFirme);
		textTelefonFirme.setColumns(10);

		panelPoslovniPodaciKupca = new JPanel();
		panelPoslovniPodaciKupca.setBorder(
				new TitledBorder(null, "Poslovni podaci kupca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPoslovniPodaciKupca.setBounds(262, 11, 301, 242);
		contentPane.add(panelPoslovniPodaciKupca);
		panelPoslovniPodaciKupca.setLayout(null);

		lblPib = new JLabel("PIB :");
		lblPib.setBounds(10, 34, 107, 14);
		panelPoslovniPodaciKupca.add(lblPib);

		textPibKupca = new JTextField();
		textPibKupca.setBounds(127, 31, 130, 20);
		panelPoslovniPodaciKupca.add(textPibKupca);
		textPibKupca.setColumns(10);

		lblMaticniBroj = new JLabel("Maticni broj :");
		lblMaticniBroj.setBounds(10, 72, 107, 14);
		panelPoslovniPodaciKupca.add(lblMaticniBroj);

		lblTekucracunKupca = new JLabel("Tekuci Racun :");
		lblTekucracunKupca.setBounds(10, 109, 107, 14);
		panelPoslovniPodaciKupca.add(lblTekucracunKupca);

		lblValutaPlacanja = new JLabel("Valuta placanja :");
		lblValutaPlacanja.setBounds(10, 140, 107, 14);
		panelPoslovniPodaciKupca.add(lblValutaPlacanja);

		lblStatusKupca = new JLabel("Status :");
		lblStatusKupca.setBounds(10, 179, 46, 14);
		panelPoslovniPodaciKupca.add(lblStatusKupca);

		chckbxAktivan = new JCheckBox("Aktivan");
		chckbxAktivan.setBounds(94, 175, 78, 23);
		panelPoslovniPodaciKupca.add(chckbxAktivan);

		chckbxInaktivan = new JCheckBox("Inaktivan");
		chckbxInaktivan.setBounds(179, 175, 78, 23);
		panelPoslovniPodaciKupca.add(chckbxInaktivan);

		textMaticniBrojKupca = new JTextField();
		textMaticniBrojKupca.setBounds(127, 69, 130, 20);
		panelPoslovniPodaciKupca.add(textMaticniBrojKupca);
		textMaticniBrojKupca.setColumns(10);

		textTekuciRacunKupca = new JTextField();
		textTekuciRacunKupca.setBounds(127, 106, 130, 20);
		panelPoslovniPodaciKupca.add(textTekuciRacunKupca);
		textTekuciRacunKupca.setColumns(10);

		comboBoxValutaPlacanja = new JComboBox();
		comboBoxValutaPlacanja.setBounds(127, 137, 130, 20);
		panelPoslovniPodaciKupca.add(comboBoxValutaPlacanja);

		lblIdKupca = new JLabel("ID Kupca :");
		lblIdKupca.setBounds(63, 208, 78, 14);
		panelPoslovniPodaciKupca.add(lblIdKupca);

		textField = new JTextField();
		textField.setBounds(169, 205, 65, 20);
		panelPoslovniPodaciKupca.add(textField);
		textField.setColumns(10);

		panelKontaktOsobaKupac = new JPanel();
		panelKontaktOsobaKupac
				.setBorder(new TitledBorder(null, "Kontak osoba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelKontaktOsobaKupac.setBounds(10, 257, 242, 144);
		contentPane.add(panelKontaktOsobaKupac);
		panelKontaktOsobaKupac.setLayout(null);

		lblImeKontakOsobeKupca = new JLabel("Ime :");
		lblImeKontakOsobeKupca.setBounds(10, 32, 60, 14);
		panelKontaktOsobaKupac.add(lblImeKontakOsobeKupca);

		textKontakOsobeKupca = new JTextField();
		textKontakOsobeKupca.setBounds(107, 29, 113, 20);
		panelKontaktOsobaKupac.add(textKontakOsobeKupca);
		textKontakOsobeKupca.setColumns(10);

		lblPrezimeKontaktOsobeKupca = new JLabel("Prezime :");
		lblPrezimeKontaktOsobeKupca.setBounds(10, 57, 60, 14);
		panelKontaktOsobaKupac.add(lblPrezimeKontaktOsobeKupca);

		textPrezimeKontaktOsobeKupca = new JTextField();
		textPrezimeKontaktOsobeKupca.setBounds(107, 54, 113, 20);
		panelKontaktOsobaKupac.add(textPrezimeKontaktOsobeKupca);
		textPrezimeKontaktOsobeKupca.setColumns(10);

		lblTelefonKontaktOsobeKupca = new JLabel("Telefon :");
		lblTelefonKontaktOsobeKupca.setBounds(10, 82, 60, 14);
		panelKontaktOsobaKupac.add(lblTelefonKontaktOsobeKupca);

		textTelefonKontaktOsobeKupca = new JTextField();
		textTelefonKontaktOsobeKupca.setBounds(107, 85, 113, 20);
		panelKontaktOsobaKupac.add(textTelefonKontaktOsobeKupca);
		textTelefonKontaktOsobeKupca.setColumns(10);

		lblEmailKontaktOsobeKupca = new JLabel("E-mail :");
		lblEmailKontaktOsobeKupca.setBounds(10, 114, 60, 14);
		panelKontaktOsobaKupac.add(lblEmailKontaktOsobeKupca);

		textEmailKontaktOsobeKupca = new JTextField();
		textEmailKontaktOsobeKupca.setBounds(107, 111, 113, 20);
		panelKontaktOsobaKupac.add(textEmailKontaktOsobeKupca);
		textEmailKontaktOsobeKupca.setColumns(10);

		btnDodajKupca = new JButton("Dodaj Kupca");
		btnDodajKupca.setBounds(262, 276, 118, 23);
		contentPane.add(btnDodajKupca);

		btnObrisiKupca = new JButton("Obrisi Kupca");
		btnObrisiKupca.setBounds(262, 310, 118, 23);
		contentPane.add(btnObrisiKupca);

		btnAzurirajKupca = new JButton("Azuriraj");
		btnAzurirajKupca.setBounds(262, 344, 118, 23);
		contentPane.add(btnAzurirajKupca);

		btnPonistiAkcijuKupac = new JButton("Ponisti akciju");
		btnPonistiAkcijuKupac.setBounds(262, 378, 118, 23);
		contentPane.add(btnPonistiAkcijuKupac);
	}

}
