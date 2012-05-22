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

import org.apache.commons.beanutils.BeanMap;

public class GenericValueGetterSetter implements ValueGetterSetter {

	private String getterName;
	private String setterName;
	
	public GenericValueGetterSetter(String fieldName) {
		this.getterName = fieldName;
		this.setterName = fieldName;
	}

	public Object getValue(Component component) {
		BeanMap map = new BeanMap(component);
		return map.get(getterName);
	}

	public void setValue(Component component, Object value) {
		BeanMap map = new BeanMap(component);
		map.put(setterName, value);
	}

}
