/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.validation.vjo.overriden;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Ignore;
import org.junit.Test;




//@Category( { P1, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class VjoOverrideTest extends VjoValidationBaseTester {

    List<VjoSemanticProblem> actualProblems = null;

    @Test
    @Ignore("Syntax error")
    //@Category( { P1, FAST, UNIT })
    public void testAlone() throws Exception {
        expectProblems.clear();
        actualProblems = getVjoSemanticProblem(
                "org.eclipse.vjet.dsf.jst.validation.vjo.overriden.", "Alone.js", this
                        .getClass());
        assertProblemEquals(expectProblems, actualProblems);
    }

    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test override visibility")
    public void testOverride() throws Exception {
        expectProblems.clear();
        expectProblems.add(createNewProblem(
                MethodProbIds.OverrideSuperMethodWithReducedVisibility, 21, 0));
        expectProblems.add(createNewProblem(
                MethodProbIds.OverrideSuperFinalMethod, 16, 0));
        actualProblems = getVjoSemanticProblem(
                "org.eclipse.vjet.dsf.jst.validation.vjo.overriden.", "Child.js", this
                        .getClass());
        assertProblemEquals(expectProblems, actualProblems);
    }
}
