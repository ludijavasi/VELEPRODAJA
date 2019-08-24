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
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.Izvestaj;
import model.Kupac;
import table.JTableModelProdajaPoFilijali;
import table.JTableModelProdajaPoKupacu;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameIzvestajProdajeKupac extends JFrame {

	private JPanel contentPane;
	private JTable tableIzvestajKupac;
	private JTextField textFieldNabavnaVrenostIzvestajKupac;
	private JTextField textFieldOsnovicaIzvestajKupac;
	private JTextField textProdajnavrednostIzvestajProdajeKupac;
	private JTextField textFieldRucIzvestajProdajeKupac;
	private JComboBox <Kupac> comboBoxIzvestajKupac;
	
	
	
	
	

	public JComboBox getComboBoxIzvestajKupac() {
		return comboBoxIzvestajKupac;
	}

	public JTable getTableIzvestajKupac() {
		return tableIzvestajKupac;
	}

	public void setTableIzvestajKupac(JTable tableIzvestajKupac) {
		this.tableIzvestajKupac = tableIzvestajKupac;
	}

	public JTextField getTextFieldNabavnaVrenostIzvestajKupac() {
		return textFieldNabavnaVrenostIzvestajKupac;
	}

	public void setTextFieldNabavnaVrenostIzvestajKupac(JTextField textFieldNabavnaVrenostIzvestajKupac) {
		this.textFieldNabavnaVrenostIzvestajKupac = textFieldNabavnaVrenostIzvestajKupac;
	}

	public JTextField getTextFieldOsnovicaIzvestajKupac() {
		return textFieldOsnovicaIzvestajKupac;
	}

	public void setTextFieldOsnovicaIzvestajKupac(JTextField textFieldOsnovicaIzvestajKupac) {
		this.textFieldOsnovicaIzvestajKupac = textFieldOsnovicaIzvestajKupac;
	}

	public JTextField getTxtProdajnavrednostIzvestajProdajeKupac() {
		return textProdajnavrednostIzvestajProdajeKupac;
	}

	public void setTxtProdajnavrednostIzvestajProdajeKupac(JTextField txtProdajnavrednostIzvestajProdajeKupac) {
		this.textProdajnavrednostIzvestajProdajeKupac = txtProdajnavrednostIzvestajProdajeKupac;
	}

	public JTextField getTextFieldRucIzvestajProdajeKupac() {
		return textFieldRucIzvestajProdajeKupac;
	}

	public void setTextFieldRucIzvestajProdajeKupac(JTextField textFieldRucIzvestajProdajeKupac) {
		this.textFieldRucIzvestajProdajeKupac = textFieldRucIzvestajProdajeKupac;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeKupac frame = new JFrameIzvestajProdajeKupac();
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
	public JFrameIzvestajProdajeKupac() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 845, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelIzvestajKupac = new JLabel("Kupac : ");
		labelIzvestajKupac.setBounds(24, 11, 166, 14);
		contentPane.add(labelIzvestajKupac);
		
		comboBoxIzvestajKupac = new JComboBox();
		comboBoxIzvestajKupac.setBounds(24, 47, 166, 20);
		contentPane.add(comboBoxIzvestajKupac);
		popuniComboBoxIzvestajKupac(comboBoxIzvestajKupac);
		comboBoxIzvestajKupac.setSelectedItem(null);
		
		JPanel panelPodacizaPeriodKupac = new JPanel();
		panelPodacizaPeriodKupac.setLayout(null);
		panelPodacizaPeriodKupac.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodacizaPeriodKupac.setBounds(207, 11, 365, 56);
		contentPane.add(panelPodacizaPeriodKupac);
		
		JLabel label = new JLabel("DO :");
		label.setBounds(178, 28, 31, 20);
		panelPodacizaPeriodKupac.add(label);
		
		JLabel label_1 = new JLabel("OD :");
		label_1.setBounds(10, 28, 46, 20);
		panelPodacizaPeriodKupac.add(label_1);
		
		JDateChooser dateChooserDoIzvestajKupac = new JDateChooser();
		dateChooserDoIzvestajKupac.setBounds(219, 28, 136, 20);
		panelPodacizaPeriodKupac.add(dateChooserDoIzvestajKupac);
		
		JDateChooser dateOdKupacIzvestaj = new JDateChooser();
		dateOdKupacIzvestaj.setBounds(32, 28, 136, 20);
		panelPodacizaPeriodKupac.add(dateOdKupacIzvestaj);
		
		JPanel panelFilterKupac = new JPanel();
		panelFilterKupac.setLayout(null);
		panelFilterKupac.setBounds(24, 89, 534, 34);
		contentPane.add(panelFilterKupac);
		
		JLabel label_2 = new JLabel("Grupa artikla :");
		label_2.setBounds(0, 11, 92, 14);
		panelFilterKupac.add(label_2);
		
		JComboBox comboBoxGrupaArtikalaIzvestajKupac = new JComboBox();
		comboBoxGrupaArtikalaIzvestajKupac.setBounds(78, 8, 80, 20);
		panelFilterKupac.add(comboBoxGrupaArtikalaIzvestajKupac);
		
		JLabel label_3 = new JLabel("Artikal :");
		label_3.setBounds(184, 11, 46, 14);
		panelFilterKupac.add(label_3);
		
		JComboBox comboBoxArtikalIzvestajKupac = new JComboBox();
		comboBoxArtikalIzvestajKupac.setBounds(240, 8, 133, 20);
		panelFilterKupac.add(comboBoxArtikalIzvestajKupac);
		
		JScrollPane scrollPaneIzvestajKupac = new JScrollPane();
		scrollPaneIzvestajKupac.setBounds(24, 148, 767, 282);
		contentPane.add(scrollPaneIzvestajKupac);
		
		tableIzvestajKupac = new JTable();
		scrollPaneIzvestajKupac.setViewportView(tableIzvestajKupac);
		postaviModelProdajaPoKupcu(new ArrayList<Izvestaj>(), tableIzvestajKupac);
		
		
		JPanel panelIzvestajKupac = new JPanel();
		panelIzvestajKupac.setLayout(null);
		panelIzvestajKupac.setBounds(24, 441, 767, 43);
		contentPane.add(panelIzvestajKupac);
		
		JLabel label_4 = new JLabel("Nabavna vrenost :");
		label_4.setBounds(10, 11, 46, 14);
		panelIzvestajKupac.add(label_4);
		
		textFieldNabavnaVrenostIzvestajKupac = new JTextField();
		textFieldNabavnaVrenostIzvestajKupac.setColumns(10);
		textFieldNabavnaVrenostIzvestajKupac.setBounds(91, 8, 86, 20);
		panelIzvestajKupac.add(textFieldNabavnaVrenostIzvestajKupac);
		
		JLabel label_5 = new JLabel("Osnovica :");
		label_5.setBounds(201, 11, 46, 14);
		panelIzvestajKupac.add(label_5);
		
		textFieldOsnovicaIzvestajKupac = new JTextField();
		textFieldOsnovicaIzvestajKupac.setColumns(10);
		textFieldOsnovicaIzvestajKupac.setBounds(273, 8, 86, 20);
		panelIzvestajKupac.add(textFieldOsnovicaIzvestajKupac);
		
		JLabel label_6 = new JLabel("Prodajna vrednost :");
		label_6.setBounds(394, 11, 46, 14);
		panelIzvestajKupac.add(label_6);
		
		textProdajnavrednostIzvestajProdajeKupac = new JTextField();
		textProdajnavrednostIzvestajProdajeKupac.setColumns(10);
		textProdajnavrednostIzvestajProdajeKupac.setBounds(450, 8, 86, 20);
		panelIzvestajKupac.add(textProdajnavrednostIzvestajProdajeKupac);
		
		JLabel label_7 = new JLabel("RUC :");
		label_7.setBounds(562, 11, 46, 14);
		panelIzvestajKupac.add(label_7);
		
		textFieldRucIzvestajProdajeKupac = new JTextField();
		textFieldRucIzvestajProdajeKupac.setColumns(10);
		textFieldRucIzvestajProdajeKupac.setBounds(635, 8, 86, 20);
		panelIzvestajKupac.add(textFieldRucIzvestajProdajeKupac);
	}
	
	private void postaviModelProdajaPoKupcu(ArrayList<Izvestaj> lista, JTable t){
		 JTableModelProdajaPoKupacu model = new  JTableModelProdajaPoKupacu(lista);
		t.setModel(model);
	}
	
	private void popuniComboBoxIzvestajKupac(JComboBox<Kupac> comboBox) {
		try {
			ArrayList<Kupac> lista = Kontroler.getInstance().getKupac();

			for (Kupac k : lista) {
				comboBox.addItem(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}