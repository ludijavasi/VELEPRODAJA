package jpanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class JPanelObrisiFilijalu extends JPanel {
	private JTextField textUnesiIdBrisiFilijale;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiFilijalu() {
		setBorder(new TitledBorder(null, "Obrisi Filijalu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JLabel lblUnesiIdBrisiFilijale = new JLabel("Unesi ID Filiajle");
		lblUnesiIdBrisiFilijale.setBounds(74, 40, 102, 26);
		add(lblUnesiIdBrisiFilijale);

		textUnesiIdBrisiFilijale = new JTextField();
		textUnesiIdBrisiFilijale.setColumns(10);
		textUnesiIdBrisiFilijale.setBounds(55, 77, 121, 20);
		add(textUnesiIdBrisiFilijale);

		JButton btnOtvoriBrisiFilijalu = new JButton("Otvori Kupca");
		btnOtvoriBrisiFilijalu.setBounds(52, 125, 124, 23);
		add(btnOtvoriBrisiFilijalu);

	}
}
