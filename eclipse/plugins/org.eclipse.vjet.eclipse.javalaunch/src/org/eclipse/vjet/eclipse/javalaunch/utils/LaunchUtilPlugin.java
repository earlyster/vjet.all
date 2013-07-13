/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.eclipse.javalaunch.utils;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;



public class LaunchUtilPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.vjet.javalaunch"; //$NON-NLS-1$


	
	public static final String CONFIGURE_SOURCE_PATH_ENABLED = "ConfigureSourcePath"; 
	
	  // The shared instance. Since start will be called only once in OSGi, we can
    // simply hang on to this reference.
     private static LaunchUtilPlugin plugin = null;

     /**
      * Returns the shared instance of this class.
      * 
      * @return the shared instance
      */
      public static synchronized LaunchUtilPlugin getDefault() {
          return plugin;
     }

	
	
	public static boolean getConfigureSourcePathEnabled() {
		boolean boolean1 = LaunchUtilPlugin.getDefault().getPreferenceStore()
		.getBoolean(LaunchUtilPlugin.CONFIGURE_SOURCE_PATH_ENABLED);
		return boolean1;
		
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}



	

	
}
