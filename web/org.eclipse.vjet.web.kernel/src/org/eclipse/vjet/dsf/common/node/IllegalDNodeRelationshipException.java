/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.node;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

/**
 * This exception is thrown during a 
 */
public class IllegalDNodeRelationshipException extends DsfRuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalDNodeRelationshipException(final String message) {
		super(message) ;
	}

	public IllegalDNodeRelationshipException(
		final String message, final Object[] args)
	{
		super(message, args);
	}
		
	public IllegalDNodeRelationshipException(
		final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public IllegalDNodeRelationshipException(
		final String message, final Object[] args, final Throwable cause)
	{
		super(message, args, cause);
	}
}
