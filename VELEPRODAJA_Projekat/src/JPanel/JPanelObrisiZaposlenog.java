package JPanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelObrisiZaposlenog extends JPanel {
	private JTextField textIDZaposlenog;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiZaposlenog() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Obrisi zaposlenog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 276, 233);
		add(panel);
		panel.setLayout(null);

		JLabel lblUnesiIdZaposlenog = new JLabel("Unesi ID Zaposlenog :");
		lblUnesiIdZaposlenog.setBounds(62, 36, 138, 28);
		panel.add(lblUnesiIdZaposlenog);

		textIDZaposlenog = new JTextField();
		textIDZaposlenog.setBounds(72, 85, 103, 28);
		panel.add(textIDZaposlenog);
		textIDZaposlenog.setColumns(10);

		JButton btnOtvoriZaposlenog = new JButton("Otvori Zaposlenog");
		btnOtvoriZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOtvoriZaposlenog.setBounds(59, 143, 141, 28);
		panel.add(btnOtvoriZaposlenog);

	}

}
