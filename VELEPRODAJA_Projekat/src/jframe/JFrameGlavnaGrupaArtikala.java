package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.GlavnaGrupa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameGlavnaGrupaArtikala extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGlavnaGrupaArtikala;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameGlavnaGrupaArtikala frame = new JFrameGlavnaGrupaArtikala();
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
	public JFrameGlavnaGrupaArtikala() {
		setTitle("GLAVNA GRUPA ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteGlavnuGrupu = new JLabel("Unesite glavnu grupu artikala :");
		lblUnesiteGlavnuGrupu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteGlavnuGrupu.setBounds(30, 58, 264, 17);
		contentPane.add(lblUnesiteGlavnuGrupu);
		
		textFieldGlavnaGrupaArtikala = new JTextField();
		textFieldGlavnaGrupaArtikala.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldGlavnaGrupaArtikala.setBounds(30, 115, 204, 20);
		contentPane.add(textFieldGlavnaGrupaArtikala);
		textFieldGlavnaGrupaArtikala.setColumns(10);
		
		JButton btnDodajGlavnuGrupu = new JButton("Dodaj glavnu grupu artikala");
		btnDodajGlavnuGrupu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				String naziv = textFieldGlavnaGrupaArtikala.getText();
				
				GlavnaGrupa gga = new GlavnaGrupa(naziv);
				
				
					Kontroler.getInstance().insertGlavnaGrupaArtikala(gga);
					JOptionPane.showMessageDialog(null, "Uspesno ste uneli glavnu grupru artikala!");
					textFieldGlavnaGrupaArtikala.setText("");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDodajGlavnuGrupu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDodajGlavnuGrupu.setBounds(30, 181, 264, 23);
		contentPane.add(btnDodajGlavnuGrupu);
	}
}
