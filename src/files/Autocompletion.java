package files;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class Autocompletion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autocompletion frame = new Autocompletion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JComboBox comboBox;
	private JTextField textField;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Autocompletion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"FootBall", "HandBall", "VolleyBall", "Ruby", "Danse", "Pocker", "Salsa", "Azonto", "Namibie", "Zambie"}));
		comboBox.setEditable(true);
		comboBox.setBounds(159, 66, 198, 50);
		contentPane.add(comboBox);
		AutoCompleteDecorator.decorate(comboBox);
		
		textField = new JTextField();
		textField.setBounds(169, 170, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
			}
}
