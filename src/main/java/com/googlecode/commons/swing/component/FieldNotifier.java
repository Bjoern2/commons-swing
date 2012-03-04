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
package com.googlecode.commons.swing.component;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.googlecode.commons.swing.resources.DefaultIcons;
import com.googlecode.commons.swing.validate.ValidationNotifier;


public class FieldNotifier extends JLabel implements ValidationNotifier {

	private static final long serialVersionUID = 1059935470139821368L;
	
	protected ImageIcon iconOK;
	protected ImageIcon iconError = DefaultIcons.exclamation();
	
	public void setValid(Component source, boolean valid, String message) {
		if (valid) {
			this.setIcon(iconOK);
		}
		else {
			this.setIcon(iconError);
		}
		
	}

}
