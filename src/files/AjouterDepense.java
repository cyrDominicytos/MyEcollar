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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Depense;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class AjouterDepense extends JPanel {
	private JTextField txtAutreMotif,  txtMontantDepense;
    @SuppressWarnings("rawtypes")
	private JComboBox cbxTypeDepense, enseignant;
    JTextPane description;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AjouterDepense() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblReinscrireUnElve = new JLabel("Enregistrer une dépense");
		lblReinscrireUnElve.setIcon(new ImageIcon(AjouterDepense.class.getResource("/icones/depense.jpg")));
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
		panel_1.setBounds(10, 26, 488, 387);
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 3");
		
		JLabel lblClasse = new JLabel("Type de dépense : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 5, left, fill");
		
		cbxTypeDepense = new JComboBox();
		cbxTypeDepense.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		cbxTypeDepense.setModel(new DefaultComboBoxModel(new String[] {"Fournitures scolaires", "Matériel didactique","Salaire", "Autres dépenses"}));
		cbxTypeDepense.setEditable(true);
		panel_1.add(cbxTypeDepense, "4, 5, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 7");
		
		txtAutreMotif = new JTextField();
		txtAutreMotif.setEnabled(false);
		txtAutreMotif.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		
		JLabel lblAutresMotif = new JLabel("Autres motifs : ");
		lblAutresMotif.setEnabled(false);
		lblAutresMotif.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		lblAutresMotif.setForeground(new Color(30, 144, 255));
		panel_1.add(lblAutresMotif, "2, 9, left, default");
		panel_1.add(txtAutreMotif, "4, 9, fill, default");
		txtAutreMotif.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 11");
		
		JLabel lblEnseignant = new JLabel("Enseignant :");
		lblEnseignant.setEnabled(false);
		lblEnseignant.setForeground(new Color(30, 144, 255));
		lblEnseignant.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblEnseignant, "2, 13, left, default");
		
		enseignant = new JComboBox();
		enseignant.setEnabled(false);
		enseignant.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		enseignant.setModel(DonneeStatiques.nomPrenomEnseignant());
		AutoCompleteDecorator.decorate(enseignant);
		panel_1.add(enseignant, "4, 13, fill, default");
		
		JLabel lblDesciptionplusDeDtails = new JLabel("Desciption(Plus de d\u00E9tails)");
		lblDesciptionplusDeDtails.setForeground(new Color(30, 144, 255));
		lblDesciptionplusDeDtails.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblDesciptionplusDeDtails, "2, 15, 1, 6");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "4, 15, 1, 6, fill, fill");
		
		description = new JTextPane();
		description.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		description.setAutoscrolls(true);
		scrollPane.setViewportView(description);
		
		JLabel lblNomDeLlve = new JLabel("Montant de la dépense : ");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 23, left, fill");
		
		txtMontantDepense = new JTextField();
		txtMontantDepense.setEditable(true);
		panel_1.add(txtMontantDepense, "4, 23, 1, 2, fill, fill");
		
		JButton btnEnregistrerLePaiement = new JButton("  Enregistrer");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (cbxTypeDepense.getSelectedIndex()) {
				case 0:
					new Depense().insertDepense(cbxTypeDepense.getSelectedItem().toString(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), "");
					break;
				case 1:
					new Depense().insertDepense(cbxTypeDepense.getSelectedItem().toString(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), "");
					break;
				case 2:
					new Depense().insertDepense(cbxTypeDepense.getSelectedItem().toString(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), DonneeStatiques.telephoneListe.get(enseignant.getSelectedIndex()));
					break;
				case 3:
					new Depense().insertDepense(txtAutreMotif.getText(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), "");
					break;
				default:
					break;
				}
				
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(190, 424, 178, 48);
		panel.add(btnEnregistrerLePaiement);
		
		JButton buttonPrint = new JButton("Imprimer");
		buttonPrint.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/printer.png")));
		buttonPrint.setForeground(new Color(248, 248, 255));
		buttonPrint.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		buttonPrint.setBackground(new Color(30, 144, 255));
		buttonPrint.setBounds(46, 424, 178, 48);
		//panel.add(buttonPrint);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel0.add(panel_3, "3, 2, fill, fill");
		
		cbxTypeDepense.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			switch (cbxTypeDepense.getSelectedIndex()) {
			case 2:
				enseignant.setEnabled(true);
				lblEnseignant.setEnabled(true);
				break;
			case 3:
				txtAutreMotif.setEnabled(true);
				lblAutresMotif.setEnabled(true);
				break;
			default:
				txtAutreMotif.setEnabled(false);
				lblAutresMotif.setEnabled(false);
				enseignant.setEnabled(false);
				lblEnseignant.setEnabled(false);
				break;
			}
			}
		});

	}
	
	
	
	
	
	
	public AjouterDepense(String contact, String nomPrenom) {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblReinscrireUnElve = new JLabel("Enregistrer une dépense");
		lblReinscrireUnElve.setIcon(new ImageIcon(AjouterDepense.class.getResource("/icones/depense.jpg")));
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
		panel_1.setBounds(22, 26, 463, 387);
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 3");
		
		JLabel lblClasse = new JLabel("Type de dépense : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 5, left, fill");
		
		cbxTypeDepense = new JComboBox();
		cbxTypeDepense.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		cbxTypeDepense.setModel(new DefaultComboBoxModel(new String[] {"Fournitures scolaires", "Matériel didactique","Salaire", "Autres dépenses"}));
		cbxTypeDepense.setSelectedItem("Salaire");
		cbxTypeDepense.setEditable(true);
		panel_1.add(cbxTypeDepense, "4, 5, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 7");
		
		txtAutreMotif = new JTextField();
		txtAutreMotif.setEnabled(false);
		txtAutreMotif.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		
		JLabel lblAutresMotif = new JLabel("Autres motifs : ");
		lblAutresMotif.setEnabled(false);
		lblAutresMotif.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		lblAutresMotif.setForeground(new Color(30, 144, 255));
		panel_1.add(lblAutresMotif, "2, 9, left, default");
		panel_1.add(txtAutreMotif, "4, 9, fill, default");
		txtAutreMotif.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 11");
		
		JLabel lblEnseignant = new JLabel("Enseignant :");
		lblEnseignant.setEnabled(false);
		lblEnseignant.setForeground(new Color(30, 144, 255));
		lblEnseignant.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblEnseignant, "2, 13, left, default");
		
		enseignant = new JComboBox();
		enseignant.setEnabled(false);
		enseignant.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		enseignant.setModel(DonneeStatiques.nomPrenomEnseignant());
		enseignant.setSelectedItem(enseignant);
		AutoCompleteDecorator.decorate(enseignant);
		panel_1.add(enseignant, "4, 13, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "4, 15, 1, 6, fill, fill");
		
		description = new JTextPane();
		description.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		description.setAutoscrolls(true);
		scrollPane.setViewportView(description);
		
		JLabel lblDesciptionplusDeDtails = new JLabel("Desciption(Plus de d\u00E9tails)");
		lblDesciptionplusDeDtails.setForeground(new Color(30, 144, 255));
		lblDesciptionplusDeDtails.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblDesciptionplusDeDtails, "2, 17, 1, 4");
		
		JLabel lblNomDeLlve = new JLabel("Montant de la dépense : ");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 23, left, fill");
		
		txtMontantDepense = new JTextField();
		txtMontantDepense.setEditable(true);
		panel_1.add(txtMontantDepense, "4, 23, 1, 2, fill, fill");
		
		JButton btnEnregistrerLePaiement = new JButton("  Enregistrer");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verifieVal())
				switch (cbxTypeDepense.getSelectedIndex()) {
				case 0:
					new Depense().insertDepense(cbxTypeDepense.getSelectedItem().toString(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), "");
					break;
				case 1:
					new Depense().insertDepense(cbxTypeDepense.getSelectedItem().toString(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), "");
					break;
				case 2:
					new Depense().insertDepense(cbxTypeDepense.getSelectedItem().toString(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), DonneeStatiques.telephoneListe.get(enseignant.getSelectedIndex()));
					break;
				case 3:
					new Depense().insertDepense(txtAutreMotif.getText(), description.getText(), Integer.parseInt(txtMontantDepense.getText()), "");
					break;
				default:
					break;
				}
				
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(190, 424, 178, 48);
		panel.add(btnEnregistrerLePaiement);
		
		JButton buttonPrint = new JButton("Imprimer");
		buttonPrint.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/printer.png")));
		buttonPrint.setForeground(new Color(248, 248, 255));
		buttonPrint.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		buttonPrint.setBackground(new Color(30, 144, 255));
		buttonPrint.setBounds(46, 424, 178, 48);
		//panel.add(buttonPrint);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel0.add(panel_3, "3, 2, fill, fill");
		
		cbxTypeDepense.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			switch (cbxTypeDepense.getSelectedIndex()) {
			case 2:
				enseignant.setEnabled(true);
				lblEnseignant.setEnabled(true);
				break;
			case 3:
				txtAutreMotif.setEnabled(true);
				lblAutresMotif.setEnabled(true);
				break;
			default:
				txtAutreMotif.setEnabled(false);
				lblAutresMotif.setEnabled(false);
				enseignant.setEnabled(false);
				lblEnseignant.setEnabled(false);
				break;
			}
			}
		});

	}
	
	public Boolean verifieVal()
	{
		String mt = txtMontantDepense.getText();
		if(mt.isEmpty() ||mt == null || Integer.valueOf(mt) <= 0)
		{
			DonneeStatiques.messageDialog("Renseigner un montant valide", 1);
			return false;
		}
			return true;
		
	}
}
