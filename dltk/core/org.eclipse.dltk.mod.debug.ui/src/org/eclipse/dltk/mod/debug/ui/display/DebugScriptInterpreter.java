/*******************************************************************************
 * Copyright (c) 2008, 2012 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.mod.debug.ui.display;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.dltk.mod.compiler.util.Util;
import org.eclipse.dltk.mod.console.IScriptExecResult;
import org.eclipse.dltk.mod.console.IScriptConsoleIO;
import org.eclipse.dltk.mod.console.IScriptInterpreter;
import org.eclipse.dltk.mod.console.ScriptExecResult;
import org.eclipse.dltk.mod.debug.core.eval.IScriptEvaluationResult;
import org.eclipse.dltk.mod.debug.core.model.IScriptStackFrame;
import org.eclipse.dltk.mod.debug.core.model.IScriptThread;
import org.eclipse.dltk.mod.debug.core.model.IScriptValue;
import org.eclipse.dltk.mod.internal.debug.ui.ScriptEvaluationContextManager;
import org.eclipse.ui.IViewPart;

public class DebugScriptInterpreter implements IScriptInterpreter {

	private final IViewPart part;

	/**
	 * @param scriptDisplayView
	 */
	public DebugScriptInterpreter(IViewPart part) {
		this.part = part;
	}

	public void addInitialListenerOperation(Runnable runnable) {
		// NOP
	}

	public InputStream getInitialOutputStream() {
		return new ByteArrayInputStream(new byte[0]);
	}

	public boolean isValid() {
		return true;
	}

	/*
	 * @see org.eclipse.dltk.mod.console.IScriptConsoleShell#close()
	 */
	public void close() throws IOException {
		// NOP
	}

	public List getCompletions(String commandLine, int position)
			throws IOException {
		return null;
	}

	public String getDescription(String commandLine, int position)
			throws IOException {
		return null;
	}

	public String[] getNames(String type) throws IOException {
		return null;
	}

	public IScriptExecResult exec(String command) throws IOException {
		final IScriptStackFrame frame = ScriptEvaluationContextManager
				.getEvaluationContext(part);
		if (frame != null) {
			final IScriptThread thread = frame.getScriptThread();
			if (thread != null) {
				final IScriptEvaluationResult result = thread
						.getEvaluationEngine().syncEvaluate(command, frame);
				if (result != null) {
					final IScriptValue value = result.getValue();
					if (value != null) {
						String output = value.getDetailsString();
						if (output == null) {
							output = Messages.DebugScriptInterpreter_null;
						}
						if (!output.endsWith("\n")) { //$NON-NLS-1$
							output = output + "\n"; //$NON-NLS-1$
						}
						return new ScriptExecResult(output);
					}
					final StringBuffer buffer = new StringBuffer();
					final String[] errors = result.getErrorMessages();
					for (int i = 0; i < errors.length; ++i) {
						buffer.append(errors[i]);
						buffer.append(Util.LINE_SEPARATOR);
					}
					if (errors.length == 0) {
						buffer
								.append(Messages.DebugScriptInterpreter_unknownEvaluationError);
						buffer.append(Util.LINE_SEPARATOR);
					}
					return new ScriptExecResult(buffer.toString(), true);
				}
			}
		}
		return new ScriptExecResult(
				Messages.DebugScriptInterpreter_NoDebugger
						+ Util.LINE_SEPARATOR, true);
	}

	public int getState() {
		return WAIT_NEW_COMMAND;
	}

	public void consoleConnected(IScriptConsoleIO protocol) {
		// NOP
	}

}
