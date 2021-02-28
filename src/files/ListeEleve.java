package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
/*import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Apprenant;

import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.BoxLayout;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ListeEleve extends JPanel {
	protected JTable table;
	private JTextPane tableMessagePanel;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxEleve, cbxAnneScolaire, cbxOrphelin, cbxClasses;
	private Principal parent;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public ListeEleve(Principal parent) {
		this.parent = parent;
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblListeDeslves = new JLabel("  Liste des élèves");
		lblListeDeslves.setIcon(new ImageIcon(ListeEleve.class.getResource("/icones/liste_Eleves.png")));
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
				ColumnSpec.decode("max(43dlu;default)"),
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(80dlu;default)"),
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(36dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(4dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(56dlu;default)"),
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(29dlu;default)"),
				ColumnSpec.decode("max(146dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("fill:max(30dlu;default):grow"),
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("fill:4dlu"),}));
		
		JLabel lblNewLabel = new JLabel("Année scolaire : ");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNewLabel, "1, 2, left, fill");
		
		cbxAnneScolaire = new JComboBox();
		cbxAnneScolaire.setEditable(true);
		AutoCompleteDecorator.decorate(cbxAnneScolaire);
		cbxAnneScolaire.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		cbxAnneScolaire.setModel(new DonneeStatiques().anneeScolaire());
		
		cbxAnneScolaire.setBorder(null);
		panel_1.add(cbxAnneScolaire, "3, 2, fill, fill");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7, "4, 2");
		
		JLabel lblOrphelin = new JLabel("Orphelin : ");
		lblOrphelin.setForeground(new Color(30, 144, 255));
		lblOrphelin.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblOrphelin, "6, 2, left, default");
		
		cbxOrphelin = new JComboBox();
		cbxOrphelin.setModel(new DefaultComboBoxModel(new String[] {"Tous", "Orphelin", "Non Orphelin"}));
		cbxOrphelin.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		panel_1.add(cbxOrphelin, "7, 2, fill, default");
		
		JLabel lblClasse = new JLabel("Classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "10, 2, right, fill");
		
	    cbxClasses = new JComboBox();
		cbxClasses.setEditable(true);
		AutoCompleteDecorator.decorate(cbxClasses);
		cbxClasses.setModel(new DonneeStatiques().classeNiveau());
		cbxClasses.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		
		panel_1.add(cbxClasses, "11, 2, fill, fill");
		
		JLabel lblNomDeLlve = new JLabel("Elève :");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "13, 2, left, fill");
		
	    cbxEleve = new JComboBox();
		cbxEleve.setEditable(true);
		
		cbxEleve.setModel(DonneeStatiques.nomPrenomApprenantListe( cbxClasses.getSelectedItem()== null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnneScolaire.getSelectedItem() == null ?(" ") : cbxAnneScolaire.getSelectedItem().toString() ));
		
		//cbxEleve.setModel(DonneeStatiques.nomPrenomApprenant(cbxClasses.getSelectedItem().toString(), cbxAnneScolaire.getSelectedItem().toString()));
		AutoCompleteDecorator.decorate(cbxEleve);
		cbxEleve.setFont(new Font("Sitka Banner", Font.PLAIN, 16));
		panel_1.add(cbxEleve, "14, 2, fill, fill");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(35);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		
			table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem() == null ?(" ") : cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem() == null ?(" ") : cbxClasses.getSelectedItem().toString() ));
		
		table.getColumnModel().getColumn(1).setPreferredWidth(240);
		table.getColumnModel().getColumn(3).setPreferredWidth(121);
		table.setFillsViewportHeight(true);
		
		scrollPane.setViewportView(table);
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(10, 50));
			   	
		panel1.setBackground(Color.WHITE);
		//panel1.setPreferredSize(new Dimension(10, 60));
		panel.add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setToolTipText("Action\r\n");
		panel1.add(panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(56dlu;default):grow"),
				ColumnSpec.decode("102px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("265px"),
				ColumnSpec.decode("max(49dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("fill:39px:grow"),}));
		
		JButton button = new JButton(" Imprimer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				       String classe = cbxClasses.getSelectedItem().toString();
				       String annee = cbxAnneScolaire.getSelectedItem().toString();
				       DonneeStatiques.imprimerDocumentPro(table, "Liste des élèves : "+classe,  "Imprimé le : "+DonneeStatiques.f.format(new Date())+"");
			}
		});
		
		tableMessagePanel = new JTextPane();
		tableMessagePanel.setEditable(false);
		tableMessagePanel.setForeground(new Color(30, 144, 255));
		tableMessagePanel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		tableMessagePanel.setText(DonneeStatiques.countLigneAffichee+" El\u00E8ves trouv\u00E9s");
		panel_2.add(tableMessagePanel, "1, 2, fill, fill");
		panel_2.add(button, "2, 2, left, fill");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		button.setBackground(new Color(30, 144, 255));
		
		JComboBox buttonPaiement = new JComboBox();
		buttonPaiement.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int rows[] = table.getSelectedRows();
				if(rows.length > 0)
				{
					int matricule = Integer.valueOf(table.getValueAt(rows[0], 0).toString());
					String nomPrenom = table.getValueAt(rows[0], 1).toString();
					String classe = cbxClasses.getSelectedItem().toString();
					String anneeScolaire = cbxAnneScolaire.getSelectedItem().toString();
					
					switch (buttonPaiement.getSelectedIndex()) {
					case 0:
						
						break;
					case 1://Modification des infos de l'apprenant
						try {
							ResultSet result = new Apprenant().selectApprenantInfos(matricule);
							if (result.next()) {				
								ListeEleve.this.removeAll();
								String ophelin =  result.getString("CODEOPHELIN");
								ListeEleve.this.add(new Inscription(result.getInt("MATRICULE"), result.getString("NOM"), result.getString("PRENOM"), result.getString("SEXE"), ophelin == null ? ("") : (result.getString("CODEOPHELIN")), result.getString("CONTACT"), result.getString("ADRESSE")));
								ListeEleve.this.revalidate();
							}

						} catch (SQLException e) {
							DonneeStatiques.messageDialog(e.getMessage(), 2);
						} 
						break;
					case 2://Enregistrer Payement
						ListeEleve.this.removeAll();
						ListeEleve.this.add(new EnregistrerPaiement(matricule, nomPrenom,classe ));
						ListeEleve.this.revalidate();
						
						break;
						case 3:  //Reinscrire l'apprenant
							if(anneeScolaire.equalsIgnoreCase(new DonneeStatiques().anneeCourante))
							{//Modification de la courante reinscription de l'apprenant
								int frais = new Model.Inscription().selectFraisApprenant(matricule, anneeScolaire);				
								ListeEleve.this.removeAll();
								ListeEleve.this.add(new Reinscription(matricule, nomPrenom, "", classe, frais, true, ListeEleve.this.parent));
								ListeEleve.this.revalidate();
							}else {
								//Reinscription de l'apprenant pour l'annee courante
								try {
									ResultSet result = new Model.Inscription().selectDerniereInscription(matricule);
									if (result.next()) {
										if(result.getString("ANNEESCOLAIRE").equalsIgnoreCase(new DonneeStatiques().anneeCourante))
										{
											ListeEleve.this.removeAll();
											ListeEleve.this.add(new Reinscription(matricule, nomPrenom, classe, result.getString("CLASSE"), result.getInt("FRAIS"), true,ListeEleve.this.parent));
											ListeEleve.this.revalidate();
										}else {
											ListeEleve.this.removeAll();
											ListeEleve.this.add(new Reinscription(matricule, nomPrenom, result.getString("CLASSE"), "", result.getInt("FRAIS"), false,ListeEleve.this.parent));
											ListeEleve.this.revalidate();
										}
									}

								} catch (SQLException e) {
									DonneeStatiques.messageDialog(e.getMessage(), 2);
								}
							}
							
						break;
					default:
						
						break;
					}
				}
				
								
			}
		});
		buttonPaiement.setModel(new DefaultComboBoxModel(new String[] {"Actions","Modifier les informations", "Enregistrer un paiement", "Réinscrire"}));
		buttonPaiement.setForeground(Color.WHITE);
		buttonPaiement.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		buttonPaiement.setBackground(new Color(30, 144, 255));
		panel_2.add(buttonPaiement, "4, 2, fill, fill");
		
		cbxAnneScolaire.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxEleve.setModel(DonneeStatiques.nomPrenomApprenantListe( cbxClasses.getSelectedItem().toString() == null ?(" ") : cbxClasses.getSelectedItem().toString(), cbxAnneScolaire.getSelectedItem().toString() == null ?(" ") : cbxAnneScolaire.getSelectedItem().toString() ));
				cbxOrphelin.setSelectedIndex(0);
				table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem().toString() == null ?(" ") : cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString() == null ?(" ") : cbxClasses.getSelectedItem().toString() ));
				tableMessagePanel.setText(DonneeStatiques.countLigneAffichee+" El\u00E8ves trouv\u00E9s");
				ListeEleve.this.revalidate();

			}
		});
		cbxOrphelin.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch (cbxOrphelin.getSelectedIndex()) {
				case 0:
					table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString()));
					break;
			  case 1:
				    table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString(), true));
					break;
			  case 2:
				    table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString(), false));
					break;
				default:
					table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString()));
					break;
				}
				cbxEleve.setSelectedIndex(0);
				tableMessagePanel.setText(DonneeStatiques.countLigneAffichee+" El\u00E8ves trouv\u00E9s");
				ListeEleve.this.revalidate();
			}
		});
		cbxClasses.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {
	    		cbxEleve.setModel(DonneeStatiques.nomPrenomApprenantListe(cbxClasses.getSelectedItem().toString(), cbxAnneScolaire.getSelectedItem().toString()));
	    		cbxOrphelin.setSelectedIndex(0);
	    		table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString()));
	    		tableMessagePanel.setText(DonneeStatiques.countLigneAffichee+" El\u00E8ves trouv\u00E9s");
	    		ListeEleve.this.revalidate();
	    	}
	    });
	    cbxEleve.addItemListener(new ItemListener() {
		    	public void itemStateChanged(ItemEvent arg0) {
		    		if(cbxEleve.getSelectedIndex() > 0)
		    			table.setModel(new DonneeStatiques().listeApprenant( DonneeStatiques.matriculeListe.get(cbxEleve.getSelectedIndex()-1) , cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString()));
		    		else
		    			table.setModel(new DonneeStatiques().listeApprenant(cbxAnneScolaire.getSelectedItem().toString(), cbxClasses.getSelectedItem().toString()));
		    		cbxOrphelin.setSelectedIndex(0);
		    		tableMessagePanel.setText(DonneeStatiques.countLigneAffichee+" El\u00E8ves trouv\u00E9s");
		    		ListeEleve.this.revalidate();
		    	}
		    });

	}
	
}
