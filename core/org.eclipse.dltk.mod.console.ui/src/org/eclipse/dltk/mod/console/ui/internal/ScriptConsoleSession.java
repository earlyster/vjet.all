/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.console.ui.internal;

import org.eclipse.dltk.mod.console.IScriptExecResult;
import org.eclipse.dltk.mod.console.ui.IScriptConsoleListener;
import org.eclipse.dltk.mod.console.ui.IScriptConsoleSession;

public class ScriptConsoleSession implements IScriptConsoleListener,
		IScriptConsoleSession {
	private StringBuffer session;

	public ScriptConsoleSession() {
		this.session = new StringBuffer();
	}

	public void interpreterResponse(IScriptExecResult text) {
		if (text != null) {
			session.append("> "); //$NON-NLS-1$
			session.append(text.getOutput());
		}
	}

	public void userRequest(String text) {
		session.append("< "); //$NON-NLS-1$
		session.append(text);
		session.append('\n');
	}

	public String toString() {
		return session.toString();
	}
}
