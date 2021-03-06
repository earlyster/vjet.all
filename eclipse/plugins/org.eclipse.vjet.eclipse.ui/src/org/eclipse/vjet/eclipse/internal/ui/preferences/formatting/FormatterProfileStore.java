/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.vjet.eclipse.internal.ui.preferences.formatting;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;

import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.internal.ui.preferences.PreferencesAccess;
import org.eclipse.vjet.eclipse.internal.ui.preferences.formatting.ProfileManager.CustomProfile;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.xml.sax.InputSource;




public class FormatterProfileStore extends ProfileStore {

	/**
	 * Preference key where all profiles are stored
	 */
	private static final String PREF_FORMATTER_PROFILES= "org.eclipse.vjet.ui.formatterprofiles"; //$NON-NLS-1$
	
	private final IProfileVersioner fProfileVersioner;
		
	public FormatterProfileStore(IProfileVersioner profileVersioner) {
		super(PREF_FORMATTER_PROFILES, profileVersioner);
		fProfileVersioner= profileVersioner;
	}	
	
	/**
	 * {@inheritDoc}
	 */
	public List readProfiles(IScopeContext scope) throws CoreException {
	    List profiles= super.readProfiles(scope);
	    if (profiles == null) {
			profiles= readOldForCompatibility(scope);
		}
	    return profiles;
	}

	/**
	 * Read the available profiles from the internal XML file and return them
	 * as collection.
	 * @return returns a list of <code>CustomProfile</code> or <code>null</code>
	 */
	private List readOldForCompatibility(IScopeContext instanceScope) {
		
		// in 3.0 M9 and less the profiles were stored in a file in the plugin's meta data
		final String STORE_FILE= "code_formatter_profiles.xml"; //$NON-NLS-1$

		File file= VjetPlugin.getDefault().getStateLocation().append(STORE_FILE).toFile();
		if (!file.exists())
			return null;
		
		try {
			// note that it's wrong to use a file reader when XML declares UTF-8: Kept for compatibility
			final FileReader reader= new FileReader(file);
			try {
				List res= readProfilesFromStream(new InputSource(reader));
				if (res != null) {
					for (int i= 0; i < res.size(); i++) {
						fProfileVersioner.update((CustomProfile) res.get(i));
					}
					writeProfiles(res, instanceScope);
				}
				file.delete(); // remove after successful write
				return res;
			} finally {
				reader.close();
			}
		} catch (CoreException e) {
			VjetUIPlugin.log(e); // log but ignore
		} catch (IOException e) {
			VjetUIPlugin.log(e); // log but ignore
		}
		return null;
	}
	
	
	public static void checkCurrentOptionsVersion() {
		PreferencesAccess access= PreferencesAccess.getOriginalPreferences();
		ProfileVersioner profileVersioner= new ProfileVersioner();
		
		IScopeContext instanceScope= access.getInstanceScope();
		IEclipsePreferences uiPreferences= instanceScope.getNode(VjetUIPlugin.PLUGIN_ID);
		int version= uiPreferences.getInt(PREF_FORMATTER_PROFILES + VERSION_KEY_SUFFIX, 0);
		if (version >= profileVersioner.getCurrentVersion()) {
			return; // is up to date
		}
		try {
			List profiles= (new FormatterProfileStore(profileVersioner)).readProfiles(instanceScope);
			if (profiles == null) {
				profiles= new ArrayList();
			}
			ProfileManager manager= new FormatterProfileManager(profiles, instanceScope, access, profileVersioner);
//			if (manager.getSelected() instanceof CustomProfile) {
				manager.commitChanges(instanceScope); // updates JavaScriptCore options
//			}
			uiPreferences.putInt(PREF_FORMATTER_PROFILES + VERSION_KEY_SUFFIX, profileVersioner.getCurrentVersion());
			savePreferences(instanceScope);
						
			IProject[] projects= ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (int i= 0; i < projects.length; i++) {
				IScopeContext scope= access.getProjectScope(projects[i]);
				if (manager.hasProjectSpecificSettings(scope)) {
					manager= new FormatterProfileManager(profiles, scope, access, profileVersioner);
					manager.commitChanges(scope); // updates JavaScriptCore project options
					savePreferences(scope);
				}
			}
		} catch (CoreException e) {
			VjetUIPlugin.log(e);
		} catch (BackingStoreException e) {
			VjetUIPlugin.log(e);
		}
	}
	
	private static void savePreferences(final IScopeContext context) throws BackingStoreException {
		try {
			context.getNode(VjetUIPlugin.PLUGIN_ID).flush();
		} finally {
			context.getNode(VjetPlugin.PLUGIN_ID).flush();
		}
	}
}
