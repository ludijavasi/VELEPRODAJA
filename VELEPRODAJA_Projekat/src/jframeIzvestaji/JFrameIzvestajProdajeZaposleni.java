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
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Izvestaj;
import model.Kupac;
import model.Zaposleni;
import table.JTableModelProdajaPoKupacu;
import table.JTableModelProdajaPoZaposlenom;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JFrameIzvestajProdajeZaposleni extends JFrame {

	private JPanel contentPane;
	private JTable tableIzvestajProdajeZaposlenog;
	private JTextField textFieldNabavnaVrenostIzvestajZaposleni;
	private JTextField textFieldOsnovicaIzvestajZaposleni;
	private JTextField textProdajnavrednostIzvestajProdajeZaposleni;
	private JTextField textFieldRucIzvestajProdajeZaposleni;
	
	

	

	public JTable getTableIzvestajProdajeZaposlenog() {
		return tableIzvestajProdajeZaposlenog;
	}

	public void setTableIzvestajProdajeZaposlenog(JTable tableIzvestajProdajeZaposlenog) {
		this.tableIzvestajProdajeZaposlenog = tableIzvestajProdajeZaposlenog;
	}

	public JTextField getTextFieldNabavnaVrenostIzvestajZaposleni() {
		return textFieldNabavnaVrenostIzvestajZaposleni;
	}

	public void setTextFieldNabavnaVrenostIzvestajZaposleni(JTextField textFieldNabavnaVrenostIzvestajZaposleni) {
		this.textFieldNabavnaVrenostIzvestajZaposleni = textFieldNabavnaVrenostIzvestajZaposleni;
	}

	public JTextField getTextFieldOsnovicaIzvestajZaposleni() {
		return textFieldOsnovicaIzvestajZaposleni;
	}

	public void setTextFieldOsnovicaIzvestajZaposleni(JTextField textFieldOsnovicaIzvestajZaposleni) {
		this.textFieldOsnovicaIzvestajZaposleni = textFieldOsnovicaIzvestajZaposleni;
	}

	public JTextField getTextProdajnavrednostIzvestajProdajeZaposleni() {
		return textProdajnavrednostIzvestajProdajeZaposleni;
	}

	public void setTextProdajnavrednostIzvestajProdajeZaposleni(JTextField textProdajnavrednostIzvestajProdajeZaposleni) {
		this.textProdajnavrednostIzvestajProdajeZaposleni = textProdajnavrednostIzvestajProdajeZaposleni;
	}

	public JTextField getTextFieldRucIzvestajProdajeZaposleni() {
		return textFieldRucIzvestajProdajeZaposleni;
	}

	public void setTextFieldRucIzvestajProdajeZaposleni(JTextField textFieldRucIzvestajProdajeZaposleni) {
		this.textFieldRucIzvestajProdajeZaposleni = textFieldRucIzvestajProdajeZaposleni;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeZaposleni frame = new JFrameIzvestajProdajeZaposleni();
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
	public JFrameIzvestajProdajeZaposleni() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZaposleni = new JLabel("Zaposleni : ");
		lblZaposleni.setBounds(10, 11, 166, 14);
		contentPane.add(lblZaposleni);
		
		JComboBox comboBoxZaposleniIzvestaj = new JComboBox();
		comboBoxZaposleniIzvestaj.setBounds(10, 31, 166, 20);
		contentPane.add(comboBoxZaposleniIzvestaj);
		popuniComboBoxIzvestajZaposleni(comboBoxZaposleniIzvestaj);
		
		JPanel panelPodaciZaPeriodIzvestajZaposleni = new JPanel();
		panelPodaciZaPeriodIzvestajZaposleni.setBounds(205, 11, 365, 56);
		panelPodaciZaPeriodIzvestajZaposleni.setLayout(null);
		panelPodaciZaPeriodIzvestajZaposleni.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelPodaciZaPeriodIzvestajZaposleni);
		
		JLabel label = new JLabel("DO :");
		label.setBounds(178, 28, 31, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(label);
		
		JLabel label_1 = new JLabel("OD :");
		label_1.setBounds(10, 28, 46, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(label_1);
		
		JDateChooser dateChooserDoIzvestajZaposlenog = new JDateChooser();
		dateChooserDoIzvestajZaposlenog.setBounds(219, 28, 136, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(dateChooserDoIzvestajZaposlenog);
		
		JDateChooser dateChooserOdIzvestajZaposlenog = new JDateChooser();
		dateChooserOdIzvestajZaposlenog.setBounds(32, 28, 136, 20);
		panelPodaciZaPeriodIzvestajZaposleni.add(dateChooserOdIzvestajZaposlenog);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 702, 243);
		contentPane.add(scrollPane);
		
		tableIzvestajProdajeZaposlenog = new JTable();
		scrollPane.setViewportView(tableIzvestajProdajeZaposlenog);
		postaviModelProdajaPoZaposlenom(new ArrayList<>(), tableIzvestajProdajeZaposlenog);
		
		
		JPanel panelFilterIzvestaZaposleni = new JPanel();
		panelFilterIzvestaZaposleni.setLayout(null);
		panelFilterIzvestaZaposleni.setBounds(10, 65, 534, 34);
		contentPane.add(panelFilterIzvestaZaposleni);
		
		JLabel label_2 = new JLabel("Grupa artikla :");
		label_2.setBounds(0, 11, 92, 14);
		panelFilterIzvestaZaposleni.add(label_2);
		
		JComboBox comboBoxIzvestajZaposleniGrupaArtikla = new JComboBox();
		comboBoxIzvestajZaposleniGrupaArtikla.setBounds(78, 8, 80, 20);
		panelFilterIzvestaZaposleni.add(comboBoxIzvestajZaposleniGrupaArtikla);
		
		JLabel label_3 = new JLabel("Artikal :");
		label_3.setBounds(184, 11, 46, 14);
		panelFilterIzvestaZaposleni.add(label_3);
		
		JComboBox comboBoxIzvestakZaposlenihArikal = new JComboBox();
		comboBoxIzvestakZaposlenihArikal.setBounds(240, 8, 133, 20);
		panelFilterIzvestaZaposleni.add(comboBoxIzvestakZaposlenihArikal);
		
		JPanel panelIzvestajZaposleni = new JPanel();
		panelIzvestajZaposleni.setLayout(null);
		panelIzvestajZaposleni.setBounds(10, 377, 767, 43);
		contentPane.add(panelIzvestajZaposleni);
		
		JLabel label_4 = new JLabel("Nabavna vrenost :");
		label_4.setBounds(10, 11, 46, 14);
		panelIzvestajZaposleni.add(label_4);
		
		textFieldNabavnaVrenostIzvestajZaposleni = new JTextField();
		textFieldNabavnaVrenostIzvestajZaposleni.setColumns(10);
		textFieldNabavnaVrenostIzvestajZaposleni.setBounds(91, 8, 86, 20);
		panelIzvestajZaposleni.add(textFieldNabavnaVrenostIzvestajZaposleni);
		
		JLabel label_5 = new JLabel("Osnovica :");
		label_5.setBounds(201, 11, 46, 14);
		panelIzvestajZaposleni.add(label_5);
		
		textFieldOsnovicaIzvestajZaposleni = new JTextField();
		textFieldOsnovicaIzvestajZaposleni.setColumns(10);
		textFieldOsnovicaIzvestajZaposleni.setBounds(273, 8, 86, 20);
		panelIzvestajZaposleni.add(textFieldOsnovicaIzvestajZaposleni);
		
		JLabel label_6 = new JLabel("Prodajna vrednost :");
		label_6.setBounds(394, 11, 46, 14);
		panelIzvestajZaposleni.add(label_6);
		
		textProdajnavrednostIzvestajProdajeZaposleni = new JTextField();
		textProdajnavrednostIzvestajProdajeZaposleni.setColumns(10);
		textProdajnavrednostIzvestajProdajeZaposleni.setBounds(450, 8, 86, 20);
		panelIzvestajZaposleni.add(textProdajnavrednostIzvestajProdajeZaposleni);
		
		JLabel label_7 = new JLabel("RUC :");
		label_7.setBounds(562, 11, 46, 14);
		panelIzvestajZaposleni.add(label_7);
		
		textFieldRucIzvestajProdajeZaposleni = new JTextField();
		textFieldRucIzvestajProdajeZaposleni.setColumns(10);
		textFieldRucIzvestajProdajeZaposleni.setBounds(635, 8, 86, 20);
		panelIzvestajZaposleni.add(textFieldRucIzvestajProdajeZaposleni);
	}
	
	private void postaviModelProdajaPoZaposlenom(ArrayList<Izvestaj> lista, JTable t){
		 JTableModelProdajaPoZaposlenom model = new  JTableModelProdajaPoZaposlenom(lista);
		t.setModel(model);
	}
		
	private void popuniComboBoxIzvestajZaposleni(JComboBox<Zaposleni> comboBox) {
		try {
			ArrayList<Zaposleni> lista = Kontroler.getInstance().getZaposleni();

			for (Zaposleni k : lista) {
				comboBox.addItem(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
