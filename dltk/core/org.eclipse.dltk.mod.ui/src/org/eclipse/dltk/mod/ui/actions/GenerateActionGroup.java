/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.dltk.mod.ui.actions;

import org.eclipse.dltk.mod.internal.ui.actions.DLTKQuickMenuAction;
import org.eclipse.dltk.mod.internal.ui.editor.ScriptEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IUpdate;

/**
 * Action group that adds the source and generate actions to a part's context
 * menu and installs handlers for the corresponding global menu actions.
 */
public class GenerateActionGroup extends ActionGroup {

	/**
	 * Pop-up menu: id of the source sub menu (value
	 * <code>org.eclipse.dltk.mod.ui.source.menu</code>).
	 */
	public static final String MENU_ID = "org.eclipse.dltk.mod.ui.source.menu"; //$NON-NLS-1$

	/**
	 * Pop-up menu: id of the generate group of the source sub menu (value
	 * <code>generateGroup</code>).
	 */
	public static final String GROUP_GENERATE = "generateGroup"; //$NON-NLS-1$

	/**
	 * Pop-up menu: id of the code group of the source sub menu (value
	 * <code>codeGroup</code>).
	 */
	public static final String GROUP_CODE = "codeGroup"; //$NON-NLS-1$

	/**
	 * Pop-up menu: id of the externalize group of the source sub menu (value
	 * <code>externalizeGroup</code>).
	 */
	public static final String GROUP_EXTERNALIZE = "externalizeGroup"; //$NON-NLS-1$

	/**
	 * Pop-up menu: id of the comment group of the source sub menu (value
	 * <code>commentGroup</code>).
	 */
	public static final String GROUP_COMMENT = "commentGroup"; //$NON-NLS-1$

	/**
	 * Pop-up menu: id of the edit group of the source sub menu (value
	 * <code>editGroup</code>).
	 */
	public static final String GROUP_EDIT = "editGroup"; //$NON-NLS-1$

	private ScriptEditor fEditor;
	private IWorkbenchSite fSite;
	private final String fGroupName;

	private static final String QUICK_MENU_ID = "org.eclipse.dltk.mod.ui.edit.text.java.source.quickMenu"; //$NON-NLS-1$

	private class SourceQuickAccessAction extends DLTKQuickMenuAction {
		public SourceQuickAccessAction(ScriptEditor editor) {
			super(editor, QUICK_MENU_ID);
		}

		protected void fillMenu(IMenuManager menu) {
			fillQuickMenu(menu);
		}
	}

	private DLTKQuickMenuAction fQuickAccessAction;
	private IHandlerActivation fQuickAccessHandlerActivation;
	private IHandlerService fHandlerService;

	/**
	 * Note: This constructor is for internal use only. Clients should not call
	 * this constructor.
	 * 
	 * @param editor
	 *            the script editor
	 * @param groupName
	 *            the group name to add the action to
	 */
	public GenerateActionGroup(ScriptEditor editor, String groupName) {
		fSite = editor.getSite();
		fEditor = editor;
		fGroupName = groupName;

		installQuickAccessAction();
	}

	private FormatAction formatAction;

	public GenerateActionGroup(IViewPart part, String groupName) {
		fSite = part.getSite();
		fGroupName = groupName;
		formatAction = new FormatAction(fSite);
		installQuickAccessAction();
	}

	public GenerateActionGroup(Page page, String groupName) {
		fSite = page.getSite();
		fGroupName = groupName;
		formatAction = new FormatAction(fSite);
		installQuickAccessAction();
	}

	private void installQuickAccessAction() {
		fHandlerService = (IHandlerService) fSite
				.getService(IHandlerService.class);
		if (fHandlerService != null) {
			fQuickAccessAction = new SourceQuickAccessAction(fEditor);
			fQuickAccessHandlerActivation = fHandlerService.activateHandler(
					fQuickAccessAction.getActionDefinitionId(),
					new ActionHandler(fQuickAccessAction));
		}
	}

	public void fillActionBars(IActionBars actionBar) {
		super.fillActionBars(actionBar);
		if (fEditor != null) {
			setGlobalActionHandlers(actionBar);
		} else {
			// actionBar.setGlobalActionHandler(DLTKActionConstants.FORMAT,
			// formatAction);
		}
	}

	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		String menuText = "Source"; //$NON-NLS-1$
		if (fQuickAccessAction != null) {
			menuText = fQuickAccessAction.addShortcut(menuText);
		}
		IMenuManager subMenu = new MenuManager(menuText, MENU_ID);
		int added = 0;
		if (isEditorOwner()) {
			added = fillEditorSubMenu(subMenu);
		} else {
			added = fillViewSubMenu(subMenu);
		}
		if (added > 0)
			menu.appendToGroup(fGroupName, subMenu);
	}

	private void fillQuickMenu(IMenuManager menu) {
		if (isEditorOwner()) {
			fillEditorSubMenu(menu);
		} else {
			fillViewSubMenu(menu);
		}
	}

	private int fillEditorSubMenu(IMenuManager source) {
		int added = 0;
		source.add(new Separator(GROUP_COMMENT));
		added += addEditorAction(source, DLTKActionConstants.ADD_BLOCK_COMMENT);
		added += addEditorAction(source,
				DLTKActionConstants.REMOVE_BLOCK_COMMENT);
		added += addEditorAction(source, DLTKActionConstants.TOGGLE_COMMENT);
		added += addEditorAction(source, DLTKActionConstants.COMMENT);
		added += addEditorAction(source, DLTKActionConstants.UNCOMMENT);
		source.add(new Separator(GROUP_EDIT));
		added += addEditorAction(source, DLTKActionConstants.FORMAT);
		added += addEditorAction(source, DLTKActionConstants.FORMAT_ELEMENT);
		added += addEditorAction(source, DLTKActionConstants.INDENT);
		source.add(new Separator(GROUP_GENERATE));
		source.add(new Separator(GROUP_CODE));
		source.add(new Separator(GROUP_EXTERNALIZE));
		return added;
	}

	private int fillViewSubMenu(IMenuManager source) {
		// TODO Disable menus
		// source.add(formatAction);
		// return 1;
		return 0;
	}

	/*
	 * (non-Javadoc) Method declared in ActionGroup
	 */
	public void dispose() {
		if (fQuickAccessHandlerActivation != null && fHandlerService != null) {
			fHandlerService.deactivateHandler(fQuickAccessHandlerActivation);
		}
		fEditor = null;
		super.dispose();
	}

	private void setGlobalActionHandlers(IActionBars bars) {
		bars.setGlobalActionHandler(DLTKActionConstants.COMMENT, getAction(
				fEditor, DLTKActionConstants.COMMENT));
		bars.setGlobalActionHandler(DLTKActionConstants.UNCOMMENT, getAction(
				fEditor, DLTKActionConstants.UNCOMMENT));
		bars.setGlobalActionHandler(DLTKActionConstants.TOGGLE_COMMENT,
				getAction(fEditor, DLTKActionConstants.TOGGLE_COMMENT));
		bars.setGlobalActionHandler(DLTKActionConstants.ADD_BLOCK_COMMENT,
				getAction(fEditor, DLTKActionConstants.ADD_BLOCK_COMMENT));
		bars.setGlobalActionHandler(DLTKActionConstants.REMOVE_BLOCK_COMMENT,
				getAction(fEditor, DLTKActionConstants.REMOVE_BLOCK_COMMENT));
		bars.setGlobalActionHandler(DLTKActionConstants.FORMAT, getAction(
				fEditor, DLTKActionConstants.FORMAT));
		bars.setGlobalActionHandler(DLTKActionConstants.FORMAT_ELEMENT,
				getAction(fEditor, DLTKActionConstants.FORMAT_ELEMENT));
		bars.setGlobalActionHandler(DLTKActionConstants.INDENT, getAction(
				fEditor, DLTKActionConstants.INDENT));
		bars.updateActionBars();
	}

	protected final IAction getAction(ITextEditor editor, String actionId) {
		return (editor == null || actionId == null ? null : editor
				.getAction(actionId));
	}

	protected int addAction(IMenuManager menu, String groupName, IAction action) {
		if (action != null && action.isEnabled()) {
			menu.appendToGroup(groupName, action);
			return 1;
		}
		return 0;
	}

	protected int addEditorAction(IMenuManager menu, String groupName,
			String actionID) {
		if (fEditor == null)
			return 0;
		IAction action = fEditor.getAction(actionID);
		if (action == null)
			return 0;
		if (action instanceof IUpdate)
			((IUpdate) action).update();
		if (action.isEnabled()) {
			menu.appendToGroup(groupName, action);
			return 1;
		}
		return 0;
	}

	private int addEditorAction(IMenuManager menu, String actionID) {
		if (fEditor == null)
			return 0;
		IAction action = fEditor.getAction(actionID);
		if (action == null)
			return 0;
		if (action instanceof IUpdate)
			((IUpdate) action).update();
		if (action.isEnabled()) {
			menu.add(action);
			return 1;
		}
		return 0;
	}

	private boolean isEditorOwner() {
		return fEditor != null;
	}
}
