/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.samples.vjoPro.samples.jsonly;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VjoSyntaxProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * JsOnlyEx2.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class JsOnlyEx2 extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        // expectProblems.add(createNewProblem(VarProbIds.UndefinedName,19, 0));
        // expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod,
        // 19, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.TypeUnknownMissingImport, 13, 0));
        // expectProblems.add(createNewProblem(VjoSyntaxProbIds.TypeUnknownMissingImport,
        // 19, 0));
        // expectProblems.add(createNewProblem(VarProbIds.UndefinedName,27, 0));
        // expectProblems.add(createNewProblem(VarProbIds.UndefinedName,14, 0));
        expectProblems.add(createNewProblem(TypeProbIds.UnusedActiveNeeds, 1,0));
        expectProblems.add(createNewProblem(VarProbIds.UndefinedName, 14,0));
        expectProblems.add(createNewProblem(VarProbIds.UndefinedName, 27,0));
        
        
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.TypeUnknownNotInTypeSpace, 2, 0));
        expectProblems.add(createNewProblem(VarProbIds.UndefinedName, 17, 0));
     
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test VJO Sample project, To validate false positive ")
    public void testJsOnlyEx2() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                VjoValidationBaseTester.VJLIB_FOLDER, "vjoPro.samples.jsonly.",
                "JsOnlyEx2.js", this.getClass(), "JSOnlyEx2", false);
        assertProblemEquals(expectProblems, problems);
    }
}
