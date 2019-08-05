package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameFilijala;
import jframe.JFrameMagacin;
import kontroler.Kontroler;
import model.Filijala;
import model.Magacin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameObrisiFilijalu extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxFilijalaObrisi;
	private JTextField textFieldIdFilijaleObrisiFilijalu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiFilijalu frame = new JFrameObrisiFilijalu();
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
	public JFrameObrisiFilijalu() {
		setTitle("OBRISI FILIJALU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiFilijalu = new JLabel("Izaberite filijalu :");
		lblIzaberiFilijalu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIzaberiFilijalu.setBounds(91, 52, 278, 17);
		contentPane.add(lblIzaberiFilijalu);
		
		JComboBox comboBoxFilijalaObrisi = new JComboBox();
		comboBoxFilijalaObrisi.setBounds(91, 95, 355, 20);
		contentPane.add(comboBoxFilijalaObrisi);
		popuniComboBoxFilijala(comboBoxFilijalaObrisi);
		comboBoxFilijalaObrisi.setSelectedItem(null);
		comboBoxFilijalaObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filijala f = (Filijala) comboBoxFilijalaObrisi.getSelectedItem();
				textFieldIdFilijaleObrisiFilijalu.setText(Integer.toString(f.getIdFilijale()));
			}
		});
		
		JButton btnOtvoriFilijalu = new JButton("Otvori filijalu");
		btnOtvoriFilijalu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameFilijala jffo = new JFrameFilijala();
				//jffo.getBtnDodajFilijalu().setVisible(true);
				int idf = Integer.parseInt(textFieldIdFilijaleObrisiFilijalu.getText().trim());
				try {
					Filijala f = Kontroler.getInstance().getDetaljiFilijale(idf);

					jffo.getTextIDFilijale().setText(Integer.toString(f.getIdFilijale()));
					jffo.getTextNazivFilijale().setText(f.getNazivFilijale());
					jffo.getTextAdresaFilijale().setText(f.getAdresaFilijale());
					jffo.getTextGradOpstinaFilijale().setText(f.getGradOpstinaFilijale());
					jffo.getTextTelefonFilijale().setText(f.getTelefonFilijale());
					jffo.getTextE_MailFilijale().setText(f.getEmailFilijale());
					jffo.getTextPibFilijale().setText(Integer.toString(f.getPibFilijale()));
					jffo.getTextTekuciRacunFilijale().setText(f.getTekuciRacunFilijale());
					
					
					
					if(f.getStatus().equals("Aktivna")) {
						jffo.getRdbtnAktivna().isSelected();
					}else
						jffo.getRdbtnNeaktivna().isSelected();
					
					
					jffo.getTextIDFilijale().setEditable(false);
					jffo.getTextNazivFilijale().setEditable(false);
					jffo.getTextAdresaFilijale().setEditable(false);
					jffo.getTextGradOpstinaFilijale().setEditable(false);
					jffo.getTextTelefonFilijale().setEditable(false);
					jffo.getTextE_MailFilijale().setEditable(false);
					jffo.getTextPibFilijale().setEditable(false);
					jffo.getTextTekuciRacunFilijale().setEditable(false);
					
										
					jffo.setVisible(true);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				jffo.getBtnObrisiFilijalu().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int rbn = Integer.parseInt(jffo.getTextIDFilijale().getText().trim());
						try {
							Kontroler.getInstance().obrisiMagacin(rbn);
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali magacin!");
							jffo.setVisible(false);
							/*
							 * textFieldAdresaMagacina.setText(""); textFieldEmailMagacina.setText("");
							 * textFieldGradMagacina.setText(""); textFieldNazivMagacina.setText("");
							 * textFieldTelefonMagacina.setText(""); textFieldIdMagacina.setText("");
							 */

						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				jffo.getBtnPonistiAkcijuFilijala().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jffo.setVisible(false);

					}
				});
				jffo.setVisible(true);

			}

		});
		                 
		btnOtvoriFilijalu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriFilijalu.setBounds(189, 213, 160, 23);
		contentPane.add(btnOtvoriFilijalu);
		
		JLabel lblIdFilijaleObrisiFilijalu = new JLabel("ID filijale :");
		lblIdFilijaleObrisiFilijalu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdFilijaleObrisiFilijalu.setBounds(91, 151, 100, 17);
		contentPane.add(lblIdFilijaleObrisiFilijalu);
		
		textFieldIdFilijaleObrisiFilijalu = new JTextField();
		textFieldIdFilijaleObrisiFilijalu.setBounds(232, 151, 86, 20);
		contentPane.add(textFieldIdFilijaleObrisiFilijalu);
		textFieldIdFilijaleObrisiFilijalu.setColumns(10);
	}
	
	private void popuniComboBoxFilijala(JComboBox<Filijala> comboBox) {
		try {
			ArrayList<Filijala> lista = Kontroler.getInstance().getFilijala();

			for (Filijala f : lista) {
				comboBox.addItem(f);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
