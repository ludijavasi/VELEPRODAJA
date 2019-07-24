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

public class JFrameObrisiFilijalu extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIdFilijale;
	private JTextField textFieldFilijale;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteIdFilijale = new JLabel("Unesite ID filijale :");
		lblUnesiteIdFilijale.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiteIdFilijale.setBounds(73, 53, 139, 17);
		contentPane.add(lblUnesiteIdFilijale);
		
		textFieldIdFilijale = new JTextField();
		textFieldIdFilijale.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldIdFilijale.setBounds(73, 81, 50, 20);
		contentPane.add(textFieldIdFilijale);
		textFieldIdFilijale.setColumns(10);
		
		JButton btnURedu = new JButton("U redu");
		btnURedu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnURedu.setBounds(138, 81, 85, 23);
		contentPane.add(btnURedu);
		
		textFieldFilijale = new JTextField();
		textFieldFilijale.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFilijale.setBounds(73, 123, 150, 20);
		contentPane.add(textFieldFilijale);
		textFieldFilijale.setColumns(10);
		
		JButton btnOtvoriFilijalu = new JButton("Otvori filijalu");
		btnOtvoriFilijalu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriFilijalu.setBounds(73, 166, 150, 23);
		contentPane.add(btnOtvoriFilijalu);
	}
}
