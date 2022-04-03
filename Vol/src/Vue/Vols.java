package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vols extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
					Vols vol = new Vols();
					vol.setVisible(true);
					vol.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vols() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		conn = ConnexionSQL.ConnexionDB();
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(25, 25, 112));
		separator.setBounds(0, 55, 629, 12);
		contentPane.add(separator);
		
		JLabel lblVols = new JLabel("Vols");
		lblVols.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/bin/vol.png"));
		lblVols.setHorizontalAlignment(SwingConstants.CENTER);
		lblVols.setForeground(new Color(0, 0, 128));
		lblVols.setFont(new Font("Bangla MN", Font.PLAIN, 30));
		lblVols.setBackground(new Color(176, 196, 222));
		lblVols.setBounds(0, 0, 629, 55);
		contentPane.add(lblVols);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 67, 464, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnActualiser.setBounds(264, 350, 117, 29);
		contentPane.add(btnActualiser);
	}
	public void initialize() {
		conn = ConnexionSQL.ConnexionDB();
	}
	public void UpdateTable() {
		String sql = "Select * from Avion";
		
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
