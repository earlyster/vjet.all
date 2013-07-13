/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.typecheck.array;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;




/**
 * For test the in array types in Equality Operator.
 * 
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
//@Category( { P3, FAST, UNIT })
//@Description("Test assign value to array children's type mismatch")
public class ArrayType3Tester extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        // FIXME find correct problem id
        expectProblems.clear();
        expectProblems.add(createNewProblem(TypeProbIds.TypeMismatch, 18, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ShouldReturnValue,
                17, 0));
    }

    @Test
    @Ignore
    //@Category( { P3, FAST, UNIT })
    //@Description("Test assign value to array children's type mismatch")
    public void testCompartibleType2() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "ArrayType3Tester.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
