/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.util;

import org.eclipse.vjet.dsf.javatojs.translate.TranslateCtx;
import org.eclipse.vjet.dsf.jst.declaration.JstType;

public class JstToJavaHelper {

	public static String getJavaTypeName(final JstType jstType){
		if (jstType == null){
			return null;
		}
		
		return TranslateCtx.ctx().getConfig().getPackageMapping().mapFrom(jstType.getName());
	}
}
