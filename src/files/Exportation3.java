package files;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Exportation3 {

	public static void main(String[] args) {
	
    	
    	
    	
		/*JFileChooser directoryChoose = new JFileChooser();
		FileNameExtensionFilter imagesFilter = new FileNameExtensionFilter("Fichier sql", "sql");
		directoryChoose.setDialogTitle("Choisissez le fichier de base de données");
		directoryChoose.setAcceptAllFileFilterUsed(false);
		directoryChoose.addChoosableFileFilter(imagesFilter);
		directoryChoose.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ret = directoryChoose.showOpenDialog(null); // ne te rend la main que si tu ferme
        if(ret == JFileChooser.APPROVE_OPTION) 
        { // validation

        	
        	System.out.println(directoryChoose);
        } 	*/
		
		System.out.println(searchForGoodDirectory());

	}
	
	public static Boolean searchForDirectory (String directory)
	{
		File dossier=new File(directory);
    	if (dossier.exists() && dossier.isDirectory())
    		return true;
    	else 
    		return false;
	}
	
	
	public static Boolean searchForFile (String file)
	{
		File dossier=new File(file);
    	if (dossier.exists() && dossier.isFile())
    		return true;
    	else 
    		return false;
    	
	}
	
	public static String searchForGoodDirectory()
	{
		if(searchForDirectory("C:\\wamp64\\bin\\mysql"))
		{
			return "C:\\\\wamp64\\\\bin\\\\mysql";
		}else if(searchForDirectory("C:\\wamp32\\bin\\mysql"))
		{
			return "C:\\\\wamp32\\\\bin\\\\mysql";
		}else if(searchForDirectory("C:\\wamp\\bin\\mysql"))
		{
			return "C:\\\\wamp\\\\bin\\\\mysql";
		}else {
			return "";
		}
		
	}
		
}
