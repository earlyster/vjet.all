/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.meta;


public class ArgType {
	public static enum WildCardType {EXTENDS,SUPER,NONE};
	private WildCardType m_wildcard;
	private static final String QMARK = "?";
	private JsTypingMeta m_type;
	private JsTypingMeta m_family;
	public ArgType() {
		m_wildcard = WildCardType.NONE;
		m_family = null;
	}
	public ArgType(JsTypingMeta type) {
		this();
		m_type = type;
	}
	
	public ArgType(WildCardType wildcardType, JsTypingMeta family) {
		m_wildcard = wildcardType;
		m_family = family;
	}
	public ArgType(JsType type, WildCardType wildcardType, JsType family) {
		this(wildcardType,family);
		m_type = type;
	}
	public String getName() {
		return (m_type!=null)?m_type.getType() : QMARK;
	}
	public JsTypingMeta getType() {
		return m_type;
	}
	public JsTypingMeta getFamily() {
		return m_family;
	}
	public WildCardType getWildCardType() {
		return m_wildcard;
	}
}