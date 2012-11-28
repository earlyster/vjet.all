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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.IJstCompletion;

/**
 * @author paragraval
 * 
 */
public class TypeConstructContext implements ITypeConstructContext {

	private final IExpr inputExpr;
	private final IExpr lhsExpr;
	private final List<IExpr> argsExprList;
	private final List<IJstType> resolvedJstTypes;
	private final IJstCompletion jstCompletion;
	private final Class<? extends IExpr> exprClass;
	private String groupName;

	public Class<? extends IExpr> getExprClass() {
		return exprClass;
	}



	public TypeConstructContext(IExpr inputExpr, IExpr lhsExpr,
			List<IExpr> argsExprList, IJstCompletion jstCompletion, Class<? extends IExpr> class1, String groupName) {

		this.inputExpr = inputExpr;
		this.lhsExpr = lhsExpr;
		this.argsExprList = argsExprList;
		this.jstCompletion = jstCompletion;
		this.exprClass = class1;
		resolvedJstTypes = new ArrayList<IJstType>();
		this.setGroupName(groupName);
	}

	@Override
	public IExpr getInputExpr() {
		return inputExpr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.vjet.dsf.jstojava.resolver.ITypeConstructContext#getLhsExpr
	 * ()
	 */
	@Override
	public IExpr getLhsExpr() {
		return lhsExpr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.vjet.dsf.jstojava.resolver.ITypeConstructContext#getArgsExpr
	 * ()
	 */
	@Override
	public List<IExpr> getArgsExpr() {
		return Collections.unmodifiableList(argsExprList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.vjet.dsf.jstojava.resolver.ITypeConstructContext#getTypes()
	 */
	@Override
	public List<IJstType> getTypes() {
		return Collections.unmodifiableList(resolvedJstTypes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.vjet.dsf.jstojava.resolver.ITypeConstructContext#addType
	 * (org.eclipse.vjet.dsf.jst.IJstType)
	 */
	@Override
	public boolean addType(IJstType jstType) {
		return resolvedJstTypes.add(jstType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.vjet.dsf.jstojava.resolver.ITypeConstructContext#getCompletion
	 * ()
	 */
	@Override
	public IJstCompletion getCompletion() {
		return jstCompletion;
	}



	public String getGroupName() {
		return groupName;
	}



	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
