/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.trace.handler;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;


public class TraceFormatter extends Formatter {
	
	@Override
	public String format(LogRecord record) {
		return record.getMessage();
	}
}
