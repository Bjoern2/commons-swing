package com.googlecode.commons.swing.component.table2;


public interface TableCellRenderer {

    TableCell render(Object value, int rowIndex, int colIndex, ColumnConfig column);
    
    int getRowSpan(int row, int col);
    int getColumnSpan(int row, int col);
    
    double getRowWeight(int row, int col);
    double getColumnWeight(int row, int col);
    
}
