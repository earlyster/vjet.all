/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.dap.cnr;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.EventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.TaskCapture;
import org.eclipse.vjet.dsf.dap.rt.DapBrowserEngine;
import org.eclipse.vjet.dsf.liveconnect.IDLCDispatcher;
import org.eclipse.vjet.dsf.liveconnect.client.DLCEvent;
import org.eclipse.vjet.dsf.liveconnect.client.IDLCClient;
import org.eclipse.vjet.dsf.liveconnect.client.simple.SimpleDLCEventTypes;

public class DapReplay implements IDapReplay {
	
	private final DapBrowserEngine m_browserEngine;
	private final IDLCDispatcher m_dlcDispatcher;
	
	//
	// Constructor
	//
	public DapReplay(
			final DapBrowserEngine browserEmulator,
			final IDLCClient dlcClient) {
		
		m_browserEngine = browserEmulator;
		m_dlcDispatcher = browserEmulator.getDispatcher();
	}

	//
	// Satisfy IDapReplay
	//
	/**
	 * @see IDapReplay#play(DapCaptureData, int)
	 */
	public void play(final DapCaptureData captureData, ReplaySpeed speed) {
		long previousTime = System.currentTimeMillis();
		for (IEventCapture capture: captureData.getAllEventCaptures()){
			if(capture instanceof EventCapture){
				EventCapture ec = (EventCapture)capture;
				long currentEventTime = System.currentTimeMillis();
				long timeDiff = currentEventTime - previousTime;
				long expectedDiff = ec.getEventTimeInterval() * speed.getFactor();
				expectedDiff = expectedDiff > speed.getMaxWait() ? speed.getMaxWait() : expectedDiff;
				if (expectedDiff > timeDiff) {
					try {
						Thread.sleep(expectedDiff - timeDiff);
					} catch (InterruptedException e) {
						// KEEPME
					}
				}
				if (ec.getEvent() == null){
					continue;
				}
				synchForRealBrowser(ec.getEvent());
				m_browserEngine.onReceive(ec.getEvent());
				previousTime = System.currentTimeMillis();
			} else if (capture instanceof TaskCapture) {
				TaskCapture tc = (TaskCapture)capture;
				m_browserEngine.executeTask(tc.getInfo());
			} else {
				continue;
			}
		}
	}
	
	//
	// Private
	//
	private void synchForRealBrowser(final DLCEvent event) {
		if (m_dlcDispatcher == null) {
			return;
		}
		String eventType = event.getType();
		String msg = event.getPayload();
		int idx = msg.indexOf(":[");
		if(idx>0){
			msg = msg.substring(0, idx);
		}
		m_dlcDispatcher.send(msg);
		if (SimpleDLCEventTypes.CHANGE.equals(eventType)) {
			m_dlcDispatcher.send(msg);
		}
		else if (SimpleDLCEventTypes.RADIO_CHANGE.equals(eventType)) {
			m_dlcDispatcher.send(msg);
		}
		else if (SimpleDLCEventTypes.KEYUP.equals(eventType)) {
			m_dlcDispatcher.send(msg);
		}
	}
}
