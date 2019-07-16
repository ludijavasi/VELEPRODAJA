package jpanel;

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
		setBorder(new TitledBorder(null, "Obrisi Zaposlenog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		JLabel lblUnesiIdZaposlenog = new JLabel("Unesi ID Zaposlenog :");
		lblUnesiIdZaposlenog.setBounds(69, 36, 138, 28);
		add(lblUnesiIdZaposlenog);

		textIDZaposlenog = new JTextField();
		textIDZaposlenog.setBounds(69, 75, 103, 28);
		add(textIDZaposlenog);
		textIDZaposlenog.setColumns(10);

		JButton btnOtvoriZaposlenog = new JButton("Otvori Zaposlenog");
		btnOtvoriZaposlenog.setBounds(56, 129, 141, 28);
		add(btnOtvoriZaposlenog);
		btnOtvoriZaposlenog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}

}
