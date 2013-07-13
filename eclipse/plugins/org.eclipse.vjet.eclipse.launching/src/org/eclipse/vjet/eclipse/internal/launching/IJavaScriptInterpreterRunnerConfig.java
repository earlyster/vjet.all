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
package org.eclipse.vjet.eclipse.internal.launching;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.dltk.mod.launching.InterpreterConfig;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.VMRunnerConfiguration;

public interface IJavaScriptInterpreterRunnerConfig {

	/**
	 * 
	 * @param config
	 * @param launch
	 * @param project
	 * @return full name of class that runs javascript file and participates in initiating debugging session.
	 */
	public String getRunnerClassName(InterpreterConfig config, ILaunch launch,IJavaProject project);

	/**
	 * 
	 * @param config
	 * @param launch
	 * @param project
	 * @return computes class path for given arguments 
	 * @throws Exception
	 */
	public String[] computeClassPath(InterpreterConfig config, ILaunch launch,IJavaProject project) throws Exception;

	/**
	 * resolves program arguments
	 * @param config
	 * @param launch
	 * @param project
	 * @return
	 */
	public String[] getProgramArguments(InterpreterConfig config, ILaunch launch,IJavaProject project);

	
	/**
	 * any extra configuration of VMRunnerConfiguration can be done here
	 * @param vconfig
	 * @param iconfig
	 * @param launch
	 * @param project
	 */
	public void adjustRunnerConfiguration(VMRunnerConfiguration vconfig,
			InterpreterConfig iconfig, ILaunch launch,IJavaProject project);
}
