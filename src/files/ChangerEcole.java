package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Authentification;
import Model.DonneeConnexion;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChangerEcole extends JPanel {
	private JTextField login;
	private Principal parent;
	 
	/**
	 * Create the panel.
	 */
	public ChangerEcole(Principal parent) {
		this.parent = parent;
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblInformationsDeLcole = new JLabel("Se connecter \u00E0 une autre \u00E9cole");
		lblInformationsDeLcole.setIcon(new ImageIcon(ChangerEcole.class.getResource("/icones/school.png")));
		lblInformationsDeLcole.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformationsDeLcole.setForeground(new Color(30, 144, 255));
		lblInformationsDeLcole.setFont(new Font("Century", Font.BOLD, 22));
		add(lblInformationsDeLcole, BorderLayout.NORTH);
		
		JPanel panel0 = new JPanel();
		panel0.setBorder(null);
		panel0.setOpaque(false);
		panel0.setBackground(new Color(248, 248, 255));
		panel0.setBounds(238, 0, 609, 589);
		add(panel0, BorderLayout.CENTER);
		panel0.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("157px:grow"),
				ColumnSpec.decode("538px"),
				ColumnSpec.decode("max(84dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("433px:grow"),}));
		
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
		panel_1.setBounds(36, 50, 466, 249);
		panel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(110dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(3dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(17dlu;default)"),}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 4");
		
		JLabel lblAnneSolairee = new JLabel("Nom de l'école :");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 6, left, fill");
		
		JComboBox txtNomEcole = new JComboBox();
		txtNomEcole.setModel(new DonneeStatiques().dbList());
		txtNomEcole.setSelectedIndex(DonneeStatiques.db_index);
		txtNomEcole.setEditable(false);
		txtNomEcole.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		
		panel_1.add(txtNomEcole, "4, 6, 2, 1, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 8");
		
		JLabel lblLogin = new JLabel("Nom d'Utilisateur : ");
		lblLogin.setForeground(new Color(30, 144, 255));
		lblLogin.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblLogin, "2, 10, left, default");
		
		login = new JTextField("");
		login.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(login, "4, 10, fill, default");
		
		JLabel lblClasse = new JLabel("Mot de passe admin : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 12, left, fill");
		JPasswordField Password = new JPasswordField();
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(Password, "4, 12, fill, fill");
		
		JLabel errorLabel = new JLabel("Donn\u00E9es Incorrectes");
		errorLabel.setVisible(false);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		errorLabel.setForeground(new Color(255, 0, 0));
		panel_1.add(errorLabel, "4, 14");
		
		JButton btnEnregistrerLePaiement = new JButton("Valider");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(ChangerEcole.class.getResource("/icones/valider.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				int db = txtNomEcole.getSelectedIndex();
				DonneeStatiques.db = DonneeStatiques.dbListe.get(db);
				if(new Authentification().Authentifier(login.getText(),Password.getText()))
				{
				DonneeStatiques.db_index = db;
					errorLabel.setVisible(false);
					DonneeStatiques.messageDialog("Connexion réussie", 0);	
					ChangerEcole.this.parent.refreshAll();
					
				}else {
					errorLabel.setVisible(true);
					DonneeStatiques.db ="ECOLARBDD";
				}
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(187, 340, 164, 48);
		panel.add(btnEnregistrerLePaiement);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel0.add(panel_3, "3, 2, fill, fill");


	}
}
