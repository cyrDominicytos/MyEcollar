package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Depense  extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Depense() {
		super();
	}
	
	/********************************************************
	 * 
	 * selectDepense liste des Depenses du systeme
	 * @return
	 * 
	 * 
	 ******************************************************/
	public ResultSet selectDepense(String date) {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM Depense WHERE ANNEESCOLAIRE='"+date+"'");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
	public ResultSet selectDepenseAUneDate(String date) {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM Depense WHERE DATE(DATEDEPENSE) = '"+date+"'");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	public ResultSet selectDepenseSuivantObjet(String objet,String date) {
		
		objet = DonneeStatiques.scarpe(objet);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM Depense WHERE OBJET = '"+objet+"' AND ANNEESCOLAIRE='"+date+"'");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
public ResultSet selectDepenseSuivantObjetAutre(String date) {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM Depense WHERE OBJET NOT IN ('Fournitures scolaires', 'Matériel didactique','Salaire') AND ANNEESCOLAIRE='"+date+"'");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	public ResultSet selectDepenseSalaire(String date) {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT D.DESCRIPTION, D.MONTANT, CONCAT(E.NOM,' ', E.PRENOM) AS NOM_PRENOM, D.ENSEIGNANT, D.DATEDEPENSE FROM DEPENSE D,ENSEIGNANT E WHERE D.ENSEIGNANT = E.TELEPHONE AND D.OBJET = 'Salaire' AND D.ANNEESCOLAIRE='"+date+"'");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
	
	/****************************************************************************
	 * 
	 * insertDepense des annees Scolaire du systeme
	 * @param dateDebut
	 * @param dateFin
	 * @param annee
	 * 
	 * 
	 ***************************************************************************/
		public int insertDepense(String objet, String description,int  montant,String enseignant) {
			
				int reponse = 0;
				//description = DonneeStatiques.scarpe(description);
				objet = DonneeStatiques.scarpe(objet);
				try {
					 requete = connexionDB.createStatement();
					 reponse =  requete.executeUpdate("INSERT INTO depense(OBJET, DESCRIPTION, MONTANT, ENSEIGNANT, ANNEESCOLAIRE)  VALUES('"+objet+"',\""+description+"\","+montant+",'"+enseignant+"', '"+new DonneeStatiques().anneeCourante+"')");
					 DonneeStatiques.messageDialog("La Depense "+objet+" "+montant+" a été bien enregistrée dans la base!",0);
					
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
				}
			return reponse;
		}
			
		
}
