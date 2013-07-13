/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.vjet.eclipse.internal.ui.view.properties;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.eclipse.internal.ui.nodeprinter.INodePrinter;
import org.eclipse.vjet.eclipse.internal.ui.nodeprinter.NodePrinterFactory;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * adapter factory regarding for jst node
 * 
 * 
 *
 */
public class JstNodePropertiesAdapterFactory implements IAdapterFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (!(adaptableObject instanceof IJstNode))
			return null;
		
		INodePrinter nodePrinter = NodePrinterFactory.getNodePrinter((IJstNode)adaptableObject);
		if (nodePrinter != null)
			return new JstNodePropertySourceAdapter((IJstNode)adaptableObject, nodePrinter);
			
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class[] getAdapterList() {
		return new Class[] {IPropertySource.class};
	}

	
}
