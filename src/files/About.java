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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/icones/16x16_About.png")));
		setResizable(false);
		setTitle("A propos des développeurs");
		setType(Type.POPUP);
		setModal(true);
		setBounds(100, 100, 656, 571);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240, 248, 255));
			panel.setPreferredSize(new Dimension(10, 100));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("  [  A PROPOS DE NOUS  ]");
				lblNewLabel.setForeground(new Color(65, 105, 225));
				lblNewLabel.setFont(new Font("Playbill", Font.PLAIN, 40));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(3, 5, 634, 89);
				panel.add(lblNewLabel);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				panel.setBorder(new LineBorder(new Color(65, 105, 225), 3, true));
				panel.setBackground(new Color(240, 248, 255));
				scrollPane.setViewportView(panel);
				panel.setLayout(new FormLayout(new ColumnSpec[] {
						FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(351dlu;default)"),
						FormSpecs.RELATED_GAP_COLSPEC,},
					new RowSpec[] {
						RowSpec.decode("15dlu"),
						RowSpec.decode("max(186dlu;default)"),}));
				{
					JTextPane txtpnNosDveloppeursSe = new JTextPane();
					txtpnNosDveloppeursSe.setFont(new Font("Sitka Small", Font.PLAIN, 13));
					txtpnNosDveloppeursSe.setPreferredSize(new Dimension(550, 24));
					txtpnNosDveloppeursSe.setEditable(false);
					txtpnNosDveloppeursSe.setText("Nos développeurs se sont fait un plaisir de développer cette application et sont très heureux de lire chaque fois vos messages, vos critiques ou vos suggestions. Toutes choses suceptibles de nous permettre d'améliorer les versions futures de cette application et de celles à  venir. N'ésitez donc pas à  nous faire parvenir vos avis chaque fois que vous en sentez le besoin.\r\n\r\n\tPour de plus amples informations sur l'équipe de développeur ou sur les produits de notre entreprise veuillez visiter:\r\n\r\n\t\t \r\n\t\tNotre site web www.creativ-technologies.com\r\n\t\t\t\r\n\r\n  CREATIV TECHNOLOGIES; LE FUTUR DE LA TECHNOLOGIE, LA TECHNOLOGIE DU FUTUR !");
					panel.add(txtpnNosDveloppeursSe, "2, 2, fill, fill");
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 70));
			buttonPane.setBackground(new Color(240, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Fermer");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
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
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			buttonPane.add(horizontalStrut);
		}
	}
}
