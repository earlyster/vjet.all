/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.eclipse.vjet.dsf.html.dom.DProgress;
import org.eclipse.vjet.dsf.html.dom.EHtmlAttr;
import org.eclipse.vjet.dsf.jsnative.HtmlProgress;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

public class AHtmlProgress extends AHtmlElement implements HtmlProgress {

	private static final long serialVersionUID = 1L;
	
	//
	// Constructor(s)
	//
	protected AHtmlProgress(AHtmlDocument doc, DProgress progress) {
		super(doc, progress);
		populateScriptable(AHtmlProgress.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}

	// 
	// Satisfy HtmlProgress
	//	
	public double getMax() {
		return getDouble(getDProgress().getHtmlMax());	
	}
	public void setMax(double max) {
		getDProgress().setHtmlMax(max);
		onAttrChange(EHtmlAttr.max, max);
	}
	
	public double getValue() {
		return getDouble(getDProgress().getHtmlValue());	
	}
	public void setValue(double value) {
		getDProgress().setHtmlValue(value);
		onAttrChange(EHtmlAttr.value, value);
	}

	//
	// Events
	//
	// Since property name is 'onabort', Rhino invokes this method.
	public Object getOnabort() {
		return getOnAbort();
	}
	
	// For Rhino
	public void setOnabort(Object functionRef) {
		setOnAbort(functionRef);
	}
	
	// Since property name is 'onblur', Rhino invokes this method.
	public Object getOnblur() {
		return getOnBlur();
	}
	
	// Since property name is 'onfocus', Rhino invokes this method.
	public Object getOnfocus() {
		return getOnFocus();
	}
	
	// For Rhino
	public void setOnblur(Object functionRef) {
		setOnBlur(functionRef);
	}
	
	// For Rhino
	public void setOnfocus(Object functionRef) {
		setOnFocus(functionRef);
	}
	
	// Since property name is 'onkeyup', Rhino invokes this method.
	public Object getOnload() {
		return getOnLoad();
	}
	
	// For Rhino
	public void setOnload(Object functionRef) {
		setOnLoad(functionRef);
	}
	
	// Since property name is 'onunload', Rhino invokes this method.
	public Object getOnunload() {
		return getOnLoad();
	}
	
	// For Rhino
	public void setOnunload(Object functionRef) {
		setOnLoad(functionRef);
	}
	
	// Since property name is 'onresize', Rhino invokes this method.
	public Object getOnresize() {
		return getOnResize();
	}
	
	// For Rhino
	public void setOnresize(Object functionRef) {
		setOnResize(functionRef);
	}
	
	// Since property name is 'onclick', Rhino invokes this method.
	public Object getOnclick() {
		return getOnClick();
	}
	
	// For Rhino
	public void setOnclick(Object functionRef) {
		setOnClick(functionRef);
	}
	
	// Since property name is 'ondblclick', Rhino invokes this method.
	public Object getOndblclick() {
		return getOnDblClick();
	}
	
	// For Rhino
	public void setOndblclick(Object functionRef) {
		setOnDblClick(functionRef);
	}
	
	// Since property name is 'onmousedown', Rhino invokes this method.
	public Object getOnmousedown() {
		return getOnMouseDown();
	}
	
	// For Rhino
	public void setOnmousedown(Object functionRef) {
		setOnMouseDown(functionRef);
	}
	
	// Since property name is 'onmousemove', Rhino invokes this method.
	public Object getOnmousemove() {
		return getOnMouseMove();
	}
	
	// For Rhino
	public void setOnmousemove(Object functionRef) {
		setOnMouseMove(functionRef);
	}
	
	// Since property name is 'onmouseout', Rhino invokes this method.
	public Object getOnmouseout() {
		return getOnMouseOut();
	}
	
	// For Rhino
	public void setOnmouseout(Object functionRef) {
		setOnMouseOut(functionRef);
	}
	
	// Since property name is 'onmouseover', Rhino invokes this method.
	public Object getOnmouseover() {
		return getOnMouseOver();
	}
	
	// For Rhino
	public void setOnmouseover(Object functionRef) {
		setOnMouseOver(functionRef);
	}
	
	// Since property name is 'onmouseup', Rhino invokes this method.
	public Object getOnmouseup() {
		return getOnMouseUp();
	}
	
	// For Rhino
	public void setOnmouseup(Object functionRef) {
		setOnMouseUp(functionRef);
	}

	//
	// Private
	//
	private DProgress getDProgress() {
		return (DProgress) getDNode();
	}
}
