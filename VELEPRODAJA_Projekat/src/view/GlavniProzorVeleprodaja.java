package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import jframe.JFrameArtikal;
import jframe.JFrameFilijala;
import jframe.JFrameGrupaArtikala;
import jframe.JFrameKontrolaZaliha;
import jframe.JFrameKupac;
import jframe.JFrameMagacin;
import jframe.JFramePromenaLozinke;
import jframe.JFrameRacun_otpreminica;
import jframe.JFrameZaposleni;
import jframeObrisi.JFrameObrisiArtikal;
import jframeObrisi.JFrameObrisiFilijalu;
import jframeObrisi.JFrameObrisiGrupuArtikala;
import jframeObrisi.JFrameObrisiKupca;
import jframeObrisi.JFrameObrisiMagacin;
import jframeObrisi.JFrameObrisiZaposlenog;
import jframePregled.JFrameKontrolaZalihaPregled;
import jframePregled.JFramePregledArtikala;
import jframePregled.JFramePregledFilijale;
import jframePregled.JFramePregledGrupeArtikala;
import jframePregled.JFramePregledKupca;
import jframePregled.JFramePregledMagacina;
import jframePregled.JFramePregledTrenutnoPrijavljeniNaMrezi;
import jframePregled.JFramePregledZaposlenih;
import jframePregled.JFrameStavkeRacunaPregled;
import kontroler.Kontroler;
import model.Artikli;
import model.GrupaArtikala;
import model.RacunOtpremnica;
import model.Zaposleni;
import table.JTableModelRacunOtpremnica;
import table.JTabelModelZaposleni;
import table.JTableModelArtikal;
import table.JTableModelFilijala;
import table.JTableModelGrupeArtikala;
import table.JTableModelKupac;
import table.JTableModelMagacin;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class GlavniProzorVeleprodaja {

	private JFrame frame;
	private JTextField textFieldUsername;
	private JPanel panelAdmin;
	private JPanel panelUserKomercijalista;
	private JPanel panelUserMagacioner;
	public Zaposleni logedIn = null;
	private JPasswordField passwordFieldPassword;	

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
		frame.setBounds(100, 100, 646, 475);
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

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = textFieldUsername.getText();
				char[] pass = passwordFieldPassword.getPassword();
				String password = new String(pass);
				
				try {
					ArrayList<Zaposleni> zaposleni = Kontroler.getInstance().getZaposleni();
					for (Zaposleni z : zaposleni) {
						if (z.getUsernameZaposlenog().equals(username) && z.getPasswordZaposlenog().equals(password)) {
							if (z.getTipZaposlenja().equals("Menadzer")) {
								logedIn = z;

								panelAdmin.setVisible(true);
								panelLogin.setVisible(false);									

							} else if (z.getTipZaposlenja().equals("Komercijalista")) {
								
								logedIn = z;

								panelUserKomercijalista.setVisible(true);
								panelLogin.setVisible(false);								
								
							} else if (z.getTipZaposlenja().equals("Magacioner")) {
								System.out.println("Magacioner");
								logedIn = z;

								panelUserMagacioner.setVisible(true);
								panelLogin.setVisible(false);								
								
							} else {
								JOptionPane.showMessageDialog(panelLogin, "Pogresan tip usera");
							}
							break;
						}
					}
					if (logedIn == null) {
						JOptionPane.showMessageDialog(panelLogin, "Pogresan username / password");
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
				textFieldUsername.setText("");
				passwordFieldPassword.setText("");				
			
			}
			});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(141, 132, 89, 23);
		panelLogovanja.add(btnLogin);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(177, 86, 191, 20);
		panelLogovanja.add(passwordFieldPassword);

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
		mntmOdjavaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdmin.setVisible(false);
				panelLogin.setVisible(true);				
			}
		});
		
		mnPrijavaAdmin.add(mntmOdjavaAdmin);
		
		JMenuItem mnTrenutnoPrijavljeniAdmin = new JMenuItem("Trenutno prijavljeni");
		mnPrijavaAdmin.add(mnTrenutnoPrijavljeniAdmin);
		mnTrenutnoPrijavljeniAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledTrenutnoPrijavljeniNaMrezi prijavljeni = new JFramePregledTrenutnoPrijavljeniNaMrezi();
				panelAdmin.setVisible(false);
				prijavljeni.setVisible(true);	
				prijavljeni.getBtnIzlazTrenutnoNaMrezi().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						prijavljeni.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});


		JMenuItem mntmIzlazAdmin = new JMenuItem("Izlaz");
		mntmIzlazAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = JOptionPane.showConfirmDialog(null, 
						   "Da li zelite da ugasite program ?",null, JOptionPane.YES_NO_OPTION);
						if(r == JOptionPane.YES_OPTION) {
						    System.exit(0);
						}
			}
		});
		mnPrijavaAdmin.add(mntmIzlazAdmin);

		mntmIzlazAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

		JMenu mnProdajaAdmin = new JMenu("    Prodaja");
		mnProdajaAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnProdajaAdmin);

		JMenuItem mntmKreirajRacunOtpremnicuAdmin = new JMenuItem("Kreiraj ra\u010Dun/otpremnicu");
		mntmKreirajRacunOtpremnicuAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameRacun_otpreminica ro = new JFrameRacun_otpreminica();
				
				panelAdmin.setVisible(false);
				ro.setVisible(true);
				
		        ro.getBtnPonistiAkcijuRacunOtpremnica().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ro.setVisible(false);					
						
					}
					
				});
		        panelAdmin.setVisible(true);	
				
				
				ro.getBtnNovaPoyicijaRacun().addActionListener(new ActionListener() {					
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrameStavkeRacunaPregled srp = new JFrameStavkeRacunaPregled();
						srp.setVisible(true);
						srp.getBtnPrekidStavkeRacuna().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								srp.setVisible(false);
								
							}
						});
						
					}
				});
			}
		});
		mnProdajaAdmin.add(mntmKreirajRacunOtpremnicuAdmin);

		JMenuItem mntmCeneArtiklaAdmin = new JMenuItem("Cene artikla");
		mnProdajaAdmin.add(mntmCeneArtiklaAdmin);

		JMenuItem mntmStorniranjeRacunaAdmin = new JMenuItem("Storniranje racuna");
		mnProdajaAdmin.add(mntmStorniranjeRacunaAdmin);

		JMenuItem mntmPregledRacunaAdmin = new JMenuItem("Pregled racuna");
		mntmPregledRacunaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameStavkeRacunaPregled racun = new JFrameStavkeRacunaPregled();
				panelAdmin.setVisible(false);
				racun.setVisible(true);
				
				postaviModelRacunOtpremnica(new ArrayList<>(), racun.getTableRacunOtpremnica());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getRacun();
					postaviModelRacunOtpremnica(lista, racun.getTableRacunOtpremnica());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                  racun.getBtnPrekidStavkeRacuna().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						racun.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
			
		mnProdajaAdmin.add(mntmPregledRacunaAdmin);

		JMenu mnAnalizaProdajeAdmin = new JMenu("Analiza prodaje");
		mnProdajaAdmin.add(mnAnalizaProdajeAdmin);

		JMenuItem mntmProdajnaCenaArtiklaAdmin = new JMenuItem("Prodajna cena artikla");
		mnAnalizaProdajeAdmin.add(mntmProdajnaCenaArtiklaAdmin);

		JMenuItem mntmProdajaPoArtikluAdmin = new JMenuItem("Prodaja po artiklu");
		mnAnalizaProdajeAdmin.add(mntmProdajaPoArtikluAdmin);

		JMenuItem mntmProdajaPoKupcimaAdmin = new JMenuItem("Prodaja po kupcima");
		mnAnalizaProdajeAdmin.add(mntmProdajaPoKupcimaAdmin);

		JMenuItem mntmSumarniPregledDokumenataAdmin = new JMenuItem("Sumarni pregled dokumenata");
		mnAnalizaProdajeAdmin.add(mntmSumarniPregledDokumenataAdmin);

		JMenu mnSkladisteAdmin = new JMenu("    Skladi\u0161te");
		mnSkladisteAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnSkladisteAdmin);

		JMenuItem mntmKontrolaZalihaAdmin = new JMenuItem("Kontrola zaliha");
		mntmKontrolaZalihaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameKontrolaZaliha kz = new JFrameKontrolaZaliha();
				kz.setVisible(true);
				kz.getBtnPrekidKontrolaZaliha().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						kz.setVisible(false);
						
					}
				});
				kz.getBtnOkKontrolaZaliha().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrameKontrolaZalihaPregled kzp = new JFrameKontrolaZalihaPregled();
						kz.setVisible(false);
						kzp.setVisible(true);
						kzp.getBtnIzlazKontrolaZalihaPregled().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
							kzp.setVisible(false);
								
							}
						});
						kzp.getBtnNoviPregledKontroleZaliha().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								kz.setVisible(true);
								kzp.setVisible(false);
								
							}
						});
					}
				});
			}
		});
	
		mnSkladisteAdmin.add(mntmKontrolaZalihaAdmin);

		JMenu mnZaposleniAdmin = new JMenu("    Zaposleni");
		mnZaposleniAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnZaposleniAdmin);

		JMenuItem mntmTrenutnoZaposleniAdmin = new JMenuItem("Trenutno zaposleni");

		JMenuItem mntmPregledZaposlenihAdmin = new JMenuItem("Pregled zaposlenih");
		mntmPregledZaposlenihAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePregledZaposlenih tz = new JFramePregledZaposlenih();
				panelAdmin.setVisible(false);
				tz.setVisible(true);
				postaviModelZaposleni(new ArrayList<>(), tz.getTablePregledTrenutnoZaposlenih());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getZaposleni();
					postaviModelZaposleni(lista, tz.getTablePregledTrenutnoZaposlenih());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				tz.getBtnIzlazTrenutnoZaposleni().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tz.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
			}
		});
		mnZaposleniAdmin.add(mntmPregledZaposlenihAdmin);

		JMenu mnMaticniPodaciAdmin = new JMenu("    Mati\u010Dni podaci");
		mnMaticniPodaciAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnMaticniPodaciAdmin);

		JMenu mnFilijalaAdmin = new JMenu("Filijala");
		mnMaticniPodaciAdmin.add(mnFilijalaAdmin);

		JMenuItem mntmPregledFilijalaAdmin = new JMenuItem("Pregled filijala");
		mntmPregledFilijalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledFilijale pf = new JFramePregledFilijale();
				panelAdmin.setVisible(false);
				pf.setVisible(true);
				postaviModelFilijala(new ArrayList<>(), pf.getTablePregleFilijale());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getFilijala();
					postaviModelFilijala(lista, pf.getTablePregleFilijale());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pf.getBtnIzlazPregledFilijale().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pf.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnFilijalaAdmin.add(mntmPregledFilijalaAdmin);

		JMenuItem mntmDodavanjeFilijaleAdmin = new JMenuItem("Dodavanje filijale");
		mntmDodavanjeFilijaleAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameFilijala jf = new JFrameFilijala();
				panelAdmin.setVisible(false);
				jf.setVisible(true);
				
				jf.getBtnPonistiAkcijuFilijala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jf.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnFilijalaAdmin.add(mntmDodavanjeFilijaleAdmin);

		JMenuItem mntmBrisanjeFilijaleAdmin = new JMenuItem("Brisanje filijale");
		mntmBrisanjeFilijaleAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameObrisiFilijalu of = new JFrameObrisiFilijalu();
				panelAdmin.setVisible(false);
				of.setVisible(true);
				of.getBtnNazadObrisiFilijali().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						of.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
				

			}
		});
		mnFilijalaAdmin.add(mntmBrisanjeFilijaleAdmin);

		JMenuItem mntmAzuriranjeFilijaleAdmin = new JMenuItem("Azuriranje");
		mnFilijalaAdmin.add(mntmAzuriranjeFilijaleAdmin);

		JMenu mnZaposleniMatPodaciAdmin = new JMenu("Zaposleni");
		mnMaticniPodaciAdmin.add(mnZaposleniMatPodaciAdmin);

		JMenuItem mntmPregledZaposlenihMPAdmin = new JMenuItem("Pregled zaposlenih");
		mntmPregledZaposlenihMPAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledZaposlenih tz = new JFramePregledZaposlenih();
				panelAdmin.setVisible(false);
				tz.setVisible(true);
				postaviModelZaposleni(new ArrayList<>(), tz.getTablePregledTrenutnoZaposlenih());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getZaposleni();
					postaviModelZaposleni(lista, tz.getTablePregledTrenutnoZaposlenih());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				tz.getBtnIzlazTrenutnoZaposleni().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tz.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmPregledZaposlenihMPAdmin);

		JMenuItem mntmDodajZaposlenogAdmin = new JMenuItem("Dodaj zaposlenog");
		mntmDodajZaposlenogAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameZaposleni fz = new JFrameZaposleni();
				panelAdmin.setVisible(false);
				fz.setVisible(true);
				
				fz.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						fz.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmDodajZaposlenogAdmin);

		JMenuItem mntmObrisiZaposlenogAdmin = new JMenuItem("Obrisi zaposlenog");
		mntmObrisiZaposlenogAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameObrisiZaposlenog oz = new JFrameObrisiZaposlenog();
				panelAdmin.setVisible(false);
				oz.setVisible(true);
				oz.getBtnNazadObrisiZaposlenog().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						oz.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
				

			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmObrisiZaposlenogAdmin);

		JMenuItem mntmAzurirajZaposlenogAdmin = new JMenuItem("Azuriraj");
		mntmAzurirajZaposlenogAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnZaposleniMatPodaciAdmin.add(mntmAzurirajZaposlenogAdmin);

		JMenu mnSkladistaAdmin = new JMenu("Magacin");
		mnMaticniPodaciAdmin.add(mnSkladistaAdmin);

		JMenuItem mntmAktivnaSkladistaAdmin = new JMenuItem("Pregled magacina");
		mntmAktivnaSkladistaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledMagacina pm = new JFramePregledMagacina();
				panelAdmin.setVisible(false);
				pm.setVisible(true);
				postaviModelMagacina(new ArrayList<>(), pm.getTablePregledMagacina());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getMagacin();
					postaviModelMagacina(lista, pm.getTablePregledMagacina());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				pm.getBtnIzlazPregledMagacina().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pm.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnSkladistaAdmin.add(mntmAktivnaSkladistaAdmin);

		JMenuItem mntmDodajSkladisteAdmin = new JMenuItem("Dodaj magacin");
		mntmDodajSkladisteAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameMagacin jfm = new JFrameMagacin();
				jfm.getBtnObrisiMagacin().setVisible(false);
				jfm.getLblIdMagacina().setVisible(false);
				jfm.getBtnPrekiniackcijuMagacin().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jfm.setVisible(false);
					}
				});
				jfm.getTextFieldIdMagacina().setVisible(false);
				jfm.setVisible(true);

			}
		});
		mnSkladistaAdmin.add(mntmDodajSkladisteAdmin);

		JMenuItem mntmObrisiSkladisteAdmin = new JMenuItem("Obrisi magacin");
		mntmObrisiSkladisteAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameObrisiMagacin om = new JFrameObrisiMagacin();
				panelAdmin.setVisible(false);
				om.setVisible(true);
				om.getBtnNazadObrisiMagacin().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						om.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnSkladistaAdmin.add(mntmObrisiSkladisteAdmin);

		JMenuItem mntmAzurirajSkladistaAdmin = new JMenuItem("Azuriraj");
		mnSkladistaAdmin.add(mntmAzurirajSkladistaAdmin);

		JMenu mnKupciAdmin = new JMenu("Kupci");
		mnMaticniPodaciAdmin.add(mnKupciAdmin);

		JMenuItem mntmAktivniKupciAdmin = new JMenuItem("Pregled kupaca");
		mntmAktivniKupciAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFramePregledKupca pk = new JFramePregledKupca();
				panelAdmin.setVisible(false);
				pk.setVisible(true);
				postaviModelKupac(new ArrayList<>(), pk.getTablePregleKupaca());
				ArrayList lista;
				
				try {
					lista = Kontroler.getInstance().getKupac();
					postaviModelKupac(lista, pk.getTablePregleKupaca());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				pk.getBtnIzlazPregledKupaca().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pk.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnKupciAdmin.add(mntmAktivniKupciAdmin);

		JMenuItem mntmDodajKupcaAdmin = new JMenuItem("Dodaj kupca");
		mntmDodajKupcaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameKupac jfk = new JFrameKupac();
				jfk.getBtnPonistiAkcijuKupac().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jfk.setVisible(false);
					}
				});
				jfk.getTextFieldIdKupca().setVisible(false);
				jfk.setVisible(true);

			}
		});
				
		mnKupciAdmin.add(mntmDodajKupcaAdmin);

		JMenuItem mntmObrisiKupcaAdmin = new JMenuItem("Obrisi kupca");
		mntmObrisiKupcaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameObrisiKupca ok = new JFrameObrisiKupca();
				panelAdmin.setVisible(false);
				ok.setVisible(true);
				ok.getBtnNazadObrisiKupca().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ok.setVisible(false);				
						
					}
					
				});
				panelAdmin.setVisible(true);
				
			}
		});
		mnKupciAdmin.add(mntmObrisiKupcaAdmin);

		JMenuItem mntmAzurirajKupcaAdmin = new JMenuItem("Azuriraj");
		mnKupciAdmin.add(mntmAzurirajKupcaAdmin);

		JMenu mnArtikliAdmin = new JMenu("Artikli");
		mnMaticniPodaciAdmin.add(mnArtikliAdmin);

		JMenuItem mntmPregledArtikalaAdmin = new JMenuItem("Pregled artikala");
		mntmPregledArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFramePregledArtikala artikal = new JFramePregledArtikala();
				panelAdmin.setVisible(false);
				artikal.setVisible(true);
				
				postaviModelArtikli(new ArrayList<>(), artikal.getTablePregledArtikala());
				ArrayList lista;
				int id_grupe_artikala=0;
				try {
					lista = Kontroler.getInstance().getArtikli(id_grupe_artikala);
					postaviModelArtikli(lista, artikal.getTablePregledArtikala());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				artikal.getBtnIzlazPregledArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						artikal.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnArtikliAdmin.add(mntmPregledArtikalaAdmin);

		JMenuItem mntmDodajArtikalAdmin = new JMenuItem("Dodaj artikal");
		mntmDodajArtikalAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameArtikal jfa = new JFrameArtikal(0);
				
				panelAdmin.setVisible(false);
				jfa.setVisible(true);
				
				jfa.getBtnPonistiAkciju().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfa.setVisible(false);						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnArtikliAdmin.add(mntmDodajArtikalAdmin);

		JMenuItem mntmObrisiArtikalAdmin = new JMenuItem("Obrisi artikal");
		mntmObrisiArtikalAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameObrisiArtikal oa = new JFrameObrisiArtikal();
				panelAdmin.setVisible(false);
				oa.setVisible(true);
				
				
				oa.getBtnNazadObrisiArtikal().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						oa.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnArtikliAdmin.add(mntmObrisiArtikalAdmin);

		JMenuItem mntmAzurirajArtikleAdmin = new JMenuItem("Azuriraj");
		mnArtikliAdmin.add(mntmAzurirajArtikleAdmin);

		JMenu mnGrupeArtikalaAdmin = new JMenu("Grupe artikala");
		mnMaticniPodaciAdmin.add(mnGrupeArtikalaAdmin);

		JMenuItem mntmPregledGrupeArtikalaAdmin = new JMenuItem("Pregled grupe artikala");
		mntmPregledGrupeArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFramePregledGrupeArtikala pga = new JFramePregledGrupeArtikala();
				panelAdmin.setVisible(false);
				pga.setVisible(true);
				
				postaviModelGrupaArtikala(new ArrayList<>(), pga.getTablePregledGrupeArtikala());
				ArrayList lista;
				
				int id_grupe_artikala;
				
				try {
					lista = Kontroler.getInstance().getGrupaArtikala(0);
					postaviModelGrupaArtikala(lista, pga.getTablePregledGrupeArtikala());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				pga.getBtnIzlazPregledGrupeArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pga.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnGrupeArtikalaAdmin.add(mntmPregledGrupeArtikalaAdmin);

		JMenuItem mntmDodajGrupuArtikalaAdmin = new JMenuItem("Dodaj grupu artikala");
		mntmDodajGrupuArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrameGrupaArtikala jfga = new JFrameGrupaArtikala();
				
				panelAdmin.setVisible(false);
				jfga.setVisible(true);
				
				jfga.getBtnPonistiAkcijuDodajGrupuArtikala().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jfga.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnGrupeArtikalaAdmin.add(mntmDodajGrupuArtikalaAdmin);

		JMenuItem mntmObrisiGrupuArtikalaAdmin = new JMenuItem("Obrisi grupu artikala");
		mntmObrisiGrupuArtikalaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameObrisiGrupuArtikala obga = new JFrameObrisiGrupuArtikala();
				
				panelAdmin.setVisible(false);
				obga.setVisible(true);
				
				obga.getBtnNazadObrisiGA().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						obga.setVisible(false);
						
					}
				});
				panelAdmin.setVisible(true);
			}
		});
		mnGrupeArtikalaAdmin.add(mntmObrisiGrupuArtikalaAdmin);

		JMenuItem mntmAzurirajGrupuArtikalaAdmin = new JMenuItem("Azuriraj");
		mnGrupeArtikalaAdmin.add(mntmAzurirajGrupuArtikalaAdmin);

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

		JMenuItem mntmSumarniPregledDokumenataIzvAdmin = new JMenuItem("Sumarni pregled dokumenata");
		mnAnalizaProdajeIzvestajAdmin.add(mntmSumarniPregledDokumenataIzvAdmin);

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

		JMenu mnSistemAdmin = new JMenu("    Sistem");
		mnSistemAdmin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarAdmin.add(mnSistemAdmin);

		JMenuItem mntmPromeniLozinkuAdmin = new JMenuItem("Promeni lozinku");
		mntmPromeniLozinkuAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFramePromenaLozinke proloz = new JFramePromenaLozinke();
				
				
				panelAdmin.setVisible(false);
				proloz.setVisible(true);
				
				proloz.getBtnUReduPromenaLozinke().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if((proloz.getTextFieldUsername().getText().toString()).equals(logedIn.getUsernameZaposlenog()) && (proloz.getTextFieldPassword().getText().toString()).equals(logedIn.getPasswordZaposlenog())) {
							JOptionPane.showMessageDialog(null, "Unesite novu lozinku!");
						}else
						{
							JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!");
						}
						
						proloz.getTextFieldNewPassword().requestFocus();
						
						//proloz.getTextFieldNewPassword().getText();
						//proloz.getTextFieldConfirmPassword().getText();
						
						//if((proloz.getTextFieldNewPassword().getText().toString()).equals(proloz.getTextFieldConfirmPassword().getText().toString())) {
							
							proloz.getBtnChangePassword().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									try {
										if((proloz.getTextFieldNewPassword().getText().toString()).equals(proloz.getTextFieldConfirmPassword().getText().toString())) {
										logedIn.setPasswordZaposlenog(proloz.getTextFieldNewPassword().getText());	
										Kontroler.getInstance().updateZaposleni(logedIn);
										JOptionPane.showMessageDialog(null, "Uspesno ste promenili lozinku!");
										proloz.setVisible(false);
										
										}
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
								}
							});
							
							//panelAdmin.setVisible(true);
							//Kontroler.getInstance().updateZaposleni(logedIn);
							//JOptionPane.showMessageDialog(null, "Uspesno ste promenili lozinku!");
						} 
						
					}
				
				);
				panelAdmin.setVisible(true);
			}
		});
		mnSistemAdmin.add(mntmPromeniLozinkuAdmin);
		
		panelUserKomercijalista = new JPanel();
		frame.getContentPane().add(panelUserKomercijalista, "name_773056089739863");
		panelUserKomercijalista.setLayout(null);
		
		JMenuBar menuBarUserKom = new JMenuBar();
		menuBarUserKom.setBounds(0, 0, 630, 21);
		panelUserKomercijalista.add(menuBarUserKom);
		
		JMenu mnPrijavaUserKom = new JMenu("Prijava");
		mnPrijavaUserKom.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarUserKom.add(mnPrijavaUserKom);
		
		JMenuItem mntmOdjavaUserKom = new JMenuItem("Odjava");
		mntmOdjavaUserKom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelUserKomercijalista.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		mnPrijavaUserKom.add(mntmOdjavaUserKom);
		
		JMenu mnZaposleniUserKom = new JMenu("Zaposleni");
		mnPrijavaUserKom.add(mnZaposleniUserKom);
		
		JMenuItem mntmTrenutnoPrijavljeniUserKom = new JMenuItem("Trenutno prijavljeni");
		mnZaposleniUserKom.add(mntmTrenutnoPrijavljeniUserKom);
		
		JMenuItem mntmOsveziUserKom = new JMenuItem("Osvezi (Update)");
		mnPrijavaUserKom.add(mntmOsveziUserKom);
		
		JMenuItem mntmIzlazUserKom = new JMenuItem("Izlaz");
		mnPrijavaUserKom.add(mntmIzlazUserKom);
		
		panelUserMagacioner = new JPanel();
		frame.getContentPane().add(panelUserMagacioner, "name_847361888603433");
		panelUserMagacioner.setLayout(null);
		
		JMenuBar menuBarUserMag = new JMenuBar();
		menuBarUserMag.setBounds(0, 0, 630, 21);
		panelUserMagacioner.add(menuBarUserMag);
		
		JMenu mnPrijavaUserMag = new JMenu("Prijava");
		menuBarUserMag.add(mnPrijavaUserMag);
		mnPrijavaUserMag.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JMenuItem mntmOdjavaUserMag = new JMenuItem("Odjava");
		mntmOdjavaUserMag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelUserMagacioner.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		mnPrijavaUserMag.add(mntmOdjavaUserMag);
		
		JMenu mnZaposleniUserMag = new JMenu("Zaposleni");
		mnPrijavaUserMag.add(mnZaposleniUserMag);
		
		JMenuItem mntmTrenutnoPrijavljeniUserMag = new JMenuItem("Trenutno prijavljeni");
		mnZaposleniUserMag.add(mntmTrenutnoPrijavljeniUserMag);
		
		JMenuItem mntmOsveziUserMag = new JMenuItem("Osvezi (Update)");
		mnPrijavaUserMag.add(mntmOsveziUserMag);
		
		JMenuItem mntmIzlazUserMag = new JMenuItem("Izlaz");
		mnPrijavaUserMag.add(mntmIzlazUserMag);

	}
	
	private void postaviModelZaposleni(ArrayList lista, JTable t){
		JTabelModelZaposleni model = new JTabelModelZaposleni(lista);
		t.setModel(model);
	}	
	private void postaviModelFilijala(ArrayList lista, JTable t){
		JTableModelFilijala model = new JTableModelFilijala(lista);
		t.setModel(model);
	}	
	private void postaviModelMagacina(ArrayList lista, JTable t){
		JTableModelMagacin model = new JTableModelMagacin(lista);
		t.setModel(model);
	}
	
	private void postaviModelKupac(ArrayList lista, JTable t){
		JTableModelKupac model = new JTableModelKupac(lista);
		t.setModel(model);
	}
	
	private void postaviModelRacunOtpremnica(ArrayList lista, JTable t){
		JTableModelRacunOtpremnica model = new JTableModelRacunOtpremnica(lista);
		t.setModel(model);
	}
	
	private void postaviModelArtikli(ArrayList lista, JTable t){
		JTableModelArtikal model = new JTableModelArtikal(lista);
		t.setModel(model);
	}
	
	private void postaviModelGrupaArtikala(ArrayList lista, JTable t){
		JTableModelGrupeArtikala model = new JTableModelGrupeArtikala(lista);
		t.setModel(model);
	}
	
}
