/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.testframework;

import junit.framework.TestCase;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.vjet.testframework.fixture.FixtureManager;



public class SampleTest extends TestCase {
	
	FixtureManager m_fixtureManager  = new FixtureManager(this);
	
	@Override
	public void setUp() {
		m_fixtureManager.setUpAll();
	}

	@Override
	public void tearDown() {
		m_fixtureManager.tearDown();
	}
	
	public void testSomething() {
		// ...
		// Reference some resource in the workspace 
		// that has been setup by the framework
		ResourcesPlugin.getWorkspace().getRoot().getProject(
			"org.eclipse.vjet.testframework.test");
	}
}
