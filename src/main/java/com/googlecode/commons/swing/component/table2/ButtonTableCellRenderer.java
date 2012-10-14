package com.googlecode.commons.swing.component.table2;

import javax.swing.JButton;

public class ButtonTableCellRenderer extends AbstractTableCellRenderer implements TableCellRenderer {

    @Override
    public TableCell render(Object value, int rowIndex, int colIndex, ColumnConfig column) {
        TableCell cell = super.render(value, rowIndex, colIndex, column);
        JButton btn = new JButton();
        if (value != null) {
            btn.setText(value.toString());
        }
        cell.add(btn);
        return cell;
    }

}
