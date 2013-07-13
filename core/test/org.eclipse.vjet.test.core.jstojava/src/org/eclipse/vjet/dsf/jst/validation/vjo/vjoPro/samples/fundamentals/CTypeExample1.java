/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.vjoPro.samples.fundamentals;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.VarProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.VjoSyntaxProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * CTypeExample1.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class CTypeExample1 extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem2(VjoSyntaxProbIds.RedundantImport,
                12, 0));
        expectProblems.add(createNewProblem2(VarProbIds.LooseVarDecl, 26, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("To test VjoPro project false positive")
    public void testCTypeExample1() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjoPro.samples.fundamentals.", "CTypeExample1.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
