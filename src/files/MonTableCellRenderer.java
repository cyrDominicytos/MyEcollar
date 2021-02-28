package files;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
 
 
public class MonTableCellRenderer extends /*JButton*/ DefaultTableCellRenderer implements TableCellRenderer, TableCellEditor
{
 
 
	private static final long serialVersionUID = -8394075315459088090L;
	private Object value;
	private JButton button = new JButton (new ImageIcon("/icones/check.png"));
	
	
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
       // setText((value==null)?"":value.toString());
    	//setForeground(table.getSelectionForeground());
       // setBackground(table.getSelectionBackground());
        //setText("Voir Plus");
    	super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);

		//Double note = (Double) value;
		setText("Voir Plus");
		setBackground(Color.RED);
		

        return button;
    }
 
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
    	
    	//super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);

		//Double note = (Double) value;
		setText("Voir Plus");
		setBackground(Color.RED);
		
        this.value=value;
        System.out.println(this.value);
        setText((value==null)?"":value.toString());
       /* addActionListener(new ActionListener()
        {
 
            public void actionPerformed(ActionEvent e)
            {
            	 System.out.println(value);
            }
 
 
 
        });*/
        return this;
    }
 
    public void cancelCellEditing(){}
 
    public boolean stopCellEditing(){
        return false;
    }
 
    public Object getCellEditorValue(){
        return value;
    }
 
    public boolean isCellEditable(EventObject anEvent){
        return true;
    }
 
    public boolean shouldSelectCell(EventObject anEvent){
        return false;
    }
 
    public void addCellEditorListener(CellEditorListener l){}
 
    public void removeCellEditorListener(CellEditorListener l){}
    
    
 
}