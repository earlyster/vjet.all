/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.launching;

import org.eclipse.dltk.mod.core.DLTKIdContributionSelector;
import org.eclipse.dltk.mod.core.PreferencesLookupDelegate;

public class VjetDebuggingEngineSelector extends DLTKIdContributionSelector{

	@Override
	protected String getSavedContributionId(PreferencesLookupDelegate delegate) {
		return delegate.getString("org.eclipse.vjet.eclipse.debug", "debugging_engine_id");
	}

}
