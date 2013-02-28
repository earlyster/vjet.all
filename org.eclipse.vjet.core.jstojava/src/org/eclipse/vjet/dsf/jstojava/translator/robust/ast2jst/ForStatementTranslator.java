/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator.robust.ast2jst;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.ScopeIds;
import org.eclipse.vjet.dsf.jst.declaration.JstAttributedType;
import org.eclipse.vjet.dsf.jst.declaration.JstBlock;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.declaration.JstFactory;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.jst.declaration.JstVars;
import org.eclipse.vjet.dsf.jst.expr.AssignExpr;
import org.eclipse.vjet.dsf.jst.expr.ConditionalExpr;
import org.eclipse.vjet.dsf.jst.expr.JstInitializer;
import org.eclipse.vjet.dsf.jst.expr.ListExpr;
import org.eclipse.vjet.dsf.jst.stmt.ForStmt;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.dsf.jst.token.IStmt;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateHelper;
import org.eclipse.mod.wst.jsdt.core.ast.IASTNode;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.ForStatement;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.Statement;

public class ForStatementTranslator extends
		BaseAst2JstTranslator<ForStatement, ForStmt> {

	@Override
	protected ForStmt doTranslate(ForStatement statement) {
		assert statement != null;
		ForStmt forStmt = new ForStmt();
		if (m_parent != null) {
			m_parent.addChild(forStmt);
		}
		try {
			m_ctx.enterBlock(ScopeIds.LOOP);
			doTranslate(statement, forStmt);
		} finally {
			m_ctx.exitBlock();
		}
		return forStmt;
	}

	private void doTranslate(ForStatement statement, ForStmt forStmt) {
		if (statement.initializations != null
				&& statement.initializations.length > 0) {
			Statement[] inits = statement.initializations;
			List<AssignExpr> list = new ArrayList<AssignExpr>();
			List<JstVars> multipleVars = new ArrayList<JstVars>();
			boolean isLocalDeclaration = false;
			JstVars jstVars = null;
			
			
			
			
			for (Statement initializer : inits) {
				if (initializer.getASTType() == IASTNode.LOCAL_DECLARATION) {
					isLocalDeclaration = true;
				}
				final Object translated = getTranslatorAndTranslate(initializer, forStmt);
				if(translated instanceof JstVars[] ){
					
					
					JstVars[] multiVars = (JstVars[])translated;
						for (JstVars jstVars2 : multiVars) {
							multipleVars.add(jstVars2);
						}
					
				}
				else if (translated instanceof JstVars) {
					multipleVars.add((JstVars)translated);
				} else if (translated instanceof AssignExpr) {
					AssignExpr assignExpr = (AssignExpr) translated;
					// JstInitializer init = new JstInitializer(assignExpr
					// .getLHS(), assignExpr.getExpr());
					list.add(assignExpr);
				} else if(translated instanceof ListExpr){
					JstType obj =JstCache.getInstance().getType("Undefined");
					jstVars = new JstVars(obj);
					
					ListExpr listExpr = (ListExpr)translated;
					IExpr[] listOfAsignments = listExpr.getExprTerms();
					for (IExpr iExpr : listOfAsignments) {
						if(iExpr instanceof AssignExpr){
							jstVars.addAssignment((AssignExpr)iExpr);
						}
					}
					
				}else {
				
					System.err.println("Unprocessed type: "
							+ initializer.getClass()
							+ " in ForStatementTranslator");
				}

			}
			if (isLocalDeclaration) { // initializer is a local declaration: for (var i = 0;;;)
				
				JstVars primaryVar = multipleVars.get(0);
				
				if(multipleVars.size()>1){
					for (int i =1 ; i<multipleVars.size();i++) {
						primaryVar.addChild(multipleVars.get(i));
						
					}
				}
				forStmt.setInitializer(primaryVar);
				
				//forStmt.setInitializer(jstVars);
			} else { // initializer is assignment: for (i = 0;;;)
				JstInitializer jstInitializer = null;
				for (AssignExpr assignExpr : list) {
					if (jstInitializer == null){
						jstInitializer = new JstInitializer();
						forStmt.setInitializer(jstInitializer);
					}
					jstInitializer.addAssignment(assignExpr);
				}
				forStmt.setInitializer(jstInitializer);
			}
		}
		if (statement.condition != null) {
			IExpr cond = (IExpr) getTranslatorAndTranslate(statement.condition,
					forStmt);
			forStmt.setCondition(TranslateHelper.buildCondition(cond));
		}
		if (statement.increments != null) {
			for (Statement increment : statement.increments) {
				forStmt.addUpdater((IExpr) getTranslatorAndTranslate(increment,
						forStmt));
			}
		}
		if (!statement.isEmptyBlock()) {
			Object obj = getTranslatorAndTranslate(statement.action, forStmt.getBody());
			if(!(obj instanceof JstBlock)){
				if(obj instanceof IStmt){
					forStmt.getBody().addStmt((IStmt)obj);
				}else if(obj instanceof ConditionalExpr){
					// TODO test this case
					forStmt.getBody().addChild((ConditionalExpr)obj);
					
				}
				
				// TODO determine what other conditions need to be looked at
				// org.eclipse.vjet.dsf.jst.expr.ConditionalExpr was returned in one case
				
			}
		}
		forStmt.setSource(TranslateHelper.getSource(statement, m_ctx.getSourceUtil()));
	}

//	private JstVars processVars(List<JstVars> list, JstVars jstVars,
//			final Object translated) {
//	
//		List<AssignExpr> initializers =jstVars.getAssignments();
//		for (AssignExpr jstInitializer : initializers) {
//			list.add(jstInitializer);
//		}
//		
//		return jstVars;
//	}
}
