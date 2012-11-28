/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.console;

import java.io.IOException;

public interface IScriptConsoleInterpreter {
	int WAIT_NEW_COMMAND = 0;
	int WAIT_CONTINUE_COMMAND = 1;
	int WAIT_USER_INPUT = 2;

	IScriptExecResult exec(String command) throws IOException;

	int getState();
}
