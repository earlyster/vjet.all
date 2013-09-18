/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.ui.actions;

import org.eclipse.dltk.mod.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.mod.ui.actions.OpenEditorActionGroup;
import org.eclipse.dltk.mod.ui.actions.OpenViewActionGroup;
import org.eclipse.dltk.mod.ui.actions.SearchActionGroup;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;

/**
 * Action group that adds the open and show actions to a context menu and the
 * action bar's navigate menu. This action group reuses the <code>
 * OpenEditorActionGroup</code>
 * and <code>OpenViewActionGroup</code>.
 * 
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 * 
 * 
 */
public class NavigateActionGroup extends ActionGroup {

	private OpenEditorActionGroup fOpenEditorActionGroup;
	private OpenViewActionGroup fOpenViewActionGroup;

	SearchActionGroup fSearchActionGroup;

	/**
	 * Creates a new <code>NavigateActionGroup</code>. The group requires
	 * that the selection provided by the part's selection provider is of type
	 * <code>
	 * org.eclipse.jface.viewers.IStructuredSelection</code>.
	 * 
	 * @param part
	 *            the view part that owns this action group
	 */
	public NavigateActionGroup(IViewPart part) {
		fOpenEditorActionGroup = new OpenEditorActionGroup(part);
		fOpenViewActionGroup = new OpenViewActionGroup(part);

		// Add by Oliver. Get the toolkit for SearchActionGroup action group.
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null && page.getActiveEditor() != null) {
			IEditorPart editorPart = page.getActiveEditor();
			if (editorPart instanceof ScriptEditor) {
				fSearchActionGroup = new SearchActionGroup(part,
						((ScriptEditor) editorPart).getLanguageToolkit());
			}

		}
	}

	/**
	 * Returns the open action managed by this action group.
	 * 
	 * @return the open action. Returns <code>null</code> if the group doesn't
	 *         provide any open action
	 */
	public IAction getOpenAction() {
		return fOpenEditorActionGroup.getOpenAction();
	}

	/*
	 * (non-Javadoc) Method declared in ActionGroup
	 */
	public void dispose() {
		super.dispose();
		fOpenEditorActionGroup.dispose();
		fOpenViewActionGroup.dispose();
		if (fSearchActionGroup != null)
			fSearchActionGroup.dispose();
	}

	/*
	 * (non-Javadoc) Method declared in ActionGroup
	 */
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		fOpenEditorActionGroup.fillActionBars(actionBars);
		fOpenViewActionGroup.fillActionBars(actionBars);
	}

	/*
	 * (non-Javadoc) Method declared in ActionGroup
	 */
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);

		fOpenEditorActionGroup.fillContextMenu(menu);
		fOpenViewActionGroup.fillContextMenu(menu);
		if (fSearchActionGroup != null) {
			fSearchActionGroup.fillContextMenu(menu);
		}
	}

	/*
	 * (non-Javadoc) Method declared in ActionGroup
	 */
	public void setContext(ActionContext context) {
		super.setContext(context);
		fOpenEditorActionGroup.setContext(context);
		fOpenViewActionGroup.setContext(context);
		if (fSearchActionGroup != null) {
			fSearchActionGroup.setContext(context);
		}
	}

	/*
	 * (non-Javadoc) Method declared in ActionGroup
	 */
	public void updateActionBars() {
		super.updateActionBars();
		fOpenEditorActionGroup.updateActionBars();
		fOpenViewActionGroup.updateActionBars();
	}
}