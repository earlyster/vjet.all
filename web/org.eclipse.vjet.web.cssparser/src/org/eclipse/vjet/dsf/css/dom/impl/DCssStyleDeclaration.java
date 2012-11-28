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
import java.io.StringReader;
import java.util.ArrayList;

import org.eclipse.vjet.dsf.css.parser.DCssBuilder;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;

/**
 * @see org.w3c.dom.css.CSSStyleDeclaration
 */
public class DCssStyleDeclaration 
	implements CSSStyleDeclaration, Serializable, Cloneable {
	private static final long serialVersionUID = 200152048848468958L;
	static final String PRIORITY_IMPORTANT = "important";
	private CSSRule m_parentRule;
    private ArrayList<DCssProperty> m_properties = new ArrayList<DCssProperty>(5);
    private String m_text = null;
    
    public DCssStyleDeclaration(CSSRule parentRule) {
        m_parentRule = parentRule;
    }

    public String getCssText() {
    	if (m_text != null) {
    		return m_text;
    	}
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        //if newlines requested in text
        //sb.append("\n");
        for (int i = 0; i < m_properties.size(); ++i) {
            DCssProperty p = m_properties.get(i);
            if (p != null) {
                sb.append(p.toString());
            }
            if (i < m_properties.size() - 1) {
                sb.append("; ");
            }
            //if newlines requested in text
            //sb.append("\n");
        }
        sb.append("}");
        m_text = sb.toString();
        return m_text;
    }

    public void setCssText(String cssText) throws DOMException {
    	m_text = null;
        try {
            InputSource is = new InputSource(new StringReader(cssText));
            DCssBuilder parser = new DCssBuilder();
            m_properties.clear();
            parser.parseStyleDeclaration(this, is);
        } catch (Exception e) {
            throw new DCssException(
                DOMException.SYNTAX_ERR,
                DCssException.SYNTAX_ERROR,
                e.getMessage());
        }
      // TODO  return this ;
    }

    public String getPropertyValue(String propertyName) {
        DCssProperty p = getPropertyDeclaration(propertyName);
        return (p != null) ? p.getValue().toString() : "";
    }
    public String getPropertyValue(int propertyIndex) {
    	return m_properties.get(propertyIndex).getValue().toString();
    }

    public CSSValue getPropertyCSSValue(String propertyName) {
        DCssProperty p = getPropertyDeclaration(propertyName);
        return (p != null) ? p.getValue() : null;
    }

    public String removeProperty(String propertyName) throws DOMException {
    	m_text = null;
        for (int i = 0; i < m_properties.size(); i++) {
            DCssProperty p = m_properties.get(i);
            if (p.getName().equalsIgnoreCase(propertyName)) {
                m_properties.remove(i);
                return p.getValue().toString();
            }
        }
        return "";
    }

    public String getPropertyPriority(String propertyName) {
        DCssProperty p = getPropertyDeclaration(propertyName);
        if (p != null) {
            return p.isImportant() ? PRIORITY_IMPORTANT : "";
        } 
        return "";
    }

    public void setProperty(
            String propertyName,
            String value,
            String priority ) throws DOMException {
    	m_text = null;
        try {
            InputSource is = new InputSource(new StringReader(value.trim()));
            DCssBuilder parser = new DCssBuilder();
            CSSValue expr = parser.parsePropertyValue(is);
            DCssProperty p = getPropertyDeclaration(propertyName);
            boolean important = PRIORITY_IMPORTANT.equalsIgnoreCase(priority);
            if (p == null) {
                p = new DCssProperty(propertyName, expr, important);
                addProperty(p);
            } else {
                p.setValue(expr);
                p.setImportant(important);
            }
        } catch (Exception e) {
            throw new DCssException(
            DOMException.SYNTAX_ERR,
            DCssException.SYNTAX_ERROR,
            e.getMessage());
        }
       // TODO return this ;
    }
    
    public int getLength() {
        return m_properties.size();
    }

    public String item(int index) {
        DCssProperty p = m_properties.get(index);
        return (p != null) ? p.getName() : "";
    }

    public CSSRule getParentRule() {
        return m_parentRule;
    }

    public CSSStyleDeclaration addProperty(DCssProperty p) {
    	m_text = null;
        m_properties.add(p);
        return this ;
    }

    public DCssProperty getPropertyDeclaration(int indexPosition) {
    	return m_properties.get(indexPosition) ;
    }
    public DCssProperty getPropertyDeclaration(String name) {
        for (int i = 0; i < m_properties.size(); i++) {
            DCssProperty p = m_properties.get(i);
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public String toString() {
        return getCssText();
    }
    
	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException {
		DCssStyleDeclaration clone = (DCssStyleDeclaration)super.clone();
		clone.m_properties = (ArrayList)m_properties.clone();
		for (int i = 0; i < clone.m_properties.size(); i++) {
			clone.m_properties.set
				(i, (DCssProperty)clone.m_properties.get(i).clone());
		}
		return clone;
	}
}
