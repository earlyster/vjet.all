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
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Test;




/**
 * Ecma3ExceptionsTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Ecma3ExceptionsTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 886, 0));
        expectProblems.add(createNewProblem(VarProbIds.LooseVarDecl, 900, 0));
        // prototype extensions which are unknown
        // not going to see these warnings with Object being dynamic
//        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 629, 0));
//        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 755, 0));
//        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 767, 0));
//        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 743, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    public void testEcma3ExceptionsTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "Ecma3ExceptionsTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
