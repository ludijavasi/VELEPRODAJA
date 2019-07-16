package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameMagacin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAdresaMagacina;
	private JTextField textFieldTelefonMagacina;
	private JTextField textFieldGradMagacina;
	private JTextField textFieldEmailMagacina;
	private JTextField textFieldIdMagacina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMagacin frame = new JFrameMagacin();
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
	public JFrameMagacin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMagacin = new JPanel();
		panelMagacin.setBorder(new TitledBorder(null, "Podaci o magacinu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMagacin.setBounds(35, 36, 522, 300);
		contentPane.add(panelMagacin);
		panelMagacin.setLayout(null);
		
		JLabel lblAdresaMagacina = new JLabel("Adresa :");
		lblAdresaMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresaMagacina.setBounds(10, 38, 147, 22);
		panelMagacin.add(lblAdresaMagacina);
		
		textFieldAdresaMagacina = new JTextField();
		textFieldAdresaMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldAdresaMagacina.setBounds(188, 39, 256, 20);
		panelMagacin.add(textFieldAdresaMagacina);
		textFieldAdresaMagacina.setColumns(10);
		
		JLabel lblTelefonMagacina = new JLabel("Telefon :");
		lblTelefonMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefonMagacina.setBounds(10, 151, 147, 22);
		panelMagacin.add(lblTelefonMagacina);
		
		textFieldTelefonMagacina = new JTextField();
		textFieldTelefonMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefonMagacina.setBounds(188, 152, 256, 20);
		panelMagacin.add(textFieldTelefonMagacina);
		textFieldTelefonMagacina.setColumns(10);
		
		JLabel lblGradOpstina = new JLabel("Grad / Opstina :");
		lblGradOpstina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGradOpstina.setBounds(10, 97, 147, 22);
		panelMagacin.add(lblGradOpstina);
		
		textFieldGradMagacina = new JTextField();
		textFieldGradMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldGradMagacina.setBounds(188, 100, 256, 20);
		panelMagacin.add(textFieldGradMagacina);
		textFieldGradMagacina.setColumns(10);
		
		JLabel lblEmailMagacina = new JLabel("E-mail :");
		lblEmailMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailMagacina.setBounds(10, 207, 147, 22);
		panelMagacin.add(lblEmailMagacina);
		
		textFieldEmailMagacina = new JTextField();
		textFieldEmailMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmailMagacina.setBounds(188, 210, 256, 20);
		panelMagacin.add(textFieldEmailMagacina);
		textFieldEmailMagacina.setColumns(10);
		
		JLabel lblIdMagacina = new JLabel("ID :");
		lblIdMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdMagacina.setBounds(10, 264, 46, 25);
		panelMagacin.add(lblIdMagacina);
		
		textFieldIdMagacina = new JTextField();
		textFieldIdMagacina.setBounds(188, 268, 86, 20);
		panelMagacin.add(textFieldIdMagacina);
		textFieldIdMagacina.setColumns(10);
		
		JButton btnDodajMagacin = new JButton("Dodaj magacin");
		btnDodajMagacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDodajMagacin.setBounds(567, 249, 172, 23);
		contentPane.add(btnDodajMagacin);
		
		JButton btnObrisiMagacin = new JButton("Obrisi magacin");
		btnObrisiMagacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnObrisiMagacin.setBounds(567, 313, 172, 23);
		contentPane.add(btnObrisiMagacin);
	}
}
