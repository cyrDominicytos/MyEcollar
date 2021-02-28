package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public class StatistiqueModel  extends Connexion{

	private Statement requete=null;
	private ResultSet result=null;
	
	public StatistiqueModel() {
		super();
	}
	
	/********************************************************
	 * 
	 * selectApprenant liste des apprenants du systeme
	 * @return
	 * 
	 * 
	 ******************************************************/
	public int selectTotalGarconInscrit(String annee) {
		int rep = 0 ;
		try {
			connexionDB  = new Model.Connexion().connexionDB;
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT COUNT(*) FROM Apprenant A, INSCRIPTION I WHERE A.MATRICULE = I.APPRENANT AND I.ANNEESCOLAIRE = '"+annee+"' AND A.SEXE='M'");
			result.next();
			rep =  result.getInt("COUNT(*)");
			connexionDB.close();
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			
		}
		    return rep;
	}
	
	
	public int selectTotalFilleInscrit(String annee) {
		int rep = 0 ;
		try {
			connexionDB  = new Model.Connexion().connexionDB;
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT COUNT(*) FROM Apprenant A, INSCRIPTION I WHERE A.MATRICULE = I.APPRENANT AND I.ANNEESCOLAIRE = '"+annee+"' AND A.SEXE='F'");
			result.next();
			rep =  result.getInt("COUNT(*)"); 
			connexionDB.close();
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			
		}
		   return rep;
	}

	public int selectTotalInscrit(String annee) {
	
		int rep = 0 ;try {
			connexionDB  = new Model.Connexion().connexionDB;
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT COUNT(*) FROM INSCRIPTION I WHERE  I.ANNEESCOLAIRE = '"+annee+"'");
			result.next();
			rep =  result.getInt("COUNT(*)"); 
    		connexionDB.close();
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			
		}
		   return rep;
	} 
	
	public int selectTotalOphlin(String annee) {
		
		int rep = 0 ;try {
			connexionDB  = new Model.Connexion().connexionDB;
			requete = connexionDB.createStatement();
			result = requete.executeQuery("SELECT COUNT(*) FROM INSCRIPTION I, APPRENANT A  WHERE I.APPRENANT = A.MATRICULE AND A.CODEOPHELIN IS NOT NULL AND  I.ANNEESCOLAIRE = '"+annee+"'");
			result.next();
			rep =  result.getInt("COUNT(*)"); 
    		connexionDB.close();
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			
		}
		   return rep;
	} 
	   public int selectTotalMateriel(String annee) {
	    	
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM DEPENSE WHERE OBJET = 'Matériel didactique' AND ANNEESCOLAIRE = '"+annee+"'");
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    		
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalFourniture(String annee) {
	    	
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM DEPENSE WHERE OBJET = 'Fournitures scolaires' AND ANNEESCOLAIRE = '"+annee+"'");
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    		
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalSalaire(String annee) {
	    	
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM DEPENSE WHERE OBJET = 'Salaire' AND ANNEESCOLAIRE = '"+annee+"'");
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    		
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalAutre(String annee) {
	    	
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM DEPENSE WHERE OBJET NOT IN ('Salaire','Fournitures scolaires','Matériel didactique')AND ANNEESCOLAIRE = '"+annee+"'");
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)");
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    		
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalAllDepense(String annee) {
	    	
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM DEPENSE WHERE ANNEESCOLAIRE <= '"+annee+"'");
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalReduction(String annee) {
	    	
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM REDUCTION ");
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalDepense(String annee) { 	
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM DEPENSE WHERE ANNEESCOLAIRE = '"+annee+"'");
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   
	   public int selectSoldeAtteint(String annee) {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT COUNT(*) FROM SEUIL_PAYEMENT  WHERE ANNEESCOLAIRE = '"+annee+"' AND POURCENTAGE >= 100");			
	    		result.next();
	    		rep =  result.getInt("COUNT(*)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectSoldeNonAtteint(String annee) {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT COUNT(*) FROM SEUIL_PAYEMENT  WHERE ANNEESCOLAIRE = '"+annee+"' AND POURCENTAGE BETWEEN 1 AND 99.999");			
	    		result.next();
	    		rep =  result.getInt("COUNT(*)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectRienPayer(String annee) {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT COUNT(*) FROM SEUIL_PAYEMENT  WHERE ANNEESCOLAIRE = '"+annee+"' AND POURCENTAGE <=0");			
	    		result.next();
	    		rep =  result.getInt("COUNT(*)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalFrais(String annee) {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery(" SELECT FRAIS FROM FRAISSCOLARITE ");	
	    		result.next();
	    		rep =  result.getInt("FRAIS"); 
	    		rep *= this.selectTotalApprenantEAYANTPAYERFRAIS(annee);
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   
	   public int selectFrais() {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery(" SELECT FRAIS FROM FRAISSCOLARITE ");	
	    		result.next();
	    		rep =  result.getInt("FRAIS"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   public int selectTotalPayement(String annee) {
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM PAYEMENT  WHERE ANNEESCOLAIRE = '"+annee+"'");	
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    		rep -= selectTotalFrais(annee);
	    		connexionDB.close(); 
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalRD(String annee) {
	    	int rep = 0 ;try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(RESTANT_DU) FROM seuil_payement  WHERE ANNEESCOLAIRE = '"+annee+"'");	
	    		result.next();
	    		rep =  result.getInt("SUM(RESTANT_DU)"); 
	    		connexionDB.close(); 
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalApprenantEAYANTPAYERFRAIS(String annee) {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT COUNT(*) NUM FROM `total_payement` T WHERE ANNEESCOLAIRE = '"+annee+"' AND TOTAL_PAYE > 0");	
	    		result.next();
	    		rep =  result.getInt("NUM"); 
	    		
	    		connexionDB.close(); 
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	System.out.println(rep);
	    	   return rep;
	    }
	   
	   
	   public int selectTotalFrais() {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery(" SELECT FRAIS FROM FRAISSCOLARITE ");	
	    		result.next();
	    		rep =  result.getInt("FRAIS"); 
	    		rep *= this.selectTotalApprenantEAYANTPAYERFRAIS(new DonneeStatiques().anneeCourante);
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalAllPayement(String annee) {
	    	int rep = 0 ;
	    	try {
	    		connexionDB  = new Model.Connexion().connexionDB;
	    		requete = connexionDB.createStatement();
	    		result = requete.executeQuery("SELECT SUM(MONTANT) FROM PAYEMENT WHERE ANNEESCOLAIRE <= '"+annee+"'");	
	    		result.next();
	    		rep =  result.getInt("SUM(MONTANT)"); 
	    		connexionDB.close();
	    	} catch (SQLException e) {
	    		DonneeStatiques.messageDialog(e.getMessage(), 3);
	    	}
	    	   return rep;
	    }
	   
	   public int selectTotalRecette(String annee) {  		 
	    		return  this.selectTotalPayement(annee)  + this.selectTotalFrais(annee); 
	    }
	   public int selectResultatAnnee(String annee) {  		 
   		return ( this.selectTotalRecette(annee) - this.selectTotalDepense(annee)); 
   }
	   public int selectTotalAllRecette(String annee) {  		 
   		return  this.selectTotalAllPayement(annee); 
   }
	   
	   public int selectBilan(String annee) {  		 
	   		return  ((this.selectTotalAllPayement(annee)) - this.selectTotalAllDepense(annee)); 
	   }
	   
}

