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
import model.GrupaArtikala;

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
	private JComboBox comboBoxJedinicaMere;
	private JComboBox comboBoxGrupaArtikla;
	private JComboBox comboBoxStopaPDV;
	
	

	public JTextField getTextFieldNazivArtikla() {
		return textFieldNazivArtikla;
	}

	public void setTextFieldNazivArtikla(JTextField textFieldNazivArtikla) {
		this.textFieldNazivArtikla = textFieldNazivArtikla;
	}

	public JTextField getTextFieldNetoCenaArtikla() {
		return textFieldNetoCenaArtikla;
	}

	public void setTextFieldNetoCenaArtikla(JTextField textFieldNetoCenaArtikla) {
		this.textFieldNetoCenaArtikla = textFieldNetoCenaArtikla;
	}

	public JTextField getTextFieldMarza() {
		return textFieldMarza;
	}

	public void setTextFieldMarza(JTextField textFieldMarza) {
		this.textFieldMarza = textFieldMarza;
	}

	public JTextField getTextFieldIDArtikla() {
		return textFieldIDArtikla;
	}

	public void setTextFieldIDArtikla(JTextField textFieldIDArtikla) {
		this.textFieldIDArtikla = textFieldIDArtikla;
	}

	public JComboBox getComboBoxJedinicaMere() {
		return comboBoxJedinicaMere;
	}

	public void setComboBoxJedinicaMere(JComboBox comboBoxJedinicaMere) {
		this.comboBoxJedinicaMere = comboBoxJedinicaMere;
	}

	public JComboBox getComboBoxGrupaArtikla() {
		return comboBoxGrupaArtikla;
	}

	public void setComboBoxGrupaArtikla(JComboBox comboBoxGrupaArtikla) {
		this.comboBoxGrupaArtikla = comboBoxGrupaArtikla;
	}

	public JComboBox getComboBoxStopaPDV() {
		return comboBoxStopaPDV;
	}

	public void setComboBoxStopaPDV(JComboBox comboBoxStopaPDV) {
		this.comboBoxStopaPDV = comboBoxStopaPDV;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameArtikal frame = new JFrameArtikal(0);
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
	public JFrameArtikal(int ida) {
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

		comboBoxJedinicaMere = new JComboBox();
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

		comboBoxGrupaArtikla = new JComboBox();
		comboBoxGrupaArtikla.setBounds(200, 21, 199, 20);
		panelArtikal.add(comboBoxGrupaArtikla);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikla);
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

		comboBoxStopaPDV = new JComboBox();
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
					GrupaArtikala ga = (GrupaArtikala) comboBoxGrupaArtikla.getSelectedItem();
					double netocena = Double.parseDouble(textFieldNetoCenaArtikla.getText().trim());
					int stopaPdv = Integer.parseInt((String) comboBoxStopaPDV.getSelectedItem());
					double marza = Double.parseDouble(textFieldMarza.getText().trim());

					Artikli a = new Artikli(0, ga.getIdGrupeArtikala(), naziv, jm, netocena, stopaPdv, marza);

					Kontroler.getInstance().insertArikli(a);
					JOptionPane.showMessageDialog(null, "Uspesno ste uneli artikal");
					
					textFieldNazivArtikla.setText("");
					comboBoxJedinicaMere.setSelectedItem(null);
					comboBoxGrupaArtikla.setSelectedItem(null);
					textFieldNetoCenaArtikla.setText("");
					comboBoxStopaPDV.setSelectedItem(null);
					textFieldMarza.setText("");

				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.getMessage());
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
		
		if(ida > 0)
		{
			//daj iz baze
			//popuni polja
			
			try {
				Artikli a = Kontroler.getInstance().getDetaljiArtikli(ida);
				
				//comboBoxGrupaArtikla.setSelectedItem(a.getIdgrupaArtikla());
				comboBoxGrupaArtikla.setSelectedIndex(0);
				comboBoxGrupaArtikla.getModel().setSelectedItem(Kontroler.getInstance().getGrupaArtikala(a.getIdgrupaArtikla()).get(0));
				
				textFieldNazivArtikla.setText(a.getNaziv_artikla());
				comboBoxJedinicaMere.setSelectedItem(a.getJedinica_mere());
				textFieldIDArtikla.setText(Integer.toString(a.getIdArtikla()));
				textFieldNetoCenaArtikla.setText(Double.toString(a.getNeto_cena_artikla()));
				comboBoxStopaPDV.getModel().setSelectedItem(a.getStopa_PDV());
				textFieldMarza.setText(Double.toString(a.getMarza_artikla()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void popuniComboBoxGrupaArtikala(JComboBox<GrupaArtikala> comboBox) {
		try {
			ArrayList<GrupaArtikala> lista = Kontroler.getInstance().getGrupaArtikala();

			for (GrupaArtikala ga : lista) {
				comboBox.addItem(ga);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
