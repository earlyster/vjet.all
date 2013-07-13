/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests.data.structure.nested;

public class UseNested {
	
	public static void staticMtd() {
		A.X x = new A.X();
		B.Y y = new B().new Y();
	}
	
	public void instanceMtd() {
		A.X x = new A.X();
		B.Y y = new B().new Y();
	}
}
