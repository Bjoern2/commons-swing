/**
 * Copyright 2012 Björn Schmitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
