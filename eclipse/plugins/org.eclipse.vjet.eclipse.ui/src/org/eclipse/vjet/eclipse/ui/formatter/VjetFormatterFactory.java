/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.ui.formatter;

import java.util.Map;

import org.eclipse.dltk.mod.ui.formatter.AbstractScriptFormatterFactory;
import org.eclipse.dltk.mod.ui.formatter.IFormatterModifyDialog;
import org.eclipse.dltk.mod.ui.formatter.IFormatterModifyDialogOwner;
import org.eclipse.dltk.mod.ui.formatter.IScriptFormatter;
import org.eclipse.dltk.mod.ui.preferences.PreferenceKey;


public class VjetFormatterFactory extends AbstractScriptFormatterFactory {

	public IScriptFormatter createFormatter(String lineDelimiter,
			Map preferences) {
		return new VjetFormatter(preferences);
	}
	
	/**
	 * @since 2.0
	 */
	public Map<String, String> changeToIndentingOnly(
			Map<String, String> preferences) {
		return preferences;
	}

	public PreferenceKey[] getPreferenceKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPreferenceQualifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFormatterModifyDialog createDialog(
			IFormatterModifyDialogOwner dialogOwner) {
		return null;
	}
}
