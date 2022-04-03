package Modèle;
import java.lang.System.Logger;
import java.sql.*;

public class ConnexionSQL {

	public static void main(String[] args) throws SQLException {
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
		
		// Chercher des donnÈes :
		try(Statement sta1 = c.createStatement()){                       //executeQuery : execution select
			ResultSet rs = sta1.executeQuery("SELECT * FROM Admin");
		while(rs.next()) {
			System.out.println(rs.getString("password"));
			}
		}
		// RequÍte language SQL: 
		String strsql = "SELECT * FROM Passager";
		
		// Manipulation des tables : 
		try(Statement sta = c.createStatement()){           // executeUpdate : execution de la mise ‡ jour
			sta.executeUpdate(strsql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
		
		
		
	