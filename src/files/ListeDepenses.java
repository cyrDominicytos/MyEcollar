package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Depense;

import java.awt.event.ItemListener;
import java.util.Date;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ListeDepenses extends JPanel {
	private JTable table;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxAnneScolaire, cbxObjet;
	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ListeDepenses() {

		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblListeDeslves = new JLabel("Liste des dépenses");
		lblListeDeslves.setIcon(new ImageIcon(ListeDepenses.class.getResource("/icones/list_depenses.jpg")));
		lblListeDeslves.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDeslves.setForeground(new Color(30, 144, 255));
		lblListeDeslves.setFont(new Font("Century", Font.BOLD, 22));
		add(lblListeDeslves, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 95));
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(4dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(76dlu;default)"),
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(29dlu;default)"),
				ColumnSpec.decode("max(107dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("fill:default:grow"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("fill:4dlu"),}));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "5, 1");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7, "2, 2");
		
		JLabel lblNewLabel = new JLabel("Année scolaire : ");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNewLabel, "4, 2, left, fill");
		
		cbxAnneScolaire = new JComboBox();
		cbxAnneScolaire.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		cbxAnneScolaire.setModel(DonneeStatiques.anneeScolaire());
				cbxAnneScolaire.setBorder(null);
		panel_1.add(cbxAnneScolaire, "5, 2, fill, fill");
		
		JLabel lblNomDeLlve = new JLabel("Type : ");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "7, 2, left, fill");
		
		cbxObjet = new JComboBox();
		cbxObjet.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		cbxObjet.setModel(new DefaultComboBoxModel(new String[] {"Tous", "Fournitures scolaires", "Matériel didactique","Salaire", "Autres dépenses"}));
		panel_1.add(cbxObjet, "8, 2, fill, fill");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(DonneeStatiques.listeDepenses(new DonneeStatiques().anneeCourante));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setPreferredSize(new Dimension(10, 60));
		panel.add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("196px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("151px"),
				ColumnSpec.decode("199px:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("48px:grow"),}));
		
		JButton btnImprimer = new JButton(" Imprimer");
		btnImprimer.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
			       DonneeStatiques.imprimerDocumentPro(table, "Liste des dépenses : ",  "Imprimé le : "+DonneeStatiques.f.format(new Date())+"");
			}
		});
		
		textPane = new JTextPane();
		textPane.setText(DonneeStatiques.countLigneAffichee+" Dépense(s) trouv\u00E9(s)");
		textPane.setForeground(new Color(30, 144, 255));
		textPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textPane.setEditable(false);
		panel1.add(textPane, "1, 2, 3, 1, fill, fill");
		btnImprimer.setIcon(new ImageIcon(SeuilDePaiement.class.getResource("/icones/printer.png")));
		btnImprimer.setBackground(new Color(30, 144, 255));
		btnImprimer.setForeground(new Color(255, 255, 255));
		btnImprimer.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel1.add(btnImprimer, "4, 2, fill, fill");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel1.add(horizontalStrut_1, "5, 2, fill, fill");
		
		
		
		
		cbxObjet.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				switch (cbxObjet.getSelectedIndex()) {
				case 0:
					table.setModel(DonneeStatiques.listeDepenses(cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 1:
					table.setModel(DonneeStatiques.listeDepensesObjet(cbxObjet.getSelectedItem().toString(),cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 2:
					table.setModel(DonneeStatiques.listeDepensesObjet(cbxObjet.getSelectedItem().toString(),cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 3:
					table.setModel(DonneeStatiques.listeDepensesSalaire(cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 4:
					table.setModel(DonneeStatiques.listeDepensesObjetAutre(cbxAnneScolaire.getSelectedItem().toString()));
					break;
				default:
					break;
				}
				textPane.setText(DonneeStatiques.countLigneAffichee+" Dépense(s) trouv\u00E9(s)");
				ListeDepenses.this.revalidate();
			}
			
		});

		cbxAnneScolaire.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {	
				switch (cbxObjet.getSelectedIndex()) {
				case 0:
					table.setModel(DonneeStatiques.listeDepenses(cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 1:
					table.setModel(DonneeStatiques.listeDepensesObjet(cbxObjet.getSelectedItem().toString(),cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 3:
					table.setModel(DonneeStatiques.listeDepensesObjet(cbxObjet.getSelectedItem().toString(),cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 4:
					table.setModel(DonneeStatiques.listeDepensesSalaire(cbxAnneScolaire.getSelectedItem().toString()));
					break;
				case 5:
					table.setModel(DonneeStatiques.listeDepenses(cbxAnneScolaire.getSelectedItem().toString()));
					break;
				default:
					break;
				}
				textPane.setText(DonneeStatiques.countLigneAffichee+" Dépense(s) trouv\u00E9(s)");
				ListeDepenses.this.revalidate();
			}
		});
	}

}
