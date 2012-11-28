/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.html.js;

import org.eclipse.vjet.dsf.html.dom.DHtmlCollection;
import org.eclipse.vjet.dsf.html.dom.DLink;
import org.mozilla.mod.javascript.Context;
import org.mozilla.mod.javascript.Scriptable;

public class JSLinkArray implements Scriptable {

	private JSWindow window = null;
//	private Context cx = null;
	private Scriptable scope = null;

	private JSLinkArray() {
	}

	/** Creates new JSLinksArray */
	public JSLinkArray(JSWindow window) {
		JSDebug.println("JSLinksArray:JSLinksArray()...");
		this.window = window;
//		this.cx = window.getContext();
		this.scope = window.getScope();
	}

	public String getClassName() {
		JSDebug.println("JSLinksArray:getClassName(...)");
		return "JSLinksArray";
	}

	/**
	 * Defines the "length" property by returning true if name is equal to "length".
	 * Defines no other properties, i.e., returns false for all other names.
	 *
	 * @param name the name of the property
	 * @param start the object where lookup began
	 */
	public boolean has(String name, Scriptable start) {
		JSDebug.println("JSLinksArray:has()... " + name);
		if (name.equals("length")) {
			return true;
		}

		DHtmlCollection links = window.getHTMLDocument().getLinks();
		if (links == null) {
			return false;
		}

		DLink link = null;
		for (int i = 0; i < links.getLength(); i++) {
			link = (DLink) links.item(i);
			if (name.equals(link.getAttribute("name"))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Defines all numeric properties by returning true.
	 *
	 * @param index the index of the property
	 * @param start the object where lookup began
	 */
	public boolean has(int index, Scriptable start) {
		JSDebug.println("JSLinksArray:has()... " + index);
		DHtmlCollection links = window.getHTMLDocument().getLinks();
		if (links == null) {
			return false;
		}

		if (index >= 0 && index < links.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the named property.
	 * Handles the "length" property and returns NOT_FOUND for all other names.
	 *
	 * @param name the property name
	 * @param start the object where the lookup began
	 */
	public Object get(String name, Scriptable start) {
		JSDebug.println("JSLinksArray:get()... " + name);
		DHtmlCollection links = window.getHTMLDocument().getLinks();
		if (name.equals("length")) {
			if (links != null) {
				return new Integer(links.getLength());
			} else {
				return new Integer(0);
			}
		}

		if (links == null) {
			return (Scriptable.NOT_FOUND);
		}

		for (int i = 0; i < links.getLength(); i++) {
			final DLink link = (DLink) links.item(i);
			if (name.equals(link.getAttribute("name"))) {
				return Context.toObject(link, scope);
			}
		}
		return Scriptable.NOT_FOUND;
	}

	/**
	 * Get the indexed property.
	 * <p>
	 * Look up the element in the DOM tree, and return an DHtmlLinkElement of it
	 * if it exists. If it doesn't exist, return NOT_FOUND.<p>
	 *
	 * @param index the index of the integral property
	 * @param start the object where the lookup began
	 */
	public Object get(int index, Scriptable start) {
		JSDebug.println("JSLinksArray:get()... " + index);
		DHtmlCollection links = window.getHTMLDocument().getLinks();
		if (links == null) {
			return Scriptable.NOT_FOUND;
		}

		if (index < 0 || index >= links.getLength()) {
			return Scriptable.NOT_FOUND;
		}
		return Context.toObject(links.item(index), scope);
	}

	/**
	 * Set a named property.
	 *
	 * We do nothing here, so all properties are effectively read-only.
	 */
	public void put(String name, Scriptable start, Object value) {
	}

	/**
	 * Set an indexed property.
	 *
	 * We do nothing here, so all properties are effectively read-only.
	 */
	public void put(int index, Scriptable start, Object value) {
	}

	/**
	 * Remove a named property.
	 *
	 * This method shouldn't even be called since we define all properties
	 * as PERMANENT.
	 */
	public void delete(String id) {
	}

	/**
	 * Remove an indexed property.
	 *
	 * This method shouldn't even be called since we define all properties
	 * as PERMANENT.
	 */
	public void delete(int index) {
	}

	/**
	 * Get prototype.
	 */
	public Scriptable getPrototype() {
		JSDebug.println("JSLinksArray:getPrototype()...");
		return prototype;
	}

	/**
	 * Set prototype.
	 */
	public void setPrototype(Scriptable prototype) {
		JSDebug.println("JSLinksArray:setPrototype()...");
		this.prototype = prototype;
	}

	/**
	 * Get parent.
	 */
	public Scriptable getParentScope() {
		JSDebug.println("JSLinksArray:getParentScope()...");
		return parent;
	}

	/**
	 * Set parent.
	 */
	public void setParentScope(Scriptable parent) {
		JSDebug.println("JSLinksArray:setPrototype()...");
		this.parent = parent;
	}

	/**
	 * Get properties.
	 *
	 * We return an empty array since we define all properties to be DONTENUM.
	 */
	public Object[] getIds() {
		JSDebug.println("JSLinksArray:getIds()...");
		return new Object[0];
	}

	/**
	 * Default value.
	 *
	 * Use the convenience method from Context that takes care of calling
	 * toString, etc.
	 */
	public Object getDefaultValue(Class typeHint) {
		JSDebug.println("JSLinksArray:getDefaultValue()...");
		return "[object JSLinksArray]";
	}

	/**
	 * instanceof operator.
	 *
	 * We mimick the normal JavaScript instanceof semantics, returning
	 * true if <code>this</code> appears in <code>value</code>'s prototype
	 * chain.
	 */
	public boolean hasInstance(Scriptable value) {
		JSDebug.println("JSLinksArray:hasInstance()...");
		Scriptable proto = value.getPrototype();
		while (proto != null) {
			if (proto.equals(this)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Some private data for this class.
	 */
	private Scriptable prototype = null, parent = null;
}
