/**
 * Copyright 2012 Bj�rn Schmitz
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

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class AbstractI18N implements I18N {
	
	protected ResourceBundle bundle;

	public String getString(String key) {
		return getBundle().getString(key);
	}
	
	public String getString(String key, String defaultValue) {
		try {
			return getBundle().getString(key);
		}
		catch (MissingResourceException ex) {
			return defaultValue;
		}
	}
	
	protected ResourceBundle getBundle() {
		if (bundle == null) {
			String baseName = getClass().getName();
			bundle = ResourceBundle.getBundle(baseName);
		}
		return bundle;
	}
	
}
