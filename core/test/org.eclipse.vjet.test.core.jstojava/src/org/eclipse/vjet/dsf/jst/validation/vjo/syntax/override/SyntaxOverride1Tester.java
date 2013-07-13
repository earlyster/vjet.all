/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.syntax.override;





import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * Override for bigger visibility
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
//@Category( { P1, FAST, UNIT })
public class SyntaxOverride1Tester extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        // ML should change to visibility is small
        expectProblems.add(createNewProblem(MethodProbIds.UnusedPrivateMethod,
                12, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnusedPrivateMethod,
                18, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.OverrideSuperMethodWithReducedVisibility, 12, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.OverrideSuperMethodWithReducedVisibility, 18, 0));

    }

    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test overriden with reduced visbility method")
    public void testOverrideType1() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "syntax.methodOverride/", "Employee1.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
