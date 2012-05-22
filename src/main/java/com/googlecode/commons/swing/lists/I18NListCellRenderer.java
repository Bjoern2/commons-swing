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
package com.googlecode.commons.swing.lists;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import org.apache.commons.lang3.Validate;

import com.googlecode.commons.swing.resources.I18N;

public class I18NListCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = -9179602426631835612L;
    
    private I18N i18n;
    private String prefix;
    private String nullValue;
    
    public I18NListCellRenderer(I18N i18n) {
        this(i18n, "", "");
    }
    
    public I18NListCellRenderer(I18N i18n, String prefix) {
        this(i18n, prefix, "");
    }
    
    public I18NListCellRenderer(I18N i18n, String prefix, String nullValue) {
        super();
        Validate.notNull(i18n, "i18n cannot be null.");
        Validate.notNull(prefix, "prefix cannot be null.");
        this.i18n = i18n;
        this.prefix = prefix;
        this.nullValue = nullValue;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        final String defaultValue = (value == null) ? nullValue : "" + value;
        value = i18n.getString(prefix + value, defaultValue);
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }

}
