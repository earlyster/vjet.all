/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;

import org.eclipse.vjet.dsf.javatojs.control.DefaultTranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.control.ICodeGenPathResolver;
import org.eclipse.vjet.dsf.javatojs.control.ITranslationInitializer;
import org.eclipse.vjet.dsf.javatojs.control.TranslationController;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateCtx;
import org.eclipse.vjet.dsf.javatojs.util.VjoFiler;
import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jsgen.shared.generate.JsrGenerator;
import org.eclipse.vjet.dsf.jsgen.shared.vjo.GeneratorCtx;
import org.eclipse.vjet.dsf.jsgen.shared.vjo.VjoGenerator;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.test.utils.TestHelper;

public class MainTranslator {
	
	private ICodeGenPathResolver m_codeGenPathResolver = ICodeGenPathResolver.DEFAULT;

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

	public void translate(Class clz) throws Exception {

		// VJO
		TranslationController controller = TestHelper.getTranslationController(getInitializer());
		List <JstType> jstTypes = controller.onDemandTranslation(clz);
//		try{
//			TestHelper.writeVjo(jstTypes);
//		}catch (ClassNotFoundException e) {
//			System.err.println("CLASS TO TRANSLATE WAS NOT FOUND");
//			e.printStackTrace();
//		}
		
		log(controller.getErrors().size());
		
		// JSR
		GeneratorCtx gCtx;
		VjoGenerator vjoGenerator;
		JsrGenerator jsrGenerator;
		URL filePath;
		for (JstType jstType: jstTypes){
			gCtx = new GeneratorCtx(CodeStyle.PRETTY); // TODO need to fix writer, shouldn't create ctx each time.

			vjoGenerator = gCtx.getProvider().getTypeGenerator();
			vjoGenerator.writeVjo(jstType);
			filePath = m_codeGenPathResolver.getVjoFilePath(jstType);
			VjoFiler.writeToFile(filePath, vjoGenerator.getGeneratedText());

			StringWriter buffer = new StringWriter();
			jsrGenerator = new JsrGenerator(new PrintWriter(buffer), gCtx.getStyle());
//			jsrGenerator.addListener(m_jsrListener);
			jsrGenerator.writeJsr(jstType, true);
			filePath = m_codeGenPathResolver.getJsrFilePath(jstType);;
			VjoFiler.writeToFile(filePath, buffer.toString());
		}	
		
		getCtx().getTraceManager().close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		MainTranslator tranl = new MainTranslator();
//		
//		try {
//			tranl.translate(Test.class);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
	}

	private void log(Object o) {
		System.out.println(o.toString());
	}
	
	public void ctxAddMapping(String original, String change){
		getCtx().getConfig().getPackageMapping().add(original, change);
	}
}
