/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.ui.dialogs;

/**
 * A filter to select {@link ITypeInfoRequestor} objects.
 * <p>
 * The interface should be implemented by clients wishing to provide special
 * filtering to the type selection dialog.
 * </p>
 * 
 */
public interface ITypeInfoFilterExtension {
	
	/**
	 * Returns whether the given type makes it into the list or
	 * not.
	 * 
	 * @param typeInfoRequestor the <code>ITypeInfoRequestor</code> to 
	 *  used to access data for the type under inspection
	 * 
	 * @return whether the type is selected or not
	 */
	public boolean select(ITypeInfoRequestor typeInfoRequestor);
	
}
