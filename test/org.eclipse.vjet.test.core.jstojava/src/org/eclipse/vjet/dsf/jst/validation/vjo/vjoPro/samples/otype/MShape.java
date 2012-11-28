/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.vjoPro.samples.otype;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * MShape.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class MShape extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems
                .add(createNewProblem(TypeProbIds.UnusedActiveNeeds, 1, 0));
        expectProblems.add(createNewProblem(MethodProbIds.ShouldReturnValue,
                15, 0));
        expectProblems
                .add(createNewProblem(FieldProbIds.UndefinedField, 16, 0));
        expectProblems.add(createNewProblem(TypeProbIds.TypeMismatch, 9, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("To test VjoPro project false positive")
    public void testMShape() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjoPro.samples.otype.", "MShape.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
