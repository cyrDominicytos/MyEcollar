package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Apprenant  extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Apprenant() {
		super();
	}
	
	/********************************************************
	 * 
	 * selectApprenant liste des apprenants du systeme
	 * @return
	 * 
	 * 
	 ******************************************************/
	public ResultSet selectApprenant() {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT Matricule, CONCAT(NOM, ' ',PRENOM) AS NOM_PRENOM, Sexe, Contact FROM Apprenant");
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			
		}
		    return result;
	}
	
public ResultSet selectApprenantInfos(int matricule) {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT * FROM Apprenant WHERE MATRICULE = "+matricule+"");
			//this.Deconnection();
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
public ResultSet selectApprenantRecu(int matricule, String classe, String annee) {
	
	try {
		requete = connexionDB.createStatement();
		result = requete.executeQuery("SELECT Matricule, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, Sexe, Contact FROM Apprenant A, INSCRIPTION I WHERE A.MATRICULE =I.APPRENANT AND I.ANNEESCOLAIRE='"+annee+"' AND I.CLASSE='"+classe+"' AND A.MATRICULE = "+matricule+"");
		return result; 
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
	}
	    return result;
}
public ResultSet selectApprenant(String classe, String annee) {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT Matricule, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, Sexe, Contact FROM Apprenant A, INSCRIPTION I WHERE A.MATRICULE =I.APPRENANT AND I.ANNEESCOLAIRE='"+annee+"' AND I.CLASSE='"+classe+"'");
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
public ResultSet selectApprenant(String classe, String annee, Boolean ophelin) {
	
	try {
		requete = connexionDB.createStatement();
		if(ophelin)
			result = requete.executeQuery("SELECT Matricule, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, Sexe, Contact, 	CODEOPHELIN FROM Apprenant A, INSCRIPTION I WHERE A.MATRICULE =I.APPRENANT AND I.ANNEESCOLAIRE='"+annee+"' AND I.CLASSE='"+classe+"' AND A.CODEOPHELIN IS NOT NULL");
		else
			result = requete.executeQuery("SELECT Matricule, CONCAT(NOM,' ',PRENOM) AS NOM_PRENOM, Sexe, Contact FROM Apprenant A, INSCRIPTION I WHERE A.MATRICULE =I.APPRENANT AND I.ANNEESCOLAIRE='"+annee+"' AND I.CLASSE='"+classe+"' AND A.CODEOPHELIN IS NULL"); 
		//this.Deconnection();
	} catch (SQLException e) {
		DonneeStatiques.messageDialog(e.getMessage(), 3);
	}
	    return result;
}
			
	public ResultSet selectApprenantInfos() {
					
					try {
						requete = connexionDB.createStatement();
						result = requete.executeQuery("SELECT * FROM Apprenant");
						//this.Deconnection();
						return result; 
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
					    return result;
			}
	
	/****************************************************************************
	 * 
	 * insertApprenant des annees Scolaire du systeme
	 * @param dateDebut
	 * @param dateFin
	 * @param annee
	 * 
	 * 
	 ***************************************************************************/
			public int insertApprenant(String nom, String prenom,String sexe,String contactTuteur,String adresse, String classe, String ophelinCode, int frais) {
				prenom = DonneeStatiques.scarpe(prenom);
				nom = DonneeStatiques.scarpe(nom);
				contactTuteur = DonneeStatiques.scarpe(contactTuteur);
				adresse = DonneeStatiques.scarpe(adresse);
				ophelinCode = DonneeStatiques.scarpe(ophelinCode);
				
				int reponse = 0;
				if(!this.ApprenantNPExiste(nom, prenom))
				{
					try {
						 requete = connexionDB.createStatement();
						 reponse =  requete.executeUpdate("INSERT INTO APPRENANT(NOM,PRENOM,SEXE,CONTACT,ADRESSE, CODEOPHELIN) VALUES('"+nom+"','"+prenom+"','"+sexe+"','"+contactTuteur+"','"+adresse+"', '"+ophelinCode+"')");
						 DonneeStatiques.messageDialog("L'apprenant "+nom+" "+prenom+" a été bien enregistré dans la base!", 0);
						 
						 int matricule = MaxMatricule();
						 frais = (frais > 0) ? (frais) : (0);
						 new Inscription().insertInscription(matricule, classe, frais);
						 
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
				}else {
					int choix = JOptionPane.showConfirmDialog(null, "Information!!\n\n "
							+ "Il est possible que vous ayez déjà inscrit cet apprenant."
							+ "\nUn apprenant du système possède exactement le même nom "+nom+" "
							+ "\net le même prenom "+prenom+" Si vous êtes certains qu'il s'agit de "
							+ "\ndeux apprenants différents ayant le même nom et prénom, cliquez sur"
							+ "\n OUI sinon,  cliquez sur ANNULER");
					if(choix == 0)
					{
						try {
							 requete = connexionDB.createStatement();
							 reponse =  requete.executeUpdate("INSERT INTO APPRENANT(NOM,PRENOM,SEXE,CONTACT,ADRESSE, CODEOPHELIN) VALUES('"+nom+"','"+prenom+"','"+sexe+"','"+contactTuteur+"','"+adresse+"', '"+ophelinCode+"')");
							 DonneeStatiques.messageDialog("L'apprenant "+nom+" "+prenom+" a été bien enregistré dans la base!", 0);
							 
							 int matricule = MaxMatricule();
							 frais = (frais > 0) ? (frais) : (0);
							 new Inscription().insertInscription(matricule, classe, frais);
							 
						} catch (SQLException e) {
							DonneeStatiques.messageDialog(e.getMessage(), 3);
						}
					}
				}
					
				return reponse;
			}
			
			
			public int insertApprenant(String nom, String prenom,String sexe,String contactTuteur,String adresse, String classe,  int frais) {
				frais = (frais > 0) ? (frais) : (0);
				int scolarite = new Scolarite().selectScolariteClasseAnnee(new DonneeStatiques().anneeCourante, classe);
				int reponse = 0;
				if( scolarite < frais)
				{
					DonneeStatiques.messageDialog("Vous ne pouvez pas renseigner un frais superieur a la scolarite de la classe.\nLa scolarite de la classe : "+classe+" est de "+scolarite, 2);
				}else {
					prenom = DonneeStatiques.scarpe(prenom);
					nom = DonneeStatiques.scarpe(nom);
					contactTuteur = DonneeStatiques.scarpe(contactTuteur);
					adresse = DonneeStatiques.scarpe(adresse);
					
						if(!this.ApprenantNPExiste(nom, prenom))
						{
							try {
								 requete = connexionDB.createStatement();
								 reponse =  requete.executeUpdate("INSERT INTO APPRENANT(NOM,PRENOM,SEXE,CONTACT,ADRESSE) VALUES('"+nom+"','"+prenom+"','"+sexe+"','"+contactTuteur+"','"+adresse+"')");
								 DonneeStatiques.messageDialog("L'apprenant "+nom+" "+prenom+" a été bien enregistré dans la base!", 0);
								 new Inscription().insertInscription(MaxMatricule(), classe, frais);
								 
							} catch (SQLException e) {
								DonneeStatiques.messageDialog(e.getMessage(), 3);
							}
						}else {
							int choix = JOptionPane.showConfirmDialog(null, "Information!!\n\n "
									+ "Il est possible que vous ayez déjà inscrit cet apprenant."
									+ "\nUn apprenant du système possède exactement le même nom "+nom+" "
									+ "\net le même prenom "+prenom+" Si vous êtes certains qu'il s'agit de "
									+ "\ndeux apprenants différents ayant le même nom et prénom, cliquez sur"
									+ "\n OUI sinon,  cliquez sur ANNULER");
							if(choix == 0)
							{
								try {
									
									 requete = connexionDB.createStatement();
									 reponse =  requete.executeUpdate("INSERT INTO APPRENANT(NOM,PRENOM,SEXE,CONTACT,ADRESSE) VALUES('"+nom+"','"+prenom+"','"+sexe+"','"+contactTuteur+"','"+adresse+"')");
									 DonneeStatiques.messageDialog("L'apprenant "+nom+" "+prenom+" a été bien enregistré dans la base!", 0);
									 new Inscription().insertInscription(MaxMatricule(), classe, frais);
									 
								} catch (SQLException e) {
									DonneeStatiques.messageDialog(e.getMessage(), 3);
								}
							}
						}
				}
				return reponse;
			}
			
			public int updateApprenant(int matricule, String nom, String prenom,String sexe,String contactTuteur,String adresse, String ophelinCode) {
				
				prenom = DonneeStatiques.scarpe(prenom);
				nom = DonneeStatiques.scarpe(nom);
				contactTuteur = DonneeStatiques.scarpe(contactTuteur);
				adresse = DonneeStatiques.scarpe(adresse);
				ophelinCode = DonneeStatiques.scarpe(ophelinCode);
				int reponse = 0;
					try {
						 requete = connexionDB.createStatement();
						 reponse =  requete.executeUpdate("UPDATE  APPRENANT SET NOM ='"+nom+"', PRENOM = '"+prenom+"',  SEXE = '"+sexe+"', CONTACT = '"+contactTuteur+"',ADRESSE = '"+adresse+"',CODEOPHELIN= '"+ophelinCode+"' WHERE MATRICULE = "+matricule+"");
						 DonneeStatiques.messageDialog("Les informations de l'apprenant "+nom+" "+prenom+" ont été bien modifiées dans la base!", 0);		
						 
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
				return reponse;
			}
			public int updateApprenant(int matricule, String nom, String prenom,String sexe,String contactTuteur,String adresse) {
					int reponse = 0;
					try {
						 requete = connexionDB.createStatement();
						 reponse =  requete.executeUpdate("UPDATE  APPRENANT SET NOM ='"+nom+"', PRENOM = '"+prenom+"',  SEXE = '"+sexe+"', CONTACT = '"+contactTuteur+"',ADRESSE = '"+adresse+"' WHERE MATRICULE = "+matricule+"");
						 DonneeStatiques.messageDialog("Les informations de l'apprenant "+nom+" "+prenom+" ont été bien modifiées dans la base!", 0);
						
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
				return reponse;
			}
			public int ApprenantExiste(int matricule) {
				try {
					 requete = connexionDB.createStatement();
					 result =  requete.executeQuery("SELECT COUNT(*) FROM Apprenant WHERE MATRICULE = "+matricule+"");
					
					 if(result.next() && result.getInt("COUNT(*)") == 1)
					 return 1;
					 return 0;
						 
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
					 return -1;	
				}
			   
			}
			
			public Boolean ApprenantNPExiste(String nom, String prenom) {
				try {
					 requete = connexionDB.createStatement();
					 result =  requete.executeQuery("SELECT COUNT(*) FROM Apprenant WHERE NOM = '"+nom+"' AND  PRENOM = '"+prenom+"' ");
					
					 if(result.next() && result.getInt("COUNT(*)") >= 1)
					 return true;
					 return false;
						 
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
					 return false;	
				}
			   
			}
			public int MaxMatricule() {
				try {
					 requete = connexionDB.createStatement();
					 result =  requete.executeQuery("SELECT MAX(MATRICULE) AS MATRICULE FROM Apprenant");
					
					 if(result.next())
					 
					 return result.getInt("MATRICULE");
					 return 0;
						 
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
					 return -1;	
				}
			   
			}
}
