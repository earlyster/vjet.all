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
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;

/**
 * http://www.html-reference.com/NOBR.htm
 *
 */
@Alias("HTMLNoBrElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlNoBr extends HtmlElement {
	@AJavaOnly @ARename(name="'JScript'")
	String LANGUAGE_JSCRIPT = "Jscript" ;
	@AJavaOnly @ARename(name="'javascript'")
	String LANGUAGE_JAVASCRIPT = "javascript" ; 
	@AJavaOnly @ARename(name="'vbs'")
	String LANGUAGE_VBS = "vbs" ; 
	@AJavaOnly @ARename(name="'vbscript'")
	String LANGUAGE_VBSCRIPT = "vbscript" ; 
	@AJavaOnly @ARename(name="'XML'")
	String LANGUAGE_XML = "XML" ;
	
	@AJavaOnly @ARename(name="'off'")
	String UNSELECTABLE_OFF = "off" ; 
	@AJavaOnly @ARename(name="'on'")
	String UNSELECTABLE_ON = "on" ;
}
