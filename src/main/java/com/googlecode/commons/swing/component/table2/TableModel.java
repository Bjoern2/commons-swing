package com.googlecode.commons.swing.component.table2;

import java.util.List;

public interface TableModel {

    List<ColumnConfig> getColumns();
    int getColumnCount();
    int getRowCount();

    Object getValue(int row, int col);
    
}
