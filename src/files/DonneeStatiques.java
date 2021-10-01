package files;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;

import Model.AnneeScolaire;
import Model.Apprenant;
import Model.Classe;
import Model.Config;
import Model.Depense;
import Model.DonneeConnexion;
import Model.Enseignant;
import Model.Payement;
import Model.SeuilDePayement;
import Model.StatistiqueModel;
@SuppressWarnings({ "unused", "serial" })
public class DonneeStatiques extends JPanel {
	
	@SuppressWarnings("rawtypes")
	//public DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = null;
	
	public static String db = "ECOLARBDD";
	public static String appName = "Ecollar 2.0";
	public static String devise = "Avec ecollar faites le vite faites le bien";
	public static String demo = null;
	public static String support = "ecollar.contact@gmail.com";
	private static ResultSet result = null;
	public  String anneeCourante = new AnneeScolaire().selectCurrentAnneeScolaire();
	
	static  ArrayList<Integer> matriculeListe, matriculeReinscription, matriculePourValiderInscription, matriculeListePaiement, matriculeListeEleves;
	public static  ArrayList<String> telephoneListe, dbListe ; 
	public static  ArrayList<String> anneeScolaireArray = new ArrayList<String>(); 
	public static SimpleDateFormat f=new SimpleDateFormat( "dd/MM/yyyy", Locale.FRANCE); 
	public static SimpleDateFormat f2=new SimpleDateFormat( "yyyy/MM/dd", Locale.FRANCE); 
	public static SimpleDateFormat f3=new SimpleDateFormat( "yyyy-MM-dd", Locale.FRANCE); 
	public static SimpleDateFormat dbformat=new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss", Locale.FRANCE); 
	public static SimpleDateFormat dbformat2=new SimpleDateFormat( "HH:mm:ss"); 
	public static SimpleDateFormat recupererAnnee=new SimpleDateFormat( "yyyy", Locale.FRANCE); 
	public static String nomEcole = new DonneeConnexion().selectNomCurrentSchool();
	public static String pwdEcole = new DonneeConnexion().selectPWDCurrentSchool();
	public static String finAnnee = new AnneeScolaire().selectCurrentDateFinAnneeScolaire();
	public static int isBoot = new Config().ProgramsIsBoot();
	public static int hasLicence = new Config().ProgramsHasLicence();
	public static int countLigneAffichee = 0, db_index =0, frais;
	public static String erroCode = "";
	
	public void refresh()
	{
		nomEcole = new DonneeConnexion().selectNomCurrentSchool();
		finAnnee = new AnneeScolaire().selectCurrentDateFinAnneeScolaire();
		anneeCourante = new AnneeScolaire().selectCurrentAnneeScolaire();
		frais = new StatistiqueModel().selectFrais();
		
		try {
			AnneeScolaire anneeScolaire = new AnneeScolaire();
			result = anneeScolaire.selectAnneeScolaire();
			while (result.next()) 
			{	
				anneeScolaireArray.add(result.getString("ANNEESCOLAIRE"));
			}
			anneeScolaire.Deconnection();
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public DonneeStatiques() 
	{
		refresh();
		
	}
	
	

	/***************************************************** 
	 * 
	 * Gestion des annees scolaires
	 * @return
	 * 
	 *****************************************************/
	
	public static javax.swing.table.DefaultTableModel listeAnneeScolaire() {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Désignation");
		 modelTable.addColumn("Date Début");
		 modelTable.addColumn("Date Fin");
		try {
			AnneeScolaire anneeScolair = new AnneeScolaire();
			//anneeScolaire = new AnneeScolaire();
			result = anneeScolair.selectAnneeScolaire();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while (result.next()) {				
				modelTable.addRow(new Object[]{ result.getObject("ANNEESCOLAIRE"), result.getObject("DATEDEBUT"), result.getObject("DATEFIN")});	
				
			}
			anneeScolair.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	
		return modelTable;
	}
	
	
	/******************************************************
	 * Page de de reinscription
	 * @return
	 * 
	 * 
	 ****************************************************/
	@SuppressWarnings("static-access")
	public static DefaultComboBoxModel<String> nomPrenomApprenantReinscription(String classe) {
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = null;
		matriculeReinscription = new ArrayList<Integer>();
		AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		try {
			Model.Inscription inscription = new Model.Inscription();
			result = inscription.selectApprenantAInscritParAnnee(classe, (new DonneeStatiques().anneeScolaireArray.size() > 1 ? new DonneeStatiques().anneeScolaireArray.get(1) :  new DonneeStatiques().anneeScolaireArray.get(0) ));
			while (result.next()) {
				
				AnneeScolaireComboBoxModel.addElement(result.getString("NOM_PRENOM"));
				matriculeReinscription.add(result.getInt("MATRICULE"));
			}
			inscription.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return AnneeScolaireComboBoxModel;
	}
	
	
	public static DefaultComboBoxModel<String> NomPrenomDesInscriptionNonValider(String classe) {
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		matriculePourValiderInscription = new ArrayList<Integer>();
		
		try {
			Model.Inscription inscription = new Model.Inscription();
			result = inscription.selectNomPrenomDesInscriptionNonValider(classe, new DonneeStatiques().anneeCourante);
			while (result.next()) 
			{
				AnneeScolaireComboBoxModel.addElement(result.getString("NOM_PRENOM"));
				matriculePourValiderInscription.add(result.getInt("MATRICULE"));
			}
			inscription.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return AnneeScolaireComboBoxModel;
	}
	public static DefaultComboBoxModel<String> anneeScolaire() {
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();;
		AnneeScolaire anneeScolaire = new AnneeScolaire();
		try {
			result = anneeScolaire.selectAnneeScolaire();
			while (result.next()) {
				
				AnneeScolaireComboBoxModel.addElement(result.getString("ANNEESCOLAIRE"));
			}
			//anneeScolaire.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		//anneeScolaire.Deconnection();
		return AnneeScolaireComboBoxModel;
	}
	
	public static DefaultComboBoxModel<String> nomPrenomApprenant(String classe, String annee) {
		
		
		matriculeListe = new ArrayList<Integer>();
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		try {
			Model.Inscription inscription = new Model.Inscription();
			result = inscription.selectApprenantInscritParAnnee(classe, annee);
			while (result.next()) {
				AnneeScolaireComboBoxModel.addElement(result.getString("NOM_PRENOM"));
				matriculeListe.add(result.getInt("MATRICULE"));
			}
			//inscription.Deconnection();;
		} catch
		(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return AnneeScolaireComboBoxModel;
	}
	

	public static DefaultComboBoxModel<String> nomPrenomApprenantListe(String classe, String annee) {
		
		Apprenant apprenant = new Apprenant();
		Model.Inscription inscription = new Model.Inscription();
		matriculeListe = new ArrayList<Integer>();
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		try {
			result = inscription.selectApprenantInscritParAnnee(classe, annee);
			AnneeScolaireComboBoxModel.addElement("TOUS");
			while (result.next()) {
				AnneeScolaireComboBoxModel.addElement(result.getString("NOM_PRENOM"));
				matriculeListe.add(result.getInt("MATRICULE"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		apprenant.Deconnection();
		return AnneeScolaireComboBoxModel;
	}
	public static DefaultComboBoxModel<String> classeNiveau() {
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		Classe classe = new Classe();
		try {
			result = classe.selectClasse();
			while (result.next()) {	
				AnneeScolaireComboBoxModel.addElement(result.getString("CLASSEGROUPE"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		classe.Deconnection();
		return AnneeScolaireComboBoxModel;
	}
	
	
	/***************************************************** 
	 * 
	 * Gestion des apprenants
	 * @return
	 * 
	 *****************************************************/
	
	public static javax.swing.table.DefaultTableModel listeApprenant() {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Matricules");
		 modelTable.addColumn("Nom et pr\u00E9nom (s)");
		 modelTable.addColumn("Sexe");
		 modelTable.addColumn("Contact tuteur");
		 //modelTable.addColumn("Actions");
  
		 Apprenant apprenant = new Apprenant();
		try {
			result = apprenant.selectApprenant();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while (result.next()) {				
				modelTable.addRow(new Object[]{ result.getObject("MATRICULE"), result.getObject("NOM_PRENOM"), result.getObject("SEXE"), result.getString("CONTACT")});	
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		apprenant.Deconnection();
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listeApprenant(String annee, String classe) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Matricules");
		 modelTable.addColumn("Nom et pr\u00E9nom (s)");
		 modelTable.addColumn("Sexe");
		 modelTable.addColumn("Contact tuteur");
		 //modelTable.addColumn("Actions");
 
		 Apprenant apprenant = new Apprenant();
		try {
			result = apprenant.selectApprenant(classe, annee);
			matriculeListeEleves = new ArrayList<Integer>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while (result.next()) {				
				modelTable.addRow(new Object[]{ result.getObject("MATRICULE"), result.getObject("NOM_PRENOM"), result.getObject("SEXE"), result.getString("CONTACT")});
				matriculeListeEleves.add(result.getInt("MATRICULE"));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		apprenant.Deconnection();
		return modelTable;
	}
		
	public static javax.swing.table.DefaultTableModel listeApprenant(String annee, String classe, Boolean ophelin) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 
		 modelTable.addColumn("Matricules");
		 modelTable.addColumn("Nom et pr\u00E9nom (s)");
		 if(ophelin)
		 modelTable.addColumn("CODEOPHELIN");
		 modelTable.addColumn("Sexe");
		 modelTable.addColumn("Contact tuteur");
		 //modelTable.addColumn("Actions");
		 
		 Apprenant apprenant = new Apprenant();
		try {
			result = apprenant.selectApprenant(classe, annee, ophelin);
			matriculeListeEleves = new ArrayList<Integer>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			if(ophelin) {
				while (result.next()) {				
					modelTable.addRow(new Object[]{ result.getObject("MATRICULE"), result.getObject("NOM_PRENOM"), result.getObject("CODEOPHELIN"),result.getObject("SEXE"), result.getString("CONTACT")});
					matriculeListeEleves.add(result.getInt("MATRICULE"));
				}
			}else {
				while (result.next()) {				
					modelTable.addRow(new Object[]{ result.getObject("MATRICULE"), result.getObject("NOM_PRENOM"),result.getObject("SEXE"), result.getString("CONTACT")});
					matriculeListeEleves.add(result.getInt("MATRICULE"));
				}
			}
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		apprenant.Deconnection();
		return modelTable;
	}
	
	
	public static javax.swing.table.DefaultTableModel listeApprenant( int matricule,String annee, String classe) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Matricules");
		 modelTable.addColumn("Nom et pr\u00E9nom (s)");
		 modelTable.addColumn("Sexe");
		 modelTable.addColumn("Contact tuteur");
		 //modelTable.addColumn("Actions");

		 Apprenant apprenant = new Apprenant();
		try {
			result = apprenant.selectApprenantRecu(matricule, classe, annee);
			matriculeListeEleves = new ArrayList<Integer>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while (result.next()) {				
				modelTable.addRow(new Object[]{ result.getObject("MATRICULE"), result.getObject("NOM_PRENOM"), result.getObject("SEXE"), result.getString("CONTACT")});
				matriculeListeEleves.add(result.getInt("MATRICULE"));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		apprenant.Deconnection();
		return modelTable;
	}
	
	/******************************************************
	 * Gestion des classes
	 * @param classe
	 * @param annee
	 * @return
	 ******************************************************/
	public static javax.swing.table.DefaultTableModel listeClasse(String annee) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 
		 modelTable.addColumn("Classe");
		// modelTable.addColumn("Année de création");
		 modelTable.addColumn("Nombre Inscrit(s)");
		 modelTable.addColumn("Scolarite");
		 //modelTable.addColumn("Actions");
		 

		try {
			Classe classe = new Classe();
			result = classe.selectClasseListe( annee);
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while (result.next()) {	
				modelTable.addRow(new Object[]{ result.getString("CLASSE"), result.getString("NOMBRE"), result.getString("MONTANT")});
			}
			classe.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return modelTable;
	}
		
	/******************************************************
	 * Paiement Scolarite
	 * @param classe
	 * @param annee
	 * @return
	 ******************************************************/
	public static javax.swing.table.DefaultTableModel listePaiement(String classe, String annee) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Nom et prénom(s)");
		 modelTable.addColumn("Montant");
		 //modelTable.addColumn("Actions");
		try {
			Payement payement = new Payement();
			result = payement.selectPayement(annee, classe);
			matriculeListePaiement = new ArrayList<>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{ result.getObject("DATEPAYEMENT"), result.getObject("NOM_PRENOM"), result.getObject("MONTANT")});
				matriculeListePaiement.add(result.getInt("MATRICULE"));
			}
			//payement.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listePaiement(String classe, String annee, int apprenant) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Nom et prénom(s)");
		 modelTable.addColumn("Montant");
		 //modelTable.addColumn("Actions");
		try {
			Payement payement = new Payement();
			result = payement.selectPayement(annee, classe, apprenant);
			matriculeListePaiement = new ArrayList<>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				matriculeListePaiement.add(result.getInt("MATRICULE"));
				modelTable.addRow(new Object[]{ result.getObject("DATEPAYEMENT"), result.getObject("NOM_PRENOM"), result.getObject("MONTANT")});
			}
			payement.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			
			return modelTable;
		}
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listePaiement(String classe, String annee, String date) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Nom et prénom(s)");
		 modelTable.addColumn("Montant");
		 //modelTable.addColumn("Actions");
		try {
			Payement payement = new Payement();
			result = payement.selectPayement(annee, classe, date);
			matriculeListePaiement = new ArrayList<>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				matriculeListePaiement.add(result.getInt("MATRICULE"));
				modelTable.addRow(new Object[]{ result.getObject("DATEPAYEMENT"), result.getObject("NOM_PRENOM"), result.getObject("MONTANT")});				
			}
			payement.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listePaiement(String classe, String annee, String date, int apprenant) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Nom et prénom(s)");
		 modelTable.addColumn("Montant");
		 //modelTable.addColumn("Actions");
		try {
			Payement payement = new Payement();
			result = payement.selectPayement(annee, classe, apprenant, date);
			matriculeListePaiement = new ArrayList<>();result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			
			while(result.next()) 
			{				
				matriculeListePaiement.add(result.getInt("MATRICULE"));
				modelTable.addRow(new Object[]{ result.getObject("DATEPAYEMENT"), result.getObject("NOM_PRENOM"), result.getObject("MONTANT")});				
			}
			payement.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static DefaultComboBoxModel<String> nomApprenants() {
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = null;
		Apprenant apprenant = new Apprenant();
		AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		try {
			result = apprenant.selectApprenant();
			while (result.next()) {	
				AnneeScolaireComboBoxModel.addElement(result.getString("NOM_PRENOM"));
			}
			apprenant.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return AnneeScolaireComboBoxModel;
	}
	
	
	/******************************************************
	 * Page des seuils de paiement
	 * @return
	 * 
	 * 
	 ****************************************************/
	public static javax.swing.table.DefaultTableModel listeEnseignant() {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Nom et prénom(s)");
		 modelTable.addColumn("Contact");
		 modelTable.addColumn("Enseignant");
		 modelTable.addColumn("Sexe");
		 modelTable.addColumn("Adresse");
		 //modelTable.addColumn("Actions");
		try {
			Enseignant enseignant = new Enseignant();
			result = enseignant.selectEnseignant();
			telephoneListe = new ArrayList<>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{ result.getObject("NOM_PRENOM"), result.getObject("TELEPHONE"),result.getObject("ESENSEIGNANT"),result.getObject("SEXE"),result.getObject("ADRESSE")});
				telephoneListe.add(result.getString("TELEPHONE"));
			}
			enseignant.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static DefaultComboBoxModel<String> nomPrenomEnseignant() {
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = null;
		
		AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		try {
			Enseignant enseignant = new Enseignant();
			result = enseignant.selectEnseignant();
			telephoneListe = new ArrayList<>();
			while (result.next()) {	
				AnneeScolaireComboBoxModel.addElement(result.getString("NOM_PRENOM"));
				telephoneListe.add(result.getString("TELEPHONE"));
			}
			enseignant.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return AnneeScolaireComboBoxModel;
	}	
	
	/******************************************************
	 * Page des Depenses
	 * @return
	 * 
	 * 
	 ****************************************************/
	public static javax.swing.table.DefaultTableModel listeDepenses(String annee) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Objet"); 
		 modelTable.addColumn("Montant");
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Description");
		 //modelTable.addColumn("Actions");
		try {
			Depense  depense = new Depense();
			result = depense.selectDepense(annee);
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{ result.getObject("OBJET"),result.getObject("MONTANT"),result.getObject("DATEDEPENSE"), result.getObject("DESCRIPTION")});
				//telephoneListe.add(result.getInt("TELEPHONE"));
			}
			depense.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listeDepensesObjet(String objet, String annee) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 
		 modelTable.addColumn("Montant");
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Description");
		 //modelTable.addColumn("Actions");
		try {
			Depense  depense = new Depense();
			result = depense.selectDepenseSuivantObjet(objet, annee);
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{result.getObject("MONTANT"),result.getObject("DATEDEPENSE"), result.getObject("DESCRIPTION")});
				
			}
			depense.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listeDepensesObjetAutre(String annee) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Objet");
		 modelTable.addColumn("Montant");
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Description");
		 ////modelTable.addColumn("Actions");
		try {
			Depense  depense = new Depense();
			result = depense.selectDepenseSuivantObjetAutre( annee);
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{result.getObject("OBJET"),result.getObject("MONTANT"),result.getObject("DATEDEPENSE"), result.getObject("DESCRIPTION")});
			}
			depense.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listeDepensesSalaire(String annee) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Nom et Prenom(s)");
		 modelTable.addColumn("Montant");
		 modelTable.addColumn("Date");
		 modelTable.addColumn("Description");
		 //modelTable.addColumn("Actions");
		try {
			Depense  depense = new Depense();
			result = depense.selectDepenseSalaire( annee);
			telephoneListe = new ArrayList<>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{ result.getObject("NOM_PRENOM"), result.getObject("MONTANT"),result.getObject("DATEDEPENSE"), result.getObject("DESCRIPTION")});
				telephoneListe.add(result.getString("ENSEIGNANT"));
			}
			depense.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	/******************************************************
	 * Page des seuils de paiement
	 * @return
	 * 
	 * 
	 ****************************************************/
	public static javax.swing.table.DefaultTableModel listeSeuilPaiementTous(String classe, String annee, String condition) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();

		 modelTable.addColumn("Nom et prénom(s)");
		 modelTable.addColumn("TOTAL PAYE");
		 modelTable.addColumn("RESTANT DU");
		 modelTable.addColumn("REDUCTION OBTENUE");
		 modelTable.addColumn("POURCENTAGE ATTEINT");
		try {
			 Model.SeuilDePayement seuilPaiement = new SeuilDePayement();
			result = seuilPaiement.selectSeuilDePayement(annee, classe, condition);
			matriculeListePaiement = new ArrayList<>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{ result.getObject("NOM_PRENOM"), result.getObject("TOTAL_PAYE"), result.getObject("RESTANT_DU"), result.getObject("REDUCTION"), result.getObject("POURCENTAGE")});
				matriculeListePaiement.add(result.getInt("MATRICULE"));
			}
			seuilPaiement.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	public static javax.swing.table.DefaultTableModel listeSeuilPaiementApprenant(String classe, String annee, int apprenant, String condition) {
		 javax.swing.table.DefaultTableModel modelTable = new javax.swing.table.DefaultTableModel();
		 modelTable.addColumn("Nom et prénom(s)");
		 modelTable.addColumn("TOTAL PAYE");
		 modelTable.addColumn("RESTANT DU");
		 modelTable.addColumn("REDUCTION OBTENUE");
		 modelTable.addColumn("POURCENTAGE ATTEINT");
		 //modelTable.addColumn("Actions");
		try {
			Model.SeuilDePayement seuilPaiement = new SeuilDePayement();
			result = seuilPaiement.selectSeuilDePayement(annee, classe,apprenant, condition);
			matriculeListePaiement = new ArrayList<>();
			result.last();
			countLigneAffichee = result.getRow();
			result.beforeFirst();
			while(result.next()) 
			{				
				modelTable.addRow(new Object[]{ result.getObject("NOM_PRENOM"), result.getObject("TOTAL_PAYE"), result.getObject("RESTANT_DU"), result.getObject("REDUCTION"),result.getObject("POURCENTAGE")});
				matriculeListePaiement.add(result.getInt("MATRICULE"));
				
			}
			seuilPaiement.Deconnection();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			return modelTable;
		}
		return modelTable;
	}
	
	/******************************************************
	 * 
	 * Impression de document
	 * @param pane
	 * 
	 *****************************************************/
	public  void imprimerDocument(JComponent pane) {
		Properties props = new Properties();
		 
	    props.put("awt.print.paperSize", "a4");
	    props.put("awt.print.destination", "printer");

	     
	    PrintJob pJob = getToolkit().getPrintJob(new Frame(),"Liste des apprenants", props);
	    if (pJob != null)
	      {
	        Graphics pg = pJob.getGraphics();
	        pane.printAll(pg);
	        pg.dispose();
	        pJob.end();
	      }
	
      } 
	
	public  void imprimerDocument(JComponent pane, String titre, Frame frame) {
		Properties props = new Properties();
		 
	    props.put("awt.print.paperSize", "a4");
	    props.put("awt.print.destination", "printer");

	     
	    PrintJob pJob = getToolkit().getPrintJob(frame,titre, props);
	    if (pJob != null)
	      {
	        Graphics pg = pJob.getGraphics();
	        pane.printAll(pg);
	        pg.dispose();
	        pJob.end();
	      }
	
      } 
	
	
	public static void imprimerDocumentPro(JTable table, String titre, String bas)
	{
		PrintMode printMode = PrintMode.FIT_WIDTH;
		MessageFormat title = new MessageFormat(titre);
		MessageFormat footer = new MessageFormat(bas);
		try {
			table.print(printMode, title, footer);
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      } 
	
	
	public static  void messageDialog(String mess, int type) {
		switch (type) {
		case 0:
			Success succes =  new Success();
			succes.message.setText(mess);
			succes.setLocationRelativeTo(null);
			succes.show();
			break;
		case 1:
			Infos info =  new Infos();
			info.message.setText(mess);
			info.setLocationRelativeTo(null);
			info.show();		
			break;
		case 2:
			Warnning warnning =  new Warnning();
			warnning.message.setText(mess);
			warnning.setLocationRelativeTo(null);
			warnning.show();
			break;
		case 3:
			Critical critical =  new Critical();
			critical.message.setText(mess);
			critical.setLocationRelativeTo(null);
			critical.show();
			break;

		default:
			break;
		}
	
      } 
	
	public static  String scarpe(String mot) {
		return mot.replaceAll("'", "\\\\'");
	
      } 
	
	public static DefaultComboBoxModel<String> dbList() {
		DefaultComboBoxModel<String> AnneeScolaireComboBoxModel = null;
		dbListe = new ArrayList<String>();
		AnneeScolaireComboBoxModel = new DefaultComboBoxModel<String>();
		try {
			Model.Ecole ecole = new Model.Ecole();
			result = ecole.selectEcole();
			while (result.next()) {
				
				AnneeScolaireComboBoxModel.addElement(result.getString("nom"));
				dbListe.add(result.getString("db"));
			}
			ecole.Deconnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return AnneeScolaireComboBoxModel;
	}
	
	
	
}
