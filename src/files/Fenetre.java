package files;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
 

import Model.Apprenant;
 
public class Fenetre extends JFrame {
  
   
    Map<Integer,Integer> row_table  = new HashMap<Integer,Integer>();
  
 
  public Fenetre(){
       
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("JTable");
    this.setSize(600, 140);
    
    try{
	 ResultSet resultat = new Apprenant().selectApprenant(); 
     //resultat.last();

      
     String  title[] = {"Matricule","Nom & Prenom","Sexe","Contact","Actions"};
     //int rowCount = resultat.getRow();
 
     Object[][] data  = new Object[22][5];
 
     JTable tableau = new JTable(data,title);
      
    // this.tableau = new JTable(model);
    tableau.getColumn("Actions").setCellRenderer(new ButtonRenderer());
      
     this.add(new JScrollPane(tableau), BorderLayout.CENTER);
      
      
      
     int i=0;
        //resultat.beforeFirst(); // on repositionne le curseur avant la première ligne
        while(resultat.next()) //tant qu'on a quelque chose à lire
        {  
            //Remplire le tableau à deux dimensions Data[][]
            for(int j=1;j<=5;j++)
            {
                 if(j != 5)data[i][j-1]=resultat.getObject(j)+"";
                 else data[i][j-1] = new JButton("Supprimer");
                  
            }
             
            i++;
            row_table.put(i, resultat.getInt("Matricule"));
             
        }

    }
    catch(SQLException ex){
    System.out.println(ex);
    }
     
     
  }
   
   
   
   
 
  @SuppressWarnings("serial")
//Classe modèle personnalisée
  class ZModel extends AbstractTableModel
  {
    private Object[][] data;
    private String[] title;
 
    //Constructeur
    public ZModel(Object[][] data, String[] title){
      this.data = data;
      this.title = title;
    }
 
    //Retourne le nombre de colonnes
    public int getColumnCount() {
      return this.title.length;
    }
 
    //Retourne le nombre de lignes
    public int getRowCount() {
      return this.data.length;
    }
 
    //Retourne la valeur à l'emplacement spécifié
    public Object getValueAt(int row, int col) {
      return this.data[row][col];
    }   
   
  }
   
 
  @SuppressWarnings("serial")
public class ButtonRenderer extends JButton implements TableCellRenderer{
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
      //On écrit dans le bouton ce que contient la cellule
      setText("Suprimer");
      //On retourne notre bouton
      return this;
     
    }
  }
   
 
 
  public static void main(String[] args){
    Fenetre fen = new Fenetre();
    fen.setVisible(true);
  }
}