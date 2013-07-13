/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblemFactory;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticRule;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.rulectx.ClassBetterStartWithCapitalLetterRuleCtx;

public class ClassBetterStartWithCapitalLetterRule extends VjoSemanticRule<ClassBetterStartWithCapitalLetterRuleCtx> {

	public VjoSemanticProblem doFire(ClassBetterStartWithCapitalLetterRuleCtx ctx) {
		final String simpleClassName = ctx.getClassSimpleName();
		if(simpleClassName.length() > 0){
			final char beginChar = simpleClassName.charAt(0);
			if(beginChar >= 'a'
					&& beginChar <= 'z'){
				return VjoSemanticProblemFactory.getInstance().createProblem(ctx.getArguments(), ctx.getGroupId(), getProblemId(), getErrMsg(), ctx.getNode(), this);
			}
		}
		//no error
		return null;
	}
}
