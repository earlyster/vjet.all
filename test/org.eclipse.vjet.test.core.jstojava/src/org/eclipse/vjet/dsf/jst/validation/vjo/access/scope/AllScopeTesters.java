/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.jst.validation.vjo.access.scope;

import org.eclipse.vjet.dsf.jst.validation.vjo.access.needs.AccessNeeds1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.needs.AccessNeeds2Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.needs.AccessNeeds3Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.needs.AccessNeedsCorrect1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.returncheck.AccessReturn1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.returncheck.AccessReturn2Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.returncheck.AccessReturnCorrect1Tester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.childPackage.ChildPackageAccessDefaultTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.childPackage.ChildPackageAccessPrivateTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.childPackage.ChildPackageAccessProtectedTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.childPackage.ChildPackageAccessPublicTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.fatherPackage.FatherPackageAccessDefaultTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.fatherPackage.FatherPackageAccessPrivateTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.fatherPackage.FatherPackageAccessProtectedTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.fatherPackage.FatherPackageAccessPublicTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.sameLevel.SamePackageAccessDefaultTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.sameLevel.SamePackageAccessPrivateTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.sameLevel.SamePackageAccessProtectedTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.sameLevel.SamePackageAccessPublicTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.samePackage.SameLevelPackageAccessDefaultTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.samePackage.SameLevelPackageAccessPrivateTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.samePackage.SameLevelPackageAccessProtectedTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.samePackage.SameLevelPackageAccessPublicTester;
import org.eclipse.vjet.dsf.jst.validation.vjo.access.scope.thisKeyWord.AllThisKeyTesters;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Class/Interface description
 *
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */

@RunWith(Suite.class)
@SuiteClasses({
    ChildPackageAccessDefaultTester.class,
    ChildPackageAccessPrivateTester.class,
    ChildPackageAccessProtectedTester.class,
    ChildPackageAccessPublicTester.class,
    
    FatherPackageAccessDefaultTester.class,
    FatherPackageAccessPrivateTester.class,
    FatherPackageAccessProtectedTester.class,
    FatherPackageAccessPublicTester.class,
    
    SamePackageAccessDefaultTester.class,
    SamePackageAccessPrivateTester.class,
    SamePackageAccessProtectedTester.class,
    SamePackageAccessPublicTester.class,
    
    SameLevelPackageAccessDefaultTester.class,
    SameLevelPackageAccessPrivateTester.class,
    SameLevelPackageAccessProtectedTester.class,
    SameLevelPackageAccessPublicTester.class,
    
    AccessNeeds1Tester.class,
    AccessNeeds2Tester.class,
    AccessNeeds3Tester.class,
    AccessNeedsCorrect1Tester.class,
    
    AccessReturnCorrect1Tester.class,
    AccessReturn1Tester.class,
    AccessReturn2Tester.class,
    
    AllThisKeyTesters.class
    
})
public class AllScopeTesters {

}
