/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and Implementation
 *    eBay Inc. - Modification
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.wizards;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.ui.DLTKPluginImages;

public class VjoNewSourceFolderCreationWizard extends VjoNewElementWizard {

	private VjoNewSourceFolderWizardPage fPage;

	public VjoNewSourceFolderCreationWizard() {
		super();
		setDefaultPageImageDescriptor(DLTKPluginImages.DESC_WIZBAN_NEWSRCFOLDR);
		// setDialogSettings(DLTKUIPlugin.getDefault().getDialogSettings());
		setWindowTitle(VjetWizardMessages.NewSourceFolderCreationWizard_title);
	}

	public void addPages() {
		super.addPages();
		fPage = new VjoNewSourceFolderWizardPage();
		addPage(fPage);
		fPage.init(getSelection());
	}

	protected void finishPage(IProgressMonitor monitor)
			throws InterruptedException, CoreException {
		fPage.createProjectFragment(monitor); // use the full progress monitor
	}

	public boolean performFinish() {
		boolean res = super.performFinish();
		if (res) {
			selectAndReveal(fPage.getCorrespondingResource());
		}
		return res;
	}

	public IModelElement getCreatedElement() {
		return fPage.getNewProjectFragment();
	}
}
