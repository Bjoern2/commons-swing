package com.googlecode.commons.swing.component.table2;

public class ColumnConfig {

    protected String id;
    protected String name;
    protected TableCellRenderer headerRenderer;
    protected TableCellRenderer renderer;
    protected int preferredWidth = 50;
    protected int minimumWidth = 50;
    protected int maximumWidth = 200;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TableCellRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(TableCellRenderer renderer) {
        this.renderer = renderer;
    }

    public TableCellRenderer getHeaderRenderer() {
        return headerRenderer;
    }

    public void setHeaderRenderer(TableCellRenderer headerRenderer) {
        this.headerRenderer = headerRenderer;
    }

    public int getPreferredWidth() {
        return preferredWidth;
    }

    public void setPreferredWidth(int preferredWidth) {
        this.preferredWidth = preferredWidth;
    }

    public int getMinimumWidth() {
        return minimumWidth;
    }

    public void setMinimumWidth(int minimumWidth) {
        this.minimumWidth = minimumWidth;
    }

    public int getMaximumWidth() {
        return maximumWidth;
    }

    public void setMaximumWidth(int maximumWidth) {
        this.maximumWidth = maximumWidth;
    }

}
