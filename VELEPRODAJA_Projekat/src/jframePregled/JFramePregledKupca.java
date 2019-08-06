package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JFramePregledKupca extends JFrame {

	private JPanel contentPane;
	private JTable tablePregleKupaca;
	private JButton btnIzlazPregledKupaca;
	
	
	public JButton getBtnIzlazPregledKupaca() {
		return btnIzlazPregledKupaca;
	}

	public JTable getTablePregleKupaca() {
		return tablePregleKupaca;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledKupca frame = new JFramePregledKupca();
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
	public JFramePregledKupca() {
		setTitle("PREGLED KUPACA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 198);
		contentPane.add(scrollPane);
		
		tablePregleKupaca = new JTable();
		scrollPane.setViewportView(tablePregleKupaca);
		
		btnIzlazPregledKupaca = new JButton("Izlaz");
		btnIzlazPregledKupaca.setBounds(335, 227, 89, 23);
		contentPane.add(btnIzlazPregledKupaca);
	}
}
