package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Ecole extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Ecole() {
		super();
	}
	//selectAnneeScolaire des annees Scolaire du systeme
	public ResultSet selectEcole() {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM ecole");
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
}
