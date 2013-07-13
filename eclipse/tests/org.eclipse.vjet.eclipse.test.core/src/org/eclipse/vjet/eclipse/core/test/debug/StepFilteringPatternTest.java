/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core.test.debug;

import org.eclipse.vjet.eclipse.internal.debug.ui.VjetDebugOptionsManager;

import junit.framework.TestCase;

public class StepFilteringPatternTest extends TestCase {

	public void testPattern(){
		String pattern = "dbgp:///*";
		String[] regExp = VjetDebugOptionsManager.convert2RegExp(new String[]{pattern});
		assertTrue("dbgp:///temp_4.js".matches(regExp[0]));
		assertFalse("jar:dbgp:///temp_4.js".matches(regExp[0]));
		assertFalse("jar:dbgp://localhost/temp_4.js".matches(regExp[0]));
		
		pattern = "*org.eclipse.vjet.vjo/VjBootstrap*";
		regExp = VjetDebugOptionsManager.convert2RegExp(new String[]{pattern});
		assertTrue("file:/c:/org.eclipse.vjet.vjo/VjBootstrap_3.js".matches(regExp[0]));
		assertTrue("org.eclipse.vjet.vjo/VjBootstrap_3.js".matches(regExp[0]));
		
		pattern = "*org.eclipse.vjet.vjo/VjBootstrap";
		regExp = VjetDebugOptionsManager.convert2RegExp(new String[]{pattern});
		assertTrue("file:/c:/org.eclipse.vjet.vjo/VjBootstrap".matches(regExp[0]));
		assertFalse("org.eclipse.vjet.vjo/VjBootstrap_3.js".matches(regExp[0]));
	}
	
	public void testPatternConvertRegExp(){
		String pattern = "dbgp:///*";
		String[] regExp = VjetDebugOptionsManager.convert2RegExp(new String[]{pattern});
		assertEquals("dbgp:///.*", regExp[0]);
		
		pattern = "*org.eclipse.vjet.vjo/VjBootstrap*";
		regExp = VjetDebugOptionsManager.convert2RegExp(new String[]{pattern});
		assertEquals(".*org\\.eclipse\\.vjet\\.vjo/VjBootstrap.*", regExp[0]);
		
		pattern = "*org\\eclipse\\vjet\\vjo\\VjBootstrap*";
		regExp = VjetDebugOptionsManager.convert2RegExp(new String[]{pattern});
		assertEquals(".*org/eclipse/vjet/vjo/VjBootstrap.*", regExp[0]);

		pattern = "*org\\eclipse\\vjet\\vjo\\VjBootstrap.js*";
		regExp = VjetDebugOptionsManager.convert2RegExp(new String[]{pattern});
		assertEquals(".*org/eclipse/vjet/vjo/VjBootstrap\\.js.*", regExp[0]);
	}
}
