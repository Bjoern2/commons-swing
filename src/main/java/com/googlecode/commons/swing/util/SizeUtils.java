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
package com.googlecode.commons.swing.util;

import java.awt.Component;
import java.awt.Dimension;

public class SizeUtils {

	public static  void setWidth(Component c, int width) {
		c.setSize(width, c.getSize().height);
	}
	
	public static void setMaxWidth(Component c, int width) {
		c.setMaximumSize(new Dimension(width, c.getMaximumSize().height));
	}
	
	public static void setMinWidth(Component c, int width) {
		c.setMinimumSize(new Dimension(width, c.getMinimumSize().height));
	}
	
	public static void setPreferredWidth(Component c, int width) {
		c.setPreferredSize(new Dimension(width, c.getPreferredSize().height));
	}
	
	public static void setAllWidths(Component c, int width) {
		setWidth(c, width);
		setMinWidth(c, width);
		setMaxWidth(c, width);
		setPreferredWidth(c, width);
	}
	
	public static  void setHeight(Component c, int height) {
		c.setSize(c.getSize().width, height);
	}
	
	public static void setMaxHeight(Component c, int height) {
		c.setMaximumSize(new Dimension(c.getMaximumSize().width, c.getMaximumSize().height));
	}
	
	public static void setMinHeight(Component c, int height) {
		c.setMinimumSize(new Dimension(c.getMinimumSize().width, height));
	}
	
	public static void setPreferredHeight(Component c, int height) {
		c.setPreferredSize(new Dimension(c.getPreferredSize().width, height));
	}
	
	public static void setAllHeights(Component c, int height) {
		setHeight(c, height);
		setMinHeight(c, height);
		setMaxHeight(c, height);
		setPreferredHeight(c, height);
	}
	
}
