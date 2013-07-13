/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.debug.ui.interpreters;

import org.eclipse.dltk.mod.internal.debug.ui.interpreters.AbstractInterpreterComboBlock;

import org.eclipse.vjet.eclipse.core.VjoNature;

public class VjetInterpreterComboBlock extends AbstractInterpreterComboBlock{

	@Override
	protected String getCurrentLanguageNature() {
		return VjoNature.NATURE_ID;
	}

	@Override
	protected void showInterpreterPreferencePage() {
		// TODO Auto-generated method stub
		
	}

}
