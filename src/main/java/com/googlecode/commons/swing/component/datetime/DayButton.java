package com.googlecode.commons.swing.component.datetime;

import java.util.Date;

import javax.swing.JToggleButton;

public class DayButton extends JToggleButton {

	private static final long serialVersionUID = -6099662047444463605L;

	protected int weekdayNumber;
	protected String weekdayName;
	protected Date value;

	public int getWeekdayNumber() {
		return weekdayNumber;
	}

	public void setWeekdayNumber(int weekdayNumber) {
		this.weekdayNumber = weekdayNumber;
	}

	public String getWeekdayName() {
		return weekdayName;
	}

	public void setWeekdayName(String weekdayName) {
		this.weekdayName = weekdayName;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

}
