/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.tool.codecompletion;

import java.net.URL;

import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.CommentCompletionTest;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.InitCompletionTest;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.SquareBracketCompletionTest;
import org.eclipse.vjet.vjo.tool.astjst.TestTemplateCreationUtilTests;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCCVjoUtilityAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcAliasProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcCTypeProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcConstructorGenProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcEnumElementAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcFunctionGenProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcInterfaceProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcKeywordInMethodProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcNeedsItemProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcOverrideProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcOwnerTypeProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcPackageProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcParameterProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcPropMethodProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcStaticPropMethodProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcThisProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcTypeNameAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcTypeProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.advisor.VjoCcVariableProposalAdvisorTest;
import org.eclipse.vjet.vjo.tool.codecompletion.bugfixtests.VjoCcFunctionBugsTests;
import org.eclipse.vjet.vjo.tool.codecompletion.bugfixtests.VjoCcInnerTypesBugsTests;
import org.eclipse.vjet.vjo.tool.codecompletion.bugfixtests.VjoCcJsNativeApiBugsTests;
import org.eclipse.vjet.vjo.tool.codecompletion.bugfixtests.VjoCcKeywordBugsTests;
import org.eclipse.vjet.vjo.tool.codecompletion.bugfixtests.VjoCcVjoMemberAccessBugsTests;
import org.eclipse.vjet.vjo.tool.codecompletion.bugfixtests.VjoCcVjoTemplateBugsTests;
import org.eclipse.vjet.vjo.tool.codecompletion.bugfixtests.VjoCcVjoTypeBugsTests;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcBugFixExtnTests;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcBugfixTests;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcIndentationTest;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcIntegrationTests;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcJavaOneSampleTest;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcJsNativeTypeGlobalTests;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcJsNativeTypeTests;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcMemberAccessTests;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.innertypes.VjoCcInnerTypeTests;
import org.eclipse.vjet.vjo.tool.codecompletion.handler.VjoCcHandlerTest;
import org.eclipse.vjet.vjo.tool.codecompletion.jsresource.CodeCompletionUtil;
import org.eclipse.vjet.vjo.tool.codecompletion.overloadtests.VjoCcVjoATypeOverloadTests;
import org.eclipse.vjet.vjo.tool.codecompletion.overloadtests.VjoCcVjoCTypeOverloadTests;
import org.eclipse.vjet.vjo.tool.codecompletion.overloadtests.VjoCcVjoETypeOverloadTests;
import org.eclipse.vjet.vjo.tool.codecompletion.overloadtests.VjoCcVjoMTypeOverloadTests;
import org.eclipse.vjet.vjo.tool.codecompletion.overridetests.VjoCcVjoATypeOverrideTests;
import org.eclipse.vjet.vjo.tool.codecompletion.overridetests.VjoCcVjoCTypeOverrideTests;
import org.eclipse.vjet.vjo.tool.codecompletion.presenter.VjoCcFunctionStringTests;
import org.eclipse.vjet.vjo.tool.codecompletion.presenter.VjoCcKeywordStringTests;
import org.eclipse.vjet.vjo.tool.codecompletion.presenter.VjoCcMethodPropReplaceStrTests;
import org.eclipse.vjet.vjo.tool.codecompletion.presenter.VjoCcPresenterTests;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	VjoCcAliasProposalAdvisorTest.class,
	VjoCcConstructorGenProposalAdvisorTest.class,
	VjoCcCTypeProposalAdvisorTest.class,
	VjoCcEnumElementAdvisorTest.class,
	VjoCcFunctionGenProposalAdvisorTest.class,
	VjoCcInterfaceProposalAdvisorTest.class,
	VjoCcKeywordInMethodProposalAdvisorTest.class,
	VjoCcNeedsItemProposalAdvisorTest.class,
	VjoCcOverrideProposalAdvisorTest.class,
	VjoCcOwnerTypeProposalAdvisorTest.class,
	VjoCcPackageProposalAdvisorTest.class,
	VjoCcParameterProposalAdvisorTest.class,
	VjoCcPropMethodProposalAdvisorTest.class,
	VjoCcStaticPropMethodProposalAdvisorTest.class,
	VjoCcThisProposalAdvisorTest.class,
	VjoCcTypeNameAdvisorTest.class,
	VjoCcTypeProposalAdvisorTest.class,
	VjoCcVariableProposalAdvisorTest.class,
	VjoCCVjoUtilityAdvisorTest.class,
//	VjoCcVjProposalAdvisorTest.class,
	
	VjoCcHandlerTest.class,
	VjoCcIntegrationTests.class,
	VjoCcCtxTest.class,
	InitCompletionTest.class,
	SquareBracketCompletionTest.class,
	VjoCcBugfixTests.class,
	VjoCcBugFixExtnTests.class,
	VjoCcJsNativeTypeGlobalTests.class,
	VjoCcJsNativeTypeTests.class,
	VjoCcJavaOneSampleTest.class,
	VjoCcKeywordStringTests.class,
	VjoCcFunctionStringTests.class,
	VjoCcMethodPropReplaceStrTests.class,
	VjoCcVjoMemberAccessBugsTests.class,
	VjoCcVjoTypeBugsTests.class,
	VjoCcMemberAccessTests.class,
	VjoCcPresenterTests.class,
	VjoCcFunctionBugsTests.class,
	VjoCcInnerTypesBugsTests.class,
	VjoCcJsNativeApiBugsTests.class,
	VjoCcKeywordBugsTests.class,
	VjoCcVjoTemplateBugsTests.class,
	VjoCcIndentationTest.class,
	VjoCcInnerTypeTests.class,
	
	//Overloading and Overriding Test cases
	VjoCcVjoATypeOverloadTests.class,
	VjoCcVjoCTypeOverloadTests.class,
	VjoCcVjoETypeOverloadTests.class,
	VjoCcVjoMTypeOverloadTests.class,
	VjoCcVjoATypeOverrideTests.class,
	VjoCcVjoCTypeOverrideTests.class,
	TestTemplateCreationUtilTests.class,
	
	// Comment completion tests
	CommentCompletionTest.class
	
})
public class AllVjoCcTestSuite {
	
	
static{
		CodeCompletionUtil.setFolder("artifact");
	}

	
	@BeforeClass
	public static void appendSourcePath(){
		
		
		URL url = AllVjoCcTestSuite.class.getClassLoader().getResource(
				AllVjoCcTestSuite.class.getName().replace('.', '/')+".class");
		if(url.getFile().contains(".jar")){
			String path = url.getFile();
			if (path.startsWith("file:/")){
				path = path.substring("file:/".length());
			}
			String jarPath = path.substring(0, path.indexOf(".jar")+".jar".length());
			System.out.println("jarPath = " + jarPath);
			System.setProperty("java.source.path", System.getProperty("java.source.path")+";"+jarPath);
		}
	}
}
