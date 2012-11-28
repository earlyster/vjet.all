/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests;


import static org.junit.Assert.assertEquals;

import org.eclipse.vjet.dsf.javatojs.control.DefaultTranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.control.ITranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.ArraySrc;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.CoinComplexEnum;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.CoinEnum;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.CoinSimpleEnum;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.ObjectAndClass;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.PrimitiveSrc;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.TestArray;
import org.eclipse.vjet.dsf.javatojs.tests.data.datatype.TestCollections;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.test.utils.TestHelper;
import org.junit.Test;



//@ModuleInfo(value="DsfPrebuild",subModuleId="JavaToJs")
public class VjoDataTypeTests  {

	private static ITranslationInitializer s_initializer;
	public static ITranslationInitializer getInitializer() {

		if (s_initializer == null) {
			s_initializer = new DefaultTranslationInitializer(){
				public void initialize(){
					super.initialize();
//					ctx.getConfig().getPackageMapping().add("com", "vjo");
				}
			};
			
		}
		return s_initializer;
	}

	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of Object and Class types")
	public void testObjectAndClass() {
		Class srcType = ObjectAndClass.class;
		TestHelper.testType(srcType, getInitializer());
	}

//	@Test
//	//@Category( { P4, FUNCTIONAL })
//	//@Description("Test translation of Object methods")
//	public void testObjectMethods() {
//		Class srcType = ObjectMethods.class;
//		TestHelper.testType(srcType, getInitializer());
//	}

	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of array usage")
	public void testArray() {
		Class srcType = TestArray.class;
		TestHelper helper = new TestHelper(srcType, getInitializer());
		String actual = helper.toVjo(helper.translate(), CodeStyle.PRETTY);
		assertEquals(helper.getExpectedVjo(), actual);
	}

	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of Collections")
	public void testCollections() {
		Class srcType = TestCollections.class;
		TestHelper helper = new TestHelper(srcType, getInitializer());
		String actual = helper.toVjo(helper.translate(), CodeStyle.PRETTY);
		assertEquals(helper.getExpectedVjo(), actual);
	}

	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of Enum")
	public void testEnum() {
		Class srcType = CoinEnum.class;
		TestHelper helper = new TestHelper(srcType, getInitializer());
		String actual = helper.toVjo(helper.translate(), CodeStyle.PRETTY);
		assertEquals(helper.getExpectedVjo(), actual);
	}
	
	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of Simple Enum")
	public void testEnumSimple() {
		Class srcType = CoinSimpleEnum.class;
		TestHelper helper = new TestHelper(srcType, getInitializer());
		String actual = helper.toVjo(helper.translate(), CodeStyle.PRETTY);
		assertEquals(helper.getExpectedVjo(), actual);
	}

	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of Complex Enum")
	public void testEnumComplex() {
		Class srcType = CoinComplexEnum.class;
		TestHelper helper = new TestHelper(srcType, getInitializer());
		String actual = helper.toVjo(helper.translate(), CodeStyle.PRETTY);
		assertEquals(helper.getExpectedVjo(), actual);
	}

	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of primitives")
	public void testPrimitive() {
		Class srcType = PrimitiveSrc.class;
		TestHelper helper = new TestHelper(srcType, getInitializer());
		String actual = helper.toVjo(helper.translate(), CodeStyle.PRETTY);
		assertEquals(helper.getExpectedVjo(), actual);
	}
	
	@Test
	//@Category( { P4, FUNCTIONAL })
	//@Description("Test translation of arrays of primitives")
	public void testPrimitiveArray() {
		Class srcType = ArraySrc.class;
		TestHelper helper = new TestHelper(srcType, getInitializer());
		String actual = helper.toVjo(helper.translate(), CodeStyle.PRETTY);
		assertEquals(helper.getExpectedVjo(), actual);
	}
	
}
