package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JPanelStavkeRacuna extends JPanel {
	private JTable tableStavkeRacuna;
	private JTextField textGrupaArtiklaStavkeRacuna;
	private JTextField textFieldArtikalStavkeRacuna;
	private JTextField textFieldJedinicaStavkeRacuna;
	private JTextField textFieldDostupnaKolicinaStavkeRacuna;
	private JTextField textFieldKolicinaStavkeRacuna;

	/**
	 * Create the panel.
	 */
	public JPanelStavkeRacuna() {
		setBorder(new TitledBorder(null, "Racun/Otpremnica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JLabel lblGrupaArtiklaStavkeRacuna = new JLabel("Grupa Artikla :");
		lblGrupaArtiklaStavkeRacuna.setBounds(10, 57, 81, 19);
		add(lblGrupaArtiklaStavkeRacuna);

		JLabel lblArtikalStavkeRacuna = new JLabel("Artikal :");
		lblArtikalStavkeRacuna.setBounds(10, 98, 46, 14);
		add(lblArtikalStavkeRacuna);

		JLabel lblJedinicaStavkeArtikla = new JLabel("Jedinica : ");
		lblJedinicaStavkeArtikla.setBounds(10, 131, 81, 19);
		add(lblJedinicaStavkeArtikla);

		JLabel lblDostupnaKolicinaStavkeArtikla = new JLabel("Dostupna Kolicina :");
		lblDostupnaKolicinaStavkeArtikla.setBounds(10, 161, 118, 14);
		add(lblDostupnaKolicinaStavkeArtikla);

		JLabel lblKolicinaStavkeArtikla = new JLabel("Kolicina :");
		lblKolicinaStavkeArtikla.setBounds(10, 199, 46, 14);
		add(lblKolicinaStavkeArtikla);

		JScrollPane scrollPaneStavkeRacuna = new JScrollPane();
		scrollPaneStavkeRacuna.setBounds(10, 235, 430, 78);
		add(scrollPaneStavkeRacuna);

		tableStavkeRacuna = new JTable();
		scrollPaneStavkeRacuna.setViewportView(tableStavkeRacuna);

		JButton btnSacuvajStavkeRacuna = new JButton("Sacuvaj");
		btnSacuvajStavkeRacuna.setBounds(94, 337, 89, 23);
		add(btnSacuvajStavkeRacuna);

		JButton btnPrekidStavkeRAcuna = new JButton("Prekid");
		btnPrekidStavkeRAcuna.setBounds(221, 337, 89, 23);
		add(btnPrekidStavkeRAcuna);

		textGrupaArtiklaStavkeRacuna = new JTextField();
		textGrupaArtiklaStavkeRacuna.setBounds(116, 56, 86, 20);
		add(textGrupaArtiklaStavkeRacuna);
		textGrupaArtiklaStavkeRacuna.setColumns(10);

		textFieldArtikalStavkeRacuna = new JTextField();
		textFieldArtikalStavkeRacuna.setBounds(116, 95, 86, 20);
		add(textFieldArtikalStavkeRacuna);
		textFieldArtikalStavkeRacuna.setColumns(10);

		textFieldJedinicaStavkeRacuna = new JTextField();
		textFieldJedinicaStavkeRacuna.setBounds(116, 130, 86, 20);
		add(textFieldJedinicaStavkeRacuna);
		textFieldJedinicaStavkeRacuna.setColumns(10);

		textFieldDostupnaKolicinaStavkeRacuna = new JTextField();
		textFieldDostupnaKolicinaStavkeRacuna.setBounds(116, 158, 86, 20);
		add(textFieldDostupnaKolicinaStavkeRacuna);
		textFieldDostupnaKolicinaStavkeRacuna.setColumns(10);

		textFieldKolicinaStavkeRacuna = new JTextField();
		textFieldKolicinaStavkeRacuna.setBounds(116, 196, 86, 20);
		add(textFieldKolicinaStavkeRacuna);
		textFieldKolicinaStavkeRacuna.setColumns(10);

	}

}
