/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.dltk.mod.internal.ui;


import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.jface.viewers.IBasicPropertyConstants;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class ScriptElementProperties implements IPropertySource {
	
	private IModelElement fSource;
	
	// Property Descriptors
	private static final IPropertyDescriptor[] fgPropertyDescriptors= new IPropertyDescriptor[1];
	static {
		PropertyDescriptor descriptor;

		// resource name
		descriptor= new PropertyDescriptor(IBasicPropertyConstants.P_TEXT, DLTKUIMessages.ScriptElementProperties_name); 
		descriptor.setAlwaysIncompatible(true);
		fgPropertyDescriptors[0]= descriptor;
	}
	
	public ScriptElementProperties(IModelElement source) {
		fSource= source;
	}
	
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return fgPropertyDescriptors;
	}
	
	public Object getPropertyValue(Object name) {
		if (name.equals(IBasicPropertyConstants.P_TEXT)) {
			return fSource.getElementName();
		}
		return null;
	}
	
	public void setPropertyValue(Object name, Object value) {
	}
	
	public Object getEditableValue() {
		return this;
	}
	
	public boolean isPropertySet(Object property) {
		return false;
	}
	
	public void resetPropertyValue(Object property) {
	}
}
