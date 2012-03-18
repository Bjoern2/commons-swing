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
