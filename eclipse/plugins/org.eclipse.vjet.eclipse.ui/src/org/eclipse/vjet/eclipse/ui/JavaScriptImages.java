/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.ui;

import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.mod.ui.PluginImagesHelper;
import org.eclipse.jface.resource.ImageDescriptor;

public class JavaScriptImages {
	private static final PluginImagesHelper helper = new PluginImagesHelper(VjetUIPlugin.getDefault()
			.getBundle(), new Path("/icons/"));

	public static final ImageDescriptor DESC_WIZBAN_PROJECT_CREATION = helper
			.createUnManaged(PluginImagesHelper.T_WIZBAN, "newjscriptfile_wiz.gif");
}
