package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class JFrameFilijala extends JFrame {

	private JPanel contentPaneFilijala;
	private JTextField textNazivFilijale;
	private JTextField textAdresaFilijale;
	private JTextField textGradOpstinaFilijale;
	private JTextField textPostanskiBrojFilijale;
	private JTextField textE_MailFilijale;
	private JTextField textTelefonFilijale;
	private JPanel panelPoslovniPodaciFilijale;
	private JLabel lblPibFilijale;
	private JTextField textPibFilijale;
	private JLabel lblMaticniBrojFilijale;
	private JLabel lblTekuciRacunFilijale;
	private JTextField textMaticniBrojFilijale;
	private JTextField textTekuciRacunFilijale;
	private JLabel lblIDFilijale;
	private JTextField textIDFilijale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameFilijala frame = new JFrameFilijala();
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
	public JFrameFilijala() {
		setTitle("FILIJALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 447);
		contentPaneFilijala = new JPanel();
		contentPaneFilijala.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneFilijala);
		contentPaneFilijala.setLayout(null);

		JPanel panelPodaciOFilijali = new JPanel();
		panelPodaciOFilijali.setLayout(null);
		panelPodaciOFilijali.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o filijali",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPodaciOFilijali.setBounds(10, 11, 242, 242);
		contentPaneFilijala.add(panelPodaciOFilijali);

		JLabel labelNayivfilijale = new JLabel("Naziv filijale :");
		labelNayivfilijale.setBounds(10, 45, 82, 14);
		panelPodaciOFilijali.add(labelNayivfilijale);

		JLabel lblAdresaFilijale = new JLabel("Adresa filijale :");
		lblAdresaFilijale.setBounds(10, 70, 82, 14);
		panelPodaciOFilijali.add(lblAdresaFilijale);

		JLabel lblGradOpstinaFilijale = new JLabel("Grad/Opstina");
		lblGradOpstinaFilijale.setBounds(10, 95, 82, 14);
		panelPodaciOFilijali.add(lblGradOpstinaFilijale);

		JLabel lblPostanskiBrojFilijale = new JLabel("Postanski broj :");
		lblPostanskiBrojFilijale.setBounds(10, 123, 82, 14);
		panelPodaciOFilijali.add(lblPostanskiBrojFilijale);

		JLabel lblTelefonFilijale = new JLabel("Telefon :");
		lblTelefonFilijale.setBounds(10, 148, 82, 14);
		panelPodaciOFilijali.add(lblTelefonFilijale);

		JLabel lblE_MailFilijale = new JLabel("E-mail :");
		lblE_MailFilijale.setBounds(10, 173, 82, 14);
		panelPodaciOFilijali.add(lblE_MailFilijale);

		textNazivFilijale = new JTextField();
		textNazivFilijale.setColumns(10);
		textNazivFilijale.setBounds(102, 42, 121, 20);
		panelPodaciOFilijali.add(textNazivFilijale);

		textAdresaFilijale = new JTextField();
		textAdresaFilijale.setColumns(10);
		textAdresaFilijale.setBounds(102, 67, 121, 20);
		panelPodaciOFilijali.add(textAdresaFilijale);

		textGradOpstinaFilijale = new JTextField();
		textGradOpstinaFilijale.setColumns(10);
		textGradOpstinaFilijale.setBounds(102, 92, 124, 20);
		panelPodaciOFilijali.add(textGradOpstinaFilijale);

		textPostanskiBrojFilijale = new JTextField();
		textPostanskiBrojFilijale.setColumns(10);
		textPostanskiBrojFilijale.setBounds(102, 120, 124, 20);
		panelPodaciOFilijali.add(textPostanskiBrojFilijale);

		textE_MailFilijale = new JTextField();
		textE_MailFilijale.setColumns(10);
		textE_MailFilijale.setBounds(99, 170, 124, 20);
		panelPodaciOFilijali.add(textE_MailFilijale);

		textTelefonFilijale = new JTextField();
		textTelefonFilijale.setColumns(10);
		textTelefonFilijale.setBounds(102, 145, 121, 20);
		panelPodaciOFilijali.add(textTelefonFilijale);

		panelPoslovniPodaciFilijale = new JPanel();
		panelPoslovniPodaciFilijale.setLayout(null);
		panelPoslovniPodaciFilijale.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Poslovni podaci filijale", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPoslovniPodaciFilijale.setBounds(272, 21, 301, 232);
		contentPaneFilijala.add(panelPoslovniPodaciFilijale);

		lblPibFilijale = new JLabel("PIB :");
		lblPibFilijale.setBounds(10, 34, 107, 14);
		panelPoslovniPodaciFilijale.add(lblPibFilijale);

		textPibFilijale = new JTextField();
		textPibFilijale.setColumns(10);
		textPibFilijale.setBounds(127, 31, 130, 20);
		panelPoslovniPodaciFilijale.add(textPibFilijale);

		lblMaticniBrojFilijale = new JLabel("Maticni broj :");
		lblMaticniBrojFilijale.setBounds(10, 72, 107, 14);
		panelPoslovniPodaciFilijale.add(lblMaticniBrojFilijale);

		lblTekuciRacunFilijale = new JLabel("Tekuci Racun :");
		lblTekuciRacunFilijale.setBounds(10, 109, 107, 14);
		panelPoslovniPodaciFilijale.add(lblTekuciRacunFilijale);

		textMaticniBrojFilijale = new JTextField();
		textMaticniBrojFilijale.setColumns(10);
		textMaticniBrojFilijale.setBounds(127, 69, 130, 20);
		panelPoslovniPodaciFilijale.add(textMaticniBrojFilijale);

		textTekuciRacunFilijale = new JTextField();
		textTekuciRacunFilijale.setColumns(10);
		textTekuciRacunFilijale.setBounds(127, 106, 130, 20);
		panelPoslovniPodaciFilijale.add(textTekuciRacunFilijale);

		lblIDFilijale = new JLabel("ID Filijale:");
		lblIDFilijale.setBounds(63, 140, 78, 14);
		panelPoslovniPodaciFilijale.add(lblIDFilijale);

		textIDFilijale = new JTextField();
		textIDFilijale.setColumns(10);
		textIDFilijale.setBounds(167, 137, 65, 20);
		panelPoslovniPodaciFilijale.add(textIDFilijale);

		JButton btnDodajFilijalu = new JButton("Dodaj Filijalu");
		btnDodajFilijalu.setBounds(97, 283, 118, 23);
		contentPaneFilijala.add(btnDodajFilijalu);

		JButton btnObrisiFilijalu = new JButton("Obrisi Filijalu");
		btnObrisiFilijalu.setBounds(97, 317, 118, 23);
		contentPaneFilijala.add(btnObrisiFilijalu);

		JButton btnAzurirajFilijalu = new JButton("Azuriraj");
		btnAzurirajFilijalu.setBounds(260, 283, 118, 23);
		contentPaneFilijala.add(btnAzurirajFilijalu);

		JButton btnPonistiAkcijuFilijala = new JButton("Ponisti akciju");
		btnPonistiAkcijuFilijala.setBounds(260, 317, 118, 23);
		contentPaneFilijala.add(btnPonistiAkcijuFilijala);
	}
}
