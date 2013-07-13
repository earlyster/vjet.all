/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
//package org.eclipse.vjet.dsf.jst.util;
//
//import org.eclipse.vjet.dsf.jst.IJstRefResolver;
//import org.eclipse.vjet.dsf.jst.IJstType;
//import org.eclipse.vjet.dsf.jst.JstParseController;
//import org.eclipse.vjet.dsf.jst.traversal.JstDepthFirstTraversal;
//
//@Deprecated
//public class JstExpressionBindingResolver implements IJstRefResolver {
//	
//	private final JstParseController m_controller;
//	
//	private final JstExpressionTypeLinker m_typeLinkerVisitor;
//	
//	public JstExpressionBindingResolver(JstParseController controller) {
//		m_controller = controller;
//		m_typeLinkerVisitor = new JstExpressionTypeLinker(this);
//	}
//
//	public void resolve(IJstType type) {
//		m_typeLinkerVisitor.setType(type);		
//		JstDepthFirstTraversal.accept(type, m_typeLinkerVisitor);
//	}
//	
//	public JstParseController getController() {
//		return m_controller;
//	}
//
//}
