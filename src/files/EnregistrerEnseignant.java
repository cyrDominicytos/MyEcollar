package files;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class EnregistrerEnseignant extends JPanel {
	private JTextField nom, prenom, contact, adresse;
	private JCheckBox esEnseignant;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxSexe;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EnregistrerEnseignant() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblAjouterEnseignant = new JLabel("Ajouter Personnel");
		lblAjouterEnseignant.setIcon(new ImageIcon(EnregistrerEnseignant.class.getResource("/icones/enseignant64.png")));
		lblAjouterEnseignant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterEnseignant.setForeground(new Color(30, 144, 255));
		lblAjouterEnseignant.setFont(new Font("Century", Font.BOLD, 22));
		add(lblAjouterEnseignant, BorderLayout.NORTH);
		
		JPanel centre = new JPanel();
		centre.setBackground(new Color(255, 255, 255));
		add(centre, BorderLayout.CENTER);
		centre.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(105dlu;default)"),
				ColumnSpec.decode("max(77dlu;default)"),
				ColumnSpec.decode("max(105dlu;default)"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JPanel gauche = new JPanel();
		gauche.setBackground(new Color(255, 255, 255));
		centre.add(gauche, "1, 2, fill, fill");
		
		JPanel centre1 = new JPanel();
		centre1.setBackground(new Color(240, 248, 255));
		centre1.setPreferredSize(new Dimension(10, 350));
		centre.add(centre1, "2, 2, 3, 1, fill, fill");
		centre1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(164dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(24dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("Nom : ");
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label, "4, 4, left, fill");
		
		nom = new JTextField();
		nom.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		nom.setColumns(10);
		nom.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(nom, "6, 4, fill, fill");
		
		JLabel label_1 = new JLabel("Prénom (s) : ");
		label_1.setForeground(new Color(30, 144, 255));
		label_1.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label_1, "4, 8, right, default");
		
		prenom = new JTextField();
		prenom.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		prenom.setColumns(10);
		prenom.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(prenom, "6, 8, fill, fill");
		
		JLabel label_2 = new JLabel("Sexe : ");
		label_2.setForeground(new Color(30, 144, 255));
		label_2.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label_2, "4, 12, left, default");
		
		cbxSexe = new JComboBox();
		cbxSexe.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));
		cbxSexe.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		cbxSexe.setBorder(null);
		centre1.add(cbxSexe, "6, 12, fill, default");
		
		JLabel lblContact = new JLabel("Contact : ");
		lblContact.setForeground(new Color(30, 144, 255));
		lblContact.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(lblContact, "4, 16, left, default");
		
		contact = new JTextField();
		contact.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		contact.setColumns(10);
		contact.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(contact, "6, 16, fill, fill");
		
		JLabel label_3 = new JLabel("Adresse : ");
		label_3.setForeground(new Color(30, 144, 255));
		label_3.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label_3, "4, 20, left, default");
		
		adresse = new JTextField();
		adresse.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		adresse.setColumns(10);
		adresse.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(adresse, "6, 20, fill, fill");
		
		esEnseignant = new JCheckBox("Ce Personnel est Enseignant");
		esEnseignant.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		esEnseignant.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		esEnseignant.setSelected(true);
		centre1.add(esEnseignant, "4, 22, 3, 1");
		
		JPanel droite = new JPanel();
		droite.setBackground(new Color(255, 255, 255));
		centre.add(droite, "5, 2, fill, fill");
		
		JButton Enregistrer = new JButton("Enregistrer");
		Enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(verifierChamp() == "")
				{
					if(contact.getText().isEmpty() || contact.getText() == null)
					{
						DonneeStatiques.messageDialog("Le champs contact ne peut pas rester vide", 1);
					}else {
						new Model.Enseignant().insertEnseignant(contact.getText(), nom.getText(), prenom.getText(), cbxSexe.getSelectedItem().toString(), adresse.getText(), esEnseignant.isSelected());
						EnregistrerEnseignant.this.viderChamp();
					}
				}else {
					DonneeStatiques.messageDialog("Veuillez renseigner les champs : "+verifierChamp(), 1);
				}	
				
			}
		});
		Enregistrer.setForeground(new Color(255, 255, 255));
		Enregistrer.setBackground(new Color(0, 100, 0));
		Enregistrer.setFont(new Font("Sitka Banner", Font.BOLD, 20));
		centre.add(Enregistrer, "3, 6");

	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EnregistrerEnseignant(String contactPara, String nomPara, String prenomPara, String sexePara, String adresePara, String enseigant) {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblAjouterEnseignant = new JLabel("Modifier un Personnel");
		lblAjouterEnseignant.setIcon(new ImageIcon(EnregistrerEnseignant.class.getResource("/icones/enseignant64.png")));
		lblAjouterEnseignant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterEnseignant.setForeground(new Color(30, 144, 255));
		lblAjouterEnseignant.setFont(new Font("Century", Font.BOLD, 22));
		add(lblAjouterEnseignant, BorderLayout.NORTH);
		
		JPanel centre = new JPanel();
		centre.setBackground(new Color(255, 255, 255));
		add(centre, BorderLayout.CENTER);
		centre.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(105dlu;default)"),
				ColumnSpec.decode("max(77dlu;default)"),
				ColumnSpec.decode("max(105dlu;default)"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JPanel gauche = new JPanel();
		gauche.setBackground(new Color(255, 255, 255));
		centre.add(gauche, "1, 2, fill, fill");
		
		JPanel centre1 = new JPanel();
		centre1.setBackground(new Color(240, 248, 255));
		centre1.setPreferredSize(new Dimension(10, 350));
		centre.add(centre1, "2, 2, 3, 1, fill, fill");
		centre.add(centre1, "2, 2, 3, 1, fill, fill");
		centre1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(164dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(24dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("Nom : ");
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label, "4, 4, left, fill");
		
		nom = new JTextField();
		nom.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		nom.setColumns(10);
		nom.setText(nomPara);
		nom.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(nom, "6, 4, fill, fill");
		
		JLabel label_1 = new JLabel("Prénom (s) : ");
		label_1.setForeground(new Color(30, 144, 255));
		label_1.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label_1, "4, 8, right, default");
		
		prenom = new JTextField();
		prenom.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		prenom.setColumns(10);
		prenom.setText(prenomPara);
		prenom.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(prenom, "6, 8, fill, fill");
		
		JLabel label_2 = new JLabel("Sexe : ");
		label_2.setForeground(new Color(30, 144, 255));
		label_2.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label_2, "4, 12, left, default");
		
		cbxSexe = new JComboBox();
		cbxSexe.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));
		cbxSexe.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		cbxSexe.setBorder(null);
		cbxSexe.setSelectedItem(sexePara);
		centre1.add(cbxSexe, "6, 12, fill, default");
		
		JLabel lblContact = new JLabel("Contact : ");
		lblContact.setForeground(new Color(30, 144, 255));
		lblContact.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(lblContact, "4, 16, left, default");
		
		contact = new JTextField();
		contact.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		contact.setColumns(10);
		contact.setText(contactPara);
		contact.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(contact, "6, 16, fill, fill");
		
		JLabel label_3 = new JLabel("Adresse : ");
		label_3.setForeground(new Color(30, 144, 255));
		label_3.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		centre1.add(label_3, "4, 20, left, default");
		
		adresse = new JTextField();
		adresse.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		adresse.setColumns(10);
		adresse.setText(adresePara);
		adresse.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		centre1.add(adresse, "6, 20, fill, fill");
		
		esEnseignant = new JCheckBox("Ce Personnel est Enseignant");
		esEnseignant.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		esEnseignant.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		if(enseigant.equalsIgnoreCase("OUI"))
			esEnseignant.setSelected(true);
		centre1.add(esEnseignant, "4, 22, 3, 1");
		
		JPanel droite = new JPanel();
		droite.setBackground(new Color(255, 255, 255));
		centre.add(droite, "5, 2, fill, fill");
		
		JButton Enregistrer = new JButton("Modifier");
		Enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verifierChamp() == "")
				{
						if(contact.getText().isEmpty() || contact.getText() == null)
						{
							DonneeStatiques.messageDialog("Le champs contact ne peut pas rester vide", 1);
						}else {
							new Model.Enseignant().updateEnseignant(contact.getText(), nom.getText(), prenom.getText(), cbxSexe.getSelectedItem().toString(), adresse.getText(),  esEnseignant.isSelected(),contactPara);
							EnregistrerEnseignant.this.viderChamp();
							
						}
				}else {
					DonneeStatiques.messageDialog("Veuillez renseigner les champs : "+verifierChamp(), 1);
				}	
			}
		});
		Enregistrer.setForeground(new Color(255, 255, 255));
		Enregistrer.setBackground(new Color(0, 100, 0));
		Enregistrer.setFont(new Font("Sitka Banner", Font.BOLD, 20));
		centre.add(Enregistrer, "3, 6");

	}
	
	public  void viderChamp()
	{
		this.nom.setText("");
		this.prenom.setText("");
		this.contact.setText("");
	}
	public  String verifierChamp() {
		String champ = "";
		if(nom.getText().isEmpty() || nom.getText() == null)
			champ += " - "+"  Nom " ;
		if(prenom.getText().isEmpty() || prenom.getText() == null)
			champ += " - "+"  Prenom " ;
		return champ;
	}
}
