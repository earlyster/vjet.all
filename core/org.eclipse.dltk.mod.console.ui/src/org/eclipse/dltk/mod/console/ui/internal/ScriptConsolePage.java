/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.console.ui.internal;

import org.eclipse.core.commands.IHandler;
import org.eclipse.dltk.mod.console.ScriptConsoleConstants;
import org.eclipse.dltk.mod.console.ui.ScriptConsole;
import org.eclipse.dltk.mod.console.ui.internal.actions.CloseScriptConsoleAction;
import org.eclipse.dltk.mod.console.ui.internal.actions.SaveConsoleSessionAction;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.TextConsolePage;
import org.eclipse.ui.console.TextConsoleViewer;
import org.eclipse.ui.console.actions.TextViewerAction;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

public class ScriptConsolePage extends TextConsolePage implements
		IScriptConsoleContentHandler {

	protected class ContentAssistProposalsAction extends TextViewerAction {

		public ContentAssistProposalsAction(ITextViewer viewer) {
			super(viewer, ISourceViewer.CONTENTASSIST_PROPOSALS);
		}
	}

	protected class ContentAssistContextInfoAction extends TextViewerAction {
		public ContentAssistContextInfoAction(ITextViewer viewer) {
			super(viewer, ISourceViewer.CONTENTASSIST_CONTEXT_INFORMATION);
		}
	}

	private SourceViewerConfiguration cfg;

	private ScriptConsoleViewer viewer;

	private TextViewerAction proposalsAction;
	private IHandler proposalsHandler;

	protected void createActions() {
		super.createActions();

		proposalsAction = new ContentAssistProposalsAction(getViewer());
		proposalsAction
				.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		IHandlerService handlerService = (IHandlerService) getSite()
				.getService(IHandlerService.class);
		proposalsHandler = new ActionHandler(proposalsAction);
		handlerService.activateHandler(
				ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS,
				proposalsHandler);

		SaveConsoleSessionAction saveSessionAction = new SaveConsoleSessionAction(
				(ScriptConsole) getConsole(),
				ScriptConsoleMessages.SaveSessionAction,
				ScriptConsoleMessages.SaveSessionTooltip);

		IAction closeConsoleAction = createTerminateConsoleAction();

		IActionBars bars = getSite().getActionBars();

		IToolBarManager toolbarManager = bars.getToolBarManager();

		toolbarManager.prependToGroup(IConsoleConstants.LAUNCH_GROUP,
				new GroupMarker(ScriptConsoleConstants.SCRIPT_GROUP));
		toolbarManager.appendToGroup(ScriptConsoleConstants.SCRIPT_GROUP,
				new Separator());

		if (closeConsoleAction != null) {
			toolbarManager.appendToGroup(ScriptConsoleConstants.SCRIPT_GROUP,
					closeConsoleAction);
		}

		toolbarManager.appendToGroup(ScriptConsoleConstants.SCRIPT_GROUP,
				saveSessionAction);

		bars.updateActionBars();
	}

	protected IAction createTerminateConsoleAction() {
		return new CloseScriptConsoleAction((ScriptConsole) getConsole(),
				ScriptConsoleMessages.TerminateConsoleAction,
				ScriptConsoleMessages.TerminateConsoleTooltip);
	}

	protected TextConsoleViewer createViewer(Composite parent) {
		viewer = new ScriptConsoleViewer(parent, (ScriptConsole) getConsole(),
				this);
		viewer.configure(cfg);
		return viewer;
	}

	public ScriptConsolePage(ScriptConsole console, IConsoleView view,
			SourceViewerConfiguration cfg) {
		super(console, view);

		this.cfg = cfg;
	}

	public void clearConsolePage() {
		viewer.clear();
	}

	public void contentAssistRequired() {
		proposalsAction.run();
	}

	public void insertText(String text) {
		viewer.insertText(text);
	}

	public void dispose() {
		if (viewer != null) {
			viewer.dispose();
			viewer = null;
		}
		proposalsHandler.dispose();

		super.dispose();
	}

}
