/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst;

import java.io.Serializable;
import java.util.List;

import org.eclipse.vjet.dsf.jst.traversal.IJstNodeVisitor;

public interface IJstNode extends Serializable {

	/**
	 * the root of the JST hierarchy (the outer type)
	 * @return
	 */
	IJstNode getRootNode();
	/**
	 * the node that contains this node in JST tree as a child
	 * @return
	 */
	IJstNode getParentNode();
	
	/**
	 * subnodes in the syntax tree
	 * @return
	 */
	List<? extends IJstNode> getChildren();
	
	/**
	 * The the JST type which either declares or inherits this node. 
	 * @return the owner node (the scope) or null if not applicable
	 */
	IJstType getOwnerType();
	
	/**
	 * Unlike the getOwnerType(), returns the type that actually declares the node.
	 * <br>
	 * @return the owner node that actually declares the node
	 */
	IJstType getRootType();
	
	JstSource getSource();
	
	List<IJstAnnotation> getAnnotations();
	
	IJstAnnotation getAnnotation(String name);
	
	List<String> getComments();
	
	List<JstCommentLocation> getCommentLocations();
	
	void accept(IJstNodeVisitor visitor);
}
