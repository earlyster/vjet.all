/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.validation.vjo.rt.ftype;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VjoSyntaxProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Test;




//@Category({P1,FAST,UNIT})
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class VjoFTypeTest extends VjoValidationBaseTester{
	
	List<VjoSemanticProblem> actualProblems = null;
	
	@Test //@Category({P1,FAST,UNIT})
	//@Description("Test validation error for non existing type usage and redundant needs")
	public void testFType() throws Exception {
		expectProblems.clear();
		actualProblems = getVjoSemanticProblem("org.eclipse.vjet.dsf.jst.validation.vjo.rt.ftype.", "FType.js", this.getClass());
		assertProblemEquals(expectProblems, actualProblems);
	}
	
	@Test //@Category({P1,FAST,UNIT})
	//@Description("Test validation error for non existing type usage and redundant needs")
	public void testFTypeUser() throws Exception {
		expectProblems.clear();
		expectProblems.add(createNewProblem(VjoSyntaxProbIds.TypeUnknownNotInTypeSpace, 25, 0));
		expectProblems.add(createNewProblem(VjoSyntaxProbIds.TypeUnknownMissingImport, 26, 0));
		
		expectProblems.add(createNewProblem(TypeProbIds.ObjectMustBeClass, 29, 0));
		expectProblems.add(createNewProblem(TypeProbIds.ObjectMustBeClass, 30, 0));
		
		expectProblems.add(createNewProblem(MethodProbIds.WrongNumberOfArguments, 47, 0));
		expectProblems.add(createNewProblem(MethodProbIds.WrongNumberOfArguments, 54, 0));
		expectProblems.add(createNewProblem(MethodProbIds.WrongNumberOfArguments, 61, 0));
		
		expectProblems.add(createNewProblem(TypeProbIds.IncompatibleTypesInEqualityOperator, 75, 0));
		expectProblems.add(createNewProblem(TypeProbIds.IncompatibleTypesInEqualityOperator, 76, 0));
		expectProblems.add(createNewProblem(TypeProbIds.IncompatibleTypesInEqualityOperator, 77, 0));
		
		actualProblems = getVjoSemanticProblem("org.eclipse.vjet.dsf.jst.validation.vjo.rt.ftype.", "FTypeUser.js", this.getClass());
		assertProblemEquals(expectProblems, actualProblems);
	}
}
