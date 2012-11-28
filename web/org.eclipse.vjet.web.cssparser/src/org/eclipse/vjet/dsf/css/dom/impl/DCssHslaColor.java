/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.dom.impl;

import java.io.Serializable;

import org.eclipse.vjet.dsf.css.dom.IHslaColor;
import org.w3c.css.sac.LexicalUnit;
import org.w3c.dom.css.CSSPrimitiveValue;


/**
 * @see org.w3c.dom.css.HSLColor
 */

public final class DCssHslaColor 
	extends DCssHslColor
	implements IHslaColor, Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	
	private CSSPrimitiveValue m_alpha ;

    //
    // Constructor(s)
    //
    public DCssHslaColor(final LexicalUnit lu) {
    	super(lu) ;
        LexicalUnit next = lu;
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();
        m_alpha = new DCssValue(next, true);
    }

    protected DCssHslaColor() {
    	// empty on purpose
    }
    
    //
    // API
    //
    public CSSPrimitiveValue getAlpha() {
        return m_alpha;
    }
    public void setAlpha(final CSSPrimitiveValue alpha) {
        m_alpha = alpha;
    }

    //
    // Override(s) from Object
    //
    @Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
    @Override
    public String toString() {
    	final String h = m_hue.toString();
    	final String s = m_saturation.toString();
    	final String l = m_lightness.toString();
    	final String a = m_alpha.toString();
    	
    	final StringBuilder sb = new StringBuilder(20);;
    	sb.append("hsla(");
    	if (isPercentage(h)) appendPercentage(sb, h); else sb.append(h) ;
    	sb.append(',') ;
    	if (isPercentage(s)) appendPercentage(sb, s); else sb.append(s) ;
    	sb.append(',') ;
    	if (isPercentage(l)) appendPercentage(sb, l); else sb.append(l) ;
    	sb.append(',') ;
    	sb.append(a) ;
    	sb.append(')');
    	
		return sb.toString();
    }
}
