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
package org.eclipse.dltk.mod.core.tests.utils;

import org.eclipse.dltk.mod.core.builder.ISourceLineTracker;
import org.eclipse.dltk.mod.utils.TextUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SourceLineTrackerTests extends TestCase {

	public static Test suite() {
		return new TestSuite(SourceLineTrackerTests.class);
	}

	public void testNotTerminatedSingleLine() {
		String input = "1234567890";
		ISourceLineTracker tracker = TextUtils.createLineTracker(input);
		assertEquals(1, tracker.getNumberOfLines());
		assertEquals(input.length(), tracker.getLength());
		assertNull(tracker.getLineDelimiter(0));
		assertEquals(0, tracker.getLineOffset(0));
		assertEquals(input.length(), tracker.getLineLength(0));
	}

	public void testTerminatedSingleLine() {
		String input = "1234567890\r\n";
		ISourceLineTracker tracker = TextUtils.createLineTracker(input);
		assertEquals(1, tracker.getNumberOfLines());
		assertEquals(input.length(), tracker.getLength());
		assertEquals("\r\n", tracker.getLineDelimiter(0));
		assertEquals(0, tracker.getLineOffset(0));
		assertEquals(input.length(), tracker.getLineLength(0));
	}

	public void testTwoLines() {
		final String line0 = "1234567890\r\n";
		final String line1 = "1234567890";
		final String input = line0 + line1;
		ISourceLineTracker tracker = TextUtils.createLineTracker(input);
		assertEquals(2, tracker.getNumberOfLines());
		assertEquals(input.length(), tracker.getLength());
		assertEquals("\r\n", tracker.getLineDelimiter(0));
		assertNull(tracker.getLineDelimiter(1));
		assertEquals(0, tracker.getLineOffset(0));
		assertEquals(line0.length(), tracker.getLineOffset(1));
		assertEquals(line0.length(), tracker.getLineLength(0));
		assertEquals(line1.length(), tracker.getLineLength(1));
	}

}
