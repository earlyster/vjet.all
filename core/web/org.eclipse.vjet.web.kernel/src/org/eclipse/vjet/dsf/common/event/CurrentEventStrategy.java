/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.event;

import org.eclipse.vjet.dsf.dom.DNode;

class CurrentEventStrategy implements IDsfEventStrategy {
	@SuppressWarnings("unchecked")
	public void handle(final DNode current, final DsfEvent event)
		throws AbortDsfEventProcessingException
	{
// MrP - perf - loop over directly if possible, avoid iterator
		for (IDsfEventListener listener : current.getDsfEventListeners()) {
			if (event.isAppropriateListener(listener)) {
				event.dispatch(listener);
			}
		}			
	}
}
