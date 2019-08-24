package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.Filijala;
import model.GrupaArtikala;
import table.JTableModelCenaArtikla;
import table.JTableModelProdajaPoFilijali;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameIzvestajProdajeFilijala extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNabavnaVrenostIzvestajFilijala;
	private JTextField textFieldOsnovicaIzvestajFilijala;
	private JTextField txtProdajnavrednostIzvestajProdajeFilijala;
	private JTextField textFieldRucIzvestajProdajeFiljala;
	private JTable tableIzvestajProdaje;
	

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldNabavnaVrenostIzvestajNabavke() {
		return textFieldNabavnaVrenostIzvestajFilijala;
	}

	public JTextField getTextFieldOsnovicaIzvestaj() {
		return textFieldOsnovicaIzvestajFilijala;
	}

	public JTextField getTxtProdajnavrednostIzvestajProdaje() {
		return txtProdajnavrednostIzvestajProdajeFilijala;
	}

	public JTextField getTextFieldRucIzvestajProdaje() {
		return textFieldRucIzvestajProdajeFiljala;
	}

	public JTable getTableIzvestajProdaje() {
		return tableIzvestajProdaje;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeFilijala frame = new JFrameIzvestajProdajeFilijala();
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
	public JFrameIzvestajProdajeFilijala() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 836, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilijal = new JLabel("Filijal : ");
		lblFilijal.setBounds(30, 11, 166, 14);
		contentPane.add(lblFilijal);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(206, 11, 365, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelOdIzvestajProdaje = new JLabel("DO :");
		labelOdIzvestajProdaje.setBounds(178, 28, 31, 20);
		panel.add(labelOdIzvestajProdaje);
		
		JLabel lblDoizvestajprodaje = new JLabel("OD :");
		lblDoizvestajprodaje.setBounds(10, 28, 46, 20);
		panel.add(lblDoizvestajprodaje);
		
		JDateChooser dateChooserrDoIzvestajProdaje = new JDateChooser();
		dateChooserrDoIzvestajProdaje.setBounds(219, 28, 136, 20);
		panel.add(dateChooserrDoIzvestajProdaje);
		
		JDateChooser dateChooserOdIzvestajProdaje = new JDateChooser();
		dateChooserOdIzvestajProdaje.setBounds(32, 28, 136, 20);
		panel.add(dateChooserOdIzvestajProdaje);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 118, 534, 34);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGrupaArtiklaIzvestajProdaje = new JLabel("Grupa artikla :");
		lblGrupaArtiklaIzvestajProdaje.setBounds(0, 11, 92, 14);
		panel_1.add(lblGrupaArtiklaIzvestajProdaje);
		
		JComboBox comboBoxFilijalaIzvestajProdaje = new JComboBox();
		comboBoxFilijalaIzvestajProdaje.setBounds(30, 47, 166, 20);
		contentPane.add(comboBoxFilijalaIzvestajProdaje);
		popuniComboBoxFilijala(comboBoxFilijalaIzvestajProdaje);
		comboBoxFilijalaIzvestajProdaje.setSelectedItem(null);
		comboBoxFilijalaIzvestajProdaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				postaviModelProdajaPoArtiklu(new ArrayList<Filijala>(), tableIzvestajProdaje);
				ArrayList lista;
				try {
					
						lista = Kontroler.getInstance().getIzvestajProdajePoFilijali(((Filijala) 
									comboBoxFilijalaIzvestajProdaje.getSelectedItem()).getIdFilijale(), 0, 0);
						
						postaviModelProdajaPoArtiklu(lista, tableIzvestajProdaje);

						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}			
				
			}
		});
		
		
		JComboBox comboBoxGrupaArtikalaIzvestajProdaje = new JComboBox();
		comboBoxGrupaArtikalaIzvestajProdaje.setBounds(78, 8, 80, 20);
		panel_1.add(comboBoxGrupaArtikalaIzvestajProdaje);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaIzvestajProdaje);
		comboBoxGrupaArtikalaIzvestajProdaje.setSelectedItem(null);
		comboBoxGrupaArtikalaIzvestajProdaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviModelProdajaPoArtiklu(new ArrayList<GrupaArtikala>(), tableIzvestajProdaje);
				ArrayList lista;
				try {
					
						lista = Kontroler.getInstance().getIzvestajProdajePoFilijaliPoGrupi(((Filijala) 
								comboBoxFilijalaIzvestajProdaje.getSelectedItem()).getIdFilijale(),((GrupaArtikala) 
								comboBoxGrupaArtikalaIzvestajProdaje.getSelectedItem()).getIdGrupeArtikala());
						postaviModelProdajaPoArtiklu(lista, tableIzvestajProdaje);
					
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			}
		});
		
		JLabel lblArtikalIzvestajProdaje = new JLabel("Artikal :");
		lblArtikalIzvestajProdaje.setBounds(184, 11, 46, 14);
		panel_1.add(lblArtikalIzvestajProdaje);
		
		JComboBox comboBoxArtikalIzvestajProdaje = new JComboBox();
		comboBoxArtikalIzvestajProdaje.setBounds(240, 8, 133, 20);
		panel_1.add(comboBoxArtikalIzvestajProdaje);
		
		JScrollPane scrollPaneIzvestajProdaje = new JScrollPane();
		scrollPaneIzvestajProdaje.setBounds(20, 163, 777, 231);
		contentPane.add(scrollPaneIzvestajProdaje);
		
		tableIzvestajProdaje = new JTable();
		postaviModelProdajaPoArtiklu(new ArrayList<>(), tableIzvestajProdaje);
		ArrayList lista;
		scrollPaneIzvestajProdaje.setViewportView(tableIzvestajProdaje);
		
		JPanel panelIzvestajFilijala = new JPanel();
		panelIzvestajFilijala.setBounds(30, 422, 767, 43);
		contentPane.add(panelIzvestajFilijala);
		panelIzvestajFilijala.setLayout(null);
		
		JLabel lblNabavnaVrenostFilijala = new JLabel("Nabavna vrenost :");
		lblNabavnaVrenostFilijala.setBounds(10, 11, 46, 14);
		panelIzvestajFilijala.add(lblNabavnaVrenostFilijala);
		
		textFieldNabavnaVrenostIzvestajFilijala = new JTextField();
		textFieldNabavnaVrenostIzvestajFilijala.setBounds(91, 8, 86, 20);
		panelIzvestajFilijala.add(textFieldNabavnaVrenostIzvestajFilijala);
		textFieldNabavnaVrenostIzvestajFilijala.setColumns(10);
		
		JLabel lblOsnovica = new JLabel("Osnovica :");
		lblOsnovica.setBounds(201, 11, 46, 14);
		panelIzvestajFilijala.add(lblOsnovica);
		
		textFieldOsnovicaIzvestajFilijala = new JTextField();
		textFieldOsnovicaIzvestajFilijala.setBounds(273, 8, 86, 20);
		panelIzvestajFilijala.add(textFieldOsnovicaIzvestajFilijala);
		textFieldOsnovicaIzvestajFilijala.setColumns(10);
		
		JLabel lblProdajnaVrednost = new JLabel("Prodajna vrednost :");
		lblProdajnaVrednost.setBounds(394, 11, 46, 14);
		panelIzvestajFilijala.add(lblProdajnaVrednost);
		
		txtProdajnavrednostIzvestajProdajeFilijala = new JTextField();
		txtProdajnavrednostIzvestajProdajeFilijala.setBounds(450, 8, 86, 20);
		panelIzvestajFilijala.add(txtProdajnavrednostIzvestajProdajeFilijala);
		txtProdajnavrednostIzvestajProdajeFilijala.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC :");
		lblRuc.setBounds(562, 11, 46, 14);
		panelIzvestajFilijala.add(lblRuc);
		
		textFieldRucIzvestajProdajeFiljala = new JTextField();
		textFieldRucIzvestajProdajeFiljala.setBounds(635, 8, 86, 20);
		panelIzvestajFilijala.add(textFieldRucIzvestajProdajeFiljala);
		textFieldRucIzvestajProdajeFiljala.setColumns(10);
		
		
	}
	private void postaviModelProdajaPoArtiklu(ArrayList lista, JTable t){
		 JTableModelProdajaPoFilijali model = new  JTableModelProdajaPoFilijali(lista);
		t.setModel(model);
	}
	
	private  void popuniComboBoxGrupaArtikala(JComboBox<GrupaArtikala> comboBox) {
		try {
			ArrayList<GrupaArtikala> lista = Kontroler.getInstance().getGrupaArtikala();

			for (GrupaArtikala ga : lista) {
				comboBox.addItem(ga);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private  void popuniComboBoxArtikli(JComboBox<Artikli> comboBox, Integer id_grupe_artikala) {
		

		try {
			comboBox.removeAllItems();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikli(id_grupe_artikala);

			// for (GlavnaGrupa gg : lista) {
			for (Artikli a : lista1) {
				comboBox.addItem(a);		

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	
	private void popuniComboBoxFilijala(JComboBox<Filijala> comboBox) {
		try {
			ArrayList<Filijala> lista = Kontroler.getInstance().getFilijala();

			for (Filijala f : lista) {
				comboBox.addItem(f);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
