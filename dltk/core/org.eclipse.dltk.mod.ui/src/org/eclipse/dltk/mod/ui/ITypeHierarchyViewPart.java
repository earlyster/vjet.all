/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.ui;


import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.IType;
import org.eclipse.ui.IViewPart;



/**
 * The standard type hierarchy view presents a type hierarchy for a given input class
 * or interface. Visually, this view consists of a pair of viewers, one showing the type
 * hierarchy, the other showing the members of the type selected in the first.
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 *
 * @see JavaUI#ID_TYPE_HIERARCHY
 */
public interface ITypeHierarchyViewPart extends IViewPart {

	/**
	 * Sets the input element of this type hierarchy view to a type.
	 *
	 * @param type the input element of this type hierarchy view, or <code>null</code>
	 *  to clear any input element
	 * @deprecated use setInputElement instead
	 */
	public void setInput(IType type);
	
	/**
	 * Sets the input element of this type hierarchy view. The following input types are possible
	 * <code>IMember</code> (types, methods, fields..), <code>IPackageFragment</code>, <code>IPackageFragmentRoot</code>
	 * and <code>IJavaProject</code>.
	 *
	 * @param element the input element of this type hierarchy view, or <code>null</code>
	 *  to clear any input
	 * 
	 * @since 2.0
	 */
	public void setInputElement(IModelElement element);	

	/**
	 * Returns the input element of this type hierarchy view.
	 *
	 * @return the input element, or <code>null</code> if no input element is set
	 * @see #setInput(IType)
	 * @deprecated use getInputElement instead
	 */
	public IType getInput();
	

	/**
	 * Returns the input element of this type hierarchy view.
	 *
	 * @return the input element, or <code>null</code> if no input element is set
	 * @see #setInputElement(IJavaElement)
	 * 
	 * @since 2.0
	 */
	public IModelElement getInputElement(); 	
}
