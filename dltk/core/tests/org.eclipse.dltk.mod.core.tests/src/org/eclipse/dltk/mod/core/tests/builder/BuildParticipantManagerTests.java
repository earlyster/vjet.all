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
package org.eclipse.dltk.mod.core.tests.builder;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.core.builder.IBuildContext;
import org.eclipse.dltk.mod.core.builder.IBuildParticipant;
import org.eclipse.dltk.mod.core.builder.IBuildParticipantFactory;
import org.eclipse.dltk.mod.internal.core.builder.BuildParticipantManager;
import org.eclipse.dltk.mod.internal.core.builder.BuildParticipantManager.BuildParticipantDescriptor;
import org.eclipse.dltk.mod.utils.TextUtils;

import junit.framework.TestCase;

public class BuildParticipantManagerTests extends TestCase {

	private static class TestBuildParticipantFactory implements
			IBuildParticipantFactory {

		final String key;

		public TestBuildParticipantFactory(String key) {
			this.key = key;
		}

		public IBuildParticipant createBuildParticipant(IScriptProject project)
				throws CoreException {
			return new TestBuildParticipant(key);
		}

	}

	private static class TestBuildParticipant implements IBuildParticipant {

		final String key;

		public TestBuildParticipant(String key) {
			this.key = key;
		}

		public void build(IBuildContext context) throws CoreException {
			// NOP
		}

	}

	private BuildParticipantDescriptor createDescriptor(String id,
			String requirements) {
		final BuildParticipantDescriptor descriptor = new BuildParticipantDescriptor(
				new TestBuildParticipantFactory(id), id, id);
		final String[] ids = TextUtils.split(requirements, ',');
		if (ids != null && ids.length != 0) {
			for (int i = 0; i < ids.length; ++i) {
				descriptor.requirements.add(ids[i]);
			}
		}
		return descriptor;
	}

	public void testSimple() {
		BuildParticipantDescriptor[] descriptors = new BuildParticipantDescriptor[] {
				createDescriptor("A", null), createDescriptor("B", null),
				createDescriptor("C", null) };
		IBuildParticipant[] participants = BuildParticipantManager
				.createParticipants(null, descriptors);
		assertEquals(3, participants.length);
		assertEquals("A", ((TestBuildParticipant) participants[0]).key);
		assertEquals("B", ((TestBuildParticipant) participants[1]).key);
		assertEquals("C", ((TestBuildParticipant) participants[2]).key);
	}

	public void testDependency() {
		BuildParticipantDescriptor[] descriptors = new BuildParticipantDescriptor[] {
				createDescriptor("A", "B,C"), createDescriptor("B", "C"),
				createDescriptor("C", null) };
		IBuildParticipant[] participants = BuildParticipantManager
				.createParticipants(null, descriptors);
		assertEquals(3, participants.length);
		assertEquals("C", ((TestBuildParticipant) participants[0]).key);
		assertEquals("B", ((TestBuildParticipant) participants[1]).key);
		assertEquals("A", ((TestBuildParticipant) participants[2]).key);
	}

	public void testMissingDependency() {
		BuildParticipantDescriptor[] descriptors = new BuildParticipantDescriptor[] {
				createDescriptor("A", "D"), createDescriptor("B", "C"),
				createDescriptor("C", null) };
		IBuildParticipant[] participants = BuildParticipantManager
				.createParticipants(null, descriptors);
		assertEquals(2, participants.length);
		assertEquals("C", ((TestBuildParticipant) participants[0]).key);
		assertEquals("B", ((TestBuildParticipant) participants[1]).key);
	}

}
