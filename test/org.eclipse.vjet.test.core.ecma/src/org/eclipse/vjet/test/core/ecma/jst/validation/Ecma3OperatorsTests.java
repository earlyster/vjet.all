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

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;




/**
 * Ecma3OperatorsTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma3OperatorsTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 96, 0));
        expectProblems.add(createNewProblem(VarProbIds.UndefinedName, 96, 0));
        expectProblems
                .add(createNewProblem(FieldProbIds.UndefinedField, 226, 0));
        expectProblems
                .add(createNewProblem(FieldProbIds.UndefinedField, 231, 0));
        expectProblems
                .add(createNewProblem(FieldProbIds.UndefinedField, 236, 0));
//        expectProblems
//        		.add(createNewProblem(FieldProbIds.UndefinedField, 296, 0));
//        expectProblems
//        		.add(createNewProblem(FieldProbIds.UndefinedField, 297, 0));
        // bugfix by roy, redeclared local with same type, tolerated
        // expectProblems.add(createNewProblem(VarProbIds.RedefinedLocal, 205,
        // 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 339, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcma3OperatorsTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma3OperatorsTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
