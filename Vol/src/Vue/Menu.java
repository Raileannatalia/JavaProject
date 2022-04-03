package Vue;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class Menu extends JFrame{

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main (String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu mn = new Menu();
					mn.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.setBounds(100, 100, 591, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(0, 0, 139));
		btnExit.setBounds(248, 355, 117, 41);
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
		
		JButton btnPassager = new JButton("");
		btnPassager.setBounds(47, 157, 104, 74);
		frame.getContentPane().add(btnPassager);
		btnPassager.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/bin/passager.png"));
		
		JLabel lblPassager = new JLabel("Passagers");
		lblPassager.setFont(new Font("Bangla MN", Font.PLAIN, 16));
		lblPassager.setBounds(57, 243, 99, 27);
		frame.getContentPane().add(lblPassager);
		
		JButton btnVol = new JButton("");
		btnVol.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Vols vol = new Vols();
				vol.setVisible(true);
				
			}
		});
		btnVol.setBounds(248, 157, 104, 74);
		frame.getContentPane().add(btnVol);
		btnVol.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/bin/vol.png"));
		
		JLabel lblVols = new JLabel("Vols");
		lblVols.setHorizontalAlignment(SwingConstants.CENTER);
		lblVols.setFont(new Font("Bangla MN", Font.PLAIN, 16));
		lblVols.setBounds(253, 243, 99, 27);
		frame.getContentPane().add(lblVols);
		
		JButton btnBillets = new JButton("");
		btnBillets.setBounds(441, 157, 104, 70);
		frame.getContentPane().add(btnBillets);
		btnBillets.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/bin/billet.png"));
		
		JLabel lblBilleterie = new JLabel("Billeterie");
		lblBilleterie.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilleterie.setFont(new Font("Bangla MN", Font.PLAIN, 16));
		lblBilleterie.setBounds(446, 245, 99, 27);
		frame.getContentPane().add(lblBilleterie);
		
		JLabel lblGestion = new JLabel("Aéroport Gestion");
		lblGestion.setBackground(new Color(176, 196, 222));
		lblGestion.setForeground(new Color(240, 255, 255));
		lblGestion.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/bin/aeroport.png"));
		lblGestion.setFont(new Font("Bangla MN", Font.PLAIN, 30));
		lblGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestion.setBounds(0, 0, 591, 70);
		frame.getContentPane().add(lblGestion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(240, 255, 255));
		separator.setBounds(10, 74, 575, 12);
		frame.getContentPane().add(separator);
		
		btnBillets.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Billeterie bil = new Billeterie();
				bil.getFrame().setVisible(true);
			}
		});
		btnBillets.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnVol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnPassager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PassagerInfo pas = new PassagerInfo();
				pas.setVisible(true);
			}
		});
		btnPassager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

}
