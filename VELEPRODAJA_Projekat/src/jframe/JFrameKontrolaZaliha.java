package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class JFrameKontrolaZaliha extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSkladisteKontrolaZaliha;
	private JLabel lblGlavnaGrupaKontrolaZaliha;
	private JTextField textFieldArtikalKontrolaZaliha;
	private final ButtonGroup RadioButtonGropSortiranjeKontrolaZaliha = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameKontrolaZaliha frame = new JFrameKontrolaZaliha();
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
	public JFrameKontrolaZaliha() {
		setTitle("Kontrola Zaliha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSkladisteKontrolaZaliha = new JLabel("Skladiste :");
		lblSkladisteKontrolaZaliha.setBounds(93, 31, 86, 14);
		contentPane.add(lblSkladisteKontrolaZaliha);

		textFieldSkladisteKontrolaZaliha = new JTextField();
		textFieldSkladisteKontrolaZaliha.setBounds(204, 28, 132, 20);
		contentPane.add(textFieldSkladisteKontrolaZaliha);
		textFieldSkladisteKontrolaZaliha.setColumns(10);

		lblGlavnaGrupaKontrolaZaliha = new JLabel("Glavna grupa :");
		lblGlavnaGrupaKontrolaZaliha.setBounds(93, 76, 86, 14);
		contentPane.add(lblGlavnaGrupaKontrolaZaliha);

		JComboBox comboBoxGlavnaGrupaKontrolaZaliha = new JComboBox();
		comboBoxGlavnaGrupaKontrolaZaliha.setBounds(204, 73, 132, 20);
		contentPane.add(comboBoxGlavnaGrupaKontrolaZaliha);

		JLabel lblGrupaArtikalaKontrolaZaliha = new JLabel("Grupa artikala :");
		lblGrupaArtikalaKontrolaZaliha.setBounds(93, 119, 86, 20);
		contentPane.add(lblGrupaArtikalaKontrolaZaliha);

		JComboBox comboBoxGrupaArtikalaKontrolaZaliha = new JComboBox();
		comboBoxGrupaArtikalaKontrolaZaliha.setBounds(204, 119, 132, 20);
		contentPane.add(comboBoxGrupaArtikalaKontrolaZaliha);

		JLabel lblArtikalKontrolaZaliha = new JLabel("Artikal :");
		lblArtikalKontrolaZaliha.setBounds(93, 162, 46, 14);
		contentPane.add(lblArtikalKontrolaZaliha);

		textFieldArtikalKontrolaZaliha = new JTextField();
		textFieldArtikalKontrolaZaliha.setBounds(204, 159, 132, 20);
		contentPane.add(textFieldArtikalKontrolaZaliha);
		textFieldArtikalKontrolaZaliha.setColumns(10);

		JPanel panelFilterKontrolaZaliha = new JPanel();
		panelFilterKontrolaZaliha
				.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterKontrolaZaliha.setBounds(85, 201, 155, 130);
		contentPane.add(panelFilterKontrolaZaliha);
		panelFilterKontrolaZaliha.setLayout(null);

		JCheckBox chckbxZaliheVeceOd0KontrolaZaliha = new JCheckBox("Zalihe > 0");
		chckbxZaliheVeceOd0KontrolaZaliha.setBounds(6, 23, 84, 23);
		panelFilterKontrolaZaliha.add(chckbxZaliheVeceOd0KontrolaZaliha);

		JCheckBox chckbxZaliheManjeOd0KontrolaZaliha = new JCheckBox("Zalihe < 0");
		chckbxZaliheManjeOd0KontrolaZaliha.setBounds(6, 49, 97, 23);
		panelFilterKontrolaZaliha.add(chckbxZaliheManjeOd0KontrolaZaliha);

		JCheckBox chckbxZalihejednakekontrolazaliha = new JCheckBox("Zalihe = 0");
		chckbxZalihejednakekontrolazaliha.setBounds(6, 75, 97, 23);
		panelFilterKontrolaZaliha.add(chckbxZalihejednakekontrolazaliha);

		JPanel panelSortiranjeKontrolaZaliha = new JPanel();
		panelSortiranjeKontrolaZaliha
				.setBorder(new TitledBorder(null, "Sortiranje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSortiranjeKontrolaZaliha.setBounds(260, 201, 132, 130);
		contentPane.add(panelSortiranjeKontrolaZaliha);
		panelSortiranjeKontrolaZaliha.setLayout(null);

		JRadioButton rdbtnArtikal = new JRadioButton("Artikal");
		RadioButtonGropSortiranjeKontrolaZaliha.add(rdbtnArtikal);
		rdbtnArtikal.setBounds(6, 24, 109, 23);
		panelSortiranjeKontrolaZaliha.add(rdbtnArtikal);

		JRadioButton rdbtnGrupaArikala = new JRadioButton("Grupa Arikala");
		RadioButtonGropSortiranjeKontrolaZaliha.add(rdbtnGrupaArikala);
		rdbtnGrupaArikala.setBounds(6, 53, 109, 23);
		panelSortiranjeKontrolaZaliha.add(rdbtnGrupaArikala);

		JButton btnOkKontrolaZaliha = new JButton("OK");
		btnOkKontrolaZaliha.setBounds(85, 369, 155, 23);
		contentPane.add(btnOkKontrolaZaliha);

		JButton btnPrekidKontrolaZaliha = new JButton("Prekid");
		btnPrekidKontrolaZaliha.setBounds(260, 369, 132, 23);
		contentPane.add(btnPrekidKontrolaZaliha);
	}
}
