/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.trace;

import org.w3c.dom.Node;

import org.eclipse.vjet.dsf.DSFRootAnchor;
import org.eclipse.vjet.dsf.dom.DAttr;
import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.html.dom.DA;
import org.eclipse.vjet.dsf.html.dom.DSpan;
import org.eclipse.vjet.dsf.html.dom.EHtmlAttr;
import org.eclipse.vjet.dsf.html.dom.HtmlTypeEnum;
import org.eclipse.vjet.dsf.common.xml.IXmlStreamWriter;

public class LabelingComponentNodeInstrumenter implements IInstrumentDElement {

	// Put a label and border on all components to produce a documentation page
	// showing what components are present.
	public void startElement(final DElement node, final IXmlStreamWriter writer) {
		if (!node.getClass().getName().startsWith(
				DSFRootAnchor.class.getPackage().getName())) {
			String classAttr = node.getAttribute("class");
			node.setAttribute("class", classAttr + " spylabel");
			DSpan span = new DSpan();
			span.setHtmlTitle(node.getClass().getSimpleName());
			span.setHtmlClassName("spytext");
			DA patternEngineLink = new DA(
				node.getClass().getSimpleName(), 
				"http://rmsweb/v4/patternengine/sitewide/component/"+node.getClass().getSimpleName()+"/");
			patternEngineLink.setHtmlTarget("_new");
			span.add(patternEngineLink);
			span.setAttribute("style", "filter:alpha(opacity=70);-moz-opacity:0.7");
//			span.setHtmlStyleAsString("filter:alpha(opacity=70);-moz-opacity:0.7"); // Move to Css once SAC parser allows these extensions
			node.add(span);
		}
	}
	
	public void setAttributeValue(DElement node, DAttr attr, String value) {
		// no-op
	}

	public void endElement(final DElement node, final IXmlStreamWriter writer) {
	}

	// Add a span tag to hold the self render object. Tag will bear classes
	// to allow a hover label over the component and it links to the pattern engine.
	public void startSelfRender(final DElement node, final IXmlStreamWriter writer) {
		if (!node.getClass().getName().startsWith(
				DSFRootAnchor.class.getPackage().getName())) {
			if (node.getClass().getName().equals("org.eclipse.vjet.dsf.resource.content.runtime.DContent") ||
					node.getClass().getName().equals("com.ebay.darwin.component.core.page.BasePage")	) {
				return;
			}
			
			if (node.getNodeName().equalsIgnoreCase("BasePage")) {
				return;
			}	
			
			writer.writeStartElement(HtmlTypeEnum.SPAN.getName());
			writer.writeAttribute(EHtmlAttr._class.getAttributeName(), "spylabel");
			writer.writeStartElement(HtmlTypeEnum.SPAN.getName());
			writer.writeAttribute(EHtmlAttr.title.getAttributeName(),node.getClass().getSimpleName());
			writer.writeAttribute(EHtmlAttr._class.getAttributeName(), "spytext"); 
			writer.writeAttribute(EHtmlAttr.style.getAttributeName(), "filter:alpha(opacity=70);-moz-opacity:0.7;");// Move to Css once SAC parser allows these extensions
			writer.writeStartElement(HtmlTypeEnum.A.getName());
			writer.writeAttribute(EHtmlAttr.href.getAttributeName(),  "http://rmsweb/v4/patternengine/sitewide/component/"+node.getClass().getSimpleName()+"/");
			writer.writeAttribute(EHtmlAttr.target.getAttributeName(),"_new");
			writer.writeCharacters(node.getClass().getSimpleName());
			writer.writeEndElement();
			writer.writeEndElement();
		}
	}

	public void endSelfRender(final DElement node, final IXmlStreamWriter writer) {
		if (!node.getClass().getName().startsWith(
				DSFRootAnchor.class.getPackage().getName())) {
			if (node.getClass().getName().equals("org.eclipse.vjet.dsf.resource.content.runtime.DContent") ||
					node.getClass().getName().equals("com.ebay.darwin.component.core.page.BasePage")	) {
				return;
			}
			
			if (node.getNodeName().equalsIgnoreCase("BasePage")) {
				return;
			}	
			writer.writeEndElement();
		}
	}

	public void appendElement(final Node parent, final Node node) {
		// empty on purpose
	}

}