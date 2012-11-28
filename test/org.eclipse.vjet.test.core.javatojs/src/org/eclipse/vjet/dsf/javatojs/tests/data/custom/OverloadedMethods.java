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
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.AMappedToJS;
import org.eclipse.vjet.dsf.javatojs.anno.AMappedToVJO;

public class OverloadedMethods {
	@AMappedToJS(name = "xyx")
	public void foo() {

	}
	
	@AExclude
	public void foo(Boolean v) {

	}
	
	@AJavaOnly
	public void foo(String arg) {

	}

	@AMappedToVJO(name = "a.b.c.Y")
	public void foo(Integer arg) {

	}

	public static void main(String[] args) {
		OverloadedMethods test = new OverloadedMethods();
		test.foo();
		test.foo(Boolean.TRUE);
		test.foo("booyah");
		test.foo(10);
	}
}
