package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;


public class PassagerInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTable table;
	private JTextField textPasseport;
	private JTextField textDestination;
	private JTextField textNrVol;
	private JTextField textNrSiege;
	
	Connection conn = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassagerInfo pass = new PassagerInfo();
					pass.setVisible(true);
					pass.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public PassagerInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		conn = ConnexionSQL.ConnexionDB();
		
		JLabel lblPassagers = new JLabel("Passagers");
		lblPassagers.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/bin/passager.png"));
		lblPassagers.setFont(new Font("Bangla MN", Font.PLAIN, 30));
		lblPassagers.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassagers.setForeground(new Color(240, 255, 255));
		lblPassagers.setBackground(new Color(176, 196, 222));
		lblPassagers.setBounds(0, 0, 763, 55);
		contentPane.add(lblPassagers);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(240, 255, 255));
		separator.setBounds(0, 55, 763, 12);
		contentPane.add(separator);
		
		textNom = new JTextField();
		textNom.setBounds(132, 67, 130, 39);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(34, 80, 86, 16);
		contentPane.add(lblNom);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(132, 110, 130, 39);
		contentPane.add(textPrenom);
		textPrenom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(34, 121, 86, 16);
		contentPane.add(lblPrenom);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String prenom  =textPrenom.getText().toString();
				String nom  =textNom.getText().toString();
				String passeport  =textPasseport.getText().toString();
				String destination  =textDestination.getText().toString();
				String nvVol  =textNrVol.getText().toString();
				String nrsiege  =textNrSiege.getText().toString();
			
				String sql = ("INSERT INTO Passager values (? ,? ,?, ?, ?, ?)");
				try {
					
					if(!prenom.equals("") && !nom.equals("")&& !passeport.equals("") && !destination.equals("")&& !nvVol.equals("") && !nrsiege.equals("")) {
						prepared = conn.prepareStatement(sql);
						prepared.setString(1, prenom);
						prepared.setString(2, nom);
						prepared.setString(3, passeport);
						prepared.setString(4, destination);
						prepared.setString(5, nvVol);
						prepared.setString(6, nrsiege);
						prepared.execute();
						
						textPrenom.getText();
						textNom.getText();
						textPasseport.getText();
						textDestination.getText();
						textNrVol.getText();
						textNrSiege.getText();
					} else {
						JOptionPane.showMessageDialog(null, "Ajouter");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			
		});
		btnAjouter.setBounds(85, 359, 117, 29);
		contentPane.add(btnAjouter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 79, 464, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnActualiser.setBounds(484, 359, 117, 29);
		contentPane.add(btnActualiser);
		
		JLabel lblPasseport = new JLabel("Passeport");
		lblPasseport.setBounds(34, 163, 86, 16);
		contentPane.add(lblPasseport);
		
		textPasseport = new JTextField();
		textPasseport.setColumns(10);
		textPasseport.setBounds(132, 152, 130, 39);
		contentPane.add(textPasseport);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(34, 208, 86, 16);
		contentPane.add(lblDestination);
		
		JLabel lblNrvol = new JLabel("NrVol");
		lblNrvol.setBounds(34, 250, 86, 16);
		contentPane.add(lblNrvol);
		
		JLabel lblNrsige = new JLabel("NrSiège");
		lblNrsige.setBounds(34, 293, 86, 16);
		contentPane.add(lblNrsige);
		
		textDestination = new JTextField();
		textDestination.setColumns(10);
		textDestination.setBounds(132, 197, 130, 39);
		contentPane.add(textDestination);
		
		textNrVol = new JTextField();
		textNrVol.setColumns(10);
		textNrVol.setBounds(132, 239, 130, 39);
		contentPane.add(textNrVol);
		
		textNrSiege = new JTextField();
		textNrSiege.setColumns(10);
		textNrSiege.setBounds(132, 282, 130, 39);
		contentPane.add(textNrSiege);
	}
	public void initialize() {
		conn = ConnexionSQL.ConnexionDB();
	}
	public void UpdateTable() {
		String sql = "Select * from Passager";
		
		try {
			prepared = conn.prepareStatement(sql);
			resultat = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
