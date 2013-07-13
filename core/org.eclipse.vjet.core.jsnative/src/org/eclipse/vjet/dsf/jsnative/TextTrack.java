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

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.eclipse.vjet.dsf.jsnative.events.EventTarget;

/*
 *interface TextTrack {
  readonly attribute DOMString kind;
  readonly attribute DOMString label;
  readonly attribute DOMString language;

  const unsigned short NONE = 0;
  const unsigned short LOADING = 1;
  const unsigned short LOADED = 2;
  const unsigned short ERROR = 3;
  readonly attribute unsigned short readyState;
           attribute Function onload;
           attribute Function onerror;

  const unsigned short OFF = 0;
  const unsigned short HIDDEN = 1;
  const unsigned short SHOWING = 2;
           attribute unsigned short mode;

  readonly attribute TextTrackCueList cues;
  readonly attribute TextTrackCueList activeCues;

           attribute Function oncuechange;
};
TextTrack implements EventTarget; 
 * @author jearly
 *
 */
public interface TextTrack extends EventTarget {

	@Property String getKind();
	@Property String getLabel();
	@Property String getLanguage();
	
	@Property short getShort();
	@Property Object getOnload();
	@Property void setOnload(Object functionRef);
	
	@Property Object getOnerror();
	@Property void setOnerror(Object functionRef);

	/** "NONE" */
	@AJavaOnly
	@ARename(name = "'NONE'")
	short NONE = 0;
	
	/** "LOADING" */
	@AJavaOnly
	@ARename(name = "'LOADING'")
	short LOADING = 1;
	
	/** "LOADED" */
	@AJavaOnly
	@ARename(name = "'LOADED'")
	short LOADED = 2;
	
	/** "ERROR" */
	@AJavaOnly
	@ARename(name = "'ERROR'")
	short ERROR = 3;

}
