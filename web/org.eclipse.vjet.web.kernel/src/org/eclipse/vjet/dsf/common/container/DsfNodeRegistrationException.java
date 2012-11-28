/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.container;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

/**
 * This exception should be thrown if a component can not be registered.
 */
public class DsfNodeRegistrationException extends DsfRuntimeException {
	private static final long serialVersionUID = 1L;

	public DsfNodeRegistrationException(final String message) {
		super(message) ;
	}

	public DsfNodeRegistrationException(
		final String message, final Object[] args)
	{
		super(message, args);
	}
		
	public DsfNodeRegistrationException(
		final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public DsfNodeRegistrationException(
		final String message, final Object[] args, final Throwable cause)
	{
		super(message, args, cause);
	}
}
