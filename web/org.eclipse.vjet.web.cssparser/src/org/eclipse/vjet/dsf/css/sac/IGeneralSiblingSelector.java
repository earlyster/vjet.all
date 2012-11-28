/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.sac;

public interface IGeneralSiblingSelector extends ISelector {

	short ANY_NODE = 202;
    
	short getNodeType();
    
	ISelector getSelector();
    
	ISimpleSelector getSiblingSelector();
}
