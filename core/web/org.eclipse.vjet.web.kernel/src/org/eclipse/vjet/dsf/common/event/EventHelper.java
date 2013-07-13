/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.event;

import org.eclipse.vjet.dsf.common.phase.PhaseId;

/**
 * This is a trusted Framework class and should not be used by
 * non-framework developers.
 */
public abstract class EventHelper {
//	@SuppressWarnings("unchecked")
//	protected static boolean isAppropriateListener(
//		final DsfEvent event, final IDsfEventListener listener)
//	{
//		return event.isAppropriateListener(listener);
//	}
//	
//	@SuppressWarnings("unchecked")
//	protected static void processListener(
//		final DsfEvent event, final IDsfEventListener listener)
//			throws AbortDsfEventProcessingException
//	{
//		event.processListener(listener);
//	}
	
	protected static void setOriginatingPhaseId(
		final DsfPhaseEvent<? extends IDsfEventListener> event, final PhaseId phaseId)
	{
		event.setOriginatingPhaseId(phaseId);
	}
}