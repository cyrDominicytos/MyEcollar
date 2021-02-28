package files;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ListeAnne extends JPanel {
	private JTable table;
	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public ListeAnne() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblListeDesAnnes = new JLabel("  Liste des années scolaires");
		lblListeDesAnnes.setIcon(new ImageIcon(ListeAnne.class.getResource("/icones/cal.png")));
		lblListeDesAnnes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesAnnes.setForeground(new Color(30, 144, 255));
		lblListeDesAnnes.setFont(new Font("Century", Font.BOLD, 22));
		add(lblListeDesAnnes, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 20));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		table.setRowHeight(35);
		table.setModel(DonneeStatiques.listeAnneeScolaire());
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(204);
		table.getColumnModel().getColumn(2).setPreferredWidth(176);
		scrollPane.setViewportView(table);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setPreferredSize(new Dimension(10, 60));
		panel.add(panel2, BorderLayout.SOUTH);
		panel2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("196px:grow"),
				ColumnSpec.decode("151px"),
				ColumnSpec.decode("199px:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("48px:grow"),}));
		
		JButton btnModifier = new JButton("  Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rows[] = table.getSelectedRows();
				if(rows.length > 0)
				{
					
					String annee = table.getValueAt(rows[0], 0).toString();
					String debut = table.getValueAt(rows[0], 1).toString();
				    String fin   = table.getValueAt(rows[0], 2).toString();
				    if(annee.equalsIgnoreCase(new DonneeStatiques().anneeCourante))
				    {
				    	ListeAnne.this.removeAll();
						ListeAnne.this.add(new NewYear(annee, debut, fin));
						ListeAnne.this.revalidate();
				    }else {
				    	DonneeStatiques.messageDialog("Action illegale!!!\n\n Vous ne pouvez pas modifier l'annee "+annee+" \nCette année est déjà clôturée.", 1);
				    }
					
				}
			}
		});
		
		textPane = new JTextPane();
		textPane.setText(DonneeStatiques.countLigneAffichee+" année(s) scolaire trouv\u00E9(s)");
		textPane.setForeground(new Color(30, 144, 255));
		textPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textPane.setEditable(false);
		panel2.add(textPane, "1, 2, fill, fill");
		btnModifier.setIcon(new ImageIcon(InfosEcole.class.getResource("/icones/update.png")));
		btnModifier.setBackground(new Color(30, 144, 255));
		btnModifier.setForeground(new Color(255, 255, 255));
		btnModifier.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel2.add(btnModifier, "2, 2, fill, fill");

	}

}
