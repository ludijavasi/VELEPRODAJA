package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameArtikal;
import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.Magacin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JFrameObrisiArtikal extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxGlavnaGrupaObrisi;
	private JComboBox comboBoxArtikalObrisi;
	private JButton btnNazadObrisiArtikal;	
	

	public JButton getBtnNazadObrisiArtikal() {
		return btnNazadObrisiArtikal;
	}

	public void setBtnNazadObrisiArtikal(JButton btnNazadObrisiArtikal) {
		this.btnNazadObrisiArtikal = btnNazadObrisiArtikal;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiArtikal frame = new JFrameObrisiArtikal();
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
	public JFrameObrisiArtikal() {
		setTitle("OBRISI ARTIKAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOtvoriArtikalObrisi = new JButton("Otvori artikal");
		btnOtvoriArtikalObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ida = ((Artikli)comboBoxArtikalObrisi.getSelectedItem()).getIdArtikla();
				JFrameArtikal jfa = new JFrameArtikal(ida);
				jfa.setVisible(true);
				
				jfa.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfa.setVisible(false);
						
					}
				});
				jfa.setVisible(true);
				/*try {
					Artikli a = Kontroler.getInstance().getDetaljiArtikli(ida);
					
					jfa.getComboBoxGrupaArtikla().setSelectedItem(a.getIdgrupaArtikla());
					jfa.getTextFieldNazivArtikla().setText(a.getNaziv_artikla());
					jfa.getComboBoxJedinicaMere().setSelectedItem(a.getJedinica_mere());
					jfa.getTextFieldIDArtikla().setText(Integer.toString(a.getIdArtikla()));
					jfa.getTextFieldNetoCenaArtikla().setText(Double.toString(a.getNeto_cena_artikla()));
					jfa.getComboBoxStopaPDV().setSelectedItem(a.getStopa_PDV());
					jfa.getTextFieldMarza().setText(Double.toString(a.getMarza_artikla()));
					
					jfa.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				
			}
		});
		btnOtvoriArtikalObrisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriArtikalObrisi.setBounds(61, 203, 156, 23);
		contentPane.add(btnOtvoriArtikalObrisi);
		
		JLabel lblUnesiteGrupuArtikala = new JLabel("Unesite grupu artikala :");
		lblUnesiteGrupuArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteGrupuArtikala.setBounds(61, 11, 234, 17);
		contentPane.add(lblUnesiteGrupuArtikala);
		
		JComboBox comboBoxGrupaArtikalaObrisi = new JComboBox();
		comboBoxGrupaArtikalaObrisi.setBounds(61, 39, 234, 20);
		contentPane.add(comboBoxGrupaArtikalaObrisi);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaObrisi);
		comboBoxGrupaArtikalaObrisi.setSelectedItem(null);
		comboBoxGrupaArtikalaObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "COMBOBOX ACTION");
				if (comboBoxGrupaArtikalaObrisi.getSelectedItem() != null) {
					popuniComboBoxArtikli(comboBoxArtikalObrisi,
							((GrupaArtikala) comboBoxGrupaArtikalaObrisi.getSelectedItem()).getIdGrupeArtikala());
					comboBoxArtikalObrisi.setSelectedItem(null);
				}
				else
				{
					comboBoxArtikalObrisi.removeAllItems();
					comboBoxArtikalObrisi.setSelectedItem(null);
				}
			}
		});
		
		JLabel lblUnesiteArtikalObrisi = new JLabel("Unesite artikal :");
		lblUnesiteArtikalObrisi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteArtikalObrisi.setBounds(61, 83, 234, 17);
		contentPane.add(lblUnesiteArtikalObrisi);
		
		comboBoxArtikalObrisi = new JComboBox();
		comboBoxArtikalObrisi.setBounds(61, 111, 234, 20);
		contentPane.add(comboBoxArtikalObrisi);
		//popuniComboBoxGrupaArtikala(comboBoxArtikalObrisi);
		comboBoxArtikalObrisi.setSelectedItem(null);		
		
	    btnNazadObrisiArtikal = new JButton("Nazad");
		btnNazadObrisiArtikal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNazadObrisiArtikal.setBounds(262, 205, 89, 23);
		contentPane.add(btnNazadObrisiArtikal);

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
	
	private void popuniComboBoxArtikli(JComboBox<Artikli> comboBox, Integer id_grupe_artikala) {
		try {
			comboBox.removeAllItems();
			
			//ArrayList<GlavnaGrupa> lista = Kontroler.getInstance().getGlavnaGrupaArtikala();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikli();

			//for (GlavnaGrupa gg : lista) {
				for (Artikli a : lista1) {
					comboBox.addItem(a);
					
				}
				
				
			//}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
	
	    

