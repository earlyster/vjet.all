/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.trace.handler;

import org.eclipse.vjet.dsf.common.Id;

public class HandlerId extends Id {
	
	private static final long serialVersionUID = 1L;

	public HandlerId(final String name) {
		super(getNextEnumSequence(), name, false) ;
	}
	
	public HandlerId(final int enumId, final String name) {
		super(enumId, name, true) ;
	}
}
