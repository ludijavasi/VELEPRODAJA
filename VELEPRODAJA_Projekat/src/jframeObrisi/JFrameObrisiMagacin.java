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

public class JFrameObrisiMagacin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdMagacina;
	private JTextField textFieldMagacina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiMagacin frame = new JFrameObrisiMagacin();
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
	public JFrameObrisiMagacin() {
		setTitle("OBRISI MAGACIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteIdMagacina = new JLabel("Unesite ID magacina :");
		lblUnesiteIdMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteIdMagacina.setBounds(58, 48, 165, 17);
		contentPane.add(lblUnesiteIdMagacina);
		
		textFieldIdMagacina = new JTextField();
		textFieldIdMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldIdMagacina.setBounds(58, 81, 55, 20);
		contentPane.add(textFieldIdMagacina);
		textFieldIdMagacina.setColumns(10);
		
		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnURedu.setBounds(135, 80, 89, 23);
		contentPane.add(btnURedu);
		
		textFieldMagacina = new JTextField();
		textFieldMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMagacina.setBounds(58, 114, 165, 20);
		contentPane.add(textFieldMagacina);
		textFieldMagacina.setColumns(10);
		
		JButton btnOtvoriMagacin = new JButton("Otvori magacin");
		btnOtvoriMagacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriMagacin.setBounds(58, 155, 165, 23);
		contentPane.add(btnOtvoriMagacin);
	}

}
