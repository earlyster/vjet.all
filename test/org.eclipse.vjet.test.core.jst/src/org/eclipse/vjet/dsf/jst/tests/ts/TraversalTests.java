/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.tests.ts;



import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.traversal.JstDepthFirstTraversal;
import org.eclipse.vjet.dsf.jst.ts.util.MethodDependencyVisitor;
import org.eclipse.vjet.dsf.ts.method.MethodName;



//@ModuleInfo(value="DsfPrebuild",subModuleId="JavaToJs")
public class TraversalTests extends BaseTest {
		
	//@Category( { P1, UNIT })
	//@Description("Test traversals in a single group")
	public void testSingleGroup() {
		
		JstCache.getInstance().clear();
		
		List<IJstType> jstTypes = getJstTypes(getClassList1());

		MethodDependencyVisitor visitor = new MethodDependencyVisitor();
		
		JstDepthFirstTraversal.accept(jstTypes, visitor);
		
		Map<MethodName,List<IJstNode>> map = visitor.getMethodDependencies();
		
		assertEquals(6, map.size());
	}
	
//	public void testTree(){
//		IndentedPrintStream ps = new IndentedPrintStream(System.out);
//
//		List<IJstType> jstTypes = getJstTypes(getClassList1());
//
//		JstDepthFirstTraversal.accept(jstTypes.get(2), new JstPrettyPrintVisitor(ps));
//	}
}
