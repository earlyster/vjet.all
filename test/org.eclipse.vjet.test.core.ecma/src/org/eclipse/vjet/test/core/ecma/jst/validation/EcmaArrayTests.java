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
import org.junit.Ignore;
import org.junit.Test;




/**
 * EcmaArrayTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class EcmaArrayTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 401, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 708, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 709, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 710, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 711, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 712, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 808, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 818, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    @Ignore("Bug8436" + "Bug 8437")
    public void testEcmaArrayTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "EcmaArrayTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
