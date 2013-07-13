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
package org.eclipse.dltk.mod.debug.ui.breakpoints;

import org.eclipse.osgi.util.NLS;

public class BreakpointMessages {
	private static final String BUNDLE_NAME = "org.eclipse.dltk.mod.debug.ui.breakpoints.BreakpointMessages"; //$NON-NLS-1$
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, BreakpointMessages.class);
	}
	
	// Breakpoint titles
	public static String LineBreakpointTitle;
	public static String MethodBreakpointTitle;
	public static String WatchpointTitle;
	
	
	// Script breakpoint labels
	public static String LanguageLabel;
	
	public static String EnabledLabel;
	
	public static String ResourceLabel;
	public static String FileLabel;
	
	public static String InternalIdLabel;
	
	public static String HitCountLabel;
	
	public static String UseConditionLabel;
	
	public static String BreakWhenHitCountLabel;
	
	public static String HitsLabel;
	
	// Line breakpoint labels
	public static String LineNumberLabel;
	
	// Method breakpoint labels
	public static String SuspendOnMethodEntryLabel;
	
	public static String SuspendOnMethodExitLabel;
	
	// Watchpoint labels
	public static String WatchFieldLabel;
	
	public static String SuspendOnAccessLabel;
	
	public static String SuspendOnModificationLabel;
	
	// Exception labels
	public static String ExceptionType;

	// Errors
	public static String InvalidNumberOfHits;
	
	public static String InternalIdNotAvailableMessage;
	
	public static String HitCountNotAvailableMessage;
	
	public static String HitConditionGreaterOrEqual;
	
	public static String HitConditionEqual;
	
	public static String HitConditionMultiple;
	
	
	// Error of ToggleBreakpointAdapter
}
