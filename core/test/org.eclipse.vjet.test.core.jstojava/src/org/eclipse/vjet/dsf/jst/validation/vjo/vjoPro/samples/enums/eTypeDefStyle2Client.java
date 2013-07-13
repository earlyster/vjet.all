/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.vjoPro.samples.enums;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * eTypeDefStyle2Client.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class eTypeDefStyle2Client extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems.add(createNewProblem(
                TypeProbIds.ClassBetterStartsWithCapitalLetter, 1, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("To test VjoPro project false positive")
    public void testeTypeDefStyle2Client() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                "vjoPro.samples.enums.", "eTypeDefStyle2Client.js", this
                        .getClass());
        assertProblemEquals(expectProblems, problems);
    }
}