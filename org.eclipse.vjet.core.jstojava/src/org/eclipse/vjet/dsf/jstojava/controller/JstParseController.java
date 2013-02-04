/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstParseController;
import org.eclipse.vjet.dsf.jst.IJstParser;
import org.eclipse.vjet.dsf.jst.IJstProperty;
import org.eclipse.vjet.dsf.jst.IJstRefResolver;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.IScriptProblem;
import org.eclipse.vjet.dsf.jst.ResolutionResult;
import org.eclipse.vjet.dsf.jst.declaration.JstBlock;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.jst.lib.IJstLibProvider;
import org.eclipse.vjet.dsf.jst.ts.JstTypeSpaceMgr;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.ts.util.JstTypeCopier;

public class JstParseController implements IJstParseController {
	
	private IJstParser m_parser;
	private IJstRefResolver m_resolver;	
	private JstTypeSpaceMgr m_tsMgr;
	
	private IJstLibProvider m_libProvider = new NativeJsLibProvider();
	
	public JstParseController(IJstParser parser) {
		if (parser == null) {
			throw new RuntimeException("parser can't be null");
		}
		m_parser = parser;
		m_resolver = new JstExpressionBindingResolver(this);
		initialize();
	}	
	
	private void initialize() {		
		// load JsNative types into JstCache for vjo parsing
		m_libProvider.getAll();		
	}

	public synchronized IJstType parse(String groupName, String fileName, String source) {
		return m_parser.parse(groupName, fileName, source);
	}
	
	public synchronized IJstType parse(String groupName, File sourceFile) {
		return m_parser.parse(groupName, sourceFile);
	}

	public synchronized IJstType parseAndResolve(String groupName, String fileName,
			String source) {
		if (source == null) {
			throw new DsfRuntimeException("missing source for " + fileName);
		}
		
		IJstType unit;
		ParseResultHolder holder = getCacheHolder(groupName, fileName, source);			
		if (holder.isLoaded()) {
			//System.out.println("Using Cache Result");
			unit = holder.getResult();
		}
		else {
			List<IScriptProblem> problems = new ArrayList<IScriptProblem>();
			unit = m_parser.parse(groupName, fileName, source);
			if(unit!=null){
				problems.addAll(unit.getProblems());
				((JstType)unit).clearProblems();
				resolve(groupName, unit);
				if(unit.getProblems()!=null){
					// resolution problems
					problems.addAll(unit.getProblems());
				}
				unit.setProblems(problems);
				
				holder.setResult(unit);
			}
			
			
			
		}	
		return unit;
	}
	
	public synchronized IJstType parseAndResolve(String groupName, File sourceFile) {
		if (sourceFile == null) {
			throw new DsfRuntimeException("missing source file!");
		}
		String fileName = sourceFile.getAbsolutePath();
		String source = VjoParser.getContent(sourceFile);
		return parseAndResolve(groupName, fileName, source);		
	}

	public IJstType resolve(IJstType type) {
		return m_resolver.resolve(type).getType();
	}
	
	public IJstType resolve(String groupName, IJstType su) {
		List<JstBlock> blocks = su.getJstBlockList();
		ResolutionResult resolve = m_resolver.resolve(groupName, su);
		addResolutionResultToSU(su, resolve);
		if(blocks==null){
			return null;
		}
		
		if(su.getJstBlockList()==null){
			su.setJstBlockList(blocks);
		}
		for (JstBlock block : blocks) {
			ResolutionResult resolutionResult = m_resolver.resolve(null, block);
			addResolutionResultToSU(su, resolutionResult);			
		}
		
		return resolve.getType();
		
	}
	
	private void addResolutionResultToSU(IJstType su, ResolutionResult resolve) {
//		su.getProblems().addAll(resolve.getProblems());
		
		if(resolve.getType()!=null){
			
			if(su instanceof JstType && resolve.getType() instanceof JstType){
				JstType type = (JstType)su;
				if(type != resolve.getType()){
					JstTypeCopier.replace(type, (JstType)resolve.getType());
					// TODO look into faster resolution here...
					// added this to handle references to old copy of jsttype
					resolve(type);
				}
				// copy resolve.getType into type
				
			}else{
			
				su = resolve.getType();
			}
		}
	}

	
	public IJstType resolve(IJstProperty property) {
		return m_resolver.resolve(property).getType();
	}
	
	public IJstType resolve(String groupName, IJstProperty property) {
		ResolutionResult rr = m_resolver.resolve(groupName, property);
		return rr.getType();
	}
	
	public IJstType resolve(IJstMethod method) {
		return m_resolver.resolve(method).getType();
	}
	
	public IJstType resolve(String groupName, IJstMethod method) {
		ResolutionResult rr = m_resolver.resolve(groupName, method);
		return rr.getType();
	}
	
	public void setRefResolver(IJstRefResolver resolver) {
		m_resolver = resolver;
	}
	
	public JstTypeSpaceMgr getJstTypeSpaceMgr() {
		return m_tsMgr;
	}

	public void setJstTSMgr(JstTypeSpaceMgr jstTSMgr) {
		m_tsMgr = jstTSMgr;
	}

	public IJstType resolve(IJstType type, IJstNode node) {
		ResolutionResult rr = m_resolver.resolve(type, node);
		return rr.getType();
	}

	/**
	 * Optimistic caching support for most current parsing result
	 */
	private ParseResultHolder m_currentHolder= null;
	
	private ParseResultHolder getCacheHolder
		(String group, String fileName, String source) {
		if (m_currentHolder == null || !m_currentHolder.isMatch(group, fileName, source)) {
			m_currentHolder = new ParseResultHolder(group, fileName, source);
		}		
		return m_currentHolder;
	}
	
	private static class ParseResultHolder {
		private final String m_group;
		private final String m_fileName;
		private final String m_source;
		private IJstType m_result = null;
		private boolean m_loaded = false;
		
		ParseResultHolder(String group, String fileName, String source) {
			m_group = group;
			m_fileName = fileName;
			m_source = source;
		}
		
		boolean isMatch(String group, String fileName, String source) {
			return m_group.equals(group) &&
				m_fileName!=null && m_fileName.equals(fileName) &&
				m_source.equals(source);
		}
		
		boolean isLoaded() {
			return m_loaded;
		}
		
		IJstType getResult() {
			return m_result;
		}
		
		void setResult(IJstType result) {
			m_result = result;
			m_loaded = true;
		}
	}
}
