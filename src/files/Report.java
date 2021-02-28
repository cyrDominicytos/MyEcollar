package files;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class Report extends JFrame implements Printable {
//attribut
private JFrame frame;
private JTable table;
private String titre;
JPanel titrePanel;
//méthodes
public Report(JTable tt, String leTitre) {
	this.table = tt;
	this.titre = leTitre;
	frame = new JFrame("Rapport des ventes");
	final String[] headers = {"Numero", "Nom de l'expedition", "Date", "Valide"};
	table = new JTable(tt.getModel());
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setPreferredSize(new Dimension(550, 200));
	
	frame.getContentPane().setLayout(new BorderLayout());
	
	
	
	titrePanel = new JPanel();
	titrePanel.setPreferredSize(new Dimension(550, 200));
	frame.getContentPane().add(BorderLayout.NORTH, titrePanel);
	titrePanel.setLayout(new BorderLayout(0, 0));
	titrePanel.setLayout(new BorderLayout(0, 0));
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(550, 60));
	titrePanel.add(panel_1, BorderLayout.SOUTH);
	panel_1.setLayout(new FormLayout(new ColumnSpec[] {
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
	
	JLabel label = new JLabel("Ann\u00E9e solaire : ");
	label.setFont(new Font("Sitka Banner", Font.BOLD, 16));
	panel_1.add(label, "2, 2");
	
	JLabel label_1 = new JLabel("<dynamic>");
	label_1.setFont(new Font("Sitka Small", Font.PLAIN, 18));
	panel_1.add(label_1, "3, 2");
	
	JLabel label_3 = new JLabel("Classe : ");
	label_3.setFont(new Font("Sitka Banner", Font.BOLD, 16));
	panel_1.add(label_3, "5, 2");
	
	JLabel label_2 = new JLabel("<dynamic>");
	label_2.setFont(new Font("Sitka Small", Font.PLAIN, 18));
	panel_1.add(label_2, "6, 2");
	
	JPanel panel_2 = new JPanel();
	titrePanel.add(panel_2, BorderLayout.CENTER);
	panel_2.setLayout(new FormLayout(new ColumnSpec[] {
			FormSpecs.RELATED_GAP_COLSPEC,
			ColumnSpec.decode("max(46dlu;default):grow"),
			ColumnSpec.decode("max(77dlu;default):grow"),
			ColumnSpec.decode("max(0dlu;default):grow"),},
		new RowSpec[] {
			FormSpecs.RELATED_GAP_ROWSPEC,
			RowSpec.decode("max(8dlu;default)"),
			RowSpec.decode("max(13dlu;default)"),
			RowSpec.decode("max(9dlu;default)"),}));
	
	JLabel label_4 = new JLabel("AL - BIRR");
	label_4.setFont(new Font("Old English Text MT", Font.BOLD, 20));
	panel_2.add(label_4, "2, 2");
	
	JLabel label_5 = new JLabel("17/10/2019");
	label_5.setHorizontalAlignment(SwingConstants.RIGHT);
	label_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
	panel_2.add(label_5, "4, 2");
	
	JLabel label_6 = new JLabel("<dynamic>");
	label_6.setHorizontalAlignment(SwingConstants.CENTER);
	label_6.setFont(new Font("DialogInput", Font.BOLD, 25));
	panel_2.add(label_6, "2, 3, 3, 1");
	
	JLabel label_7 = new JLabel("====== @ ======");
	label_7.setHorizontalAlignment(SwingConstants.CENTER);
	label_7.setFont(new Font("Sitka Display", Font.BOLD, 20));
	panel_2.add(label_7, "2, 4, 3, 1");
	
	
	frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
	
	JPanel panel = new JPanel();
	panel.setPreferredSize(new Dimension(10, 150));
	scrollPane.setColumnHeaderView(panel);
	frame.pack();
	JButton printButton = new JButton();
	printButton.setText("Imprimez moi !");
	frame.getContentPane().add(BorderLayout.SOUTH, printButton);
	// pour une impression plus rapide nous désactive de double buffering
	RepaintManager.currentManager(frame).setDoubleBufferingEnabled(false);
	
	printButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent evt) {
	PrinterJob pj = PrinterJob.getPrinterJob();
	pj.setPrintable(Report.this);
	pj.printDialog();
	try {
	pj.print();
	}
	catch (Exception PrintException) {}
	}
	});
	frame.setVisible(true);
}

public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException 
{
	Graphics2D g2 = (Graphics2D)g;
	Font defaultFont = g2.getFont();
	g2.setColor(Color.black);
	int fontHeight = g2.getFontMetrics().getHeight();
	int fontDescent = g2.getFontMetrics().getDescent();
	
	// laisser de l'espace pour le numero de page
	double pageHeight = pageFormat.getImageableHeight() - fontHeight;
	double pageWidth = pageFormat.getImageableWidth();
	double tableWidth = (double)
	table.getColumnModel().getTotalColumnWidth();
	double scale = 1;
	System.out.println("pageHeight  => "+pageHeight+"\n"+"pageWidth  => "+pageWidth+"\n"+"tableWidth  => "+tableWidth+"\n");
	if (tableWidth >= pageWidth)
	{
	scale = pageWidth / tableWidth;
	}
	
	double headerHeightOnPage = table.getTableHeader().getHeight()*scale;
	double tableWidthOnPage = tableWidth * scale;
	
	double oneRowHeight = (table.getRowHeight() +
	table.getRowMargin()*2)*scale;
	
	//int numRowsOnAPage = (int)((pageHeight-headerHeightOnPage) /
	//oneRowHeight)-2;
	int numRowsOnAPage = (int)((pageHeight-50-headerHeightOnPage) /oneRowHeight)-2;
	
	double pageHeightForTable = oneRowHeight * numRowsOnAPage;
	
	int totalNumPages = (int)Math.ceil(((double)table.getRowCount()) /
	numRowsOnAPage);
	System.out.println("pageHeight  => "+pageHeight+"\n"+"pageWidth  => "+pageWidth+"\n"+"tableWidth  => "+tableWidth+"\n"+
			"headerHeightOnPage  => "+headerHeightOnPage+"\n"+"tableWidthOnPage  => "+tableWidthOnPage+"\n"+"oneRowHeight  => "+oneRowHeight+"\n"+
			"numRowsOnAPage  => "+numRowsOnAPage+"\n"+"pageHeightForTable  => "+pageHeightForTable+"\n"+"totalNumPages  => "+totalNumPages+"\n");
	if (pageIndex >= totalNumPages)
	return NO_SUCH_PAGE;
	
	g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY()+22);
	
	// en bas au centre
	g2.drawString("Page: " + (pageIndex +1),
	(int)pageWidth/2 - 35, (int)(pageHeight + fontHeight - fontDescent)-20);
	
	g2.translate(0f, headerHeightOnPage);
	g2.translate(0f, -pageIndex*pageHeightForTable);
	
	// si cette partie de la page est plus petite
	// que la taille disponible, alors découper les contours appropriés
	if (pageIndex + 1 == totalNumPages) {
	int lastRowPrinted = numRowsOnAPage * pageIndex;
	int numRowsLeft = table.getRowCount() - lastRowPrinted;
	System.out.println("lastRowPrinted  => "+lastRowPrinted+"\n"+"numRowsLeft  => "+numRowsLeft+"\n");
	
	g2.setClip(0, (int)(pageHeightForTable * pageIndex),
	(int)Math.ceil(tableWidthOnPage),
	(int)Math.ceil(oneRowHeight * numRowsLeft));
	}
	// sinon découper la zone disponible toute entière
	else
	{
	g2.setClip(0, (int)(pageHeightForTable * pageIndex),
	(int)Math.ceil(tableWidthOnPage),
	(int)Math.ceil(pageHeightForTable));
	}
	g2.scale(scale, scale);
	table.paint(g2);
	
	// dessiner les entêtes en haut
	g2.scale(1/scale, 1/scale);
	g2.translate(0f, pageIndex*pageHeightForTable);
	g2.translate(0f, -headerHeightOnPage);
	g2.setClip(0,-22,
	(int)Math.ceil(tableWidthOnPage),
	(int)Math.ceil(headerHeightOnPage)+22);
	g2.scale(scale, scale);
	//g2.translate(0f, 50);
	table.getTableHeader().paint(g2);
	
	g2.translate(0f, 0);
	
	Font titleFont = defaultFont.deriveFont(Font.BOLD, 16);
	g2.setFont(titleFont);
	g2.setColor(Color.red);
	//g2.drawString("AL - BIR" ,0,0);
	//g2.drawString("17/10/2019 " ,(int)pageWidth- 150,0);
	g2.drawString(titre ,(int)pageWidth/3,0);
	/*g2.drawString("CM2/B " ,(int)pageWidth - 150,45);
	g2.drawString("Annee Scolaire : 2019-2020" ,0,45);*/
	g2.setFont(defaultFont);
	
	return Printable.PAGE_EXISTS;
}

} 