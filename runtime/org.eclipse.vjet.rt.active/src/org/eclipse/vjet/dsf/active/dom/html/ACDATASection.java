/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.eclipse.vjet.dsf.dom.DCDATASection;
import org.eclipse.vjet.dsf.jsnative.CDATASection;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

public class ACDATASection extends AText implements CDATASection {

	private static final long serialVersionUID = 1L;
	
	protected ACDATASection(AHtmlDocument doc, DCDATASection text) {
		super(doc, text);
		populateScriptable(ACDATASection.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}
	
	@Override
	public String getNodeName() {
		return "#cdata-section";
	}
	
}
