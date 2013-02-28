/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.vjLib.example;

import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;

/**
 * VjComp.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
// @Category( { P3, FAST, UNIT })
// @ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class VjComp extends VjoValidationBaseTester {

	@Before
	public void setUp() {
		expectProblems.clear();
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 77, 0));
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 76, 0));
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 79, 0));
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 39, 0));
		expectProblems
				.add(createNewProblem2(FieldProbIds.UndefinedField, 78, 0));
		expectProblems.add(createNewProblem2(TypeProbIds.UnusedActiveNeeds, 11,
				0));
		expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 193,
				0));
		expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 193,
				0));
		expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 193,
				0));
		expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 208,
				0));
	}

	@Test
	// @Category( { P3, FAST, UNIT })
	// @Description("Test Vjo vj lib project, To validate false positive ")
	public void testVjComp() {
		List<VjoSemanticProblem> problems = getVjoSemanticProblem(
				VjoValidationBaseTester.VJLIB_FOLDER, "vjoPro.example.",
				"VjComp.js", this.getClass());
		assertProblemEquals(expectProblems, problems);
	}
}
