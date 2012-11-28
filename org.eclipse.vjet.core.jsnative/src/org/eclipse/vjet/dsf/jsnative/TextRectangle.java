/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.jsnative.anno.BrowserSupport;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.mozilla.mod.javascript.IWillBeScriptable;

/**
 * http://www.w3.org/TR/cssom-view/#the-textrectangle-interface
 */
@JsMetatype
public interface TextRectangle extends IWillBeScriptable {
	/**
	 * 
	 * The top attribute, on getting, must return the distance between the top of the viewport and the top of the rectangle box as number of CSS pixels
	 */
	@BrowserSupport({BrowserType.IE_6P,BrowserType.FIREFOX_3P})
	@Property float getTop();

	/**
	 * 
	 * The right attribute, on getting, must return the distance between the left of the viewport and the right of the rectangle box as number of CSS pixels
	 */
	@BrowserSupport({BrowserType.IE_6P,BrowserType.FIREFOX_3P})
	@Property float getRight();

	/**
	 * 
	 * The bottom attribute, on getting, must return the distance between the top of the viewport and the bottom of the rectangle box as number of CSS pixels
	 */
	@BrowserSupport({BrowserType.IE_6P,BrowserType.FIREFOX_3P})
	@Property float getBottom();

	/**
	 * 
	 * The left attribute, on getting, must return the distance between the left of the viewport and the left of the rectangle box as number of CSS pixels
	 */
	@BrowserSupport({BrowserType.IE_6P,BrowserType.FIREFOX_3P})
	@Property float getLeft();
}
