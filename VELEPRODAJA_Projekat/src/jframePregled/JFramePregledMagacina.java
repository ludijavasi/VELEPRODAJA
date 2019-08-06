package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JFramePregledMagacina extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledMagacina;
	private JButton btnIzlazPregledMagacina;
	

	public JTable getTablePregledMagacina() {
		return tablePregledMagacina;
	}

	public JButton getBtnIzlazPregledMagacina() {
		return btnIzlazPregledMagacina;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledMagacina frame = new JFramePregledMagacina();
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
	public JFramePregledMagacina() {
		setTitle("PREGLED MAGACINA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 193);
		contentPane.add(scrollPane);
		
		tablePregledMagacina = new JTable();
		scrollPane.setViewportView(tablePregledMagacina);
		
		btnIzlazPregledMagacina = new JButton("Izlaz");
		btnIzlazPregledMagacina.setBounds(335, 227, 89, 23);
		contentPane.add(btnIzlazPregledMagacina);
	}

}
