package Vue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.*;
import junit.extensions.TestDecorator;
import junit.framework.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
import Modèle.ConnexionSQL;
import java.sql.Connection;
import java.sql.DriverManager;


public class Billeterie extends JFrame{

	private JFrame frame;
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JFrame getFrame() {
		
		return frame;
	}

	private JTextField textPrice;
	private JTextField textClass;
	private JTextField textAllerRetour;
	private JTextField textCategorie;
	private JTextField textFrom;
	private JTextField textTo;
	private JTextField textDate;
	private JTextField textHeure;
	private JTextField textSiege;
	private JTextField textNrTicket;
	private JTextField textCompagnie;
	


	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billeterie bil = new Billeterie();
					bil.frame.setVisible(true);
					//bil.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Connection c = null;
		
		// Connexion :
		try {
			//org.Nomdelabd.Driver driver = new org.nomdelabd.Driver();
			Class.forName("org.sqlite.JDBC");                         // On instancie l'objet de la classe
			c = DriverManager.getConnection("jdbc:sqlite:BasesDeDonnees/BDD.db");       //Connection du driver avec la BD
			System.out.println("SQLite DataBase connected");
		} catch (Exception e){
			e.printStackTrace();                                   //sert ‡ garder une trace de l'exeption
		}
	}

	/**
	 * Create the application.
	 */
	public Billeterie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.setBounds(0, 0, 1164, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblClass.setBounds(42, 102, 90, 33);
		frame.getContentPane().add(lblClass);
		
		JRadioButton rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setFont(new Font("Bangla MN", Font.PLAIN, 13));
		rdbtnEconomy.setBounds(42, 147, 141, 23);
		frame.getContentPane().add(rdbtnEconomy);
		
		JRadioButton rdbtnStandart = new JRadioButton("Standart");
		rdbtnStandart.setFont(new Font("Bangla MN", Font.PLAIN, 13));
		rdbtnStandart.setBounds(42, 193, 141, 23);
		frame.getContentPane().add(rdbtnStandart);
		
		JRadioButton rdbtnBusiness = new JRadioButton("Business");
		rdbtnBusiness.setFont(new Font("Bangla MN", Font.PLAIN, 13));
		rdbtnBusiness.setBounds(42, 243, 141, 23);
		frame.getContentPane().add(rdbtnBusiness);
		
		JLabel lblAllerRetour = new JLabel("Aller/Retour");
		lblAllerRetour.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblAllerRetour.setBounds(207, 102, 132, 33);
		frame.getContentPane().add(lblAllerRetour);
		
		JRadioButton rdbtnAllerSimple = new JRadioButton("Aller simple");
		rdbtnAllerSimple.setFont(new Font("Bangla MN", Font.PLAIN, 13));
		rdbtnAllerSimple.setBounds(217, 147, 122, 23);
		frame.getContentPane().add(rdbtnAllerSimple);
		
		JRadioButton rdbtnAllerRetour = new JRadioButton("Aller-Retour");
		rdbtnAllerRetour.setFont(new Font("Bangla MN", Font.PLAIN, 13));
		rdbtnAllerRetour.setBounds(217, 193, 122, 23);
		frame.getContentPane().add(rdbtnAllerRetour);
		
		JLabel lblCategorie = new JLabel("Catégorie");
		lblCategorie.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblCategorie.setBounds(396, 102, 100, 33);
		frame.getContentPane().add(lblCategorie);
		
		JRadioButton rdbtnAdulte = new JRadioButton("Adulte");
		rdbtnAdulte.setFont(new Font("Bangla MN", Font.PLAIN, 13));
		rdbtnAdulte.setBounds(406, 147, 90, 23);
		frame.getContentPane().add(rdbtnAdulte);
		
		JRadioButton rdbtnEnfant = new JRadioButton("Enfant");
		rdbtnEnfant.setFont(new Font("Bangla MN", Font.PLAIN, 13));
		rdbtnEnfant.setBounds(406, 193, 90, 23);
		frame.getContentPane().add(rdbtnEnfant);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(240, 255, 255));
		separator.setBounds(42, 127, 441, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblDestination = new JLabel("Déstination");
		lblDestination.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblDestination.setBounds(42, 304, 132, 33);
		frame.getContentPane().add(lblDestination);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(240, 255, 255));
		separator_1.setBounds(42, 333, 441, 12);
		frame.getContentPane().add(separator_1);
		
		JComboBox comboDestination = new JComboBox();
		comboDestination.setModel(new DefaultComboBoxModel(new String[] {"To:", "Bruxelles", "Paris", "Tokyo", "New York"}));
		comboDestination.setFont(new Font("Bangla MN", Font.PLAIN, 14));
		comboDestination.setBounds(42, 349, 158, 33);
		frame.getContentPane().add(comboDestination);
		
		JLabel lblCompanie = new JLabel("Companie");
		lblCompanie.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblCompanie.setBounds(217, 304, 132, 33);
		frame.getContentPane().add(lblCompanie);
		
		JComboBox comboCompanie = new JComboBox();
		comboCompanie.setModel(new DefaultComboBoxModel(new String[] {"With:", "SwissAirlines", "EasyJet", "AirFrance", "AmericanAigle"}));
		comboCompanie.setFont(new Font("Bangla MN", Font.PLAIN, 14));
		comboCompanie.setBounds(217, 349, 158, 33);
		frame.getContentPane().add(comboCompanie);
		
		/*JLabel lblDateCalendar = new JLabel("Date");
		lblDateCalendar.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblDateCalendar.setBounds(567, 402, 75, 33);
		frame.getContentPane().add(lblDateCalendar);*/
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblPrice.setBounds(567, 294, 61, 23);
		frame.getContentPane().add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setBackground(new Color(248, 248, 255));
		textPrice.setBounds(711, 294, 90, 26);
		frame.getContentPane().add(textPrice);
		textPrice.setColumns(10);
		
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setToolTipText("Cancel System");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Cancel les informations choisis 
				textPrice.setText(null);
				rdbtnAdulte.setSelected(false);
				rdbtnEnfant.setSelected(false);
				rdbtnEconomy.setSelected(false);
				rdbtnStandart.setSelected(false);
				rdbtnBusiness.setSelected(false);
				comboDestination.setSelectedItem("Destination");
				comboCompanie.setSelectedItem("Companie");
				rdbtnAllerSimple.setSelected(false);
				rdbtnAllerRetour.setSelected(false);
				textTo.setText(null);
				textFrom.setText(null);
				textDate.setText(null);
				textHeure.setText(null);
				textClass.setText(null);
				textPrice.setText(null);
				textAllerRetour.setText(null);
				textCategorie.setText(null);
				textSiege.setText(null);
				textNrTicket.setText(null);
				
			}
		});
		btnCancel.setFont(new Font("Bangla MN", Font.BOLD, 13));
		btnCancel.setBounds(199, 510, 117, 33);
		frame.getContentPane().add(btnCancel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Exit System");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frame, "Confirmer pour quitter","Authentification",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Bangla MN", Font.BOLD, 13));
		btnExit.setBounds(354, 510, 117, 33);
		frame.getContentPane().add(btnExit);
		
		JSeparator sep1 = new JSeparator();
		sep1.setForeground(new Color(240, 255, 255));
		sep1.setBounds(42, 474, 441, 12);
		frame.getContentPane().add(sep1);
		
		JSeparator sep2 = new JSeparator();
		sep2.setForeground(new Color(240, 255, 255));
		sep2.setOrientation(SwingConstants.VERTICAL);
		sep2.setBounds(508, 102, 12, 441);
		frame.getContentPane().add(sep2);
		
		JLabel lblDetails = new JLabel("Détails:");
		lblDetails.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblDetails.setBounds(532, 102, 132, 33);
		frame.getContentPane().add(lblDetails);
		
		JLabel lblInfoClass = new JLabel("Class");
		lblInfoClass.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblInfoClass.setBounds(567, 143, 132, 33);
		frame.getContentPane().add(lblInfoClass);
		
		JLabel lblInfoAllerRetour = new JLabel("Aller/Retour");
		lblInfoAllerRetour.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblInfoAllerRetour.setBounds(567, 189, 132, 33);
		frame.getContentPane().add(lblInfoAllerRetour);
		
		JLabel lblInfoCategorie = new JLabel("Catégorie");
		lblInfoCategorie.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblInfoCategorie.setBounds(567, 244, 132, 33);
		frame.getContentPane().add(lblInfoCategorie);
		
		textClass = new JTextField();
		textClass.setBackground(new Color(248, 248, 255));
		textClass.setColumns(10);
		textClass.setBounds(711, 143, 90, 26);
		frame.getContentPane().add(textClass);
		
		textAllerRetour = new JTextField();
		textAllerRetour.setBackground(new Color(248, 248, 255));
		textAllerRetour.setColumns(10);
		textAllerRetour.setBounds(711, 189, 90, 26);
		frame.getContentPane().add(textAllerRetour);
		
		textCategorie = new JTextField();
		textCategorie.setBackground(new Color(248, 248, 255));
		textCategorie.setColumns(10);
		textCategorie.setBounds(711, 239, 90, 26);
		frame.getContentPane().add(textCategorie);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblFrom.setBounds(871, 148, 90, 33);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblTo.setBounds(871, 189, 90, 33);
		frame.getContentPane().add(lblTo);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblDate.setBounds(871, 239, 90, 33);
		frame.getContentPane().add(lblDate);
		
		JLabel lblHeure = new JLabel("L'heure");
		lblHeure.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblHeure.setBounds(871, 289, 90, 33);
		frame.getContentPane().add(lblHeure);
		
		textFrom = new JTextField();
		textFrom.setBackground(new Color(248, 248, 255));
		textFrom.setColumns(10);
		textFrom.setBounds(956, 143, 109, 26);
		frame.getContentPane().add(textFrom);
		
		textTo = new JTextField();
		textTo.setBackground(new Color(248, 248, 255));
		textTo.setColumns(10);
		textTo.setBounds(956, 189, 109, 26);
		frame.getContentPane().add(textTo);
		
		textDate = new JTextField();
		textDate.setBackground(new Color(248, 248, 255));
		textDate.setColumns(10);
		textDate.setBounds(956, 239, 109, 26);
		frame.getContentPane().add(textDate);
		
		textHeure = new JTextField();
		textHeure.setBackground(new Color(248, 248, 255));
		textHeure.setColumns(10);
		textHeure.setBounds(956, 289, 109, 26);
		frame.getContentPane().add(textHeure);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(240, 255, 255));
		separator_3.setBounds(532, 127, 533, 12);
		frame.getContentPane().add(separator_3);
		
		JLabel lblSige = new JLabel("Siège");
		lblSige.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblSige.setBounds(567, 333, 132, 33);
		frame.getContentPane().add(lblSige);
		
		textSiege = new JTextField();
		textSiege.setBackground(new Color(248, 248, 255));
		textSiege.setColumns(10);
		textSiege.setBounds(711, 333, 90, 26);
		frame.getContentPane().add(textSiege);
		
		JLabel lblNrticket = new JLabel("NrTicket");
		lblNrticket.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblNrticket.setBounds(871, 333, 90, 33);
		frame.getContentPane().add(lblNrticket);
		
		textNrTicket = new JTextField();
		textNrTicket.setBackground(new Color(248, 248, 255));
		textNrTicket.setColumns(10);
		textNrTicket.setBounds(956, 333, 109, 26);
		frame.getContentPane().add(textNrTicket);
		
		JLabel lblAroportDeDpart = new JLabel("Aéroport de départ");
		lblAroportDeDpart.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblAroportDeDpart.setBounds(42, 402, 182, 33);
		frame.getContentPane().add(lblAroportDeDpart);
		
		JComboBox comboDepart = new JComboBox();
	
		
		comboDepart.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if (e.getStateChange()==ItemEvent.SELECTED) {
					comboDepart.getSelectedItem().toString();
				}
				
			}
			
		});
		
		comboDepart.setModel(new DefaultComboBoxModel(new String[] {"From:", "Nantes", "Lyon ", "Genève"}));
		comboDepart.setFont(new Font("Bangla MN", Font.PLAIN, 14));
		comboDepart.setBounds(42, 436, 158, 33);
		frame.getContentPane().add(comboDepart);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(240, 255, 255));
		separator_1_2.setBounds(42, 394, 441, 12);
		frame.getContentPane().add(separator_1_2);
		
		
		JButton btnTotal = new JButton("Total");
		btnTotal.setToolTipText("La somme total des billets");
		btnTotal.setFont(new Font("Bangla MN", Font.BOLD, 13));
		btnTotal.setBounds(45, 510, 117, 33);
		frame.getContentPane().add(btnTotal);
		
		JLabel lblCompagnie = new JLabel("Compagnie");
		lblCompagnie.setFont(new Font("Bangla MN", Font.PLAIN, 17));
		lblCompagnie.setBounds(567, 378, 132, 33);
		frame.getContentPane().add(lblCompagnie);
		
		textCompagnie = new JTextField();
		textCompagnie.setBackground(new Color(248, 248, 255));
		textCompagnie.setColumns(10);
		textCompagnie.setBounds(711, 371, 90, 26);
		frame.getContentPane().add(textCompagnie);
		
		JLabel lblBilleterie = new JLabel("Billeterie - Aéroport");
		lblBilleterie.setForeground(new Color(240, 255, 255));
		lblBilleterie.setFont(new Font("Bangla MN", Font.PLAIN, 30));
		lblBilleterie.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilleterie.setIcon(new ImageIcon("/Users/raileannatalia/Desktop/monDossierJava/workspace/GestionAvia/bin/billet.png"));
		lblBilleterie.setBounds(0, 0, 1164, 84);
		frame.getContentPane().add(lblBilleterie);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(240, 255, 255));
		separator_2.setBounds(42, 78, 1023, 12);
		frame.getContentPane().add(separator_2);
		btnTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//======L'heure=====
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
				textHeure.setText(tTime.format(timer.getTime()));
			
			//======Date=====
				SimpleDateFormat tDate = new SimpleDateFormat("dd-MMM-yyyy");
				textDate.setText(tDate.format(timer.getTime()));
				
				//textFrom.setText(comboDepart.getSelectedItem().toString());
				textTo.setText((String) comboDestination.getSelectedItem()+"*");
				//utiliser setText pour remplir les ... 
				textFrom.setText((String) comboDepart.getSelectedItem());
				//textClass.
				textCompagnie.setText((String) comboCompanie.getSelectedItem());
				
				if (rdbtnEconomy.isSelected()) {
					textClass.setText("Economy");
				}
				if (rdbtnStandart.isSelected()) {
					textClass.setText("Standart");
				}
				if (rdbtnBusiness.isSelected()) {
					textClass.setText("Busines");
				}
				
				if (rdbtnAllerSimple.isSelected()){
					textAllerRetour.setText("Aller Simple");	
				}
				if (rdbtnAllerRetour.isSelected()){
					textAllerRetour.setText("Aller-Retour");	
				}
				if (rdbtnAdulte.isSelected()){
					textCategorie.setText("Adulte");	
				}
				if (rdbtnEnfant.isSelected()){
					textCategorie.setText("Enfant");	
				}
				
				
			//=====Random number generator=====
				int nb1;
				String a1 ="";
				nb1 = 2453 + (int) (Math.random()*5680);
				a1+=nb1+2453;
				textNrTicket.setText(a1);
	
			}
		});
		ConnexionSQL connect = new ConnexionSQL();
		
	}

	public void calculerPrix() {
		
	}

}
