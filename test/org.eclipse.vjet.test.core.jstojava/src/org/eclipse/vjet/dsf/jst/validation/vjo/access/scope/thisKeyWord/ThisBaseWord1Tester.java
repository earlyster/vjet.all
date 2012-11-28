/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.thisKeyWord;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * This base word 1 Tester
 *
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
//@Category( { P1, FAST, UNIT })
public class ThisBaseWord1Tester extends VjoValidationBaseTester {
    @Before
    public void setUp(){
        expectProblems.clear();
        expectProblems.add(createNewProblem(MethodProbIds.UndefinedMethod, 25, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ParameterMismatch,10, 0));
    }

    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test use this.base. to invoking current scope's type's property")
    public void testAccesVisible1() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "access.scope.thiskeyword.","ThisBaseWordSample1.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
