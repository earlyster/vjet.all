/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.eclipse.vjet.dsf.html.dom.DBr;
import org.eclipse.vjet.dsf.html.dom.EHtmlAttr;
import org.eclipse.vjet.dsf.jsnative.HtmlBr;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

public class AHtmlBr extends AHtmlElement implements HtmlBr {

	private static final long serialVersionUID = 1L;
	
	protected AHtmlBr(AHtmlDocument doc, DBr br) {
		super(doc, br);
		populateScriptable(AHtmlBr.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}

	public String getClear() {
		return getDBr().getHtmlClear();
	}

	public void setClear(String clear) {
		getDBr().setHtmlClear(clear);
		onAttrChange(EHtmlAttr.clear, clear);
	}
	
	private DBr getDBr() {
		return (DBr) getDNode();
	}

}
