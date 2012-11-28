/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticValidator;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoValidationCtx;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.VjoSemanticRuleRepo;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.rulectx.BaseVjoSemanticRuleCtx;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.symbol.EVjoSymbolType;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.symbol.IVjoSymbol;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.util.JstLoopUtil;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.visitor.IVjoValidationPostAllChildrenListener;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.visitor.IVjoValidationVisitorEvent;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.stmt.ContinueStmt;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;

public class VjoContinueStmtValidator 
	extends VjoSemanticValidator 
	implements IVjoValidationPostAllChildrenListener{
	
	private static List<Class<? extends IJstNode>> s_targetTypes;
	
	static{
		s_targetTypes = new ArrayList<Class<? extends IJstNode>>();
		s_targetTypes.add(ContinueStmt.class);
	}
	
	@Override
	public List<Class<? extends IJstNode>> getTargetNodeTypes() {
		return s_targetTypes;
	}
	
	@Override
	public void onPostAllChildrenEvent(final IVjoValidationVisitorEvent event){
		final VjoValidationCtx ctx = event.getValidationCtx();
		final IJstNode jstNode = event.getVisitNode();
			
		if(!(jstNode instanceof ContinueStmt)){
			return;
		}
		
		final ContinueStmt continueStmt = (ContinueStmt)jstNode;
		
		if(!JstLoopUtil.withinLoopStmt(continueStmt, ctx.getClosestScope())){
			//report problem
			//break/continue must appear within loop statements
		}

		final JstIdentifier continueLabelId = continueStmt.getIdentifier();
		if(continueLabelId != null){
			//break has label in use, validate if label exists
			final IVjoSymbol labelSymbol = ctx.getSymbolTable().getSymbolInScope(ctx.getClosestScope(), continueLabelId.getName(), EVjoSymbolType.LOCAL_VARIABLE);
			if(labelSymbol == null){
				//report problem as break label doesn't exist
				final BaseVjoSemanticRuleCtx ruleCtx = new BaseVjoSemanticRuleCtx(continueLabelId, ctx.getGroupId(), new String[]{continueLabelId.getName()});
				satisfyRule(ctx, VjoSemanticRuleRepo.getInstance().CONTINUE_NONE_EXIST_LABEL, ruleCtx);
			}
		}
	}
	
}
