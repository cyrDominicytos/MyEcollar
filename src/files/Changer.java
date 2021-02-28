package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Model.DonneeConnexion;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Changer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox nomEcole;
	private JTextField login, Password;
	/**
	 * Create the dialog.
	 */
	public Changer() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(getParent());
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Modifier les informations de l'école");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Changer.class.getResource("/icones/update.png")));
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 630, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(93, 82, 417, 283);
		contentPanel.add(panel_1);
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4, "4, 2");
		
		JLabel lblNomEcole = new JLabel("Nom de l'\u00E9cole : ");
		lblNomEcole.setForeground(new Color(30, 144, 255));
		lblNomEcole.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomEcole, "2, 4, left, fill");
		
		nomEcole = new JComboBox();
		nomEcole.setModel(new DefaultComboBoxModel(new String[] {"AL-BIR 1", "AL-BIR 2", "AL-BIR 3"}));
		nomEcole.setFont(new Font("Sitka Banner", Font.PLAIN, 18));
		panel_1.add(nomEcole, "4, 4, fill, fill");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, "4, 6");
		
		JLabel lblClasse = new JLabel("Ancien mot de passe : ");
		lblClasse.setForeground(new Color(30, 144, 255));
		lblClasse.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblClasse, "2, 8, left, fill");
		login = new JTextField();
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		login.setEditable(true);
		panel_1.add(login, "4, 8, fill, center");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1, "4, 10");
		
		JLabel lblNomDeLlve = new JLabel("Mot de passe : ");
		lblNomDeLlve.setForeground(new Color(30, 144, 255));
		lblNomDeLlve.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		panel_1.add(lblNomDeLlve, "2, 12, left, fill");
		
		Password = new JPasswordField();
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		Password.setEditable(true);
		panel_1.add(Password, "4, 12, fill, center");
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3, "4, 14");
		
		JLabel lblModifierLesInformations = new JLabel("Se connecter \u00E0 une autre \u00E9cole");
		lblModifierLesInformations.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lblModifierLesInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifierLesInformations.setBounds(42, 20, 526, 50);
		contentPanel.add(lblModifierLesInformations);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 70));
			buttonPane.setBackground(new Color(240, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent arg0) {
						if(login.getText().matches(DonneeStatiques.pwdEcole))
						{
							new DonneeConnexion().updateSchool(nomEcole.getSelectedItem().toString(), Password.getText());
							DonneeStatiques.messageDialog("Les informations de connexion ont été modifiées avec succes!",0);
							int reponse = JOptionPane.showConfirmDialog(null, "Vous devez redémarrer l'application pour prendre en compte les nouvelles données de l'école.\n Souhaitez vous redémarrer en même temps ? ");
							if(reponse == 0)
							System.exit(0);
						}else {
							DonneeStatiques.messageDialog("Désolé, l'anncien mot de passe saisi est incorrect!",1);
						}
						
					}
				});
				okButton.setPreferredSize(new Dimension(100, 40));
				okButton.setBackground(new Color(0, 128, 0));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Sitka Banner", Font.BOLD, 16));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setPreferredSize(new Dimension(100, 40));
				cancelButton.setBackground(new Color(255, 140, 0));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Sitka Banner", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			buttonPane.add(horizontalStrut);
		}
	}
}
