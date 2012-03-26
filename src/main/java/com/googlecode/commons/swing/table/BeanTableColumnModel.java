package com.googlecode.commons.swing.table;

import java.util.List;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class BeanTableColumnModel extends DefaultTableColumnModel {

    private static final long serialVersionUID = 3658772596463986621L;
    
    protected List<ColumnConfig> columns;

    public BeanTableColumnModel(List<ColumnConfig> columns) {
        super();
        this.columns = columns;
        for (int i = 0; i < columns.size(); i++) {
            ColumnConfig config = columns.get(i);
            
            TableColumn col = new TableColumn();
            col.setModelIndex(i);
            col.setCellRenderer(config.getRenderer());
            col.setCellEditor(config.getEditor());
            col.setWidth(config.getWidth());
            col.setHeaderValue(config.getTitle());
            col.setIdentifier(config.getName());
            addColumn(col);
        }
        
    }
    
}
