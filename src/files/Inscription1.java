package files;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.*;
import java.awt.event.ItemListener;
//import java.sql.Date;
import java.text.DateFormat;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
@SuppressWarnings("serial")
public class Inscription1 extends JPanel {
	public JTextField nomTextField;
	public JTextField prenomTextField;
	public JTextField contactTuteurTextField_2;
	public JTextField txtAdresse;
	public JTextField frais;
	public JTextField codeText;
	@SuppressWarnings("rawtypes")
	JComboBox classe;
	@SuppressWarnings("rawtypes")
	JComboBox cbxSexe;
	JCheckBox lblCatgorie;
	JLabel lblCode;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public Inscription1() {
		setAutoscrolls(true);
		setBackground(new Color(240, 248, 255));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(175dlu;default):grow"),
				ColumnSpec.decode("max(83dlu;default)"),
				ColumnSpec.decode("max(85dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(179dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("max(41dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(25dlu;default)"),
				RowSpec.decode("max(15dlu;default):grow"),}));
		

		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setForeground(new Color(30, 144, 255));
		lblNom.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblNom, "2, 3, left, fill");
		
		nomTextField = new JTextField();
		nomTextField.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		nomTextField.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(nomTextField, "4, 3, fill, fill");
		nomTextField.setColumns(10);
		
		JLabel lblContatctDuTuteur = new JLabel("Contatct du tuteur : ");
		lblContatctDuTuteur.setForeground(new Color(30, 144, 255));
		lblContatctDuTuteur.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblContatctDuTuteur, "6, 3, left, fill");
		
		contactTuteurTextField_2 = new JTextField();
		contactTuteurTextField_2.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		contactTuteurTextField_2.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(contactTuteurTextField_2, "8, 3, fill, fill");
		contactTuteurTextField_2.setColumns(10);
		
		JLabel lblPrnoms = new JLabel("Prénom (s) : ");
		lblPrnoms.setForeground(new Color(30, 144, 255));
		lblPrnoms.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblPrnoms, "2, 7, right, default");
		
		prenomTextField = new JTextField();
		prenomTextField.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		prenomTextField.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(prenomTextField, "4, 7, fill, fill");
		prenomTextField.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setForeground(new Color(30, 144, 255));
		lblAdresse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblAdresse, "6, 7, left, fill");
		
		txtAdresse = new JTextField();
		txtAdresse.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		txtAdresse.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(txtAdresse, "8, 7, fill, fill");
		txtAdresse.setColumns(10);
		
		JLabel lblSexe = new JLabel("Sexe : ");
		lblSexe.setForeground(new Color(30, 144, 255));
		lblSexe.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblSexe, "2, 11, left, fill");
		
		cbxSexe = new JComboBox();
		cbxSexe.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		cbxSexe.setBorder(null);
		cbxSexe.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		add(cbxSexe, "4, 11, fill, fill");
		
		JLabel lblClasse = new JLabel("Classe :");
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		lblClasse.setForeground(new Color(30, 144, 255));
		add(lblClasse, "6, 11, left, fill");
		
		classe = new JComboBox();
		classe.setEditable(true);
		AutoCompleteDecorator.decorate(classe);
		classe.setModel(new DonneeStatiques().classeNiveau());
		classe.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		add(classe, "8, 11, fill, fill");
		
		lblCatgorie = new JCheckBox("Orphelin");
		
		lblCatgorie.setForeground(new Color(30, 144, 255));
		lblCatgorie.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblCatgorie, "2, 15, left, default");
		
		lblCatgorie.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int i = arg0.getStateChange();
				if(i == ItemEvent.SELECTED) {
					codeText.setEnabled(true);
					lblCode.setEnabled(true);
					frais.setEnabled(false);
					frais.setText("0");
					
				}else {
					codeText.setEnabled(false);
					codeText.setText("");
					lblCode.setEnabled(false);
					frais.setEnabled(true);
					frais.setText("0");
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		panel_1.setBackground(new Color(255, 255, 255));
		add(panel_1, "4, 15, fill, fill");
		panel_1.setLayout(null);
		
		lblCode = new JLabel("CODE : ");
		lblCode.setEnabled(false);
		lblCode.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblCode.setForeground(new Color(30, 144, 255));
		lblCode.setBounds(6, 7, 69, 27);
		panel_1.add(lblCode);
		
		codeText = new JTextField("");
		codeText.setEnabled(false);
		codeText.setFont(new Font("Sitka Display", Font.BOLD, 18));
		codeText.setForeground(new Color(30, 144, 255));
		codeText.setBounds(69, 0, 274, 41);
		panel_1.add(codeText);
		
		JLabel lblFraisDinscription = new JLabel("Frais d'inscription : ");
		lblFraisDinscription.setForeground(new Color(30, 144, 255));
		lblFraisDinscription.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblFraisDinscription, "6, 15, right, default");
		
		frais = new JTextField();
		frais.setText("0");
		frais.setColumns(10);
		add(frais, "8, 15, fill, fill");
		
		JLabel lblFcfa = new JLabel("FCFA");
		lblFcfa.setForeground(new Color(30, 144, 255));
		lblFcfa.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblFcfa, "10, 15");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		add(verticalStrut_3, "5, 24");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public Inscription1(String nom, String prenom, String sexe, String code, String contact, String adresse)
	{
		setAutoscrolls(true);
		setBackground(new Color(240, 248, 255));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(175dlu;default):grow"),
				ColumnSpec.decode("max(83dlu;default)"),
				ColumnSpec.decode("max(85dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(179dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("max(41dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("12dlu"),
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(25dlu;default)"),
				RowSpec.decode("max(15dlu;default):grow"),}));
		

		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setForeground(new Color(30, 144, 255));
		lblNom.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblNom, "2, 3, left, fill");
		
		nomTextField = new JTextField();
		nomTextField.setText(nom);
		nomTextField.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		nomTextField.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(nomTextField, "4, 3, fill, fill");
		nomTextField.setColumns(10);
		
		JLabel lblContatctDuTuteur = new JLabel("Contatct du tuteur : ");
		lblContatctDuTuteur.setForeground(new Color(30, 144, 255));
		lblContatctDuTuteur.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblContatctDuTuteur, "6, 3, left, fill");
		
		contactTuteurTextField_2 = new JTextField();
		contactTuteurTextField_2.setText(contact);
		contactTuteurTextField_2.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		contactTuteurTextField_2.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(contactTuteurTextField_2, "8, 3, fill, fill");
		contactTuteurTextField_2.setColumns(10);
		
		JLabel lblPrnoms = new JLabel("Prénom (s) : ");
		lblPrnoms.setForeground(new Color(30, 144, 255));
		lblPrnoms.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblPrnoms, "2, 7, right, default");
		
		prenomTextField = new JTextField();
		prenomTextField.setText(prenom);
		prenomTextField.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		prenomTextField.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(prenomTextField, "4, 7, fill, fill");
		prenomTextField.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setForeground(new Color(30, 144, 255));
		lblAdresse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblAdresse, "6, 7, left, fill");
		
		txtAdresse = new JTextField();
		txtAdresse.setText(adresse);
		txtAdresse.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		txtAdresse.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		add(txtAdresse, "8, 7, fill, fill");
		txtAdresse.setColumns(10);
		
		JLabel lblSexe = new JLabel("Sexe : ");
		lblSexe.setForeground(new Color(30, 144, 255));
		lblSexe.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblSexe, "2, 11, left, fill");
		
		cbxSexe = new JComboBox();
		cbxSexe.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		cbxSexe.setBorder(null);
		cbxSexe.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cbxSexe.setSelectedItem(sexe);
		add(cbxSexe, "4, 11, fill, fill");
		
		JLabel lblClasse = new JLabel("Classe :");
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		lblClasse.setForeground(new Color(30, 144, 255));
		add(lblClasse, "6, 11, left, fill");
		
		classe = new JComboBox();
		classe.setEditable(false);
		classe.setEnabled(false);
		//AutoCompleteDecorator.decorate(classe);
		//classe.setModel(new DonneeStatiques().classeNiveau());
		classe.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		
		add(classe, "8, 11, fill, fill");
		
		lblCatgorie = new JCheckBox("Orphelin");
		
		lblCatgorie.setForeground(new Color(30, 144, 255));
		lblCatgorie.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblCatgorie, "2, 15, left, default");
	
		lblCatgorie.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int i = arg0.getStateChange();
				if(i == ItemEvent.SELECTED) {
					codeText.setEnabled(true);
					lblCode.setEnabled(true);
					codeText.setText(code);
				}else {
					codeText.setEnabled(false);
					codeText.setText("");
					lblCode.setEnabled(false);
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		panel_1.setBackground(new Color(255, 255, 255));
		add(panel_1, "4, 15, fill, fill");
		panel_1.setLayout(null);
		
		lblCode = new JLabel("CODE : ");
		lblCode.setEnabled(false);
		lblCode.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblCode.setForeground(new Color(30, 144, 255));
		lblCode.setBounds(6, 7, 69, 27);
		
		codeText = new JTextField("");
		codeText.setFont(new Font("Sitka Display", Font.BOLD, 18));
		codeText.setForeground(new Color(30, 144, 255));
		codeText.setBounds(69, 0, 274, 41);
		if(code.isEmpty())
		{
			lblCatgorie.setSelected(false);
			codeText.setEnabled(false);
		}else {
			lblCatgorie.setSelected(true);
			codeText.setEnabled(true);
			codeText.setText(code);
			
		}
		panel_1.add(lblCode);
		panel_1.add(codeText);
		
		JLabel lblFraisDinscription = new JLabel("Frais d'inscription : ");
		lblFraisDinscription.setForeground(new Color(30, 144, 255));
		lblFraisDinscription.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblFraisDinscription, "6, 15, right, default");
		
		frais = new JTextField();
		frais.setEditable(false);
		frais.setEnabled(false);
		frais.setColumns(10);
		add(frais, "8, 15, fill, fill");
		
		JLabel lblFcfa = new JLabel("FCFA");
		lblFcfa.setForeground(new Color(30, 144, 255));
		lblFcfa.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		add(lblFcfa, "10, 15");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		add(verticalStrut_3, "5, 24");
	}
	
	public  void viderChamp()
	{
		this.nomTextField.setText("");
		this.prenomTextField.setText("");
		this.contactTuteurTextField_2.setText("");
		this.txtAdresse.setText("");
		this.codeText.setText("");
		this.lblCatgorie.setSelected(false);
	}

}
