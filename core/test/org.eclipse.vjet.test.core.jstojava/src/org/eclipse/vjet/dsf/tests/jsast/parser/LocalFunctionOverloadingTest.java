/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.tests.jsast.parser;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstModifiers;
import org.eclipse.vjet.dsf.jst.declaration.JstSynthesizedMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstVars;
import org.eclipse.vjet.dsf.jst.expr.AssignExpr;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.token.IStmt;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.report.ErrorReporter;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateCtx;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



import org.eclipse.vjet.dsf.common.resource.ResourceUtil;

/**
 * Tests if explicit static in .props is ok
 * 
 * 
 *
 */
//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class LocalFunctionOverloadingTest implements ICommentConstants {
	
	private static final String fileName = FOLDER + "/LocalFunctionOverloading.vjo";
	
	private static IJstType jstType = null;
	private static TranslateCtx ctx = null;
	
	@BeforeClass
	public static void setUpJst() throws Exception {
		VjoParser p = new VjoParser();
		ctx = new TranslateCtx();
	
		// get file
		File resource= new File(ResourceUtil.getResource(LocalFunctionOverloadingTest.class,
				                fileName).getFile());
		URL url = ResourceUtil.getResource(BadCommentTest.class,fileName);
		String fileAsString = JsPreGenHelper.url2String(url);
		jstType = p.parse(fileName, resource.getAbsolutePath(), fileAsString, ctx);
		assertNotNull(jstType);
	}
		
	@Test
	//@Category({P2,UNIT,FAST})
	//@Description("Verifies local function overloading supported")
	public void verifyLocalFunctionOverloading() {
		IJstMethod bar = jstType.getStaticMethod("bar");
		JstModifiers jm = bar.getModifiers();
		assertTrue(jm.isStatic());
		
		boolean assignmentFound = true;
		for(IStmt stmt: bar.getBlock().getStmts()){
			if(stmt instanceof JstVars){
				final IJstType varType = ((JstVars)stmt).getType();
				assertNotNull(varType);
				assertEquals("Function", varType.getName());
				for(AssignExpr assignment: ((JstVars)stmt).getAssignments()){
					assertNotNull(assignment);
					assertNotNull(assignment.getLHS());
					if(assignment.getLHS() instanceof JstIdentifier){
						assignmentFound = true;
						final JstIdentifier identifier = (JstIdentifier)assignment.getLHS();
						assertNotNull(identifier);
						assertNotNull(identifier.getJstBinding());
						assertTrue(identifier.getJstBinding() instanceof JstMethod);
						// switched over to syntheized method when doing var refactor
//						if(!"f2".equals(identifier.getName())){
//							assertFalse(identifier.getJstBinding() instanceof JstSynthesizedMethod);
//						}
						
						final JstMethod method = (JstMethod)identifier.getJstBinding();
						assertTrue(method.isDispatcher());
						assertNotNull(method.getOverloaded());
					}
				}
			}
		}
		assertTrue(assignmentFound);
		
		ErrorReporter er = ctx.getErrorReporter();
		assertFalse(er.hasErrors());
	}
	
	
	@AfterClass
	public static void tearDownJst() throws Exception {
		ctx = null;
		jstType = null;
	}
}
