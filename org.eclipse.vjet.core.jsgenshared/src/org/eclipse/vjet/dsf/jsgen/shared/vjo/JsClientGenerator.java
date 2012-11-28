/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.vjo;

import org.eclipse.vjet.dsf.jst.reserved.JsClientKeywords;

/**
 * TODO:
 * 1. support browser variation
 *
 */
public class JsClientGenerator extends BaseGenerator  {
	
	//
	// Constructor
	//
	public JsClientGenerator(final GeneratorCtx ctx){
		super(ctx);
	}
	
	//
	// API
	//
	public JsClientGenerator writeAlert(final String msg){
		writeIndent();
		getWriter().append(JsClientKeywords.ALERT).append("(\"").append(msg).append("\");");
		writeNewline();
		return this;
	}
}
