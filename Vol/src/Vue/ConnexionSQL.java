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
		
		
		/*// Chercher des donnÈes :
		try(Statement sta1 = conn.createStatement()){                       //executeQuery : execution select
			ResultSet rs = sta1.executeQuery("SELECT * FROM Admin");
		while(rs.next()) {
			System.out.println(rs.getString("password"));
			}
		}
		// RequÍte language SQL: 
		String strsql = "SELECT * FROM Passager";
		
		// Manipulation des tables : 
		try(Statement sta = conn.createStatement()){           // executeUpdate : execution de la mise ‡ jour
			sta.executeUpdate(strsql);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
}
		
		
		
	