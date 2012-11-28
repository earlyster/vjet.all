/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.eclipse.vjet.dsf.html.dom.DOption;
import org.eclipse.vjet.dsf.html.dom.EHtmlAttr;
import org.eclipse.vjet.dsf.jsnative.HtmlForm;
import org.eclipse.vjet.dsf.jsnative.HtmlOption;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

public class AHtmlOption extends AHtmlElement implements HtmlOption {

	private static final long serialVersionUID = 1L;
	
	protected AHtmlOption(AHtmlDocument doc, DOption option) {
		super(doc, option);
		populateScriptable(AHtmlOption.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}

	public boolean getDefaultSelected() {
		return AHtmlHelper.booleanValueOf(EHtmlAttr.defaultSelected,getHtmlAttribute(EHtmlAttr.defaultSelected));
	}

	public boolean getDisabled() {
		return AHtmlHelper.booleanValueOf(EHtmlAttr.disabled,getHtmlAttribute(EHtmlAttr.disabled));
	}

	public HtmlForm getForm() {
		return super.getFormInternal();
	}

	public int getIndex() {
		return getDOption().getHtmlIndex();
	}

	public String getLabel() {
		return getDOption().getHtmlLabel();
	}

	public boolean getSelected() {
		return AHtmlHelper.booleanValueOf(EHtmlAttr.selected,getHtmlAttribute(EHtmlAttr.selected));
	}

	public String getText() {
		return getDOption().getHtmlText();
	}

	public String getValue() {
		return getDOption().getHtmlValue();
	}

	public void setDefaultSelected(boolean defaultSelected) {
		setHtmlAttribute(EHtmlAttr.defaultSelected, defaultSelected);
		onAttrChange(EHtmlAttr.defaultSelected, defaultSelected);
	}

	public void setDisabled(boolean disabled) {
		getDOption().setAttribute(EHtmlAttr.disabled, String.valueOf(disabled));
		onAttrChange(EHtmlAttr.disabled, disabled);
	}

	public void setIndex(int index) {
		getDOption().setHtmlIndex(index);
		// TODO EHtmlAttr.index doesn't exists
//		onAttrChange(EHtmlAttr.index, index);
	}

	public void setLabel(String label) {
		getDOption().setHtmlLabel(label);
		onAttrChange(EHtmlAttr.label, label);
	}
	
	public void setSelected(boolean selected) {
		getDOption().setAttribute(EHtmlAttr.selected, String.valueOf(selected));
		onAttrChange(EHtmlAttr.selected, selected);
	}
	
	public void setText(String text) {
		getDOption().setHtmlText(text);
	}

	public void setValue(String value) {
		getDOption().setHtmlValue(value);
		onValueChange(value);
	}
	
	private DOption getDOption() {
		return (DOption) getDNode();
	}

}
