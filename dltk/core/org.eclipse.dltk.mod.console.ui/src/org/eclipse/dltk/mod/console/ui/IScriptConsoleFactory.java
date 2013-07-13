/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.console.ui;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.dltk.mod.console.IScriptInterpreter;

public interface IScriptConsoleFactory {
	void openConsole(IScriptInterpreter interpreter, String id, ILaunch launch);
}
