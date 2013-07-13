/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.jstvalidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.validation.common.ScopeId;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IScriptProblem;

public class ValidationCtx {
	
	private List<IScriptProblem> m_problems;
	private IJstNode m_node;
	private String m_filePath;
	private ScopeId m_scope;
	private char[] m_source;
	
	public List<IScriptProblem> getProblems() {
		if(m_problems==null){
			m_problems = new ArrayList<IScriptProblem>();
		}
		return m_problems;
	}
	public void setProblems(List<IScriptProblem> problems) {
		m_problems = problems;
	}
	
	public IJstNode getNode() {
		return m_node;
	}
	
	public void setNode(IJstNode type) {
		m_node = type;
	}
	public String getFilePath() {
		return m_filePath;
	}
	public void setFilePath(String filePath) {
		m_filePath = filePath;
	}
	
	public void setSource(char[] file){
		m_source = file;
	}
	
	public ScopeId getScope() {
		return m_scope;
	}
	public void setScope(ScopeId scope) {
		m_scope = scope;
	}
	
	public char[] getSource() {
		return m_source;
	}
	
	
}
