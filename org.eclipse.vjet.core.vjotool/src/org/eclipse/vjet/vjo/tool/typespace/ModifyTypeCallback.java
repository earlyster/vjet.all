/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.tool.typespace;


import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.ts.event.EventListenerStatus;
import org.eclipse.vjet.dsf.ts.event.ISourceEventCallback;

/**
 * Source event call back on modify event.
 * 
 * 
 *
 */
public class ModifyTypeCallback implements ISourceEventCallback<IJstType> {

	public void onComplete(EventListenerStatus<IJstType> status) {
		if (status.getCode() != EventListenerStatus.Code.Successful) {
//			String errors = TypeSpaceLoadEvent.getErrorString(status);
//			DLTKCore.error(errors);
		}
	}
	
	public void onProgress(float percent) {
	}

}
