/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.console.ui;

import org.eclipse.ui.console.IConsoleFactory;

public abstract class ScriptConsoleFactoryBase implements IConsoleFactory {
	public ScriptConsoleFactoryBase() {
	}

	protected void registerAndOpenConsole(ScriptConsole console) {
		ScriptConsoleManager manager = ScriptConsoleManager.getInstance();
		manager.add(console);
		manager.showConsole(console);
	}

	public void openConsole() {
		ScriptConsole console = createConsoleInstance();
		if (console != null) {
			registerAndOpenConsole(console);
		}
	}

	protected abstract ScriptConsole createConsoleInstance();
}
