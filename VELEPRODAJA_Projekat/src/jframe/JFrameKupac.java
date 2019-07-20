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
import javax.swing.JTextPane;

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
	private JCheckBox chckbxAktivan;
	private JCheckBox chckbxInaktivan;
	private JTextField textTekuciRacunKupca;
	private JComboBox comboBoxValutaPlacanja;
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
		setTitle("KUPAC");
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

		JLabel lblTelefonFirme = new JLabel("Telefon :");
		lblTelefonFirme.setBounds(10, 148, 82, 14);
		panelPodacioKupcu.add(lblTelefonFirme);

		JLabel lblKontakOsobaFirme = new JLabel("Kontakt osoba :");
		lblKontakOsobaFirme.setBounds(10, 173, 82, 14);
		panelPodacioKupcu.add(lblKontakOsobaFirme);

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

		textTelefonFirme = new JTextField();
		textTelefonFirme.setBounds(102, 145, 121, 20);
		panelPodacioKupcu.add(textTelefonFirme);
		textTelefonFirme.setColumns(10);

		JTextPane textPaneKontakOsobaFirme = new JTextPane();
		textPaneKontakOsobaFirme.setBounds(102, 173, 121, 20);
		panelPodacioKupcu.add(textPaneKontakOsobaFirme);

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

		btnDodajKupca = new JButton("Dodaj Kupca");
		btnDodajKupca.setBounds(67, 282, 118, 23);
		contentPane.add(btnDodajKupca);

		btnObrisiKupca = new JButton("Obrisi Kupca");
		btnObrisiKupca.setBounds(215, 282, 118, 23);
		contentPane.add(btnObrisiKupca);

		btnAzurirajKupca = new JButton("Azuriraj");
		btnAzurirajKupca.setBounds(358, 282, 118, 23);
		contentPane.add(btnAzurirajKupca);

		btnPonistiAkcijuKupac = new JButton("Ponisti akciju");
		btnPonistiAkcijuKupac.setBounds(225, 326, 118, 23);
		contentPane.add(btnPonistiAkcijuKupac);
	}
}
