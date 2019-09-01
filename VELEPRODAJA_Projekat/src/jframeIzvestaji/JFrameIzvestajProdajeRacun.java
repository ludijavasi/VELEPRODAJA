package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.Filijala;
import model.GrupaArtikala;
import model.Izvestaj;
import model.Kupac;
import table.JTableModelPregledRacunaRacuna;
import table.JTableModelProdajPoRacunu;
import table.JTableModelProdajaPoFilijali;
import table.JTableModelProdajaPoKupacu;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JFrameIzvestajProdajeRacun extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledRAcuna;
	private JComboBox comboBoxKupacPregledRacuna;
	private JDateChooser dateChooserpregledRacunaDO;
	private JDateChooser dateChooserPregledRacunaOD;
	private JComboBox comboBoxGrupaArtiklaPregledRacuna;
	private JComboBox comboBoxArtikalPregledRAcuna;
	private JTextField textFieldNbavnaVrednostRacun;
	private JTextField textFieldOsnovicaRAcun;
	private JTextField textFieldProdajnaVrednostRacun;
	private JTextField textFieldRucRacun;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeRacun frame = new JFrameIzvestajProdajeRacun();
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
	public JFrameIzvestajProdajeRacun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Kupac : ");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(10, 11, 170, 20);
		contentPane.add(label);
		
		comboBoxKupacPregledRacuna = new JComboBox();
		comboBoxKupacPregledRacuna.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxKupacPregledRacuna.setBounds(10, 42, 200, 20);
		contentPane.add(comboBoxKupacPregledRacuna);
		popuniComboBoxIzvestajKupac(comboBoxKupacPregledRacuna);
		comboBoxKupacPregledRacuna.setSelectedItem(null);
		
		comboBoxKupacPregledRacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				postaviModelProdajaPoRacunu(new ArrayList<Kupac>(), tablePregledRAcuna);
				ArrayList lista;
				try {
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
						String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
						String sd1 = sdf.format(dateChooserpregledRacunaDO.getDate());

						lista = Kontroler.getInstance().getIzvestajProdajePoKupcu(((Kupac) 
								comboBoxKupacPregledRacuna.getSelectedItem()).getIdKupca(),sd,sd1);
						
						postaviModelProdajaPoRacunu(lista, tablePregledRAcuna);
						suma(tablePregledRAcuna);
						
						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
			}
		});
		
		JPanel panelPodaciZaPeriodRacun = new JPanel();
		panelPodaciZaPeriodRacun.setLayout(null);
		panelPodaciZaPeriodRacun.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodaciZaPeriodRacun.setBounds(274, 11, 470, 60);
		contentPane.add(panelPodaciZaPeriodRacun);
		
		JLabel label_1 = new JLabel("DO :");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(260, 30, 30, 20);
		panelPodaciZaPeriodRacun.add(label_1);
		
		JLabel label_2 = new JLabel("OD :");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(10, 30, 30, 20);
		panelPodaciZaPeriodRacun.add(label_2);
		
		dateChooserpregledRacunaDO = new JDateChooser();
		dateChooserpregledRacunaDO.setBounds(310, 30, 150, 20);
		panelPodaciZaPeriodRacun.add(dateChooserpregledRacunaDO);
		
		dateChooserPregledRacunaOD = new JDateChooser();
		dateChooserPregledRacunaOD.setBounds(60, 30, 150, 20);
		panelPodaciZaPeriodRacun.add(dateChooserPregledRacunaOD);
		
		JPanel panelFilterPregledRacuna = new JPanel();
		panelFilterPregledRacuna.setLayout(null);
		panelFilterPregledRacuna.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterPregledRacuna.setBounds(10, 92, 734, 50);
		contentPane.add(panelFilterPregledRacuna);
		
		JLabel label_3 = new JLabel("Grupa artikla :");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(10, 20, 110, 20);
		panelFilterPregledRacuna.add(label_3);
		
		comboBoxGrupaArtiklaPregledRacuna = new JComboBox();
		comboBoxGrupaArtiklaPregledRacuna.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtiklaPregledRacuna.setBounds(150, 20, 200, 20);
		panelFilterPregledRacuna.add(comboBoxGrupaArtiklaPregledRacuna);
		
		JLabel label_4 = new JLabel("Artikal :");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(400, 20, 70, 20);
		panelFilterPregledRacuna.add(label_4);
		
		comboBoxArtikalPregledRAcuna = new JComboBox();
		comboBoxArtikalPregledRAcuna.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalPregledRAcuna.setBounds(490, 20, 200, 20);
		panelFilterPregledRacuna.add(comboBoxArtikalPregledRAcuna);
		
		JScrollPane scrollPanePregledRAcuna = new JScrollPane();
		scrollPanePregledRAcuna.setBounds(0, 192, 1110, 287);
		contentPane.add(scrollPanePregledRAcuna);
		
		tablePregledRAcuna = new JTable();
		scrollPanePregledRAcuna.setViewportView(tablePregledRAcuna);
		postaviModelProdajaPoRacunu(new ArrayList<Izvestaj>(), tablePregledRAcuna);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 490, 1100, 50);
		contentPane.add(panel);
		
		JLabel label_5 = new JLabel("Nabavna vrenost :");
		label_5.setFont(new Font("Arial", Font.BOLD, 14));
		label_5.setBounds(10, 20, 130, 20);
		panel.add(label_5);
		
		textFieldNbavnaVrednostRacun = new JTextField();
		textFieldNbavnaVrednostRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNbavnaVrednostRacun.setColumns(10);
		textFieldNbavnaVrednostRacun.setBounds(160, 20, 120, 20);
		panel.add(textFieldNbavnaVrednostRacun);
		
		JLabel label_6 = new JLabel("Osnovica :");
		label_6.setFont(new Font("Arial", Font.BOLD, 14));
		label_6.setBounds(320, 20, 80, 20);
		panel.add(label_6);
		
		textFieldOsnovicaRAcun = new JTextField();
		textFieldOsnovicaRAcun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldOsnovicaRAcun.setColumns(10);
		textFieldOsnovicaRAcun.setBounds(420, 20, 120, 20);
		panel.add(textFieldOsnovicaRAcun);
		
		JLabel label_7 = new JLabel("Prodajna vrednost :");
		label_7.setFont(new Font("Arial", Font.BOLD, 14));
		label_7.setBounds(580, 20, 140, 20);
		panel.add(label_7);
		
		textFieldProdajnaVrednostRacun = new JTextField();
		textFieldProdajnaVrednostRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldProdajnaVrednostRacun.setColumns(10);
		textFieldProdajnaVrednostRacun.setBounds(740, 20, 120, 20);
		panel.add(textFieldProdajnaVrednostRacun);
		
		JLabel label_8 = new JLabel("RUC :");
		label_8.setFont(new Font("Arial", Font.BOLD, 14));
		label_8.setBounds(900, 20, 50, 20);
		panel.add(label_8);
		
		textFieldRucRacun = new JTextField();
		textFieldRucRacun.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldRucRacun.setColumns(10);
		textFieldRucRacun.setBounds(970, 20, 120, 20);
		panel.add(textFieldRucRacun);
	}
	private void postaviModelProdajaPoRacunu(ArrayList lista, JTable t){
		JTableModelProdajPoRacunu model = new  JTableModelProdajPoRacunu(lista);
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
	
	
	private void suma (JTable t) {
		double sum = 0; double sum1 = 0; double sum2 = 0;
		
		for (int i = 0; i < tablePregledRAcuna.getRowCount(); i++) { 
			sum = sum + Double.parseDouble(tablePregledRAcuna.getValueAt(i,7).toString());
				
		}
		for (int i1 = 0; i1 < tablePregledRAcuna.getRowCount(); i1++) {
			sum1 = sum1 + Double.parseDouble(tablePregledRAcuna.getValueAt(i1,11).toString());
		 		
		 		}
		for (int i2 = 0; i2 < tablePregledRAcuna.getRowCount(); i2++) {
			sum2 = sum2 + Double.parseDouble(tablePregledRAcuna.getValueAt(i2,10).toString());
			
			}
				textFieldNbavnaVrednostRacun.setText(Double.toString(sum));
				textFieldRucRacun.setText(Double.toString(sum2-sum));
				textFieldOsnovicaRAcun.setText(Double.toString(sum1));
				textFieldProdajnaVrednostRacun.setText(Double.toString(sum2)); 
		  }

}
