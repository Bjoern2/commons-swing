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
