/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.dap.rt;

import org.eclipse.vjet.dsf.active.client.AWindow;
import org.eclipse.vjet.dsf.dap.event.DapEvent;
import org.eclipse.vjet.dsf.html.events.EventType;

/**
 * a helper class for VjoRunner
 */
public class BodyOnloadAdapter {
	public static void fireOnload(AWindow window) {
		DapCtx.ctx().setWindow(window);
		DapEventDispatcher dispatcher = DapEventDispatcher.getInstance();
		dispatcher.dispatchEvent(new DapEvent(window.getDocument().getBody(), EventType.LOAD));
	}
}
