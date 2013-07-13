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

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * protected tester
 *
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
//@Category( { P1, FAST, UNIT })
public class ThisWord2Tester extends VjoValidationBaseTester {

    @Before
    public void setUp(){
        expectProblems.clear();
        expectProblems.add(createNewProblem(FieldProbIds.NonStaticFieldFromStaticInvocation, 27, 0));
        expectProblems.add(createNewProblem(FieldProbIds.NonStaticAccessToStaticField, 12, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnusedPrivateMethod,11, 0));
        expectProblems.add(createNewProblem(MethodProbIds.UnusedPrivateMethod, 16, 0));
    }

    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test use this.vj$. to invoking instance property from static block")
    public void testAccesVisible1() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "access.scope.thiskeyword.",
                "PropsThis2.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
