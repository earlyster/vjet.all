/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.vjLib.dsf.utils.jstrace;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * Wrap.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class Wrap extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 20, 0));
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 21, 0));
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 22, 0));
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 23, 0));
        expectProblems.add(createNewProblem2(VarProbIds.UndefinedName, 22, 0));
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 24, 0));
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 25, 0));
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 26, 0));
//        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 27, 0));
        expectProblems.add(createNewProblem2(VarProbIds.UndefinedName, 33, 0));
        expectProblems.add(createNewProblem2(VarProbIds.UndefinedName, 38, 0));
        expectProblems
        .add(createNewProblem2(FieldProbIds.UndefinedField, 64, 0));
//        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 67,
//                0));
//        expectProblems.add(createNewProblem2(MethodProbIds.UndefinedMethod, 76,
//                0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test Vjo vj lib project, To validate false positive ")
    public void testWrap() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                VjoValidationBaseTester.VJLIB_FOLDER,
                "vjoPro.dsf.utils.jstrace.", "Wrap.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
