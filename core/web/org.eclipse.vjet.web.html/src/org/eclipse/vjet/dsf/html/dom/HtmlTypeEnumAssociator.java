/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.html.dom;

public class HtmlTypeEnumAssociator {
	private HtmlTypeEnumAssociator(){}
	/** pass through to package friendly HtmlTypeEnum.getNameChars() **/
	public static char [] getNameCharArray(final HtmlTypeEnum type){
		return type.getNameChars();
	}
}
