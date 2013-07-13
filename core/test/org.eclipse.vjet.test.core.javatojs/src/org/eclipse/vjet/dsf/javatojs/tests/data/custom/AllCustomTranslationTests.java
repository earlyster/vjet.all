/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests.data.custom;



import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import org.eclipse.vjet.dsf.javatojs.control.DefaultTranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.control.ITranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateCtx;
import org.eclipse.vjet.dsf.javatojs.util.JstToJavaHelper;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.test.utils.TestHelper;


//@ModuleInfo(value="DsfPrebuild",subModuleId="JavaToJs")
public class AllCustomTranslationTests {

	private static ITranslationInitializer s_initializer;
	public static ITranslationInitializer getInitializer() {

		if (s_initializer == null) {
			s_initializer = new DefaultTranslationInitializer(){
				public void initialize(){
					super.initialize();
					TranslateCtx.ctx()
						.enableParallel(true)
						.enableTrace(true);
				}
			};
			
		}
		return s_initializer;
	}
	
	private static TranslateCtx getCtx(){
		return TranslateCtx.ctx();
	}
	
//	@Test
//	//@Category( { P1, FUNCTIONAL,NOJARRUN })
//	//@Description("Test Handler type")
//	public void testHandlers() {
//		TestHelper.testType(Handlers.class, getInitializer());
//		getCtx().getTraceManager().close();
//	}

//	@Test
//	//@Category( { P1, FUNCTIONAL,NOJARRUN })
//	//@Description("Test variable type lookup")
//	public void testVarTypeLookup() {
//		TestHelper.testType(VarTypeLookup.class, getInitializer());
//		getCtx().getTraceManager().close();
//	}
//	@Test
//	//@Category( { P1, FUNCTIONAL,NOJARRUN })
//	//@Description("Test AHtml Types")
//	public void testAHtmlTypes() {
//		TestHelper.testType(AHtmlTypes.class, getInitializer());
//		getCtx().getTraceManager().close();
//	}
	
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test forcing to fully qualified types")
	public void testForceFullyQualified() {
		TestHelper.testType(ForceFullyQualified.class, getInitializer());
		getCtx().getTraceManager().close();
	}
	
//	@Test
//	//@Category( { P1, FUNCTIONAL })
//	//@Description("Test Customized Types")
//	public void testCustomizedAs() {
//		TestHelper.testType(CustomizedAs.class, getInitializer());
//		getCtx().getTraceManager().close();
//	}
	
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test overloaded methods")
	public void testOverloadedMethods() {
		TestHelper.testType(OverloadedMethods.class, getInitializer());
	}
	
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test overloaded constructors")
	public void testOverloadedConstructors() {
		TestHelper.testType(OverloadedConstructors.class, getInitializer());
	}
	
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test var arg methods")
	public void testVarArgMethods() {
		TestHelper.testType(VarArgMethods.class, getInitializer());
	}
	
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test Rename")
	public void testRename() {
		TestHelper.testType(Rename.class, getInitializer());
	}
	
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test Java only")
	public void testJavaOnly() {
		TestHelper.testType(JavaOnlyTests.class, getInitializer());
	}
	
//	@Test
//	//@Category( { P1, FUNCTIONAL,NOJARRUN })
//	//@Description("Test JS proxy")
//	public void testJsProxy(){
//		TestHelper.testType(JsProxyTests.class, getInitializer());
//	}
	
//	@Test
//	//@Category( { P1, FUNCTIONAL,NOJARRUN })
//	//@Description("Test Curry type")
//	public void testCurry(){
//		TestHelper.testType(CurryTests.class, getInitializer());
//	}
	
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test Java lang types")
	@Ignore
	public void testJavaLangTypes() {
		JstCache.getInstance().clear();
		TestHelper.testType(JavaLangTypes.class, getInitializer());

		JstType type = JstCache.getInstance().getType("String");
		String javaName = JstToJavaHelper.getJavaTypeName(type);
		assertEquals("String", javaName);

		// assertEquals(5, controller.getErrors().size());
		getCtx().getTraceManager().close();
	}
}
