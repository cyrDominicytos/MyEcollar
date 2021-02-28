package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import files.DonneeStatiques;

public class Maintenance  {

	private Statement requete=null;
	private ResultSet result=null;
	Connection connexionDB = null;
	public Maintenance() {
		
		this.connecterBDD();
		try {
			requete = connexionDB.createStatement();
			//result = requete.executeQuery("SELECT Matricule FROM Apprenant");
			//while (result.next()) {
			for(int i=2; i<=134; i++)
			{
				requete.executeUpdate("INSERT INTO `reduction`(`APPRENANT`, `ANNEESCOLAIRE`, `MONTANT`) VALUES ("+i+",'2019-2020',"+0+")");
				
			}
			//}
			
		} catch (SQLException e) {
			DonneeStatiques.messageDialog(e.getMessage(), 3);
			
		}
	}

public void connecterBDD()
{
try {
	Class.forName ("com.mysql.jdbc.Driver");  
        try{     
        	//connexionDB=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1539:ECOLARBDD","SYSTEM","Ecolarbdd1221");
        	connexionDB=DriverManager.getConnection("jdbc:mysql://localhost/"+DonneeStatiques.db,"root","");
       }
        catch(Exception e)
        {	
        	DonneeStatiques.messageDialog("Erreur de connexion\n\n Veuillez bien demarrer le serveur de base de donnees avant de lancer l'appliccation.\n\n", 3);
           
        }
        
     
 } catch (Exception e)
 {  
	 DonneeStatiques.messageDialog("Erreur de connexion : \n\n Le pilote n'a pas put etre charger.\n\n"+e.getMessage(), 2);
   
 }
}
	public static void main(String[] args) {
		new Maintenance();
	}
	
	
	
}
