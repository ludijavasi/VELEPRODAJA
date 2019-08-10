 package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameMagacin;
import kontroler.Kontroler;
import model.Magacin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class JFrameObrisiMagacin extends JFrame {

	private JPanel contentPane;
	private JComboBox<Magacin> comboBoxMagacinaObrisi;
	private JTextField textFieldIdMagacinaObrisiMagacin;
	private JButton btnNazadObrisiMagacin;

	public JButton getBtnNazadObrisiMagacin() {
		return btnNazadObrisiMagacin;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiMagacin frameObrisiMagacin = new JFrameObrisiMagacin();
					frameObrisiMagacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameObrisiMagacin() {
		setTitle("OBRISI MAGACIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnesiteIdMagacina = new JLabel("Izaberi magacin");
		lblUnesiteIdMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteIdMagacina.setBounds(58, 48, 331, 17);
		contentPane.add(lblUnesiteIdMagacina);

		JButton btnOtvoriMagacin = new JButton("Otvori magacin");
		btnOtvoriMagacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameMagacin jfmo = new JFrameMagacin();
				jfmo.getBtnDodajMagacin().setVisible(false);
				int idm = Integer.parseInt(textFieldIdMagacinaObrisiMagacin.getText().trim());
				try {
					Magacin m = Kontroler.getInstance().getDetaljiMagacina(idm);

					jfmo.getTextFieldIdMagacina().setText(Integer.toString(m.getIdMagacina()));
					jfmo.getTextFieldNazivMagacina().setText(m.getNazivMagacina());
					jfmo.getTextFieldAdresaMagacina().setText(m.getAdresaMagacina());
					jfmo.getTextFieldGradMagacina().setText(m.getGradOpstinaMagacina());
					jfmo.getTextFieldTelefonMagacina().setText(m.getTelefonMagacina());
					jfmo.getTextFieldEmailMagacina().setText(m.getEmailMagacina());
					jfmo.getTextFieldIdMagacina().setEditable(false);
					jfmo.getTextFieldNazivMagacina().setEditable(false);
					jfmo.getTextFieldAdresaMagacina().setEditable(false);
					jfmo.getTextFieldGradMagacina().setEditable(false);
					jfmo.getTextFieldTelefonMagacina().setEditable(false);
					jfmo.getTextFieldEmailMagacina().setEditable(false);
					jfmo.setVisible(true);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				jfmo.getBtnObrisiMagacin().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int rbn = Integer.parseInt(jfmo.getTextFieldIdMagacina().getText().trim());
						try {
							Kontroler.getInstance().obrisiMagacin(rbn);
							JOptionPane.showMessageDialog(null, "Uspesno ste obrisali magacin!");
							jfmo.setVisible(false);
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
				jfmo.getBtnPrekiniackcijuMagacin().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jfmo.setVisible(false);

					}
				});
				jfmo.setVisible(true);

			}

		});
		btnOtvoriMagacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriMagacin.setBounds(224, 166, 165, 23);
		contentPane.add(btnOtvoriMagacin);

		comboBoxMagacinaObrisi = new JComboBox<Magacin>();
		comboBoxMagacinaObrisi.setBounds(58, 88, 331, 20);
		contentPane.add(comboBoxMagacinaObrisi);
		popuniComboBoxMagacin(comboBoxMagacinaObrisi);
		comboBoxMagacinaObrisi.setSelectedItem(null);
		comboBoxMagacinaObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Magacin m = (Magacin) comboBoxMagacinaObrisi.getSelectedItem();
				textFieldIdMagacinaObrisiMagacin.setText(Integer.toString(m.getIdMagacina()));
			}
		});

		JLabel lblIdMagacinaObrisiMagacin = new JLabel("ID Magacina :");
		lblIdMagacinaObrisiMagacin.setBounds(122, 128, 77, 14);
		contentPane.add(lblIdMagacinaObrisiMagacin);

		textFieldIdMagacinaObrisiMagacin = new JTextField();
		textFieldIdMagacinaObrisiMagacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		textFieldIdMagacinaObrisiMagacin.setBounds(239, 125, 86, 20);
		contentPane.add(textFieldIdMagacinaObrisiMagacin);
		textFieldIdMagacinaObrisiMagacin.setColumns(10);
		
		btnNazadObrisiMagacin = new JButton("Nazad");
		btnNazadObrisiMagacin.setBounds(58, 168, 89, 23);
		contentPane.add(btnNazadObrisiMagacin);
	}

	private void popuniComboBoxMagacin(JComboBox<Magacin> comboBox) {
		try {
			ArrayList<Magacin> lista = Kontroler.getInstance().getMagacin();

			for (Magacin m : lista) {
				comboBox.addItem(m);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
