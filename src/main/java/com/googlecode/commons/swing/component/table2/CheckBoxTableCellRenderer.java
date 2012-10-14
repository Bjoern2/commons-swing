package com.googlecode.commons.swing.component.table2;

import javax.swing.JCheckBox;

import com.googlecode.commons.swing.util.SizeUtils;

public class CheckBoxTableCellRenderer extends AbstractTableCellRenderer implements TableCellRenderer {

    @Override
    public TableCell render(Object value, int rowIndex, int colIndex, ColumnConfig column) {
        TableCell cell = super.render(value, rowIndex, colIndex, column);
        
        JCheckBox chk = new JCheckBox();
        chk.setOpaque(false);
        chk.setFocusable(false);
        SizeUtils.setMinWidth(chk, 20);
        SizeUtils.setPreferredWidth(chk, 20);
        if (value instanceof Boolean) {
            Boolean b = (Boolean)value;
            chk.setSelected(b);
        }
        cell.add(chk);
        
        return cell;
    }

    @Override
    public double getColumnWeight(int row, int col) {
        return 0.0;
    }

}
