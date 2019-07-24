package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameObrisiKupca extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdKupca;
	private JTextField textFieldKupac;

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
		
		JLabel lblUnesiteIdKupca = new JLabel("Unesite ID kupca :");
		lblUnesiteIdKupca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteIdKupca.setBounds(63, 52, 137, 17);
		contentPane.add(lblUnesiteIdKupca);
		
		textFieldIdKupca = new JTextField();
		textFieldIdKupca.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldIdKupca.setBounds(63, 84, 48, 20);
		contentPane.add(textFieldIdKupca);
		textFieldIdKupca.setColumns(10);
		
		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnURedu.setBounds(133, 83, 79, 23);
		contentPane.add(btnURedu);
		
		textFieldKupac = new JTextField();
		textFieldKupac.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldKupac.setBounds(63, 123, 149, 20);
		contentPane.add(textFieldKupac);
		textFieldKupac.setColumns(10);
		
		JButton btnOtvoriKupca = new JButton("Otvori kupca");
		btnOtvoriKupca.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriKupca.setBounds(63, 172, 149, 23);
		contentPane.add(btnOtvoriKupca);
	}

}
