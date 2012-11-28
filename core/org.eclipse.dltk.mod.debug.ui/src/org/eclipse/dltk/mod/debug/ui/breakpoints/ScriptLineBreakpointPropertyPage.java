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

import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.mod.core.environment.EnvironmentPathUtils;
import org.eclipse.dltk.mod.debug.core.model.IScriptBreakpoint;
import org.eclipse.dltk.mod.debug.core.model.IScriptLineBreakpoint;
import org.eclipse.dltk.mod.ui.util.SWTFactory;
import org.eclipse.swt.widgets.Composite;

public class ScriptLineBreakpointPropertyPage extends
		ScriptBreakpointPropertyPage {

	protected void createLocationLabels(Composite parent) throws CoreException {
		super.createLocationLabels(parent);
		IScriptLineBreakpoint breakpoint = (IScriptLineBreakpoint) getBreakpoint();

		// Line number
		int lineNumber = breakpoint.getLineNumber();

		SWTFactory.createLabel(parent, BreakpointMessages.LineNumberLabel, 1);
		SWTFactory.createLabel(parent, Integer.toString(lineNumber), 1);
	}

	protected String getBreakpointLocationLabel() {
		final IScriptBreakpoint breakpoint = getBreakpoint();
		if (breakpoint instanceof IScriptLineBreakpoint) {
			final IScriptLineBreakpoint lineBP = (IScriptLineBreakpoint) breakpoint;
			final IResource resource = lineBP.getResource();
			if (resource != null) {
				return BreakpointMessages.ResourceLabel;
			}
		}
		return super.getBreakpointLocationLabel();
	}

	protected String getBreakpointResourceName() throws CoreException {
		final IScriptBreakpoint breakpoint = getBreakpoint();
		if (breakpoint instanceof IScriptLineBreakpoint) {
			final IScriptLineBreakpoint lineBP = (IScriptLineBreakpoint) breakpoint;
			final IResource resource = lineBP.getResource();
			if (resource != null) {
				return resource.getFullPath().toString();
			}
			final IPath path = lineBP.getResourcePath();
			if (path != null) {
				// TODO add environment ONLY for remote ones
				return EnvironmentPathUtils.getLocalPath(path).toString();
			}
			final URI uri = lineBP.getResourceURI();
			return uri.toString();
		}
		return super.getBreakpointResourceName();
	}
}
