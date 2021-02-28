package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class ListerPaiement extends JPanel {
	private JTable table;
	@SuppressWarnings("rawtypes")
	JComboBox cbxAnnee ,cbxEleve, cbxClasses;
	JDateChooser cbxDate;
	JCheckBox chckbxTous,  chckbxNewCheckBox;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public ListerPaiement() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblListeDesPaiements = new JLabel("  Liste des paiements");
		lblListeDesPaiements.setIcon(new ImageIcon(ListerPaiement.class.getResource("/icones/listePaie.png")));
		lblListeDesPaiements.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesPaiements.setForeground(new Color(30, 144, 255));
		lblListeDesPaiements.setFont(new Font("Century", Font.BOLD, 22));
		add(lblListeDesPaiements, BorderLayout.NORTH);
		
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
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(33dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(84dlu;default)"),
				ColumnSpec.decode("max(5dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(76dlu;default)"),
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(29dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(113dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("fill:default:grow"),
				RowSpec.decode("max(20dlu;default):grow"),
				RowSpec.decode("fill:4dlu"),}));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "10, 1");
		
		JLabel lblNewLabel = new JLabel("Année scolaire : ");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNewLabel, "1, 2, left, fill");
		
		cbxAnnee = new JComboBox();
		cbxAnnee.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		cbxAnnee.setModel(DonneeStatiques.anneeScolaire());
		cbxAnnee.setEditable(false);
		panel_1.add(cbxAnnee, "3, 2, fill, fill");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7, "6, 2");
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setForeground(new Color(30, 144, 255));
		lblDate.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblDate, "7, 2, right, default");
		
		cbxDate= new JDateChooser();
		cbxDate.setDate(new Date());
		cbxDate.setDateFormatString("d/MM/yyyy");
		cbxDate.setEnabled(false);
		cbxDate.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
	
		chckbxTous = new JCheckBox("Toutes");
		chckbxTous.setSelected(true);
		chckbxTous.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int i = arg0.getStateChange();
				if(i == ItemEvent.SELECTED) {
					cbxDate.setEnabled(false);
					table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
					ListerPaiement.this.revalidate();
				}else {
					cbxDate.setEnabled(true);
					chckbxNewCheckBox.setSelected(true);
					table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), DonneeStatiques.f2.format(cbxDate.getDate())));	
					ListerPaiement.this.revalidate();
				}
			}
			
		});
		
		panel_1.add(chckbxTous, "9, 2");
		
		panel_1.add(cbxDate, "10, 2, fill, default");
		
		JLabel lblClasse = new JLabel("Classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "12, 2, right, fill");
		
		cbxClasses = new JComboBox();
		cbxClasses.setModel(DonneeStatiques.classeNiveau());
		panel_1.add(cbxClasses, "13, 2, right, fill");
		
		JLabel lblNomDeLlve = new JLabel("Elève :");
		lblNomDeLlve.setEnabled(false);
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "15, 2, left, fill");
		
		cbxEleve = new JComboBox();
		cbxEleve.setModel(DonneeStatiques.nomPrenomApprenantListe(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
		panel_1.add(cbxEleve, "18, 2, fill, fill");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(35);
		table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(236);
		table.getColumnModel().getColumn(2).setPreferredWidth(121);
		//table.getColumnModel().getColumn(3).setPreferredWidth(96);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		cbxEleve.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				chckbxTous.setSelected(true);
				if(cbxEleve.getSelectedIndex() > 0)
					table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), DonneeStatiques.matriculeListe.get(cbxEleve.getSelectedIndex() -1)));
				else
					table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
				ListerPaiement.this.revalidate();
			}
		
		});
		
		cbxClasses.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//chckbxNewCheckBox.setSelected(true);
				cbxEleve.setModel(DonneeStatiques.nomPrenomApprenantListe(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
				table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
				ListerPaiement.this.revalidate();
			}
		});

		cbxDate.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString(), DonneeStatiques.f2.format(cbxDate.getDate())));
				ListerPaiement.this.revalidate();
			}
		});
		
		cbxAnnee.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxEleve.setModel(DonneeStatiques.nomPrenomApprenantListe(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
				table.setModel(DonneeStatiques.listePaiement(cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnnee.getSelectedItem().toString()));
				ListerPaiement.this.revalidate();
			}
		});
	}

}
