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
	private JTextField textFieldArtikalKontrolaZaliha;
	private final ButtonGroup RadioButtonGropSortiranjeKontrolaZaliha = new ButtonGroup();
	private JButton btnPrekidKontrolaZaliha;
	private JButton btnOkKontrolaZaliha;

	public JButton getBtnPrekidKontrolaZaliha() {
		return btnPrekidKontrolaZaliha;
	}

	public JButton getBtnOkKontrolaZaliha() {
		return btnOkKontrolaZaliha;
	}

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
		setBounds(100, 100, 336, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFilterKontrolaZaliha = new JPanel();
		panelFilterKontrolaZaliha
				.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterKontrolaZaliha.setBounds(25, 163, 118, 109);
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
		panelSortiranjeKontrolaZaliha.setBounds(172, 163, 118, 103);
		contentPane.add(panelSortiranjeKontrolaZaliha);
		panelSortiranjeKontrolaZaliha.setLayout(null);

		JRadioButton rdbtnArtikal = new JRadioButton("Artikal");
		RadioButtonGropSortiranjeKontrolaZaliha.add(rdbtnArtikal);
		rdbtnArtikal.setBounds(6, 60, 109, 23);
		panelSortiranjeKontrolaZaliha.add(rdbtnArtikal);

		JRadioButton rdbtnGrupaArikala = new JRadioButton("Grupa Arikala");
		RadioButtonGropSortiranjeKontrolaZaliha.add(rdbtnGrupaArikala);
		rdbtnGrupaArikala.setBounds(6, 29, 109, 23);
		panelSortiranjeKontrolaZaliha.add(rdbtnGrupaArikala);

		btnOkKontrolaZaliha = new JButton("OK");
		btnOkKontrolaZaliha.setBounds(172, 283, 118, 23);
		contentPane.add(btnOkKontrolaZaliha);

		btnPrekidKontrolaZaliha = new JButton("Prekid");
		btnPrekidKontrolaZaliha.setBounds(25, 283, 118, 23);
		contentPane.add(btnPrekidKontrolaZaliha);

		JPanel panelPretragaKontrolaZaliha = new JPanel();
		panelPretragaKontrolaZaliha
				.setBorder(new TitledBorder(null, "Pretraga", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPretragaKontrolaZaliha.setBounds(25, 22, 265, 130);
		contentPane.add(panelPretragaKontrolaZaliha);
		panelPretragaKontrolaZaliha.setLayout(null);

		textFieldSkladisteKontrolaZaliha = new JTextField();
		textFieldSkladisteKontrolaZaliha.setBounds(123, 27, 132, 20);
		panelPretragaKontrolaZaliha.add(textFieldSkladisteKontrolaZaliha);
		textFieldSkladisteKontrolaZaliha.setColumns(10);

		JLabel lblSkladisteKontrolaZaliha = new JLabel("Skladiste :");
		lblSkladisteKontrolaZaliha.setBounds(10, 30, 86, 14);
		panelPretragaKontrolaZaliha.add(lblSkladisteKontrolaZaliha);

		JComboBox comboBoxGrupaArtikalaKontrolaZaliha = new JComboBox();
		comboBoxGrupaArtikalaKontrolaZaliha.setBounds(123, 58, 132, 20);
		panelPretragaKontrolaZaliha.add(comboBoxGrupaArtikalaKontrolaZaliha);

		JLabel lblGrupaArtikalaKontrolaZaliha = new JLabel("Grupa artikala :");
		lblGrupaArtikalaKontrolaZaliha.setBounds(10, 55, 86, 20);
		panelPretragaKontrolaZaliha.add(lblGrupaArtikalaKontrolaZaliha);

		textFieldArtikalKontrolaZaliha = new JTextField();
		textFieldArtikalKontrolaZaliha.setBounds(123, 89, 132, 20);
		panelPretragaKontrolaZaliha.add(textFieldArtikalKontrolaZaliha);
		textFieldArtikalKontrolaZaliha.setColumns(10);

		JLabel lblArtikalKontrolaZaliha = new JLabel("Artikal :");
		lblArtikalKontrolaZaliha.setBounds(10, 92, 46, 14);
		panelPretragaKontrolaZaliha.add(lblArtikalKontrolaZaliha);
	}
}
