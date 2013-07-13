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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


 public class VMParameterPage extends FieldEditorPreferencePage implements
         IWorkbenchPreferencePage {


     public VMParameterPage() {
         super(FieldEditorPreferencePage.GRID);
         setPreferenceStore(LaunchUtilPlugin.getDefault()
                .getPreferenceStore());
         setDescription("VM Launch Parameters");

    }

    /**
     * Initialize the preference page
     */
     public void init(IWorkbench workbench) {
        // Initialize the preference page
    }

    @Override
     protected void createFieldEditors() {
         addField(new BooleanFieldEditor(LaunchUtilPlugin.CONFIGURE_SOURCE_PATH_ENABLED, "Set vm parameter java.source.path", getFieldEditorParent()));
        
    }

}
