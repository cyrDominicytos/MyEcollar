package files;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Payement;

@SuppressWarnings("serial")
public class EnregistrerPaiement extends JPanel {
	private JTextField montantTextField;

	/**
	 * Create the panel.
	 */
	JComboBox anneeComboBox,  cbxClasse,cbxNomEleve;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EnregistrerPaiement() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(219, 0, 628, 589);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(null);
		label.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/gg1.png")));
		label.setBounds(237, 42, 134, 125);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(56, 121, 525, 357);
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
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 4");
		
		JLabel lblAnneSolairee = new JLabel("Année Solairee : ");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 6, left, fill");
		
		anneeComboBox = new JComboBox();
		anneeComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenant(cbxClasse.getSelectedItem().toString(), anneeComboBox.getSelectedItem().toString()));
			}
		});
		anneeComboBox.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		anneeComboBox.setModel(DonneeStatiques.anneeScolaire());
		
		panel_1.add(anneeComboBox, "4, 6, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 8");
		
		JLabel lblClasse = new JLabel("Classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 10, left, fill");
		cbxClasse = new JComboBox();
		cbxClasse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenant(cbxClasse.getSelectedItem().toString(), anneeComboBox.getSelectedItem().toString()));
				cbxNomEleve.setEnabled(true);
				montantTextField.setEnabled(true);
			}
		});
		cbxClasse.setMaximumRowCount(10);
		cbxClasse.setEditable(true);
		cbxClasse.setModel(DonneeStatiques.classeNiveau());
				panel_1.add(cbxClasse, "4, 10, fill, fill");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 12");
		
		JLabel lblNomDeLlve = new JLabel("Nom de l'élève :");
		lblNomDeLlve.setEnabled(false);
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 14, right, fill");
		
		cbxNomEleve = new JComboBox();
		cbxNomEleve.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//lblMontant.setEnabled(true);
				montantTextField.setEnabled(true);
			}
		});
		cbxNomEleve.setEditable(true);
		if(cbxClasse.getSelectedItem() != null)
		cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenant(cbxClasse.getSelectedItem().toString(), anneeComboBox.getSelectedItem().toString()));
		cbxNomEleve.setEnabled(false);
		AutoCompleteDecorator.decorate(cbxNomEleve);
		panel_1.add(cbxNomEleve, "4, 14, fill, fill");
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_6, "4, 16");
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setEnabled(false);
		lblMontant.setForeground(new Color(30, 144, 255));
		lblMontant.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblMontant, "2, 18, left, fill");
		
		montantTextField = new JTextField();
		montantTextField.setEnabled(false);
		panel_1.add(montantTextField, "4, 18, fill, fill");
		montantTextField.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "4, 19");
		
		JButton btnEnregistrerLePaiement = new JButton("Valider");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verifieVal())
				new Payement().insertPayement(DonneeStatiques.matriculeListe.get(cbxNomEleve.getSelectedIndex()), anneeComboBox.getSelectedItem().toString(), Integer.parseInt(montantTextField.getText()));
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		//btnEnregistrerLePaiement.setBounds(340, 501, 164, 48);
		btnEnregistrerLePaiement.setBounds(200, 501, 164, 48);
		
		panel.add(btnEnregistrerLePaiement);
		
		JButton buttonPrint = new JButton("Imprimer");
		buttonPrint.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/printer.png")));
		buttonPrint.setForeground(new Color(248, 248, 255));
		buttonPrint.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		buttonPrint.setBackground(new Color(30, 144, 255));
		buttonPrint.setBounds(114, 501, 164, 48);
		//panel.add(buttonPrint);
	
	}
	
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EnregistrerPaiement(int matricule, String nomPrenom, String classe) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(238, 0, 609, 589);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(null);
		label.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/gg1.png")));
		label.setBounds(237, 42, 134, 125);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(104, 121, 400, 357);
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
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 4");
		
		JLabel lblAnneSolairee = new JLabel("Année Solairee : ");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 6, left, fill");
		
		anneeComboBox = new JComboBox();
		anneeComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenant(cbxClasse.getSelectedItem().toString(), anneeComboBox.getSelectedItem().toString()));
			}
		});
		anneeComboBox.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		anneeComboBox.setModel(DonneeStatiques.anneeScolaire());
		
		panel_1.add(anneeComboBox, "4, 6, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 8");
		
		JLabel lblClasse = new JLabel("Classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 10, left, fill");
		cbxClasse = new JComboBox();
		cbxClasse.setMaximumRowCount(10);
		cbxClasse.setEditable(true);
		cbxClasse.setModel(DonneeStatiques.classeNiveau());
		cbxClasse.setSelectedItem(classe);
				panel_1.add(cbxClasse, "4, 10, fill, fill");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 12");
		
		JLabel lblNomDeLlve = new JLabel("Nom de l'élève :");
		lblNomDeLlve.setEnabled(false);
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 14, right, fill");
		
		cbxNomEleve = new JComboBox();
		cbxNomEleve.setEditable(true);
		cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenant(cbxClasse.getSelectedItem().toString(), anneeComboBox.getSelectedItem().toString()));
		cbxNomEleve.setSelectedItem(nomPrenom);
		cbxNomEleve.setEnabled(true);
		panel_1.add(cbxNomEleve, "4, 14, fill, fill");
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_6, "4, 16");
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setForeground(new Color(30, 144, 255));
		lblMontant.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblMontant, "2, 18, left, fill");
		
		montantTextField = new JTextField();
		panel_1.add(montantTextField, "4, 18, fill, fill");
		montantTextField.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "4, 19");
		cbxClasse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxNomEleve.setModel(DonneeStatiques.nomPrenomApprenant(cbxClasse.getSelectedItem().toString(), anneeComboBox.getSelectedItem().toString()));
				cbxNomEleve.setEnabled(true);
				montantTextField.setEnabled(true);
			}
		});
		cbxNomEleve.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				montantTextField.setEnabled(true);
			}
		});
		JButton btnEnregistrerLePaiement = new JButton("Valider");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verifieVal())
				new Payement().insertPayement(DonneeStatiques.matriculeListe.get(cbxNomEleve.getSelectedIndex()), anneeComboBox.getSelectedItem().toString(), Integer.parseInt(montantTextField.getText()));
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(340, 501, 164, 48);
		panel.add(btnEnregistrerLePaiement);
		
		JButton buttonPrint = new JButton("Imprimer");
		buttonPrint.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/printer.png")));
		buttonPrint.setForeground(new Color(248, 248, 255));
		buttonPrint.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		buttonPrint.setBackground(new Color(30, 144, 255));
		buttonPrint.setBounds(114, 501, 164, 48);
		panel.add(buttonPrint);
	
	}
	
	public Boolean verifieVal()
	{
		String mt = montantTextField.getText();
		if(mt.isEmpty() ||mt == null || Integer.valueOf(mt) <= 0)
		{
			DonneeStatiques.messageDialog("Renseigner un montant valide", 1);
			return false;
		}
			return true;
		
	}
}
