/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative_deprecated;

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.HtmlElement;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * http://www.htmlref.com/Reference/AppA/tag_rt.htm
 *
 */
@Alias("HTMLRubyElement")
@DOMSupport(DomLevel.ONE)
public interface HtmlRuby_IE extends HtmlElement {
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
	
	@AJavaOnly @ARename(name="'on'")
	String UNSELECTABLE_ON = "on" ; 
	@AJavaOnly @ARename(name="'off'")
	String UNSELECTABLE_OFF = "off" ; 
	
	@Property  String getAccessKey();
	@Property  void setAccessKey(String accessKey);

	@Property String getAtomicSelection();
	@Property void setAtomicSelection(String atomic);
	
	@Property String getContentEditable();
	@Property void setContentEditable(String contenteditable);
	
	@Property String getHideFocus();
	@Property void setHideFocus(String hidefocus);
	
	@Property String getLanguage();
	@Property void setLanguage(String language);
	
	@Property String getName();
	@Property void setName(String name);
	
	@Property int getTabIndex();
	@Property void setTabIndex(String tabindex);
	
	@Property String getUnselectable();
	@Property void setUnselectable(String unselectable);
	
}
