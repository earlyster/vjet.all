/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.validation.vjo.overloaded;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Test;




//@Category( { P1, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class VjoOverloadedTest extends VjoValidationBaseTester {

    List<VjoSemanticProblem> actualProblems = null;

    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test methods overload ")
    public void testOverloaded() throws Exception {
        expectProblems.clear();
        actualProblems = getVjoSemanticProblem(
                "org.eclipse.vjet.dsf.jst.validation.vjo.overloaded.", "Overloaded.js",
                this.getClass());
        assertProblemEquals(expectProblems, actualProblems);
    }
    
    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test methods overload in interface ")
    public void testOverloadedInterface() throws Exception {
        expectProblems.clear();
        actualProblems = getVjoSemanticProblem(
                "org.eclipse.vjet.dsf.jst.validation.vjo.overloaded.", "IOverloaded.js",
                this.getClass());
        assertProblemEquals(expectProblems, actualProblems);
    }

    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test methods overload ")
    public void testVariable() throws Exception {
        expectProblems.clear();
        actualProblems = getVjoSemanticProblem(
                "org.eclipse.vjet.dsf.jst.validation.vjo.overloaded.", "Variable.js",
                this.getClass());
        assertProblemEquals(expectProblems, actualProblems);
    }

}
