/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests;



import java.util.HashMap;
import java.util.List;

import org.eclipse.vjet.dsf.common.trace.TraceAttr;
import org.eclipse.vjet.dsf.common.trace.event.TraceId;
import org.eclipse.vjet.dsf.javatojs.control.DefaultTranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.control.ITranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.control.TranslationController;
import org.eclipse.vjet.dsf.javatojs.tests.data.multipass.Dependent;
import org.eclipse.vjet.dsf.javatojs.trace.ITranslateTracer;
import org.eclipse.vjet.dsf.javatojs.trace.TranslateError;
import org.eclipse.vjet.dsf.javatojs.trace.TranslationTraceId;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateCtx;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateInfo;
import org.eclipse.vjet.dsf.javatojs.util.JavaToJsHelper;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jsgen.shared.vjo.GeneratorCtx;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.junit.Test;



import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.test.utils.TestHelper;

//@ModuleInfo(value="DsfPrebuild",subModuleId="JavaToJs")
public class MultiPassTests {

	public static final TraceId ID = TranslationTraceId.TEST;

	private static ITranslationInitializer s_initializer;
	public static ITranslationInitializer getInitializer() {

		if (s_initializer == null) {
			s_initializer = new DefaultTranslationInitializer(){
				public void initialize(){
					super.initialize();
					TranslateCtx ctx = TranslateCtx.ctx()
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
	
	private ITranslateTracer s_tracer;
	private ITranslateTracer getTracer() {
		if (s_tracer == null) {
			s_tracer = getCtx().getTraceManager().getTracer();
		}
		return s_tracer;

	}
//	@Test
//	//@Category( { P1, FUNCTIONAL })
//	//@Description("Test targeted translation")
//	@Ignore
//	public void testTargetedTranslation() {
//
//		reset();
//		getTracer()
//				.startGroup(ID, new TraceAttr("name", "TargetedTranslation"));
//
//		Class srcType = Dependent.class;
//
//		TranslationController controller = TestHelper.getTranslationController(getInitializer());
//
//		JstType jstType = controller.targetedTranslation(srcType);
//
//		String actual = JavaToJsHelper.toVjo(jstType,
//			new GeneratorCtx(CodeStyle.PRETTY));
//
//		TestHelper helper = new TestHelper(srcType, getInitializer());
//		// helper.writeVjo(actual);
//
//		JstCache.getInstance().clear();
//
//		getTracer().endGroup(ID);
//
//		printErrors(controller.getErrors());
//
//		assertEquals(helper.getExpectedVjo(), actual);
//		// assertEquals(4, jstType.getImplicitDependency().size());
//	}
	@Test
	//@Category( { P1, FUNCTIONAL })
	//@Description("Test on demand translation")
	public void testOnDemandTranslation() {

		reset();

		getTracer()
				.startGroup(ID, new TraceAttr("name", "OnDemandTranslation"));

		Class srcType = Dependent.class;

		TranslationController controller = TestHelper.getTranslationController(getInitializer());

		List<JstType> jstTypes = controller.onDemandTranslation(srcType);
		String actual;
		for (JstType jstType : jstTypes) {
			actual = JavaToJsHelper.toVjo(jstType,
				new GeneratorCtx(CodeStyle.PRETTY));
			if (!jstType.getSimpleName().equals("Dependent")) {
				// assertEquals(TestHelper.getExpectedVjo(jstType.getName()),
				// actual);
			}
		}

		getTracer().endGroup(ID);

		// MUST BE THE IN THE LAST TEST
		getCtx().getTraceManager().close();

		printErrors(controller.getErrors());
	}

	//
	// Private
	//
	private void reset() {
		// LibManager.getInstance().clear();
		JstCache.getInstance().clear();
		getCtx().setTranslateInfo(new HashMap<JstType, TranslateInfo>());
	}

	private void printErrors(List<TranslateError> errors) {
		for (TranslateError e : errors) {
			if (e.getLevel() == LogLevel.ERROR) {
				System.err.println(e.toString());
			}
		}
	}
}
