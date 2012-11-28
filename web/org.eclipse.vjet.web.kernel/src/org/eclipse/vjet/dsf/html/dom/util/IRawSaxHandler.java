/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.html.dom.util;

import org.eclipse.vjet.dsf.dom.DCDATASection;
import org.eclipse.vjet.dsf.dom.DComment;
import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.dom.DDocumentType;
import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.dom.DEntity;
import org.eclipse.vjet.dsf.dom.DEntityReference;
import org.eclipse.vjet.dsf.dom.DNotation;
import org.eclipse.vjet.dsf.dom.DProcessingInstruction;
import org.eclipse.vjet.dsf.dom.DRawString;
import org.eclipse.vjet.dsf.dom.DText;

/**
 * The standard handler inteferce of the SAX parser. It provides a set of
 * methods to emit DElement and other types.For Examples: <code>DDocuemnt</code>,
 * <code>DComment</code> and <code>DText</code>. Since all DSF HTML tags derive
 * from <code>DDocument</code> and DElement</code>, we can emit for any of the
 * DSF HTML types. It is handy for custom emission and when you want to control
 * the event sequences.
 * 
 */
//Note, too many classes are implements this interface.
//not worth to re-package it.

public interface IRawSaxHandler {

	void startElement(final DElement node);
	void endElement(final DElement node);

	void startDocument(final DDocument document);
	void endDocument(final DDocument document);

	void handleComment(final DComment comment);
	void handleCData(final DCDATASection cdata);
	void handleText(final DText text);
	void handleRawString(final DRawString rawString);
	
	void handleDocType(final DDocumentType doctype);
	void handleNotation(final DNotation notation) ;
	void handleEntity(final DEntity entity);
	void handleProcessingInstruction(final DProcessingInstruction pi) ;
	
	void handleEntityReference(final DEntityReference doctype);
}
