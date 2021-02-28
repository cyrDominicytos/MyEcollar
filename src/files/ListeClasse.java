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
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ItemListener;
import java.util.Date;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ListeClasse extends JPanel {
	private JTable table;
	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	JComboBox cbxAnneScolaire;
	
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public ListeClasse() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblListeDesClasses = new JLabel("  Liste des classes");
		lblListeDesClasses.setIcon(new ImageIcon(ListeClasse.class.getResource("/icones/list_class.png")));
		lblListeDesClasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesClasses.setForeground(new Color(30, 144, 255));
		lblListeDesClasses.setFont(new Font("Century", Font.BOLD, 22));
		add(lblListeDesClasses, BorderLayout.NORTH);
		
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
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(29dlu;default)"),
				ColumnSpec.decode("max(69dlu;default)"),},
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
		panel_1.add(lblNewLabel, "5, 2, left, fill");
		
		cbxAnneScolaire = new JComboBox();
		AutoCompleteDecorator.decorate(cbxAnneScolaire);
		cbxAnneScolaire.setEditable(true);
		cbxAnneScolaire.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				table.setModel(DonneeStatiques.listeClasse(cbxAnneScolaire.getSelectedItem().toString()));
				textPane.setText(DonneeStatiques.countLigneAffichee+" Classes ouvertes");
				ListeClasse.this.revalidate();
			}
			
		});
		cbxAnneScolaire.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		cbxAnneScolaire.setModel(DonneeStatiques.anneeScolaire());
		cbxAnneScolaire.setBorder(null);
		cbxAnneScolaire.setModel(new DonneeStatiques().anneeScolaire());
		panel_1.add(cbxAnneScolaire, "6, 2, fill, fill");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		table.setModel(DonneeStatiques.listeClasse(new DonneeStatiques().anneeCourante));
			
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(143);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setToolTipText("Action\r\n");
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(56dlu;default):grow"),
				ColumnSpec.decode("102px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("190px"),
				ColumnSpec.decode("max(49dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("fill:39px:grow"),}));
		
		JButton imprimer = new JButton(" Imprimer");
		imprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       String annee = cbxAnneScolaire.getSelectedItem().toString();
			       DonneeStatiques.imprimerDocumentPro(table, "Liste des classes ",  "Imprimé le : "+DonneeStatiques.f.format(new Date())+"");
			}
		});
		
		textPane = new JTextPane();
		textPane.setText(DonneeStatiques.countLigneAffichee+" Classes ouvertes");
		textPane.setForeground(new Color(30, 144, 255));
		textPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textPane.setEditable(false);
		panel_2.add(textPane, "1, 2, fill, fill");
		panel_2.add(imprimer, "2, 2, left, fill");
		imprimer.setForeground(Color.WHITE);
		imprimer.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		imprimer.setBackground(new Color(30, 144, 255));
		
		JButton buttonPaiement = new JButton();
		buttonPaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rows[] = table.getSelectedRows();
				
				if(rows.length > 0)
				{
					String classe = table.getValueAt(rows[0], 0).toString();
					String scolarite = table.getValueAt(rows[0], 2).toString();
					ListeClasse.this.removeAll();
					ListeClasse.this.add(new NouvelleClasse(classe, scolarite));
					ListeClasse.this.revalidate();
				}
			}
		});
		buttonPaiement.setText("Modifier la scolarité");
		buttonPaiement.setForeground(Color.WHITE);
		buttonPaiement.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		buttonPaiement.setBackground(new Color(30, 144, 255));
		panel_2.add(buttonPaiement, "4, 2, fill, fill");
		

	}

}
