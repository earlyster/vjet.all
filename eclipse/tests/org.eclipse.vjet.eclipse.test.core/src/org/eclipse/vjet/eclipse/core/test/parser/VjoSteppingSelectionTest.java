/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core.test.parser;

import java.io.File;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.dltk.mod.compiler.env.ISourceModule;

import org.eclipse.vjet.eclipse.core.IJSSourceModule;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.core.search.matching.ICategoryRequestor;
import org.eclipse.vjet.eclipse.core.test.FixtureUtils;
import org.eclipse.vjet.eclipse.core.test.contentassist.TestConstants;
import org.eclipse.vjet.eclipse.internal.codeassist.select.VjoSelectionEngine;
import org.eclipse.vjet.testframework.fixture.FixtureManager;

public class VjoSteppingSelectionTest extends AbstractVjoModelTests {

	private final static String TEST_FLD = "\\projects\\VJETProject\\src\\stepping\\selection";
	
	public void testSteppingSelection() {
		FixtureManager m_fixtureManager = FixtureUtils.setUpFixture(this);

		try {
			String[] files = new File(m_fixtureManager.getSandBox().getSandBoxDir().getAbsoluteFile() + getTestFolder()).list();
			for (String item : files) {
				if(isJSFile(item))
					processTest(item, ICategoryRequestor.TYPE_CATEGORY);
			}
		} catch (Exception e) {
			VjetPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, VjetPlugin.PLUGIN_ID,
							IStatus.ERROR, "Error during test", e));
			throw new AssertionError();
		} finally {
			FixtureUtils.tearDownFixture(m_fixtureManager);
		}
	}

	protected void processTest(String name, String category) throws Exception {
		IJSSourceModule module = (IJSSourceModule) getSourceModule(
				getProjectName(), "src", new Path(name));

		String content = module.getSource();
		for (int i = 0; i < content.length(); i++) {
			basicTest(module, i, category);
		}
	}

	protected void basicTest(IJSSourceModule module, int position,
			String category) {
		assertNotSame("Invalid file content, cant find position", -1, position);

		VjoSelectionEngine engine = new VjoSelectionEngine();
		engine.select((ISourceModule) module, position, position);	
	}

	protected String getTestFolder() {
		return TEST_FLD.replace("\\", File.separator);
	}

	protected String getProjectName() {
		return TestConstants.PROJECT_NAME_VJETPROJECT;
	}

}
