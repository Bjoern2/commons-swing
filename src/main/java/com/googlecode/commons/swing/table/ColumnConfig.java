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
