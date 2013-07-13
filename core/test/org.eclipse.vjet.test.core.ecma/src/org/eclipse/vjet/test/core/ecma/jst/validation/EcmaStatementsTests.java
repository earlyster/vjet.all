/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.test.core.ecma.jst.validation;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.VjoSyntaxProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;




/**
 * EcmaStatementsTests.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class EcmaStatementsTests extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 838, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 940, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 940, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 950, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 950, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 961, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 961, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 971, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 971, 0));
        expectProblems.add(createNewProblem(
                VjoSyntaxProbIds.IncorrectVjoSyntax, 981, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test DSF project, To validate false positive ")
    @Ignore
    // syntax error
    public void testEcmaStatementsTests() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjet.dsf.jslang.feature.tests.", "EcmaStatementsTests.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
