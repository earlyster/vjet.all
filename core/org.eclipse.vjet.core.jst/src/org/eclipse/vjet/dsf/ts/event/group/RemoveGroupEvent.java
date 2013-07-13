/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.ts.event.group;

import org.eclipse.vjet.dsf.ts.event.ISourceEvent;
import org.eclipse.vjet.dsf.ts.event.ISourceEventCallback;
import org.eclipse.vjet.dsf.ts.event.ISourceEventListener;
import org.eclipse.vjet.dsf.ts.event.dispatch.IEventListenerHandle;

/**
 * Remove group event
 * 
 * 
 */
public final class RemoveGroupEvent extends GroupEvent {

	//
	// Constructors
	//
	/**
	 * Constructor
	 * @param groupName String
	 * @param groupPath String
	 */
	public RemoveGroupEvent(String groupName, String groupPath){
		super(groupName, groupPath);
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
		((IGroupEventListener)listener).onGroupRemoved(this);
	}
	
	/**
	 * @see ISourceEvent#dispatch(ISourceEventListener,IEventListenerHandle,ISourceEventCallback)
	 */
	public void dispatch(ISourceEventListener listener, IEventListenerHandle handle, ISourceEventCallback callback){
		if (listener == null){
			return;
		}
		((IGroupEventListener)listener).onGroupRemoved(this);
	}
	
	public boolean shouldLock() { return true; }
}
