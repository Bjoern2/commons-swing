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

import java.awt.Component;

import com.googlecode.commons.swing.value.ValueGetter;
import com.googlecode.commons.swing.value.ValueGetterSetter;
import com.googlecode.commons.swing.value.ValueSetter;
import com.googlecode.commons.swing.value.ValueUtils;

public class Binding {

    private Component component;
    private ValueGetter valueGetter;
    private ValueSetter valueSetter;
    private String beanPropertyName;

    public Binding(Component component, String beanPropertyName) {
        super();
        this.component = component;
        this.valueGetter = ValueUtils.getInstance().getGetter(component.getClass());
        this.valueSetter = ValueUtils.getInstance().getSetter(component.getClass());
        this.beanPropertyName = beanPropertyName;
    }

    public Binding(Component component, ValueGetterSetter valueGetterSetter, String beanPropertyName) {
        super();
        this.component = component;
        this.valueGetter = valueGetterSetter;
        this.valueSetter = valueGetterSetter;
        this.beanPropertyName = beanPropertyName;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String getBeanPropertyName() {
        return beanPropertyName;
    }

    public void setBeanPropertyName(String beanPropertyName) {
        this.beanPropertyName = beanPropertyName;
    }

    public ValueGetter getValueGetter() {
        return valueGetter;
    }

    public void setValueGetter(ValueGetter valueGetter) {
        this.valueGetter = valueGetter;
    }

    public ValueSetter getValueSetter() {
        return valueSetter;
    }

    public void setValueSetter(ValueSetter valueSetter) {
        this.valueSetter = valueSetter;
    }

}
