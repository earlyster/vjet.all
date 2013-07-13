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

import org.w3c.dom.css.CSSValue;

public class DCssProperty implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String m_name;
    private CSSValue m_value;
    private boolean m_important;

    /** Creates new Property */
    public DCssProperty(String name, CSSValue value, boolean important) {
        m_name = name;
        m_value = value;
        m_important = important;
    }

    public String getName() {
        return m_name;
    }

    public CSSValue getValue() {
        return m_value;
    }

    public boolean isImportant() {
        return m_important;
    }

    public void setValue(CSSValue value) {
        m_value = value;
    }
    
    public void setImportant(boolean important) {
        m_important = important;
    }
    
    public String toString() {
        return m_name + ":"
            + m_value.toString()
            + (m_important ? " !important" : "");
    }
    
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}