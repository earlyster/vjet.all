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
package org.eclipse.dltk.mod.internal.debug.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.dltk.mod.internal.debug.ui.messages"; //$NON-NLS-1$
	public static String HotCodeReplaceErrorDialog_continue;
	public static String HotCodeReplaceErrorDialog_disconnect;
	public static String HotCodeReplaceErrorDialog_disconnect2;
	public static String HotCodeReplaceErrorDialog_failed;
	public static String HotCodeReplaceErrorDialog_restart;
	public static String HotCodeReplaceErrorDialog_restart2;
	public static String HotCodeReplaceErrorDialog_terminate;
	public static String HotCodeReplaceErrorDialog_terminate2;
	public static String ScriptDetailFormattersManager_cantEvaluateDetails;
	public static String ScriptHotCodeReplaceListener_doNotShowErrorWhenHotCodeReplaceFails;
	public static String ScriptHotCodeReplaceListener_doNotShowErrorWhenHotCodeReplaceIsNotSupported;
	public static String ScriptHotCodeReplaceListener_hotCodeReplaceFailed;
	public static String ScriptHotCodeReplaceListener_someCodeChangesCannotBeHotSwappedIntoARunningInterpreter;
	public static String ScriptHotCodeReplaceListener_theTargetDoesntSupportHotCodeReplace;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
