/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.debug.ui.interpreters;

import org.eclipse.dltk.mod.internal.debug.ui.interpreters.InterpretersBlock;
import org.eclipse.dltk.mod.internal.debug.ui.interpreters.ScriptInterpreterPreferencePage;

public class VjetInterpreterPrefPage  extends ScriptInterpreterPreferencePage {

	@Override
	public InterpretersBlock createInterpretersBlock() {
		return new VjetInterpreterBlock();
	}

}
