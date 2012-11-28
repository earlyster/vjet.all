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

import org.eclipse.vjet.dsf.jsgen.shared.ids.VjoSyntaxProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * ITypeInstanceMembers1.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class ITypeInstanceMembers1 extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.ITypeAllowsOnlyPublicModifier, 2, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.ITypeAllowsOnlyPublicModifier, 6, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.ITypeWithInstanceProperty, 3, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.ITypeWithInstanceProperty, 6, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.ITypeWithInstanceProperty, 2, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.ITypeWithInstanceProperty, 5, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("To test VjoPro project false positive")
    public void testITypeInstanceMembers1() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjoPro.samples.fundamentals.", "ITypeInstanceMembers1.js",
                this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
