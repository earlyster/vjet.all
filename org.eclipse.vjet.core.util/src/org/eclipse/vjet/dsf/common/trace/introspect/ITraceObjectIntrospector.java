/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.trace.introspect;

import org.eclipse.vjet.dsf.common.xml.IXmlStreamWriter;



/**
 * Interface to introspect object state for tracing.
 */
public interface ITraceObjectIntrospector {
	/**
	 * Write object state with given writer.
	 * @param obj Object
	 * @param writer IXmlStreamWriter
	 */
	void writeState(Object obj, IXmlStreamWriter writer);
}
