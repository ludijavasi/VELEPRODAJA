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

public class JFrameObrisiArtikal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdArtikla;
	private JTextField textFieldArtikal;

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
		
		JLabel lblUnesiteIdArtikla = new JLabel("Unesite ID artikla :");
		lblUnesiteIdArtikla.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteIdArtikla.setBounds(61, 49, 144, 17);
		contentPane.add(lblUnesiteIdArtikla);
		
		textFieldIdArtikla = new JTextField();
		textFieldIdArtikla.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldIdArtikla.setBounds(61, 77, 49, 20);
		contentPane.add(textFieldIdArtikla);
		textFieldIdArtikla.setColumns(10);
		
		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnURedu.setBounds(128, 77, 89, 23);
		contentPane.add(btnURedu);
		
		textFieldArtikal = new JTextField();
		textFieldArtikal.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldArtikal.setBounds(61, 117, 156, 20);
		contentPane.add(textFieldArtikal);
		textFieldArtikal.setColumns(10);
		
		JButton btnOtvoriArtikal = new JButton("Otvori artikal");
		btnOtvoriArtikal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriArtikal.setBounds(61, 156, 156, 23);
		contentPane.add(btnOtvoriArtikal);
	}

}
