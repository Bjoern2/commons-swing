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
package com.googlecode.commons.swing.validate;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.event.EventListenerList;
import javax.swing.text.JTextComponent;

public class Validators {

	private Set<ValidationGroup> groups = new HashSet<ValidationGroup>();
	
	protected EventListenerList listenerList = new EventListenerList();
	
	public void add(Component component, Validator validator, ValidationNotifier notifier) {
		add(component, validator, Arrays.asList(notifier));
	}
	
	public void add(Component component, Validator validator, ValidationNotifier... notifiers) {
		add(component, validator, Arrays.asList(notifiers));
	}
	
	public void add(Component component, Validator validator, List<ValidationNotifier> notifiers) {
		final ValidationGroup grp = new ValidationGroup(component, validator, notifiers);
		groups.add(grp);
		component.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				revalidate();
			}
		});
		if (component instanceof JTextComponent) {
			JTextComponent txt = (JTextComponent)component;
			txt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					revalidate();
				}
			});
		}
		if (component instanceof JComboBox) {
			JComboBox cmb = (JComboBox)component;
			cmb.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					revalidate();
				}
			});
		}
	}
	
	public boolean revalidate() {
		boolean isValid = isValid();
		fireValidate(isValid);
		return isValid;
	}
	
	public boolean isValid() {
		boolean isValid = true;
		for (ValidationGroup g : groups) {
			if (!g.validate()) {
				isValid = false;
			}
		}
		return isValid;
	}
	
	protected void fireValidate(boolean valid) {
		ValidationListener[] listeners = this.listenerList.getListeners(ValidationListener.class);
		for (ValidationListener l : listeners) {
			l.validate(valid);
		}
	}
	
	public void addValidationListener(ValidationListener l) {
		this.listenerList.add(ValidationListener.class, l);
	}
	
	public void removeValidationListener(ValidationListener l) {
		this.listenerList.remove(ValidationListener.class, l);
	}
	
}
