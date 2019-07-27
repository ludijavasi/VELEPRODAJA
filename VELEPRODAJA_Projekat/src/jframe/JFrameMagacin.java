package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.xml.bind.ParseConversionEvent;

import kontroler.Kontroler;
import model.Magacin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameMagacin extends JFrame {

	private JPanel contentPaneMagacin;
	private JTextField textFieldNazivMagacina;
	private JTextField textFieldAdresaMagacina;
	private JTextField textFieldTelefonMagacina;
	private JTextField textFieldGradMagacina;
	private JTextField textFieldEmailMagacina;
	private JTextField textFieldIdMagacina;
	private JButton btnDodajMagacin;
	private JButton btnObrisiMagacin;
	private JButton btnPrekiniackcijuMagacin;
	private JButton btnAzurirajMagacin;
	private JLabel lblIdMagacina;

	public JPanel getContentPaneMagacin() {
		return contentPaneMagacin;
	}

	public void setContentPaneMagacin(JPanel contentPaneMagacin) {
		this.contentPaneMagacin = contentPaneMagacin;
	}

	public JTextField getTextFieldNazivMagacina() {
		return textFieldNazivMagacina;
	}

	public void setTextFieldNazivMagacina(JTextField textFieldNazivMagacina) {
		this.textFieldNazivMagacina = textFieldNazivMagacina;
	}

	public JTextField getTextFieldAdresaMagacina() {
		return textFieldAdresaMagacina;
	}

	public void setTextFieldAdresaMagacina(JTextField textFieldAdresaMagacina) {
		this.textFieldAdresaMagacina = textFieldAdresaMagacina;
	}

	public JTextField getTextFieldTelefonMagacina() {
		return textFieldTelefonMagacina;
	}

	public void setTextFieldTelefonMagacina(JTextField textFieldTelefonMagacina) {
		this.textFieldTelefonMagacina = textFieldTelefonMagacina;
	}

	public JTextField getTextFieldGradMagacina() {
		return textFieldGradMagacina;
	}

	public void setTextFieldGradMagacina(JTextField textFieldGradMagacina) {
		this.textFieldGradMagacina = textFieldGradMagacina;
	}

	public JTextField getTextFieldEmailMagacina() {
		return textFieldEmailMagacina;
	}

	public void setTextFieldEmailMagacina(JTextField textFieldEmailMagacina) {
		this.textFieldEmailMagacina = textFieldEmailMagacina;
	}

	public JTextField getTextFieldIdMagacina() {
		return textFieldIdMagacina;
	}

	public void setTextFieldIdMagacina(JTextField textFieldIdMagacina) {
		this.textFieldIdMagacina = textFieldIdMagacina;
	}

	public JButton getBtnDodajMagacin() {
		return btnDodajMagacin;
	}

	public void setBtnDodajMagacin(JButton btnDodajMagacin) {
		this.btnDodajMagacin = btnDodajMagacin;
	}

	public JButton getBtnObrisiMagacin() {
		return btnObrisiMagacin;
	}

	public void setBtnObrisiMagacin(JButton btnObrisiMagacin) {
		this.btnObrisiMagacin = btnObrisiMagacin;
	}

	public JButton getBtnPrekiniackcijuMagacin() {
		return btnPrekiniackcijuMagacin;
	}

	public void setBtnPrekiniackcijuMagacin(JButton btnPrekiniackcijuMagacin) {
		this.btnPrekiniackcijuMagacin = btnPrekiniackcijuMagacin;
	}

	public JButton getBtnAzurirajMagacin() {
		return btnAzurirajMagacin;
	}

	public void setBtnAzurirajMagacin(JButton btnAzurirajMagacin) {
		this.btnAzurirajMagacin = btnAzurirajMagacin;
	}

	public JLabel getLblIdMagacina() {
		return lblIdMagacina;
	}

	public void setLblIdMagacina(JLabel lblIdMagacina) {
		this.lblIdMagacina = lblIdMagacina;
	}

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
		setTitle("MAGACIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 451);
		contentPaneMagacin = new JPanel();
		contentPaneMagacin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneMagacin);
		contentPaneMagacin.setLayout(null);

		JPanel panelMagacin = new JPanel();
		panelMagacin.setBorder(
				new TitledBorder(null, "Podaci o magacinu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMagacin.setBounds(35, 36, 522, 300);
		contentPaneMagacin.add(panelMagacin);
		panelMagacin.setLayout(null);

		JLabel lblAdresaMagacina = new JLabel("Adresa :");
		lblAdresaMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresaMagacina.setBounds(10, 85, 147, 22);
		panelMagacin.add(lblAdresaMagacina);

		textFieldAdresaMagacina = new JTextField();
		textFieldAdresaMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldAdresaMagacina.setBounds(188, 86, 256, 20);
		panelMagacin.add(textFieldAdresaMagacina);
		textFieldAdresaMagacina.setColumns(10);

		JLabel lblTelefonMagacina = new JLabel("Telefon :");
		lblTelefonMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefonMagacina.setBounds(10, 174, 147, 22);
		panelMagacin.add(lblTelefonMagacina);

		textFieldTelefonMagacina = new JTextField();
		textFieldTelefonMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefonMagacina.setBounds(188, 175, 256, 20);
		panelMagacin.add(textFieldTelefonMagacina);
		textFieldTelefonMagacina.setColumns(10);

		JLabel lblGradOpstina = new JLabel("Grad / Opstina :");
		lblGradOpstina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGradOpstina.setBounds(10, 128, 147, 22);
		panelMagacin.add(lblGradOpstina);

		textFieldGradMagacina = new JTextField();
		textFieldGradMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldGradMagacina.setBounds(188, 129, 256, 20);
		panelMagacin.add(textFieldGradMagacina);
		textFieldGradMagacina.setColumns(10);

		JLabel lblEmailMagacina = new JLabel("E-mail :");
		lblEmailMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailMagacina.setBounds(10, 220, 147, 22);
		panelMagacin.add(lblEmailMagacina);

		textFieldEmailMagacina = new JTextField();
		textFieldEmailMagacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmailMagacina.setBounds(188, 221, 256, 20);
		panelMagacin.add(textFieldEmailMagacina);
		textFieldEmailMagacina.setColumns(10);

		lblIdMagacina = new JLabel("ID MAGACINA :");
		lblIdMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdMagacina.setBounds(109, 264, 131, 25);
		panelMagacin.add(lblIdMagacina);

		textFieldIdMagacina = new JTextField();
		textFieldIdMagacina.setBounds(250, 268, 131, 20);
		panelMagacin.add(textFieldIdMagacina);
		textFieldIdMagacina.setColumns(10);

		JLabel lblNazivMagacina = new JLabel("Naziv magacina :");
		lblNazivMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNazivMagacina.setBounds(10, 40, 125, 17);
		panelMagacin.add(lblNazivMagacina);

		textFieldNazivMagacina = new JTextField();
		textFieldNazivMagacina.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNazivMagacina.setBounds(188, 40, 256, 20);
		panelMagacin.add(textFieldNazivMagacina);
		textFieldNazivMagacina.setColumns(10);

		btnDodajMagacin = new JButton("Dodaj magacin");
		btnDodajMagacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String naziv = textFieldNazivMagacina.getText();
					String adresa = textFieldAdresaMagacina.getText();
					String grad = textFieldGradMagacina.getText();
					String tel = textFieldTelefonMagacina.getText();
					String email = textFieldEmailMagacina.getText();

					Magacin m = new Magacin(naziv, adresa, grad, tel, email);

					Kontroler.getInstance().insertMagacin(m);

					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novi magacin!");
					textFieldAdresaMagacina.setText("");
					textFieldEmailMagacina.setText("");
					textFieldGradMagacina.setText("");
					textFieldNazivMagacina.setText("");
					textFieldTelefonMagacina.setText("");

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDodajMagacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDodajMagacin.setBounds(385, 347, 172, 23);
		contentPaneMagacin.add(btnDodajMagacin);

		btnObrisiMagacin = new JButton("Obrisi magacin");
		btnObrisiMagacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rbn = Integer.parseInt(textFieldIdMagacina.getText().trim());
				try {
					Kontroler.getInstance().obrisiMagacin(rbn);
					JOptionPane.showMessageDialog(null, "Uspesno ste obrisali magacin!");
					textFieldAdresaMagacina.setText("");
					textFieldEmailMagacina.setText("");
					textFieldGradMagacina.setText("");
					textFieldNazivMagacina.setText("");
					textFieldTelefonMagacina.setText("");
					textFieldIdMagacina.setText("");

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnObrisiMagacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnObrisiMagacin.setBounds(206, 347, 172, 23);
		contentPaneMagacin.add(btnObrisiMagacin);

		btnPrekiniackcijuMagacin = new JButton("Prekini akciju");
		btnPrekiniackcijuMagacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnPrekiniackcijuMagacin.setBounds(35, 347, 161, 23);
		contentPaneMagacin.add(btnPrekiniackcijuMagacin);

		btnAzurirajMagacin = new JButton("Azuriraj");
		btnAzurirajMagacin.setBounds(35, 378, 89, 23);
		contentPaneMagacin.add(btnAzurirajMagacin);
	}
}
