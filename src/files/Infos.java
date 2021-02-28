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
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Infos extends JDialog {

	JTextPane message;
	private final JPanel contentPanel = new JPanel();
	public Infos() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Infos.class.getResource("/icones/info.png")));
		setTitle("Information");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Infos.class.getResource("/icones/info.png")));
		label.setBounds(14, 40, 96, 96);
		contentPanel.add(label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(65, 105, 225), 2));
		separator_1.setBackground(new Color(112, 128, 144));
		separator_1.setBounds(31, 24, 602, 5);
		contentPanel.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(65, 105, 225), 2));
		separator.setBackground(new Color(112, 128, 144));
		separator.setBounds(31, 148, 602, 5);
		contentPanel.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(109, 40, 524, 96);
		contentPanel.add(scrollPane);
		
		message = new JTextPane();
		message.setForeground(new Color(112, 128, 144));
		message.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		message.setEditable(false);
		scrollPane.setViewportView(message);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setPreferredSize(new Dimension(10, 40));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Fermer");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBounds(279, 0, 81, 35);
				cancelButton.setBackground(new Color(0, 128, 0));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Sitka Banner", Font.BOLD, 18));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
