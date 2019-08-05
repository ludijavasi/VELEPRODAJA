package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kontroler.Kontroler;
import model.Filijala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameFilijala extends JFrame {

	private JPanel contentPaneFilijala;
	private JTextField textNazivFilijale;
	private JTextField textAdresaFilijale;
	private JTextField textGradOpstinaFilijale;
	private JTextField textE_MailFilijale;
	private JTextField textTelefonFilijale;
	private JPanel panelPoslovniPodaciFilijale;
	private JLabel lblPibFilijale;
	private JTextField textPibFilijale;
	private JLabel lblTekuciRacunFilijale;
	private JTextField textTekuciRacunFilijale;
	private JLabel lblIDFilijale;
	private JTextField textIDFilijale;
	private JButton btnDodajFilijalu;
	private JButton btnPonistiAkcijuFilijala;
	private JButton btnObrisiFilijalu;
	private JButton btnAzurirajFilijalu;
	private JRadioButton rdbtnAktivna;
	private JRadioButton rdbtnNeaktivna;
	private final ButtonGroup buttonGroupFilijala = new ButtonGroup();
	
	

	public JPanel getContentPaneFilijala() {
		return contentPaneFilijala;
	}

	public void setContentPaneFilijala(JPanel contentPaneFilijala) {
		this.contentPaneFilijala = contentPaneFilijala;
	}

	public JTextField getTextNazivFilijale() {
		return textNazivFilijale;
	}

	public void setTextNazivFilijale(JTextField textNazivFilijale) {
		this.textNazivFilijale = textNazivFilijale;
	}

	public JTextField getTextAdresaFilijale() {
		return textAdresaFilijale;
	}

	public void setTextAdresaFilijale(JTextField textAdresaFilijale) {
		this.textAdresaFilijale = textAdresaFilijale;
	}

	public JTextField getTextGradOpstinaFilijale() {
		return textGradOpstinaFilijale;
	}

	public void setTextGradOpstinaFilijale(JTextField textGradOpstinaFilijale) {
		this.textGradOpstinaFilijale = textGradOpstinaFilijale;
	}

	public JTextField getTextE_MailFilijale() {
		return textE_MailFilijale;
	}

	public void setTextE_MailFilijale(JTextField textE_MailFilijale) {
		this.textE_MailFilijale = textE_MailFilijale;
	}

	public JTextField getTextTelefonFilijale() {
		return textTelefonFilijale;
	}

	public void setTextTelefonFilijale(JTextField textTelefonFilijale) {
		this.textTelefonFilijale = textTelefonFilijale;
	}

	public JPanel getPanelPoslovniPodaciFilijale() {
		return panelPoslovniPodaciFilijale;
	}

	public void setPanelPoslovniPodaciFilijale(JPanel panelPoslovniPodaciFilijale) {
		this.panelPoslovniPodaciFilijale = panelPoslovniPodaciFilijale;
	}

	public JLabel getLblPibFilijale() {
		return lblPibFilijale;
	}

	public void setLblPibFilijale(JLabel lblPibFilijale) {
		this.lblPibFilijale = lblPibFilijale;
	}

	public JTextField getTextPibFilijale() {
		return textPibFilijale;
	}

	public void setTextPibFilijale(JTextField textPibFilijale) {
		this.textPibFilijale = textPibFilijale;
	}

	public JLabel getLblTekuciRacunFilijale() {
		return lblTekuciRacunFilijale;
	}

	public void setLblTekuciRacunFilijale(JLabel lblTekuciRacunFilijale) {
		this.lblTekuciRacunFilijale = lblTekuciRacunFilijale;
	}

	public JTextField getTextTekuciRacunFilijale() {
		return textTekuciRacunFilijale;
	}

	public void setTextTekuciRacunFilijale(JTextField textTekuciRacunFilijale) {
		this.textTekuciRacunFilijale = textTekuciRacunFilijale;
	}

	public JLabel getLblIDFilijale() {
		return lblIDFilijale;
	}

	public void setLblIDFilijale(JLabel lblIDFilijale) {
		this.lblIDFilijale = lblIDFilijale;
	}

	public JTextField getTextIDFilijale() {
		return textIDFilijale;
	}

	public void setTextIDFilijale(JTextField textIDFilijale) {
		this.textIDFilijale = textIDFilijale;
	}

	public ButtonGroup getButtonGroupFilijala() {
		return buttonGroupFilijala;
	}	

	public JButton getBtnDodajFilijalu() {
		return btnDodajFilijalu;
	}

	public void setBtnDodajFilijalu(JButton btnDodajFilijalu) {
		this.btnDodajFilijalu = btnDodajFilijalu;
	}	

	public JButton getBtnPonistiAkcijuFilijala() {
		return btnPonistiAkcijuFilijala;
	}

	public void setBtnPonistiAkcijuFilijala(JButton btnPonistiAkcijuFilijala) {
		this.btnPonistiAkcijuFilijala = btnPonistiAkcijuFilijala;
	}

	public JButton getBtnObrisiFilijalu() {
		return btnObrisiFilijalu;
	}

	public void setBtnObrisiFilijalu(JButton btnObrisiFilijalu) {
		this.btnObrisiFilijalu = btnObrisiFilijalu;
	}

	public JButton getBtnAzurirajFilijalu() {
		return btnAzurirajFilijalu;
	}

	public void setBtnAzurirajFilijalu(JButton btnAzurirajFilijalu) {
		this.btnAzurirajFilijalu = btnAzurirajFilijalu;
	}	

	public JRadioButton getRdbtnAktivna() {
		return rdbtnAktivna;
	}

	public void setRdbtnAktivna(JRadioButton rdbtnAktivna) {
		this.rdbtnAktivna = rdbtnAktivna;
	}

	public JRadioButton getRdbtnNeaktivna() {
		return rdbtnNeaktivna;
	}

	public void setRdbtnNeaktivna(JRadioButton rdbtnNeaktivna) {
		this.rdbtnNeaktivna = rdbtnNeaktivna;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameFilijala frame = new JFrameFilijala();
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
	public JFrameFilijala() {
		setTitle("FILIJALA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 343);
		contentPaneFilijala = new JPanel();
		contentPaneFilijala.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneFilijala);
		contentPaneFilijala.setLayout(null);

		JPanel panelPodaciOFilijali = new JPanel();
		panelPodaciOFilijali.setLayout(null);
		panelPodaciOFilijali.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o filijali",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPodaciOFilijali.setBounds(10, 11, 242, 182);
		contentPaneFilijala.add(panelPodaciOFilijali);

		JLabel labelNayivfilijale = new JLabel("Naziv filijale :");
		labelNayivfilijale.setBounds(10, 45, 82, 14);
		panelPodaciOFilijali.add(labelNayivfilijale);

		JLabel lblAdresaFilijale = new JLabel("Adresa filijale :");
		lblAdresaFilijale.setBounds(10, 70, 82, 14);
		panelPodaciOFilijali.add(lblAdresaFilijale);

		JLabel lblGradOpstinaFilijale = new JLabel("Grad/Opstina");
		lblGradOpstinaFilijale.setBounds(10, 95, 82, 14);
		panelPodaciOFilijali.add(lblGradOpstinaFilijale);

		JLabel lblTelefonFilijale = new JLabel("Telefon :");
		lblTelefonFilijale.setBounds(10, 120, 82, 14);
		panelPodaciOFilijali.add(lblTelefonFilijale);

		JLabel lblE_MailFilijale = new JLabel("E-mail :");
		lblE_MailFilijale.setBounds(10, 151, 82, 14);
		panelPodaciOFilijali.add(lblE_MailFilijale);

		textNazivFilijale = new JTextField();
		textNazivFilijale.setColumns(10);
		textNazivFilijale.setBounds(102, 42, 121, 20);
		panelPodaciOFilijali.add(textNazivFilijale);

		textAdresaFilijale = new JTextField();
		textAdresaFilijale.setColumns(10);
		textAdresaFilijale.setBounds(102, 67, 121, 20);
		panelPodaciOFilijali.add(textAdresaFilijale);

		textGradOpstinaFilijale = new JTextField();
		textGradOpstinaFilijale.setColumns(10);
		textGradOpstinaFilijale.setBounds(102, 92, 124, 20);
		panelPodaciOFilijali.add(textGradOpstinaFilijale);

		textE_MailFilijale = new JTextField();
		textE_MailFilijale.setColumns(10);
		textE_MailFilijale.setBounds(99, 148, 124, 20);
		panelPodaciOFilijali.add(textE_MailFilijale);

		textTelefonFilijale = new JTextField();
		textTelefonFilijale.setColumns(10);
		textTelefonFilijale.setBounds(102, 117, 121, 20);
		panelPodaciOFilijali.add(textTelefonFilijale);

		panelPoslovniPodaciFilijale = new JPanel();
		panelPoslovniPodaciFilijale.setLayout(null);
		panelPoslovniPodaciFilijale.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Poslovni podaci filijale", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPoslovniPodaciFilijale.setBounds(272, 11, 301, 182);
		contentPaneFilijala.add(panelPoslovniPodaciFilijale);

		lblPibFilijale = new JLabel("PIB :");
		lblPibFilijale.setBounds(10, 34, 107, 14);
		panelPoslovniPodaciFilijale.add(lblPibFilijale);

		textPibFilijale = new JTextField();
		textPibFilijale.setColumns(10);
		textPibFilijale.setBounds(127, 31, 130, 20);
		panelPoslovniPodaciFilijale.add(textPibFilijale);

		lblTekuciRacunFilijale = new JLabel("Tekuci Racun :");
		lblTekuciRacunFilijale.setBounds(10, 65, 107, 14);
		panelPoslovniPodaciFilijale.add(lblTekuciRacunFilijale);

		textTekuciRacunFilijale = new JTextField();
		textTekuciRacunFilijale.setColumns(10);
		textTekuciRacunFilijale.setBounds(127, 62, 130, 20);
		panelPoslovniPodaciFilijale.add(textTekuciRacunFilijale);

		lblIDFilijale = new JLabel("ID Filijale:");
		lblIDFilijale.setBounds(39, 100, 78, 14);
		panelPoslovniPodaciFilijale.add(lblIDFilijale);

		textIDFilijale = new JTextField();
		textIDFilijale.setColumns(10);
		textIDFilijale.setBounds(148, 97, 65, 20);
		panelPoslovniPodaciFilijale.add(textIDFilijale);

		JRadioButton rdbtnAktivna = new JRadioButton("Aktivna");
		buttonGroupFilijala.add(rdbtnAktivna);
		rdbtnAktivna.setBounds(39, 145, 109, 23);
		panelPoslovniPodaciFilijale.add(rdbtnAktivna);

		JRadioButton rdbtnNeaktivna = new JRadioButton("Neaktivna");
		buttonGroupFilijala.add(rdbtnNeaktivna);
		rdbtnNeaktivna.setBounds(148, 145, 109, 23);
		panelPoslovniPodaciFilijale.add(rdbtnNeaktivna);

		ButtonGroup status = new ButtonGroup();
		status.add(rdbtnAktivna);
		status.add(rdbtnNeaktivna);

		JButton btnDodajFilijalu = new JButton("Dodaj filijalu");
		btnDodajFilijalu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String naziv = textNazivFilijale.getText();
					String adresa = textAdresaFilijale.getText();
					String grad = textGradOpstinaFilijale.getText();
					String tel = textTelefonFilijale.getText();
					String email = textE_MailFilijale.getText();
					int pib = Integer.parseInt(textPibFilijale.getText());
					String tek_racun = textTekuciRacunFilijale.getText();
					String status = "";
					if (rdbtnAktivna.isSelected()) {
						status = "Aktivna";
					} else if (rdbtnNeaktivna.isSelected()) {
						status = "Neaktivna";
					}

					Filijala f = new Filijala(naziv, adresa, grad, tel, email, pib, tek_racun, status);

					Kontroler.getInstance().insertFilijala(f);

					JOptionPane.showMessageDialog(null, "Uspesno ste uneli novu filijalu!");

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDodajFilijalu.setBounds(311, 204, 118, 23);
		contentPaneFilijala.add(btnDodajFilijalu);

		JButton btnObrisiFilijalu = new JButton("Obrisi filijalu");
		btnObrisiFilijalu.setBounds(97, 238, 118, 23);
		contentPaneFilijala.add(btnObrisiFilijalu);

		JButton btnAzurirajFilijalu = new JButton("Azuriraj");
		btnAzurirajFilijalu.setBounds(311, 238, 118, 23);
		contentPaneFilijala.add(btnAzurirajFilijalu);

		JButton btnPonistiAkcijuFilijala = new JButton("Ponisti akciju");
		btnPonistiAkcijuFilijala.setBounds(97, 204, 118, 23);
		contentPaneFilijala.add(btnPonistiAkcijuFilijala);
	}
}
