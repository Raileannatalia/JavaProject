package Vue;
import java.lang.System.Logger;
import java.sql.*;

import javax.swing.JOptionPane;

public class ConnexionSQL {

	public static Connection ConnexionDB(){
		Connection conn = null;
		
	
		// Connexion :
		try {
			//org.Nomdelabd.Driver driver = new org.nomdelabd.Driver();
			Class.forName("org.sqlite.JDBC");                         // On instancie l'objet de la classe
			conn = DriverManager.getConnection("jdbc:sqlite:BasesDeDonnees/BDD.db");       //Connection du driver avec la BD
			System.out.println("SQLite DataBase connected");
			return conn;
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
		
		
		
	