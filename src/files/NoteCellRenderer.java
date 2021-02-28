package files;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class NoteCellRenderer extends DefaultTableCellRenderer {
@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);
		
		Double note = (Double) value;
		setText(note.toString());
		
		
		setBackground(Color.RED);
		
		return this;
	}
}