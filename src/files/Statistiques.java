package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Model.StatistiqueModel;

@SuppressWarnings("serial")
public class Statistiques extends JPanel {
	private JLabel totalHommeInscrit, totalFilleInscrite,totalInscrit,materiel,
	fourniture,salaire,TotalAutreDepense,totalDepense,TotalPayement,Recettedelanne,
	TotalFraisInscription,Resultatsdelanne,TotalDepensesCumulees,TotalRecettesCumulees,
	bilant, TotalRduction, ToutPayer,PayerUnepartie,RienPayer,restantDu, ophlin;

	/**
	 * Create the panel.
	 */
	public Statistiques(String annee ) {
		setMinimumSize(new Dimension(500, 400));
		setBorder(null);
		setBackground(Color.WHITE);
		
		JPanel Central = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));	
		//setLayout(new BorderLayout());
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1);
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(Color.WHITE);
		add(panelGauche);
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut);
		panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panelGauche.add(verticalStrut_2);
		JPanel panelInscrits = new JPanel();
		
		panelInscrits.setBackground(Color.WHITE);
		panelInscrits.setBorder(new LineBorder(new Color(99, 130, 191), 3, true));
		panelGauche.add(panelInscrits);
		panelInscrits.setLayout(new BorderLayout(0, 0));
		
		JLabel lblApprenants = new JLabel("   Apprenants");
		lblApprenants.setIcon(new ImageIcon(Statistiques.class.getResource("/icones/eleve.jpg")));
		lblApprenants.setBorder(null);
		lblApprenants.setHorizontalAlignment(SwingConstants.CENTER);
		lblApprenants.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		panelInscrits.add(lblApprenants, BorderLayout.NORTH);
		
		JScrollPane panel_1 = new JScrollPane();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(200, 140));
		panelInscrits.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Total d'inscrits : ");
		lblNewLabel_2.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 62, 133, 26);
		
		JLabel lblNombreTotalDinscrits = new JLabel("Gar\u00E7ons inscrits : ");
		lblNombreTotalDinscrits.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblNombreTotalDinscrits.setBounds(20, 0, 142, 26);
		
		JLabel lblNombreTotalDe = new JLabel("Filles inscrites : ");
		lblNombreTotalDe.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblNombreTotalDe.setBounds(20, 37, 133, 26);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_2);
		panel_1.add(lblNombreTotalDinscrits);
		panel_1.add(lblNombreTotalDe);
		
		totalHommeInscrit = new JLabel();
		totalHommeInscrit.setForeground(new Color(30, 144, 255));
		totalHommeInscrit.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		totalHommeInscrit.setHorizontalAlignment(SwingConstants.RIGHT);
		totalHommeInscrit.setBounds(172, 0, 182, 26);
		panel_1.add(totalHommeInscrit);
		
		totalFilleInscrite = new JLabel();
		totalFilleInscrite.setHorizontalAlignment(SwingConstants.RIGHT);
		totalFilleInscrite.setForeground(new Color(30, 144, 255));
		totalFilleInscrite.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		totalFilleInscrite.setBounds(259, 37, 95, 26);
		panel_1.add(totalFilleInscrite);
		
		totalInscrit = new JLabel();
		totalInscrit.setHorizontalAlignment(SwingConstants.RIGHT);
		totalInscrit.setForeground(new Color(30, 144, 255));
		totalInscrit.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		totalInscrit.setBounds(163, 62, 191, 26);
		panel_1.add(totalInscrit);
		
		JLabel label_1 = new JLabel("Tout Payer");
		label_1.setToolTipText("Nombre d'\u00E9l\u00E8ve ayant pay\u00E9 la totalit\u00E9 de la scolarit\u00E9 annuelle");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(20, 118, 158, 26);
		panel_1.add(label_1);
		
		ToutPayer = new JLabel();
		ToutPayer.setToolTipText("Nombre d'\u00E9l\u00E8ves ayant d\u00E9j\u00E0\u00A0 payer la totalit\u00E9 de la scolarit\u00E9.");
		ToutPayer.setHorizontalAlignment(SwingConstants.RIGHT);
		ToutPayer.setForeground(new Color(30, 144, 255));
		ToutPayer.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		ToutPayer.setBounds(172, 118, 182, 26);
		panel_1.add(ToutPayer);
		
		JLabel label_3 = new JLabel("Payer Une partie");
		label_3.setToolTipText("Nombre d'\u00E9l\u00E8ve ayant pay\u00E9 une partie de la scolarit\u00E9 annuelle");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_3.setBounds(20, 146, 158, 26);
		panel_1.add(label_3);
		
		PayerUnepartie = new JLabel();
		PayerUnepartie.setToolTipText("Nombre d'\u00E9l\u00E8ve ayant d\u00E9j\u00E0\u00A0 atteint le montant pr\u00E9vu pour cette tranche.");
		PayerUnepartie.setHorizontalAlignment(SwingConstants.RIGHT);
		PayerUnepartie.setForeground(new Color(30, 144, 255));
		PayerUnepartie.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		PayerUnepartie.setBounds(182, 144, 172, 26);
		panel_1.add(PayerUnepartie);
		
		JLabel label_5 = new JLabel("Rien Payer :");
		label_5.setToolTipText("Nombre d'\u00E9l\u00E8ve n'ayant rien pay\u00E9 sur  la scolarit\u00E9 annuelle");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_5.setBounds(20, 177, 158, 26);
		panel_1.add(label_5);
		
		RienPayer = new JLabel();
		RienPayer.setHorizontalAlignment(SwingConstants.RIGHT);
		RienPayer.setForeground(new Color(30, 144, 255));
		RienPayer.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		RienPayer.setBounds(193, 177, 161, 26);
		panel_1.add(RienPayer);
		
		JLabel lblNombreTotalDophlin = new JLabel("Total d'ophelin : ");
		lblNombreTotalDophlin.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblNombreTotalDophlin.setBounds(20, 88, 142, 26);
		panel_1.add(lblNombreTotalDophlin);
		
		ophlin = new JLabel();
		ophlin.setText("0");
		ophlin.setHorizontalAlignment(SwingConstants.RIGHT);
		ophlin.setForeground(new Color(30, 144, 255));
		ophlin.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		ophlin.setBounds(172, 88, 182, 26);
		panel_1.add(ophlin);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelGauche.add(verticalStrut);
		
		JPanel panelDepenses = new JPanel();
		panelDepenses.setBackground(Color.WHITE);
		panelDepenses.setBorder(new LineBorder(new Color(99, 130, 191), 3, true));
		panelGauche.add(panelDepenses);
		panelDepenses.setLayout(new BorderLayout(0, 0));
		
		JLabel labelDepenses = new JLabel("   Dépenses");
		labelDepenses.setIcon(new ImageIcon(Statistiques.class.getResource("/icones/depenses.jpg")));
		labelDepenses.setHorizontalAlignment(SwingConstants.CENTER);
		labelDepenses.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		labelDepenses.setBorder(null);
		panelDepenses.add(labelDepenses, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panelDepenses.add(panel, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(0, 140));
		panel.setLayout(null);
		
		JLabel lblLivres = new JLabel("Matériel didactique :");
		lblLivres.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblLivres.setBounds(24, 11, 149, 26);
		panel.add(lblLivres);
		
		JLabel lblEquipements = new JLabel("Fournitures scolaires :");
		lblEquipements.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblEquipements.setBounds(24, 48, 168, 26);
		panel.add(lblEquipements);
		
		JLabel lblDiversAchats = new JLabel("Salaire :");
		lblDiversAchats.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblDiversAchats.setBounds(24, 80, 149, 26);
		panel.add(lblDiversAchats);
		
		JLabel lblTotalDesDpenses = new JLabel("Autres D\u00E9penses :");
		lblTotalDesDpenses.setMinimumSize(new Dimension(100, 700));
		lblTotalDesDpenses.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblTotalDesDpenses.setBounds(24, 114, 168, 26);
		panel.add(lblTotalDesDpenses);
		
		materiel = new JLabel();
		materiel.setHorizontalAlignment(SwingConstants.RIGHT);
		materiel.setForeground(new Color(30, 144, 255));
		materiel.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		materiel.setBounds(186, 11, 168, 26);
		panel.add(materiel);
		
		fourniture = new JLabel();
		fourniture.setHorizontalAlignment(SwingConstants.RIGHT);
		fourniture.setForeground(new Color(30, 144, 255));
		fourniture.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		fourniture.setBounds(186, 48, 168, 26);
		panel.add(fourniture);
		
		salaire = new JLabel();
		salaire.setHorizontalAlignment(SwingConstants.RIGHT);
		salaire.setForeground(new Color(30, 144, 255));
		salaire.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		salaire.setBounds(186, 80, 168, 26);
		panel.add(salaire);
		
		TotalAutreDepense = new JLabel();
		TotalAutreDepense.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalAutreDepense.setForeground(new Color(30, 144, 255));
		TotalAutreDepense.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		TotalAutreDepense.setBounds(186, 112, 168, 26);
		panel.add(TotalAutreDepense);
		
		JLabel label = new JLabel("Total des d\u00E9penses :");
		label.setMinimumSize(new Dimension(100, 700));
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(24, 149, 168, 26);
		panel.add(label);
		
		totalDepense = new JLabel();
		totalDepense.setHorizontalAlignment(SwingConstants.RIGHT);
		totalDepense.setForeground(new Color(30, 144, 255));
		totalDepense.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		totalDepense.setBounds(186, 149, 168, 26);
		panel.add(totalDepense);
				
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panelGauche.add(verticalStrut_3);
		
		JPanel panelDroit = new JPanel();
		panelDroit.setBackground(Color.WHITE);
		add(panelDroit);
		panelDroit.setLayout(new BoxLayout(panelDroit, BoxLayout.Y_AXIS));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panelDroit.add(verticalStrut_4);
		JPanel panelNbrPaye = new JPanel();
		panelNbrPaye.setBackground(Color.WHITE);
		panelNbrPaye.setBorder(new LineBorder(new Color(99, 130, 191), 3, true));
		panelDroit.add(panelNbrPaye);
		panelNbrPaye.setLayout(new BorderLayout(0, 0));
		
		JLabel labelPaiements = new JLabel("   Paiements");
		labelPaiements.setIcon(new ImageIcon(Statistiques.class.getResource("/icones/paiements.png")));
		labelPaiements.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaiements.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		labelPaiements.setBorder(null);
		panelNbrPaye.add(labelPaiements, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(0, 140));
		panelNbrPaye.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblSommeCollecte = new JLabel("Total Payement :");
		lblSommeCollecte.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		lblSommeCollecte.setBounds(20, 85, 158, 26);
		panel_2.add(lblSommeCollecte);
		
		TotalPayement = new JLabel();
		TotalPayement.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalPayement.setForeground(new Color(30, 144, 255));
		TotalPayement.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		TotalPayement.setBounds(193, 85, 173, 26);
		panel_2.add(TotalPayement);
		
		JLabel lblRecetteDeLanne = new JLabel("Recette de  l'ann\u00E9e : ");
		lblRecetteDeLanne.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRecetteDeLanne.setBounds(20, 122, 152, 26);
		panel_2.add(lblRecetteDeLanne);
		
		Recettedelanne = new JLabel();
		Recettedelanne.setHorizontalAlignment(SwingConstants.RIGHT);
		Recettedelanne.setForeground(new Color(30, 144, 255));
		Recettedelanne.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		Recettedelanne.setBounds(193, 122, 173, 26);
		panel_2.add(Recettedelanne);
		
		JLabel lblTotalFraisInscription = new JLabel("Total Frais Inscription :");
		lblTotalFraisInscription.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTotalFraisInscription.setBounds(20, 48, 158, 26);
		panel_2.add(lblTotalFraisInscription);
		
		TotalFraisInscription = new JLabel();
		TotalFraisInscription.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalFraisInscription.setForeground(new Color(30, 144, 255));
		TotalFraisInscription.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		TotalFraisInscription.setBounds(193, 48, 173, 26);
		panel_2.add(TotalFraisInscription);
		
		JLabel lblTotalRduction = new JLabel("Total R\u00E9duction :");
		lblTotalRduction.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTotalRduction.setBounds(20, 13, 158, 26);
		panel_2.add(lblTotalRduction);
		
		TotalRduction = new JLabel();
		TotalRduction.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalRduction.setForeground(new Color(30, 144, 255));
		TotalRduction.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		TotalRduction.setBounds(183, 11, 183, 26);
		panel_2.add(TotalRduction);
		
		JLabel lblRestantD = new JLabel("Restant D\u00FB");
		lblRestantD.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRestantD.setBounds(20, 159, 152, 26);
		panel_2.add(lblRestantD);
		
		restantDu = new JLabel();
		restantDu.setHorizontalAlignment(SwingConstants.RIGHT);
		restantDu.setForeground(new Color(30, 144, 255));
		restantDu.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		restantDu.setBounds(193, 159, 173, 26);
		panel_2.add(restantDu);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panelDroit.add(verticalStrut_1);
		
		JPanel panelGraphe = new JPanel();
		panelGraphe.setBackground(Color.WHITE);
		panelGraphe.setBorder(new LineBorder(new Color(99, 130, 191), 3, true));
		panelDroit.add(panelGraphe);
		panelGraphe.setLayout(new BorderLayout(0, 0));
		
		JLabel labelGraphes = new JLabel("Bilan de l'Ecole");
		labelGraphes.setIcon(new ImageIcon(Statistiques.class.getResource("/icones/graphes.jpg")));
		labelGraphes.setHorizontalAlignment(SwingConstants.CENTER);
		labelGraphes.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		labelGraphes.setBorder(null);
		panelGraphe.add(labelGraphes, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(0, 140));
		panelGraphe.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblTotalDpenses = new JLabel("R\u00E9sultats de l'ann\u00E9e :");
		lblTotalDpenses.setToolTipText("Le r\u00E9sultat de l'ann\u00E9e est  la  diff\u00E9rence entre la recette de l'ann\u00E9e(somme totale collect\u00E9e) et la d\u00E9pense totale");
		lblTotalDpenses.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTotalDpenses.setBounds(10, 11, 192, 27);
		panel_3.add(lblTotalDpenses);
		
		Resultatsdelanne = new JLabel();
		Resultatsdelanne.setToolTipText("Le r\u00E9sultat de l'ann\u00E9e est  la  diff\u00E9rence entre la recette de l'ann\u00E9e(somme totale collect\u00E9e) et la d\u00E9pense");
		Resultatsdelanne.setHorizontalAlignment(SwingConstants.RIGHT);
		Resultatsdelanne.setForeground(new Color(30, 144, 255));
		Resultatsdelanne.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		Resultatsdelanne.setBounds(212, 11, 160, 27);
		panel_3.add(Resultatsdelanne);
		
		JLabel lblTotalRecettes = new JLabel("Total D\u00E9penses Cumul\u00E9es :");
		lblTotalRecettes.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTotalRecettes.setBounds(10, 49, 200, 27);
		panel_3.add(lblTotalRecettes);
		
		TotalDepensesCumulees = new JLabel();
		//TotalDepensesCumulees.setText(new StatistiqueModel().selectTotalDepense()+"");
		TotalDepensesCumulees.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalDepensesCumulees.setForeground(new Color(30, 144, 255));
		TotalDepensesCumulees.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		TotalDepensesCumulees.setBounds(212, 49, 160, 27);
		panel_3.add(TotalDepensesCumulees);
		
		JLabel lblSoldeEnCaisse = new JLabel("Total Recettes Cumul\u00E9es :");
		lblSoldeEnCaisse.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSoldeEnCaisse.setBounds(10, 87, 200, 27);
		panel_3.add(lblSoldeEnCaisse);
		
		TotalRecettesCumulees = new JLabel();
		//TotalRecettesCumulees.setText(new StatistiqueModel().selectTotalRecette()+"");
		TotalRecettesCumulees.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalRecettesCumulees.setForeground(new Color(30, 144, 255));
		TotalRecettesCumulees.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		TotalRecettesCumulees.setBounds(200, 87, 172, 27);
		panel_3.add(TotalRecettesCumulees);
		
		JLabel Bilan = new JLabel("Solde en caisse :");
		Bilan.setToolTipText("Le solde en caisse est la diff\u00E9rence entre le total des recettes depuis la cr\u00E9ation de l'\u00E9cole et le total des d\u00E9penses");
		Bilan.setFont(new Font("Dialog", Font.PLAIN, 16));
		Bilan.setBounds(10, 125, 192, 27);
		panel_3.add(Bilan);
		
		bilant = new JLabel();
		bilant.setToolTipText("Le solde en caisse est la diff\u00E9rence entre le total des recettes depuis la cr\u00E9ation de l'\u00E9cole et le total des d\u00E9penses");
		//bilant.setText(new StatistiqueModel().selectBilan()+"");
		bilant.setHorizontalAlignment(SwingConstants.RIGHT);
		bilant.setForeground(new Color(30, 144, 255));
		bilant.setFont(new Font("Modern No. 20", Font.BOLD, 28));
		bilant.setBounds(212, 125, 160, 27);
		panel_3.add(bilant);
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panelDroit.add(verticalStrut_5);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2);
		
		//setLayout(new BorderLayout());
		//add(Central, BorderLayout.CENTER);
		this.refreshStatistique(annee);
	}
	
	public void refreshStatistique(String annee)
	{
		System.out.println(annee);
		totalHommeInscrit.setText(new StatistiqueModel().selectTotalGarconInscrit(annee)+"");
		totalFilleInscrite.setText(new StatistiqueModel().selectTotalFilleInscrit(annee)+"");
		totalInscrit.setText(new StatistiqueModel().selectTotalInscrit(annee)+"");
		ophlin.setText(new StatistiqueModel().selectTotalOphlin(annee)+"");
		ToutPayer.setText(new StatistiqueModel().selectSoldeAtteint(annee)+"") ;
		PayerUnepartie.setText(new StatistiqueModel().selectSoldeNonAtteint(annee)+"") ;
		RienPayer.setText(new StatistiqueModel().selectRienPayer(annee)+"") ;
		
		
		materiel.setText(new StatistiqueModel().selectTotalMateriel(annee)+"");
		fourniture.setText(new StatistiqueModel().selectTotalFourniture(annee)+"");
		salaire.setText(new StatistiqueModel().selectTotalSalaire(annee)+"");
		TotalAutreDepense.setText(new StatistiqueModel().selectTotalAutre(annee)+"");
		totalDepense.setText(new StatistiqueModel().selectTotalDepense(annee)+"");
		
		
		TotalRduction.setText(new StatistiqueModel().selectTotalReduction(annee)+"");
		TotalFraisInscription.setText(new StatistiqueModel().selectTotalFrais(annee)+"");
		TotalPayement.setText(new StatistiqueModel().selectTotalPayement(annee)+"");
		Recettedelanne.setText(new StatistiqueModel().selectTotalRecette(annee)+"");
		restantDu.setText(new StatistiqueModel().selectTotalRD(annee)+"");
		
		Resultatsdelanne.setText(new StatistiqueModel().selectResultatAnnee(annee)+"");
		TotalDepensesCumulees.setText(new StatistiqueModel().selectTotalAllDepense(annee)+"");
		TotalRecettesCumulees.setText(new StatistiqueModel().selectTotalAllRecette(annee)+"");
		bilant.setText(new StatistiqueModel().selectBilan(annee)+"");
		

	}
}
