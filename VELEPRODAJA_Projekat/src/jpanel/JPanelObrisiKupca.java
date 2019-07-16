package jpanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanelObrisiKupca extends JPanel {
	private JTextField textIDBrisiKupca;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiKupca() {
		setBorder(new TitledBorder(null, "Obrisi Kupca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JLabel lblUnesiIdBrisiKupca = new JLabel("Unesi ID Kupca");
		lblUnesiIdBrisiKupca.setBounds(106, 50, 102, 26);
		add(lblUnesiIdBrisiKupca);

		textIDBrisiKupca = new JTextField();
		textIDBrisiKupca.setBounds(87, 87, 121, 20);
		add(textIDBrisiKupca);
		textIDBrisiKupca.setColumns(10);

		JButton btnOtvoriBrisiKupca = new JButton("Otvori Kupca");
		btnOtvoriBrisiKupca.setBounds(84, 135, 124, 23);
		add(btnOtvoriBrisiKupca);

	}
}
