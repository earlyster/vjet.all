/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules;

import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblemFactory;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticRule;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.VjoMethodControlFlowTable;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.rulectx.MethodAndReturnFlowRuleCtx;
import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.stmt.RtnStmt;
import org.eclipse.vjet.dsf.jst.stmt.ThrowStmt;
import org.eclipse.vjet.dsf.jst.token.IStmt;

public class VoidMethodShouldNotHaveReturnRule extends VjoSemanticRule<MethodAndReturnFlowRuleCtx>{
	
	public VjoSemanticProblem doFire(MethodAndReturnFlowRuleCtx ctx) {
		final IJstMethod method = ctx.getMethod();
		final VjoMethodControlFlowTable flowTable = ctx.getReturnFlowTable();
		
		if(method != null && flowTable != null){
			if(method.getRtnType() != null
					&& "void".equals(method.getRtnType().getSimpleName())){
				List<IStmt> stmts = flowTable.lookUpStmt((JstMethod)method);
				boolean returnFound = false;
				for(IStmt stmt : stmts){
					if(stmt == null){
					}
					else if(stmt instanceof ThrowStmt && ((ThrowStmt)stmt).getExpression() != null){
						returnFound = true;
						break;
					}else if(stmt instanceof RtnStmt && ((RtnStmt)stmt).getExpression() != null){
                        returnFound = true;
                        break;
                    }
				}
				
				if(returnFound){
					final VjoSemanticProblem problem = VjoSemanticProblemFactory.getInstance().createProblem(ctx.getArguments(), ctx.getGroupId(),getProblemId(), getErrMsg(), ctx.getNode(), this);
					return problem;
				}
			}
		}
		
		return null;
	}
}
