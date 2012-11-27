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
package org.eclipse.dltk.mod.formatter;

import org.eclipse.jface.text.IRegion;

public interface IFormatterDocument {

	String getText();

	int getLength();

	/**
	 * @param startOffset
	 * @param endOffset
	 * @return
	 */
	String get(int startOffset, int endOffset);

	/**
	 * @param region
	 * @return
	 */
	String get(IRegion region);

	/**
	 * @param key
	 * @return
	 */
	boolean getBoolean(String key);

	int getInt(String key);

	char charAt(int start);

}
