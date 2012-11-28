/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.dom.html;

import org.w3c.dom.DOMException;

import org.eclipse.vjet.dsf.dom.DCharacterData;
import org.eclipse.vjet.dsf.jsnative.CharacterData;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;

class ACharacterData extends ANode implements CharacterData  {

	private static final long serialVersionUID = 1L;
	
	protected ACharacterData(final AHtmlDocument doc, final DCharacterData data) {
		super(doc, data);
		populateScriptable(ACharacterData.class, doc == null ? BrowserType.IE_6P : doc.getBrowserType());
	}
	
	protected ACharacterData(final ADocument doc, final DCharacterData data) {
		super(doc, data);
		populateScriptable(ACharacterData.class, BrowserType.NONE);
	}
	
	@Override
	public AHtmlDocument getOwnerDocument() {
		return (AHtmlDocument) super.getOwnerDocument();
	}

	public void appendData(String data) throws DOMException {
		getDCharacterData().appendData(data);
	}

	public void deleteData(int offset, int count) throws DOMException {
		getDCharacterData().deleteData(offset, count);
	}

	public String getData() throws DOMException {
		return getDCharacterData().getData();
	}

	public int getLength() {
		return getDCharacterData().getLength();
	}

	public void insertData(int offset, String middle) throws DOMException {
		getDCharacterData().insertData(offset, middle);
	}

	public void replaceData(int offset, int count, String middle)
			throws DOMException {
		getDCharacterData().replaceData(offset, count, middle);
	}

	public void setData(String data) throws DOMException {
		getDCharacterData().setData(data);
	}

	public String substringData(int offset, int count) throws DOMException {
		return getDCharacterData().substringData(offset, count);
	}
	
	private DCharacterData getDCharacterData() {
		return (DCharacterData) getDNode();
	}

}
