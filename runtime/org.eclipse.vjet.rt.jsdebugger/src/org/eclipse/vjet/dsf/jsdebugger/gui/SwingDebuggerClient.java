/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsdebugger.gui;

import javax.swing.WindowConstants;

import org.eclipse.vjet.dsf.jsdi.agent.remote.DebuggerClient;

public class SwingDebuggerClient {
	
	public SwingDebuggerClient() {
		SwingGui.initFileChooser();
		SwingGui gui = new SwingGui("DSF JS Debugger");
		gui.pack();
		gui.setSize(600, 460);			
		gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		gui.setVisible(true);
		new DebuggerClient(gui, true);
	}
	
	public static void main(String[] args) {
		new SwingDebuggerClient();
	}

}
