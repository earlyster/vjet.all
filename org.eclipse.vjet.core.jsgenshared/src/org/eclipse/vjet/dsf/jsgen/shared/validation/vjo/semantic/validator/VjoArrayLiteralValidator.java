/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticValidator;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.visitor.IVjoValidationPostAllChildrenListener;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.visitor.IVjoValidationVisitorEvent;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.term.ArrayLiteral;

/**
 * refactored @ Oct/11/2009
 * all symbol tables logic in validation is to be removed
 * 
 *
 */
public class VjoArrayLiteralValidator 
	extends VjoSemanticValidator 
	implements IVjoValidationPostAllChildrenListener {

	private static List<Class<? extends IJstNode>> s_targetTypes;

	static{
		s_targetTypes = new ArrayList<Class<? extends IJstNode>>();
		s_targetTypes.add(ArrayLiteral.class);
	}
	
	@Override
	public List<Class<? extends IJstNode>> getTargetNodeTypes() {
		return s_targetTypes;
	}
	
	@Override
	public void onPostAllChildrenEvent(final IVjoValidationVisitorEvent event){
		//do nothing
		//no more handling of the symbol table
	}
}
