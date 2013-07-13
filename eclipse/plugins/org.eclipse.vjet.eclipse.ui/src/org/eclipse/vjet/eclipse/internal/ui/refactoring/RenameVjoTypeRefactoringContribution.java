/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.refactoring;

import org.eclipse.vjet.eclipse.internal.ui.refactoring.rename.RenameTypeWizard;
import org.eclipse.vjet.eclipse.internal.ui.refactoring.rename.RenameVjoTypeProcessor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.mod.internal.corext.refactoring.rename.ScriptRenameRefactoring;
import org.eclipse.dltk.mod.internal.corext.refactoring.vjet.AbstractVjoRenameRefactoringContribution;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;


/**
 * Refactoring contribution for the rename compilation unit refactoring.
 * 
	 *
 */
public final class RenameVjoTypeRefactoringContribution extends AbstractVjoRenameRefactoringContribution {
	


	@Override
	public RefactoringWizard getRenameWizard() throws CoreException{
		return new RenameTypeWizard(createRefactoring(null));
	}

	@Override
	public Refactoring createNewRefactoring(RefactoringDescriptor descriptor) throws CoreException {
		return new ScriptRenameRefactoring(new RenameVjoTypeProcessor(null));
	}
	
	
	
}
