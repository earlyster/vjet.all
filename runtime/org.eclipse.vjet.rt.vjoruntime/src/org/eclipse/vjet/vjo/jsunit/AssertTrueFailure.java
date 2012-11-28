/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.jsunit;

import java.util.List;

import org.mozilla.mod.javascript.StackInspector.StackInfo;

public class AssertTrueFailure extends JsUnitFailure {

	public AssertTrueFailure(List<StackInfo> stacks) {

		super(stacks);

	}
	
	public String toString() {
		return "assertTrue failed: " + getStackTrace();
	}

}
