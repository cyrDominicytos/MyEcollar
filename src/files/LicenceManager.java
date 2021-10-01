package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JPanel;

public class LicenceManager extends JPanel {

	/**
	 * Create the panel.
	 */
	public LicenceManager() {

	}

	 public static String getIpAdresse() 
	    {
	    	
	    	try {
				return InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return null;
	    }
	    
	    public static String getMacAdresse() 
	    {
	    	InetAddress ip = null;
			String rs = "";
			try {
					
				
				InetAddress localHost = InetAddress.getLocalHost();
				NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
				byte[] hardwareAddress = ni.getHardwareAddress();
				String[] hexadecimal = new String[hardwareAddress.length];
				for (int i = 0; i < hardwareAddress.length; i++) {
				    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
				}
				rs = String.join("-", hexadecimal);
				
			} catch (SocketException e){
					
				e.printStackTrace();
					
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        return rs;
	    }
	    
	public String lire(File myObj)    
 	{
		String  data="";
		try {
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        data = data.concat(myReader.nextLine());
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return data;		
 	}
	
	
	public Boolean ecrire(File f, String code)    
 	{
		
		 try {
	         File dir = new File(f.getParentFile(), f.getName());
	         PrintWriter pWriter = new PrintWriter(dir);
	         pWriter.print(code);
	         pWriter.close();
	         return true;
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      }
		return false;	
 	}
 
	
}
