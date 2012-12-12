/*******************************************************************************
 * Copyright (c) 2008 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.mod.validators.internal.ui.popup.actions;

import java.util.Arrays;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.validators.core.IValidatorOutput;
import org.eclipse.dltk.mod.validators.core.ValidatorRuntime;
import org.eclipse.dltk.mod.validators.internal.ui.ValidatorsUI;
import org.eclipse.dltk.mod.validators.ui.AbstractConsoleValidateJob;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;

public class ValidateAllAction extends Action {

	private final IStructuredSelection selection;

	/**
	 * @param element
	 */
	public ValidateAllAction(IStructuredSelection selection) {
		this.selection = selection;
		setText(Messages.DLTKValidatorsEditorContextMenu_validateAll);
		setImageDescriptor(ValidatorsUI.getDefault().getImageDescriptor(
				ValidateAction.VALIDATE_IMAGE));
	}

	public void run() {
		final AbstractConsoleValidateJob delegate = new AbstractConsoleValidateJob(
				Messages.ValidateSelectionWithConsoleAction_validation) {

			protected boolean isConsoleRequired() {
				return false;
			}

			protected void invokeValidationFor(IValidatorOutput out,
					IScriptProject project, ISourceModule[] modules,
					IResource[] resources, IProgressMonitor monitor) {
				// TODO create sub monitors
				ValidatorRuntime.executeSourceModuleValidators(project, Arrays
						.asList(modules), out, ValidatorRuntime.ALL, monitor);
				ValidatorRuntime.executeResourceValidators(project, Arrays
						.asList(resources), out, ValidatorRuntime.ALL, monitor);
			}
		};
		delegate.run(selection.toArray());
	}

}
