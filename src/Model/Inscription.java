package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Inscription  extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Inscription() {
		super();
	}
	
	
	/******************************************************** 
	 * selectInscription liste des Inscriptions du systeme
	 * @return
	 * 
	 ******************************************************/
	public ResultSet selectInscription() {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM Inscription");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
	public ResultSet selectNomPrenomDesInscriptionNonValider(String classe, String annee) {
		classe = DonneeStatiques.scarpe(classe);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT MATRICULE, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, Sexe, Contact FROM Apprenant A, INSCRIPTION I WHERE A.MATRICULE = I.APPRENANT AND I.CLASSE =  '"+classe+"' AND I.ANNEESCOLAIRE = '"+ annee+"' AND I.FRAIS IS NULL");
		   
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}

    public ResultSet selectApprenantInscritParAnnee(String classe, String annee) {
    	classe = DonneeStatiques.scarpe(classe);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT MATRICULE, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, Sexe, Contact FROM APPRENANT A, INSCRIPTION I WHERE A.MATRICULE = I.APPRENANT AND I.CLASSE =  '"+classe+"' AND I.ANNEESCOLAIRE = '"+ annee+"'");
		   
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	 }
    
    public ResultSet selectApprenantAInscritParAnnee(String classe, String annee) {
    	classe = DonneeStatiques.scarpe(classe);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT MATRICULE, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, Sexe, Contact FROM APPRENANT A, INSCRIPTION I WHERE A.MATRICULE = I.APPRENANT AND I.CLASSE =  '"+classe+"' AND I.ANNEESCOLAIRE = '"+ annee+"' AND A.MATRICULE NOT IN (SELECT A.MATRICULE FROM APPRENANT A, INSCRIPTION I WHERE A.MATRICULE = I.APPRENANT AND  I.ANNEESCOLAIRE = '"+ new DonneeStatiques().anneeCourante+"')");
		   
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	 }
    
    public ResultSet selectDerniereInscription(int matricule) {
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM INSCRIPTION  WHERE APPRENANT = "+matricule+" AND ANNEESCOLAIRE = (SELECT MAX(ANNEESCOLAIRE) FROM INSCRIPTION  WHERE APPRENANT  = "+matricule+")");
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	 }
public String selectClasseApprenant(int apprenant, String annee) {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT CLASSE FROM INSCRIPTION I WHERE I.APPRENANT =  "+apprenant+" AND I.ANNEESCOLAIRE = '"+ annee+"'");
			
			 result.next(); 
			 return result.getString("CLASSE");
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return "";
	}	

public int selectFraisApprenant(int apprenant, String annee) {
	
	try {
		requete = connexionDB.createStatement();
		result = requete.executeQuery("SELECT FRAIS FROM INSCRIPTION I WHERE I.APPRENANT =  "+apprenant+" AND I.ANNEESCOLAIRE = '"+ annee+"'");
		
		 result.next(); 
		 return result.getInt("FRAIS");
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
	}
	    return 0;
}
    
	
	/**********************************************************
	 * insertInscription des annees Scolaire du systeme
	 * @param apprenant
	 * @param classe 
	 **********************************************************/
	public int insertInscription(int apprenant, String classe, int frais) {
		classe = DonneeStatiques.scarpe(classe);
		int reponse = -1;
		switch (this.InscriptionExiste(apprenant, classe)) {
		case 1:
			JOptionPane.showMessageDialog(null, "Erreur !!!\n\nL'apprenant ayant le matricule  "+apprenant+" s'est déjà inscrit pour le compte de l'année  "+new AnneeScolaire().selectCurrentAnneeScolaire()+"");
			break;
		case 0:
			try {
				 requete = connexionDB.createStatement();
				 reponse = 	 requete.executeUpdate("INSERT INTO Inscription(APPRENANT,CLASSE,ANNEESCOLAIRE, FRAIS) VALUES("+apprenant+",'"+classe+"','"+new AnneeScolaire().selectCurrentAnneeScolaire()+"', "+frais+")");
				 DonneeStatiques.messageDialog("L'inscription a bien été prise en compte!",0);
				
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}
			
			break;
		default:
			DonneeStatiques.messageDialog("Une erreur inattandue s'est produite durant l'inscription  \n veuillez réessayer l'opération l'inscription!",2);
			break;
		}
		
		return reponse;
	}
		
	
	public int UpdateInscription(int apprenant, String classe, int frais, String ancienneClasse) {
		classe = DonneeStatiques.scarpe(classe);
		ancienneClasse = DonneeStatiques.scarpe(ancienneClasse);
		
		  int reponse = -1;
			try {
				 requete = connexionDB.createStatement();
				 reponse = 	 requete.executeUpdate("UPDATE Inscription SET CLASSE = '"+classe+"', FRAIS= "+frais+" WHERE APPRENANT ="+apprenant+" AND  ANNEESCOLAIRE='"+new AnneeScolaire().selectCurrentAnneeScolaire()+"'");
				 DonneeStatiques.messageDialog("L'inscription a bien été modifiée",0);
				
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}		
		return reponse;
	}
	public int InscriptionExiste(int apprenant, String classe) {
		classe = DonneeStatiques.scarpe(classe);
		try {
			 requete = connexionDB.createStatement();
			 result =  requete.executeQuery("SELECT COUNT(*) FROM Inscription WHERE APPRENANT = "+apprenant+" AND CLASSE = '"+classe+"' AND ANNEESCOLAIRE = '"+new AnneeScolaire().selectCurrentAnneeScolaire()+"'");
			
			 if(result.next() && result.getInt("COUNT(*)") == 1)
			 return 1;
			 return 0;
				 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			 return -1;	
		}
	   
	}
	
	public void validerInscription(int apprenant, String classe, int frais)
	{
		classe = DonneeStatiques.scarpe(classe);
		try {
		     
			 requete = connexionDB.createStatement();
			 requete.executeUpdate("UPDATE  INSCRIPTION SET FRAIS = "+frais+" WHERE APPRENANT = '"+apprenant+"' AND ANNEESCOLAIRE = '"+new AnneeScolaire().selectCurrentAnneeScolaire()+"' AND CLASSE = '"+classe+"'");
			 DonneeStatiques.messageDialog("Validation d'inscription réussie!",0);
			
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			
		}
		   
	}
	
}
