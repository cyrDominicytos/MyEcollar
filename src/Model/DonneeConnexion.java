package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class DonneeConnexion extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public DonneeConnexion() {
		super();
	}
	//selectAnneeScolaire des annees Scolaire du systeme
	public ResultSet selectSchool() {
		
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM  CONNEXION");
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
	public ResultSet selectCurrentSchool() {
		
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM  CONNEXION WHERE ETAT = 'TRUE'");
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		return   result; 
	}
	public String selectNomCurrentSchool() {
		
		String nom ="";
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM  CONNEXION WHERE ETAT = 'TRUE'");
			
			if(result.next())
				nom = result.getString("LOGIN");
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		return   nom; 
	}
	public String selectPWDCurrentSchool() {
		
		String nom ="";
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM  CONNEXION WHERE ETAT = 'TRUE'");
			
			if(result.next())
				nom = result.getString("PASSWORD");
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		return   nom; 
	}
   //updateAnneeScolaire des annees Scolaire du systeme
	public void updateSchool(String login, String password) {
		
		try {
			 requete = connexionDB.createStatement();
			 requete.executeUpdate("UPDATE CONNEXION SET LOGIN='"+login+"' , PASSWORD ='"+password+"' WHERE ETAT='TRUE'");
			
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		
	}

	
}
