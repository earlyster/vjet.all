/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator.robust;

import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstProperty;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.ISynthesized;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.jst.declaration.SynthJstProxyMethod;
import org.eclipse.vjet.dsf.jst.declaration.SynthJstProxyProp;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateCtx;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstExpectsOnTypeCompletion;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstTypeCompletion;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.MessageSend;

public class ExpectsRobustTranslator extends CompletionsFilteredRobustTranslator{


	public ExpectsRobustTranslator(TranslateCtx ctx) {
		super(ctx);
	}


	protected final JstTypeCompletion createOnTypeCompletion() {
		return new JstExpectsOnTypeCompletion(jst);
	}

	public boolean transform() {

		// remove expects("") element from the stack
		current = astElements.pop();
		
		// move to the next iteration
		return super.transform();
	}
	
	@Override
	protected void processCompletion() {
		weakTranslator.getProvider().getTypeTranslator()
		.processExpects((MessageSend) current, jst);
		
		addSynthesizedMethods(jst, jst.getExpects());
		
	}


	private void addSynthesizedMethods(JstType jst, List<IJstType> expects) {
		// TODO Auto-generated method stub
		for(IJstType expected: expects){
			
			
			addExpectedMethods(jst, expected.getMethods());
			addExpectedProperties(jst, expected.getProperties());
			
		}
	}


	private void addExpectedProperties(JstType jst,
			List<IJstProperty> properties) {
		for(IJstProperty prop: properties){
			if(prop instanceof ISynthesized){
				continue;
			}
			
			jst.addProperty(new SynthJstProxyProp(prop));
		}
	}


	private void addExpectedMethods(JstType jst,
			List<? extends IJstMethod> methods) {
		for(IJstMethod mtd: methods){
			if(mtd instanceof ISynthesized){
				continue;
			}
			jst.addMethod(new SynthJstProxyMethod(mtd));
		}
		
	}

}
