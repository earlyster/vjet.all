/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.event;

import org.eclipse.vjet.dsf.jsnative.events.EventTarget;


public interface IDomEventPublisher {
	
	boolean publish(String evtType, EventTarget src);
//	boolean publish(String evtType, EventTarget src, String value);

}
