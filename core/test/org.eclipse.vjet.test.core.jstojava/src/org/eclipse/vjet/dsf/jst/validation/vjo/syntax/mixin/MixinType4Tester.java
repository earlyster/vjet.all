/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.syntax.mixin;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.MethodProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * Class/Interface description
 *
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
//@Category( { P3, FAST, UNIT })
public class MixinType4Tester extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(FieldProbIds.AmbiguousField, 6, 0));
        expectProblems.add(createNewProblem(FieldProbIds.AmbiguousField, 20, 0));
        expectProblems.add(createNewProblem(MethodProbIds.AmbiguousMethod, 13, 0));
        expectProblems.add(createNewProblem(MethodProbIds.AmbiguousMethod, 27, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test mixin function for ctype with confilict field and method situation")
    public void testIfstatement1() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "syntax.mixintype/", "PersonConflit.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
    
    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test mixin function for ctype with confilict field and method situation")
    public void testMixinConflicts() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "syntax.mixintype/", "EmployeeConflictsPerson.js", this.getClass());
        expectProblems.clear();
        expectProblems.add(createNewProblem(FieldProbIds.AmbiguousField, 5, 0));
        expectProblems.add(createNewProblem(FieldProbIds.AmbiguousField, 13, 0));
        expectProblems.add(createNewProblem(MethodProbIds.AmbiguousMethod, 8, 0));
        expectProblems.add(createNewProblem(MethodProbIds.AmbiguousMethod, 16, 0));
        //bugfix by roy, mtype reference error changed to undefined field
        expectProblems.add(createNewProblem(FieldProbIds.UndefinedField, 22, 0));
        
        assertProblemEquals(expectProblems, problems);
    }
}
