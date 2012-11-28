/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.vjet.dsf.jstojava.resolver;

import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.IJstCompletion;

/**
 * A type construction context that holds information about the left-hand side
 * expression, input expressions and the constructed types.
 * 
 * @author paragraval
 * 
 */
public interface ITypeConstructContext {

	/**
	 * Returns non-null input expression node that needs to be resolved.
	 * 
	 * @return
	 */
	public IExpr getInputExpr();

	/**
	 * Returns the left-hand-side of expression, if available.
	 * 
	 * @return
	 */
	public IExpr getLhsExpr();

	/**
	 * Returns list of expressions for input arguments.
	 * 
	 * @return
	 */
	public List<IExpr> getArgsExpr();

	/**
	 * Returns non-modifiable list of {@link IJstType}, if resolved.
	 * 
	 * @return
	 */
	public List<IJstType> getTypes();

	/**
	 * Adds the given type to the list of resolved types.
	 * 
	 * @param jstType
	 * @return true, if the given type is added.
	 */
	public boolean addType(IJstType jstType);

	/**
	 * Returns the {@link IJstCompletion} node
	 * 
	 * @return
	 */
	public IJstCompletion getCompletion();
	

	public Class<? extends IExpr> getExprClass();
	
	public String getGroupName();



}
