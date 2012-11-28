/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jstojava.report.ErrorReporter;

public interface IFindTypeSupport {

	IJstType getCurrentType();
	
//	Map<String, IJstType> getSymbol2TypeMap();
	/**
	 * by huzhou@ebay.com replacing #getSymbol2TypeMap
	 */
	IJstType findTypeByName(final String name);
	
	char[] getOriginalSource();
	
	ILineInfoProvider getLineInfoProvider();
	
	ErrorReporter getErrorReporter();
	
	interface ILineInfoProvider {
		int line(int beginOffset);
		int col(int beginOffset);
	}
}
