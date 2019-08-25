package jframeIzvestaji;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

import com.toedter.calendar.JDateChooser;

import kontroler.Kontroler;
import model.Artikli;
import model.Filijala;
import model.GrupaArtikala;
import model.Izvestaj;
import model.Kupac;
import table.JTableModelProdajaPoFilijali;
import table.JTableModelProdajaPoKupacu;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrameIzvestajProdajeKupac extends JFrame {

	private JPanel contentPane;
	private JTable tableIzvestajKupac;
	private JTextField textFieldNabavnaVrenostIzvestajKupac;
	private JTextField textFieldOsnovicaIzvestajKupac;
	private JTextField textProdajnavrednostIzvestajProdajeKupac;
	private JTextField textFieldRucIzvestajProdajeKupac;
	private JComboBox <Kupac> comboBoxIzvestajKupac;
	private JComboBox comboBoxArtikalIzvestajKupac;
	
	
	
	
	

	public JComboBox getComboBoxIzvestajKupac() {
		return comboBoxIzvestajKupac;
	}

	public JTable getTableIzvestajKupac() {
		return tableIzvestajKupac;
	}

	public void setTableIzvestajKupac(JTable tableIzvestajKupac) {
		this.tableIzvestajKupac = tableIzvestajKupac;
	}

	public JTextField getTextFieldNabavnaVrenostIzvestajKupac() {
		return textFieldNabavnaVrenostIzvestajKupac;
	}

	public void setTextFieldNabavnaVrenostIzvestajKupac(JTextField textFieldNabavnaVrenostIzvestajKupac) {
		this.textFieldNabavnaVrenostIzvestajKupac = textFieldNabavnaVrenostIzvestajKupac;
	}

	public JTextField getTextFieldOsnovicaIzvestajKupac() {
		return textFieldOsnovicaIzvestajKupac;
	}

	public void setTextFieldOsnovicaIzvestajKupac(JTextField textFieldOsnovicaIzvestajKupac) {
		this.textFieldOsnovicaIzvestajKupac = textFieldOsnovicaIzvestajKupac;
	}

	public JTextField getTxtProdajnavrednostIzvestajProdajeKupac() {
		return textProdajnavrednostIzvestajProdajeKupac;
	}

	public void setTxtProdajnavrednostIzvestajProdajeKupac(JTextField txtProdajnavrednostIzvestajProdajeKupac) {
		this.textProdajnavrednostIzvestajProdajeKupac = txtProdajnavrednostIzvestajProdajeKupac;
	}

	public JTextField getTextFieldRucIzvestajProdajeKupac() {
		return textFieldRucIzvestajProdajeKupac;
	}

	public void setTextFieldRucIzvestajProdajeKupac(JTextField textFieldRucIzvestajProdajeKupac) {
		this.textFieldRucIzvestajProdajeKupac = textFieldRucIzvestajProdajeKupac;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzvestajProdajeKupac frame = new JFrameIzvestajProdajeKupac();
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
	public JFrameIzvestajProdajeKupac() {
		setTitle("IZVE\u0160TAJ PRODAJE PO KUPCIMA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelIzvestajKupac = new JLabel("Kupac : ");
		labelIzvestajKupac.setFont(new Font("Arial", Font.BOLD, 14));
		labelIzvestajKupac.setBounds(30, 20, 170, 20);
		contentPane.add(labelIzvestajKupac);
		
		comboBoxIzvestajKupac = new JComboBox();
		comboBoxIzvestajKupac.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxIzvestajKupac.setBounds(30, 60, 200, 20);
		contentPane.add(comboBoxIzvestajKupac);
		popuniComboBoxIzvestajKupac(comboBoxIzvestajKupac);
		comboBoxIzvestajKupac.setSelectedItem(null);
		
		
		comboBoxIzvestajKupac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				postaviModelProdajaPoKupcu(new ArrayList<Kupac>(), tableIzvestajKupac);
				ArrayList lista;
				try {
					
						lista = Kontroler.getInstance().getIzvestajProdajePoKupcu(((Kupac) 
									comboBoxIzvestajKupac.getSelectedItem()).getIdKupca());
						
						postaviModelProdajaPoKupcu(lista, tableIzvestajKupac);

						
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
			}
		});
		
		
		JPanel panelPodacizaPeriodKupac = new JPanel();
		panelPodacizaPeriodKupac.setLayout(null);
		panelPodacizaPeriodKupac.setBorder(new TitledBorder(null, "Podaci za period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPodacizaPeriodKupac.setBounds(350, 20, 470, 60);
		contentPane.add(panelPodacizaPeriodKupac);
		
		JLabel label = new JLabel("DO :");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(260, 30, 30, 20);
		panelPodacizaPeriodKupac.add(label);
		
		JLabel label_1 = new JLabel("OD :");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(10, 30, 30, 20);
		panelPodacizaPeriodKupac.add(label_1);
		
		JDateChooser dateChooserDoIzvestajKupac = new JDateChooser();
		dateChooserDoIzvestajKupac.setBounds(310, 30, 150, 20);
		panelPodacizaPeriodKupac.add(dateChooserDoIzvestajKupac);
		
		JDateChooser dateOdKupacIzvestaj = new JDateChooser();
		dateOdKupacIzvestaj.setBounds(60, 30, 150, 20);
		panelPodacizaPeriodKupac.add(dateOdKupacIzvestaj);
		
		JPanel panelFilterKupac = new JPanel();
		panelFilterKupac.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFilterKupac.setLayout(null);
		panelFilterKupac.setBounds(30, 120, 710, 50);
		contentPane.add(panelFilterKupac);
		
		JLabel label_2 = new JLabel("Grupa artikla :");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(10, 20, 110, 20);
		panelFilterKupac.add(label_2);
		
		JComboBox comboBoxGrupaArtikalaIzvestajKupac = new JComboBox();
		comboBoxGrupaArtikalaIzvestajKupac.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxGrupaArtikalaIzvestajKupac.setBounds(150, 20, 200, 20);
		panelFilterKupac.add(comboBoxGrupaArtikalaIzvestajKupac);
		popuniComboBoxGrupaArtikala(comboBoxGrupaArtikalaIzvestajKupac);
		comboBoxGrupaArtikalaIzvestajKupac.setSelectedItem(null);
		
		comboBoxGrupaArtikalaIzvestajKupac.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				postaviModelProdajaPoKupcu(new ArrayList<GrupaArtikala>(), tableIzvestajKupac);
				ArrayList lista;
				try {
					
						lista = Kontroler.getInstance().getIzvestajProdajePoKupcuPoGrupi(((Kupac) 
								comboBoxIzvestajKupac.getSelectedItem()).getIdKupca(),((GrupaArtikala) 
										comboBoxGrupaArtikalaIzvestajKupac.getSelectedItem()).getIdGrupeArtikala());
						postaviModelProdajaPoKupcu(lista, tableIzvestajKupac);
					
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			}
			
		});
				
				
            comboBoxGrupaArtikalaIzvestajKupac.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if (comboBoxGrupaArtikalaIzvestajKupac.getSelectedItem() != null) {
						
						//pamcenje i skidanje actionlistener-a
						ActionListener al = comboBoxArtikalIzvestajKupac.getActionListeners()[0];
						comboBoxArtikalIzvestajKupac.removeActionListener(al);
						
						popuniComboBoxArtikli(comboBoxArtikalIzvestajKupac,
								((GrupaArtikala) comboBoxGrupaArtikalaIzvestajKupac.getSelectedItem()).getIdGrupeArtikala());
						comboBoxArtikalIzvestajKupac.setSelectedItem(null);
						
						//vracanje zapamcenog actionlistener-a
						comboBoxArtikalIzvestajKupac.addActionListener(al);
					}
					else
					{
						comboBoxArtikalIzvestajKupac.removeAllItems();
						comboBoxArtikalIzvestajKupac.setSelectedItem(null);
					}
					
				}
			});
				
		
		
		JLabel label_3 = new JLabel("Artikal :");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(400, 20, 70, 20);
		panelFilterKupac.add(label_3);
		
		comboBoxArtikalIzvestajKupac = new JComboBox();
		comboBoxArtikalIzvestajKupac.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBoxArtikalIzvestajKupac.setBounds(490, 20, 200, 20);
		panelFilterKupac.add(comboBoxArtikalIzvestajKupac);
		
		comboBoxArtikalIzvestajKupac.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				postaviModelProdajaPoKupcu(new ArrayList<Artikli>(), tableIzvestajKupac);
				ArrayList lista;
				try {
					
						lista = Kontroler.getInstance().getIzvestajProdajePoKupcuPoGrupiPoArtiklu(((Kupac) 
								comboBoxIzvestajKupac.getSelectedItem()).getIdKupca(),((GrupaArtikala) 
								comboBoxGrupaArtikalaIzvestajKupac.getSelectedItem()).getIdGrupeArtikala(),
								((Artikli)comboBoxArtikalIzvestajKupac.getSelectedItem()).getIdArtikla());
						postaviModelProdajaPoKupcu(lista, tableIzvestajKupac);
					
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			}
		});
		
		
		JScrollPane scrollPaneIzvestajKupac = new JScrollPane();
		scrollPaneIzvestajKupac.setBounds(30, 200, 1220, 230);
		contentPane.add(scrollPaneIzvestajKupac);
		
		tableIzvestajKupac = new JTable();
		scrollPaneIzvestajKupac.setViewportView(tableIzvestajKupac);
		postaviModelProdajaPoKupcu(new ArrayList<Izvestaj>(), tableIzvestajKupac);
		
		
		JPanel panelIzvestajKupac = new JPanel();
		panelIzvestajKupac.setLayout(null);
		panelIzvestajKupac.setBounds(30, 500, 1100, 50);
		contentPane.add(panelIzvestajKupac);
		
		JLabel label_4 = new JLabel("Nabavna vrenost :");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(10, 20, 130, 20);
		panelIzvestajKupac.add(label_4);
		
		textFieldNabavnaVrenostIzvestajKupac = new JTextField();
		textFieldNabavnaVrenostIzvestajKupac.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldNabavnaVrenostIzvestajKupac.setColumns(10);
		textFieldNabavnaVrenostIzvestajKupac.setBounds(160, 20, 120, 20);
		panelIzvestajKupac.add(textFieldNabavnaVrenostIzvestajKupac);
		
		JLabel label_5 = new JLabel("Osnovica :");
		label_5.setFont(new Font("Arial", Font.BOLD, 14));
		label_5.setBounds(320, 20, 80, 20);
		panelIzvestajKupac.add(label_5);
		
		textFieldOsnovicaIzvestajKupac = new JTextField();
		textFieldOsnovicaIzvestajKupac.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldOsnovicaIzvestajKupac.setColumns(10);
		textFieldOsnovicaIzvestajKupac.setBounds(420, 20, 120, 20);
		panelIzvestajKupac.add(textFieldOsnovicaIzvestajKupac);
		
		JLabel label_6 = new JLabel("Prodajna vrednost :");
		label_6.setFont(new Font("Arial", Font.BOLD, 14));
		label_6.setBounds(580, 20, 140, 20);
		panelIzvestajKupac.add(label_6);
		
		textProdajnavrednostIzvestajProdajeKupac = new JTextField();
		textProdajnavrednostIzvestajProdajeKupac.setFont(new Font("Arial", Font.PLAIN, 13));
		textProdajnavrednostIzvestajProdajeKupac.setColumns(10);
		textProdajnavrednostIzvestajProdajeKupac.setBounds(740, 20, 120, 20);
		panelIzvestajKupac.add(textProdajnavrednostIzvestajProdajeKupac);
		
		JLabel label_7 = new JLabel("RUC :");
		label_7.setFont(new Font("Arial", Font.BOLD, 14));
		label_7.setBounds(900, 20, 50, 20);
		panelIzvestajKupac.add(label_7);
		
		textFieldRucIzvestajProdajeKupac = new JTextField();
		textFieldRucIzvestajProdajeKupac.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldRucIzvestajProdajeKupac.setColumns(10);
		textFieldRucIzvestajProdajeKupac.setBounds(970, 20, 120, 20);
		panelIzvestajKupac.add(textFieldRucIzvestajProdajeKupac);
	}
	
	private void postaviModelProdajaPoKupcu(ArrayList lista, JTable t){
		 JTableModelProdajaPoKupacu model = new  JTableModelProdajaPoKupacu(lista);
		t.setModel(model);
	}
	
	private  void popuniComboBoxGrupaArtikala(JComboBox<GrupaArtikala> comboBox) {
		try {
			ArrayList<GrupaArtikala> lista = Kontroler.getInstance().getGrupaArtikala();

			for (GrupaArtikala ga : lista) {
				comboBox.addItem(ga);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private  void popuniComboBoxArtikli(JComboBox<Artikli> comboBox, Integer id_grupe_artikala) {
		

		try {
			comboBox.removeAllItems();
			ArrayList<Artikli> lista1 = Kontroler.getInstance().getArtikli(id_grupe_artikala);

			// for (GlavnaGrupa gg : lista) {
			for (Artikli a : lista1) {
				comboBox.addItem(a);		

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private void popuniComboBoxIzvestajKupac(JComboBox<Kupac> comboBox) {
		try {
			ArrayList<Kupac> lista = Kontroler.getInstance().getKupac();

			for (Kupac k : lista) {
				comboBox.addItem(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}