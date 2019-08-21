package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import table.JTableModelCenaArtikla;
import table.JTableModelProdajaPoArtiklu;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFrameIzvestajProdaje extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNabavnaVrenostIzvestajNabavke;
	private JTextField textFieldOsnovicaIzvestaj;
	private JTextField txtProdajnavrednostIzvestajProdaje;
	private JTextField textFieldRucIzvestajProdaje;
	private JTable tableIzvestajProdaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdaje frame = new JFrameIzvestajProdaje();
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
	public JFrameIzvestajProdaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilijal = new JLabel("Filijal : ");
		lblFilijal.setBounds(30, 11, 166, 14);
		contentPane.add(lblFilijal);
		
		JComboBox comboBoxFilijalaIzvestajProdaje = new JComboBox();
		comboBoxFilijalaIzvestajProdaje.setBounds(30, 47, 166, 20);
		contentPane.add(comboBoxFilijalaIzvestajProdaje);
		
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
		
		JComboBox comboBoxGrupaArtikalaIzvestajProdaje = new JComboBox();
		comboBoxGrupaArtikalaIzvestajProdaje.setBounds(78, 8, 80, 20);
		panel_1.add(comboBoxGrupaArtikalaIzvestajProdaje);
		
		JLabel lblArtikalIzvestajProdaje = new JLabel("Artikal :");
		lblArtikalIzvestajProdaje.setBounds(184, 11, 46, 14);
		panel_1.add(lblArtikalIzvestajProdaje);
		
		JComboBox comboBoxArtikalIzvestajProdaje = new JComboBox();
		comboBoxArtikalIzvestajProdaje.setBounds(240, 8, 133, 20);
		panel_1.add(comboBoxArtikalIzvestajProdaje);
		
		JLabel lblNabavnaVrenost = new JLabel("Nabavna vrenost :");
		lblNabavnaVrenost.setBounds(10, 424, 46, 14);
		contentPane.add(lblNabavnaVrenost);
		
		textFieldNabavnaVrenostIzvestajNabavke = new JTextField();
		textFieldNabavnaVrenostIzvestajNabavke.setBounds(93, 421, 86, 20);
		contentPane.add(textFieldNabavnaVrenostIzvestajNabavke);
		textFieldNabavnaVrenostIzvestajNabavke.setColumns(10);
		
		JLabel lblOsnovica = new JLabel("Osnovica :");
		lblOsnovica.setBounds(198, 424, 46, 14);
		contentPane.add(lblOsnovica);
		
		textFieldOsnovicaIzvestaj = new JTextField();
		textFieldOsnovicaIzvestaj.setBounds(254, 421, 86, 20);
		contentPane.add(textFieldOsnovicaIzvestaj);
		textFieldOsnovicaIzvestaj.setColumns(10);
		
		JLabel lblProdajnaVrednost = new JLabel("Prodajna vrednost :");
		lblProdajnaVrednost.setBounds(360, 424, 46, 14);
		contentPane.add(lblProdajnaVrednost);
		
		txtProdajnavrednostIzvestajProdaje = new JTextField();
		txtProdajnavrednostIzvestajProdaje.setBounds(416, 421, 86, 20);
		contentPane.add(txtProdajnavrednostIzvestajProdaje);
		txtProdajnavrednostIzvestajProdaje.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC :");
		lblRuc.setBounds(537, 424, 46, 14);
		contentPane.add(lblRuc);
		
		textFieldRucIzvestajProdaje = new JTextField();
		textFieldRucIzvestajProdaje.setBounds(593, 421, 86, 20);
		contentPane.add(textFieldRucIzvestajProdaje);
		textFieldRucIzvestajProdaje.setColumns(10);
		
		JScrollPane scrollPaneIzvestajProdaje = new JScrollPane();
		scrollPaneIzvestajProdaje.setBounds(20, 163, 777, 231);
		contentPane.add(scrollPaneIzvestajProdaje);
		
		tableIzvestajProdaje = new JTable();
		postaviModelProdajaPoArtiklu(new ArrayList<>(), tableIzvestajProdaje);
		ArrayList lista;
		scrollPaneIzvestajProdaje.setViewportView(tableIzvestajProdaje);
	}
	private void postaviModelProdajaPoArtiklu(ArrayList lista, JTable t){
		 JTableModelProdajaPoArtiklu model = new  JTableModelProdajaPoArtiklu(lista);
		t.setModel(model);
	}
}
