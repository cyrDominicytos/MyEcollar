package files;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormSpecs;

public class RecuInscription extends JFrame {

	JLabel matricule;
	JLabel classe;
	JLabel nom;
	JLabel prenom;
	JLabel dateNaiss;
	JLabel lieuNaiss;
	JLabel sexe;
	JLabel contactTuteur;
	JLabel codeOrphelin;
	JLabel adresse;
	JScrollPane scrollPane;
	JPanel printPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public RecuInscription(String p_matricule,String p_nom,String p_prenom,String p_classe,String p_sexe,String p_codeophelin,String p_contactTuteur,String p_adresse) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setType(Type.UTILITY);
		setBounds(0, 0, 698, 579);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel btnPane = new JPanel();
		btnPane.setBackground(new Color(255, 255, 255));
		btnPane.setPreferredSize(new Dimension(10, 60));
		getContentPane().add(btnPane, BorderLayout.SOUTH);
		btnPane.setLayout(null);
		
		JButton btnImprimer = new JButton(" Imprimer");
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DonneeStatiques().imprimerDocument(printPane);
			}
		});
		btnImprimer.setForeground(Color.WHITE);
		btnImprimer.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		btnImprimer.setBackground(new Color(30, 144, 255));
		btnImprimer.setBounds(113, 8, 171, 44);
		btnPane.add(btnImprimer);
		
		JButton btnAnnuler = new JButton("Quitter");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		btnAnnuler.setBackground(new Color(255, 165, 0));
		btnAnnuler.setBounds(397, 8, 171, 44);
		btnPane.add(btnAnnuler);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		printPane = new JPanel();
		printPane.setBackground(Color.WHITE);
		scrollPane.setViewportView(printPane);
		printPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePane = new JPanel();
		titlePane.setLayout(null);
		titlePane.setPreferredSize(new Dimension(10, 55));
		titlePane.setBackground(Color.WHITE);
		printPane.add(titlePane, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Réçu d'inscription ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sitka Heading", Font.BOLD, 25));
		label.setBounds(19, 0, 536, 32);
		titlePane.add(label);
		
		JLabel label_1 = new JLabel("====== @ ======");
		label_1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		label_1.setBounds(193, 22, 172, 26);
		titlePane.add(label_1);
		
		JLabel lblAlBirr = new JLabel("AL - BIRR");
		lblAlBirr.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlBirr.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		lblAlBirr.setBounds(459, 9, 151, 16);
		titlePane.add(lblAlBirr);
		
		JPanel infoPane = new JPanel();
		infoPane.setBackground(Color.WHITE);
		printPane.add(infoPane, BorderLayout.SOUTH);
		infoPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(34dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(66dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(75dlu;default)"),
				ColumnSpec.decode("max(11dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(92dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(5dlu;default):grow"),},
			new RowSpec[] {
				RowSpec.decode("15dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(15dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(25dlu;default):grow"),}));
		
		JLabel lblMatricule = new JLabel("Matricule : ");
		lblMatricule.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblMatricule, "3, 3");
		
		matricule = new JLabel(p_matricule);
		matricule.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(matricule, "5, 3, 3, 1");
		
		JLabel lblClasse = new JLabel("Classe : ");
		lblClasse.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblClasse, "3, 5");
		
		classe = new JLabel(p_classe);
		classe.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(classe, "5, 5, 3, 1");
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblNom, "3, 7");
		
		nom = new JLabel(p_nom);
		nom.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(nom, "5, 7, 5, 1");
		
		JLabel lblPrnom = new JLabel("Prénom (s): ");
		lblPrnom.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblPrnom, "3, 9");
		
		prenom = new JLabel(p_prenom);
		prenom.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(prenom, "5, 9, 5, 1");
		
		JLabel lblSexe = new JLabel("Sexe : ");
		lblSexe.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblSexe, "3, 13");
		
		sexe = new JLabel(p_sexe);
		sexe.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(sexe, "5, 13");
		
		JLabel lblOrphelin = new JLabel("Orphelin : ");
		lblOrphelin.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblOrphelin, "3, 15");
		
		codeOrphelin = new JLabel(p_codeophelin);
		codeOrphelin.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(codeOrphelin, "5, 15");
		
		JLabel lblContactDuTuteur = new JLabel("Contact du tuteur : ");
		lblContactDuTuteur.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblContactDuTuteur, "3, 17");
		
		contactTuteur = new JLabel(p_contactTuteur);
		contactTuteur.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(contactTuteur, "5, 17, 5, 1");
		
		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblAdresse, "3, 19");
		
		adresse = new JLabel(p_adresse);
		adresse.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		infoPane.add(adresse, "5, 19, 5, 1");
		
		JLabel lblFait = new JLabel("Fait à  ------------------------------------- le "+DonneeStatiques.f.format(new Date())+"");
		infoPane.add(lblFait, "6, 22, 3, 1");
		
		JLabel lblLaDirectrice = new JLabel("La directrice");
		lblLaDirectrice.setFont(new Font("Sitka Display", Font.BOLD, 18));
		infoPane.add(lblLaDirectrice, "8, 24, center, default");

	}
}
