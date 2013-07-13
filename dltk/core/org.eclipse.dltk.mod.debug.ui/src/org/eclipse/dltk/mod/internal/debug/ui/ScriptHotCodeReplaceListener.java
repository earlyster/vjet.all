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

import java.text.MessageFormat;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.dltk.mod.debug.core.IHotCodeReplaceListener;
import org.eclipse.dltk.mod.debug.core.model.IScriptDebugTarget;
import org.eclipse.dltk.mod.debug.ui.DLTKDebugUIPlugin;
import org.eclipse.dltk.mod.debug.ui.IDLTKDebugUIPreferenceConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ScriptHotCodeReplaceListener implements IHotCodeReplaceListener {

	/**
	 * @see IScriptHotCodeReplaceListener#hotCodeReplaceSucceeded(IScriptDebugTarget)
	 */
	public void hotCodeReplaceSucceeded(IScriptDebugTarget target) {
	}

	/**
	 * @see IScriptHotCodeReplaceListener#hotCodeReplaceFailed(IScriptDebugTarget,
	 *      DebugException)
	 */
	public void hotCodeReplaceFailed(final IScriptDebugTarget target,
			final DebugException exception) {
		if ((exception != null && !DLTKDebugUIPlugin.getDefault()
				.getPreferenceStore().getBoolean(
						IDLTKDebugUIPreferenceConstants.PREF_ALERT_HCR_FAILED))
				|| ((exception == null) && !DLTKDebugUIPlugin
						.getDefault()
						.getPreferenceStore()
						.getBoolean(
								IDLTKDebugUIPreferenceConstants.PREF_ALERT_HCR_NOT_SUPPORTED))) {
			return;
		}

		final Display display = DLTKDebugUIPlugin.getStandardDisplay();
		if (display.isDisposed()) {
			return;
		}

		final IStatus status;
		final String preference;
		final String alertMessage;
		final String launchName = target.getLaunch().getLaunchConfiguration()
				.getName();
		if (exception == null) {
			status = new Status(IStatus.WARNING, DLTKDebugUIPlugin
					.getUniqueIdentifier(), IStatus.WARNING,
					Messages.ScriptHotCodeReplaceListener_theTargetDoesntSupportHotCodeReplace, null);
			preference = IDLTKDebugUIPreferenceConstants.PREF_ALERT_HCR_NOT_SUPPORTED;
			alertMessage = Messages.ScriptHotCodeReplaceListener_doNotShowErrorWhenHotCodeReplaceIsNotSupported;
		} else {
			status = new Status(IStatus.WARNING, DLTKDebugUIPlugin
					.getUniqueIdentifier(), IStatus.WARNING, exception
					.getMessage(), exception.getCause());
			preference = IDLTKDebugUIPreferenceConstants.PREF_ALERT_HCR_FAILED;
			alertMessage = Messages.ScriptHotCodeReplaceListener_doNotShowErrorWhenHotCodeReplaceFails;
		}
		final String title = Messages.ScriptHotCodeReplaceListener_hotCodeReplaceFailed;
		final String message = MessageFormat.format(Messages.ScriptHotCodeReplaceListener_someCodeChangesCannotBeHotSwappedIntoARunningInterpreter,
						new Object[] { launchName });
		display.asyncExec(new Runnable() {
			public void run() {
				if (display.isDisposed()) {
					return;
				}
				Shell shell = DLTKDebugUIPlugin.getActiveWorkbenchShell();
				HotCodeReplaceErrorDialog dialog = new HotCodeReplaceErrorDialog(
						shell, title, message, status, preference,
						alertMessage, DLTKDebugUIPlugin.getDefault()
								.getPreferenceStore(), target);
				dialog.setBlockOnOpen(false);
				dialog.open();
			}
		});
	}
}
