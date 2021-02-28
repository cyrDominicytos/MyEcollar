package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class AnneeScolaire extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public AnneeScolaire() {
		super();
	}
	//selectAnneeScolaire des annees Scolaire du systeme
	public ResultSet selectAnneeScolaire() {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM ANNEESCOLAIRE ORDER BY ANNEESCOLAIRE DESC");
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
	public String selectCurrentAnneeScolaire() {
		
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT MAX(ANNEESCOLAIRE) FROM ANNEESCOLAIRE");
			
			return  result.next() ? result.getString("MAX(ANNEESCOLAIRE)") : ("") ;
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		return   (" - "); 
	}
	
	public String selectCurrentDateFinAnneeScolaire() {
		
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT MAX(DATEFIN) FROM ANNEESCOLAIRE");
			
			return  result.next() ? result.getString("MAX(DATEFIN)") : (" - ") ;
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		return   (" - "); 
	}
	
   //updateAnneeScolaire des annees Scolaire du systeme
	public void updateAnneeScolaire(String Annee, String dateDebut, String dateFin) {
		
		try {
			 requete = connexionDB.createStatement();
			 requete.executeUpdate("UPDATE ANNEESCOLAIRE SET DATEDEBUT='"+dateDebut+"' , DATEFIN ='"+dateFin+"' WHERE ANNEESCOLAIRE='"+Annee+"' ");
			 DonneeStatiques.messageDialog("Les dates de debut et de fin de l'année scolaire "+Annee+" ont bien été modifiées ",0);
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		
	}
		
	//insertAnneeScolaire des annees Scolaire du systeme
		public void insertAnneeScolaire(String dateDebut, String dateFin, String annee) {
			
			 switch (this.AnneeScolaireExiste(annee)) 
			 {
				case 1:
					DonneeStatiques.messageDialog("L'année scolaire "+annee+" existe déjà. \n\n Vous pouvez la modifier en allant dans liste des années scolaires",1);
					break;
				case 0:
					try {
						 requete = connexionDB.createStatement();
						 requete.executeUpdate("INSERT INTO ANNEESCOLAIRE(DATEDEBUT, DATEFIN,ANNEESCOLAIRE) VALUES(\""+dateDebut+"\",\""+dateFin+"\",\""+annee+"\")");
						 DonneeStatiques.messageDialog("L'année scolaire "+annee+" a été bien enregistré" , 0);
						
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
					
					break;
				default:
					DonneeStatiques.messageDialog("Une erreur inattandue s'est produite durant \nl'enregistrement de\"L'année scolaire "+annee+" \n veuillez réessayer l'opération !",2);
					break;
			 }
			
		}
		public int AnneeScolaireExiste(String annee) {	
			try {
				 requete = connexionDB.createStatement();
				 result =  requete.executeQuery("SELECT COUNT(*) FROM ANNEESCOLAIRE WHERE ANNEESCOLAIRE = '"+annee+"'");
				
				 if(result.next() && result.getInt("COUNT(*)") == 1)		 
				 return 1;
				 return 0;						 
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
				 return -1;	
			}
		   
		}
}
