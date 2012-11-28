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

import java.io.OutputStream;

/**
 * The instance of the object to send {@link IValidatorWorker} output to.
 */
public interface IValidatorOutput {

	/**
	 * Checks if output is enabled.
	 * 
	 * @return <code>true</code> if this object is operational or
	 *         <code>false</code> if not.
	 */
	boolean isEnabled();

	/**
	 * Checks error state.
	 * 
	 * @return <code>true</code> if this object has encountered an error
	 */
	boolean checkError();

	/**
	 * Returns output stream to send validator output to.
	 * 
	 * @return
	 */
	OutputStream getStream();

	/**
	 * Prints the specified line to the output or do nothing if this instance is
	 * not enabled.
	 * 
	 * @param x
	 */
	void println(String x);

	/**
	 * Closes this instance.
	 */
	void close();

}
