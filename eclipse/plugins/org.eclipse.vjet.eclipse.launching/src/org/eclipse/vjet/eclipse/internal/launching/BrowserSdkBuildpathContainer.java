/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.launching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.mod.core.DLTKLanguageManager;
import org.eclipse.dltk.mod.core.IBuildpathContainer;
import org.eclipse.dltk.mod.core.IBuildpathEntry;
import org.eclipse.dltk.mod.core.IBuiltinModuleProvider;
import org.eclipse.dltk.mod.core.IInterpreterContainerExtension;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.launching.IInterpreterInstall;
import org.eclipse.dltk.mod.launching.IInterpreterInstallChangedListener;
import org.eclipse.dltk.mod.launching.PropertyChangeEvent;
import org.eclipse.dltk.mod.launching.ScriptRuntime;

import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.internal.core.util.Util;
import org.eclipse.vjet.vjo.lib.TsLibLoader;

/**
 * Interpreter Container - resolves a buildpath container tp interpreter
 */
public class BrowserSdkBuildpathContainer implements IBuildpathContainer {
	/**
	 * Container path used to resolve to this interpreter
	 */
	private IPath fPath = null;
	private List m_entries;
	/**
	 * Cache of buildpath entries per Interpreter install. Cleared when a
	 * Interpreter changes.
	 */
	private static Map fgBuildpathEntries = null;
	

	/**
	 * Returns the buildpath entries associated with the given interpreter.
	 * 
	 * @param interpreter
	 * @return buildpath entries
	 */
	private IBuildpathEntry[] getBuildpathEntries() {
		if (fgBuildpathEntries == null) {
			fgBuildpathEntries = new HashMap(10);
			// TODO need updated to listen sdk changes
			// add a listener to clear cached value when a Interpreter changes
			// or is
			// removed
			IInterpreterInstallChangedListener listener = new IInterpreterInstallChangedListener() {
				public void defaultInterpreterInstallChanged(
						IInterpreterInstall previous,
						IInterpreterInstall current) {
				}

				public void interpreterChanged(PropertyChangeEvent event) {
					if (event.getSource() != null) {
						fgBuildpathEntries.remove(event.getSource());
					}
				}

				public void interpreterAdded(IInterpreterInstall newInterpreter) {

				}

				public void interpreterRemoved(
						IInterpreterInstall removedInterpreter) {
					fgBuildpathEntries.remove(removedInterpreter);
				}
			};
			ScriptRuntime.addInterpreterInstallChangedListener(listener);
		}
		IBuildpathEntry[] entries = (IBuildpathEntry[]) fgBuildpathEntries
				.get(fPath.lastSegment());
		if (entries == null || m_entries ==null) {
			entries = computeBuildpathEntries(fPath.lastSegment());
			fgBuildpathEntries.put(fPath.lastSegment(), entries);
		}
		return entries;
	}

	/**
	 * Computes the buildpath entries associated with a interpreter - one entry
	 * per library.
	 * 
	 * @param interpreter
	 * @return buildpath entries
	 */
	private IBuildpathEntry[] computeBuildpathEntries(String sdkName) {
		List entries = m_entries;
		return (IBuildpathEntry[]) entries.toArray(new IBuildpathEntry[entries
				.size()]);
	}



	private IPath getSdkBasePath(String groupName) {
		return new Path(Util.getNativeTypeCacheDir(groupName).toString());
	}

	/**
	 * Constructs a interpreter buildpath container on the given interpreter
	 * install
	 * 
	 * @param interpreter
	 *            Interpreter install - cannot be <code>null</code>
	 * @param path
	 *            container path used to resolve this interpreter
	 */
	public BrowserSdkBuildpathContainer(IInterpreterInstall interpreter, IPath path) {
		fPath = path;
	}

	/**
	 * @see IBuildpathContainer#getBuildpathEntries(IScriptProject)
	 */
	public IBuildpathEntry[] getBuildpathEntries(IScriptProject project) {
		IBuildpathEntry[] buildpathEntries = getBuildpathEntries();
		List entries = new ArrayList();
		entries.addAll(Arrays.asList(buildpathEntries));
		// Use custom per project interpreter entries.
		IInterpreterContainerExtension extension = DLTKLanguageManager
				.getInterpreterContainerExtensions(project);
		if (extension != null) {
			extension.processEntres(project, entries);
		}
		return (IBuildpathEntry[]) entries.toArray(new IBuildpathEntry[entries
				.size()]);
	}

	/**
	 * @see IBuildpathContainer#getDescription()
	 */
	public String getDescription(IScriptProject project) {
		String sdkName = fPath.lastSegment();
		return sdkName + "[" + VjetPlugin.DES_VJET_SDK + "]";
	}

	/**
	 * @see IBuildpathContainer#getKind()
	 */
	public int getKind() {
		return IBuildpathContainer.K_DEFAULT_SYSTEM;
	}

	/**
	 * @see IBuildpathContainer#getPath()
	 */
	public IPath getPath() {
		return fPath;
	}

	public IBuiltinModuleProvider getBuiltinProvider(IScriptProject project) {
		return new IBuiltinModuleProvider() {

			public String getBuiltinModuleContent(String name) {
				return "";
			}

			public String[] getBuiltinModules() {
				return TsLibLoader.getDefaultLibNames();
			}

			public long lastModified() {
				return 0;
			}
		};
	}

	public void setEntries(List createEntries) {
		m_entries = createEntries;
		
	}
}
