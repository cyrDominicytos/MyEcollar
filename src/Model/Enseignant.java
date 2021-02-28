package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class Enseignant  extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public Enseignant() {
		super();
	}
	
	/********************************************************
	 * 
	 * selectEnseignant liste des Enseignants du systeme
	 * @return
	 * 
	 * 
	 ******************************************************/
	public ResultSet selectEnseignant() {
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT TELEPHONE, CONCAT(NOM, ' ',PRENOM) AS NOM_PRENOM, SEXE, ADRESSE, ESENSEIGNANT FROM ENSEIGNANT");
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	
	
	public ResultSet selectEnseignant(String contact) {
		contact = DonneeStatiques.scarpe(contact);
		
		try {
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT *  FROM ENSEIGNANT WHERE TELEPHONE = '"+contact+"'");
			
			return result; 
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
		}
		    return result;
	}
	

	/****************************************************************************
	 * 
	 * insertEnseignant des annees Scolaire du systeme
	 * @param dateDebut
	 * @param dateFin
	 * @param annee
	 * 
	 * 
	 ***************************************************************************/
			public int insertEnseignant(String telephone, String nom, String prenom,String sexe,String adresse, Boolean esEnseignant) {
				telephone = DonneeStatiques.scarpe(telephone);
				nom = DonneeStatiques.scarpe(nom);
				prenom = DonneeStatiques.scarpe(prenom);
				adresse = DonneeStatiques.scarpe(adresse);
				int reponse = 0;
				switch (this.EnseignantExiste(telephone)) {
				case 1:
					JOptionPane.showMessageDialog(null, "Un Personnel possède déjà le téléphone  "+telephone+"\nL'Enseignant "+prenom+" "+nom+" est soit déjà inscrit.");
					break;
				case 0:
					try {
						 requete = connexionDB.createStatement();
						if(esEnseignant)
						 {
							 reponse =  requete.executeUpdate("INSERT INTO ENSEIGNANT(TELEPHONE,NOM,PRENOM,SEXE,ADRESSE, ESENSEIGNANT) VALUES('"+telephone+"','"+nom+"','"+prenom+"','"+sexe+"','"+adresse+"', 'OUI')");
							 DonneeStatiques.messageDialog("L'Enseignant "+ nom+" "+prenom+" a été bien enregistré dans la base!",0);
							 this.updateReduction(telephone); 
						 }else {
							 reponse =  requete.executeUpdate("INSERT INTO ENSEIGNANT(TELEPHONE,NOM,PRENOM,SEXE,ADRESSE, ESENSEIGNANT) VALUES('"+telephone+"','"+nom+"','"+prenom+"','"+sexe+"','"+adresse+"', 'NON')");
							 DonneeStatiques.messageDialog("Le Personnel "+ nom+" "+prenom+" a été bien enregistré dans la base!",0);
						 }
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Une erreur inattandue s'est produite durant l'enregistrement\nde l'Enseignant "+prenom+" "+nom+" \n veuillez réessayer l'opération !");
					break;
				}
				return reponse;
			}
			
			public int updateEnseignant(String contact,String nom, String prenom,String sexe,String adresse, Boolean esEnseignant, String ancienContact) {
				contact = DonneeStatiques.scarpe(contact);
				nom = DonneeStatiques.scarpe(nom);
				prenom = DonneeStatiques.scarpe(prenom);
				adresse = DonneeStatiques.scarpe(adresse);
				ancienContact = DonneeStatiques.scarpe(ancienContact);
				int reponse = 0;
					try {
						 requete = connexionDB.createStatement();
						 if(esEnseignant)
						 {
							 reponse =  requete.executeUpdate("UPDATE  ENSEIGNANT  SET TELEPHONE = '"+contact+"', NOM ='"+nom+"', PRENOM = '"+prenom+"',  SEXE = '"+sexe+"',ADRESSE = '"+adresse+"', ESENSEIGNANT='OUI' WHERE TELEPHONE = '"+ancienContact+"'");
							 DonneeStatiques.messageDialog("Les informations de l'enseignant "+nom+" "+prenom+" ont été bien modifiées dans la base!", 0);		 
						 }else {
							 reponse =  requete.executeUpdate("UPDATE  ENSEIGNANT  SET TELEPHONE = '"+contact+"', NOM ='"+nom+"', PRENOM = '"+prenom+"',  SEXE = '"+sexe+"',ADRESSE = '"+adresse+"', ESENSEIGNANT='NON' WHERE TELEPHONE = '"+ancienContact+"'");
							 DonneeStatiques.messageDialog("Les informations du Personnel "+nom+" "+prenom+" ont été bien modifiées dans la base!", 0);		 
						 }
					} catch (SQLException e) {
						DonneeStatiques.messageDialog(e.getMessage(), 3);
					}
				return reponse;
			}
			public int EnseignantExiste(String telephone) {
				
				try {
					 requete = connexionDB.createStatement();
					 result =  requete.executeQuery("SELECT COUNT(*) FROM Enseignant WHERE TELEPHONE = '"+telephone+"'");
					
					 if(result.next() && result.getInt("COUNT(*)") == 1)
					 return 1;
					 return 0;
				} catch (SQLException e) {
					DonneeStatiques.messageDialog(e.getMessage(), 3);
					 return -1;	
				}
			   
			}
			
			
         public void updateReduction(String contactTuteur) {
					try {
						 requete = connexionDB.createStatement();
						 result =  requete.executeQuery("SELECT MATRICULE FROM APPRENANT WHERE CONTACT = '"+contactTuteur+"'");
						 ResultSet ScolarResult;
						 while(result.next())
						 {
							int matricule = result.getInt("MATRICULE");
							ScolarResult =   requete.executeQuery("SELECT MONTANT FROM SCOLARITE WHERE ANNEESCOLAIRE = '"+new DonneeStatiques().anneeCourante+"' AND CLASSE = (SELECT CLASSE FROM INSCRIPTION WHERE APPRENANT = "+matricule+"  AND  ANNEESCOLAIRE = '"+new DonneeStatiques().anneeCourante+"') ");
							if(ScolarResult.next())
							{
								int scolar = ScolarResult.getInt("MONTANT");
								if(scolar > 0)
								requete.executeUpdate("UPDATE REDUCTION SET MONTANT = "+(ScolarResult.getInt("MONTANT")/2)+" WHERE APPRENANT = "+matricule+" AND ANNEESCOLAIRE = '"+new DonneeStatiques().anneeCourante+"'");
							}
						 } 
					} catch (SQLException e) {
						
					}
			}
		
}
