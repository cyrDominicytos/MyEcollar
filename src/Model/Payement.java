package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;
import files.Success;

public class Payement  extends Connexion{
	private Statement requete=null;
	private ResultSet result=null;
	public Payement() {
		super();
	}
	
	/******************************************************** 
	 * selectPayement liste des Payements du systeme
	 * @return
	 * 
	 ******************************************************/
	public ResultSet selectPayement(String annee, String classe) {
		classe = DonneeStatiques.scarpe(classe);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT MATRICULE, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, P.MONTANT, CONCAT('Le ',DATE(P.DATEPAYEMENT), ' à ', TIME(P.DATEPAYEMENT)) AS DATEPAYEMENT FROM PAYEMENT P, APPRENANT AP, INSCRIPTION I WHERE P.APPRENANT = AP.MATRICULE AND I.ANNEESCOLAIRE = P.ANNEESCOLAIRE AND I.APPRENANT= P.APPRENANT AND P.ANNEESCOLAIRE = '"+annee+"' AND I.CLASSE = '"+classe+"' AND MONTANT > 0 ;");			
			  
			return result;
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			  return result;
		}
		  
	}
	
public ResultSet selectPayement(String annee, String classe, String date) {
	classe = DonneeStatiques.scarpe(classe);
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT MATRICULE, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, P.MONTANT, CONCAT('Le ', DATE(P.DATEPAYEMENT), ' à ', TIME(P.DATEPAYEMENT)) AS DATEPAYEMENT FROM PAYEMENT P, APPRENANT AP, INSCRIPTION I WHERE P.APPRENANT = AP.MATRICULE AND I.ANNEESCOLAIRE = P.ANNEESCOLAIRE AND I.APPRENANT= P.APPRENANT AND P.ANNEESCOLAIRE = '"+annee+"' AND I.CLASSE = '"+classe+"' AND  DATE(P.DATEPAYEMENT) = '"+date+"' AND MONTANT > 0 ;");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}

public ResultSet selectPayement(String annee, String classe, int apprenant) {
	classe = DonneeStatiques.scarpe(classe);
	try {
		requete = connexionDB.createStatement();
		result = requete.executeQuery("SELECT  MATRICULE ,CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, P.MONTANT, CONCAT('Le ',DATE(P.DATEPAYEMENT), ' à ', TIME(P.DATEPAYEMENT)) AS DATEPAYEMENT FROM PAYEMENT P, APPRENANT AP, INSCRIPTION I WHERE P.APPRENANT = AP.MATRICULE AND I.ANNEESCOLAIRE = P.ANNEESCOLAIRE AND I.APPRENANT= P.APPRENANT AND P.ANNEESCOLAIRE = '"+annee+"' AND I.CLASSE = '"+classe+"' AND AP.MATRICULE = "+apprenant+"  AND MONTANT > 0 ;");
		
		return result; 
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
	}
	    return result;
}

public ResultSet selectPayement(String annee, String classe, int apprenant, String date) {
	classe = DonneeStatiques.scarpe(classe);
	try {
		requete = connexionDB.createStatement();
		result = requete.executeQuery("SELECT MATRICULE , CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, P.MONTANT, CONCAT('Le ',DATE(P.DATEPAYEMENT), ' à ', TIME(P.DATEPAYEMENT)) AS DATEPAYEMENT FROM PAYEMENT P, APPRENANT AP, INSCRIPTION I WHERE P.APPRENANT = AP.MATRICULE AND I.ANNEESCOLAIRE = P.ANNEESCOLAIRE AND I.APPRENANT= P.APPRENANT AND P.ANNEESCOLAIRE = '"+annee+"' AND I.CLASSE = '"+classe+"' AND AP.MATRICULE = "+apprenant+" AND DATE(P.DATEPAYEMENT) = '"+date+"' AND MONTANT > 0 ;");
		
		return result; 
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
	}
	    return result;
}
	
	/******************************************************** 
	 * Seuil  des Payements 
	 * @return
	 * 
	 ******************************************************/
public ResultSet selectSeuilPayement(String annee, String classe) {
	classe = DonneeStatiques.scarpe(classe);
	try {
		requete = connexionDB.createStatement();
		result = requete.executeQuery("SELECT MATRICULE, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, P.MONTANT, CONCAT('Le ',DATE(P.DATEPAYEMENT), ' à ', TIME(P.DATEPAYEMENT)) AS DATEPAYEMENT FROM PAYEMENT P, APPRENANT AP, INSCRIPTION I WHERE P.APPRENANT = AP.MATRICULE AND I.ANNEESCOLAIRE = P.ANNEESCOLAIRE AND I.APPRENANT= P.APPRENANT AND P.ANNEESCOLAIRE = '"+annee+"' AND I.CLASSE = '"+classe+"';");			
		  
		return result;
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
		  return result;
	}
	  
}

public ResultSet selectSeuilPayement(String annee, String classe, int apprenant) {
	classe = DonneeStatiques.scarpe(classe);
	try {
		requete = connexionDB.createStatement();
		result = requete.executeQuery("SELECT  MATRICULE ,CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, P.MONTANT, CONCAT('Le ',DATE(P.DATEPAYEMENT), ' à ', TIME(P.DATEPAYEMENT)) AS DATEPAYEMENT FROM PAYEMENT P, APPRENANT AP, INSCRIPTION I WHERE P.APPRENANT = AP.MATRICULE AND I.ANNEESCOLAIRE = P.ANNEESCOLAIRE AND I.APPRENANT= P.APPRENANT AND P.ANNEESCOLAIRE = '"+annee+"' AND I.CLASSE = '"+classe+"' AND AP.MATRICULE = "+apprenant+";");
		
		return result; 
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
	}
	    return result;
}
	
	/**********************************************************
	 * insertPayement des annees Scolaire du systeme
	 * @param apprenant
	 * @param classe 
	 **********************************************************/
	public void insertPayement(int apprenant, String annee, int montant) {
		int Scolarite = 0, totalPayer = 0;
		totalPayer = this.TotalScolaritePayer(apprenant,annee);
		Scolarite =  new Scolarite().selectScolariteClasseAnnee(annee, (new Inscription().selectClasseApprenant(apprenant, annee)));
		Scolarite -=  this.Reduction(apprenant, annee);
		switch (Integer.compare(Scolarite,totalPayer)) {
		case -1:
			DonneeStatiques.messageDialog("Solde dépassé!!!\n\nPar erreur cet apprenant a payé plus qu'il ne doive !Il mérite un remboursement de   "+(totalPayer - Scolarite)+" FCFA", 2);
			break;
		case 0:
			DonneeStatiques.messageDialog("Paiement !!!\n\nL'apprenant ayant le matricule  "+apprenant+" s'est déjà acquietté de la totalité de ses frais  pour le compte de l'année  "+annee+"", 1);
			break;
		case 1:
			if(montant <= Scolarite-totalPayer)
			{
				try {
					 requete = connexionDB.createStatement();
					 requete.executeUpdate("INSERT INTO PAYEMENT(MONTANT,APPRENANT,ANNEESCOLAIRE) VALUES("+montant+","+apprenant+",'"+annee+"')");
					 DonneeStatiques.messageDialog("Le Payement a bien été enregistré !", 0);
					
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
				}
			}else {
				DonneeStatiques.messageDialog("Montant superieur!!!\n\nLa valeur de la scolarité restante pour cet apprenant n'atteint pas   "+montant+" \n\nCet apprenant reste devoir "+ (Scolarite - totalPayer)+"", 1);
				
			}
			
			break;
				default:
			break;
		}
		
	}
			
	@SuppressWarnings("unused")
	public int TotalScolaritePayer(int apprenant, String annee) {
		
		try {
			 requete = connexionDB.createStatement();
			 result =  requete.executeQuery("SELECT SUM(MONTANT) FROM Payement WHERE APPRENANT = "+apprenant+" AND  ANNEESCOLAIRE = '"+annee+"'");
			
			 result.next();
			 return result.getInt("SUM(MONTANT)") ;	 
		} catch (SQLException e) 
		{
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			 return 0;	
		}
	}		
		public int Reduction(int apprenant, String annee) {
			
			try {
				 requete = connexionDB.createStatement();
				 result =  requete.executeQuery("SELECT MONTANT FROM REDUCTION WHERE APPRENANT = "+apprenant+" AND  ANNEESCOLAIRE = '"+annee+"'");
				
				 if(result.next()) 
				 return result.getInt("MONTANT") ;	 
				 return 0 ;	
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
				 return 0;	
			}
	   
	}
	
}



