/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.eclipse.vjet.dsf.html.dom.DCanvas;
import org.eclipse.vjet.dsf.html.dom.EHtmlAttr;
import org.eclipse.vjet.dsf.jsnative.HtmlCanvas;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

public class AHtmlCanvas extends AHtmlElement implements HtmlCanvas {

	private static final long serialVersionUID = 1L;
	
	//
	// Constructor(s)
	//
	protected AHtmlCanvas(AHtmlDocument doc, DCanvas node) {
		super(doc, node);
		populateScriptable(AHtmlCanvas.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}

	//
	// API
	//
	
	
	
	
	public int getHeight() {
		try {
			return Integer.valueOf(getDCanvas().getHtmlHeight());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return 0;
		}	
	}
	public void setHeight(int height) {
		getDCanvas().setHtmlHeight(height);
		onAttrChange(EHtmlAttr.height, height);
	}
	
	public int getWidth() {
		try {
			return Integer.valueOf(getDCanvas().getHtmlWidth());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return 0;
		}	
	}
	public void setWidth(int width) {
		getDCanvas().setHtmlWidth(width);
		onAttrChange(EHtmlAttr.width, width);
	}
	
	
	@Override
	public Object getContext(String contextId, Object... args) {
		// TODO not implemented for ADOM
		return null;
	}

	@Override
	public String toDataURL(String type, Object... args) {
		// TODO not implemented for ADOM
		return null;
	}


	
	
	//
	// Events
	//

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
	
	// Since property name is 'onkeydown', Rhino invokes this method.
	public Object getOnkeydown() {
		return getOnKeyDown();
	}
	
	// For Rhino
	public void setOnkeydown(Object functionRef) {
		setOnKeyDown(functionRef);
	}
	
	// Since property name is 'onkeypress', Rhino invokes this method.
	public Object getOnkeypress() {
		return getOnKeyPress();
	}
	
	// For Rhino
	public void setOnkeypress(Object functionRef) {
		setOnKeyPress(functionRef);
	}
	
	// Since property name is 'onkeyup', Rhino invokes this method.
	public Object getOnkeyup() {
		return getOnKeyUp();
	}
	
	// For Rhino
	public void setOnkeyup(Object functionRef) {
		setOnKeyUp(functionRef);
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
	private DCanvas getDCanvas() {
		return (DCanvas) getDNode();
	}


}

