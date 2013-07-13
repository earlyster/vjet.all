/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.ts.event.method;

import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.ts.event.ISourceEvent;
import org.eclipse.vjet.dsf.ts.event.ISourceEventCallback;
import org.eclipse.vjet.dsf.ts.event.ISourceEventListener;
import org.eclipse.vjet.dsf.ts.event.dispatch.IEventListenerHandle;
import org.eclipse.vjet.dsf.ts.method.MethodName;

public final class ModifyMethodEvent extends MethodEvent {
	
	private IJstMethod m_mtd;
	
	//
	// Constructors
	//
	public ModifyMethodEvent(MethodName mtdName, IJstMethod mtd){
		super(mtdName, mtd.isStatic());
		m_mtd = mtd;
	}

	//
	// Satisfy IJstEvent
	//
	/**
	 * @see ISourceEvent#dispatch(ISourceEventListener)
	 */
	public void dispatch(ISourceEventListener listener){
		if (listener == null){
			return;
		}
		((IMethodEventListener)listener).onMethodModified(this);
	}
	
	/**
	 * @see ISourceEvent#dispatch(ISourceEventListener,IEventListenerHandle,ISourceEventCallback)
	 */
	public void dispatch(ISourceEventListener listener, IEventListenerHandle handle, ISourceEventCallback callback){
		if (listener == null){
			return;
		}
		((IMethodEventListener)listener).onMethodModified(this);
	}
	
	//
	// API
	//
	public IJstMethod getMethod(){
		return m_mtd;
	}
	
	public boolean shouldLock() { return true; }
}
