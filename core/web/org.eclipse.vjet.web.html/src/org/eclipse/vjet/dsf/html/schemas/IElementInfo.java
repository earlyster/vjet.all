/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/* Created on Dec 19, 2005 */
package org.eclipse.vjet.dsf.html.schemas;

import org.eclipse.vjet.dsf.html.dom.HtmlTypeEnum;

public interface IElementInfo extends Iterable<IAttributeInfo> {
	public HtmlTypeEnum getType();
	public boolean requireEndTag();
	public boolean requireStartTag();
	public IAttributeInfo getAttributeInfo(final String name);
	public IContentModel getContentModel();
//	public Iterator<IAttributeInfo> createAttributeInfoIterator();
}
