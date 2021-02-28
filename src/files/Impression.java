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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.DonneeConnexion;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Impression extends JFrame {
	
	JLabel anneScolaire;
	JLabel classe;
	JLabel ecole;
	JLabel dateCourante;
	JLabel PageName, lblClasse;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Impression frame = new Impression();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public Impression(javax.swing.table.DefaultTableModel  model, String classePara,String PageNamePara, String annee) {
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 722);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(400, 32767));
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
		imprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DonneeStatiques().imprimerDocument(scrollPane.getViewport(),PageNamePara, Impression.this );
			}
		});
		imprimer.setForeground(Color.WHITE);
		imprimer.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		imprimer.setBackground(new Color(30, 144, 255));
		buttonPanel.add(imprimer, "1, 2, fill, default");
		
		JButton annuler = new JButton("Quitter");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		annuler.setForeground(Color.WHITE);
		annuler.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		annuler.setBackground(new Color(255, 165, 0));
		buttonPanel.add(annuler, "4, 2, fill, default");
		
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel principal = new JPanel();
		principal.setBackground(Color.WHITE);
		scrollPane.setViewportView(principal);
		principal.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(10, 150));
		principal.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBas = new JPanel();
		panelBas.setPreferredSize(new Dimension(10, 45));
		
		titlePanel.add(panelBas, BorderLayout.SOUTH);
		panelBas.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(25dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,}));
		
		JLabel lblAnneSolaire = new JLabel("Année solaire : ");
		lblAnneSolaire.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		panelBas.add(lblAnneSolaire, "2, 2, left, default");
		anneScolaire = new JLabel(annee);
		anneScolaire.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		panelBas.add(anneScolaire, "3, 2");
		lblClasse = new JLabel("Classe : ");
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		panelBas.add(lblClasse, "5, 2, left, default");
		classe = new JLabel(classePara);
		classe.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		panelBas.add(classe, "6, 2");
		
		
		
		JPanel panelHaut = new JPanel();
		titlePanel.add(panelHaut, BorderLayout.CENTER);
		panelHaut.setLayout(new FormLayout(new ColumnSpec[] {
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
		panelHaut.add(ecole, "2, 2, left, center");
		
		dateCourante = new JLabel(DonneeStatiques.f.format(new java.util.Date())+"");
		dateCourante.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panelHaut.add(dateCourante, "4, 2, right, default");
		
		PageName = new JLabel(PageNamePara);
		PageName.setFont(new Font("DialogInput", Font.BOLD, 25));
		panelHaut.add(PageName, "2, 3, 3, 1, center, fill");
		
		JLabel label = new JLabel("====== @ ======");
		label.setFont(new Font("Sitka Display", Font.BOLD, 20));
		panelHaut.add(label, "2, 4, 3, 1, center, default");
		
		
		/*JPanel tablePane = new JPanel();
		principal.add(tablePane, BorderLayout.CENTER);
		tablePane.setLayout(new BorderLayout(0, 0));
		
		tablePane.setBackground(Color.WHITE);
		JTable tableau = new JTable();
		tableau.setAutoCreateRowSorter(true);
		tableau.setRowHeight(25);
		tableau.setShowVerticalLines(true);
		tableau.setShowHorizontalLines(true);
		tableau.setModel(model);
		
		tablePane.add(new JScrollPane(),tableau);
		
		*/
		
		
		JPanel tablePane = new JPanel();
		principal.add(tablePane, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		tablePane.add(scrollPane, BorderLayout.CENTER);
		
		JTable tableau = new JTable();
		tableau.setAutoCreateRowSorter(true);
		tableau.setRowHeight(25);
		tableau.setShowVerticalLines(true);
		tableau.setShowHorizontalLines(true);
		tableau.setModel(model);
		scrollPane.setViewportView(tableau);
		if(classePara.isEmpty())
		{
			lblClasse.setText("");
			classe.setText("");
		}
	}

}
