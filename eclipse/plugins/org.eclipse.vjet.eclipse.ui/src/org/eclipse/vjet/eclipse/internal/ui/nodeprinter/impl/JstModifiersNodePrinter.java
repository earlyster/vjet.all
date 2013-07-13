/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.vjet.eclipse.internal.ui.nodeprinter.impl;

import org.eclipse.vjet.dsf.jst.declaration.JstModifiers;
import org.eclipse.vjet.eclipse.internal.ui.nodeprinter.INodePrinter;

/**
 * 
 *
 */
public class JstModifiersNodePrinter implements INodePrinter {

	/* (non-Javadoc)
	 * @see org.eclipse.vjet.eclipse.internal.ui.nodeprinter.INodePrinter#getPropertyNames(Object node)
	 */
	public String[] getPropertyNames(Object node) {
		return new String[] {"object_id", "access_scope", "is_static", "is_abstract", "is_dynamic", "is_final"};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.vjet.eclipse.internal.ui.nodeprinter.INodePrinter#getPropertyValuies(java.lang.Object)
	 */
	public Object[] getPropertyValuies(Object node) {
		String objectID = String.valueOf(node.hashCode());
		JstModifiers jstModifiers = (JstModifiers)node;
		
		String accessScope = jstModifiers.getAccessScope();
		String isStatic = String.valueOf(jstModifiers.isStatic());
		String isAbstract = String.valueOf(jstModifiers.isAbstract());
		String isDynamic = String.valueOf(jstModifiers.isDynamic());
		String isFinal = String.valueOf(jstModifiers.isFinal());
		return new Object[] {objectID, accessScope, isStatic, isAbstract, isDynamic, isFinal};
	}

}
