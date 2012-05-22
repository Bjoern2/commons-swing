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
package com.googlecode.commons.swing.resources;

public class DefaultI18N extends AbstractI18N {

	private static DefaultI18N instance;
	
	public static DefaultI18N getInstance() {
		if (instance == null) {
			instance = new DefaultI18N();
		}
		return instance;
	}
	
	public String validation_email_incorrect() {
		return getString("validation_email_incorrect");
	}
	
	public String validation_is_empty() {
		return getString("validation_is_empty");
	}
	
	public String validation_is_null() {
		return getString("validation_is_null");
	}
	public String validation_incorrect_format() {
		return getString("validation_incorrect_format");
	}
	
	public String validation_lenght_wrong(int minSize, int maxSize) {
		String msg = getString("validation_incorrect_format");
		msg.replace("{minSize}", "" + minSize);
		msg.replace("{maxSize}", "" + maxSize);
		return msg;
	}
	
}
