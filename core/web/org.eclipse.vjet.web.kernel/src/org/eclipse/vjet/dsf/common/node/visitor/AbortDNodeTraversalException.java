/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.node.visitor;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
/**
 * A subtype of <code>DsfRuntimeException</code> which is thrown when encounter
 * DOM tree traversal error.
 * 
 */
public class AbortDNodeTraversalException extends DsfRuntimeException {

	private static final long serialVersionUID = 1L;

	public AbortDNodeTraversalException(final String message) {
		super(message) ;
	}

	public AbortDNodeTraversalException(
		final String message, final Object[] args)
	{
		super(message, args);
	}
		
	public AbortDNodeTraversalException(
		final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public AbortDNodeTraversalException(
		final String message, final Object[] args, final Throwable cause)
	{
		super(message, args, cause);
	}
}
