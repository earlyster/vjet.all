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
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.mozilla.mod.javascript.IWillBeScriptable;
/*
 *   readonly attribute TimeRanges buffered;
  readonly attribute TimeRanges seekable;
  readonly attribute double duration;
           attribute double currentTime;

  readonly attribute boolean paused;
  readonly attribute TimeRanges played;
  void play();
  void pause();

           attribute double defaultPlaybackRate;
           attribute double playbackRate;

           attribute double volume;
           attribute boolean muted;

           attribute Function onemptied;
           attribute Function onloadedmetadata;
           attribute Function onloadeddata;
           attribute Function oncanplay;
           attribute Function oncanplaythrough;
           attribute Function onplaying;
           attribute Function onwaiting;

           attribute Function ondurationchange;
           attribute Function ontimeupdate;
           attribute Function onplay;
           attribute Function onpause;
           attribute Function onratechange;
           attribute Function onvolumechange;

 */
@Alias("MediaController")
@JsMetatype
public interface MediaController extends IWillBeScriptable {

	@Property double getDefaultPlaybackRate();
	@Property void setDefaultPlaybackRate(double rate);
	
	@Property double getPlaybackRate();
	@Property void setPlaybackRate(double rate);
	
	@Property double getVolume();
	@Property void setVolume(double volume);
	
	@Property boolean getMuted();
	@Property void setMuted(boolean muted);
	
	
	void setOnScroll(Object functionRef);
	
	@Property void onEmptied(Object functionRef);           
	@Property void onLoadedmetadata(Object functionRef);    
	@Property void onLoadeddata(Object functionRef);        
	@Property void onCanplay(Object functionRef);           
	@Property void onCanplaythrough(Object functionRef);    
	@Property void onPlaying(Object functionRef);           
	@Property void onWaiting(Object functionRef);           
	                     
	@Property void onDurationchange(Object functionRef);    
	@Property void onTimeupdate(Object functionRef);        
	@Property void onPlay(Object functionRef);              
	@Property void onPause(Object functionRef);             
	@Property void onRatechange(Object functionRef);        
	@Property void onVolumechange(Object functionRef);      
	                              
	
}

