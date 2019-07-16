package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import jpanel.JPanelObrisiZaposlenog;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzorVeleprodaja {

	private JFrame frame;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JPanel panelAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzorVeleprodaja window = new GlavniProzorVeleprodaja();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProzorVeleprodaja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 603, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_268101549302672");
		panelLogin.setLayout(null);

		JPanel panelLogovanja = new JPanel();
		panelLogovanja.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogovanja.setBounds(135, 85, 399, 177);
		panelLogin.add(panelLogovanja);
		panelLogovanja.setLayout(null);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(26, 48, 93, 14);
		panelLogovanja.add(lblUsername);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(26, 87, 93, 14);
		panelLogovanja.add(lblPassword);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(177, 47, 191, 20);
		panelLogovanja.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(177, 86, 191, 20);
		panelLogovanja.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLogin.setVisible(false);
				panelAdmin.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(141, 132, 89, 23);
		panelLogovanja.add(btnLogin);

		panelAdmin = new JPanel();
		frame.getContentPane().add(panelAdmin, "name_268160544207166");
		panelAdmin.setLayout(null);

		JMenuBar menuBarAdmin = new JMenuBar();
		menuBarAdmin.setBounds(0, 0, 656, 27);
		panelAdmin.add(menuBarAdmin);

		JMenu mnPrijavaAdmin = new JMenu("Prijava");
		mnPrijavaAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnPrijavaAdmin);

		JMenuItem mntmOdjavaAdmin = new JMenuItem("Odjava");
		mnPrijavaAdmin.add(mntmOdjavaAdmin);

		JMenu mnZaposleniPrijavaAdmin = new JMenu("Zaposleni");
		mnPrijavaAdmin.add(mnZaposleniPrijavaAdmin);

		JMenuItem mntmTrenutnoPrijavljeni = new JMenuItem("Trenutno prijavljeni");
		mnZaposleniPrijavaAdmin.add(mntmTrenutnoPrijavljeni);

		JMenuItem mntmOsveziupdateAdmin = new JMenuItem("Osvezi (update)");
		mnPrijavaAdmin.add(mntmOsveziupdateAdmin);

		JMenuItem mntmIzlazAdmin = new JMenuItem("Izlaz");
		mnPrijavaAdmin.add(mntmIzlazAdmin);

		mntmIzlazAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

		JMenu mnProdajaAdmin = new JMenu("    Prodaja");
		mnProdajaAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnProdajaAdmin);

		JMenuItem mntmKreirajRacunOtpremnicuAdmin = new JMenuItem("Kreiraj ra\u010Dun/otpremnicu");
		mnProdajaAdmin.add(mntmKreirajRacunOtpremnicuAdmin);

		JMenuItem mntmCeneArtiklaAdmin = new JMenuItem("Cene artikla");
		mnProdajaAdmin.add(mntmCeneArtiklaAdmin);

		JMenuItem mntmPovracajKupcaAdmin = new JMenuItem("Povra\u0107aj kupca");
		mnProdajaAdmin.add(mntmPovracajKupcaAdmin);

		JMenuItem mntmKontrolaFaktureAdmin = new JMenuItem("Kontrola fakture");
		mnProdajaAdmin.add(mntmKontrolaFaktureAdmin);

		JMenu mnAnalizaProdajeAdmin = new JMenu("Analiza prodaje");
		mnProdajaAdmin.add(mnAnalizaProdajeAdmin);

		JMenuItem mntmProdajnaCenaArtiklaAdmin = new JMenuItem("Prodajna cena artikla");
		mnAnalizaProdajeAdmin.add(mntmProdajnaCenaArtiklaAdmin);

		JMenuItem mntmProdajaPoArtikluAdmin = new JMenuItem("Prodaja po artiklu");
		mnAnalizaProdajeAdmin.add(mntmProdajaPoArtikluAdmin);

		JMenuItem mntmProdajaPoKupcimaAdmin = new JMenuItem("Prodaja po kupcima");
		mnAnalizaProdajeAdmin.add(mntmProdajaPoKupcimaAdmin);

		JMenuItem mntmRazlikaUCeniAdmin = new JMenuItem("Razlika u ceni");
		mnAnalizaProdajeAdmin.add(mntmRazlikaUCeniAdmin);

		JMenuItem mntmSumarniPregledDokumenataAdmin = new JMenuItem("Sumarni pregled dokumenata");
		mnAnalizaProdajeAdmin.add(mntmSumarniPregledDokumenataAdmin);

		JMenuItem mntmDnevnikProdajeProdaje = new JMenuItem("Dnevnik prodaje");
		mnAnalizaProdajeAdmin.add(mntmDnevnikProdajeProdaje);

		JMenu mnSkladisteAdmin = new JMenu("    Skladi\u0161te");
		mnSkladisteAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnSkladisteAdmin);

		JMenuItem mntmKontrolaZalihaAdmin = new JMenuItem("Kontrola zaliha");
		mnSkladisteAdmin.add(mntmKontrolaZalihaAdmin);

		JMenu mnAnalizaSkladistaAdmin = new JMenu("Analiza skladista");
		mnSkladisteAdmin.add(mnAnalizaSkladistaAdmin);

		JMenuItem mntmInforOSkladPromAdmin = new JMenuItem("Informacija o skladisnim promenama");
		mnAnalizaSkladistaAdmin.add(mntmInforOSkladPromAdmin);

		JMenuItem mntmIstorijaArtikalaAdmin = new JMenuItem("Istorija artikala");
		mnSkladisteAdmin.add(mntmIstorijaArtikalaAdmin);

		JMenuItem mntmStatistikaPotrosnjeAdmin = new JMenuItem("Statistika potro\u0161nje");
		mnSkladisteAdmin.add(mntmStatistikaPotrosnjeAdmin);

		JMenu mnZaposleniAdmin = new JMenu("    Zaposleni");
		mnZaposleniAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnZaposleniAdmin);

		JMenuItem mntmTrenutnoZaposleniAdmin = new JMenuItem("Trenutno zaposleni");
		mnZaposleniAdmin.add(mntmTrenutnoZaposleniAdmin);

		JMenuItem mntmZasnivanjeRadnogOdnosaAdmin = new JMenuItem("Zasnivanje radnog odnosa");
		mntmZasnivanjeRadnogOdnosaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnZaposleniAdmin.add(mntmZasnivanjeRadnogOdnosaAdmin);

		JMenuItem mntmPrekidRadnogOdnosaAdmin = new JMenuItem("Prekid radnog odnosa");
		mnZaposleniAdmin.add(mntmPrekidRadnogOdnosaAdmin);

		JMenuItem mntmPregledZaposlenihAdmin = new JMenuItem("Pregled zaposlenih");
		mnZaposleniAdmin.add(mntmPregledZaposlenihAdmin);

		JMenu mnMaticniPodaciAdmin = new JMenu("    Mati\u010Dni podaci");
		mnMaticniPodaciAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnMaticniPodaciAdmin);

		JMenu mnFilijalaAdmin = new JMenu("Filijala");
		mnMaticniPodaciAdmin.add(mnFilijalaAdmin);

		JMenuItem mntmAktivneFilijaleAdmin = new JMenuItem("Aktivne filijale");
		mnFilijalaAdmin.add(mntmAktivneFilijaleAdmin);

		JMenuItem mntmDodavanjeFilijaleAdmin = new JMenuItem("Dodavanje filijale");
		mnFilijalaAdmin.add(mntmDodavanjeFilijaleAdmin);

		JMenuItem mntmBrisanjeFilijaleAdmin = new JMenuItem("Brisanje filijale");
		mnFilijalaAdmin.add(mntmBrisanjeFilijaleAdmin);

		JMenuItem mntmAzuriranjeFilijaleAdmin = new JMenuItem("Azuriranje");
		mnFilijalaAdmin.add(mntmAzuriranjeFilijaleAdmin);

		JMenu mnZaposleniMatPodaciAdmin = new JMenu("Zaposleni");
		mnMaticniPodaciAdmin.add(mnZaposleniMatPodaciAdmin);

		JMenuItem mntmPregledZaposlenihMPAdmin = new JMenuItem("Pregled zaposlenih");
		mnZaposleniMatPodaciAdmin.add(mntmPregledZaposlenihMPAdmin);

		JMenuItem mntmDodajZaposlenogAdmin = new JMenuItem("Dodaj zaposlenog");
		mnZaposleniMatPodaciAdmin.add(mntmDodajZaposlenogAdmin);

		JMenuItem mntmObrisiZaposlenogAdmin = new JMenuItem("Obrisi zaposlenog");
		mntmObrisiZaposlenogAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmObrisiZaposlenogAdmin);

		JMenuItem mntmAzurirajZaposlenogAdmin = new JMenuItem("Azuriraj");
		mnZaposleniMatPodaciAdmin.add(mntmAzurirajZaposlenogAdmin);

		JMenu mnGrupePoslovaAdmin = new JMenu("Grupe poslova");
		mnMaticniPodaciAdmin.add(mnGrupePoslovaAdmin);

		JMenuItem mntmPregledGrupePoslovaAdmin = new JMenuItem("Pregled grupe poslova");
		mnGrupePoslovaAdmin.add(mntmPregledGrupePoslovaAdmin);

		JMenuItem mntmDodajGrupuPoslovaAdmin = new JMenuItem("Dodaj grupu poslova");
		mnGrupePoslovaAdmin.add(mntmDodajGrupuPoslovaAdmin);

		JMenuItem mntmObrisiGrupuPoslovaAdmin = new JMenuItem("Obrisi grupu poslova");
		mnGrupePoslovaAdmin.add(mntmObrisiGrupuPoslovaAdmin);

		JMenuItem mntmAzurirajGrupePoslovaAdmin = new JMenuItem("Azuriraj");
		mnGrupePoslovaAdmin.add(mntmAzurirajGrupePoslovaAdmin);

		JMenu mnSkladistaAdmin = new JMenu("Skladista");
		mnMaticniPodaciAdmin.add(mnSkladistaAdmin);

		JMenuItem mntmAktivnaSkladistaAdmin = new JMenuItem("Aktivna skladista");
		mnSkladistaAdmin.add(mntmAktivnaSkladistaAdmin);

		JMenuItem mntmDodajSkladisteAdmin = new JMenuItem("Dodaj skladiste");
		mnSkladistaAdmin.add(mntmDodajSkladisteAdmin);

		JMenuItem mntmObrisiSkladisteAdmin = new JMenuItem("Obrisi skladiste");
		mnSkladistaAdmin.add(mntmObrisiSkladisteAdmin);

		JMenuItem mntmAzurirajSkladistaAdmin = new JMenuItem("Azuriraj");
		mnSkladistaAdmin.add(mntmAzurirajSkladistaAdmin);

		JMenu mnGrupeSkladistaAdmin = new JMenu("Grupe skladista");
		mnMaticniPodaciAdmin.add(mnGrupeSkladistaAdmin);

		JMenuItem mntmPregledGrupeSkladistaAdminn = new JMenuItem("Pregled grupe skladista");
		mnGrupeSkladistaAdmin.add(mntmPregledGrupeSkladistaAdminn);

		JMenuItem mntmDodajGrupuSkladistaAdmin = new JMenuItem("Dodaj grupu skladista");
		mnGrupeSkladistaAdmin.add(mntmDodajGrupuSkladistaAdmin);

		JMenuItem mntmObrisiGrupuSkladistaAdmin = new JMenuItem("Obrisi grupu skladiste");
		mnGrupeSkladistaAdmin.add(mntmObrisiGrupuSkladistaAdmin);

		JMenu mnKupciAdmin = new JMenu("Kupci");
		mnMaticniPodaciAdmin.add(mnKupciAdmin);

		JMenuItem mntmAktivniKupciAdmin = new JMenuItem("Aktivni kupci");
		mnKupciAdmin.add(mntmAktivniKupciAdmin);

		JMenuItem mntmDodajKupcaAdmin = new JMenuItem("Dodaj kupca");
		mnKupciAdmin.add(mntmDodajKupcaAdmin);

		JMenuItem mntmObrisiKupcaAdmin = new JMenuItem("Obrisi kupca");
		mnKupciAdmin.add(mntmObrisiKupcaAdmin);

		JMenuItem mntmAzurirajKupcaAdmin = new JMenuItem("Azuriraj");
		mnKupciAdmin.add(mntmAzurirajKupcaAdmin);

		JMenu mnArtikliAdmin = new JMenu("Artikli");
		mnMaticniPodaciAdmin.add(mnArtikliAdmin);

		JMenuItem mntmPregledArtikalaAdmin = new JMenuItem("Pregled artikala");
		mnArtikliAdmin.add(mntmPregledArtikalaAdmin);

		JMenuItem mntmDodajArtikalAdmin = new JMenuItem("Dodaj artikal");
		mnArtikliAdmin.add(mntmDodajArtikalAdmin);

		JMenuItem mntmObrisiArtikalAdmin = new JMenuItem("Obrisi artikal");
		mnArtikliAdmin.add(mntmObrisiArtikalAdmin);

		JMenuItem mntmAzurirajArtikleAdmin = new JMenuItem("Azuriraj");
		mnArtikliAdmin.add(mntmAzurirajArtikleAdmin);

		JMenu mnGrupeArtikalaAdmin = new JMenu("Grupe artikala");
		mnMaticniPodaciAdmin.add(mnGrupeArtikalaAdmin);

		JMenuItem mntmPregledGrupeArtikalaAdmin = new JMenuItem("Pregled grupe artikala");
		mnGrupeArtikalaAdmin.add(mntmPregledGrupeArtikalaAdmin);

		JMenuItem mntmDodajGrupuArtikalaAdmin = new JMenuItem("Dodaj grupu artikala");
		mnGrupeArtikalaAdmin.add(mntmDodajGrupuArtikalaAdmin);

		JMenuItem mntmObrisiGrupuArtikalaAdmin = new JMenuItem("Obrisi grupu artikala");
		mnGrupeArtikalaAdmin.add(mntmObrisiGrupuArtikalaAdmin);

		JMenuItem mntmAzurirajGrupuArtikalaAdmin = new JMenuItem("Azuriraj");
		mnGrupeArtikalaAdmin.add(mntmAzurirajGrupuArtikalaAdmin);

		JMenu mnPoreziAdmin = new JMenu("Porezi");
		mnMaticniPodaciAdmin.add(mnPoreziAdmin);

		JMenuItem mntmPorez10Admin = new JMenuItem("Porez 10%");
		mnPoreziAdmin.add(mntmPorez10Admin);

		JMenuItem mntmPorez20Admin = new JMenuItem("Porez 20%");
		mnPoreziAdmin.add(mntmPorez20Admin);

		JMenuItem mntmAzurirajGrupuSkladistaAdmin = new JMenuItem("Azuriraj");
		mnGrupeSkladistaAdmin.add(mntmAzurirajGrupuSkladistaAdmin);

		JMenu mnIzvestajAdmin = new JMenu("    Izve\u0161taj");
		mnIzvestajAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnIzvestajAdmin);

		JMenu mnAnalizaProdajeIzvestajAdmin = new JMenu("Analiza prodaje");
		mnIzvestajAdmin.add(mnAnalizaProdajeIzvestajAdmin);

		JMenuItem mntmProdajnaCenaArtiklaIzvAdmin = new JMenuItem("Prodajna cena artikla");
		mnAnalizaProdajeIzvestajAdmin.add(mntmProdajnaCenaArtiklaIzvAdmin);

		JMenuItem mntmProdajaPoArtiklimaIzvAdmin = new JMenuItem("Prodaja po artiklima");
		mnAnalizaProdajeIzvestajAdmin.add(mntmProdajaPoArtiklimaIzvAdmin);

		JMenuItem mntmProdajaPoKupcimaIzvAdmin = new JMenuItem("Prodaja po kupcima");
		mnAnalizaProdajeIzvestajAdmin.add(mntmProdajaPoKupcimaIzvAdmin);

		JMenuItem mntmRazlikeUCeniIzvAdmin = new JMenuItem("Razlike u ceni");
		mnAnalizaProdajeIzvestajAdmin.add(mntmRazlikeUCeniIzvAdmin);

		JMenuItem mntmSumarniPregledDokumenataIzvAdmin = new JMenuItem("Sumarni pregled dokumenata");
		mnAnalizaProdajeIzvestajAdmin.add(mntmSumarniPregledDokumenataIzvAdmin);

		JMenuItem mntmDnevnikProdajeIzvAdmin = new JMenuItem("Dnevnik prodaje");
		mnAnalizaProdajeIzvestajAdmin.add(mntmDnevnikProdajeIzvAdmin);

		JMenu mnAnalizaSkladistaIzvestajAdmin = new JMenu("Analiza skladista");
		mnIzvestajAdmin.add(mnAnalizaSkladistaIzvestajAdmin);

		JMenuItem mntmInfOSkladisPromenIzvAdmin = new JMenuItem("Informacija o skladisnim promenama");
		mnAnalizaSkladistaIzvestajAdmin.add(mntmInfOSkladisPromenIzvAdmin);

		JMenuItem mntmStatistikaPotrosnjeIzvAdmin = new JMenuItem("Statistika potrosnje");
		mnAnalizaSkladistaIzvestajAdmin.add(mntmStatistikaPotrosnjeIzvAdmin);

		JMenuItem mntmIstorijaArtiklaIzvAdmin = new JMenuItem("Istorija artikala");
		mnAnalizaSkladistaIzvestajAdmin.add(mntmIstorijaArtiklaIzvAdmin);

		JMenu mnRezultatiAdmin = new JMenu("Rezultati");
		mnIzvestajAdmin.add(mnRezultatiAdmin);

		JMenuItem mntmDnevniIzvestajAdmin = new JMenuItem("Dnevni izvestaj");
		mnRezultatiAdmin.add(mntmDnevniIzvestajAdmin);

		JMenuItem mntmNedeljniIzvestajAdmin = new JMenuItem("Nedeljni izvestaj");
		mnRezultatiAdmin.add(mntmNedeljniIzvestajAdmin);

		JMenuItem mntmMesecniIzvestajAdmin = new JMenuItem("Mesecni izvestaj");
		mnRezultatiAdmin.add(mntmMesecniIzvestajAdmin);

		JMenuItem mntmGodisnjiIzvestajAdmin = new JMenuItem("Godisnji izvestaj");
		mnRezultatiAdmin.add(mntmGodisnjiIzvestajAdmin);

		JMenuItem mntmProdajaPoArtikluIzvAdmin = new JMenuItem("Prodaja po artiklu");
		mnRezultatiAdmin.add(mntmProdajaPoArtikluIzvAdmin);

		JMenuItem mntmZaradaPoArtikluIzvAdmin = new JMenuItem("Zarada po artiklu");
		mnRezultatiAdmin.add(mntmZaradaPoArtikluIzvAdmin);

		JMenu mnSistemAdmin = new JMenu("    Sistem");
		mnSistemAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnSistemAdmin);

		JMenuItem mntmPromeniLozinkuAdmin = new JMenuItem("Promeni lozinku");
		mnSistemAdmin.add(mntmPromeniLozinkuAdmin);

		JMenuItem mntmAzurirajSistemAdmin = new JMenuItem("Azuriraj");
		mnSistemAdmin.add(mntmAzurirajSistemAdmin);

	}
}
