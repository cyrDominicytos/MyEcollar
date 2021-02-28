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

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.Classe;
import Model.Scolarite;

@SuppressWarnings("serial")
public class NouvelleClasse extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextField txtMontant;
	JTextField txtClasseName;
	public NouvelleClasse() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblReinscrireUnElve = new JLabel("Ajouter une nouvelle classe");
		lblReinscrireUnElve.setIcon(new ImageIcon(NouvelleClasse.class.getResource("/icones/addclass.png")));
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
		panel_1.setBounds(45, 51, 417, 283);
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
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 4");
		
		JLabel lblAnneSolairee = new JLabel("Année Solairee :");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 6, left, fill");
		
		JTextField txtAnnee = new JTextField();
		txtAnnee.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnnee.setText(new DonneeStatiques().anneeCourante);
		txtAnnee.setEditable(false);
		txtAnnee.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		
		panel_1.add(txtAnnee, "4, 6, 2, 1, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 8");
		
		JLabel lblClasse = new JLabel("Nom de la classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 10, left, fill");
		
		txtClasseName = new JTextField();
		txtClasseName.setEditable(true);
		panel_1.add(txtClasseName, "4, 10, 2, 1, fill, fill");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 12");
		
		JLabel lblNomDeLlve = new JLabel("Montant de la scolarité : ");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 14, left, fill");
		
		txtMontant = new JTextField();
		txtMontant.setEditable(true);
		panel_1.add(txtMontant, "4, 14, 2, 1, fill, fill");
		
		JButton btnEnregistrerLePaiement = new JButton("  Enregistrer");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Classe().insertClasse(txtClasseName.getText(), Integer.parseInt(txtMontant.getText()));
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(154, 366, 198, 48);
		panel.add(btnEnregistrerLePaiement);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel0.add(panel_3, "3, 2, fill, fill");

	}
	
	public NouvelleClasse(String classe, String scolarite) {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblReinscrireUnElve = new JLabel("Modifié une classe");
		lblReinscrireUnElve.setIcon(new ImageIcon(NouvelleClasse.class.getResource("/icones/addclass.png")));
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
		panel_1.setBounds(45, 51, 417, 283);
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
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_5, "4, 4");
		
		JLabel lblAnneSolairee = new JLabel("Année Solairee :");
		lblAnneSolairee.setForeground(new Color(30, 144, 255));
		lblAnneSolairee.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblAnneSolairee, "2, 6, left, fill");
		
		JTextField txtAnnee = new JTextField();
		txtAnnee.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnnee.setText(new DonneeStatiques().anneeCourante);
		txtAnnee.setEditable(false);
		txtAnnee.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		
		panel_1.add(txtAnnee, "4, 6, 2, 1, fill, fill");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 8");
		
		JLabel lblClasse = new JLabel("Nom de la classe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 10, left, fill");
		
		txtClasseName = new JTextField();
		txtClasseName.setEditable(true);
		txtClasseName.setText(classe);
		panel_1.add(txtClasseName, "4, 10, 2, 1, fill, fill");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 12");
		
		JLabel lblNomDeLlve = new JLabel("Montant de la scolarité : ");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 14, left, fill");
		
		txtMontant = new JTextField();
		txtMontant.setEditable(true);
		txtMontant.setText(scolarite);
		panel_1.add(txtMontant, "4, 14, 2, 1, fill, fill");
		
		JButton btnEnregistrerLePaiement = new JButton("  Modifier");
		btnEnregistrerLePaiement.setIcon(new ImageIcon(EnregistrerPaiement.class.getResource("/icones/check.png")));
		btnEnregistrerLePaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Classe().updateClasse(txtClasseName.getText(), classe);
				new Scolarite().updateScolariteClasse(txtClasseName.getText(), Integer.parseInt(txtMontant.getText()));
			}
		});
		btnEnregistrerLePaiement.setFont(new Font("Sitka Banner", Font.BOLD, 22));
		btnEnregistrerLePaiement.setForeground(new Color(248, 248, 255));
		btnEnregistrerLePaiement.setBackground(new Color(0, 128, 0));
		btnEnregistrerLePaiement.setBounds(154, 366, 198, 48);
		panel.add(btnEnregistrerLePaiement);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel0.add(panel_3, "3, 2, fill, fill");

	}
}
