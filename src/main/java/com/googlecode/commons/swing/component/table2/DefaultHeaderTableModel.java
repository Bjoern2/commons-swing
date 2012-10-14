package com.googlecode.commons.swing.component.table2;

import java.util.List;

public class DefaultHeaderTableModel implements TableModel {

    protected List<ColumnConfig> columns;
    
    public DefaultHeaderTableModel(List<ColumnConfig> columns) {
        super();
        this.columns = columns;
    }

    @Override
    public List<ColumnConfig> getColumns() {
        return columns;
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public Object getValue(int row, int col) {
        return getColumns().get(col).getName();
    }

}
