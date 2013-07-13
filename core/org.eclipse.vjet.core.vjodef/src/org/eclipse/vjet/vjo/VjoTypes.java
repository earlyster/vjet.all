/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo;

import org.eclipse.vjet.dsf.jsnative.global.Object;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.declaration.JstFactory;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstType;

public class VjoTypes {

	public static final JstMethod CAST = new JstMethod("cast");
	
	public static JstType VJO_JAVA_LANG_UTIL;
		
	static{
		
		VJO_JAVA_LANG_UTIL = JstFactory.getInstance()
		.createJstType("org.eclipse.vjet.vjo.java.lang.Util", false)
			.addMethod(CAST);
		
		VJO_JAVA_LANG_UTIL
			.addExtend(JstCache.getInstance().getType(Object.class.getName()));
	}
	
}
