/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.control.translate;

import org.eclipse.jdt.core.dom.CompilationUnit;

import org.eclipse.vjet.dsf.javatojs.trace.ITranslateTracer;
import org.eclipse.vjet.dsf.javatojs.translate.TranslateCtx;
import org.eclipse.vjet.dsf.javatojs.translate.TranslationMode;
import org.eclipse.vjet.dsf.jst.declaration.JstType;

public final class TypeTranslateTask extends BaseTask {

	private JstType m_type;
	
	//
	// Constructor
	//
	TypeTranslateTask(String id, CompilationUnit cu, 
		JstType type, TranslateCtx ctx, ITranslateTracer tracer, TranslateCtx parentCtx){
		
		super(id, cu, tracer, parentCtx);
		m_type = type;
	}
	
	//
	// Satisfying BaseTask
	//
	void doIt(){
		TranslateCtx.ctx().getProvider().getUnitTranslator().processUnit(getCompilationUnit(), m_type);
	}
	
	//
	// API
	//
	public  TranslationMode getMode(){
		return TranslateCtx.ctx().getTranslateInfo(m_type).getMode();
	}
	
	public JstType getType(){
		return m_type;
	}
}
