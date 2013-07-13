/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.parser.comments;

import org.eclipse.vjet.dsf.jst.meta.JsTypingMeta;
import org.eclipse.vjet.dsf.jst.meta.Token;

/**
 * Representing an attributed type from function scope - "this" at invocation time.
 */
public class JsFuncScopeAttributedType extends JsTypingMeta {

	public JsFuncScopeAttributedType(Token typingToken) {
		super(typingToken);
	}
	
	@Override
	public String getType() {
		return null;
	}

}
