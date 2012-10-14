package com.googlecode.commons.swing.component.table2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

import com.googlecode.commons.swing.layout.GridBagFactory;
import com.googlecode.commons.swing.layout.GridBagFactory.Anchor;
import com.googlecode.commons.swing.layout.GridBagFactory.Fill;
import com.googlecode.commons.swing.util.SizeUtils;

public class TablePlus extends JComponent {

    private static final long serialVersionUID = 2117880320511848291L;
    
    protected TableModel headerModel;
    protected TableModel contentModel;
//    protected TableCellRenderer cellRenderer;
    
    protected Container header;
    protected Container content;
    protected Container footer;
    
    
    public TablePlus(TableModel headerModel, TableModel contentModel) {
        super();
        this.headerModel = headerModel == null ? new DefaultHeaderTableModel(contentModel.getColumns()) : headerModel;
        this.contentModel = contentModel;
        init();
    }
    
    protected void init() {
        setLayout(new BorderLayout());
        
        header = new Container();
        add(new JScrollPane(header, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.NORTH);
        
        content = new Container();
        add(new JScrollPane(content), BorderLayout.CENTER);
        
        render();
    }
    
    protected void render() {
        header.removeAll();
        header.setLayout(new GridBagLayout());
        
        content.removeAll();
        content.setLayout(new GridBagLayout());
        
        final List<ColumnConfig> cols = contentModel.getColumns();
        
        // Header:
        for (int rowIndex = 0; rowIndex < headerModel.getRowCount(); rowIndex++) {
            for (int colIndex = 0; colIndex < headerModel.getColumnCount(); colIndex++) {
                ColumnConfig col = cols.get(colIndex);
                TableCellRenderer renderer = col.getHeaderRenderer();
                if (renderer == null) {
                    renderer = new HeaderTableCellRenderer();
                }
                TableCell c = renderer.render(headerModel.getValue(rowIndex, colIndex), rowIndex, colIndex, col);
                SizeUtils.setPreferredWidth(c, col.getPreferredWidth());
                SizeUtils.setPreferredWidth(c, col.getMaximumWidth());
                SizeUtils.setPreferredWidth(c, col.getMinimumWidth());
                
                
                final GridBagFactory f = new GridBagFactory();
                f.setAnchor(Anchor.CENTER);
                f.setFill(Fill.BOTH);
                f.setColumn(colIndex);
                f.setRow(0);
                f.setRowWeight(renderer.getRowWeight(rowIndex, colIndex));
                f.setColWeight(renderer.getColumnWeight(rowIndex, colIndex));
                f.setColSpan(renderer.getColumnSpan(rowIndex, colIndex));
                f.setRowSpan(renderer.getRowSpan(rowIndex, colIndex));
    
                header.add(c, f.create());
            }
        }
        
//        Component scrollBarHelper = Box.createGlue();
//        header.add(scrollBarHelper);
//        
//        Object objW = UIManager.get("ScrollBar.width");
//        int w = NumberUtils.toInt(objW.toString());
//        SizeUtils.setAllWidths(scrollBarHelper, w);
        
        
        // Content:
        for (int rowIndex = 0; rowIndex < contentModel.getRowCount(); rowIndex++) {
            for (int colIndex = 0; colIndex < contentModel.getColumnCount(); colIndex++) {
                ColumnConfig col = cols.get(colIndex);
                TableCellRenderer renderer = col.getRenderer();
                
                TableCell c = renderer.render(contentModel.getValue(rowIndex, colIndex), rowIndex, colIndex, col);
                SizeUtils.setPreferredWidth(c, col.getPreferredWidth());
                SizeUtils.setPreferredWidth(c, col.getMaximumWidth());
                SizeUtils.setPreferredWidth(c, col.getMinimumWidth());
                
                final GridBagFactory f = new GridBagFactory();
                f.setAnchor(Anchor.CENTER);
                f.setFill(Fill.BOTH);
                f.setColumn(colIndex);
                f.setRow(rowIndex);
                f.setRowWeight(renderer.getRowWeight(rowIndex, colIndex));
                f.setColWeight(renderer.getColumnWeight(rowIndex, colIndex));
                f.setColSpan(renderer.getColumnSpan(rowIndex, colIndex));
                f.setRowSpan(renderer.getRowSpan(rowIndex, colIndex));

                content.add(c, f.create());
            }
        }
        
        // Add Spacer
//        Component spacer = Box.createGlue();
//        final GridBagFactory f = new GridBagFactory();
//        f.setAnchor(Anchor.CENTER);
//        f.setFill(Fill.BOTH);
//        f.setColumn(0);
//        f.setRow(contentModel.getRowCount());
//        f.setColWeight(1.0);
//        f.setRowWeight(1.0);
//        content.add(spacer, f.create());
    }
    
    
}

