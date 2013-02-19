/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.samples.dox.ebay.vjoPro.vjoPro4javadev.samples.vjlib;




import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jst.validation.vjo.VjoValidationBaseTester;
import org.junit.Before;
import org.junit.Test;




/**
 * ImageAnimateImage.java
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
//@Category( { P3, FAST, UNIT })
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class ImageAnimateImage extends VjoValidationBaseTester {

    @Before
    public void setUp() {
        expectProblems.clear();
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 36, 0));
        expectProblems.add(createNewProblem2(FieldProbIds.UndefinedField, 20, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 25, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 33, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 22, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 36, 0));
        expectProblems
                .add(createNewProblem2(FieldProbIds.UndefinedField, 24, 0));
    }

    @Test
    //@Category( { P3, FAST, UNIT })
    //@Description("Test VJO Sample project, To validate false positive ")
    // The bug 6110 still exist. now we update the test js
    // file via alias. if use alias it's work.
    public void testImageAnimateImage() {
        List<VjoSemanticProblem> problems = getVjoSemanticProblem(
                VjoValidationBaseTester.VJLIB_FOLDER,
                "dox.ebay.vjoPro.vjoPro4javadev.samples.vjlib.",
                "ImageAnimateImage.js", this.getClass());
        assertProblemEquals(expectProblems, problems);
    }
}
