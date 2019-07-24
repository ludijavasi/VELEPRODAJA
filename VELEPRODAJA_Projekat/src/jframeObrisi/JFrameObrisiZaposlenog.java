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

public class JFrameObrisiZaposlenog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdZaposlenog;
	private JTextField textFieldZaposleni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiZaposlenog frame = new JFrameObrisiZaposlenog();
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
	public JFrameObrisiZaposlenog() {
		setTitle("OBRISI ZAPOSLENOG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteIdZaposlenog = new JLabel("Unesite ID zaposlenog :");
		lblUnesiteIdZaposlenog.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteIdZaposlenog.setBounds(55, 49, 193, 17);
		contentPane.add(lblUnesiteIdZaposlenog);
		
		textFieldIdZaposlenog = new JTextField();
		textFieldIdZaposlenog.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldIdZaposlenog.setBounds(55, 85, 50, 20);
		contentPane.add(textFieldIdZaposlenog);
		textFieldIdZaposlenog.setColumns(10);
		
		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnURedu.setBounds(137, 84, 89, 23);
		contentPane.add(btnURedu);
		
		textFieldZaposleni = new JTextField();
		textFieldZaposleni.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldZaposleni.setBounds(55, 129, 171, 20);
		contentPane.add(textFieldZaposleni);
		textFieldZaposleni.setColumns(10);
		
		JButton btnOtvoriZaposlenog = new JButton("Otvori zaposlenog");
		btnOtvoriZaposlenog.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriZaposlenog.setBounds(55, 175, 171, 23);
		contentPane.add(btnOtvoriZaposlenog);
	}

}
