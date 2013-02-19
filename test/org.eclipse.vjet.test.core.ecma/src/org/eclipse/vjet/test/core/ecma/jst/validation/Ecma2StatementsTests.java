/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.test.core.ecma.jst.validation;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;




/**
 * Ecma2StatementsTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma2StatementsTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        // bugfix by roy, redeclared local with same type, tolerated

        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 578, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 579, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 582, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 583, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 584, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 585, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcma2StatementsTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma2StatementsTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
