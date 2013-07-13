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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.zip.ZipException;

import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.typespace.efs.TypeSpaceFileSystem;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.mod.internal.core.ExternalFoldersManager;
import org.eclipse.dltk.mod.internal.core.ModelManager;

public class BuildPathUtils {

	public static IPath createPathForGroup(String groupName) {

		IPath p = null;
		URI uri = null;

		// TODO how to get this without adding linked resource?
		// must be absolute path for build path to work
		uri = getURIFromGroup(groupName);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile[] files = root.findFilesForLocationURI(uri,
				IContainer.INCLUDE_HIDDEN);
		if (files.length == 0) {
			VjetPlugin.error("Group name" + groupName
					+ "could not find path from uri " + uri);
			return null;
		}

		p = files[0].getFullPath();
//		if (!p.lastSegment().equals(groupName)) {
//			// this is error?
//			VjetPlugin.error("Group name" + groupName
//					+ " incorrectly binding with " + p);
//		}

		return p;
	}

	private static URI getURIFromGroup(String groupName) {
		URI uri = null;
		String paramString = "typespace://" + groupName + "/?group="
				+ groupName;
		try {
			uri = new URI(paramString);
		} catch (URISyntaxException e) {
			VjetPlugin.error("Group name" + groupName, e);
		}
		return uri;
	}

	public static void addLinkForGroup(String group) throws CoreException {
		addLinkForGroup(group, group);
	}

	public static void addLinkForGroup(final String group, final String linkName)
			throws CoreException {
		final URI uri = getURIFromGroup(group);

		ExternalFoldersManager foldersManager = ModelManager
				.getExternalManager();
		foldersManager.createLinkFolderKeepFolderName(linkName, new Path(
				linkName), uri, true, null);

	}

	/*
	 * prime the type space file system with entries since type space is not
	 * loaded yet read the manifest
	 */
	public static void initGroupWithTypeList(String groupName, IFile zipfile) {
		try {
			TypeSpaceFileSystem.initialize(getURIFromGroup(groupName), zipfile);
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
