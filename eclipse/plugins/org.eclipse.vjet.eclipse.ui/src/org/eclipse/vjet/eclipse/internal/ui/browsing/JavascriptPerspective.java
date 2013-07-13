/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     eBay Inc - modification
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.browsing;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.progress.IProgressConstants;

public class JavascriptPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {

		String editorArea = layout.getEditorArea();

		IFolderLayout folder = layout.createFolder(
				"left", IPageLayout.LEFT, (float) 0.2, editorArea); //$NON-NLS-1$

		String navigator = "org.eclipse.dltk.mod.ui.ScriptExplorer";

		folder.addView(navigator);
		folder.addPlaceholder(IPageLayout.ID_BOOKMARKS);

		IFolderLayout outputfolder = layout.createFolder(
				"bottom", IPageLayout.BOTTOM, (float) 0.75, editorArea); //$NON-NLS-1$
		outputfolder.addView(IPageLayout.ID_PROBLEM_VIEW);
		outputfolder.addView(IPageLayout.ID_TASK_LIST);
		outputfolder.addView(IConsoleConstants.ID_CONSOLE_VIEW);

		outputfolder.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);
		outputfolder.addPlaceholder(IPageLayout.ID_BOOKMARKS);
		outputfolder.addPlaceholder(IProgressConstants.PROGRESS_VIEW_ID);

		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, (float) 0.75,
				editorArea);

		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);

		// views - standard workbench
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
		layout.addShowViewShortcut(navigator);
		layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
		layout.addShowViewShortcut(IProgressConstants.PROGRESS_VIEW_ID);
		layout.addShowViewShortcut("org.eclipse.vjet.eclipse.ui.view.scriptUnit");
		layout.addShowViewShortcut("org.eclipse.vjet.eclipse.ui.view.typeSpace");
		layout.addShowViewShortcut("org.eclipse.vjet.eclipse.ui.view.AST");
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);

		// new actions - Javascript project creation wizard
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.VJETProjectWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.JsFileCreation"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.VjoPackageCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.VjoClassCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.VjoInterfaceCreationWizard"); //$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.VjoEnumCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.VjoMixinCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.VjoOTypeCreationWizard");
		layout.addNewWizardShortcut("org.eclipse.vjet.eclipse.ui.NewSourceFolderCreationWizard");

		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");//$NON-NLS-1$
	}
}
