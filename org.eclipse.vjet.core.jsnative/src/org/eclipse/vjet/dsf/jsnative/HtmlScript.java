/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.AMappedToJS;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * http://www.w3.org/TR/REC-html40/interact/scripts.html#edef-SCRIPT
 *
 */
@Alias("HTMLScriptElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlScript extends HtmlElement {
	
	/** "text/css" */
	public static final String TYPE_TEXT_CSS = "text/css" ;
	/** "text/javascript" */
	@AJavaOnly @AMappedToJS (name="'text/javascript'")
	public static final String TYPE_TEXT_JAVASCRIPT = "text/javascript" ;
	/** "text/vbscript" */
	@AJavaOnly @AMappedToJS (name="'text/vbscript'")
	public static final String TYPE_TEXT_VBSCRIPT = "text/vbscript" ;
	
	//Document location for this script enum
	/** value = 0 */
	@AJavaOnly @AMappedToJS (name="0")
	public static final int DOCUMENT_LOCATION_HEAD = 0;
	/** value = 1 */
	@AJavaOnly @AMappedToJS (name="1")
	public static final int DOCUMENT_LOCATION_BODY = 1;
	
	@Property String getText();
	@Property void setText(String text);

	@Property String getCharset();
	@Property void setCharset(String charset);

	@Property boolean getDefer();
	@Property void setDefer(boolean defer);

	@Property String getSrc();
	@Property void setSrc(String src);

	@Property String getType();
	@Property void setType(String type);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onload")
	Object getOnLoad();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onload")
	void setOnLoad(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onunload")
	Object getOnUnload();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onunload")
	void setOnUnload(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	Object getOnMouseMove();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	void setOnMouseMove(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	Object getOnMouseOut();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	void setOnMouseOut(Object functionRef);
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	Object getOnMouseOver();
	
	
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	void setOnMouseOver(Object functionRef);

}
