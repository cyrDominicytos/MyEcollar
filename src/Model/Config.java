package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Config  extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Config() {
		super();
	}
	
	
		//selectClasse des annees Scolaire du systeme
		public ResultSet selectConfig(String code) {
			
			
			try {
				requete = connexionDB.createStatement();
				result = requete.executeQuery("SELECT *  FROM Config  WHERE code= '"+code+"'");
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
			public void insertLicence(String code, String licence, String now, String end)
			{
				//classe = DonneeStatiques.scarpe(classe);
				 switch (this.ProgramsHasLicence()) 
				 {
					case 1:
						DonneeStatiques.messageDialog("Vous disposez d'une licence Démo",1);
						break;
					case 0:
						try {
							 requete = connexionDB.createStatement();
							 requete.executeUpdate("INSERT INTO config(code, str_value, created_at, updated_at) VALUES('"+code+"', '"+licence+"', '"+now+"', '"+end+"')");
							} catch (SQLException e) {
								DonneeStatiques.messageDialog(e.getMessage(), 3);
							}
						
						break;
					default:
						DonneeStatiques.messageDialog("Une erreur inattandue s'est produite durant \nl'installatin de votre démo. Veuillez contactez le fournisseur",2);
						break;
				 }

			}
			
			public int ProgramsIsBoot() 
			{	
				try {
					 requete = connexionDB.createStatement();
					 result =  requete.executeQuery("SELECT COUNT(*) FROM anneescolaire");
					 if(result.next() && result.getInt("COUNT(*)") >= 1)		 
					 return 1;
					 return 0;						 
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
					 return -1;	
				}
			   
			}
			
			public int ProgramsHasLicence() 
			{	
				try {
					 requete = connexionDB.createStatement();
					 result =  requete.executeQuery("SELECT COUNT(*) FROM config Where code=\"lc\"");
					 if(result.next() && result.getInt("COUNT(*)") >= 1)		 
					 return 1;
					 return 0;						 
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
					 return -1;	
				}
			   
			}
}
			
