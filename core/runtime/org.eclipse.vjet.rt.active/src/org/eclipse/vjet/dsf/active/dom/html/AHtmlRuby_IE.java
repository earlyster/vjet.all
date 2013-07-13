/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.eclipse.vjet.dsf.html.dom.EHtmlAttr;
import org.eclipse.vjet.dsf.html.dom.deprecated.DRuby_IE;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;
import org.eclipse.vjet.dsf.jsnative_deprecated.HtmlRuby_IE;

public class AHtmlRuby_IE extends AHtmlElement implements HtmlRuby_IE {

	private static final long serialVersionUID = 1L;
	
	protected AHtmlRuby_IE(AHtmlDocument doc, DRuby_IE node) {
		super(doc, node);
		populateScriptable(AHtmlRuby_IE.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}

	public String getAccessKey() {
		return getDRuby().getHtmlAccessKey();
	}

	public String getAtomicSelection() {
		return getDRuby().getHtmlAtomicSelection();
	}

	public String getContentEditable() {
		return getDRuby().getHtmlContentEditable();
	}

	public String getHideFocus() {
		return getDRuby().getHtmlHideFocus();
	}

	public String getLanguage() {
		return getDRuby().getHtmlLanguage();
	}

	public String getName() {
		return getDRuby().getHtmlName();
	}

	public int getTabIndex() {
		return getDRuby().getHtmlTabIndex();
	}

	public String getUnselectable() {
		return getDRuby().getHtmlUnselectable();
	}

	public void setAccessKey(String accessKey) {
		getDRuby().setHtmlAccessKey(accessKey);
		onAttrChange(EHtmlAttr.accesskey, accessKey);
	}

	public void setAtomicSelection(String atomic) {
		getDRuby().setHtmlAtomicSelection(atomic);
		onAttrChange(EHtmlAttr.atomicselection, atomic);
	}

	public void setContentEditable(String contenteditable) {
		getDRuby().setHtmlContentEditable(contenteditable);
		onAttrChange(EHtmlAttr.contenteditable, contenteditable);
	}

	public void setHideFocus(String hidefocus) {
		getDRuby().setHtmlHideFocus(hidefocus);
		onAttrChange(EHtmlAttr.hidefocus, hidefocus);
	}

	public void setLanguage(String language) {
		getDRuby().setHtmlLanguage(language);
		onAttrChange(EHtmlAttr.language, language);
	}

	public void setName(String name) {
		getDRuby().setHtmlName(name);
		onAttrChange(EHtmlAttr.name, name);
	}

	public void setTabIndex(String tabindex) {
		getDRuby().setHtmlTabIndex(tabindex);
		onAttrChange(EHtmlAttr.tabindex, tabindex);
	}

	public void setUnselectable(String unselectable) {
		getDRuby().setHtmlUnselectable(unselectable);
		onAttrChange(EHtmlAttr.unselectable, unselectable);
	}
	
	private DRuby_IE getDRuby() {
		return (DRuby_IE) getDNode();
	}
}
