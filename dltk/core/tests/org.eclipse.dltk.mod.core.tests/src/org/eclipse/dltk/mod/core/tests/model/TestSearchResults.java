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
package org.eclipse.dltk.mod.core.tests.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.mod.core.IMethod;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.core.search.SearchMatch;
import org.eclipse.dltk.mod.core.search.SearchRequestor;

public class TestSearchResults extends SearchRequestor {

	public void acceptSearchMatch(SearchMatch match) throws CoreException {
		matches.add(match);
	}

	private List matches = new ArrayList();

	public int size() {
		return matches.size();
	}

	public void assertSourceModule(String name) {
		assertExists(ISourceModule.class, name);
	}

	public void assertType(String name) {
		assertExists(IType.class, name);
	}

	public void assertMethod(String name) {
		assertExists(IMethod.class, name);
	}

	public void assertExists(Class modelElementClass, String modelElementName) {
		if (locate(modelElementClass, modelElementName) == null) {
			Assert.fail("Not found " + modelElementName + ":"
					+ modelElementClass.getName());
		}
	}

	public IModelElement locate(Class modelElementClass, String modelElementName) {
		Assert.assertNotNull(modelElementClass);
		Assert.assertTrue(IModelElement.class
				.isAssignableFrom(modelElementClass));
		for (Iterator i = matches.iterator(); i.hasNext();) {
			final SearchMatch match = (SearchMatch) i.next();
			if (modelElementClass.isAssignableFrom(match.getElement()
					.getClass())) {
				IModelElement element = (IModelElement) match.getElement();
				final String matchName;
				if (element instanceof IType) {
					final IType type = (IType) element;
					// TODO use separator defined for the target language
					matchName = type.getTypeQualifiedName("::");
				} else {
					matchName = element.getElementName();
				}
				if (modelElementName.equals(matchName)) {
					return element;
				}
			}
		}
		return null;
	}

}
