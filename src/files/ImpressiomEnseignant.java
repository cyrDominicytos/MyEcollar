package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.DonneeConnexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class ImpressiomEnseignant extends JFrame {
	
	JLabel anneScolaire;
	JLabel ecole;
	JLabel dateCourante;
	JLabel lblPageName;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImpressiomEnseignant frame = new ImpressiomEnseignant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ImpressiomEnseignant(JTable table) {
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 859, 685);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(10, 60));
		buttonPanel.setBackground(Color.WHITE);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(80dlu;default):grow"),
				ColumnSpec.decode("max(90dlu;default)"),
				ColumnSpec.decode("100dlu"),
				ColumnSpec.decode("max(90dlu;default)"),
				ColumnSpec.decode("max(85dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(28dlu;default)"),}));
		
		JButton imprimer = new JButton(" Imprimer");
		imprimer.setForeground(Color.WHITE);
		imprimer.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		imprimer.setBackground(new Color(30, 144, 255));
		buttonPanel.add(imprimer, "2, 2, fill, default");
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		annuler.setForeground(Color.WHITE);
		annuler.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		annuler.setBackground(new Color(255, 165, 0));
		buttonPanel.add(annuler, "4, 2, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel principal = new JPanel();
		principal.setBackground(Color.WHITE);
		scrollPane.setViewportView(principal);
		principal.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		titlePanel.setPreferredSize(new Dimension(10, 90));
		principal.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(46dlu;default):grow"),
				ColumnSpec.decode("max(77dlu;default):grow"),
				ColumnSpec.decode("max(0dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(8dlu;default)"),
				RowSpec.decode("max(13dlu;default)"),
				RowSpec.decode("max(9dlu;default)"),}));
		
		ecole = new JLabel( new DonneeConnexion().selectNomCurrentSchool());
		ecole.setFont(new Font("Old English Text MT", Font.BOLD, 20));
		titlePanel.add(ecole, "2, 2, left, center");
		
		dateCourante = new JLabel("15 Aoà»t 2019");
		dateCourante.setFont(new Font("SansSerif", Font.PLAIN, 14));
		titlePanel.add(dateCourante, "4, 2, right, default");
		
		lblPageName = new JLabel("Liste des enseignants");
		lblPageName.setFont(new Font("DialogInput", Font.BOLD, 25));
		titlePanel.add(lblPageName, "2, 3, 3, 1, center, fill");
		
		JLabel label = new JLabel("====== @ ======");
		label.setFont(new Font("Sitka Display", Font.BOLD, 20));
		titlePanel.add(label, "2, 4, 3, 1, center, default");
		
		JPanel centre = new JPanel();
		centre.setBackground(Color.WHITE);
		principal.add(centre, BorderLayout.CENTER);
		centre.setLayout(new BorderLayout(0, 0));
		
		JPanel details = new JPanel();
		details.setPreferredSize(new Dimension(10, 45));
		details.setBackground(Color.WHITE);
		centre.add(details, BorderLayout.NORTH);
		details.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,}));
		
		JLabel lblAnneSolaire = new JLabel("Année solaire : ");
		lblAnneSolaire.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		details.add(lblAnneSolaire, "2, 2, left, default");
		
		anneScolaire = new JLabel("2018 - 2019");
		anneScolaire.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		details.add(anneScolaire, "3, 2");
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(table, BorderLayout.CENTER);
		tablePanel.setBackground(Color.WHITE);
		centre.add(tablePanel, BorderLayout.CENTER);
	}

}
