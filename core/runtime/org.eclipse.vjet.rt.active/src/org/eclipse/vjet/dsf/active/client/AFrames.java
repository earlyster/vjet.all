/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.active.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.jsnative.Frames;
import org.eclipse.vjet.dsf.jsnative.Window;

public class AFrames extends ActiveObject implements Frames {
	

	private static final long serialVersionUID = 1L;
	
	private List<Window> m_frames = new ArrayList<Window>();

	public void addChildWindow(Window window) {
		m_frames.add(window);
	}
	
	public int size() {
        return m_frames.size();
    }
	
	public Window at(int index) {
		return m_frames.get(index);
	}

}
