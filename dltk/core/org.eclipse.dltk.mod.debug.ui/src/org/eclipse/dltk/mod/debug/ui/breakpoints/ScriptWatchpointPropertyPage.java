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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.mod.debug.core.IDLTKDebugToolkit;
import org.eclipse.dltk.mod.debug.core.ScriptDebugManager;
import org.eclipse.dltk.mod.debug.core.model.IScriptWatchpoint;
import org.eclipse.dltk.mod.ui.util.SWTFactory;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ScriptWatchpointPropertyPage extends ScriptBreakpointPropertyPage {

	private Button suspendOnAccessButton;
	private Button suspendOnModificationButton;

	public ScriptWatchpointPropertyPage() {

	}

	protected void createTypeSpecificLabels(Composite parent)
			throws CoreException {
		setTitle(BreakpointMessages.WatchpointTitle);

		IScriptWatchpoint watchPoint = (IScriptWatchpoint) getBreakpoint();

		// Watch field
		SWTFactory.createLabel(parent, BreakpointMessages.WatchFieldLabel, 1);
		SWTFactory.createLabel(parent, watchPoint.getFieldName(), 1);
	}

	protected boolean hasExpressionEditor() {
		return false;
	}

	protected void createTypeSpecificButtons(Composite parent) {
		suspendOnAccessButton = SWTFactory.createCheckButton(parent,
				BreakpointMessages.SuspendOnAccessLabel, null, false, 1);
		suspendOnModificationButton = SWTFactory.createCheckButton(parent,
				BreakpointMessages.SuspendOnModificationLabel, null, false, 1);
	}

	protected void loadValues() throws CoreException {
		super.loadValues();

		IScriptWatchpoint watchpoint = (IScriptWatchpoint) getBreakpoint();
		final IDLTKDebugToolkit debugToolkit = ScriptDebugManager.getInstance()
				.getDebugToolkitByDebugModel(watchpoint.getModelIdentifier());
		if (debugToolkit.isAccessWatchpointSupported()) {
			suspendOnAccessButton.setSelection(watchpoint.isAccess());
			suspendOnModificationButton.setSelection(watchpoint
					.isModification());
		} else {
			suspendOnAccessButton.setEnabled(false);
			suspendOnModificationButton.setEnabled(false);
			suspendOnModificationButton.setSelection(true);
		}
	}

	protected void saveValues() throws CoreException {
		super.saveValues();

		IScriptWatchpoint watchpoint = (IScriptWatchpoint) getBreakpoint();
		final IDLTKDebugToolkit debugToolkit = ScriptDebugManager.getInstance()
				.getDebugToolkitByDebugModel(watchpoint.getModelIdentifier());
		if (debugToolkit.isAccessWatchpointSupported()) {
			watchpoint.setAccess(suspendOnAccessButton.getSelection());
			watchpoint.setModification(suspendOnModificationButton
					.getSelection());
		}
	}
}
