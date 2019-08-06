package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameFilijala;
import jframe.JFrameKupac;
import kontroler.Kontroler;
import model.Filijala;
import model.Kupac;

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

public class JFrameObrisiKupca extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdKupcaObrisiKupca;
	private JButton btnNazadObrisiKupca;

	public JButton getBtnNazadObrisiKupca() {
		return btnNazadObrisiKupca;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiKupca frame = new JFrameObrisiKupca();
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
	public JFrameObrisiKupca() {
		setTitle("OBRISI KUPCA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiteKupca = new JLabel("Izaberite kupca :");
		lblIzaberiteKupca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIzaberiteKupca.setBounds(63, 52, 137, 17);
		contentPane.add(lblIzaberiteKupca);
		
		textFieldIdKupcaObrisiKupca = new JTextField();
		textFieldIdKupcaObrisiKupca.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldIdKupcaObrisiKupca.setBounds(255, 128, 48, 20);
		contentPane.add(textFieldIdKupcaObrisiKupca);
		textFieldIdKupcaObrisiKupca.setColumns(10);
		
		btnNazadObrisiKupca = new JButton("Nazad");
		btnNazadObrisiKupca.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNazadObrisiKupca.setBounds(63, 190, 79, 23);
		contentPane.add(btnNazadObrisiKupca);
		
		JButton btnOtvoriKupcaObrisiKupca = new JButton("Otvori kupca");
		btnOtvoriKupcaObrisiKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameKupac jfk = new JFrameKupac();
				//jffo.getBtnDodajFilijalu().setVisible(true);
				int idk = Integer.parseInt(textFieldIdKupcaObrisiKupca.getText().trim());
				
				try {
					Kupac k = Kontroler.getInstance().getDetaljiKupca(idk);

					jfk.getTextFieldIdKupca().setText(Integer.toString(k.getIdKupca()));
					jfk.getTextNazivFirme().setText(k.getNazivFirmeKupca());
					jfk.getTextAdresaFirme().setText(k.getAdresaKupca());
					jfk.getTextGradOpstinaFirme().setText(k.getGradOpstinaKupca());
					jfk.getTextTelefonFirme().setText(k.getTelefonKupca());
					jfk.getTextEMailKipca().setText(k.getEmailKupca());
					jfk.getTextFieldKontakOsobaKupca().setText(k.getKontaktOsobaKupca());
					jfk.getTextPibKupca().setText(Integer.toString(k.getPibKupca()));
					jfk.getTextTekuciRacunKupca().setText(k.getTekuciRacunKupca());
					jfk.getComboBoxValutaPlacanja().setSelectedItem(k.getValutaPlacanjaKupca());
					
					if(k.getStatusKupca().equals("Aktivna")) {
						jfk.getRdbtnAktivan().isSelected();
					}else
						jfk.getRdbtnNeaktivan().isSelected();
					
					
					
					
					
					jfk.getTextFieldIdKupca().setEditable(false);
					jfk.getTextNazivFirme().setEditable(false);
					jfk.getTextAdresaFirme().setEditable(false);
					jfk.getTextGradOpstinaFirme().setEditable(false);
					jfk.getTextTelefonFirme().setEditable(false);
					jfk.getTextEMailKipca().setEditable(false);
					jfk.getTextFieldKontakOsobaKupca().setEditable(false);
					jfk.getTextPibKupca().setEditable(false);
					jfk.getTextTekuciRacunKupca().setEditable(false);
					jfk.getComboBoxValutaPlacanja().setEditable(false);
					jfk.getRdbtnAktivan().setFocusable(false);
					jfk.getRdbtnNeaktivan().setFocusable(false);
					
										
					jfk.setVisible(true);
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				jfk.getBtnObrisiKupca().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int rbk = Integer.parseInt(jfk.getTextFieldIdKupca().getText().trim());
						try {
							Kontroler.getInstance().obrisiKupca(rbk);;
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali kupca!");
							jfk.setVisible(false);
							

						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
					jfk.getBtnPonistiAkcijuKupac().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							jfk.setVisible(false);

						}
					});
				
			}
		});
		btnOtvoriKupcaObrisiKupca.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriKupcaObrisiKupca.setBounds(245, 190, 149, 23);
		contentPane.add(btnOtvoriKupcaObrisiKupca);
		
		JComboBox comboBoxObrisiKupca = new JComboBox();
		comboBoxObrisiKupca.setBounds(63, 82, 337, 20);
		contentPane.add(comboBoxObrisiKupca);
		popuniComboBoxKupca(comboBoxObrisiKupca);
		comboBoxObrisiKupca.setSelectedItem(null);
		comboBoxObrisiKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kupac k = (Kupac) comboBoxObrisiKupca.getSelectedItem();
				textFieldIdKupcaObrisiKupca.setText(Integer.toString(k.getIdKupca()));
			}
		});
		
		JLabel lblIdKupca = new JLabel("ID Kupca :");
		lblIdKupca.setBounds(63, 133, 58, 14);
		contentPane.add(lblIdKupca);
	}
	private void popuniComboBoxKupca(JComboBox<Kupac> comboBox) {
		try {
			ArrayList<Kupac> lista = Kontroler.getInstance().getKupac();

			for (Kupac k : lista) {
				comboBox.addItem(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
