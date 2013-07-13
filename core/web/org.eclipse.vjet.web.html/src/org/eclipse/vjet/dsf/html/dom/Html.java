/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.html.dom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;

import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.dom.DElementConstructor;
import org.eclipse.vjet.dsf.dom.DomUtil;
import org.eclipse.vjet.dsf.dom.support.DNamespace;

public class Html extends DElementConstructor {			
	/**
	 * Holds names and classes of HTML element types. When an element with a
	 * particular tag name is created, the matching {@link java.lang.Class}
	 * is used to create the element object. For example, &lt;A&gt; matches
	 * HTMLAnchorElementImpl. This static table is shared across all
	 * HTML documents.
	 *
	 * @see #createElement
	 */
	private static HashMap<String,Constructor<?> > s_elementTypesHTML;

	/**
	 * Signature used to locate constructor of HTML element classes. This
	 * static array is shared across all HTML documents.
	 *
	 * @see #createElement
	 */
	private static final Class<?>[] s_elemClassSigHTML = new Class[] {};
	private static final Object[] EMPTY_ARG = new Object[] {};

	static {
		populateElementTypes();
	}
	
	//
	// API
	//
	@Override
	public DElement domCreateDynamicElement(
		final String namespaceUri, final String possibleQualifiedName)
	{
		final DNamespace ns = DomUtil.getNamespace(namespaceUri, possibleQualifiedName);
		final String localName = DomUtil.getUnqualifedName(possibleQualifiedName) ;
		return domCreateDynamicElement(ns, localName) ;
	}
	/**
	 * Answers the correct HTML Element for the tagName.  The tagName is put
	 * in connonical form internally so case does not matter.  If no tag name
	 * match, a DElement instance with the tag name is returned.
	 * @return Specific DXyz type for the tag.  If not an HTML tag, then returns
	 * a DElement of that tag name
	 * @param inTagName Will throw IllegalStateException if null or empty String
	 */
	@Override
	public DElement domCreateDynamicElement(final String unqualifiedName) {
		// First, make sure tag name is all upper case, next get the associated
		// element class. If no class is found, generate a generic HTML element.
		// Do so also if an unexpected exception occurs.
		final String tagName = unqualifiedName.toLowerCase(Locale.ENGLISH);
		final Constructor<?> cnst = s_elementTypesHTML.get(tagName);
		if (cnst != null) {
			// Get the constructor for the element. The signature specifies an
			// owner document and a tag name. Use the constructor to instantiate
			// a new object and return it.
			try {
				return (DElement) cnst.newInstance(EMPTY_ARG);
			} 
			catch (Exception except) {
				final Throwable thrw;

				if (except instanceof InvocationTargetException) {
					thrw = ((InvocationTargetException)except).getTargetException();
				} 
				else {
					thrw = except;
				}

				throw new IllegalStateException(
					"HTM15 Tag '"
					+ tagName
					+ "' associated with an Element class that failed to construct.\n"
					+ tagName
					+ " with following message: "
					+ thrw.getMessage(),
					except);
			}
		}
		return new DElement(tagName);
	}
	
	@Override
	public DElement domCreateDynamicElement(
		final DNamespace namespace, final String nonQualifiedTagName)
	{
		DElement elem = domCreateDynamicElement(nonQualifiedTagName) ;
		elem.setDsfNamespace(namespace) ;
		return elem ;
	}
	
	@Override
	public DElement domCreateDynamicElement(
		final DDocument owner, final String inTagName)
	{
		DElement e = domCreateDynamicElement(inTagName);
		setOwnerDocument(owner, e);
		return e;
	}
	
	@Override
	public DElement domCreateDynamicElement(
		final DDocument owner, final DNamespace namespace, final String inTagName)
	{
		DElement e = domCreateDynamicElement(namespace, inTagName);
		setOwnerDocument(owner, e);
		return e;
	}

	//
	// Private
	//
	/**
	 * Called by the constructor to populate the element types list (see {@link
	 * #_elementTypesHTML}). Will be called multiple times but populate the list
	 * only the first time. Replacement for static constructor.
	 */
	private synchronized static void populateElementTypes() {

		if (s_elementTypesHTML != null) {
			return;
		}
		s_elementTypesHTML = new HashMap<String,Constructor<?> >(101);
		for (final HtmlTypeEnum htmlType:HtmlTypeEnum.valueIterable()){
			populateElementType(htmlType);
		}
	}

	private static void populateElementType(final HtmlTypeEnum htmlType) {
		final String tagName = htmlType.getName();
		final Class<?> elemClz = htmlType.getTypeClass();
		try {
			s_elementTypesHTML.put(
				tagName,
				elemClz.getConstructor(s_elemClassSigHTML));
		}
		catch (Exception except) {
			throw new RuntimeException(
				"HTM019 OpenXML Error: Could not find proper constructor for "
					+ elemClz.getName()
					+ " for "
					+ tagName,
				except);
		}
	}
}
