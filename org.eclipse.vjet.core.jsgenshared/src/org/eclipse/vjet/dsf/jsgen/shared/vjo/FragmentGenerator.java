/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.vjo;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.vjet.dsf.jst.declaration.JstVars;
import org.eclipse.vjet.dsf.jst.expr.AssignExpr;
import org.eclipse.vjet.dsf.jst.expr.JstInitializer;
import org.eclipse.vjet.dsf.jst.token.IInitializer;

public class FragmentGenerator extends BaseGenerator {
	
	
	//
	// Constructor
	//
	public FragmentGenerator(final GeneratorCtx ctx){
		super(ctx);
	}
	
	//
	// API
	//
	public void writeInitializer(final IInitializer initializer){
		
		if (initializer == null){
			return;
		}
		
		if (initializer instanceof JstInitializer){
			write((JstInitializer)initializer);
		}
		else if (initializer instanceof JstVars){
			write((JstVars)initializer);
		}
	}
	
	//
	// Private
	//
	private void write(final JstInitializer initializer){

		PrintWriter writer = getWriter();
		ExprGenerator exprGenerator = getExprGenerator();
		
		List<AssignExpr> initializers = initializer.getAssignments();
		AssignExpr assignExpr;
		if (initializers != null){
			for (int i=0; i<initializers.size(); i++){
				if (i>0){
					writer.append(",");
				}
				assignExpr = initializers.get(i);
				if (assignExpr.getLHS().toLHSText() != null){
					writer.append(assignExpr.getLHS().toLHSText());
				}
				if (assignExpr.getExpr() != null){
					writer.append(assignExpr.getOprator().toString());
					exprGenerator.writeExpr(assignExpr.getExpr());
				}
			}
		}
	}
	
	private void write(final JstVars jstVars){
		PrintWriter writer = getWriter();
		if (jstVars.getType() != null){
			writer.append("var ");
		}
		writeInitializer(jstVars.getInitializer());
	}
}
