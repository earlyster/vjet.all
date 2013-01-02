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

import java.io.IOException;
import java.net.URL;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstTypeReference;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.jstojava.translator.JstUtil;
import org.eclipse.vjet.vjo.lib.IResourceResolver;
import org.eclipse.vjet.vjo.lib.LibManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import org.eclipse.vjet.dsf.common.resource.ResourceUtil;

//@ModuleInfo(value="DsfPrebuild",subModuleId="JsToJava")
public class VjoSelectionTests {
	private IJstType type;

	@Before
	public void setUp() throws IOException {
		IResourceResolver jstLibResolver = org.eclipse.vjet.dsf.jstojava.test.utils.JstLibResolver
				.getInstance()
				.setSdkEnvironment(
						new org.eclipse.vjet.dsf.jstojava.test.utils.VJetSdkEnvironment(
								new String[0], "DefaultSdk"));

		LibManager.getInstance().setResourceResolver(jstLibResolver);
		
		URL file = ResourceUtil.getResource(getClass(),"simplevjocommented.js.txt");
		type = new VjoParser().addLib(LibManager.getInstance().getJsNativeGlobalLib())
			.parse(null, file).getType();
		
		
	}

	@Test
	//@Category({P4,UNIT,FAST})
	//@Description("Verifies imports declared using deprecated getNode method")
	public void testImports() {
		Object node = JstUtil.getAllNodes(type, 17, 17).get(0);
		assertEquals("Wrong node type selected", JstTypeReference.class,
				node.getClass());
		IJstType importedType = ((JstTypeReference) node).getReferencedType();
		assertEquals("Wrong imported type seleced", "a.b.c.Z", importedType
				.getName());
		
	}
	
	@Test
	//@Category({P2,UNIT,FAST})
	//@Description("Verifies imports declared")
	public void testImports2() {
		Object node = JstUtil.getAllNodes(type, 17, 17).get(0);
		assertEquals("Wrong node type selected", JstTypeReference.class,
				node.getClass());
		IJstType importedType = ((JstTypeReference) node).getReferencedType();
		assertEquals("Wrong imported type seleced", "a.b.c.Z", importedType
				.getName());
	}

	@Test
	//@Category({P4,UNIT,FAST})
	//@Description("Verifies inherits declared using deprecated getNode method")
	public void testExtends() {
		Object node = JstUtil.getAllNodes(type, 156, 156).get(0);
		assertEquals("Wrong node type selected", JstTypeReference.class,
				node.getClass());
		IJstType importedType = ((JstTypeReference) node).getReferencedType();
		assertEquals("Wrong extended type seleced",
				"org.eclipse.vjet.dsf.tests.jsast.A", importedType.getName());
	}
	
	@Test
	//@Category({P2,UNIT,FAST})
	//@Description("Verifies inherits declared")
	public void testExtends2() {
		Object node = JstUtil.getLeafNode(type, 156, 156);
		assertEquals("Wrong node type selected", JstTypeReference.class,
				node.getClass());
		IJstType importedType = ((JstTypeReference) node).getReferencedType();
		assertEquals("Wrong extended type seleced",
				"org.eclipse.vjet.dsf.tests.jsast.A", importedType.getName());
	}

	@After
	public void tearDown() {
		System.out.println("VjoSelectionTests.tearDown()");
	}
}
