/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.eclipse.vjet.dsf.jsnative.events.EventTarget;
import org.mozilla.mod.javascript.IWillBeScriptable;
/*
 * interface TextTrackCue {
  readonly attribute TextTrack track;
  readonly attribute DOMString id;

  readonly attribute double startTime;
  readonly attribute double endTime;
  readonly attribute boolean pauseOnExit;


  DOMString getCueAsSource();
  DocumentFragment getCueAsHTML();

           attribute Function onenter;
           attribute Function onexit;
};
TextTrackCue implements EventTarget;
 */
@Alias("TextTrackCue")
@JsMetatype
public interface TextTrackCue extends IWillBeScriptable,EventTarget{

	@Property TextTrack getTrack();
	@Property String getId();
	@Property double getStartTime();
	@Property double getEndTime();
	@Property boolean getPauseOnExit();
	
	@Function String getCueAsSource();
	@Function DocumentFragment getCueAsHTML();
	
	@Property Object getOnenter();
	@Property void setOnender(Object functionRef);
	@Property Object getOnexit();
	@Property void setOnexit(Object functionRef);
	
	
	
	
}
