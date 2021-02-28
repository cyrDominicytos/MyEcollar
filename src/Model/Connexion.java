package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import files.DonneeStatiques;

public  class Connexion {

	Connection connexionDB = null;
    Statement st = null;
    
    public Connexion() {
    	 try
         {
 	       Class.forName ("com.mysql.jdbc.Driver");  
 	        try{ 
 	        	//System.out.println( DonneeStatiques.db);
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
   
    public final void Deconnection(){
        // fermeture de la base
        try
        {	
        	connexionDB.close();
        } catch (Exception e){
        	DonneeStatiques.messageDialog("Erreur de Deconnexion\n\n La deconnexion à la base de données a echoué.\n\n"+e.getMessage(), 3);
	           
        }
    }

    
}
