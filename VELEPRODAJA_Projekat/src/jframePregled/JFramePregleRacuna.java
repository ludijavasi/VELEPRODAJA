package jframePregled;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Kupac;
import table.JTableModelPregledRacunaRacuna;
import table.JTableModelProdajaPoFilijali;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class JFramePregleRacuna extends JFrame {

	private JPanel contentPane;
	private JTable tablePregledRacuna;
	private JDateChooser dateChooserPregledRacunaDO;
	private JDateChooser dateChooserPregledRacunaOD;
	private JTextField textFieldUkupnoNetoPregledRacuna;
	private JTextField textFieldUkupnoPdvPregledRacuna;
	private JTextField textFieldUkupnoBrutoPregledRacuna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePregleRacuna frame = new JFramePregleRacuna();
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
	public JFramePregleRacuna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPodaciZaPeriodPregedRAcuna = new JPanel();
		panelPodaciZaPeriodPregedRAcuna.setLayout(null);
		panelPodaciZaPeriodPregedRAcuna.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodaciZaPeriodPregedRAcuna.setBounds(20, 25, 596, 60);
		contentPane.add(panelPodaciZaPeriodPregedRAcuna);
		
		JLabel label = new JLabel("DO :");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(260, 30, 30, 20);
		panelPodaciZaPeriodPregedRAcuna.add(label);
		
		JLabel label_1 = new JLabel("OD :");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(10, 30, 30, 20);
		panelPodaciZaPeriodPregedRAcuna.add(label_1);
		
		dateChooserPregledRacunaDO = new JDateChooser();
		dateChooserPregledRacunaDO.setBounds(310, 30, 150, 20);
		panelPodaciZaPeriodPregedRAcuna.add(dateChooserPregledRacunaDO);
		
		dateChooserPregledRacunaOD = new JDateChooser();
		dateChooserPregledRacunaOD.setBounds(60, 30, 150, 20);
		panelPodaciZaPeriodPregedRAcuna.add(dateChooserPregledRacunaOD);
		
		JButton btnPretraziPregledRAcuna = new JButton("Pretrazi");
		btnPretraziPregledRAcuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				postaviModelPregledRacuna(new ArrayList<Kupac>(), tablePregledRacuna);
				ArrayList lista;
				try {
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
						String sd = sdf.format(dateChooserPregledRacunaOD.getDate());
						String sd1 = sdf.format(dateChooserPregledRacunaDO.getDate());

						lista = Kontroler.getInstance().getRacunPregledRacuna(sd, sd1);
						
						postaviModelPregledRacuna(lista, tablePregledRacuna);
						suma(tablePregledRacuna);
						
						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
			}
		});
		btnPretraziPregledRAcuna.setBounds(474, 30, 89, 23);
		panelPodaciZaPeriodPregedRAcuna.add(btnPretraziPregledRAcuna);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 96, 596, 254);
		contentPane.add(scrollPane);
		
		tablePregledRacuna = new JTable();
		scrollPane.setViewportView(tablePregledRacuna);
		postaviModelPregledRacuna(new ArrayList<>(), tablePregledRacuna);
		
		JLabel lblUkupnoNeto = new JLabel("Ukupno neto :");
		lblUkupnoNeto.setBounds(20, 391, 86, 14);
		contentPane.add(lblUkupnoNeto);
		
		textFieldUkupnoNetoPregledRacuna = new JTextField();
		textFieldUkupnoNetoPregledRacuna.setBounds(130, 388, 86, 20);
		contentPane.add(textFieldUkupnoNetoPregledRacuna);
		textFieldUkupnoNetoPregledRacuna.setColumns(10);
		
		JLabel lblUkupnoPdv = new JLabel("Ukupno PDV :");
		lblUkupnoPdv.setBounds(262, 391, 86, 14);
		contentPane.add(lblUkupnoPdv);
		
		textFieldUkupnoPdvPregledRacuna = new JTextField();
		textFieldUkupnoPdvPregledRacuna.setBounds(371, 388, 86, 20);
		contentPane.add(textFieldUkupnoPdvPregledRacuna);
		textFieldUkupnoPdvPregledRacuna.setColumns(10);
		
		JLabel lblUkupnoButo = new JLabel("Ukupno buto :");
		lblUkupnoButo.setBounds(488, 391, 86, 14);
		contentPane.add(lblUkupnoButo);
		
		textFieldUkupnoBrutoPregledRacuna = new JTextField();
		textFieldUkupnoBrutoPregledRacuna.setBounds(594, 388, 86, 20);
		contentPane.add(textFieldUkupnoBrutoPregledRacuna);
		textFieldUkupnoBrutoPregledRacuna.setColumns(10);
	}
	private void postaviModelPregledRacuna(ArrayList lista, JTable t){
		 JTableModelPregledRacunaRacuna model = new  JTableModelPregledRacunaRacuna(lista);
		t.setModel(model);		
	}
	private void suma (JTable t) {
		double sum = 0; double sum1 = 0; double sum2 = 0;
		
		for (int i = 0; i < tablePregledRacuna.getRowCount(); i++) { 
			sum = sum + Double.parseDouble(tablePregledRacuna.getValueAt(i,4).toString());
				
		}
		for (int i1 = 0; i1 < tablePregledRacuna.getRowCount(); i1++) {
			sum1 = sum1 + Double.parseDouble(tablePregledRacuna.getValueAt(i1,6).toString());
		 		
		 		}
		for (int i2 = 0; i2 < tablePregledRacuna.getRowCount(); i2++) {
			sum2 = sum2 + Double.parseDouble(tablePregledRacuna.getValueAt(i2,5).toString());
			
			}
				textFieldUkupnoNetoPregledRacuna.setText(Double.toString(sum));
				textFieldUkupnoBrutoPregledRacuna.setText(Double.toString(sum1));
				textFieldUkupnoPdvPregledRacuna.setText(Double.toString(sum2));
			
		  }
		  
}
