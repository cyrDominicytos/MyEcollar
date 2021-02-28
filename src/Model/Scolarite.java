package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Scolarite  extends Connexion{
	private Statement requete=null;
	private ResultSet result=null;
	
	public Scolarite() {
		super();
	}
	
	
	
	
	//selectAnneeScolaire des annees Scolaire du systeme
	public ResultSet selectScolarite() {
		
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM SCOLARITE ORDER BY ANNEESCOLAIRE DESC");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
	//selectAnneeScolaire des annees Scolaire du systeme
		public int selectScolariteClasseAnnee(String annee, String classe)
		{
			int scolar = 0;
			try {
				requete = connexionDB.createStatement();
				result = requete.executeQuery("SELECT MONTANT FROM SCOLARITE WHERE CLASSE = '"+classe+"' AND ANNEESCOLAIRE = '"+annee+"' ");
				
				if(result.next())
					scolar = result.getInt("MONTANT");
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}
			    return scolar;
		}
	
	
   //updateAnneeScolaire des annees Scolaire du systeme
	public void updateScolariteClasse(String classe, int valeur) {
		
		try {
			 requete = connexionDB.createStatement();
			 requete.executeUpdate("UPDATE SCOLARITE SET MONTANT="+valeur+"  WHERE ANNEESCOLAIRE='"+new DonneeStatiques().anneeCourante+"' AND CLASSE = '"+classe+"'");
			 DonneeStatiques.messageDialog("La scolarite de la classe "+classe+" a bien été modifiée ",0);
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		
	}
		
	//insertAnneeScolaire des annees Scolaire du systeme
		public void insertScolarite(String classe, int montant, String annee) {
			classe = DonneeStatiques.scarpe(classe);
				 switch (this.ScolariteExiste(classe, annee)) 
				 {
					case 1:
						DonneeStatiques.messageDialog("Erreur !!!\n\nLa scolarite de la classe  "+classe+" existe déjà. \n\n Vous pouvez la modifier en allant dans liste des classes",1);
						
						break;
					case 0:
						try {
							 requete = connexionDB.createStatement();
							 requete.executeUpdate("INSERT INTO SCOLARITE(CLASSE, MONTANT, ANNEESCOLAIRE) VALUES('"+classe+"',"+montant+",'"+annee+"')");
							 DonneeStatiques.messageDialog("La scolarite de la classe "+classe+" a été bien enregistré!",0);
							
						} catch (SQLException e) {
							DonneeStatiques.messageDialog(e.getMessage(), 3);
						}
						
						break;
					default:
						DonneeStatiques.messageDialog("Une erreur inattandue s'est produite durant \nl'enregistrement de la scolarité de la classe "+classe+" \n veuillez réessayer l'opération !",2);
						break;
				 }
			
			
			
		}
		
		public void insertScolariteUp( ResultSet result, String annee)
		{
			try {
				while(result.next())
				 {
					 Statement requete2 = connexionDB.createStatement();
					 requete2.execute("INSERT INTO SCOLARITE(CLASSE, MONTANT, ANNEESCOLAIRE) VALUES('"+result.getString("CLASSE")+"',"+result.getString("MONTANT")+",'"+annee+"')");
				 }
				DonneeStatiques.messageDialog("Mise à jour des scolarités par classe terminée pour l'année "+annee, 0);
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}
			 
		}
		
		public void insertClassInscUp( ResultSet result, String annee) {
			try {

				while(result.next())
				 {
					 Statement requete2 = connexionDB.createStatement();
					requete2.execute("INSERT INTO classenbrinscrit(CLASSE, ANNEESCOLAIRE, NOMBRE) VALUES('"+result.getString("CLASSE")+"','"+annee+"', "+0+")");
				 }
				DonneeStatiques.messageDialog("Mise à jour des classes terminée pour l'année "+annee, 0);
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}
		}
		
	
		public void insertMiseAjourScolarite() {
			try {
				 requete = connexionDB.createStatement();
				 result =  requete.executeQuery("SELECT MAX(ANNEESCOLAIRE) AS PRECEDENTE FROM anneescolaire WHERE ANNEESCOLAIRE != (SELECT MAX(ANNEESCOLAIRE)  FROM anneescolaire)");
				 result.next();
				 if(result.getString("PRECEDENTE") != null)	
				 {
					 String anneePrecedente = result.getString("PRECEDENTE");
					 result =  requete.executeQuery("SELECT MAX(ANNEESCOLAIRE) AS ACTUELLE FROM anneescolaire ");
					 result.next();
					 if(result.getString("ACTUELLE") != null)	
					 {
						 String annee = result.getString("ACTUELLE");
						 
						 insertClassInscUp(requete.executeQuery("SELECT * FROM SCOLARITE  WHERE  ANNEESCOLAIRE ='"+anneePrecedente+"' "), annee);
						 insertScolariteUp(requete.executeQuery("SELECT * FROM SCOLARITE  WHERE  ANNEESCOLAIRE ='"+anneePrecedente+"' "), annee);
						
					}
					
				 }
				
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}
			 
			
			}
		public int ScolariteExiste(String classe , String annee) {	
			try {
				 requete = connexionDB.createStatement();
				 result =  requete.executeQuery("SELECT COUNT(*) FROM SCOLARITE WHERE CLASSE = '"+classe+"' AND ANNEESCOLAIRE = '"+annee+"'");
				
				 if(result.next() && result.getInt("COUNT(*)") == 1)		 
				 return 1;
				 return 0;						 
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
				 return -1;	
			}
		   
		}
		
}
