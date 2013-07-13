/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests.data.multipass;

import java.util.Date;

import org.eclipse.vjet.dsf.dap.rt.DapHandlerAdapter;
import org.eclipse.vjet.dsf.javatojs.tests.data.B;

public class Base extends DapHandlerAdapter {
	public Date m_date;
	public String toString(){
		return m_date.toString();
	}
	
	protected B createB(){
		return new B();
	}
}
