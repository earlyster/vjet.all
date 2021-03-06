/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.debug.core;

public class DLTKDebugPreferenceConstants {
	public static final int DBGP_DEFAULT_PORT = 9000;
	public static final int DBGP_AVAILABLE_PORT = -1;
	public static final String DBGP_AUTODETECT_BIND_ADDRESS = "autodetect"; //$NON-NLS-1$

	public static final String PREF_DBGP_BREAK_ON_FIRST_LINE = "dbgp_break_on_first_line"; //$NON-NLS-1$

	public static final String PREF_DBGP_ENABLE_LOGGING = "dbgp_enable_logging"; //$NON-NLS-1$

	// Communication
	public static final String PREF_DBGP_BIND_ADDRESS = "dbgp_bind_address"; //$NON-NLS-1$
	public static final String PREF_DBGP_PORT = "dbgp_port"; //$NON-NLS-1$

	// Time to wait of connection debugging engine to the IDE
	public static final String PREF_DBGP_CONNECTION_TIMEOUT = "dbgp_connection_timeout"; //$NON-NLS-1$

	// Time to wait after sending DBGP request to the debugging engine
	public static final String PREF_DBGP_RESPONSE_TIMEOUT = "dbgp_response_timeout"; //$NON-NLS-1$

	public static final String PREF_DBGP_SHOW_SCOPE_PREFIX = "dbgp_show_scope_"; //$NON-NLS-1$

	public static final String PREF_DBGP_SHOW_SCOPE_LOCAL = PREF_DBGP_SHOW_SCOPE_PREFIX
			+ "local"; //$NON-NLS-1$

	public static final String PREF_DBGP_SHOW_SCOPE_GLOBAL = PREF_DBGP_SHOW_SCOPE_PREFIX
			+ "global"; //$NON-NLS-1$

	public static final String PREF_DBGP_SHOW_SCOPE_CLASS = PREF_DBGP_SHOW_SCOPE_PREFIX
			+ "class"; //$NON-NLS-1$
}
