package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.text.DateFormatter;

import Model.Apprenant;

@SuppressWarnings("serial")
public class Inscription extends JPanel {

	/**
	 * Create the panel.
	 */
	JScrollPane scrollPane ;
	private int action =  0;
	Inscription1 page1;
	public Inscription() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNouvelleInscription = new JLabel(" Nouvelle inscription");
		lblNouvelleInscription.setIcon(new ImageIcon(Inscription.class.getResource("/icones/student-registratin.png")));
		lblNouvelleInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelleInscription.setForeground(new Color(30, 144, 255));
		lblNouvelleInscription.setFont(new Font("Century", Font.BOLD, 22));
		add(lblNouvelleInscription, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		page1 = new Inscription1();
		scrollPane.setViewportView(page1);
		
		JButton envoyer = new JButton("Enregistrer");
		envoyer.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "static-access" })
			public void actionPerformed(ActionEvent arg0) {
				
				if(page1.classe.getSelectedItem() != null)
					if(verifierChamp() == "")
					{
						if(verifierFrais())
						{
							if(page1.lblCatgorie.isSelected()) {
								if(page1.codeText.getText().isEmpty() || page1.codeText.getText() == null)
								{
									DonneeStatiques.messageDialog("Vous avez specifie que l'apprenant "+page1.nomTextField.getText()+" "+page1.prenomTextField.getText()+" est ophelin.\n Preciser le code de la structure qui s'occupe de ses frais."+verifierChamp(), 1);
									
			
								}else {
									if(new Apprenant().insertApprenant( page1.nomTextField.getText(), page1.prenomTextField.getText(), page1.cbxSexe.getSelectedItem().toString(), page1.contactTuteurTextField_2.getText(), page1.txtAdresse.getText(), page1.classe.getSelectedItem().toString(),page1.codeText.getText(), Integer.parseInt(page1.frais.getText())) == 1)
									{
										RecuInscription recu = new RecuInscription(String.valueOf(new Apprenant().MaxMatricule()), page1.nomTextField.getText(), page1.prenomTextField.getText(), page1.classe.getSelectedItem().toString(), page1.cbxSexe.getSelectedItem().toString(), page1.codeText.getText().isEmpty() ? ("Non") : ("Oui"), page1.contactTuteurTextField_2.getText(), page1.txtAdresse.getText());
										recu.setLocationRelativeTo(null);
										recu.show();
										page1.viderChamp();
									}
								}
							}else {
								
								if(new Apprenant().insertApprenant( page1.nomTextField.getText(), page1.prenomTextField.getText(), page1.cbxSexe.getSelectedItem().toString(), page1.contactTuteurTextField_2.getText(), page1.txtAdresse.getText(), page1.classe.getSelectedItem().toString(), Integer.parseInt(page1.frais.getText())) == 1)
								{
									RecuInscription recu = new RecuInscription(String.valueOf(new Apprenant().MaxMatricule()), page1.nomTextField.getText(), page1.prenomTextField.getText(), page1.classe.getSelectedItem().toString(), page1.cbxSexe.getSelectedItem().toString(), page1.codeText.getText().isEmpty() ? ("Non") : ("Oui"), page1.contactTuteurTextField_2.getText(), page1.txtAdresse.getText());
									recu.setLocationRelativeTo(null);
									recu.show();
									page1.viderChamp();
								}
							}
						}
					}
						
					else {
						DonneeStatiques.messageDialog("Veuillez renseigner les champs : "+verifierChamp(), 1);
					}
						
				else
					DonneeStatiques.messageDialog("Aucune classe n'est encore disponible dans le système !\nVous devez enregistrer d'abord les classes afin de pouvoir en attribuer lors de l'incription", 1);
					
				
			}
		});
	
		envoyer.setPreferredSize(new Dimension(55, 28));
		envoyer.setMinimumSize(new Dimension(55, 28));
		envoyer.setMaximumSize(new Dimension(55, 28));
		envoyer.setForeground(new Color(255, 255, 240));
		envoyer.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		envoyer.setBackground(new Color(0, 128, 0));
		page1.add(envoyer, "5, 23, default, fill");
		
		scrollPane.setAutoscrolls(true);
		add(scrollPane, BorderLayout.SOUTH);
	}
	
	
	public Inscription(int matricule, String nom, String prenom, String sexe, String code, String contact, String adresse) {
		
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNouvelleInscription = new JLabel(" Modification des données de : "+nom+" "+prenom);
		lblNouvelleInscription.setIcon(new ImageIcon(Inscription.class.getResource("/icones/student-registratin.png")));
		lblNouvelleInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelleInscription.setForeground(new Color(30, 144, 255));
		lblNouvelleInscription.setFont(new Font("Century", Font.BOLD, 22));
		add(lblNouvelleInscription, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		page1 = new Inscription1(nom, prenom, sexe, code, contact, adresse);
		scrollPane.setViewportView(page1);
		
		JButton envoyer = new JButton("Modifier");
		envoyer.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "static-access" })
			public void actionPerformed(ActionEvent arg0) {
				
				if(verifierChamp() == "")
				{
					if(verifierFrais())
					{
						if(page1.lblCatgorie.isSelected()) {
							if(new Apprenant().updateApprenant(matricule, page1.nomTextField.getText(), page1.prenomTextField.getText(), page1.cbxSexe.getSelectedItem().toString(), page1.contactTuteurTextField_2.getText(), page1.txtAdresse.getText(),page1.codeText.getText()) == 1)
							{
								page1.viderChamp();
							}
						}else {
							if(new Apprenant().updateApprenant(matricule, page1.nomTextField.getText(), page1.prenomTextField.getText(), page1.cbxSexe.getSelectedItem().toString(), page1.contactTuteurTextField_2.getText(), page1.txtAdresse.getText()) == 1)
							{
								page1.viderChamp();
							}
						}
					}
					
				}
				
				else {
					DonneeStatiques.messageDialog("Veuillez renseigner les champs : "+verifierChamp(), 1);
				}
					
				
			}
		});
	
		envoyer.setPreferredSize(new Dimension(55, 28));
		envoyer.setMinimumSize(new Dimension(55, 28));
		envoyer.setMaximumSize(new Dimension(55, 28));
		envoyer.setForeground(new Color(255, 255, 240));
		envoyer.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		envoyer.setBackground(new Color(0, 128, 0));
		page1.add(envoyer, "5, 23, default, fill");
		
		scrollPane.setAutoscrolls(true);
		add(scrollPane, BorderLayout.SOUTH);
	}

	@SuppressWarnings("deprecation")
	public static String dateString(Date date) {
		
		return ""+date.getDay()+"/"+date.getMonth()+"/"+date.getYear()+"";
}
	
public  String verifierChamp() {
		String champ = "";
		if(this.page1.nomTextField.getText().isEmpty() || this.page1.nomTextField.getText() == null)
			champ += " - "+"  Nom " ;
		if(this.page1.prenomTextField.getText().isEmpty() || this.page1.prenomTextField.getText() == null)
			champ += " - "+"  Prenom " ;
		return champ;
	}


public  Boolean verifierFrais() {
	String champ = "";
	if(this.page1.frais.getText().isEmpty() || this.page1.frais.getText() == null || Integer.valueOf(this.page1.frais.getText()) < 0 )
	{
		DonneeStatiques.messageDialog("Renseigner un montant valide pour le frais de scolarité", 1);
		return false;
	}
	else
		if(Integer.valueOf(this.page1.frais.getText()) < DonneeStatiques.frais  && Integer.valueOf(this.page1.frais.getText()) > 0)
		{
			DonneeStatiques.messageDialog("Le montant des frais ne peut etre inférieur à "+DonneeStatiques.frais, 1);
			return false;
		}else
			return true;
}
}
