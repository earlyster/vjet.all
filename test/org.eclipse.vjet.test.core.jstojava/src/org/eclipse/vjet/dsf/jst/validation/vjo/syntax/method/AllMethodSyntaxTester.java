/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method;

import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.inits.CorrectInitTest1;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.inits.Init1;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.inits.Init2;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.inits.Init3;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.inits.Init4;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.abstractMethod.SyntaxAbstract1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.abstractMethod.SyntaxAbstractCorrect1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.abstractMethod.SyntaxAbstractCorrect2Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.exception.SyntaxMethodThrowsException1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterface1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterface2Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterface3Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterface4Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterface5Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterfaceCorrect1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterfaceCorrect2Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.impl.SyntaxInterfaceCorrect3Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.syntax.method.overload.AllMethodOverloadTesters;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    SyntaxInterfaceCorrect1Tester.class,
    SyntaxInterfaceCorrect2Tester.class,
    SyntaxInterfaceCorrect3Tester.class,
    SyntaxInterface1Tester.class,
    SyntaxInterface2Tester.class,
    SyntaxInterface3Tester.class,
    SyntaxInterface4Tester.class,
    SyntaxInterface5Tester.class,
    
    //Abstract tester
    SyntaxAbstract1Tester.class,
    SyntaxAbstractCorrect1Tester.class,
    SyntaxAbstractCorrect2Tester.class,
    
    //inits
    CorrectInitTest1.class,
    Init1.class,
    Init2.class,
    Init3.class,
    Init4.class,
    
    SyntaxMethodThrowsException1Tester.class,
    
    //Method overload testers
    AllMethodOverloadTesters.class
    
})

/**
 * All method syntax tester
 *
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
public class AllMethodSyntaxTester {

}
