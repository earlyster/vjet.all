/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * 
 * http://www.w3.org/TR/REC-html40/struct/text.html#edef-BR
 *
 */
@Alias("HTMLBRElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlBr extends HtmlElement {
	/** "none" */
	public static final String CLEAR_NONE = "none" ;
	/** "left" */
	public static final String CLEAR_LEFT = "left" ;
	/** "right" */
	public static final String CLEAR_RIGHT = "right" ;
	/** "all" */
	public static final String CLEAR_ALL = "all" ;
	
	@Property String getClear();
	@Property void setClear(String clear);
}
