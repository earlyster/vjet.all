/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.tool.codecompletion.overloadtests;




import java.util.Arrays;
import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.vjo.tool.codecompletion.VjoCcBaseTest;
import org.eclipse.vjet.vjo.tool.codecompletion.jsresource.CodeCompletionUtil;
import org.junit.Before;
import org.junit.Test;



//@Category({P1,FAST,UNIT})
//@ModuleInfo(value="DsfPrebuild",subModuleId="VJET")
public class VjoCcVjoATypeOverloadTests extends VjoCcBaseTest{
	
	private VjoCcOverloadUtil overloadUtil;
	
	@Before
	public void setUp() throws Exception {
		overloadUtil = new VjoCcOverloadUtil();
	}
	
	@Test
	public void testBaseOverloadProposal(){
		// JS Type name
		String js = "engine.overload.ABase";
		
		// Function to test for overloading
		String funcName = "nonAbstFunc1";
		
		IJstType jstType = getJstType(CodeCompletionUtil.GROUP_NAME, js);
		
		// Position where proposal to be displayed
		int position = lastPositionInFile("this.", jstType);
		
		// list of expected argument list. include null in case of no argument expected
		String[] expectArgs = {null,"int i","int i, String s",
				"int i, String s, Date d"};
		
		VjoCcOverloadUtil.Proposals prop = overloadUtil.new Proposals(jstType,position,funcName);
		
		List<String> actualList = overloadUtil.getActMethParamList(prop);
		List<String> expectedList = Arrays.asList(expectArgs);
		
		overloadUtil.checkProposals(expectedList,actualList);
	}
	
}
