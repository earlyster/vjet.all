/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.core.search;

import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.core.search.TypeNameMatch;

/**
 * DLTK Search concrete type for a type name match.
 * 
 */
public class DLTKSearchTypeNameMatch extends TypeNameMatch {

	private IType type;
	private int modifiers = -1; // store modifiers to avoid java model
								// population

	/**
	 * Creates a new Java Search type name match.
	 */
	public DLTKSearchTypeNameMatch(IType type, int modifiers) {
		this.type = type;
		this.modifiers = modifiers;
	}

	/*
	 * (non-Javadoc) Returns whether the matched type is equals to the given
	 * object or not.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true; // avoid unnecessary calls for identical objects
		if (obj instanceof TypeNameMatch) {
			TypeNameMatch match = (TypeNameMatch) obj;
			if (this.type == null) {
				return match.getType() == null
						&& match.getModifiers() == this.modifiers;
			}
			return this.type.equals(match.getType())
					&& match.getModifiers() == this.modifiers;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jdt.core.search.TypeNameMatch#getModifiers()
	 */
	public int getModifiers() {
		return this.modifiers;
	}

	/*
	 * (non-Javadoc) Note that returned handle exists as it matches a type
	 * accepted from up-to-date index file.
	 * 
	 * @see org.eclipse.jdt.core.search.TypeNameMatch#getType()
	 */
	public IType getType() {
		return this.type;
	}

	/*
	 * (non-Javadoc) Returns the hash code of the matched type.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (this.type == null)
			return this.modifiers;
		return this.type.hashCode();
	}

	/**
	 * Set modifiers of the matched type.
	 * 
	 * @param modifiers
	 *            the modifiers of the matched type.
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}

	/**
	 * Set matched type.
	 * 
	 * @param type
	 *            the matched type.
	 */
	public void setType(IType type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc) Returns the string of the matched type.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (this.type == null)
			return super.toString();
		return this.type.toString();
	}
}
