package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class SeuilDePayement  extends Connexion{
	private Statement requete=null;
	private ResultSet result=null;
	public SeuilDePayement() {
		super();
	}
	
	/******************************************************** 
	 * selectPayement liste des Payements du systeme
	 * @return
	 * 
	 ******************************************************/
	public ResultSet selectSeuilDePayement(String annee, String classe, String condition) {
		classe = DonneeStatiques.scarpe(classe);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT S.*, R.MONTANT AS REDUCTION FROM SEUIL_PAYEMENT S , REDUCTION R  WHERE S.MATRICULE = R.APPRENANT AND  S.ANNEESCOLAIRE = '"+annee+"' AND S.CLASSE = '"+classe+"' "+condition+"");			
			
			return result;
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			  return result;
		}
		  
	}
	

public ResultSet selectSeuilDePayement(String annee, String classe, int apprenant, String condition) {
	classe = DonneeStatiques.scarpe(classe);
	try {
		requete = connexionDB.createStatement();
		result = requete.executeQuery("SELECT S.*, R.MONTANT AS REDUCTION FROM SEUIL_PAYEMENT S , REDUCTION R  WHERE S.MATRICULE = R.APPRENANT AND  S.ANNEESCOLAIRE = '"+annee+"' AND CLASSE = '"+classe+"' AND MATRICULE = "+apprenant+" "+condition+"");			
		
		return result; 
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
	}
	    return result;
}

		
}



