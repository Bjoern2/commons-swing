package com.googlecode.commons.swing.component.table2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.googlecode.commons.swing.util.BeanUtils;

public class BeanTableModel<T> implements TableModel {

    protected List<ColumnConfig> columns;
    protected List<T> data;
    
    public BeanTableModel(List<ColumnConfig> columns, List<T> data) {
        super();
        this.columns = columns;
        this.data = data;
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
        return data.size();
    }

    @Override
    public Object getValue(int rowIndex, int colIndex) {
        ColumnConfig col = getColumns().get(colIndex);
        T row = data.get(rowIndex);
        
        if (StringUtils.isBlank(col.getId())) {
            return null;
        }
        return BeanUtils.getProperty(row, col.getId());
    }

}
