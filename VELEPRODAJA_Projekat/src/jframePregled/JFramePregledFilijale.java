package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFramePregledFilijale extends JFrame {

	private JPanel contentPane;
	private JTable tablePregleFilijale;
	private JButton btnIzlazPregledFilijale;
	

	public JTable getTablePregleFilijale() {
		// TODO Auto-generated method stub
		return tablePregleFilijale;
	}
	
	public JButton getBtnIzlazPregledFilijale() {
		return btnIzlazPregledFilijale;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledFilijale frame = new JFramePregledFilijale();
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
	public JFramePregledFilijale() {
		setTitle("PREGLED FILIJALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 182);
		contentPane.add(scrollPane);
		
		tablePregleFilijale = new JTable();
		scrollPane.setViewportView(tablePregleFilijale);
		
		btnIzlazPregledFilijale = new JButton("Izlaz");
		btnIzlazPregledFilijale.setBounds(335, 227, 89, 23);
		contentPane.add(btnIzlazPregledFilijale);
	}

}
