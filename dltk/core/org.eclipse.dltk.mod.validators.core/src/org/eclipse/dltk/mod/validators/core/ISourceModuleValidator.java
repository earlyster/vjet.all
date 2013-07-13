/*******************************************************************************
 * Copyright (c) 2008, 2012 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.mod.validators.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.dltk.mod.core.ISourceModule;

public interface ISourceModuleValidator {

	/**
	 * Validate source modules.
	 * 
	 * @param modules
	 * @param console
	 * @param monitor
	 * @return
	 */
	IStatus validate(ISourceModule[] modules, IValidatorOutput output,
			IProgressMonitor monitor);

	/**
	 * Remove all reported markers.
	 * 
	 * @param module
	 */
	void clean(ISourceModule[] modules);

}
