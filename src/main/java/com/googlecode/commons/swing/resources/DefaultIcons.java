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
package com.googlecode.commons.swing.resources;

import javax.swing.ImageIcon;

public class DefaultIcons extends Resources {

	private static DefaultIcons instance;
	
	private DefaultIcons() {
		// Empty
	}
	
	private static DefaultIcons getInstance() {
		if (instance == null) {
			instance = new DefaultIcons();
		}
		return instance;
	}
	
	public static ImageIcon exclamation() {
		return getImageIcon("exclamation.png");
	}
	
	public static ImageIcon resultset_next() {
		return getImageIcon("resultset_next.png");
	}
	
	public static ImageIcon resultset_previous() {
		return getImageIcon("resultset_previous.png");
	}
	
	public static ImageIcon getImageIcon(String name) {
		return getInstance().loadImageIcon(name);
	}
	
}
