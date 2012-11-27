/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.core.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.dltk.mod.core.tests.buildpath.BuildpathTests;
import org.eclipse.dltk.mod.core.tests.compiler.CompilerCharOperationTests;
import org.eclipse.dltk.mod.core.tests.compiler.CompilerUtilTests;
import org.eclipse.dltk.mod.core.tests.ddp.CoreDDPTests;
import org.eclipse.dltk.mod.core.tests.launching.EnvironmentResolverTests;
import org.eclipse.dltk.mod.core.tests.launching.InterpreterConfigTests;
import org.eclipse.dltk.mod.core.tests.mixin.MixinIndexTests;
import org.eclipse.dltk.mod.core.tests.mixin.MixinModelTests;
import org.eclipse.dltk.mod.core.tests.model.BufferTests;
import org.eclipse.dltk.mod.core.tests.model.ModelMembersTests;
import org.eclipse.dltk.mod.core.tests.model.WorkingCopyTests;
import org.eclipse.dltk.mod.core.tests.util.CharacterStackTests;
import org.eclipse.dltk.mod.core.tests.utils.InternalCoreUtilTest;
import org.eclipse.dltk.mod.core.tests.utils.TextUtilsTest;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.dltk.mod.core.tests.model");
		// $JUnit-BEGIN$
		suite.addTest(new TestSuite(CompilerUtilTests.class));
		suite.addTest(new TestSuite(CompilerCharOperationTests.class));
		suite.addTest(new TestSuite(InternalCoreUtilTest.class));
		suite.addTest(new TestSuite(MixinIndexTests.class));
		suite.addTest(new TestSuite(MixinModelTests.class));
		suite.addTest(BuildpathTests.suite());

		suite.addTest(CoreDDPTests.suite());

		suite.addTest(BufferTests.suite());
		suite.addTest(ModelMembersTests.suite());
		suite.addTest(WorkingCopyTests.suite());

		suite.addTest(InterpreterConfigTests.suite());

		suite.addTest(EnvironmentResolverTests.suite());

		suite.addTest(TextUtilsTest.suite());
		suite.addTestSuite(CharacterStackTests.class);
		// $JUnit-END$
		return suite;
	}
}
