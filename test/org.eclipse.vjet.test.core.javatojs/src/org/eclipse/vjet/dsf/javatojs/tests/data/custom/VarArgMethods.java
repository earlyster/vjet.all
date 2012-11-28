/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests.data.custom;

import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.javatojs.anno.AMappedToJS;
import org.eclipse.vjet.dsf.javatojs.anno.AMappedToVJO;
import org.eclipse.vjet.dsf.javatojs.anno.AProperty;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;


public class VarArgMethods {
	@AExclude
	public void foo() {

	}
	
	@AMappedToJS(name = "a")
	public void foo(Boolean v) {

	}
	
	@AMappedToVJO(name = "x.y.z.b")
	public static void foo(Boolean... values) {

	}
	
	@ARename(name = "c")
	public static void foo(Integer... values) {

	}

	@AProperty(name = "d")
	public void foo(Integer arg) {

	}

	public static void main(String[] args) {
		VarArgMethods test = new VarArgMethods();
		test.foo();
		test.foo(Boolean.TRUE);
		test.foo(Boolean.TRUE, Boolean.FALSE);
		test.foo(10, 20, 30);
		test.foo(10);
	}
}
