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
package org.eclipse.vjet.eclipse.internal.launching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.mod.core.IAccessRule;
import org.eclipse.dltk.mod.core.IBuildpathAttribute;
import org.eclipse.dltk.mod.core.IBuildpathContainer;
import org.eclipse.dltk.mod.core.IBuildpathEntry;
import org.eclipse.dltk.mod.core.IBuiltinModuleProvider;
import org.eclipse.dltk.mod.core.IScriptProject;

public class VJETZipContainer implements IBuildpathContainer {

	private final String groupName;
	private final IPath containerPath;
	private Map fgBuildpathEntries;
	private List m_entries;
	private static IAccessRule[] EMPTY_RULES = new IAccessRule[0];

	public VJETZipContainer(String groupName, IPath containerPath) {
		this.groupName = groupName;
		this.containerPath = containerPath;

	}

	@Override
	public IBuildpathEntry[] getBuildpathEntries(IScriptProject project) {
		if (fgBuildpathEntries == null) {
			fgBuildpathEntries = new HashMap(10);

		}
		IBuildpathEntry[] entries = (IBuildpathEntry[]) fgBuildpathEntries
				.get(groupName);
		if (entries == null || m_entries==null) {
			entries = computeBuildpathEntries();
			fgBuildpathEntries.put(groupName, entries);
		}
		return entries;
	}

	private IBuildpathEntry[] computeBuildpathEntries() {
		List entries = m_entries;
		IBuildpathAttribute[] attributes = new IBuildpathAttribute[0];
		ArrayList excluded = new ArrayList(); // paths to exclude
		// TODO add zip to build path rather than require seperate entry
		// TODO add to type space
//		entries.add(new BuildpathEntry(IProjectFragment.K_BINARY,
//				IBuildpathEntry.BPE_LIBRARY, ScriptProject
//						.canonicalizedPath(BuildPathUtils
//								.createPathForGroup(groupName)), false,
//				BuildpathEntry.INCLUDE_ALL, (IPath[]) excluded
//						.toArray(new IPath[excluded.size()]), EMPTY_RULES,
//				false, attributes, false));
//		
//		entries.add(new BuildpathEntry(IProjectFragment.K_BINARY,
//				IBuildpathEntry.BPE_LIBRARY, ScriptProject
//						.canonicalizedPath(this.containerPath), false,
//				BuildpathEntry.INCLUDE_ALL, (IPath[]) excluded
//						.toArray(new IPath[excluded.size()]), EMPTY_RULES,
//				false, attributes, false));

		return (IBuildpathEntry[]) entries.toArray(new IBuildpathEntry[entries
				.size()]);
	}

	@Override
	public String getDescription(IScriptProject project) {
		return groupName + " [Library Types]";
	}

	@Override
	public int getKind() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPath getPath() {
		return containerPath;
	}

	@Override
	public IBuiltinModuleProvider getBuiltinProvider(IScriptProject project) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEntries(List createEntries) {
		m_entries = createEntries;
		
	}

}
