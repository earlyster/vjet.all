/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.dap.event;

import org.eclipse.vjet.dsf.active.dom.html.AHtmlHelper;
import org.eclipse.vjet.dsf.jsnative.events.EventTarget;
import org.eclipse.vjet.dsf.jsnative.events.UIEvent;
import org.mozilla.mod.javascript.IJsJavaConverter;
import org.mozilla.mod.javascript.Scriptable;

public class UIEventConverter implements IJsJavaConverter {

	public UIEvent convert(Scriptable s) {
		AUIEvent event = new AUIEvent();

		EventTarget srcElement = (EventTarget) AHtmlHelper.getAttributeValue(
				"srcElement", s);
		if (srcElement != null) {
			event.setSrcElement(srcElement);
		}
		EventTarget target = (EventTarget) AHtmlHelper.getAttributeValue(
				"target", s);
		if (target != null) {
			event.setTarget(target);
		}
		event.setTimestamp(AHtmlHelper.getLongAttributeValue("timeStamp", s));
		event.setType(AHtmlHelper.getStringAttributeValue("type", s));
		event.setCancelable(AHtmlHelper.getBooleanAttributeValue("cancelable",
				s));
		event
				.setCanBubble(AHtmlHelper.getBooleanAttributeValue("canBubble",
						s));
		event.setDetail(AHtmlHelper.getIntAttributeValue("detail", s));
		return event;
	}

}
