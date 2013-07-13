/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.dom.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;

import org.eclipse.vjet.dsf.css.parser.DCssBuilder;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSFontFaceRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;

/**
 * @see org.w3c.dom.css.CSSFontFaceRule
 */
public class DCssFontFaceRule
	extends DCssRule
	implements CSSFontFaceRule, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private CSSStyleDeclaration m_style = null;

	public DCssFontFaceRule(
		CSSStyleSheet parentStyleSheet,
		CSSRule parentRule) {
		super(parentStyleSheet, parentRule);
	}

	public short getType() {
		return FONT_FACE_RULE;
	}

	public String getCssText() {
		return "@font-face " + getStyle().getCssText();
	}

	public void setCssText(String cssText) throws DOMException {
		// TODO look into  && m_parentStyleSheet.isReadOnly()
		if (m_parentStyleSheet != null) {
			throw new DCssException(
				DOMException.NO_MODIFICATION_ALLOWED_ERR,
				DCssException.READ_ONLY_STYLE_SHEET);
		}

		try {
			InputSource is = new InputSource(new StringReader(cssText));
			DCssBuilder parser = new DCssBuilder();
			CSSRule r = parser.parseRule(is);

			// The rule must be a font face rule
			if (r.getType() == CSSRule.FONT_FACE_RULE) {
				m_style = ((DCssFontFaceRule) r).m_style;
			} else {
				throw new DCssException(
					DOMException.INVALID_MODIFICATION_ERR,
					DCssException.EXPECTING_FONT_FACE_RULE);
			}
		} catch (DCssException e) {
			throw new DCssException(
				DOMException.SYNTAX_ERR,
				DCssException.SYNTAX_ERROR,
				e.getMessage());
		} catch (IOException e) {
			throw new DCssException(
				DOMException.SYNTAX_ERR,
				DCssException.SYNTAX_ERROR,
				e.getMessage());
		}
		
//		return this ;
	}

	public CSSStyleDeclaration getStyle() {
		return m_style;
	}

	public CSSFontFaceRule setStyle(CSSStyleDeclaration style) {
		m_style = style;
		return this ;
	}

	//
	// Override(s) from Object
	//
	/** 
	 * DO NOT CHANGE THIS.  Unfortunately the def code relies on toString()
	 * for values.  Will need to fix this.
	 */
	@Override
	public String toString() {
		return getCssText() ;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
