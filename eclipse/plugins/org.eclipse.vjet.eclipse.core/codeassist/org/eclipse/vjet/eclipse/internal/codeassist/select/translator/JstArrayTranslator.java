/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.codeassist.select.translator;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstArray;
import org.eclipse.vjet.eclipse.internal.codeassist.select.JstNodeDLTKElementResolver;

public class JstArrayTranslator extends DefaultNodeTranslator {

	@Override
	public IJstNode lookupBinding(IJstNode jstNode) {
		JstArray arr = (JstArray) jstNode;
		IJstType type = arr.getComponentType();
		if (type == null) {
			return null;
		}
		return JstNodeDLTKElementResolver.lookupBinding(type);
	}
}