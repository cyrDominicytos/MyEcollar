/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Alissou
 */
public class DataBaseConnect {
    
    Connection con = null;
    Statement st = null;
    
    // Methode de gestion de connection � la base de donn�es
    public final Statement connection(){
        try
        {
            Class.forName ("oracle.jdbc.driver.OracleDriver");
            //System.out.println("Pilote charger avec succ�s!!!");
            try{
                 //Connection � la  base de donn�es
                con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:BD","ROOT","Oracle125");
                //System.out.println("Connexion avec la base "+con.getMetaData().getDatabaseProductName()+" �tablie");
                st = con.createStatement();
            }
            catch(Exception e)
            {
            	System.err.println("Erreur de chargement du driver : " + e.getMessage()) ;
            }
        } 
        catch(Exception e)
        {
            System.err.println("Erreur " + e.getMessage());
        }
        return st;
    }
    
    // fermeture de la base
    public final void Deconnection(){
        try
        {
            //con.close();
            //System.out.println("Base ProjetJava ferm�e");
        }
        catch (Exception e){
        	
        }
    }

    
}
