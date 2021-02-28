package files;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Apprenant;
import Model.Enseignant;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ListeEnseignant extends JPanel {

	JTable table;
	JTextPane textPane;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ListeEnseignant() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblListeDesEnseignants = new JLabel("  Liste des Personnels");
		lblListeDesEnseignants.setIcon(new ImageIcon(ListeEnseignant.class.getResource("/icones/liste_Eleves.png")));
		lblListeDesEnseignants.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesEnseignants.setForeground(new Color(30, 144, 255));
		lblListeDesEnseignants.setFont(new Font("Century", Font.BOLD, 22));
		add(lblListeDesEnseignants, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 30));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JPanel centre = new JPanel();
		centre.setBackground(Color.WHITE);
		panel.add(centre, BorderLayout.CENTER);
		centre.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		centre.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(25);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setModel(DonneeStatiques.listeEnseignant());
		table.getColumnModel().getColumn(0).setPreferredWidth(187);
		table.getColumnModel().getColumn(1).setPreferredWidth(255);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(201);
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
				ColumnSpec.decode("265px"),
				ColumnSpec.decode("max(49dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("fill:39px:grow"),}));
		
		JButton button = new JButton(" Imprimer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       String annee = new DonneeStatiques().anneeCourante;
			       DonneeStatiques.imprimerDocumentPro(table, "Liste des enseignants  ",  "Imprimé le : "+DonneeStatiques.f.format(new Date())+"");
			}
		});
		
		textPane = new JTextPane();
		textPane.setText("30 Personnel(s) trouv\u00E9(s)");
		textPane.setForeground(new Color(30, 144, 255));
		textPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textPane.setEditable(false);
		panel_2.add(textPane, "1, 2, fill, fill");
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
					String contact = table.getValueAt(rows[0], 1).toString();
					String nomPrenom = table.getValueAt(rows[0], 0).toString();
										
					switch (buttonPaiement.getSelectedIndex()) {
					case 0:
						
						break;
					case 1://Modification des infos de l'enseignant
						try {
							ResultSet result = new Enseignant().selectEnseignant(contact);
							if (result.next()) {				
								ListeEnseignant.this.removeAll();
								ListeEnseignant.this.add(new EnregistrerEnseignant(result.getString("TELEPHONE"), result.getString("NOM"), result.getString("PRENOM"), result.getString("SEXE"), result.getString("ADRESSE"), result.getString("ESENSEIGNANT")));
								ListeEnseignant.this.revalidate();
							}
						} catch (SQLException e) {
							DonneeStatiques.messageDialog(e.getMessage(), 2);
						} 
						break;
					case 2://Enregistrer Payement
						ListeEnseignant.this.removeAll();
						ListeEnseignant.this.add(new AjouterDepense(contact, nomPrenom));
						ListeEnseignant.this.revalidate();
						break;
					default:
						
						break;
					}
				}
			}
		});
		buttonPaiement.setModel(new DefaultComboBoxModel(new String[] {"Actions","Modifier les informations", "Enregistrer un paiement"}));
		buttonPaiement.setForeground(Color.WHITE);
		buttonPaiement.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		buttonPaiement.setBackground(new Color(30, 144, 255));
		panel_2.add(buttonPaiement, "4, 2, fill, fill");
		
	}

}
