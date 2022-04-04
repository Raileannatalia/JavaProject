package Vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//============================Lien vers repository GitHub=======================

/* https://github.com/Raileannatalia/JavaProject.git

1. creer New repository sur GitHub Desktop
2. copier le lien de cette repository --> dans l'onglet ouvrant choisir le fichier qui contient le projet.
3. Faire "Push"-- le projet a ete bien ajouter sur GitHub. */


public class Login_password extends JFrame{

	private JFrame frame;
	private JTextField textUserName;
	private JPasswordField textPassword;
	private JPanel contentPane;
	
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
					Login_password auth = new Login_password();
					auth.frame.setVisible(true);
					auth.setLocationRelativeTo(null);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(240, 248, 255));
		frame.getContentPane().setFont(new Font("Bangla MN", Font.BOLD, 20));
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		conn = ConnexionSQL.ConnexionDB();
		
		JLabel lblText = new JLabel("Authentification");
		lblText.setForeground(UIManager.getColor("Menu.background"));
		lblText.setBounds(138, 6, 219, 47);
		lblText.setFont(new Font("Bangla MN", Font.PLAIN, 25));
		frame.getContentPane().add(lblText);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(UIManager.getColor("Menu.background"));
		lblPassword.setBounds(73, 133, 117, 38);
		lblPassword.setFont(new Font("Bangla MN", Font.PLAIN, 20));
		frame.getContentPane().add(lblPassword);
		
		JLabel lblUserName = new JLabel("Login");
		lblUserName.setForeground(SystemColor.menu);
		lblUserName.setBounds(73, 65, 105, 41);
		lblUserName.setFont(new Font("Bangla MN", Font.PLAIN, 20));
		frame.getContentPane().add(lblUserName);
		
		textUserName = new JTextField();
		textUserName.setBounds(227, 65, 130, 26);
		textUserName.setFont(new Font("Bangla MN", Font.PLAIN, 14));
		frame.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(227, 140, 130, 26);
		textPassword.setFont(new Font("Bangla MN", Font.PLAIN, 14));
		frame.getContentPane().add(textPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 139));
		btnLogin.setBounds(50, 201, 117, 41);
		btnLogin.setFont(new Font("Bangla MN", Font.BOLD, 20));
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String password = textPassword.getText().toString();
				String login = textUserName.getText().toString();
				
				String sql = "select login,password from Admin ";
				
				try {
					prepared = conn.prepareStatement(sql);
					resultat = prepared.executeQuery();
					
					int i = 0;
					
					if (login.equals("") || password.equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Remplissez les champs vides");
					} else 
					{
			
						while (resultat.next()) 
						{
							String login1 = resultat.getString("login");
							String password1 = resultat.getString("password");
							
							if(login1.equals(login) && password1.equals(password)) 
							{
								JOptionPane.showMessageDialog(null, "Connexion reussie");
								i = 1;
									
							}
						}
						if (i==0) {
							JOptionPane.showMessageDialog(null, "Pas de connexion, reesayez");
						} else 
						{
							Menu mn = new Menu();
							mn.getFrame().setVisible(true);
							//fermer l'onglet
						}
						}
				}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		frame.getContentPane().add(btnLogin);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setForeground(new Color(0, 0, 139));
		btnEffacer.setBounds(193, 201, 117, 41);
		btnEffacer.setFont(new Font("Bangla MN", Font.BOLD, 20));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textUserName.setText(null);
				textPassword.setText(null);
					
			}
		});
		frame.getContentPane().add(btnEffacer);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(0, 0, 139));
		btnExit.setBounds(339, 201, 117, 41);
		btnExit.setFont(new Font("Bangla MN", Font.BOLD, 20));
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frame = new JFrame("Exit");
			
				if(JOptionPane.showConfirmDialog(frame, "Confirmer pour quitter","Authentification",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
			}
		});
		frame.getContentPane().add(btnExit);
		
		JSeparator separator_top = new JSeparator();
		separator_top.setBounds(73, 47, 349, 12);
		frame.getContentPane().add(separator_top);
		
		JSeparator separator_buttom = new JSeparator();
		separator_buttom.setBounds(73, 191, 349, 12);
		frame.getContentPane().add(separator_buttom);
		
		JLabel lblImage = new JLabel("");
		String chemin = "2.jpeg";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		lblImage.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/image/2.jpeg"));
		lblImage.setBounds(0, -21, 500, 293);
		frame.getContentPane().add(lblImage);
	}
	
}


