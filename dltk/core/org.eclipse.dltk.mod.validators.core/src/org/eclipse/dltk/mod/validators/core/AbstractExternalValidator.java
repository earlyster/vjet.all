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
package org.eclipse.dltk.mod.validators.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.validators.internal.core.ValidatorsCore;

public abstract class AbstractExternalValidator {

	protected abstract String getMarkerType();

	public void clean(ISourceModule[] modules) {
		clean(toResources(modules));
	}

	public void clean(IResource[] resources) {
		final String markerType = getMarkerType();
		// TODO execute single operation via IWorkspaceRunnable ?
		for (int i = 0; i < resources.length; ++i) {
			final IResource resource = resources[i];
			clean(resource, markerType);
		}
	}

	protected void clean(final IResource resource, final String markerType) {
		try {
			resource.deleteMarkers(markerType, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			ValidatorsCore.log(e.getStatus());
		}
	}

	protected void clean(final IResource resource) {
		clean(resource, getMarkerType());
	}

	protected IResource[] toResources(ISourceModule[] modules) {
		final List resources = new ArrayList(modules.length);
		for (int i = 0; i < modules.length; ++i) {
			final IResource resource = modules[i].getResource();
			if (resource != null) {
				resources.add(resource);
			}
		}
		final IResource[] result = new IResource[resources.size()];
		resources.toArray(result);
		return result;
	}

	protected IMarker createMarker(IResource res, int line, int start, int end,
			String msg, int severity, int priority) throws CoreException {
		final IMarker m = res.createMarker(getMarkerType());
		m.setAttribute(IMarker.LINE_NUMBER, line);
		m.setAttribute(IMarker.MESSAGE, msg);
		m.setAttribute(IMarker.SEVERITY, severity);
		m.setAttribute(IMarker.PRIORITY, priority);
		m.setAttribute(IMarker.CHAR_START, start);
		m.setAttribute(IMarker.CHAR_END, end);
		return m;
	}

	protected IMarker reportWarning(IResource res, int line, int start,
			int end, String msg) throws CoreException {
		return createMarker(res, line, start, end, msg,
				IMarker.SEVERITY_WARNING, IMarker.PRIORITY_NORMAL);
	}

	protected IMarker reportError(IResource res, int line, int start, int end,
			String msg) throws CoreException {
		return createMarker(res, line, start, end, msg, IMarker.SEVERITY_ERROR,
				IMarker.PRIORITY_NORMAL);
	}
}
