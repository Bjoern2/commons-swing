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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.googlecode.commons.swing.value.GenericValueGetterSetter;
import com.googlecode.commons.swing.value.ValueGetter;
import com.googlecode.commons.swing.value.ValueUtils;

public class ValidationGroup {

	private Component component;
	private ValueGetter valueGetter;
	private Validator validator;
	private final Set<ValidationNotifier> notifiers = new HashSet<ValidationNotifier>();
	
	public ValidationGroup(Component component, Validator validator, ValidationNotifier notifier) {
		super();
		this.component = component;
		this.valueGetter = ValueUtils.getInstance().getGetter(component.getClass());
		this.validator = validator;
		if (notifier != null) {
			this.notifiers.add(notifier);
		}
	}
	
	public ValidationGroup(Component component, ValueGetter valueGetter, Validator validator, ValidationNotifier notifier) {
		super();
		this.component = component;
		this.valueGetter = valueGetter;
		this.validator = validator;
		if (notifier != null) {
			this.notifiers.add(notifier);
		}
	}
	
	public ValidationGroup(Component component, String valueFieldName, Validator validator, ValidationNotifier notifier) {
		super();
		this.component = component;
		this.valueGetter = new GenericValueGetterSetter(valueFieldName);
		this.validator = validator;
		if (notifier != null) {
			this.notifiers.add(notifier);
		}
	}
	
	public ValidationGroup(Component component, Validator validator, Collection<ValidationNotifier> notifiers) {
		super();
		this.component = component;
		this.valueGetter = ValueUtils.getInstance().getGetter(component.getClass());
		this.validator = validator;
		this.notifiers.addAll(notifiers);
	}
	
	public ValidationGroup(Component component, Validator validator, ValidationNotifier... notifiers) {
		super();
		this.component = component;
		this.valueGetter = ValueUtils.getInstance().getGetter(component.getClass());
		this.validator = validator;
		this.notifiers.addAll(Arrays.asList(notifiers));
	}

	public boolean validate() {
		Object o = valueGetter.getValue(component);
		boolean valid = validator.isValid(o);
		for (ValidationNotifier n : notifiers) {
			n.setValid(component, valid, validator.getMessage());
		}
		return valid;
	}
	
}
