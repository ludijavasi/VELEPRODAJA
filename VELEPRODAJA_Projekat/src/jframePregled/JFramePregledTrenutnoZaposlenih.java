package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JFramePregledTrenutnoZaposlenih extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledTrenutnoZaposlenih;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledTrenutnoZaposlenih frame = new JFramePregledTrenutnoZaposlenih();
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
	public JFramePregledTrenutnoZaposlenih() {
		setTitle("PREGLED TRENUTNO ZAPOSLENIH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPanePregledTrenutnoZaposlenih = new JScrollPane();
		scrollPanePregledTrenutnoZaposlenih.setBounds(10, 11, 569, 222);
		contentPane.add(scrollPanePregledTrenutnoZaposlenih);
		
		tablePregledTrenutnoZaposlenih = new JTable();
		scrollPanePregledTrenutnoZaposlenih.setViewportView(tablePregledTrenutnoZaposlenih);
		
		JButton btnIzlazTrenutnoZaposleni = new JButton("Izlaz");
		btnIzlazTrenutnoZaposleni.setBounds(446, 244, 133, 23);
		contentPane.add(btnIzlazTrenutnoZaposleni);
	}

}
