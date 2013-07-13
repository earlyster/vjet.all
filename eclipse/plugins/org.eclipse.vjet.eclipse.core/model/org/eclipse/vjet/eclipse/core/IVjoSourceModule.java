/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.ts.type.TypeName;
import org.eclipse.dltk.mod.core.ISourceModule;

/**
 * Interface to describe VJO related module
 * 
 *
 */
public interface IVjoSourceModule extends ISourceModule, org.eclipse.dltk.mod.compiler.env.ISourceModule{
	/**
	 * @return JstType
	 */
	IJstType getJstType();

	/**
	 * Return the type name in the DSF back end style
	 * @return
	 */
	TypeName getTypeName();
}