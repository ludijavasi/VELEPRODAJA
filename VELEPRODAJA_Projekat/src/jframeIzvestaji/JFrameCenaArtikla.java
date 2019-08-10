package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import table.JTableModelCenaArtikla;
import table.JTableModelGrupeArtikala;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JFrameCenaArtikla extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGrupaArtiklaCenaArtikla;
	private JTextField textFieldArtikalCenaArtikla;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tableCenaArtikla;
	private JButton btnNazadCenaArtikla;

	public JButton getBtnNazadCenaArtikla() {
		return btnNazadCenaArtikla;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCenaArtikla frame = new JFrameCenaArtikla();
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
	public JFrameCenaArtikla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupaArtiklaCenaArtikla = new JLabel("Grupa artikla :");
		lblGrupaArtiklaCenaArtikla.setBounds(10, 11, 68, 22);
		contentPane.add(lblGrupaArtiklaCenaArtikla);
		
		textFieldGrupaArtiklaCenaArtikla = new JTextField();
		textFieldGrupaArtiklaCenaArtikla.setBounds(88, 12, 86, 20);
		contentPane.add(textFieldGrupaArtiklaCenaArtikla);
		textFieldGrupaArtiklaCenaArtikla.setColumns(10);
		
		JLabel lblArtikal = new JLabel("Artikal :");
		lblArtikal.setBounds(10, 44, 46, 14);
		contentPane.add(lblArtikal);
		
		textFieldArtikalCenaArtikla = new JTextField();
		textFieldArtikalCenaArtikla.setBounds(88, 43, 86, 20);
		contentPane.add(textFieldArtikalCenaArtikla);
		textFieldArtikalCenaArtikla.setColumns(10);
		
		JPanel panelFilterCenaArtikla = new JPanel();
		panelFilterCenaArtikla.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterCenaArtikla.setBounds(10, 69, 300, 42);
		contentPane.add(panelFilterCenaArtikla);
		panelFilterCenaArtikla.setLayout(null);
		
		JRadioButton rdbtnGrupaArtikla = new JRadioButton("Grupa Artikla");
		buttonGroup.add(rdbtnGrupaArtikla);
		rdbtnGrupaArtikla.setBounds(35, 12, 109, 23);
		panelFilterCenaArtikla.add(rdbtnGrupaArtikla);
		
		JRadioButton rdbtnArtikal = new JRadioButton("Artikal");
		buttonGroup.add(rdbtnArtikal);
		rdbtnArtikal.setBounds(156, 12, 109, 23);
		panelFilterCenaArtikla.add(rdbtnArtikal);
		
		JScrollPane scrollPaneCenaArtikla = new JScrollPane();
		scrollPaneCenaArtikla.setBounds(10, 122, 414, 128);
		contentPane.add(scrollPaneCenaArtikla);
		
		tableCenaArtikla = new JTable();
		scrollPaneCenaArtikla.setViewportView(tableCenaArtikla);
		postaviModelCeneArtikla(new ArrayList<>(), tableCenaArtikla);
		ArrayList lista;
		
		try {
			lista = Kontroler.getInstance().getArtikli();
			postaviModelCeneArtikla(lista,tableCenaArtikla);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btnNazadCenaArtikla = new JButton("Nazad");
		btnNazadCenaArtikla.setBounds(335, 261, 89, 23);
		contentPane.add(btnNazadCenaArtikla);
	}
	private void postaviModelCeneArtikla(ArrayList lista, JTable t){
		JTableModelCenaArtikla model = new JTableModelCenaArtikla(lista);
		t.setModel(model);
	}

	
}
