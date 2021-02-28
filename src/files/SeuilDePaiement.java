package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.file.Files;
import java.util.Date;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Scolarite;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class SeuilDePaiement extends JPanel {
	private JTextField scolariteTextField;
	private JTable table;
	private JTextPane textPane;
	@SuppressWarnings("rawtypes")
	JComboBox cbxClasse, cbxSeuil, cbxEleve, cbxAnnee;
	JCheckBox checkBox;
	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public SeuilDePaiement() {
		setBackground(new Color(255, 255, 255));
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblSeuilDePaiement = new JLabel("Seuil de paiement des elèves");
		lblSeuilDePaiement.setIcon(new ImageIcon(SeuilDePaiement.class.getResource("/icones/check_pai.png")));
		lblSeuilDePaiement.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeuilDePaiement.setForeground(new Color(30, 144, 255));
		lblSeuilDePaiement.setFont(new Font("Century", Font.BOLD, 22));
		add(lblSeuilDePaiement, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 95));
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(43dlu;default)"),
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(80dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(49dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(33dlu;default)"),
				ColumnSpec.decode("max(59dlu;default)"),
				ColumnSpec.decode("max(4dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(76dlu;default)"),
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(29dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(113dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("fill:default:grow"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("fill:4dlu"),}));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "10, 1");
		
		JLabel lblNewLabel = new JLabel("Scolarit\u00E9");
		lblNewLabel.setToolTipText("Scolarit\u00E9 de la Classe");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNewLabel, "1, 2, left, fill");
		
		scolariteTextField = new JTextField();
		scolariteTextField.setToolTipText("Scolarit\u00E9 de la Classe");
		scolariteTextField.setEditable(false);
		scolariteTextField.setBorder(new LineBorder(new Color(30, 144, 255), 2, true));
		panel_1.add(scolariteTextField, "3, 2, fill, fill");
		scolariteTextField.setColumns(10);
		
		JLabel lblAnne = new JLabel("Ann\u00E9e : ");
		lblAnne.setForeground(new Color(30, 144, 255));
		lblAnne.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnne, "4, 2, right, default");
		
		cbxAnnee = new JComboBox();
		panel_1.add(cbxAnnee, "6, 2, fill, default");
		
		JLabel lblClasse = new JLabel("Classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "9, 2, right, fill");
		
		cbxClasse = new JComboBox();
		panel_1.add(cbxClasse, "10, 2, right, fill");
		
		JLabel lblSeuil = new JLabel("Seuil :");
		lblSeuil.setEnabled(false);
		lblSeuil.setForeground(new Color(30, 144, 255));
		lblSeuil.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblSeuil, "12, 2, right, default");
		
		cbxSeuil = new JComboBox();
		cbxSeuil.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		cbxSeuil.setModel(new DefaultComboBoxModel(new String[] {"Sans contrainte","A Rien Payé", "A Payé Au plus 5%", "A Payé Au plus 10%", "A Payé Au plus 15%", "A Payé Au plus 20%", "A Payé Au plus 25%", "A Payé Au plus 30%", "A Payé Au plus 35%", "A Payé Au plus 40%", "A Payé Au plus 45%", "A Payé Au plus 50%", "A Payé Au plus 55%", "A Payé Au plus 60%", "A Payé Au plus 65%", "A Payé Au plus 70%", "A Payé Au plus 75%", "A Payé Au plus 80%", "A Payé Au plus 85%", "A Payé Au plus 90%", "A Payé Au plus 95%",  "A Payé moins de 100%", "A Tout Payé"}));
		panel_1.add(cbxSeuil, "13, 2, fill, default");
		
		JLabel lblNomDeLlve = new JLabel("Elève :");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "15, 2, left, fill");
		
		cbxEleve = new JComboBox();
		panel_1.add(cbxEleve, "18, 2, fill, fill");
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		cbxClasse.setModel(DonneeStatiques.classeNiveau());
		cbxAnnee.setModel(DonneeStatiques.anneeScolaire());
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(35);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
			scolariteTextField.setText(String.valueOf(new Scolarite().selectScolariteClasseAnnee(cbxAnnee.getSelectedItem().toString(), cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString())));
			cbxEleve.setModel(new DonneeStatiques().nomPrenomApprenantListe(cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
			table.setModel(DonneeStatiques.listeSeuilPaiementTous(cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(),SeuilDePaiement.genererCondition(cbxSeuil.getSelectedIndex())));
			
		
		
		cbxClasse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxEleve.setModel(new DonneeStatiques().nomPrenomApprenantListe(cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
				cbxSeuil.setSelectedIndex(0);
				scolariteTextField.setText(String.valueOf(new Scolarite().selectScolariteClasseAnnee(cbxAnnee.getSelectedItem().toString(), cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString())));
				table.setModel(DonneeStatiques.listeSeuilPaiementTous(cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), SeuilDePaiement.genererCondition(cbxSeuil.getSelectedIndex())));
				textPane.setText(DonneeStatiques.countLigneAffichee+" Seuil(s) trouv\u00E9(s)");
				SeuilDePaiement.this.revalidate();
			}
		});
		
		cbxAnnee.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxEleve.setModel(new DonneeStatiques().nomPrenomApprenantListe(cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
				cbxSeuil.setSelectedIndex(0);
				scolariteTextField.setText(String.valueOf(new Scolarite().selectScolariteClasseAnnee(cbxAnnee.getSelectedItem().toString(), cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString())));
				table.setModel(DonneeStatiques.listeSeuilPaiementTous(cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), SeuilDePaiement.genererCondition(cbxSeuil.getSelectedIndex())));
				textPane.setText(DonneeStatiques.countLigneAffichee+" Seuil(s) trouv\u00E9(s)");
				SeuilDePaiement.this.revalidate();
			}
		});
		
		cbxEleve.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxSeuil.setSelectedIndex(0);
				if(cbxEleve.getSelectedIndex() > 0)
					table.setModel(DonneeStatiques.listeSeuilPaiementApprenant(cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), DonneeStatiques.matriculeListe.get(cbxEleve.getSelectedIndex() -1), SeuilDePaiement.genererCondition(cbxSeuil.getSelectedIndex())));
				else
					table.setModel(DonneeStatiques.listeSeuilPaiementTous(cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), SeuilDePaiement.genererCondition(cbxSeuil.getSelectedIndex())));
				textPane.setText(DonneeStatiques.countLigneAffichee+" Seuil(s) trouv\u00E9(s)");
				SeuilDePaiement.this.revalidate();
				
			}
		});
		
		cbxSeuil.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxEleve.setSelectedIndex(0);
				table.setModel(DonneeStatiques.listeSeuilPaiementTous(cbxClasse.getSelectedItem() == null ?(" ") : cbxClasse.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), SeuilDePaiement.genererCondition(cbxSeuil.getSelectedIndex())));
				textPane.setText(DonneeStatiques.countLigneAffichee+" Seuil(s) trouv\u00E9(s)");
				SeuilDePaiement.this.revalidate();
			}
		});
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setPreferredSize(new Dimension(10, 60));
		panel.add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("196px:grow"),
				ColumnSpec.decode("151px"),
				ColumnSpec.decode("199px:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("48px:grow"),}));
		
		JButton btnImprimer = new JButton(" Imprimer");
		btnImprimer.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				 	String classe = cbxClasse.getSelectedItem().toString();
				    DonneeStatiques.imprimerDocumentPro(table, "Seuil de paiement des elèves : "+classe,  "Imprimé le : "+DonneeStatiques.f.format(new Date())+"");
			       
			}
		});
		
		textPane = new JTextPane();
		textPane.setText(DonneeStatiques.countLigneAffichee+" Seuil(s) trouv\u00E9(s)");
		textPane.setForeground(new Color(30, 144, 255));
		textPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textPane.setEditable(false);
		panel1.add(textPane, "1, 2, fill, fill");
		btnImprimer.setIcon(new ImageIcon(SeuilDePaiement.class.getResource("/icones/printer.png")));
		btnImprimer.setBackground(new Color(30, 144, 255));
		btnImprimer.setForeground(new Color(255, 255, 255));
		btnImprimer.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel1.add(btnImprimer, "2, 2, fill, fill");

	}
	
	public static String genererCondition(int index) {
		String condition="";
		switch (index) {
		case 0:
			condition = "";
			break;
		case 1:
			condition = " AND POURCENTAGE <= 0";
			break;
		case 2:
			condition = " AND POURCENTAGE BETWEEN 0 AND 5";
			break;
		case 3:
			condition = " AND POURCENTAGE BETWEEN 0 AND 10";
			break;
		case 4:
			condition = " AND POURCENTAGE BETWEEN 0 AND 15";
			break;
		case 5:
			condition = " AND POURCENTAGE BETWEEN 0 AND 20";
			break;
		case 6:
			condition = " AND POURCENTAGE BETWEEN 0 AND 25";
			break;
		case 7:
			condition = " AND POURCENTAGE BETWEEN 0 AND 30";
			break;
		case 8:
			condition = " AND POURCENTAGE BETWEEN 0 AND 35";
			break;
		case 9:
			condition = " AND POURCENTAGE BETWEEN 0 AND 40";
			break;
		case 10:
			condition = " AND POURCENTAGE BETWEEN 0 AND 45";
			break;
		case 11:
			condition = " AND POURCENTAGE BETWEEN 0 AND 50";
			break;
		case 12:
			condition = " AND POURCENTAGE BETWEEN 0 AND 55";
			break;
		case 13:
			condition = " AND POURCENTAGE BETWEEN 0 AND 60";
			break;
		case 14:
			condition = " AND POURCENTAGE BETWEEN 0 AND 65";
			break;
		case 15:
			condition = " AND POURCENTAGE BETWEEN 0 AND 70";
			break;
		case 16:
			condition = " AND POURCENTAGE BETWEEN 0 AND 75";
			break;
		case 17:
			condition = " AND POURCENTAGE BETWEEN 0 AND 80";
			break;
		case 18:
			condition = " AND POURCENTAGE BETWEEN 0 AND 85";
			break;
		case 19:
			condition = " AND POURCENTAGE BETWEEN 0 AND 90";
			break;
		case 20:
			condition = " AND POURCENTAGE BETWEEN 0 AND 95";
			break;
		case 21:
			
			condition = " AND POURCENTAGE BETWEEN 0 AND 99.9999";
			break;
		case 22:
			condition = " AND POURCENTAGE >= 100";
			break;
		default:
			condition = "";
			break;
			
			
			
		}
		//System.out.println(condition);
		return condition;
	}
}
