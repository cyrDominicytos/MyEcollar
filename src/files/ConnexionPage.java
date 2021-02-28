package files;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import Model.Authentification;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

@SuppressWarnings("serial")
public class ConnexionPage extends JFrame implements KeyListener{

	private JFrame logonForm;
	private JTextField loginTextField;
	private JPasswordField passTextField;
	private int xPos, yPos;
	
	private Principal acceuil;
	JLabel errorLabel;
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
				
				String[] argss = { "cmd.exe", "/C", "C:\\wamp64\\wampmanager.exe"};
				String[] arg2 = { "cmd.exe", "/C", "C:\\wamp32\\wampmanager.exe"};
		        Runtime runtime = Runtime.getRuntime();
		        try {
		        	final Process process2 = runtime.exec(arg2);
		        	final Process process = runtime.exec(argss);
		        	try {
						ConnexionPage window = new ConnexionPage();
						window.setUndecorated(true);
						window.logonForm.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
		        } catch (IOException e) {
		        	DonneeStatiques.messageDialog("Un probleme inattendu s'est produit lors du lancement du serveur de base de données.\n"+e.getMessage() , 0);
		        }
				
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	int count = 0;
	public ConnexionPage() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		logonForm = new JFrame();
		logonForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		logonForm.setUndecorated(true);
		logonForm.setResizable(false);
		logonForm.setType(Type.UTILITY);
		logonForm.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xPos = arg0.getX();
				yPos = arg0.getY();
			}
		});
		logonForm.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
	
				logonForm.setLocation(x-xPos, y-yPos);
			}
		});
		logonForm.getContentPane().setBackground(Color.WHITE);
		logonForm.setTitle("Ouvrir une session");
		logonForm.setBounds(100, 100, 597, 487);
		logonForm.setLocationRelativeTo(null);
		logonForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logonForm.getContentPane().setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(SystemColor.textHighlight);
		imagePanel.setBounds(0, 0, 300, 487);
		logonForm.getContentPane().add(imagePanel);
		imagePanel.setLayout(null);
		
		JPanel sloganPanel = new JPanel();
		sloganPanel.setBackground(SystemColor.textHighlight);
		sloganPanel.setBounds(0, 385, 300, 78);
		imagePanel.add(sloganPanel);
		sloganPanel.setLayout(null);
		
		JLabel lblDialloshop = new JLabel("Ecollar");
		lblDialloshop.setHorizontalAlignment(SwingConstants.CENTER);
		lblDialloshop.setBounds(80, 13, 140, 23);
		lblDialloshop.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDialloshop.setForeground(new Color(255, 255, 255));
		sloganPanel.add(lblDialloshop);
		
		JLabel lblNewLabel = new JLabel("... Faites le vite, Faites le mieux ...");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(14, 47, 271, 16);
		sloganPanel.add(lblNewLabel);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 300, 350);
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setIcon(new ImageIcon(ConnexionPage.class.getResource("/fonds/bg.jpg")));
		imagePanel.add(lblImage);
		
		JLabel lblLogin = new JLabel("Nom d'utilisateur");
		lblLogin.setForeground(SystemColor.textText);
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLogin.setToolTipText("Ce numéro constitue votre login");
		lblLogin.setLabelFor(loginTextField);
		lblLogin.setBounds(329, 173, 159, 27);
		logonForm.getContentPane().add(lblLogin);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("Rockwell", Font.PLAIN, 16));
		loginTextField.setForeground(new Color(0, 0, 0));
		loginTextField.setBorder(new LineBorder(SystemColor.textHighlight, 2, true));
		loginTextField.setColumns(10);
		loginTextField.setBounds(329, 200, 262, 34);
		logonForm.getContentPane().add(loginTextField);
		
		JLabel lblPass = new JLabel("Mot de passe");
		lblPass.setForeground(SystemColor.textText);
		lblPass.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPass.setLabelFor(passTextField);
		lblPass.setBounds(329, 274, 121, 22);
		logonForm.getContentPane().add(lblPass);
		
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Rockwell", Font.PLAIN, 16));
		passTextField.setForeground(new Color(0, 0, 0));
		passTextField.setBorder(new LineBorder(SystemColor.textHighlight, 2, true));
		passTextField.setColumns(10);
		passTextField.setBounds(329, 307, 262, 34);
		logonForm.getContentPane().add(passTextField);
		
		JButton envoyerButton = new JButton("Envoyer");
		
		envoyerButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				authentifier();
			}
		});
		envoyerButton.setName("submit");
		envoyerButton.setActionCommand("submit");
		envoyerButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		envoyerButton.setForeground(Color.WHITE);
		envoyerButton.setBackground(new Color(0, 153, 255));
		envoyerButton.setBounds(379, 405, 169, 36);
		logonForm.getContentPane().add(envoyerButton);
		
		JLabel lblClose = new JLabel("");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblClose.setIcon(new ImageIcon(ConnexionPage.class.getResource("/icones/btn_close.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblClose.setIcon(new ImageIcon(ConnexionPage.class.getResource("/icones/btn_close_normal.png")));
			}
		});
		lblClose.setIcon(new ImageIcon(ConnexionPage.class.getResource("/icones/btn_close_normal.png")));
		lblClose.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClose.setBounds(567, 0, 30, 30);
		logonForm.getContentPane().add(lblClose);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(ConnexionPage.class.getResource("/icones/images.jpg")));
		lblPhoto.setBorder(null);
		lblPhoto.setBounds(411, 39, 88, 88);
		logonForm.getContentPane().add(lblPhoto);
		
		errorLabel = new JLabel("Donn\u00E9es incorrectes");
		errorLabel.setVisible(false);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		errorLabel.setBounds(329, 139, 262, 28);
		logonForm.getContentPane().add(errorLabel);
		
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("appel");
		if(key.getKeyCode() == KeyEvent.VK_ENTER)
		{
			authentifier();
			System.out.println("Marche");
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		System.out.println("appel");
		if(key.getKeyCode() == KeyEvent.VK_ENTER)
		{
			authentifier();
			System.out.println("Marche");
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent key) {
		System.out.println("appel");
		if(key.getKeyCode() == KeyEvent.VK_ENTER)
		{
			authentifier();
			System.out.println("Marche");
		}
		
	}
	
	public void authentifier()
	{
		if(new Authentification().Authentifier(loginTextField.getText(), passTextField.getText()))
		{
			errorLabel.setVisible(false);
			
			ConnexionPage.this.logonForm.setVisible(false);
			Principal frame = new Principal();
			frame.show();					
			
		}else {
			errorLabel.setVisible(true);
		}
	}
}
