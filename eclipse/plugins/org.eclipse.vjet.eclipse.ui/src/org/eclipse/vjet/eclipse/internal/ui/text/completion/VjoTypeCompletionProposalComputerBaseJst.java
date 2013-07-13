/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.text.completion;

import java.util.Collections;
import java.util.List;

import org.eclipse.vjet.eclipse.codeassist.CodeassistUtils;
import org.eclipse.vjet.vjo.tool.codecompletion.CodeCompletionUtils;
import org.eclipse.vjet.vjo.tool.codecompletion.IVjoCcEngine;
import org.eclipse.vjet.vjo.tool.codecompletion.IVjoCcProposalData;
import org.eclipse.vjet.vjo.tool.codecompletion.engine.VjoCcEngine;
import org.eclipse.vjet.vjo.tool.typespace.TypeSpaceMgr;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.core.VjoSourceModule;
import org.eclipse.dltk.mod.ui.DLTKUIPlugin;
import org.eclipse.dltk.mod.ui.PreferenceConstants;
import org.eclipse.dltk.mod.ui.text.completion.ScriptCompletionProposalComputer;
import org.eclipse.dltk.mod.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.dltk.mod.ui.text.completion.ScriptTextMessages;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.swt.widgets.Shell;

public class VjoTypeCompletionProposalComputerBaseJst extends
		ScriptCompletionProposalComputer {

	private String fErrorMessage;

	@Override
	protected TemplateCompletionProcessor createTemplateProposalComputer(
			ScriptContentAssistInvocationContext context) {
		return null;
	}

	// Script language specific completion proposals like types or keywords
	protected List computeScriptCompletionProposals(int offset,
			ScriptContentAssistInvocationContext context,
			IProgressMonitor monitor) {

		// Source module getting
		ISourceModule sourceModule = context.getSourceModule();
		if (sourceModule == null) {
			return Collections.EMPTY_LIST;
		}
		VjoSourceModule vjoSourceModule = null;
		if (sourceModule instanceof VjoSourceModule) {
			vjoSourceModule = (VjoSourceModule) sourceModule;
		} else {
			return Collections.emptyList();
		}
		IVjoCcEngine engine = new VjoCcEngine(TypeSpaceMgr.parser());
		String typeName = CodeassistUtils.getGroupName(vjoSourceModule);

		List<IVjoCcProposalData> list = engine.complete(typeName, new String(
				vjoSourceModule.getFileName()), vjoSourceModule
				.getSourceContents(), offset);
		// printProposal(list);
		if (list.isEmpty()) {
			return Collections.emptyList();
		}
		CodeCompletionUtils.printProposal(list);
		VjoProposalEclipsePresenter presenter = new VjoProposalEclipsePresenter(
				engine.getContext(), offset, context.getViewer()
						.getSelectedRange(), context.getDocument());
		return presenter.doPresenter(list);
	}

	private void handleCodeCompletionException(ModelException e,
			ScriptContentAssistInvocationContext context) {
		ISourceModule module = context.getSourceModule();
		Shell shell = context.getViewer().getTextWidget().getShell();
		if (e.isDoesNotExist()
				&& !module.getScriptProject().isOnBuildpath(module)) {
			IPreferenceStore store = DLTKUIPlugin.getDefault()
					.getPreferenceStore();
			boolean value = store
					.getBoolean(PreferenceConstants.NOTIFICATION_NOT_ON_BUILDPATH_MESSAGE);
			if (!value) {
				MessageDialog
						.openInformation(
								shell,
								ScriptTextMessages.CompletionProcessor_error_notOnBuildPath_title,
								ScriptTextMessages.CompletionProcessor_error_notOnBuildPath_message);
			}
			store.setValue(
					PreferenceConstants.NOTIFICATION_NOT_ON_BUILDPATH_MESSAGE,
					true);
		} else
			ErrorDialog
					.openError(
							shell,
							ScriptTextMessages.CompletionProcessor_error_accessing_title,
							ScriptTextMessages.CompletionProcessor_error_accessing_message,
							e.getStatus());
	}

	public String getErrorMessage() {
		return fErrorMessage;
	}

}
