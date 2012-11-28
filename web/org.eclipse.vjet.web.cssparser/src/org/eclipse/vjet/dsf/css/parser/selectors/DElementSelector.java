/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.parser.selectors;

import java.io.Serializable;

import org.eclipse.vjet.dsf.css.sac.ISelector;
import org.w3c.css.sac.ElementSelector;

public class DElementSelector implements ElementSelector, Serializable {

	private String m_localName;

	public DElementSelector(String localName) {
		m_localName = localName;
	}

	public short getSelectorType() {
		return ISelector.SAC_ELEMENT_NODE_SELECTOR;
	}

	public String getNamespaceURI() {
		return null;
	}

	public String getLocalName() {
		return m_localName;
	}

	public String toString() {
		return (getLocalName() != null) ? getLocalName() : "*";
	}
	
	//added API
	public void setLocalName(String localName) {
		m_localName = localName;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
