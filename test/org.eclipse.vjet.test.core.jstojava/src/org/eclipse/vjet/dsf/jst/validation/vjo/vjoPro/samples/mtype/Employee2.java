/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.vjoPro.samples.mtype;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * Employee2.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Employee2 extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("To test VjoPro project false positive")
    public void testEmployee2() {
//        expectProblems.add(createNewProblem(TypeProbIds.MixinExpectsMustBeSatisfied, 1, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.ShouldReturnValue,37,0));
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjoPro.samples.mtype.", "Employee2.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("To test VjoPro project false positive")
    public void testEmployee8() {
        expectProblems.clear();
        expectProblems.add(createNewProblem2(FieldProbIds.AmbiguousField, 14, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.AmbiguousMethod, 17, 0));
        expectProblems.add(createNewProblem2(MethodProbIds.AmbiguousMethod, 24, 0));
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjoPro.samples.mtype.", "Employee8.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("To test VjoPro project false positive")
    public void testEmployee9() {
        expectProblems.clear();
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjoPro.samples.mtype.", "Employee9.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
