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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;

public class ScriptConsoleIO implements IScriptConsoleIO {

	private static final String INTERPRETER = "interpreter"; //$NON-NLS-1$

	private static final String SHELL = "shell"; //$NON-NLS-1$

	private final InputStream input;

	private final OutputStream output;

	private final String id;

	protected static void logInterpreterResponse(String response) {
		// System.out.println("interpreter: " + response);
	}

	protected static void logShellResponse(String response) {
		// System.out.println("shell: " + response);
	}

	protected static String readFixed(int len, InputStream input)
			throws IOException {
		byte[] buffer = new byte[len];
		int from = 0;
		try {
			while (from < buffer.length) {
				int n;
				try {
					n = input.read(buffer, from, buffer.length - from);
				} catch (SocketTimeoutException sxcn) {
					n = input.read(buffer, from, buffer.length - from);
				}
				if (n == -1) {
					return null;
				}
				from += n;
			}
		} catch (SocketTimeoutException sxcn) {
			sxcn.printStackTrace();
		}

		return new String(buffer, 0, from, "UTF-8"); //$NON-NLS-1$
	}

	protected static int readLength(InputStream input) throws IOException {
		try {
			String readFixed = readFixed(10, input);
			return Integer.parseInt(readFixed);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	protected static String readResponse(InputStream input) throws IOException {
		int len = readLength(input);
		if (len == -1) {
			return null;
		}

		String xml = readFixed(len, input);

		if (xml == null) {
			return null;
		}

		return xml;
	}

	public ScriptConsoleIO(InputStream input, OutputStream output)
			throws IOException {
		if (input == null || output == null) {
			throw new IllegalArgumentException();
		}

		this.input = input;
		this.output = output;

		this.id = ScriptConsoleXmlHelper.parseInfoXml(readResponse(input));
	}

	public InputStream getInitialResponseStream() {
		return new InputStream() {
			boolean finished = false;

			public int read() throws IOException {
				if (finished == true) {
					return -1;
				}
				byte b[] = new byte[1];
				int read = input.read(b, 0, 1);
				if (read == -1 || b[0] == 0) {
					finished = true;
					return -1;
				}
				return b[0];
			}
		};
	}

	public String getId() {
		return id;
	}

	public ShellResponse execShell(String command, String[] args)
			throws IOException {

		output.write((SHELL + "\n").getBytes("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$
		output.write((command + "\n").getBytes("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$

		for (int i = 0; i < args.length; ++i) {
			output.write((args[i] + "\n").getBytes("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$
		}
		output.flush();

		final String response = readResponse(input);
		logShellResponse(response);
		return ScriptConsoleXmlHelper.parseShellXml(response);
	}

	public InterpreterResponse execInterpreter(String command)
			throws IOException {
		output.write((INTERPRETER + "\n").getBytes("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$
		output.write((command + "\n").getBytes("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$
		output.flush();

		final String response = readResponse(input);
		logInterpreterResponse(response);
		return ScriptConsoleXmlHelper.parseInterpreterXml(response);
	}

	public void close() throws IOException {
		input.close();
		output.close();
	}
}
