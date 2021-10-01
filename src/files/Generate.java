package files;


import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Config;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Generate {

	private JFrame frame;
	private JTextField ipAddress;
	private JTextField macAddress;
	private JTextField secreCode;
	private JTextArea Licence;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generate window = new Generate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Generate() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Start Address
		//String motherBoard_SerialNumber = getSystemMotherBoard_SerialNumber();
       // System.out.println("MotherBoard Serial Number : "+motherBoard_SerialNumber);
		this.generateLicence();
		
		
		//end 
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JInternalFrame internalFrame = new JInternalFrame("Licence Generator");
		frame.getContentPane().add(internalFrame, BorderLayout.CENTER);
		internalFrame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;pref)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(19dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(19dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("IP Machine");
		internalFrame.getContentPane().add(lblNewLabel, "4, 4");
		
		ipAddress = new JTextField();
		ipAddress.setText(getIpAdresse());
		ipAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		internalFrame.getContentPane().add(ipAddress, "5, 4, 6, 1, fill, default");
		ipAddress.setColumns(10);
		
		JLabel lblMacMachine = new JLabel("MAC Machine");
		internalFrame.getContentPane().add(lblMacMachine, "4, 6");
		
		macAddress = new JTextField();
		//macAddress.setText(getMacAdresse());
		macAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		macAddress.setColumns(10);
		internalFrame.getContentPane().add(macAddress, "5, 6, 6, 1, fill, default");
		
		JLabel lblS = new JLabel("Secret Code");
		internalFrame.getContentPane().add(lblS, "4, 8");
		
		secreCode = new JTextField("VBXDD");
		secreCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		secreCode.setColumns(10);
		internalFrame.getContentPane().add(secreCode, "5, 8, 6, 1, fill, default");
		
		Licence = new JTextArea();
		internalFrame.getContentPane().add(Licence, "4, 10, 7, 1, fill, fill");
		
		panel = new JPanel();
		
		
		JButton btnGenerete = new JButton("Encrypt");
		btnGenerete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Licence.setText(encrypt(macAddress.getText(), secreCode.getText()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_1 = new JButton("Décrypt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Licence.setText(decrypt(encrypt(macAddress.getText(), secreCode.getText()), secreCode.getText()));
					System.out.println(decrypt(encrypt(macAddress.getText(), secreCode.getText()), secreCode.getText()).equalsIgnoreCase(macAddress.getText()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnGenerete);
		panel.add(btnNewButton_1);
		
		
		//frame.getContentPane().add(btnGenerete, BorderLayout.SOUTH);
		internalFrame.setVisible(true);
		System.out.println(checkIfHasLicence());
			
	}
	
	
	
	public static String lire(File myObj)    
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
	
	
	public static Boolean ecrire(File f, String code)    
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
 
	
	/* public String encrypt(String str)
	 {
		 String Newstr=" ";  
	        ;  
	        try {  
	    
	        for (int i=0;i<str.length();i++)  
	        {  
	            char ch=Character.toLowerCase(str.charAt(i));  
	            switch (ch)  
	            {  
	                case 'a':  
	                    Newstr=Newstr+"{";  
	                    break;  
	                case 'b':  
	                    Newstr=Newstr+"}";  
	                    break;  
	                case 'c':  
	                    Newstr=Newstr+"#";  
	                    break;  
	                case 'd':  
	                    Newstr=Newstr+"~";  
	                    break;  
	                case 'e':  
	                    Newstr=Newstr+"+";  
	                    break;  
	                case 'f':  
	                    Newstr=Newstr+"-";  
	                    break;  
	                case 'g':  
	                    Newstr=Newstr+"*";  
	                    break;  
	                case 'h':  
	                    Newstr=Newstr+"@";  
	                    break;  
	                case 'i':  
	                    Newstr=Newstr+"/";  
	                    break;  
	                case 'j':  
	                    Newstr=Newstr+"\\";  
	                    break;  
	                case 'k':  
	                    Newstr=Newstr+"?";  
	                    break;  
	                case 'l':  
	                    Newstr=Newstr+"$";  
	                    break;  
	                case 'm':  
	                    Newstr=Newstr+"!";  
	                    break;  
	                case 'n':  
	                    Newstr=Newstr+"^";  
	                    break;  
	                case 'o':  
	                    Newstr=Newstr+"(";  
	                    break;  
	                case 'p':  
	                    Newstr=Newstr+")";  
	                    break;  
	                case 'q':  
	                    Newstr=Newstr+"<";  
	                    break;  
	                case 'r':  
	                    Newstr=Newstr+">";  
	                    break;  
	                case 's' :  
	                    Newstr=Newstr+"=";  
	                    break;  
	                case 't':  
	                    Newstr=Newstr+";";  
	                    break;  
	                case 'u':  
	                    Newstr=Newstr+",";  
	                    break;  
	                case 'v' :  
	                    Newstr=Newstr+"_";  
	                    break;  
	                case 'w':  
	                    Newstr=Newstr+"[";  
	                    break;  
	                case 'x' :  
	                    Newstr=Newstr+"]";  
	                    break;  
	                case 'y':  
	                    Newstr=Newstr+":";  
	                    break;  
	                case 'z' :  
	                    Newstr=Newstr+"\"";  
	                    break;  
	                case ' ' :  
	                    Newstr=Newstr+" ";  
	                    break;  
	                case '.':  
	                    Newstr=Newstr+'3';  
	                    break;  
	                case ',':  
	                    Newstr=Newstr+"1";  
	                    break;  
	                case '(':  
	                    Newstr=Newstr+'4';  
	                    break;  
	                case '\"':  
	                    Newstr=Newstr+'5';  
	                    break;  
	                case ')' :  
	                    Newstr=Newstr+"7";  
	                    break;  
	                case '?' :  
	                    Newstr= Newstr+"2";  
	                    break;  
	                case '!':  
	                    Newstr= Newstr+"8";  
	                    break;  
	                case '-' :  
	                    Newstr= Newstr+"6";  
	                    break;  
	                case '%' :  
	                    Newstr = Newstr+"9";  
	                    break;  
	                case '1':  
	                    Newstr=Newstr+"r";  
	                    break;  
	                case '2':  
	                    Newstr=Newstr+"k";  
	                    break;  
	                case '3':  
	                    Newstr=Newstr+"b";  
	                    break;  
	                case '4':  
	                    Newstr = Newstr+"e";  
	                    break;  
	                case '5':  
	                    Newstr = Newstr+"q";  
	                    break;  
	                case '6':  
	                    Newstr = Newstr+"h";  
	                    break;  
	                case '7':  
	                    Newstr = Newstr+"u";  
	                    break;  
	                case '8' :  
	                    Newstr= Newstr+"y";  
	                    break;  
	                case '9':  
	                    Newstr = Newstr+"w";  
	                    break;  
	                case '0':  
	                    Newstr = Newstr+"z";  
	                    break;  
	                 default:  
	                    Newstr=Newstr+"0";  
	                    break;  
	            }  
	        }  
	        }  
	        catch(Exception ioe)  
	        {  
	            ioe.printStackTrace();  
	        }  
	        return Newstr;
	  }
	 
	 
	 public String decrypt(String str)
	 {
		 String Newstr=" ";  
	       
	        try
	        {    
	        for (int i=0;i<str.length();i++)  
	        {  
	            char ch=Character.toLowerCase(str.charAt(i));  
	            switch (ch)  
	            {  
	                case '{':  
	                    Newstr=Newstr+"A";  
	                    break;  
	                case '}':  
	                    Newstr=Newstr+"B";  
	                    break;  
	                case '#':  
	                    Newstr=Newstr+"C";  
	                    break;  
	                case '~':  
	                    Newstr=Newstr+"D";  
	                    break;  
	                case '+':  
	                    Newstr=Newstr+"E";  
	                    break;  
	                case '-':  
	                    Newstr=Newstr+"F";  
	                    break;  
	                case '*':  
	                    Newstr=Newstr+"G";  
	                    break;  
	                case '@':  
	                    Newstr=Newstr+"H";  
	                    break;  
	                case '/':  
	                    Newstr=Newstr+"I";  
	                    break;  
	                case '\\':  
	                    Newstr=Newstr+"J";  
	                    break;  
	                case '?':  
	                    Newstr=Newstr+"K";  
	                    break;  
	                case '$':  
	                    Newstr=Newstr+"L";  
	                    break;  
	                case '!':  
	                    Newstr=Newstr+"M";  
	                    break;  
	                case '^':  
	                    Newstr=Newstr+"N";  
	                    break;  
	                case '(':  
	                    Newstr=Newstr+"O";  
	                    break;  
	                case ')':  
	                    Newstr=Newstr+"P";  
	                    break;  
	                case '<':  
	                    Newstr=Newstr+"Q";  
	                    break;  
	                case '>':  
	                    Newstr=Newstr+"R";  
	                    break;  
	                case '=' :  
	                    Newstr=Newstr+"S";  
	                    break;  
	                case ';':  
	                    Newstr=Newstr+"T";  
	                    break;  
	                case ',':  
	                    Newstr=Newstr+"U";  
	                    break;  
	                case '_' :  
	                    Newstr=Newstr+"V";  
	                    break;  
	                case '[':  
	                    Newstr=Newstr+"W";  
	                    break;  
	                case ']' :  
	                    Newstr=Newstr+"X";  
	                    break;  
	                case ':':  
	                    Newstr=Newstr+"Y";  
	                    break;  
	                case '\"' :  
	                    Newstr=Newstr+"Z";  
	                    break;       
	                case '1':  
	                    Newstr=Newstr+"r";  
	                    break;  
	                case '2':  
	                    Newstr=Newstr+"k";  
	                    break;  
	                case '3':  
	                    Newstr=Newstr+"b";  
	                    break;  
	                case '4':  
	                    Newstr = Newstr+"e";  
	                    break;  
	                case '5':  
	                    Newstr = Newstr+"q";  
	                    break;  
	                case '6':  
	                    Newstr = Newstr+"h";  
	                    break;  
	                case '7':  
	                    Newstr = Newstr+"u";  
	                    break;  
	                case '8' :  
	                    Newstr= Newstr+"y";  
	                    break;  
	                case '9':  
	                    Newstr = Newstr+"w";  
	                    break;  
	                case '0':  
	                    Newstr = Newstr+"z";  
	                    break;  
	                 default:  
	                    Newstr=Newstr+"0";  
	                    break;  
	            }  
	        }  
	        }  
	        catch(Exception ioe)  
	        {  
	            ioe.printStackTrace();  
	        }  
	        return Newstr;
	  }*/

	/*public  String encrypt(String strClearText,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strClearText.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
	
	public  String decrypt(String strEncrypted,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
			strData=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}*/

	 public void generateLicence()    
	 {
		 //System.out.println(this.encrypt("Toto"));
		// System.out.println(decrypt(encrypt("Toto")));
	 }
	 
	 
	 
	
	 private static SecretKeySpec secretKey;
	 private static byte[] key;
	 
	 public static void setKey(String myKey) 
	    {
	        MessageDigest sha = null;
	        try {
	            key = myKey.getBytes("UTF-8");
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16); 
	            secretKey = new SecretKeySpec(key, "AES");
	        } 
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } 
	        catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    }
	 
		 public static String encrypt(String strToEncrypt, String secret) 
		    {
		        try
		        {
		            setKey(secret);
		            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		        } 
		        catch (Exception e) 
		        {
		            System.out.println("Error while encrypting: " + e.toString());
		        }
		        return null;
	    }
	 
	    public static String decrypt(String strToDecrypt, String secret) 
	    {
	        try
	        {
	            setKey(secret);
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while decrypting: " + e.toString());
	        }
	        return null;
	    }
	
	    
	    @SuppressWarnings("static-access")
		public static int checkIfHasLicence() 
	    {
	    	File f = new File("./config/conf.ini");
			if(!f.exists()) 
			{
				
				if(DonneeStatiques.hasLicence == 1)
				{
					//DB is already boot
					DonneeStatiques.erroCode = "C00x1";
					return 22;
					
				}else {
					//First booting
					 try
			         {
			            f.createNewFile();
			            //String mac = getMacAdresse();
			            String mac = "54-BE-F7-5A-FF-AD";
			            String now = DonneeStatiques.dbformat.format(new Date());
			            //String end = DonneeStatiques.dbformat.format(new Date());
			            String end = DonneeStatiques.dbformat2.format(new Date());
			    		String dt = LocalDate.now().plusDays(14).toString();
			    		end = dt+" "+end;
			           
			            String script = mac.concat("@").concat(now).concat("@").concat(end);
			            System.out.println(script);
			            String script1 = encrypt(script, DonneeStatiques.devise);
			            String script2 = encrypt(script1, DonneeStatiques.devise);
			            ecrire(f,script2);
			            System.out.println(script2);
			            new Config().insertLicence("lc",script2,now,  end);
			            DonneeStatiques.demo = "Vous etes en  mode Démo, cette version n'est accessible que pour 14 jours";
			            return 20;
			         } catch (Exception e)
					 {
			        	 DonneeStatiques.erroCode = "C00x1";
			        	 return 22;
			           // e.printStackTrace();
			         } 
					 
				}
				    
		      }else 
		      {
		    	  //User has licence
		    	  String str = lire(f);
		    	  String dscript = decrypt(decrypt(str, DonneeStatiques.devise), DonneeStatiques.devise);
		    	  String[] list = dscript.split("@");
		          ResultSet rs = new Config().selectConfig("lc");
		          String dbSecret = "";
		          String dbStart = "";
		          String dbend = "";
		          if(list.length==3)
		          {
		        	  try {
							while(rs.next()) 
							{
								dbSecret = rs.getString("str_value");
								dbStart = rs.getTimestamp("created_at").toString();
								dbend = rs.getTimestamp("updated_at").toString();
								if(dbend.length() > 19 ){
								    dbend = dbend.substring(0, 19);
								}
								if(dbStart.length() > 19 ){
									dbStart = dbend.substring(0, 19);
								}
								
							 }
							if(dscript.equals(decrypt(decrypt(dbSecret, DonneeStatiques.devise), DonneeStatiques.devise)) && list[2].equals(dbend))
							{
							  if(dbend.compareTo(DonneeStatiques.dbformat.format(new Date())) > 0) 
								{
									DonneeStatiques.demo = "Vous etes en  mode Démo, cette version n'est accessible que pour 14 jours";
									return 20;
								}
								
								if (dbend.compareTo(DonneeStatiques.dbformat.format(new Date())) <= 0) 
								{
									return 21;
								}
								 
							}else {
								/*System.out.println(dscript.equals(decrypt(decrypt(dbSecret, DonneeStatiques.devise), DonneeStatiques.devise)));
								System.out.println(dbend.equals(list[2]));
								System.out.println(dbend);
								System.out.println(list[2]);
								System.out.println(dscript+" "+decrypt(decrypt(dbSecret, DonneeStatiques.devise), DonneeStatiques.devise));*/
								  DonneeStatiques.erroCode = "C00x2";
								  return 22;
							}
							 
						}catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	  DonneeStatiques.erroCode = "C00x3";
		        	  return 22;
		          }else {
		        	  DonneeStatiques.erroCode = "C00x4";
		        	  return 22;
		          }
		         
		      } 
	    	
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
				NetworkInterface nif = NetworkInterface.getByName("lo");
			    byte[] bytes = nif.getHardwareAddress();

			    //assertNotNull(bytes);
			
				InetAddress localHost = InetAddress.getLocalHost();
				NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
				byte[] hardwareAddress = ni.getHardwareAddress();
				//assertNotNull(bytes);
				String[] hexadecimal = new String[hardwareAddress.length];
				for (int i = 0; i < hardwareAddress.length; i++) {
				    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
				}
				rs = String.join("-", hexadecimal);
				
				
				
				/*ip = InetAddress.getLocalHost();
				System.out.println("Current IP address : " + ip.getHostAddress());
				
				NetworkInterface network = NetworkInterface.getByInetAddress(ip);
				
				byte[] mac = network.getHardwareAddress();
				
					
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
				}
				rs = sb.toString();*/
				
				
				
				
				/*InetAddress localHost = InetAddress.getLocalHost();
				ip = localHost;
				NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
				byte[] hardwareAddress = ni.getHardwareAddress();
				
				String[] hexadecimal = new String[hardwareAddress.length];
				for (int i = 0; i < hardwareAddress.length; i++) {
				    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
				}
				String macAddress = String.join("-", hexadecimal);
				mac = macAddress;*/
					
			} catch (SocketException e){
					
				e.printStackTrace();
					
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        return rs;
	    }
	    
	   /* public static String getBiosAdresse() 
	    {
	        
	    }*/
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	 
	 
	 public static String getSystemMotherBoard_SerialNumber(){
	        try{
	            String OSName=  System.getProperty("os.name");
	            if(OSName.contains("Windows")){
	            	System.out.println("Windows");
	                return (getWindowsMotherboard_SerialNumber());
	            }
	            else{
	            	 System.out.println("Linux");
	                 return (GetLinuxMotherBoard_serialNumber());
	            }
	        }
	        catch(Exception E){
	            System.err.println("System MotherBoard Exp : "+E.getMessage());
	            return null;
	        }
	    }
	 
	 
	    /**
	     * Method for get Linux Machine MotherBoard Serial Number
	     * @return 
	     */
	    private static String GetLinuxMotherBoard_serialNumber()
	    {
	    	// command to be executed on the terminal
	        String command
	            = "sudo dmidecode -s baseboard-serial-number";
	  
	        // variable to store the Serial Number
	        String serialNumber = null;
	  
	        // try block
	        try {
	  
	            // declaring the process to run the command
	            Process SerialNumberProcess
	                = Runtime.getRuntime().exec(command);
	  
	            // getting the input stream using
	            // InputStreamReader using Serial Number Process
	            InputStreamReader ISR = new InputStreamReader(
	                SerialNumberProcess.getInputStream());
	  
	            // declaring the Buffered Reader
	            BufferedReader br = new BufferedReader(ISR);
	  
	            // reading the serial number using
	            // Buffered Reader
	            serialNumber = br.readLine().trim();
	  
	            // waiting for the system to return
	            // the serial number
	            SerialNumberProcess.waitFor();
	  
	            // closing the Buffered Reader
	            br.close();
	        }
	  
	        // catch block
	        catch (Exception e) {
	  
	            // printing the exception
	            e.printStackTrace();
	  
	            // giving the serial number the value null
	            serialNumber = null;
	        }
	  
	        // returning the serial number
	        return serialNumber;
	    }
	    
	/*
	 @SuppressWarnings("resource")
	public char crypter(String code)    
	 	{
			try{
					int ctr;
					//V
					File f = new File("./config/conf.ini");
					if(!f.exists()) {
				         try {
				            f.createNewFile();
				         } catch (Exception e) {
				            e.printStackTrace();
				         }        
				      } 				  
					   
						FileInputStream inputStream = new FileInputStream("./config/conf.ini");
						FileOutputStream outputStream = new FileOutputStream("./config/ConfigOut.txt");
						while ((ctr = inputStream.read()) != -1) {
							ctr -= 3; // 3 is the encryption key .
							System.out.print((char) ctr);
							outputStream.write(ctr);
						}
						outputStream.close();
					
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			    	
	 		}
	 
	 */
	 
	 /**
	     * Method for get Windows Machine MotherBoard Serial Number
	     * @return 
	     */
	    private static String getWindowsMotherboard_SerialNumber() {
	        // command to be executed on the terminal
	        String command = "wmic bios get serialnumber";
	  
	        // variable to store the Serial Number
	        String serialNumber = null;
	  
	        // try block
	        try {
	  
	            // declaring the process to run the command
	            Process SerialNumberProcess
	                = Runtime.getRuntime().exec(command);
	  
	            // getting the input stream using
	            // InputStreamReader using Serial Number Process
	            InputStreamReader ISR = new InputStreamReader(
	                SerialNumberProcess.getInputStream());
	  
	            // declaring the Buffered Reader
	            BufferedReader br = new BufferedReader(ISR);
	  
	            // reading the serial number using
	            // Buffered Reader
	            System.out.println(br);
	            serialNumber = br.readLine().trim();
	            serialNumber = br.readLine().trim();
	            System.out.println(serialNumber);
	            // waiting for the system to return
	            // the serial number
	            SerialNumberProcess.waitFor();
	  
	            // closing the Buffered Reader
	            br.close();
	        }
	  
	        // catch block
	        catch (Exception e) {
	  
	            // printing the exception
	            e.printStackTrace();
	  
	            // giving the serial number the value null
	            serialNumber = null;
	        }
	  
	        // returning the serial number
	        return serialNumber;
	    } 
	    
	    
		
}
