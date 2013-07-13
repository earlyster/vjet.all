/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import java.util.Date;

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.OverLoadFunc;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/*
 *  // error state
 readonly attribute MediaError error;

 // network state
 attribute DOMString src;
 readonly attribute DOMString currentSrc;
 const unsigned short NETWORK_EMPTY = 0;
 const unsigned short NETWORK_IDLE = 1;
 const unsigned short NETWORK_LOADING = 2;
 const unsigned short NETWORK_NO_SOURCE = 3;
 readonly attribute unsigned short networkState;
 attribute DOMString preload;
 readonly attribute TimeRanges buffered;
 void load();
 DOMString canPlayType(in DOMString type);

 // ready state
 const unsigned short HAVE_NOTHING = 0;
 const unsigned short HAVE_METADATA = 1;
 const unsigned short HAVE_CURRENT_DATA = 2;
 const unsigned short HAVE_FUTURE_DATA = 3;
 const unsigned short HAVE_ENOUGH_DATA = 4;
 readonly attribute unsigned short readyState;
 readonly attribute boolean seeking;

 // playback state
 attribute double currentTime;
 readonly attribute double initialTime;
 readonly attribute double duration;
 readonly attribute Date startOffsetTime;
 readonly attribute boolean paused;
 attribute double defaultPlaybackRate;
 attribute double playbackRate;
 readonly attribute TimeRanges played;
 readonly attribute TimeRanges seekable;
 readonly attribute boolean ended;
 attribute boolean autoplay;
 attribute boolean loop;
 void play();
 void pause();

 // media controller
 attribute DOMString mediaGroup;
 attribute MediaController controller;

 // controls
 attribute boolean controls;
 attribute double volume;
 attribute boolean muted;
 attribute boolean defaultMuted;

 // tracks
 readonly attribute MultipleTrackList audioTracks;
 readonly attribute ExclusiveTrackList videoTracks;
 readonly attribute TextTrack[] textTracks;
 MutableTextTrack addTextTrack(in DOMString kind, in optional DOMString label, in optional DOMString language);

 */

@Alias("HTMLMediaElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlMedia extends HtmlElement {

	@Property
	MediaError getError();

	@Property
	String getSrc();

	@Property
	void setSrc(String src);

	@Property
	String getCurrentSrc();

	/** "NETWORK_EMPTY" */
	@AJavaOnly
	@ARename(name = "'NETWORK_EMPTY'")
	short NETWORK_EMPTY = 0;

	/** "NETWORK_IDLE" */
	@AJavaOnly
	@ARename(name = "'NETWORK_IDLE'")
	short NETWORK_IDLE = 1;

	/** "NETWORK_LOADING" */
	@AJavaOnly
	@ARename(name = "'NETWORK_LOADING'")
	short NETWORK_LOADING = 2;

	/** "NETWORK_NO_SOURCE" */
	@AJavaOnly
	@ARename(name = "'NETWORK_NO_SOURCE'")
	short NETWORK_NO_SOURCE = 3;

	/** "HAVE_NOTHING" */
	@AJavaOnly
	@ARename(name = "'HAVE_NOTHING'")
	short HAVE_NOTHING = 0;

	/** "HAVE_METADATA" */
	@AJavaOnly
	@ARename(name = "'HAVE_METADATA'")
	short HAVE_METADATA = 1;

	/** "HAVE_CURRENT_DATA" */
	@AJavaOnly
	@ARename(name = "'HAVE_CURRENT_DATA'")
	short HAVE_CURRENT_DATA = 2;

	/** "HAVE_FUTURE_DATA" */
	@AJavaOnly
	@ARename(name = "'HAVE_FUTURE_DATA'")
	short HAVE_FUTURE_DATA = 3;

	/** "HAVE_FUTURE_DATA" */
	@AJavaOnly
	@ARename(name = "'HAVE_FUTURE_DATA'")
	short HAVE_ENOUGH_DATA = 4;

	@Property
	short getReadyState();

	@Property
	short getNetworkState();

	@Property
	String getPreload();

	@Property
	TimeRanges getBuffered();

	@Property
	boolean getSeeking();

	@Function
	void load();

	@Function
	String canPlayType(String type);

	@Property
	double getCurrentTime();

	@Property
	void setCurrentTime(double currentTime);

	@Property
	double getInitialTime();

	@Property
	double getDuration();

	@Property
	Date getStartOffsetTime();

	@Property
	boolean getPaused();

	@Property
	double getDefaultPlaybackRate();

	@Property
	void setDefaultPlaybackRate(double defaultPlaybackRate);

	@Property
	double getPlaybackRate();

	@Property
	void setPlaybackRate(double rate);

	@Property
	TimeRanges getPlayed();

	@Property
	TimeRanges getSeekable();

	@Property
	boolean getEnded();

	@Property
	boolean getAutoplay();
	@Property
	void setAutoplay(boolean autoPlay);

	@Function
	void play();

	@Function
	void pause();

	@Property
	String getMediaGroup();
	@Property
	void setMediaGroup(String mediaGroup);

	@Property
	MediaController getController();
	
	@Property
	void setController(MediaController controller);

	@Property
	double getVolume();
	@Property
	void setVolume(double volume);

	@Property
	boolean getMuted();
	@Property
	void setMuted(boolean muted);

	@Property
	boolean getDefaultMuted();
	@Property
	void setDefaultMuted(boolean defaultMuted);
//
//	@Property
//	boolean getAutoBuffer();
//
//	@Property
//	void setAutoBuffer(boolean autoBuffer);

//	@Property
//	boolean getAutoPlay();
//
//	@Property
//	void setAutoPlay(boolean autoPlay);

//	@Property
//	boolean getLoop();
//
//	@Property
//	void setLoop(boolean loop);

	@Property
	boolean getControls();

	@Property
	void setControls(boolean controls);
	
	@Property MultipleTrackList getAudioTracks();
	
	@Property ExclusiveTrackList getVideoTracks();
	@Property TextTrack[] getTextTracks();
	
	@OverLoadFunc MutableTextTrack addTextTrack(String kind, String label, String language);
	@OverLoadFunc MutableTextTrack addTextTrack(String kind, String label);
	@OverLoadFunc MutableTextTrack addTextTrack(String kind);

}
