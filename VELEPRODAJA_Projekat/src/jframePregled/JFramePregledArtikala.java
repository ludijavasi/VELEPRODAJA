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
		setBounds(100, 100, 591, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSortiranjeArtikala = new JPanel();
		panelSortiranjeArtikala.setBorder(new TitledBorder(null, "Sortiranje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSortiranjeArtikala.setBounds(10, 11, 555, 62);
		contentPane.add(panelSortiranjeArtikala);
		panelSortiranjeArtikala.setLayout(null);
		
		JRadioButton rdbtnGlavnaGrupa = new JRadioButton("Glavna grupa");
		rdbtnGlavnaGrupa.setBounds(6, 19, 109, 23);
		panelSortiranjeArtikala.add(rdbtnGlavnaGrupa);
		
		JRadioButton rdbtnGrupaArtikla = new JRadioButton("Grupa artikla");
		rdbtnGrupaArtikla.setBounds(149, 19, 109, 23);
		panelSortiranjeArtikala.add(rdbtnGrupaArtikla);
		
		JRadioButton rdbtnArtikal = new JRadioButton("Artikal");
		rdbtnArtikal.setBounds(289, 19, 109, 23);
		panelSortiranjeArtikala.add(rdbtnArtikal);
		
		ButtonGroup grupaSortiranje = new ButtonGroup();
		grupaSortiranje.add(rdbtnGlavnaGrupa);
		grupaSortiranje.add(rdbtnGrupaArtikla);
		grupaSortiranje.add(rdbtnArtikal);
		
		JScrollPane scrollPanePregledArtikala = new JScrollPane();
		scrollPanePregledArtikala.setBounds(10, 90, 555, 184);
		contentPane.add(scrollPanePregledArtikala);
		
		tablePregledArtikala = new JTable();
		scrollPanePregledArtikala.setViewportView(tablePregledArtikala);
		
		btnIzlazPregledArtikala = new JButton("Izlaz");
		btnIzlazPregledArtikala.setBounds(437, 291, 128, 23);
		contentPane.add(btnIzlazPregledArtikala);
	}
}
