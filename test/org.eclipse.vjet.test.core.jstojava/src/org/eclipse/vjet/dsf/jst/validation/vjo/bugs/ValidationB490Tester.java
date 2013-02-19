/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.bugs;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * Bug 490
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
//@Category( { P3, FAST, UNIT })
public class ValidationB490Tester extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem2(MethodProbIds.AmbiguousMethod, 21,
                0));
        expectProblems.add(createNewProblem2(MethodProbIds.AmbiguousMethod, 24,
                0));
        expectProblems.add(createNewProblem2(MethodProbIds.AmbiguousMethod, 27,
                0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test duplicate methods for overload")
    public void testBugfix() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem("bugs.b490/",
                "B490.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
