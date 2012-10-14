package com.googlecode.commons.swing.component.table2;

import java.awt.Color;


public abstract class AbstractTableCellRenderer implements TableCellRenderer {

    @Override
    public int getRowSpan(int row, int col) {
        return 1;
    }

    @Override
    public int getColumnSpan(int row, int col) {
        return 1;
    }

    @Override
    public double getRowWeight(int row, int col) {
        return 0.0;
    }

    @Override
    public double getColumnWeight(int row, int col) {
        return 1.0;
    }

    @Override
    public TableCell render(Object value, int rowIndex, int colIndex, ColumnConfig column) {
        TableCell cell = new TableCell();
        cell.setOpaque(true);
        cell.setBackground(rowIndex % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
        return cell;
    }

}
