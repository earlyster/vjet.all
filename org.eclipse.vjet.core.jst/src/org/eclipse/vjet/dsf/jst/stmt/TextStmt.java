/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.stmt;

import org.eclipse.vjet.dsf.jst.BaseJstNode;
import org.eclipse.vjet.dsf.jst.token.IStmt;
import org.eclipse.vjet.dsf.jst.traversal.IJstNodeVisitor;

public class TextStmt extends BaseJstNode implements IStmt {
	
	private static final long serialVersionUID = 1L;
	
	private String m_text;
	
	public TextStmt(String text){
		assert text != null : "text cannot be null";
		m_text = text;
	}

	public String toStmtText(){
		return m_text;
	}

	@Override
	public void accept(IJstNodeVisitor visitor){
		visitor.visit(this);
	}
	
	@Override
	public String toString(){
		return toStmtText();
	}
}
