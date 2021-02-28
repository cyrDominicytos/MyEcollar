package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Apprenant;
import Model.Inscription;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Reinscription extends JPanel {
	private JTextField frais;
	JComboBox cbxAncienneClasse;
	JComboBox cbxNomEleve;
	JComboBox cbxNewClasse;
	private Principal parent;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Reinscription(Principal parent) {
		this.parent = parent;
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblReinscrireUnElve = new JLabel("Réinscrire un élève");
		lblReinscrireUnElve.setIcon(new ImageIcon(Reinscription.class.getResource("/icones/reinscrire.png")));
		lblReinscrireUnElve.setHorizontalAlignment(SwingConstants.CENTER);
		lblReinscrireUnElve.setForeground(new Color(30, 144, 255));
		lblReinscrireUnElve.setFont(new Font("Century", Font.BOLD, 22));
		add(lblReinscrireUnElve, BorderLayout.NORTH);
		
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
				RowSpec.decode("525px:grow"),}));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(248, 248, 255));
		panel0.add(panel, "2, 2, fill, fill");
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(null);
		label.setIcon(new ImageIcon(Reinscription.class.getResource("/icones/28140.png")));
		label.setBounds(187, 13, 134, 125);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(6, 103, 496, 357);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("max(12dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("30dlu"),
				RowSpec.decode("max(21dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(21dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(22dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(25dlu;default)"),}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		JTextPane anneeError = new JTextPane();
		anneeError.setVisible(false);
		anneeError.setText("L'ann\u00E9e Scolaire "+new DonneeStatiques().anneeCourante+" est d\u00E9j\u00E0 cl\u00F4tur\u00E9e. Veuillez ouvrir une nouvelle ann\u00E9e.");
		anneeError.setForeground(new Color(255, 0, 0));
		anneeError.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel_1.add(anneeError, "2, 3, 3, 1");
		
		JLabel lblAnneSolairee = new JLabel("Année Solairee :");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 4, left, fill");
		
		JTextField anneCourante = new JTextField();
		anneCourante.setHorizontalAlignment(SwingConstants.CENTER);
		anneCourante.setText(new DonneeStatiques().anneeCourante);
		anneCourante.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		anneCourante.setEditable(false);
		panel_1.add(anneCourante, "4, 4, 2, 1, fill, fill");
		
		JLabel lblClasse = new JLabel("Ancienne classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 6, left, fill");
		cbxAncienneClasse = new JComboBox();
		AutoCompleteDecorator.decorate(cbxAncienneClasse);
		cbxAncienneClasse.setMaximumRowCount(10);
		cbxAncienneClasse.setEditable(true);
		if(DonneeStatiques.classeNiveau() != null)
		cbxAncienneClasse.setModel(DonneeStatiques.classeNiveau());
		panel_1.add(cbxAncienneClasse, "4, 6, 2, 1, fill, fill");
		
		JLabel lblNomDeLlve = new JLabel("Nom de l'élève :");
		lblNomDeLlve.setEnabled(false);
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 8, left, fill");
		
		cbxNomEleve = new JComboBox();
		AutoCompleteDecorator.decorate(cbxNomEleve);
		cbxNomEleve.setEditable(true);
		if(cbxAncienneClasse.getSelectedItem() != null)
		cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenantReinscription(cbxAncienneClasse.getSelectedItem().toString()));
		panel_1.add(cbxNomEleve, "4, 8, 2, 1, fill, fill");
		
		JLabel lblNewClasse = new JLabel("Nouvelle classe : ");
		lblNewClasse.setEnabled(false);
		lblNewClasse.setForeground(new Color(30, 144, 255));
		lblNewClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNewClasse, "2, 10, left, fill");
		
		cbxNewClasse = new JComboBox();
		AutoCompleteDecorator.decorate(cbxNewClasse);
		cbxNewClasse.setEditable(true);
		cbxNewClasse.setModel(DonneeStatiques.classeNiveau());
		
		
		panel_1.add(cbxNewClasse, "4, 10, 2, 1, fill, fill");
		
		JLabel lblFraisDeRinscription = new JLabel("Frais de réinscription : ");
		lblFraisDeRinscription.setForeground(new Color(30, 144, 255));
		lblFraisDeRinscription.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblFraisDeRinscription, "2, 12, right, fill");
		
		frais = new JTextField();
		frais.setText("0");
		panel_1.add(frais, "4, 12, fill, fill");
		frais.setColumns(10);
		
		JButton btnEnregistrerLePaiement = new JButton("Valider");
		btnEnregistrerLePaiement.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
					int f = Integer.parseInt(frais.getText());
					if(verifierFrais())
					{
						new Model.Inscription().insertInscription(DonneeStatiques.matriculeReinscription.get(cbxNomEleve.getSelectedIndex()), cbxNewClasse.getSelectedItem().toString(),f);
						try {
							ResultSet result = new Apprenant().selectApprenantInfos(DonneeStatiques.matriculeReinscription.get(cbxNomEleve.getSelectedIndex()));
							result.next();
							RecuInscription recu = new RecuInscription(result.getString("MATRICULE"), result.getString("NOM"), result.getString("PRENOM"), cbxNewClasse.getSelectedItem().toString(), result.getString("SEXE"), result.getString("CODEOPHELIN").isEmpty() ? ("Non") : ("Oui"), result.getString("CONTACT"), result.getString("ADRESSE"));
							recu.setLocationRelativeTo(null);
							recu.show();
						} catch (Exception e) {
							//DonneeStatiques.messageDialog(e.getMessage(), 2);
						}
						frais.setText("0");
						Reinscription.this.cbxNomEleve.revalidate();
					}
					
					
					
				
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(172, 469, 164, 48);
		panel.add(btnEnregistrerLePaiement);

		cbxAncienneClasse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenantReinscription(cbxAncienneClasse.getSelectedItem().toString()));
				lblNomDeLlve.setEnabled(true);
				cbxNomEleve.setEnabled(true);
			}
		});

		cbxNomEleve.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				lblNewClasse.setEnabled(true);
				cbxNewClasse.setEnabled(true);
			}
		});
		
		if(DonneeStatiques.finAnnee.compareTo( DonneeStatiques.f3.format(new Date())) < 0)
		{
			 anneeError.setVisible(true);
			 btnEnregistrerLePaiement.setEnabled(false);
		}

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Reinscription(int matricule, String nomPrenom, String oldClass, String newClass, int val, Boolean action,Principal parent) {
		
			this.parent = parent;
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblReinscrireUnElve = new JLabel(action ? "Modifier l'inscription de "+nomPrenom : "Réinscrire l'élève "+nomPrenom);
		lblReinscrireUnElve.setIcon(new ImageIcon(Reinscription.class.getResource("/icones/reinscrire.png")));
		lblReinscrireUnElve.setHorizontalAlignment(SwingConstants.CENTER);
		lblReinscrireUnElve.setForeground(new Color(30, 144, 255));
		lblReinscrireUnElve.setFont(new Font("Century", Font.BOLD, 22));
		add(lblReinscrireUnElve, BorderLayout.NORTH);
		
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
				RowSpec.decode("525px:grow"),}));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(248, 248, 255));
		panel0.add(panel, "2, 2, fill, fill");
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(null);
		label.setIcon(new ImageIcon(Reinscription.class.getResource("/icones/28140.png")));
		label.setBounds(187, 13, 134, 125);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(6, 103, 496, 357);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("max(12dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("30dlu"),
				RowSpec.decode("max(21dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(21dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(22dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(25dlu;default)"),}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		JTextPane anneeError = new JTextPane();
		anneeError.setVisible(false);
		anneeError.setText("L'ann\u00E9e Scolaire "+new DonneeStatiques().anneeCourante+" est d\u00E9j\u00E0 cl\u00F4tur\u00E9e. Veuillez ouvrir une nouvelle ann\u00E9e.");
		anneeError.setForeground(new Color(255, 0, 0));
		anneeError.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel_1.add(anneeError, "2, 3, 3, 1");
		
		
		JLabel lblAnneSolairee = new JLabel("Année Solairee :");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 4, left, fill");
		
		JTextField anneCourante = new JTextField();
		anneCourante.setHorizontalAlignment(SwingConstants.CENTER);
		anneCourante.setText(new DonneeStatiques().anneeCourante);
		anneCourante.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		anneCourante.setEditable(false);
		panel_1.add(anneCourante, "4, 4, 2, 1, fill, fill");
		
		JLabel lblClasse = new JLabel("Ancienne classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 6, left, fill");
		cbxAncienneClasse = new JComboBox();
		AutoCompleteDecorator.decorate(cbxAncienneClasse);
		cbxAncienneClasse.setMaximumRowCount(10);
		
		panel_1.add(cbxAncienneClasse, "4, 6, 2, 1, fill, fill");
		
		JLabel lblNomDeLlve = new JLabel("Nom de l'élève :");
		lblNomDeLlve.setEnabled(false);
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 8, left, fill");
		
		cbxNomEleve = new JComboBox();
		cbxNomEleve.setModel(new DefaultComboBoxModel(new String[] {nomPrenom}));		
		cbxNomEleve.setSelectedItem(nomPrenom);
		
		panel_1.add(cbxNomEleve, "4, 8, 2, 1, fill, fill");
		
		JLabel lblNewClasse = new JLabel("Nouvelle classe : ");
		lblNewClasse.setEnabled(false);
		lblNewClasse.setForeground(new Color(30, 144, 255));
		lblNewClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNewClasse, "2, 10, left, fill");
		
		cbxNewClasse = new JComboBox();
		AutoCompleteDecorator.decorate(cbxNewClasse);
		cbxNewClasse.setEditable(true);
		cbxNewClasse.setModel(DonneeStatiques.classeNiveau());
		panel_1.add(cbxNewClasse, "4, 10, 2, 1, fill, fill");
		
		JLabel lblFraisDeRinscription = new JLabel("Frais de réinscription : ");
		lblFraisDeRinscription.setForeground(new Color(30, 144, 255));
		lblFraisDeRinscription.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblFraisDeRinscription, "2, 12, right, fill");
		
		frais = new JTextField();
		frais.setText("0");
		panel_1.add(frais, "4, 12, fill, fill");
		frais.setColumns(10);
		if(action)
		{
			cbxNewClasse.setSelectedItem(newClass);
			frais.setText(""+val);
		}else {
			//cbxAncienneClasse.setSelectedItem(oldClass);
			cbxAncienneClasse.setModel(new DefaultComboBoxModel(new String[] {oldClass}));	
			frais.setText("0");
		}
		
		JButton btnEnregistrerLePaiement = new JButton("Valider");
		btnEnregistrerLePaiement.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				

				
				if(verifierFrais())
				{
					if(action)
					{
						if(new Model.Inscription().UpdateInscription(matricule, cbxNewClasse.getSelectedItem().toString(), Integer.parseInt(frais.getText()), oldClass) > 0)
						try {
							ResultSet result = new Apprenant().selectApprenantInfos(matricule);
							result.next();
							RecuInscription recu = new RecuInscription(result.getString("MATRICULE"), result.getString("NOM"), result.getString("PRENOM"), cbxNewClasse.getSelectedItem().toString(), result.getString("SEXE"), result.getString("CODEOPHELIN").isEmpty() ? ("Non") : ("Oui"), result.getString("CONTACT"), result.getString("ADRESSE"));
							recu.setLocationRelativeTo(null);
							recu.show();
						} catch (Exception e) {
							//DonneeStatiques.messageDialog(e.getMessage(), 2);
						}
					}else {
						if(new Model.Inscription().insertInscription(matricule, cbxNewClasse.getSelectedItem().toString(), Integer.parseInt(frais.getText())) > 0)
						try {
							ResultSet result = new Apprenant().selectApprenantInfos(DonneeStatiques.matriculeReinscription.get(cbxNomEleve.getSelectedIndex()));
							result.next();
							RecuInscription recu = new RecuInscription(result.getString("MATRICULE"), result.getString("NOM"), result.getString("PRENOM"), cbxNewClasse.getSelectedItem().toString(), result.getString("SEXE"), result.getString("CODEOPHELIN").isEmpty() ? ("Non") : ("Oui"), result.getString("CONTACT"), result.getString("ADRESSE"));
							recu.setLocationRelativeTo(null);
							recu.show();
						} catch (Exception e) {
							//DonneeStatiques.messageDialog(e.getMessage(), 2);
						}
					}
					frais.setText("0");
				}
				
				
				
								
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(172, 469, 164, 48);
		panel.add(btnEnregistrerLePaiement);

		cbxAncienneClasse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenantReinscription(cbxAncienneClasse.getSelectedItem().toString()));
				lblNomDeLlve.setEnabled(true);
				cbxNomEleve.setEnabled(true);
			}
		});

		cbxNomEleve.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				lblNewClasse.setEnabled(true);
				cbxNewClasse.setEnabled(true);
			}
		});
		
		if(DonneeStatiques.finAnnee.compareTo( DonneeStatiques.f3.format(new Date())) < 0)
		{
			 anneeError.setVisible(true);
			 btnEnregistrerLePaiement.setEnabled(false);
		}

	}
	
	
	public  Boolean verifierFrais() {
		String champ = "";
		if(this.frais.getText().isEmpty() ||this.frais.getText() == null || Integer.valueOf(this.frais.getText()) < 0 )
		{
			DonneeStatiques.messageDialog("Renseigner un montant valide pour le frais de scolarité", 1);
			return false;
		}
		else
			if(Integer.valueOf(this.frais.getText()) < DonneeStatiques.frais && Integer.valueOf(this.frais.getText()) > 0 )
			{
				DonneeStatiques.messageDialog("Le montant des frais ne peut etre inférieur à "+DonneeStatiques.frais, 1);
				return false;
			}else
				return true;
	}
}
