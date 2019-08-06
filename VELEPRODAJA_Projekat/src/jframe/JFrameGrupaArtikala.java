package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.GrupaArtikala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameGrupaArtikala extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGrupaArtikala;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameGrupaArtikala frame = new JFrameGrupaArtikala();
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
	public JFrameGrupaArtikala() {
		setTitle("GRUPA ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteGrupuArtikala = new JLabel("Unesite grupu artikala :");
		lblUnesiteGrupuArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteGrupuArtikala.setBounds(30, 58, 264, 17);
		contentPane.add(lblUnesiteGrupuArtikala);
		
		textFieldGrupaArtikala = new JTextField();
		textFieldGrupaArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldGrupaArtikala.setBounds(30, 115, 204, 20);
		contentPane.add(textFieldGrupaArtikala);
		textFieldGrupaArtikala.setColumns(10);
		
		JButton btnDodajGrupuArtikala = new JButton("Dodaj grupu artikala");
		btnDodajGrupuArtikala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				String naziv = textFieldGrupaArtikala.getText();
				
				GrupaArtikala ga = new GrupaArtikala(0, naziv);
				
				
					Kontroler.getInstance().insertGrupaArtikala(ga);
					JOptionPane.showMessageDialog(null, "Uspesno ste uneli grupu artikala!");
					textFieldGrupaArtikala.setText("");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDodajGrupuArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDodajGrupuArtikala.setBounds(30, 181, 264, 23);
		contentPane.add(btnDodajGrupuArtikala);
	}
}
