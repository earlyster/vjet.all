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
package org.eclipse.vjet.dsf.active.dom.html;

import java.util.Date;

import org.eclipse.vjet.dsf.html.dom.BaseHtmlElement;
import org.eclipse.vjet.dsf.jsnative.ExclusiveTrackList;
import org.eclipse.vjet.dsf.jsnative.HtmlMedia;
import org.eclipse.vjet.dsf.jsnative.MediaController;
import org.eclipse.vjet.dsf.jsnative.MediaError;
import org.eclipse.vjet.dsf.jsnative.MultipleTrackList;
import org.eclipse.vjet.dsf.jsnative.MutableTextTrack;
import org.eclipse.vjet.dsf.jsnative.TextTrack;
import org.eclipse.vjet.dsf.jsnative.TimeRanges;

public class AMediaElement extends AHtmlElement implements HtmlMedia {

	protected AMediaElement(AHtmlDocument doc, BaseHtmlElement node) {
		super(doc, node);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MediaError getError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSrc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSrc(String src) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentSrc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getReadyState() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short getNetworkState() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPreload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeRanges getBuffered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getSeeking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String canPlayType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCurrentTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCurrentTime(double currentTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getInitialTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date getStartOffsetTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getPaused() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getDefaultPlaybackRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDefaultPlaybackRate(double defaultPlaybackRate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPlaybackRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPlaybackRate(double rate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TimeRanges getPlayed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeRanges getSeekable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getEnded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAutoplay() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAutoplay(boolean autoPlay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMediaGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMediaGroup(String mediaGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MediaController getController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setController(MediaController controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setVolume(double volume) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getMuted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMuted(boolean muted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getDefaultMuted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDefaultMuted(boolean defaultMuted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getControls() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setControls(boolean controls) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MultipleTrackList getAudioTracks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExclusiveTrackList getVideoTracks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextTrack[] getTextTracks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutableTextTrack addTextTrack(String kind, String label,
			String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutableTextTrack addTextTrack(String kind, String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MutableTextTrack addTextTrack(String kind) {
		// TODO Auto-generated method stub
		return null;
	}



}
