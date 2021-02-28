package files;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.AnneeScolaire;
import Model.Classe;
import Model.Scolarite;

import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;

public class NewYear extends JPanel {
	/**
	 * Create the panel.
	 */
	public static  String dateFin = DonneeStatiques.finAnnee;
	JTextField txtLibelleAnnee;
	JTextPane erreur;
	JDateChooser txtFinAnnee, txtDebutAnnee;
	private Principal parent;
	public NewYear(Principal parent) {
		this.parent = parent;
		dateFin = DonneeStatiques.finAnnee;
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNouvelleAnnueeScolaire = new JLabel("Créer une nouvelle année scolaire ");
		lblNouvelleAnnueeScolaire.setBackground(Color.WHITE);
		lblNouvelleAnnueeScolaire.setIcon(new ImageIcon(NewYear.class.getResource("/icones/newYear.png")));
		lblNouvelleAnnueeScolaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelleAnnueeScolaire.setForeground(new Color(30, 144, 255));
		lblNouvelleAnnueeScolaire.setFont(new Font("Century", Font.BOLD, 22));
		add(lblNouvelleAnnueeScolaire, BorderLayout.NORTH);
		
		JPanel panel0 = new JPanel();
		panel0.setBorder(null);
		panel0.setOpaque(false);
		panel0.setBackground(new Color(248, 248, 255));
		panel0.setBounds(238, 0, 609, 589);
		add(panel0, BorderLayout.CENTER);
		panel0.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("157px:grow"),
				ColumnSpec.decode("508px"),
				ColumnSpec.decode("max(84dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("398px:grow"),}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel0.add(panel_2, "1, 2, fill, fill");
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(248, 248, 255));
		panel0.add(panel, "2, 2, fill, fill");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(45, 51, 417, 283);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 4");
		
		JLabel lblAnneSolairee = new JLabel("Date de début :");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 6, left, fill");
		
		txtDebutAnnee = new JDateChooser();
		txtDebutAnnee.setDate(new Date());
		txtDebutAnnee.setDateFormatString("d/MM/yyyy");
		panel_1.add(txtDebutAnnee, "4, 6, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 8");
		
		JLabel lblClasse = new JLabel("Date de fin :");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 10, left, fill");
		
		txtFinAnnee = new JDateChooser();
		txtFinAnnee.setDate(new Date());
		txtFinAnnee.setDateFormatString("d/MM/yyyy");
		panel_1.add(txtFinAnnee, "4, 10, fill, fill");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 12");
		
		JLabel lblNomDeAnne = new JLabel("Désignation :");
		lblNomDeAnne.setForeground(new Color(30, 144, 255));
		lblNomDeAnne.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeAnne, "2, 14, left, fill");
		
		txtLibelleAnnee = new JTextField();
		txtLibelleAnnee.setEditable(false);
		panel_1.add(txtLibelleAnnee, "4, 14, 2, 1, fill, fill");
		
		JButton btnEnregistrerLePaiement = new JButton("  Enregistrer");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtLibelleAnnee.getText().isEmpty())
				{
					new AnneeScolaire().insertAnneeScolaire(DonneeStatiques.f2.format(txtDebutAnnee.getDate()), DonneeStatiques.f2.format(txtFinAnnee.getDate()), NewYear.this.anneeScolaire());
					miseAjourScolarite();
					NewYear.this.parent.refreshAll();
					/*int reponse = JOptionPane.showConfirmDialog(null, "Vous devez redémarrer l'application pour prendre en compte la nouvelle année scolaire.\n Souhaitez vous redémarrer en même temps ? ");
					if(reponse == 0)
					System.exit(0);*/
					
				}else {
					DonneeStatiques.messageDialog("L'année scolaire n'est pas valide. \nChoisissez une date debut et de fin  dont l'ecart donne au moins 8 mois et au plus 13 mois.", 1);
				}
				
			}
		});
		
		txtDebutAnnee.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
						if(verifierDate())
							txtLibelleAnnee.setText(NewYear.this.anneeScolaire());
						else
							txtLibelleAnnee.setText("");
	
					}
				});
		
		txtFinAnnee.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				if(verifierDate())
					txtLibelleAnnee.setText(NewYear.this.anneeScolaire());
				else
					txtLibelleAnnee.setText("");
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(154, 366, 198, 48);
		panel.add(btnEnregistrerLePaiement);
		
		erreur = new JTextPane();
		erreur.setText("Impossible de creer une nouvelle annee. L'annee "+new DonneeStatiques().anneeCourante+" est toujours ouverte.");
		erreur.setBackground(Color.WHITE);
		erreur.setForeground(Color.RED);
		erreur.setFont(new Font("Century", Font.BOLD, 14));
		erreur.setBounds(10, 0, 488, 64);
		erreur.setVisible(false);
		panel.add(erreur);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel0.add(panel_3, "3, 2, fill, fill");
		
		if(new DonneeStatiques().anneeCourante != null)
		if(DonneeStatiques.f3.format(new Date()).compareTo(dateFin) < 0)
		{
			erreur.setVisible(true);
			btnEnregistrerLePaiement.setEnabled(false);
			
		}
	}
	
	@SuppressWarnings("deprecation")
	public NewYear(String annee, String debut, String fin) {
		dateFin = DonneeStatiques.finAnnee;
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNouvelleAnnueeScolaire = new JLabel("Modifier l'année scolaire "+annee);
		lblNouvelleAnnueeScolaire.setBackground(Color.WHITE);
		lblNouvelleAnnueeScolaire.setIcon(new ImageIcon(NewYear.class.getResource("/icones/newYear.png")));
		lblNouvelleAnnueeScolaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelleAnnueeScolaire.setForeground(new Color(30, 144, 255));
		lblNouvelleAnnueeScolaire.setFont(new Font("Century", Font.BOLD, 22));
		add(lblNouvelleAnnueeScolaire, BorderLayout.NORTH);
		
		JPanel panel0 = new JPanel();
		panel0.setBorder(null);
		panel0.setOpaque(false);
		panel0.setBackground(new Color(248, 248, 255));
		panel0.setBounds(238, 0, 609, 589);
		add(panel0, BorderLayout.CENTER);
		panel0.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("157px:grow"),
				ColumnSpec.decode("508px"),
				ColumnSpec.decode("max(84dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("398px:grow"),}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel0.add(panel_2, "1, 2, fill, fill");
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(248, 248, 255));
		panel0.add(panel, "2, 2, fill, fill");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(45, 51, 417, 283);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 4");
		
		JLabel lblAnneSolairee = new JLabel("Date de début :");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 6, left, fill");
		
		txtDebutAnnee = new JDateChooser();
		try {
			txtDebutAnnee.setDate(DonneeStatiques.f3.parse(debut));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			DonneeStatiques.messageDialog(e.getMessage(), 2);
		}
		txtDebutAnnee.setDateFormatString("d/MM/yyyy");
		panel_1.add(txtDebutAnnee, "4, 6, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 8");
		
		JLabel lblClasse = new JLabel("Date de fin :");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 10, left, fill");
		
		txtFinAnnee = new JDateChooser();
		try {
			txtFinAnnee.setDate(DonneeStatiques.f3.parse(fin));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			DonneeStatiques.messageDialog(e.getMessage(), 2);
		}
		txtFinAnnee.setDateFormatString("d/MM/yyyy");
		panel_1.add(txtFinAnnee, "4, 10, fill, fill");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 12");
		
		JLabel lblNomDeAnne = new JLabel("Désignation :");
		lblNomDeAnne.setForeground(new Color(30, 144, 255));
		lblNomDeAnne.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeAnne, "2, 14, left, fill");
		
		txtLibelleAnnee = new JTextField();
		txtLibelleAnnee.setText(annee);
		txtLibelleAnnee.setEditable(false);
		panel_1.add(txtLibelleAnnee, "4, 14, 2, 1, fill, fill");
		
		JButton btnEnregistrerLePaiement = new JButton("  Modifier");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtLibelleAnnee.getText().equalsIgnoreCase(annee)) 
				{
					new AnneeScolaire().updateAnneeScolaire(annee, DonneeStatiques.f2.format(txtDebutAnnee.getDate()),  DonneeStatiques.f2.format(txtFinAnnee.getDate()));
					int reponse = JOptionPane.showConfirmDialog(null, "Vous devez redémarrer l'application pour prendre en compte la nouvelle modification de l'année scolaire.\n Souhaitez vous redémarrer en même temps ? ");
					if(reponse == 0)
					System.exit(0);
				}else {
					DonneeStatiques.messageDialog("La modification de l'année scolaire "+annee+"\n\n  ne peut donner une année differente de "+annee+" \n Seules les dates de début et de fin peuvent être modifiées", 1);
				}
			}
		});
		
		txtDebutAnnee.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
						if(verifierDate())
							txtLibelleAnnee.setText(NewYear.this.anneeScolaire());
						else
							txtLibelleAnnee.setText("");
					}
				});
		
		txtFinAnnee.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				if(verifierDate())
					txtLibelleAnnee.setText(NewYear.this.anneeScolaire());
				else
					txtLibelleAnnee.setText("");
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(154, 366, 198, 48);
		panel.add(btnEnregistrerLePaiement);
		erreur = new JTextPane();
		erreur.setText("Impossible de creer une nouvelle annee. L'annee "+new DonneeStatiques().anneeCourante+" est toujours ouverte.");
		erreur.setBackground(Color.WHITE);
		erreur.setForeground(Color.RED);
		erreur.setFont(new Font("Century", Font.BOLD, 12));
		erreur.setBounds(10, 0, 488, 67);
		erreur.setVisible(false);
		panel.add(erreur);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel0.add(panel_3, "3, 2, fill, fill");

	}
	public String  anneeScolaire() {
		return  DonneeStatiques.recupererAnnee.format(txtDebutAnnee.getDate()) + "-" + DonneeStatiques.recupererAnnee.format(txtFinAnnee.getDate());
		
	}
	
	public Boolean  verifierDate() {
		Boolean reponse = false;
		String dateDebut = DonneeStatiques.f2.format(txtDebutAnnee.getDate()), dateFin= DonneeStatiques.f2.format(txtFinAnnee.getDate());
		String anneeDebut =  DonneeStatiques.recupererAnnee.format(txtDebutAnnee.getDate()), anneeFin =  DonneeStatiques.recupererAnnee.format(txtFinAnnee.getDate());
		if( dateDebut.compareToIgnoreCase(dateFin) < 0 )
		{
			if(anneeDebut.compareToIgnoreCase(anneeFin) < 0 )
			{
				int diff = Integer.parseInt(anneeFin) - Integer.parseInt(anneeDebut);
				if(diff == 1 )
				{	
					if(DonneeStatiques.recupererAnnee.format(new Date()).equalsIgnoreCase(DonneeStatiques.recupererAnnee.format(txtFinAnnee.getDate())) || DonneeStatiques.recupererAnnee.format(new Date()).equalsIgnoreCase(DonneeStatiques.recupererAnnee.format(txtDebutAnnee.getDate())))
					{
						reponse = true;
					}
					
				}
			}
		}	
		return  reponse;
	}
	
	public void miseAjourScolarite()
	{
		new Scolarite().insertMiseAjourScolarite();
	}
}
