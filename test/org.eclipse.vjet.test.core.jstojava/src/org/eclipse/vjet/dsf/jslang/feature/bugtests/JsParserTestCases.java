/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jslang.feature.bugtests;

import static org.junit.Assert.assertFalse;

import org.eclipse.vjet.dsf.jstojava.parser.SyntaxTreeFactory2;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.junit.Test;

import org.eclipse.vjet.dsf.common.FileUtils;

public class JsParserTestCases {

	@Test
	public void regExp() throws Exception{
		String s = FileUtils.getResourceAsString("regExp.txt");
		
		CompilationUnitDeclaration d = SyntaxTreeFactory2.createAST(null, s.toCharArray(),"regExp.txt", null);
		assertFalse(d.hasErrors());
		
		String s2 = FileUtils.getResourceAsString("regExp.txt");
		
		CompilationUnitDeclaration d2 = SyntaxTreeFactory2.createAST(null, s2.toCharArray(),"regExp.js", null);
		assertFalse(d2.hasErrors());
		
		
	}
	
}
