package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import table.JTableModelGrupeArtikala;
import table.JTableModelRacunOtpremnica;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class JFrameRacun_otpreminica extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKupacRacun;
	private JTextField textFieldRacunOtpremnicaRacun;
	private JLabel lblDatumRacun;
	private JTextField textFieldNetoRacun;
	private JTextField textFieldPDVRacun;
	private JTextField textFieldBrutoRacun;
	private JTable tableStavkeRacuna;
	private JButton btnNovaPoyicijaRacun;

	public JButton getBtnNovaPoyicijaRacun() {
		return btnNovaPoyicijaRacun;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameRacun_otpreminica frame = new JFrameRacun_otpreminica();
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
	public JFrameRacun_otpreminica() {
		setTitle("Racun/Otpreminica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKupacRacun = new JLabel("Kupac :");
		lblKupacRacun.setBounds(10, 34, 113, 14);
		contentPane.add(lblKupacRacun);

		JLabel lblRacunotpreminica = new JLabel("Racun/Otpreminica :");
		lblRacunotpreminica.setBounds(10, 75, 113, 14);
		contentPane.add(lblRacunotpreminica);

		textFieldKupacRacun = new JTextField();
		textFieldKupacRacun.setBounds(133, 31, 86, 20);
		contentPane.add(textFieldKupacRacun);
		textFieldKupacRacun.setColumns(10);

		textFieldRacunOtpremnicaRacun = new JTextField();
		textFieldRacunOtpremnicaRacun.setBounds(133, 72, 86, 20);
		contentPane.add(textFieldRacunOtpremnicaRacun);
		textFieldRacunOtpremnicaRacun.setColumns(10);

		lblDatumRacun = new JLabel("Datum :");
		lblDatumRacun.setBounds(306, 34, 46, 14);
		contentPane.add(lblDatumRacun);

		JDateChooser dateChooserRacunOtpremnica = new JDateChooser();
		dateChooserRacunOtpremnica.setBounds(410, 31, 277, 20);
		contentPane.add(dateChooserRacunOtpremnica);

		JLabel lblNetopdvbruto = new JLabel("Neto/PDV/Bruto :");
		lblNetopdvbruto.setBounds(306, 75, 91, 14);
		contentPane.add(lblNetopdvbruto);

		textFieldNetoRacun = new JTextField();
		textFieldNetoRacun.setBounds(410, 72, 86, 20);
		contentPane.add(textFieldNetoRacun);
		textFieldNetoRacun.setColumns(10);

		textFieldPDVRacun = new JTextField();
		textFieldPDVRacun.setBounds(505, 72, 86, 20);
		contentPane.add(textFieldPDVRacun);
		textFieldPDVRacun.setColumns(10);

		textFieldBrutoRacun = new JTextField();
		textFieldBrutoRacun.setBounds(601, 72, 86, 20);
		contentPane.add(textFieldBrutoRacun);
		textFieldBrutoRacun.setColumns(10);

		JScrollPane scrollPaneRacun = new JScrollPane();
		scrollPaneRacun.setBounds(10, 122, 859, 288);
		contentPane.add(scrollPaneRacun);

		tableStavkeRacuna = new JTable();
		postaviModelRAcunaOtpremnice(new ArrayList<>(), tableStavkeRacuna);
		ArrayList lista;
		
		scrollPaneRacun.setViewportView(tableStavkeRacuna);

		btnNovaPoyicijaRacun = new JButton("Nova Pozicija");
		btnNovaPoyicijaRacun.setBounds(10, 433, 130, 23);
		contentPane.add(btnNovaPoyicijaRacun);

		JButton btnIzmeniRacun = new JButton("Izmeni");
		btnIzmeniRacun.setBounds(157, 433, 89, 23);
		contentPane.add(btnIzmeniRacun);

		JButton btnBrisiRacun = new JButton("Brisi");
		btnBrisiRacun.setBounds(263, 433, 89, 23);
		contentPane.add(btnBrisiRacun);

		JButton btnKreirajRacun = new JButton("Kreiraj");
		btnKreirajRacun.setBounds(780, 433, 89, 23);
		contentPane.add(btnKreirajRacun);
	}
	private void postaviModelRAcunaOtpremnice(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
		t.setModel(model);
	}
	
}
