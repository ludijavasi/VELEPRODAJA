package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameGrupaArtikala;
import kontroler.Kontroler;
import model.GrupaArtikala;
import model.Magacin;
import model.Zaposleni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JFrameObrisiGrupuArtikala extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdGrupeArtikalaObrisiGA;
	private JComboBox comboBoxObrisiGrupuArtikala;
	private JButton btnNazadObrisiGA;	

	public JButton getBtnNazadObrisiGA() {
		return btnNazadObrisiGA;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiGrupuArtikala frame = new JFrameObrisiGrupuArtikala();
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
	public JFrameObrisiGrupuArtikala() {
		setTitle("OBRISI GRUPU ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteGrupuArtikala = new JLabel("Unesite grupu artikala:");
		lblUnesiteGrupuArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteGrupuArtikala.setBounds(35, 50, 223, 17);
		contentPane.add(lblUnesiteGrupuArtikala);
		
		comboBoxObrisiGrupuArtikala = new JComboBox();
		comboBoxObrisiGrupuArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxObrisiGrupuArtikala.setBounds(35, 102, 223, 20);
		contentPane.add(comboBoxObrisiGrupuArtikala);
		popuniComboBoxGrupaArtikala(comboBoxObrisiGrupuArtikala);
		comboBoxObrisiGrupuArtikala.setSelectedItem(null);
		comboBoxObrisiGrupuArtikala.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			GrupaArtikala ga = (GrupaArtikala) comboBoxObrisiGrupuArtikala.getSelectedItem();
			textFieldIdGrupeArtikalaObrisiGA.setText(Integer.toString(ga.getIdGrupeArtikala()));		
		}
	});
		
		JLabel lblIdGrupeArtikalaObrisiGA = new JLabel("ID grupe artikala :");
		lblIdGrupeArtikalaObrisiGA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdGrupeArtikalaObrisiGA.setBounds(35, 165, 152, 17);
		contentPane.add(lblIdGrupeArtikalaObrisiGA);
		
		textFieldIdGrupeArtikalaObrisiGA = new JTextField();
		textFieldIdGrupeArtikalaObrisiGA.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldIdGrupeArtikalaObrisiGA.setBounds(197, 163, 61, 20);
		contentPane.add(textFieldIdGrupeArtikalaObrisiGA);
		textFieldIdGrupeArtikalaObrisiGA.setColumns(10);
		
		JButton btnOtvoriteGrupuArtikalaObrisiGA = new JButton("Otvorite grupu artikala ");
		btnOtvoriteGrupuArtikalaObrisiGA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameGrupaArtikala jfoga = new JFrameGrupaArtikala();
				jfoga.getBtnAzurirajDodajGrupuArtikala().setVisible(false);
				jfoga.getBtnDodajGrupuArtikala().setVisible(false);
				
				int idga = Integer.parseInt(textFieldIdGrupeArtikalaObrisiGA.getText().trim());
				
				try {
					GrupaArtikala ga = Kontroler.getInstance().getDetaljiGrupaArtikala(idga);
					
					jfoga.getTextFieldGrupaArtikala().setText(ga.getNazivGrupeArtikala());
					jfoga.getTextFieldIdGrupeArtikala().setText(Integer.toString(ga.getIdGrupeArtikala()));
					
					jfoga.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				jfoga.getBtnObrisiGrupuArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int idga = Integer.parseInt(jfoga.getTextFieldIdGrupeArtikala().getText().trim());
						
						try {
							Kontroler.getInstance().deleteGrupaArtikala(idga);
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali grupu artikala!");
							//textFieldIdGrupeArtikalaObrisiGA.setText("");
							
							jfoga.setVisible(false);
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				jfoga.getBtnPonistiAkcijuDodajGrupuArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfoga.setVisible(false);
						
					}
				});
				jfoga.setVisible(true);
				
			}
		});
		btnOtvoriteGrupuArtikalaObrisiGA.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriteGrupuArtikalaObrisiGA.setBounds(35, 225, 193, 23);
		contentPane.add(btnOtvoriteGrupuArtikalaObrisiGA);
		
		btnNazadObrisiGA = new JButton("Nazad");
		btnNazadObrisiGA.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNazadObrisiGA.setBounds(276, 227, 89, 23);
		contentPane.add(btnNazadObrisiGA);
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
