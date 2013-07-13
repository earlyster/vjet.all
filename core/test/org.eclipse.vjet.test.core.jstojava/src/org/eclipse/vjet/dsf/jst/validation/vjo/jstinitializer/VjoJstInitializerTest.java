/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.validation.vjo.jstinitializer;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Test;




//@Category( { P1, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class VjoJstInitializerTest extends VjoValidationBaseTester {

    List<VjoSemanticProblem> actualProblems = null;

    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test final field assignment")
    public void testJstInitializer() throws Exception {
        expectProblems.clear();
        expectProblems.add(createNewProblem(FieldProbIds.FinalFieldAssignment,
                5, 0));
        expectProblems.add(createNewProblem(FieldProbIds.FinalFieldAssignment,
                15, 0));

        actualProblems = getVjoSemanticProblem(
                "org.eclipse.vjet.dsf.jst.validation.vjo.jstinitializer.",
                "Jstinitializer.js", this.getClass());
        assertProblemEquals(expectProblems, actualProblems);
    }
}
