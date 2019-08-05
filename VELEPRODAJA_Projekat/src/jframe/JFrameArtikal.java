package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.GlavnaGrupa;
import model.Grupa_Artikla;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JFrameArtikal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNazivArtikla;
	private JTextField textFieldNetoCenaArtikla;
	private JTextField textFieldMarza;
	private JTextField textFieldIDArtikla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikal frame = new JFrameArtikal();
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
	public JFrameArtikal() {
		setTitle("ARTIKAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelArtikal = new JPanel();
		panelArtikal.setBorder(
				new TitledBorder(null, "Podaci o artiklu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelArtikal.setBounds(30, 11, 420, 166);
		contentPane.add(panelArtikal);
		panelArtikal.setLayout(null);

		JLabel lblNazivArtikla = new JLabel("Naziv artikla :");
		lblNazivArtikla.setBounds(31, 49, 80, 14);
		panelArtikal.add(lblNazivArtikla);

		JLabel lblJedinicaMere = new JLabel("Jedinica mere :");
		lblJedinicaMere.setBounds(31, 79, 107, 14);
		panelArtikal.add(lblJedinicaMere);

		JLabel lblGrupaArtikla = new JLabel("Grupa Artikla :");
		lblGrupaArtikla.setBounds(31, 24, 128, 14);
		panelArtikal.add(lblGrupaArtikla);

		textFieldNazivArtikla = new JTextField();
		textFieldNazivArtikla.setBounds(200, 49, 199, 20);
		panelArtikal.add(textFieldNazivArtikla);
		textFieldNazivArtikla.setColumns(10);

		JComboBox comboBoxJedinicaMere = new JComboBox();
		comboBoxJedinicaMere
				.setModel(new DefaultComboBoxModel(new String[] {"Kilogram", "Gram", "Litar", "Komad"}));
		comboBoxJedinicaMere.setBounds(200, 76, 199, 20);
		panelArtikal.add(comboBoxJedinicaMere);
		comboBoxJedinicaMere.setSelectedItem(null);

		JLabel lblIdArtikla = new JLabel("ID artikla :");
		lblIdArtikla.setBounds(31, 124, 80, 14);
		panelArtikal.add(lblIdArtikla);

		textFieldIDArtikla = new JTextField();
		textFieldIDArtikla.setBounds(200, 121, 64, 20);
		panelArtikal.add(textFieldIDArtikla);
		textFieldIDArtikla.setColumns(10);

		JComboBox comboBoxGrupaArtikla = new JComboBox();
		comboBoxGrupaArtikla.setBounds(200, 21, 199, 20);
		panelArtikal.add(comboBoxGrupaArtikla);
		popuniComboBoxGlavnaGrupaArtikala(comboBoxGrupaArtikla);
		comboBoxGrupaArtikla.setSelectedItem(null);

		JPanel panelEkonomskiPodaciOArtiklu = new JPanel();
		panelEkonomskiPodaciOArtiklu.setBorder(new TitledBorder(null, "Ekonomski podaci o artiklu",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEkonomskiPodaciOArtiklu.setBounds(30, 188, 420, 102);
		contentPane.add(panelEkonomskiPodaciOArtiklu);
		panelEkonomskiPodaciOArtiklu.setLayout(null);

		JLabel lblMarza = new JLabel("Marza :");
		lblMarza.setBounds(10, 72, 107, 14);
		panelEkonomskiPodaciOArtiklu.add(lblMarza);

		JLabel lblStopaPdva = new JLabel("Stopa PDV-a :");
		lblStopaPdva.setBounds(10, 47, 107, 14);
		panelEkonomskiPodaciOArtiklu.add(lblStopaPdva);

		JLabel lblNetoCenaArtikla = new JLabel("Neto cena artikla :");
		lblNetoCenaArtikla.setBounds(10, 22, 128, 14);
		panelEkonomskiPodaciOArtiklu.add(lblNetoCenaArtikla);

		textFieldNetoCenaArtikla = new JTextField();
		textFieldNetoCenaArtikla.setBounds(200, 19, 198, 20);
		panelEkonomskiPodaciOArtiklu.add(textFieldNetoCenaArtikla);
		textFieldNetoCenaArtikla.setColumns(10);

		JComboBox comboBoxStopaPDV = new JComboBox();
		comboBoxStopaPDV.setModel(new DefaultComboBoxModel(new String[] {"10", "20"}));
		comboBoxStopaPDV.setBounds(200, 44, 86, 20);
		panelEkonomskiPodaciOArtiklu.add(comboBoxStopaPDV);
		comboBoxStopaPDV.setSelectedItem(null);

		textFieldMarza = new JTextField();
		textFieldMarza.setBounds(200, 69, 86, 20);
		panelEkonomskiPodaciOArtiklu.add(textFieldMarza);
		textFieldMarza.setColumns(10);

		JButton btnDodajArtikal = new JButton("Dodaj artikal");
		btnDodajArtikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String naziv = textFieldNazivArtikla.getText().trim();
					String jm = (String) comboBoxJedinicaMere.getSelectedItem();
					Grupa_Artikla ga = (Grupa_Artikla) comboBoxGrupaArtikla.getSelectedItem();
					double netocena = Double.parseDouble(textFieldNetoCenaArtikla.getText().trim());
					int stopaPdv = Integer.parseInt((String) comboBoxStopaPDV.getSelectedItem());
					double marza = Double.parseDouble(textFieldMarza.getText().trim());

					Artikli a = new Artikli(naziv, jm, netocena, stopaPdv, marza);

					Kontroler.getInstance().insertArikli(a);
					JOptionPane.showMessageDialog(null, "Uspesno ste uneli artikal");

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnDodajArtikal.setBounds(478, 35, 146, 23);
		contentPane.add(btnDodajArtikal);

		JButton btnObrisiArtikal = new JButton("Obrisi artikal");
		btnObrisiArtikal.setBounds(478, 76, 146, 23);
		contentPane.add(btnObrisiArtikal);

		JButton btnAzuriraj = new JButton("Azuriraj");
		btnAzuriraj.setBounds(478, 120, 146, 23);
		contentPane.add(btnAzuriraj);

		JButton btnPonistiAkciju = new JButton("Ponisti akciju");
		btnPonistiAkciju.setBounds(478, 165, 146, 23);
		contentPane.add(btnPonistiAkciju);
	}
	
	private void popuniComboBoxGlavnaGrupaArtikala(JComboBox<GlavnaGrupa> comboBox) {
		try {
			ArrayList<GlavnaGrupa> lista = Kontroler.getInstance().getGlavnaGrupaArtikala();

			for (GlavnaGrupa gg : lista) {
				comboBox.addItem(gg);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
