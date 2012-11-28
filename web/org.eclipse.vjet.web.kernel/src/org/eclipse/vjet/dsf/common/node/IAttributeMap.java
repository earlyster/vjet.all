/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.common.node;

import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.dom.DAttr;

public interface IAttributeMap extends Map<String, Object>, Iterable<DAttr> {
	/** value via ValueBinding */
	IValueBinding getValueBinding(String propertyName);
	/**
	 * returns existing binding for the property, a runtime exception can be 
	 * thrown if the property is an non-bindable intrinsic property
	 */
	IValueBinding setValueBinding(String propertyName, IValueBinding binding);
	
	/** Answer the DAttr for this key */
	DAttr getAttr(String key) ;
	
	Set<Map.Entry<String, DAttr>> attrEntrySet();
}
