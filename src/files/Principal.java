package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/*import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Model.DonneeConnexion;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class Principal extends JFrame {


	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	public  JComboBox anneeStatistique;
	public JInternalFrame internalFrame;
	public JPanel panel;
	public JLabel label;
	//private DataBaseConnect connect;
	//private ResultSet resultat;
	JScrollPane scrollPaneDroit;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public Principal(){
		
		
		setLocale(new Locale("fr", "BJ"));
		setMinimumSize(new Dimension(800, 740));
		setPreferredSize(getToolkit().getScreenSize());
		setSize(getToolkit().getScreenSize());
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icones/app1.png")));
		setTitle(DonneeStatiques.appName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1066, 708);
		
		JSplitPane splitPane = new JSplitPane();
		JButton btnAcceuil = new JButton("");
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		mnFichier.setMnemonic('F');
		menuBar.add(mnFichier);
		
		JMenuItem menuItemQuitter = new JMenuItem("Quitter      (Ctrl+Q)");
		menuItemQuitter.setBackground(new Color(255, 255, 255));
		menuItemQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reponse = JOptionPane.showConfirmDialog(null, "Etes-vous certain de vouloir quitter ? ");
				if(reponse == 0)
				System.exit(0);
			}
		});
		menuItemQuitter.setIcon(new ImageIcon(Principal.class.getResource("/icones/exit.png")));
		menuItemQuitter.setSelectedIcon(null);
		mnFichier.add(menuItemQuitter);
		
		JMenu mnOptions = new JMenu("Options");
		mnOptions.setMnemonic('O');
			
		menuBar.add(mnOptions);
		
		JMenuItem mntmRetounerLacceuil = new JMenuItem("Retouner à  l'acceuil");
		mntmRetounerLacceuil.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmRetounerLacceuil.setPreferredSize(new Dimension(250, 30));
		mntmRetounerLacceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new  Statistiques(anneeStatistique.getSelectedItem().toString()));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(false);
				anneeStatistique.setVisible(true);
			}
		});
		
		mntmRetounerLacceuil.setIcon(new ImageIcon(Principal.class.getResource("/icones/home_min.png")));
		mnOptions.add(mntmRetounerLacceuil);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(0, 5));
		mnOptions.add(separator_2);
		
		JMenuItem mnAjouterEleve = new JMenuItem("Nouvelle inscription");
		mnAjouterEleve.setFont(new Font("Georgia", Font.PLAIN, 15));
		mnAjouterEleve.setPreferredSize(new Dimension(250, 30));
		
		mnAjouterEleve.setIcon(new ImageIcon(Principal.class.getResource("/icones/student-registration.png")));
		mnOptions.add(mnAjouterEleve);
		
		JMenuItem mntmRinscription = new JMenuItem("Réinscription");
		mntmRinscription.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmRinscription.setPreferredSize(new Dimension(250, 30));
		
		mntmRinscription.setIcon(new ImageIcon(Principal.class.getResource("/icones/reinscrire_min.png")));
		mnOptions.add(mntmRinscription);
		
		JMenuItem mntmListerElves = new JMenuItem("Liste des élèves");
		mntmListerElves.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmListerElves.setPreferredSize(new Dimension(250, 30));
		
		mntmListerElves.setIcon(new ImageIcon(Principal.class.getResource("/icones/listeEleve.jpg")));
		mnOptions.add(mntmListerElves);
		
		mntmListerElves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListeEleve(Principal.this));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(0, 5));
		mnOptions.add(separator_1);
		
		JMenuItem mntmConsulSold = new JMenuItem("Seuil de paiement");
		mntmConsulSold.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmConsulSold.setPreferredSize(new Dimension(250, 30));
		
		mntmConsulSold.setIcon(new ImageIcon(Principal.class.getResource("/icones/verifier_soldes.png")));
		mnOptions.add(mntmConsulSold);
		
		mntmConsulSold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new SeuilDePaiement());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
			}
		});
		
		JMenuItem mntmAjouterPaie = new JMenuItem("Nouveau paiement");
		mntmAjouterPaie.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmAjouterPaie.setPreferredSize(new Dimension(250, 30));
		
		mntmAjouterPaie.setIcon(new ImageIcon(Principal.class.getResource("/icones/ic_coins_s.png")));
		mnOptions.add(mntmAjouterPaie);
		
		JMenuItem mntmListePaiements = new JMenuItem("Liste des paiements");
		mntmListePaiements.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmListePaiements.setPreferredSize(new Dimension(250, 30));
		
		mntmListePaiements.setIcon(new ImageIcon(Principal.class.getResource("/icones/list_paie.png")));
		mnOptions.add(mntmListePaiements);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setPreferredSize(new Dimension(0, 5));
		mnOptions.add(separator_3);
		
		JMenuItem mntmEnregistrerUneDpense = new JMenuItem("Enregistrer une dépense");
		mntmEnregistrerUneDpense.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmEnregistrerUneDpense.setPreferredSize(new Dimension(250, 30));
		
		mntmEnregistrerUneDpense.setIcon(new ImageIcon(Principal.class.getResource("/icones/depenses_min.jpg")));
		mnOptions.add(mntmEnregistrerUneDpense);
		
		JMenuItem mntmListeDesDpenses = new JMenuItem("Liste des dépenses");
		mntmListeDesDpenses.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmListeDesDpenses.setPreferredSize(new Dimension(250, 30));
		
		mntmListeDesDpenses.setIcon(new ImageIcon(Principal.class.getResource("/icones/list_depenses_min.jpg")));
		mnOptions.add(mntmListeDesDpenses);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 5));
		mnOptions.add(separator);
		
		JMenuItem mntmAjouterUnEnseignant = new JMenuItem("Ajouter un personnel");
		mntmAjouterUnEnseignant.setIcon(new ImageIcon(Principal.class.getResource("/icones/ensMin.png")));
		mntmAjouterUnEnseignant.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmAjouterUnEnseignant.setPreferredSize(new Dimension(250, 30));
		
		mnOptions.add(mntmAjouterUnEnseignant);
		
		JMenuItem mntmListeDesEnseignants = new JMenuItem("Liste des personnels");
		mntmListeDesEnseignants.setIcon(new ImageIcon(Principal.class.getResource("/icones/liste_EnseiMin.png")));
		mntmListeDesEnseignants.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmListeDesEnseignants.setPreferredSize(new Dimension(250, 30));
		mnOptions.add(mntmListeDesEnseignants);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setPreferredSize(new Dimension(0, 5));
		mnOptions.add(separator_5);
		
		JMenuItem mntmAjouterUneClasse = new JMenuItem("Ajouter une classe");
		mntmAjouterUneClasse.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmAjouterUneClasse.setPreferredSize(new Dimension(250, 30));
		mntmAjouterUneClasse.setIcon(new ImageIcon(Principal.class.getResource("/icones/minClass.png")));
		
		mnOptions.add(mntmAjouterUneClasse);
		
		JMenuItem mntmListerClasses = new JMenuItem("Liste des classes");
		mntmListerClasses.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmListerClasses.setPreferredSize(new Dimension(250, 30));
		
		mntmListerClasses.setIcon(new ImageIcon(Principal.class.getResource("/icones/class_min.png")));
		mnOptions.add(mntmListerClasses);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setPreferredSize(new Dimension(0, 5));
		mnOptions.add(separator_4);
		
		JMenuItem mntmNouvelleAnneScolaire = new JMenuItem("Nouvelle Année scolaire");
		mntmNouvelleAnneScolaire.setIcon(new ImageIcon(Principal.class.getResource("/icones/newYearMin.png")));
		
		mntmNouvelleAnneScolaire.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmNouvelleAnneScolaire.setPreferredSize(new Dimension(250, 30));
		mnOptions.add(mntmNouvelleAnneScolaire);
		
		JMenuItem mntmListeDesAnnes = new JMenuItem("Liste des années scolaires");
		
		mntmListeDesAnnes.setIcon(new ImageIcon(Principal.class.getResource("/icones/calmin.png")));
		mntmListeDesAnnes.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmListeDesAnnes.setPreferredSize(new Dimension(250, 30));
		mnOptions.add(mntmListeDesAnnes);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setPreferredSize(new Dimension(0, 5));
		mnOptions.add(separator_6);
		
		JMenuItem mntmInformationDeLcole = new JMenuItem("Information de l'école");
		mntmInformationDeLcole.setFont(new Font("Georgia", Font.PLAIN, 15));
		mntmInformationDeLcole.setPreferredSize(new Dimension(250, 30));
		
		mntmInformationDeLcole.setIcon(new ImageIcon(Principal.class.getResource("/icones/ecole.png")));
		mnOptions.add(mntmInformationDeLcole);
		
		mntmInformationDeLcole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new InfosEcole(Principal.this));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
			}
		});
		
		mntmListerClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListeClasse());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
			}
		});
		
		
		mntmAjouterUneClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new NouvelleClasse());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
			}
		});
		
		mntmListeDesEnseignants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListeEnseignant());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
			}
		});
		
		
		mntmAjouterUnEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new EnregistrerEnseignant());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
			}
		});
		
		JMenu mnTraitements = new JMenu("Traitements");
		menuBar.add(mnTraitements);
		
		JSeparator separator2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(0, 5));
		mnTraitements.add(separator2);
		
		
		JMenuItem mntmImporterBaseDe = new JMenuItem("Importer Base de donn\u00E9es");
		mntmImporterBaseDe.setIcon(new ImageIcon(Principal.class.getResource("/icones/import1.jfif")));
		mntmImporterBaseDe.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				
				int reponse = JOptionPane.showConfirmDialog(null, "Vous demandez à importer une nouvelle base de données.\nCelle-ci va remplacer celle qu'utilise l'application présentement.\nAssurez vous de choissir le bon fichier de sauvegarde.\n Etes-vous certain de vouloir importer une base pour remplacer la présente ? ");
				if(reponse == 0)
				{
					//Choix du fichier a importer
					JFileChooser directoryChoose = new JFileChooser();
					FileNameExtensionFilter imagesFilter = new FileNameExtensionFilter("Fichier sql", "sql");
					directoryChoose.setDialogTitle("Choisissez le fichier de sauvegarde de votre base de données");
					directoryChoose.setAcceptAllFileFilterUsed(false);
					directoryChoose.addChoosableFileFilter(imagesFilter);
					directoryChoose.setFileSelectionMode(JFileChooser.FILES_ONLY);
			        int ret = directoryChoose.showOpenDialog(null); // ne te rend la main que si tu ferme
			        if(ret == JFileChooser.APPROVE_OPTION) 
			        { 
			        	Runtime runtime = Runtime.getRuntime();
		        		try {
		        			String debutChemin = searchForGoodDirectory();
		        			String[] commande = { "cmd.exe", "/C", "cd "+debutChemin+"\\mysql*\\bin& mysql.exe  ecolarbdd -u root < \""+directoryChoose.getSelectedFile().toString()+"\""};
		        			final Process process = runtime.exec(commande);
							DonneeStatiques.messageDialog("L'importation de la base de données s'est bien déroulée." , 0);
						} catch (IOException e) {
							DonneeStatiques.messageDialog("Un probleme inattendu s'est produit lors de l'importation de la base de donnée.\nIl est possible que vous ayez choissi un fichier non compatable.\n"+e.getMessage() , 1);
					 	       
						}	
		          }
    	   }
		}
		});
		mntmImporterBaseDe.setPreferredSize(new Dimension(250, 30));
		mntmImporterBaseDe.setFont(new Font("Georgia", Font.PLAIN, 15));
		mnTraitements.add(mntmImporterBaseDe);
		
		JMenuItem mntmExporterBaseDe = new JMenuItem("Exporter Base de donn\u00E9es");
		mntmExporterBaseDe.setIcon(new ImageIcon(Principal.class.getResource("/icones/export1.jfif")));
		mntmExporterBaseDe.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser directoryChoose = new JFileChooser();
				directoryChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int ret = directoryChoose.showOpenDialog(null); // ne  rend la main que si on ferme
		        if(ret == JFileChooser.APPROVE_OPTION) { // validation
		        	Runtime runtime = Runtime.getRuntime();
		        		try {
		        			String debutChemin = searchForGoodDirectory();
		        			String[] commande = { "cmd.exe", "/C", "cd "+debutChemin+"\\mysql*\\bin& mysqldump.exe  ecolarbdd -u root > \""+directoryChoose.getSelectedFile().toString()+"\"\\ecolarbdd.sql"};
		        			final Process processusExport = runtime.exec(commande);
		        			DonneeStatiques.messageDialog("L'exportation de la base de données s'est bien déroulée.\n Vous verez le fichier dans le repertoire : "+directoryChoose.getSelectedFile().toString() , 0);
							processusExport.destroy();
						} catch (IOException e) {
							DonneeStatiques.messageDialog("Un probleme inattendu s'est produit lors de l'exportation de la base de donnée.\nVeuillez réessayé.\n"+e.getMessage() , 0);   
							 
						}
		        }
			}
		});
		mntmExporterBaseDe.setPreferredSize(new Dimension(250, 30));
		mntmExporterBaseDe.setFont(new Font("Georgia", Font.PLAIN, 15));
		mnTraitements.add(mntmExporterBaseDe);
		
		JMenuItem mntmChanger = new JMenuItem("Changer d'école");
		mntmChanger.setIcon(new ImageIcon(Principal.class.getResource("/icones/export1.jfif")));
		mntmChanger.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ChangerEcole(Principal.this));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		mntmChanger.setPreferredSize(new Dimension(250, 30));
		mntmChanger.setFont(new Font("Georgia", Font.PLAIN, 15));
		mnTraitements.add(mntmChanger);
		
		JMenuItem mntmConfig = new JMenuItem("Configuration");
		mntmConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new Configuration(Principal.this));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		mntmConfig.setPreferredSize(new Dimension(250, 30));
		mntmConfig.setFont(new Font("Georgia", Font.PLAIN, 15));
		mnTraitements.add(mntmConfig);
		
		
		
		JMenu mnAide = new JMenu("Aide");
		mnAide.setMnemonic('A');
		menuBar.add(mnAide);
		
		JMenuItem mntmAcivate = new JMenuItem("Activer le logiciel");
		mntmAcivate.setMnemonic(KeyEvent.VK_F2);
		//mntmAcivate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmAcivate.setIcon(new ImageIcon(Principal.class.getResource("/icones/checkmark_success_96.png")));
		mnAide.add(mntmAcivate);
		
		JMenuItem mntmhelp = new JMenuItem("Manuel utilisateur");
		
		mntmhelp.setIcon(new ImageIcon(Principal.class.getResource("/icones/manual.png")));
		mnAide.add(mntmhelp);
		
		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mntmAPropos.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				About about = new About();
				about.setLocationRelativeTo(null);
				about.show();
			}
		});
		mntmAPropos.setIcon(new ImageIcon(Principal.class.getResource("/icones/16x16_About.png")));
		mnAide.add(mntmAPropos);
		
		JMenuItem mntmFaireUnDon = new JMenuItem("Faire un don");
		
		mntmFaireUnDon.setIcon(new ImageIcon(Principal.class.getResource("/icones/don.png")));
		mnAide.add(mntmFaireUnDon);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		internalFrame = new JInternalFrame( DonneeStatiques.demo==null ? ("Année scolaire "+ new DonneeStatiques().anneeCourante) : (DonneeStatiques.demo) );
		System.out.println(DonneeStatiques.demo);
		internalFrame.setVisible(true);
		internalFrame.getContentPane().setBackground(new Color(255, 255, 255));
		contentPane.add(internalFrame, BorderLayout.CENTER);
		
		panel = new JPanel();
		internalFrame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		
		JButton btnAddPaie = new JButton("Nouveau Paiement");
		
		btnAddPaie.setPreferredSize(new Dimension(160, 40));
		panel_1.add(btnAddPaie);
		
		JButton btnSeuilPaiement = new JButton("Seuil de paiement");
		
		btnSeuilPaiement.setPreferredSize(new Dimension(150, 40));
		panel_1.add(btnSeuilPaiement);	
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		
		
		btnAcceuil.setToolTipText("Retourner aux statistiques");
		
		btnAcceuil.setIcon(new ImageIcon(Principal.class.getResource("/icones/home.png")));
		panel_2.add(btnAcceuil);
			
		label = new JLabel( new DonneeConnexion().selectNomCurrentSchool());
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Wide Latin", Font.PLAIN, 18));
		panel_2.add(label);
		
		
		splitPane.setDividerSize(5);
		internalFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
		splitPane.setAutoscrolls(true);		
		
	    scrollPaneDroit = new JScrollPane();
		splitPane.setRightComponent(scrollPaneDroit);
		NewYear newYear = new NewYear(Principal.this);
		newYear.setPreferredSize(new Dimension(600, 475));
		
		btnAcceuil.setEnabled(false);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		anneeStatistique = new JComboBox();
		anneeStatistique.setModel(new DonneeStatiques().anneeScolaire());
		anneeStatistique.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new Statistiques(anneeStatistique.getSelectedItem().toString()));
				btnAcceuil.setEnabled(false);
				Principal.this.scrollPaneDroit.revalidate();
			}
		});
		anneeStatistique.setBounds(17, 6, 166, 42);
		panel_3.add(anneeStatistique);
		scrollPaneDroit.setViewportView(new DonneeStatiques().anneeCourante == null ? newYear : new  Statistiques(anneeStatistique.getSelectedItem().toString()));
		
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new Statistiques(anneeStatistique.getSelectedItem().toString()));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(false);
				anneeStatistique.setVisible(true);
			}
		});
		
		btnAddPaie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new EnregistrerPaiement());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
				
			}
		});
		
		
		mntmAjouterPaie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new EnregistrerPaiement());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		btnSeuilPaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new SeuilDePaiement());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmListePaiements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListerPaiement());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
			
		});
		
		mnAjouterEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new Inscription());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmRinscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new Reinscription(Principal.this));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});

		
		mntmAjouterUneClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new NouvelleClasse());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmListerClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListeClasse());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmInformationDeLcole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new InfosEcole(Principal.this));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmEnregistrerUneDpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new AjouterDepense());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmListeDesDpenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListeDepenses());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		
		mntmAjouterUnEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new EnregistrerEnseignant());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmListeDesEnseignants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListeEnseignant());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmAcivate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Activate active = new Activate();
				active.setLocationRelativeTo(null);
				active.show();
			}
		});
		
		mntmhelp.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Sorry sorry = new Sorry();
				sorry.setLocationRelativeTo(null);
				sorry.show();
			}
		});
		
		mntmFaireUnDon.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Sorry sorry = new Sorry();
				sorry.setLocationRelativeTo(null);
				sorry.show();
			}
		});
		
		mntmNouvelleAnneScolaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new NewYear(Principal.this));
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		mntmListeDesAnnes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneDroit.removeAll();
				scrollPaneDroit = new JScrollPane();
				splitPane.setRightComponent(scrollPaneDroit);
				scrollPaneDroit.setViewportView(new ListeAnne());
				
				Principal.this.scrollPaneDroit.revalidate();
				btnAcceuil.setEnabled(true);
				anneeStatistique.setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(240, 76));
		scrollPane.setAutoscrolls(true);
		splitPane.setLeftComponent(scrollPane);
		
		JTree tree = new JTree();
		tree.setPreferredSize(new Dimension(140, 76));
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						String test = tree.getLastSelectedPathComponent().toString();
				if(node.isRoot()) {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new Statistiques(anneeStatistique.getSelectedItem().toString()));
				}else if(test == "Nouveau paiement") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new EnregistrerPaiement());
				}else if(test == "Liste des paiements") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new ListerPaiement());
				}else if(test == "Seuil de paiement") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new SeuilDePaiement());
				}else if(test == "Nouvelle Inscription") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new Inscription());
				}else if(test == "Réinscription") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new Reinscription(Principal.this));
				}else if(test == "Liste des élèves") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new ListeEleve(Principal.this));
				}else if(test == "Enregistrer une dépense") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new AjouterDepense());
				}else if(test == "Liste des dépenses") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new ListeDepenses());
				}else if(test == "Ajouter un personnel") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new EnregistrerEnseignant());
				}else if(test == "Liste des personnels") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new ListeEnseignant());
				}else if(test == "Ajouter une classe") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new NouvelleClasse());
				}else if(test == "Liste des classes") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new ListeClasse());
				}else if(test == "Informations de l'école") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new InfosEcole(Principal.this));
					
				}else if(test == "Nouvelle année scolaire") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new NewYear(Principal.this));
				}else if(test == "Liste des années scolaire") {
					scrollPaneDroit.removeAll();
					scrollPaneDroit = new JScrollPane();
					splitPane.setRightComponent(scrollPaneDroit);
					scrollPaneDroit.setViewportView(new ListeAnne());		
				}
				
				anneeStatistique.setVisible(false);
				btnAcceuil.setEnabled(true);
				Principal.this.scrollPaneDroit.revalidate();
				
			}
		});
		
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Menu") {
				{
					/*DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Scolarit\u00E9");
						node_1.add(new DefaultMutableTreeNode("Nouveau paiement"));
						node_1.add(new DefaultMutableTreeNode("Liste des paiements"));
						node_1.add(new DefaultMutableTreeNode("Seuil de paiement"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Apprenants");
						node_1.add(new DefaultMutableTreeNode("Nouvelle Inscription"));
						node_1.add(new DefaultMutableTreeNode("R\u00E9inscription"));
						node_1.add(new DefaultMutableTreeNode("Liste des \u00E9l\u00E8ves"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("D\u00E9penses");
						node_1.add(new DefaultMutableTreeNode("Enregistrer une d\u00E9pense"));
						node_1.add(new DefaultMutableTreeNode("Liste des d\u00E9penses"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Administrer");
						node_1.add(new DefaultMutableTreeNode("Ajouter un personnel"));
						node_1.add(new DefaultMutableTreeNode("Liste des personnels"));
						node_1.add(new DefaultMutableTreeNode("Ajouter une classe"));
						node_1.add(new DefaultMutableTreeNode("Liste des classes"));
						node_1.add(new DefaultMutableTreeNode("Nouvelle ann\u00E9e scolaire"));
						node_1.add(new DefaultMutableTreeNode("Liste des ann\u00E9es scolaire"));
						node_1.add(new DefaultMutableTreeNode("Informations de l'\u00E9cole"));
					add(node_1);*/
				}
			}
		));
		tree.setToggleClickCount(1);
		tree.setRowHeight(40);
		tree.setName("Menu\r\n");
		tree.setAutoscrolls(true);
		scrollPane.setViewportView(tree);
		
		if(new DonneeStatiques().anneeCourante == null)
		{
			mnOptions.setEnabled(false);
			tree.setEnabled(false);
			btnAddPaie.setEnabled(false);
			btnSeuilPaiement.setEnabled(false);
		}else {
			mnOptions.setEnabled(true);
			tree.setEnabled(true);
			btnAddPaie.setEnabled(true);
			btnSeuilPaiement.setEnabled(true);
		}
		
		this.setExtendedState(this.MAXIMIZED_BOTH);
		refreshAll();
	}
	
	public Boolean searchForDirectory (String directory)
	{
		File dossier=new File(directory);
    	if (dossier.exists() && dossier.isDirectory())
    		return true;
    	else 
    		return false;
	}
	
	
	public Boolean searchForFile (String file)
	{
		File dossier=new File(file);
    	if (dossier.exists() && dossier.isFile())
    		return true;
    	else 
    		return false;
    	
	}
	
	public String searchForGoodDirectory()
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
	
	public  void refreshAll()
	{
		new DonneeStatiques().refresh();
		anneeStatistique.setModel(new DonneeStatiques().anneeScolaire());
		label.setText(DonneeStatiques.nomEcole);
		internalFrame.setTitle( DonneeStatiques.demo==null ? ("Année scolaire "+ new DonneeStatiques().anneeCourante) : (DonneeStatiques.demo));
		
		Principal.this.panel.revalidate();
		Principal.this.internalFrame.revalidate();
		Principal.this.revalidate();
	}
}
