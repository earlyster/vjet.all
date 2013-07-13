/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.validation.vjo.globals.extension;

import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Test;

public class GlobalsExtensionTest extends VjoValidationBaseTester{
	
	List<VjoSemanticProblem> actualProblems = null;
	
	@Test
	public void testGlobalsExtensionTest() throws Exception {
		expectProblems.clear();
		expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 9, 0));
		
		actualProblems 
			= getVjoSemanticProblem("org.eclipse.vjet.dsf.jst.validation.vjo.globals.extension.", "GlobalsExtensionTest.js", this.getClass());
		
		assertProblemEquals(expectProblems, actualProblems);
	}
}
