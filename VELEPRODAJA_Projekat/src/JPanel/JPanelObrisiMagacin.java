package JPanel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanelObrisiMagacin extends JPanel {
	private JTextField textFieldIdMagacina;

	/**
	 * Create the panel.
	 */
	public JPanelObrisiMagacin() {
		setLayout(null);
		
		JPanel panelObrisiMagacin = new JPanel();
		panelObrisiMagacin.setBorder(new TitledBorder(null, "Obrisi magacin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelObrisiMagacin.setBounds(36, 36, 371, 234);
		add(panelObrisiMagacin);
		panelObrisiMagacin.setLayout(null);
		
		JLabel lblUnesiIdMagacina = new JLabel("Unesi ID magacina :");
		lblUnesiIdMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnesiIdMagacina.setBounds(108, 56, 161, 28);
		panelObrisiMagacin.add(lblUnesiIdMagacina);
		
		textFieldIdMagacina = new JTextField();
		textFieldIdMagacina.setBounds(133, 112, 86, 20);
		panelObrisiMagacin.add(textFieldIdMagacina);
		textFieldIdMagacina.setColumns(10);
		
		JButton btnOtvoriMagacin = new JButton("Otvori magacin");
		btnOtvoriMagacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriMagacin.setBounds(108, 170, 143, 23);
		panelObrisiMagacin.add(btnOtvoriMagacin);

	}

}
