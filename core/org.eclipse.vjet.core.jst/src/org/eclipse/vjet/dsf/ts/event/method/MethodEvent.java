/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.ts.event.method;

import org.eclipse.vjet.dsf.ts.event.ISourceEvent;
import org.eclipse.vjet.dsf.ts.event.ISourceEventListener;
import org.eclipse.vjet.dsf.ts.event.dispatch.IEventListenerHandle;
import org.eclipse.vjet.dsf.ts.method.MethodName;
import org.eclipse.vjet.dsf.common.Z;

public abstract class MethodEvent implements ISourceEvent<IEventListenerHandle> {
	
	private MethodName m_mtdName;
	private boolean m_isStatic;
	
	//
	// Constructors
	//
	MethodEvent(MethodName mtdName, boolean isStatic){
		assert mtdName != null : "mtdName cannot be null";
		m_mtdName = mtdName;
		m_isStatic = isStatic;
	}

	//
	// Satisfy IJstEvent
	//
	public boolean isAppropriateListener(ISourceEventListener listener){
		return listener instanceof IMethodEventListener;
	}

	//
	// API
	//
	public MethodName getMethodName(){
		return m_mtdName;
	}
	
	public boolean isMethodStatic(){
		return m_isStatic;
	}
	
	@Override
	public String toString(){
		Z z = new Z();
		z.format("eventType", getClass().getSimpleName());
		z.format("m_mtdName", m_mtdName);
		return z.toString();
	}
}
