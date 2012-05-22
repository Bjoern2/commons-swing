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
package com.googlecode.commons.swing.table.renderer;

import java.awt.Component;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DateTimeTableCellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 8236355339567075214L;
	
	protected DateFormat format;
	
	public DateTimeTableCellRenderer() {
		this(DateFormat.getDateTimeInstance());
	}
	
	public DateTimeTableCellRenderer(DateFormat format) {
		super();
		this.format = format;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof Date) {
			Date d = (Date)value;
			value = format.format(d);
		} else if (value instanceof Calendar) {
			Calendar cal = (Calendar)value;
			value = format.format(cal.getTime());
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

}
