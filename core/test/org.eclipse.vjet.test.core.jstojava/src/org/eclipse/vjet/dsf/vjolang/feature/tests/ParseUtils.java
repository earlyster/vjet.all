/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.vjolang.feature.tests;

import static org.junit.Assert.assertTrue;
import junit.framework.TestCase;

import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jsgen.shared.util.PrintJstBindingTree;
import org.eclipse.vjet.dsf.jsgen.shared.util.PrintJstTree;
import org.eclipse.vjet.dsf.jsgen.shared.vjo.GeneratorCtx;
import org.eclipse.vjet.dsf.jsgen.shared.vjo.VjoGenerator;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstParseController;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.traversal.JstDepthFirstTraversal;
import org.eclipse.vjet.dsf.jst.ts.util.JstPrettyPrintVisitor;
import org.eclipse.vjet.dsf.jstojava.controller.JstParseController;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.ts.group.IGroup;

public class ParseUtils {

	public static void printTree(IJstNode type) {
	      IndentedPrintStream ps = new IndentedPrintStream(System.out);
	      JstDepthFirstTraversal.accept(type, new JstPrettyPrintVisitor(ps));


	}
	
	public static void printTree2(IJstNode type){
		type.accept(new PrintJstTree());
	}
	
	
	public static void printTreeBindings(IJstNode type){
		type.accept(new PrintJstBindingTree());
	}
	
	public static void validateJstSource(IJstNode node){
		
		JstSourceVisitor jstSourceVisitor = new JstSourceVisitor();
		node.accept(jstSourceVisitor);
		if(jstSourceVisitor.m_failures.size()>0){
			StringBuilder errors = new StringBuilder();
			for(String f : jstSourceVisitor.m_failures){
				errors.append(f).append("\n");
			}
			TestCase.fail("Failures with Jst source missing\n" + errors.toString());
		}
	}
	
	
	
	public static void genTypes(IGroup<IJstType> types) {
		if(types==null){
			return;
		}
		for(IJstType t:types.getEntities().values()){
			genType(t);
		
		}
	}
	
	public static  void genType(IJstType t) {
		VjoGenerator g = new VjoGenerator(new GeneratorCtx(CodeStyle.PRETTY));
		assertTrue(!g.writeType(t).equals(""));
//		System.out.println(g.getGeneratedText());
	}
	
	
	
	public static IJstType createScriptUnit(String name, String file) {
		VjoParser p = new VjoParser();
		IJstParseController c = new JstParseController(p);
		return c.parse(name, name, file);
	}
	
	

}
