/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.runtime.tests.metatype;

import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

import org.eclipse.vjet.vjo.runtime.tests.BaseTestClass;
import org.junit.Test;

public class IntTests extends BaseTestClass {
	private static final String NATIVETYPES_TEST_VJO = "org.eclipse.vjet.vjo.runtime.tests.metatype.jstests.IntTests";

	@Test
	//@Category( {P1,IE })
	public void testIntTests_MSIE() throws Exception {
		runJsTest(NATIVETYPES_TEST_VJO, BrowserType.IE_8);
	}

	@Test

	public void testJsTestCase01_FIREFOX() throws Exception {
		runJsTest(NATIVETYPES_TEST_VJO, BrowserType.FIREFOX_3);
	}

//	@Test
//	//@Category( {P2,OPERA })
//	public void jsTestCase01_OPERA() throws Exception {
//		runJsTest(NATIVETYPES_TEST_VJO, BrowserType.OPERA_9);
//	}
//
//	@Test
//	//@Category( {P2,SAFARI })
//	public void jsTestCase01_SAFARI() throws Exception {
//		runJsTest(NATIVETYPES_TEST_VJO, BrowserType.SAFARI_3);
//	}

}
