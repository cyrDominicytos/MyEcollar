package files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Activate extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Activate() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Activate.class.getResource("/icones/checkmark_success_96.png")));
		setTitle("Activation du logiciel");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnDsolCetteFonctionnalit = new JTextPane();
			txtpnDsolCetteFonctionnalit.setEditable(false);
			txtpnDsolCetteFonctionnalit.setForeground(new Color(112, 128, 144));
			txtpnDsolCetteFonctionnalit.setFont(new Font("Sitka Banner", Font.BOLD, 16));
			txtpnDsolCetteFonctionnalit.setText(" Afin d'activer votre logiciel, veuillez contacter le fournisseur via "+DonneeStatiques.support);
			txtpnDsolCetteFonctionnalit.setBounds(122, 72, 306, 93);
			contentPanel.add(txtpnDsolCetteFonctionnalit);
		}
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Activate.class.getResource("/icones/success.png")));
		label.setBounds(14, 57, 96, 96);
		contentPanel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		separator.setBackground(new Color(112, 128, 144));
		separator.setBounds(31, 177, 371, 5);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		separator_1.setBackground(new Color(112, 128, 144));
		separator_1.setBounds(31, 24, 371, 5);
		contentPanel.add(separator_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setPreferredSize(new Dimension(10, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Fermer");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBounds(176, 0, 81, 35);
				cancelButton.setBackground(new Color(0, 128, 0));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Sitka Banner", Font.BOLD, 18));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
