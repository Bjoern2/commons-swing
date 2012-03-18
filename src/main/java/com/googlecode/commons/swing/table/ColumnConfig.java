package com.googlecode.commons.swing.table;

import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ColumnConfig {

	protected String name;
	protected String title;
	protected TableCellRenderer renderer;
	protected TableCellEditor editor;
	protected int width;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TableCellRenderer getRenderer() {
		return renderer;
	}

	public void setRenderer(TableCellRenderer renderer) {
		this.renderer = renderer;
	}

	public TableCellEditor getEditor() {
		return editor;
	}

	public void setEditor(TableCellEditor editor) {
		this.editor = editor;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
