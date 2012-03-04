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

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.apache.commons.lang3.StringUtils;

import com.googlecode.commons.swing.resources.DefaultIcons;
import com.googlecode.commons.swing.validate.ValidationNotifier;


public class FormNotifier extends JLabel implements ValidationNotifier {

	private static final long serialVersionUID = -7255035645341421739L;

	protected final Map<Component, String> invalidComponents = new HashMap<Component, String>();
	
	protected ImageIcon iconError = DefaultIcons.exclamation();
	protected Border borderError = new LineBorder(Color.RED, 1);
	
	public FormNotifier() {
		super();
		setIcon(iconError);
		setBorder(borderError);
		setBackground(Color.RED);
		setVerticalTextPosition(JLabel.TOP);
	}
	
	public void setValid(Component source, boolean valid, String message) {
		if (!valid) {
			invalidComponents.put(source, message);
		}
		else {
			invalidComponents.remove(source);
			
		}
		setText(generateMessages());
		setVisible(!invalidComponents.isEmpty());
	}
	
	private String generateMessages() {
		List<String> lines = new ArrayList<String>();
		for (Entry<Component, String> comp : invalidComponents.entrySet()) {
			String line = "";
			if (!StringUtils.isBlank(comp.getKey().getName())) {
				line += comp.getKey().getName() + ": ";
			}
			line += comp.getValue();
			lines.add(line);
		}
		
		String messages = "<html>" + StringUtils.join(lines, "<br/>") + "</html>";
		return messages;
	}

}
