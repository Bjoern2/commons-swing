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
package com.googlecode.commons.swing.layout;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagFactory {

	protected int column = 0;
	protected int row = 0;
	protected int colSpan = 1;
	protected int rowSpan = 1;
	protected double colWeight = 0.0;
	protected double rowWeight = 0.0;
	protected Anchor anchor = Anchor.CENTER;
	protected Fill fill = Fill.NONE;
	protected Insets insets = new Insets(0, 0, 0, 0);
	protected int ipadx = 0;
	protected int ipady = 0;
	
	protected int rowCount = 1;
	protected int columnCount = 1;
	
	public enum Anchor {
		CENTER(GridBagConstraints.CENTER),
		NORTH(GridBagConstraints.NORTH),
		NORTHEAST(GridBagConstraints.NORTHEAST),
	    EAST(GridBagConstraints.EAST),
	    SOUTHEAST(GridBagConstraints.SOUTHEAST),
	    SOUTH(GridBagConstraints.SOUTH),
	    SOUTHWEST(GridBagConstraints.SOUTHWEST),
	    WEST(GridBagConstraints.WEST),
	    NORTHWEST(GridBagConstraints.NORTHWEST),
	    
	    PAGE_START(GridBagConstraints.PAGE_START),
	    PAGE_END(GridBagConstraints.PAGE_END),
	    LINE_START(GridBagConstraints.LINE_START),
	    LINE_END(GridBagConstraints.LINE_END), 
	    FIRST_LINE_START(GridBagConstraints.FIRST_LINE_START), 
	    FIRST_LINE_END(GridBagConstraints.FIRST_LINE_END), 
	    LAST_LINE_START(GridBagConstraints.LAST_LINE_START),
	    LAST_LINE_END(GridBagConstraints.LAST_LINE_END),
	    
	    BASELINE(GridBagConstraints.BASELINE),
	    BASELINE_LEADING(GridBagConstraints.BASELINE_LEADING),
	    BASELINE_TRAILING(GridBagConstraints.BASELINE_TRAILING),
	    ABOVE_BASELINE(GridBagConstraints.ABOVE_BASELINE), 
	    ABOVE_BASELINE_LEADING(GridBagConstraints.ABOVE_BASELINE_LEADING),
	    ABOVE_BASELINE_TRAILING(GridBagConstraints.ABOVE_BASELINE_TRAILING),
	    BELOW_BASELINE(GridBagConstraints.BELOW_BASELINE),
	    BELOW_BASELINE_LEADING(GridBagConstraints.BELOW_BASELINE_LEADING),
	    BELOW_BASELINE_TRAILING(GridBagConstraints.BELOW_BASELINE_TRAILING);
		
		private int c;
		
		private Anchor(int c) {
			this.c = c;
		}
		
		public int toInt() {
			return c;
		}
	}
	
	public enum Fill {
		NONE(GridBagConstraints.NONE),
		BOTH(GridBagConstraints.BOTH),
		HORIZONTAL(GridBagConstraints.HORIZONTAL),
		VERTICAL(GridBagConstraints.VERTICAL);
		
		private int c;
		
		private Fill(int c) {
			this.c = c;
		}
		
		public int toInt() {
			return c;
		}
	}
	
	public GridBagConstraints create() {
		GridBagConstraints c = new GridBagConstraints(column, row, colSpan, rowSpan, colWeight, rowWeight, anchor.toInt(), fill.toInt(), insets, ipadx, ipady);
		return c;
	}
	
	public GridBagConstraints create(int x, int y) {
		GridBagConstraints c = new GridBagConstraints(x, y, colSpan, rowSpan, colWeight, rowWeight, anchor.toInt(), fill.toInt(), insets, ipadx, ipady);
		return c;
	}
	
	public GridBagFactory nextColumn() {
		column = column + 1;
		if ((column + 1) > columnCount) {
			columnCount = (row + 1);
		}
		return this;
	}
	
	public GridBagFactory resetColumn() {
		column = 0;
		return this;
	}
	
	public GridBagFactory nextRow() {
		row = row + 1;
		if ((row + 1) > rowCount) {
			rowCount = (row + 1);
		}
		return this;
	}
	
	public GridBagFactory resetRow() {
		row = 0;
		return this;
	}
	
	public GridBagFactory reset() {
		column = 0;
		row = 0;
		rowSpan = 1;
		colSpan = 1;
		rowCount = 1;
		columnCount = 1;
		return this;
	}

	public Fill getFill() {
		return fill;
	}

	public GridBagFactory setFill(Fill fill) {
		this.fill = fill;
		return this;
	}

	public Insets getInsets() {
		return insets;
	}

	public GridBagFactory setInsets(Insets insets) {
		this.insets = insets;
		return this;
	}

	public Anchor getAnchor() {
		return anchor;
	}

	public GridBagFactory setAnchor(Anchor anchor) {
		this.anchor = anchor;
		return this;
	}

	public double getColWeight() {
		return colWeight;
	}

	public GridBagFactory setColWeight(double colWeight) {
		this.colWeight = colWeight;
		return this;
	}

	public double getRowWeight() {
		return rowWeight;
	}

	public GridBagFactory setRowWeight(double rowWeight) {
		this.rowWeight = rowWeight;
		return this;
	}

	public int getColSpan() {
		return colSpan;
	}

	public GridBagFactory setColSpan(int colSpan) {
		this.colSpan = colSpan;
		return this;
	}
	
	public GridBagFactory setColSpanToColCount() {
		this.colSpan = columnCount;
		return this;
	}

	public int getRowSpan() {
		return rowSpan;
	}

	public GridBagFactory setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
		return this;
	}
	
	public GridBagFactory setRowSpanToRowCount() {
		this.rowSpan = rowCount;
		return this;
	}

	public int getRowCount() {
		return rowCount;
	}
	
	public int getColumnCount() {
		return columnCount;
	}
	
}
