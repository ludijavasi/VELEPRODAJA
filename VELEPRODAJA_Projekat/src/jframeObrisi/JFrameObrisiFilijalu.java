package jframeObrisi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframe.JFrameFilijala;
import jframe.JFrameMagacin;
import kontroler.Kontroler;
import model.Filijala;
import model.Magacin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameObrisiFilijalu extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxFilijalaObrisi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameObrisiFilijalu frame = new JFrameObrisiFilijalu();
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
	public JFrameObrisiFilijalu() {
		setTitle("OBRISI FILIJALU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiFilijalu = new JLabel("Izaberite filijalu :");
		lblIzaberiFilijalu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIzaberiFilijalu.setBounds(91, 52, 278, 17);
		contentPane.add(lblIzaberiFilijalu);
		
		JComboBox comboBoxFilijalaObrisi = new JComboBox();
		comboBoxFilijalaObrisi.setBounds(91, 95, 355, 20);
		contentPane.add(comboBoxFilijalaObrisi);
		popuniComboBoxFilijala(comboBoxFilijalaObrisi);
		
		JButton btnOtvoriFilijalu = new JButton("Otvori filijalu");
		btnOtvoriFilijalu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOtvoriFilijalu.setBounds(189, 154, 160, 23);
		contentPane.add(btnOtvoriFilijalu);
	}
	
	private void popuniComboBoxFilijala(JComboBox<Filijala> comboBox) {
		try {
			ArrayList<Filijala> lista = Kontroler.getInstance().getFilijala();

			for (Filijala f : lista) {
				comboBox.addItem(f);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
