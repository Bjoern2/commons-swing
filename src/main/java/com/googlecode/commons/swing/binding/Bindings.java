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
package com.googlecode.commons.swing.binding;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanMap;

public class Bindings<M> {

	private M model;
	private Set<Binding> bindings = new HashSet<Binding>();
	
	public void addBinding(Binding b) {
		bindings.add(b);
	}

	public void bind(M model) {
		this.model = model;
		final BeanMap map = new BeanMap(model);
		for (Binding b : bindings) {
			Object value = map.get(b.getBeanPropertyName());
			b.getValueSetter().setValue(b.getComponent(), value);
		}
	}
	
	public M getModel() {
		BeanMap map = new BeanMap(model);
		for (Binding b : bindings) {
			Object value = b.getValueGetter().getValue(b.getComponent());
			map.put(b.getBeanPropertyName(), value);
		}
		return (M)map.getBean();
		
	}
	
}
