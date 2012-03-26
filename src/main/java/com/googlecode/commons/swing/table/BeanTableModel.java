package com.googlecode.commons.swing.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.commons.lang3.Validate;

import com.googlecode.commons.swing.util.BeanUtils;

public class BeanTableModel<T> extends AbstractTableModel {

	private static final long serialVersionUID = -1409685116749001861L;
	
	protected final List<T> data = new ArrayList<T>();
	protected List<ColumnConfig> columns;
	
	public BeanTableModel(List<ColumnConfig> columns) {
		super();
		Validate.notNull(columns);
		this.columns = columns;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data.clear();
		if (data != null) {
		    this.data.addAll(data);
		}
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ColumnConfig col = columns.get(columnIndex);
		T row = data.get(rowIndex);
		return BeanUtils.getProperty(row, col.getName());
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ColumnConfig col = columns.get(columnIndex);
		T row = data.get(rowIndex);
		BeanUtils.setProperty(row, col.getName(), aValue);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		ColumnConfig col = columns.get(columnIndex);
		return (col.getEditor() != null);
	}

	@Override
	public String getColumnName(int column) {
		ColumnConfig col = columns.get(column);
		return col.getTitle();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return super.getColumnClass(columnIndex);
	}
	
}
