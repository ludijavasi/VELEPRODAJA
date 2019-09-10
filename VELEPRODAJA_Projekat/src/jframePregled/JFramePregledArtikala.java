package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class JFramePregledArtikala extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledArtikala;
	private JButton btnIzlazPregledArtikala;		
	

	public JTable getTablePregledArtikala() {
		return tablePregledArtikala;
	}

	public void setTablePregledArtikala(JTable tablePregledArtikala) {
		this.tablePregledArtikala = tablePregledArtikala;
	}

	public JButton getBtnIzlazPregledArtikala() {
		return btnIzlazPregledArtikala;
	}

	public void setBtnIzlazPregledArtikala(JButton btnIzlazPregledArtikala) {
		this.btnIzlazPregledArtikala = btnIzlazPregledArtikala;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregledArtikala frame = new JFramePregledArtikala();
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
	public JFramePregledArtikala() {
		setTitle("PREGLED ARTIKALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSortiranjeArtikala = new JPanel();
		panelSortiranjeArtikala.setBorder(new TitledBorder(null, "Sortiranje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSortiranjeArtikala.setBounds(10, 30, 560, 60);
		contentPane.add(panelSortiranjeArtikala);
		panelSortiranjeArtikala.setLayout(null);
		
		JComboBox comboBoxGrupaArtikalaPregledArtikala = new JComboBox();
		comboBoxGrupaArtikalaPregledArtikala.setBounds(252, 29, 176, 20);
		panelSortiranjeArtikala.add(comboBoxGrupaArtikalaPregledArtikala);
		
		ButtonGroup grupaSortiranje = new ButtonGroup();
		
		JScrollPane scrollPanePregledArtikala = new JScrollPane();
		scrollPanePregledArtikala.setBounds(10, 110, 960, 250);
		contentPane.add(scrollPanePregledArtikala);
		
		tablePregledArtikala = new JTable();
		scrollPanePregledArtikala.setViewportView(tablePregledArtikala);
		
		btnIzlazPregledArtikala = new JButton("Izlaz");
		btnIzlazPregledArtikala.setFont(new Font("Arial", Font.BOLD, 14));
		btnIzlazPregledArtikala.setBounds(820, 620, 150, 25);
		contentPane.add(btnIzlazPregledArtikala);
	}
}
