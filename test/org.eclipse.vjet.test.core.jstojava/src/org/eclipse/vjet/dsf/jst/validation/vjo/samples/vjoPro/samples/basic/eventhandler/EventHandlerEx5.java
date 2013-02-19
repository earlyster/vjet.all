/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.samples.vjoPro.samples.basic.eventhandler;

import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;

/**
 * EventHandlerEx5.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
// @Category( { P3, FAST, UNIT })
// @ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class EventHandlerEx5 extends VjoValidationBaseTester {

	@Before
	public void setUp() {
		expectProblems.clear();
		expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 36,
				10));
		expectProblems.add(createNewProblem2(MethodProbIds.ShouldReturnValue,
				35, 0));
		
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 36, 0));
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 36, 0));
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 24, 0));
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 25, 0));
	}

	@Test
	// @Category( { P3, FAST, UNIT })
	// @Description("Test VJO Sample project, To validate false positive ")
	public void testEventHandlerEx5() {
		List<VjoSemanticProblem> problems = getVjoSemanticProblem(
				VjoValidationBaseTester.VJLIB_FOLDER,
				"vjoPro.samples.basic.eventhandler.", "EventHandlerEx5.js",
				this.getClass());
		assertProblemEquals(expectProblems, problems);
	}
}
