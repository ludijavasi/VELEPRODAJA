package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.Artikli;
import model.GlavnaGrupa;
import model.Grupa_Artikla;
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
		
		JButton btnOtvoriArtikal = new JButton("Otvori artikal");
		btnOtvoriArtikal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriArtikal.setBounds(61, 203, 156, 23);
		contentPane.add(btnOtvoriArtikal);
		
		JLabel lblUnesiteGlavnuGrupu = new JLabel("Unesite glavnu grupu artikala :");
		lblUnesiteGlavnuGrupu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteGlavnuGrupu.setBounds(61, 35, 234, 17);
		contentPane.add(lblUnesiteGlavnuGrupu);
		
		JComboBox comboBoxGlavnaGrupaObrisi = new JComboBox();
		comboBoxGlavnaGrupaObrisi.setBounds(61, 76, 234, 20);
		contentPane.add(comboBoxGlavnaGrupaObrisi);
		popuniComboBoxGlavnaGrupa(comboBoxGlavnaGrupaObrisi);
		comboBoxGlavnaGrupaObrisi.setSelectedItem(null);
		comboBoxGlavnaGrupaObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "COMBOBOX ACTION");
				if (comboBoxGlavnaGrupaObrisi.getSelectedItem() != null) {
					popuniComboBoxGrupaArtikala(comboBoxArtikalObrisi,
							((GlavnaGrupa) comboBoxGlavnaGrupaObrisi.getSelectedItem()).getIdGlavneGrupe());
					comboBoxArtikalObrisi.setSelectedItem(null);
				}
				else
				{
					comboBoxArtikalObrisi.removeAllItems();
					comboBoxArtikalObrisi.setSelectedItem(null);
				}
			}
		});
		
		JLabel lblUnesiteArtikal = new JLabel("Unesite artikal :");
		lblUnesiteArtikal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteArtikal.setBounds(61, 118, 234, 17);
		contentPane.add(lblUnesiteArtikal);
		
		comboBoxArtikalObrisi = new JComboBox();
		comboBoxArtikalObrisi.setBounds(61, 156, 234, 20);
		contentPane.add(comboBoxArtikalObrisi);
		//popuniComboBoxGrupaArtikala(comboBoxArtikalObrisi);
		comboBoxArtikalObrisi.setSelectedItem(null);
		

	}
	
	private void popuniComboBoxGlavnaGrupa(JComboBox<GlavnaGrupa> comboBox) {
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
	
	private void popuniComboBoxGrupaArtikala(JComboBox<Grupa_Artikla> comboBox, Integer id_glavne_grupe) {
		try {
			comboBox.removeAllItems();
			
			//ArrayList<GlavnaGrupa> lista = Kontroler.getInstance().getGlavnaGrupaArtikala();
			ArrayList<Grupa_Artikla> lista1 = Kontroler.getInstance().getGrupaArtikala(id_glavne_grupe);

			//for (GlavnaGrupa gg : lista) {
				for (Grupa_Artikla ga : lista1) {
					comboBox.addItem(ga);
					
				}
				
				
			//}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
	
	    

