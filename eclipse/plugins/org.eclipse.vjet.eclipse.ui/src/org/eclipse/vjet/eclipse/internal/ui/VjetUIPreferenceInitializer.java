/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     eBay Inc - Modification
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui;

import org.eclipse.vjet.eclipse.codeassist.compliance.PredefinedBrowsersPreferenceKeys;
import org.eclipse.vjet.eclipse.codeassist.compliance.PredefinedBrowsersPreferenceKeys.IBrowserKey;
import org.eclipse.vjet.eclipse.ui.VjetPreferenceConstants;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.dltk.mod.compiler.task.TodoTaskPreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.editors.text.EditorsUI;

public class VjetUIPreferenceInitializer extends AbstractPreferenceInitializer {

    
    
    public void initializeDefaultPreferences() {
        IPreferenceStore store = VjetUIPlugin.getDefault().getPreferenceStore();

        EditorsUI.useAnnotationsPreferencePage(store);
        EditorsUI.useQuickDiffPreferencePage(store);
        VjetPreferenceConstants.initializeDefaultValues(store);

        // IEclipsePreferences defaultPreferences = ((IScopeContext) new
        // DefaultScope()).getNode(VjetUIPlugin.PLUGIN_ID);

        Preferences pluginPreferences = VjetUIPlugin.getDefault()
                .getPluginPreferences();
        TodoTaskPreferences.initializeDefaultValues(pluginPreferences);
        // initComplianceKeys
        initComplancePreferenceKeys(pluginPreferences);
        
    }



    private void initComplancePreferenceKeys(Preferences pluginPreferences) {
        IBrowserKey[] predefLKeys = PredefinedBrowsersPreferenceKeys
                .getPredefinedKeys();

        for (int iter = 0; iter < predefLKeys.length; iter++) {
            pluginPreferences.setDefault(predefLKeys[iter]
                    .isTargetedBrowserPredefKey(), Boolean.FALSE);
            pluginPreferences.setDefault(predefLKeys[iter]
                    .takeTargetedBrowserVerPredefKey(), Boolean.FALSE);
        }

    }
    
}
