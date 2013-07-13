/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.dltk.mod.core.tests.launching;

import java.util.List;

import junit.framework.Test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.core.environment.EnvironmentManager;
import org.eclipse.dltk.mod.core.environment.IEnvironment;
import org.eclipse.dltk.mod.core.tests.model.AbstractModelTests;
import org.eclipse.dltk.mod.launching.InterpreterConfig;

public class InterpreterConfigTests extends AbstractModelTests {
	private static final String PROJECT_NAME = "launching";

	private IScriptProject scriptProject;

	public InterpreterConfigTests(String name) {
		super("org.eclipse.dltk.mod.core.tests", name);
	}

	// Configuration
	public void setUpSuite() throws Exception {
		super.setUpSuite();
		scriptProject = setUpScriptProject(PROJECT_NAME);
	}

	public void tearDownSuite() throws Exception {
		deleteProject(PROJECT_NAME);
		super.tearDownSuite();
	}

	public static Test suite() {
		return new Suite(InterpreterConfigTests.class);
	}

	protected InterpreterConfig createInterperterConfig() {
		IProject project = scriptProject.getProject();
		IResource member = project.findMember("src/script.xxx");
		IPath scriptPath = member.getLocation();
		IEnvironment env = EnvironmentManager.getEnvironment(scriptProject);
		return new InterpreterConfig(env, scriptPath);
	}

	public void testInterpreterConfig() {
		IProject project = scriptProject.getProject();
		IResource member = project.findMember("src/script.xxx");
		IPath scriptPath = member.getLocation();
		IEnvironment env = EnvironmentManager.getEnvironment(scriptProject);

		InterpreterConfig config = new InterpreterConfig(env, scriptPath);

		// Creation
		assertNotNull(config.getScriptFilePath());
		assertNotNull(config.getWorkingDirectoryPath());

		assertEquals(scriptPath.toOSString(), config.getScriptFilePath().toOSString());
		assertEquals(scriptPath.removeLastSegments(1).toOSString(), config
				.getWorkingDirectoryPath().toOSString());

		// Null as script file
		try {
			config.setScriptFile(null);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}

//		try {
//			config.setScriptFile((File) null);
//			fail("Should raise an IllegalArgumentException");
//		} catch (IllegalArgumentException e) {
//
//		}

		// Null as working directory
		try {
			config.setWorkingDirectory(null);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {

		}

//		try {
//			config.setWorkingDirectory((File) null);
//			fail("Should raise an IllegalArgumentException");
//		} catch (IllegalArgumentException e) {
//
//		}
	}

	public void testInterpreterConfigEnvArgs() {
		InterpreterConfig config = createInterperterConfig();

		// Environment
		assertEquals(0, config.getEnvVars().size());

		// Not existent variable
		assertFalse(config.hasEnvVar("DIMAN"));
		assertNull(config.getEnvVar("KDS"));

		// Add variable
		config.addEnvVar("KDS", "DIMAN");
		assertTrue(config.hasEnvVar("KDS"));
		assertNotNull(config.getEnvVar("KDS"));
		assertEquals("DIMAN", config.getEnvVar("KDS"));

		// Remove
		config.removeEnvVar("KDS");
		assertFalse(config.hasEnvVar("DIMAN"));
		assertNull(config.getEnvVar("KDS"));

		assertEquals(0, config.getEnvVars().size());

		// Adding null name
		try {
			config.addEnvVar("KDS", null);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}

		// Adding null value
		try {
			config.addEnvVar(null, "DIMAN");
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testInterperterConfigScriptArgs() {
		InterpreterConfig config = createInterperterConfig();

		// Script arguments
		assertEquals(0, config.getScriptArgs().size());
		assertFalse(config.hasScriptArg("-gXXX"));

		// Adding first argument
		config.addScriptArg("-gXXX");
		assertTrue(config.hasScriptArg("-gXXX"));

		// Adding second argument
		config.addScriptArg("-pXXX");
		assertTrue(config.hasScriptArg("-pXXX"));

		final List args = config.getScriptArgs();
		assertEquals(2, args.size());
		assertEquals("-gXXX", args.get(0));
		assertEquals("-pXXX", args.get(1));

		// Adding null argument
		try {
			config.addScriptArg(null);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testInterperterConfigInterpreterArgs() {
		InterpreterConfig config = createInterperterConfig();

		// Script arguments
		assertEquals(0, config.getInterpreterArgs().size());
		assertFalse(config.hasInterpreterArg("arg1"));

		// Adding first argument
		config.addInterpreterArg("arg1");
		assertTrue(config.hasInterpreterArg("arg1"));

		// Adding second argument
		config.addInterpreterArg("arg2");
		assertTrue(config.hasInterpreterArg("arg2"));

		final List args = config.getInterpreterArgs();
		assertEquals(2, args.size());
		assertEquals("arg1", args.get(0));
		assertEquals("arg2", args.get(1));

		// Adding null argument
		try {
			config.addInterpreterArg(null);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}
}
