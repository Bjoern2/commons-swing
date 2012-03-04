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
package com.googlecode.commons.swing.value;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.text.JTextComponent;

public class ValueUtils {

	private Map<Class<?>, ValueGetter> getters = new HashMap<Class<?>, ValueGetter>();
	private Map<Class<?>, ValueSetter> setters = new HashMap<Class<?>, ValueSetter>();

	private static ValueUtils instance;
	
	public ValueUtils() {
		addGetterAndSetter(JTextComponent.class, new GenericValueGetterSetter("text"));
		addGetterAndSetter(JComboBox.class, new GenericValueGetterSetter("selectedItem"));
		addGetterAndSetter(JToggleButton.class, new GenericValueGetterSetter("selected"));
	}
	
	public static ValueUtils getInstance() {
		if (instance == null) {
			instance = new ValueUtils();
		}
		return instance;
	}
	
	public void addGetterAndSetter(Class<?> type, ValueGetterSetter o) {
		getters.put(type, o);
		setters.put(type, (ValueSetter)o);
	}
	
	public void addGetter(Class<?> type, ValueGetter getter) {
		getters.put(type, getter);
	}
	
	public void addSetter(Class<?> type, ValueSetter setter) {
		setters.put(type, setter);
	}
	
	public <T> T getValue(Component c) {
		if (c == null) {
			return null;
		}
		ValueGetter getter = getGetter(c.getClass());
		return (T)getter.getValue(c);
	}
	
	public ValueGetter getGetter(Class<?> clazz) {
		if (getters.containsKey(clazz)) {
			return getters.get(clazz);
		}
		else {
			Class<?> superClazz = clazz.getSuperclass();
			if (superClazz != null) {
				return getGetter(superClazz);
			}
		}
		return null;
	}
	
	public ValueSetter getSetter(Class<?> clazz) {
		if (setters.containsKey(clazz)) {
			return setters.get(clazz);
		}
		else {
			Class<?> superClazz = clazz.getSuperclass();
			if (superClazz != null) {
				return getSetter(superClazz);
			}
		}
		return null;
	}
	
	public void setValue(Component component, Object value) {
		ValueSetter setter = setters.get(component.getClass());
		if (setter != null) {
			setter.setValue(component, value);
		}
	}
	
}
