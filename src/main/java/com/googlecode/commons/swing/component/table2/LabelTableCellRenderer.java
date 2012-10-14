package com.googlecode.commons.swing.component.table2;

import javax.swing.JLabel;

public class LabelTableCellRenderer extends AbstractTableCellRenderer implements TableCellRenderer {

    @Override
    public TableCell render(Object value, int rowIndex, int colIndex, ColumnConfig column) {
        TableCell cell = super.render(value, rowIndex, colIndex, column);
        
        JLabel lbl = new JLabel();
        lbl.setOpaque(false);
        if (value != null) {
            lbl.setText(value.toString());
        }
        cell.add(lbl);
        
        return cell;
    }

}
