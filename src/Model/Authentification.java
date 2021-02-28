package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Authentification extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Authentification() {
		super();
	}
	//selectAnneeScolaire des annees Scolaire du systeme
	public Boolean Authentifier(String login, String pwd) {
		Boolean reponse = false;
		login = DonneeStatiques.scarpe(login);
		pwd = DonneeStatiques.scarpe(pwd);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT COUNT(*) FROM CONNEXION WHERE LOGIN = '"+login+"' AND PASSWORD = '"+pwd+"'");
			if(result.next())
			{
				if(result.getInt("COUNT(*)") == 1)
					reponse = true;
			}
			connexionDB.close();
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return reponse;
	}
}
