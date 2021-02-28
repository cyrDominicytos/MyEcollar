package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Classe  extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Classe() {
		super();
	}
	
	//selectClasse des annees Scolaire du systeme
		public ResultSet selectClasse() {
			
			
			try {
				requete = connexionDB.createStatement();
				result = requete.executeQuery("SELECT * FROM CLASSE");
				
				return result; 
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}
			    return result;
		}
		
		//selectClasse des annees Scolaire du systeme
				public ResultSet selectClasseListe(String annee) {
					
					
					try {
						requete = connexionDB.createStatement();
						result = requete.executeQuery("SELECT *  FROM CLASSENBRINSCRIT C, SCOLARITE S WHERE C.CLASSE = S.CLASSE AND C.ANNEESCOLAIRE = '"+( annee.isEmpty() ? (new DonneeStatiques().anneeCourante) : (annee) )+"'AND S.ANNEESCOLAIRE = '"+( annee.isEmpty() ? (new DonneeStatiques().anneeCourante) : (annee) )+"' 	ORDER BY MONTANT, C.CLASSE ");
						
						return result; 
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
					    return result;
				}
		
	   //updateClasse des annees Scolaire du systeme
		public void updateClasse(String classe, String oldClass) {
			classe = DonneeStatiques.scarpe(classe);
			oldClass = DonneeStatiques.scarpe(oldClass);
			try {
				requete = connexionDB.createStatement();
				 requete.executeUpdate("UPDATE Classe SET CLASSEGROUPE='"+classe+"' WHERE CLASSEGROUPE='"+oldClass+"'");
				 DonneeStatiques.messageDialog("La classe "+oldClass+" a bien été modifiée en "+classe,0);
			} catch (SQLException e) {
				DonneeStatiques.messageDialog(e.getMessage(), 3);
			}
			
		}
			
		//insertClasse des annees Scolaire du systeme
			public void insertClasse(String classe, int scolarite) {
				classe = DonneeStatiques.scarpe(classe);
				 switch (this.ClasseExiste(classe)) 
				 {
					case 1:
						DonneeStatiques.messageDialog("Erreur !!!\n\nLa classe  "+classe+" existe déjà. \n\n Vous pouvez la modifier en allant dans liste des classes",1);
						break;
					case 0:
						try {
							 requete = connexionDB.createStatement();
							 requete.executeUpdate("INSERT INTO CLASSE(CLASSEGROUPE, ANNEECREATION) VALUES('"+classe+"', '"+new DonneeStatiques().anneeCourante+"')");
							 DonneeStatiques.messageDialog("La classe "+classe+" a été bien enregistré dans la base!",0);
							 new Scolarite().insertScolarite(classe, scolarite, new DonneeStatiques().anneeCourante);
							 
							 
						} catch (SQLException e) {
							DonneeStatiques.messageDialog(e.getMessage(), 3);
						}
						
						break;
					default:
						DonneeStatiques.messageDialog("Une erreur inattandue s'est produite durant \nl'enregistrement de la classe "+classe+" \n veuillez réessayer l'opération !",2);
						break;
				 }

			}
			
				public int ClasseExiste(String classe) {	
				try {
					 requete = connexionDB.createStatement();
					 result =  requete.executeQuery("SELECT COUNT(*) FROM CLASSE WHERE CLASSEGROUPE = '"+classe+"'");
					 if(result.next() && result.getInt("COUNT(*)") == 1)		 
					 return 1;
					 return 0;						 
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
					 return -1;	
				}
			   
			}
}
