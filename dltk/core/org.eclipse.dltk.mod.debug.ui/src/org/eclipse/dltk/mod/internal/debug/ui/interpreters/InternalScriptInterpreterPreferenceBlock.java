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
package org.eclipse.dltk.mod.internal.debug.ui.interpreters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.mod.core.internal.environment.LocalEnvironment;
import org.eclipse.dltk.mod.launching.IInterpreterInstall;
import org.eclipse.dltk.mod.launching.IInterpreterInstallType;
import org.eclipse.dltk.mod.launching.ScriptRuntime;
import org.eclipse.dltk.mod.launching.ScriptRuntime.DefaultInterpreterEntry;
import org.eclipse.dltk.mod.ui.preferences.ComboViewerBlock;
import org.eclipse.dltk.mod.ui.preferences.ImprovedAbstractConfigurationBlock;
import org.eclipse.dltk.mod.ui.preferences.OverlayPreferenceStore;
import org.eclipse.dltk.mod.ui.util.SWTFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * Preference block that can be used to select an installed interpreter for
 * 'internal' editor, etc use.
 */
public abstract class InternalScriptInterpreterPreferenceBlock extends
		ImprovedAbstractConfigurationBlock {

	private ComboViewerBlock viewer;

	public InternalScriptInterpreterPreferenceBlock(
			OverlayPreferenceStore store, PreferencePage page) {
		super(store, page);
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.preferences.IPreferenceConfigurationBlock#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public final Control createControl(Composite parent) {
		Composite composite = SWTFactory.createComposite(parent, parent
				.getFont(), 1, 1, GridData.FILL);

		Group group = SWTFactory.createGroup(composite,
				getSelectorGroupLabel(), 1, 1, GridData.FILL_HORIZONTAL);

		SWTFactory.createLabel(group, getSelectorNameLabel(), 1);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		viewer = new ComboViewerBlock(group, gd) {
			protected String getObjectName(Object element) {
				return ((IInterpreterInstall) element).getName();
			}

			protected void selectedObjectChanged(Object element) {
				setString(getPreferenceKey(), getObjectId(element));
			}

			protected Object getDefaultObject() {
				return getDefaultSelectedInterpreter();
			}

			protected String getObjectId(Object element) {
				return ScriptRuntime
						.getCompositeIdFromInterpreter((IInterpreterInstall) element);
			}

			protected String getSavedObjectId() {
				return getString(getPreferenceKey());
			}

			protected Object getObjectById(String id) {
				return ScriptRuntime.getInterpreterFromCompositeId(id);
			}
		};

		viewer.initialize(getInterpreterInstalls());

		return composite;
	}

	/**
	 * Returns the language's nature id.
	 */
	protected abstract String getNatureId();

	/**
	 * Returns the preference key that will be used to store the interpreter
	 * preference.
	 */
	protected abstract String getPreferenceKey();

	/**
	 * Returns the label that will be used for the selector group.
	 */
	protected abstract String getSelectorGroupLabel();

	/**
	 * Returns the label that will be used for the selector name.
	 */
	protected abstract String getSelectorNameLabel();

	/**
	 * Returns the {@link IInterpreterInstall} that will be auto-selected if an
	 * interpreter id is not found in the preference store.
	 */
	protected Object getDefaultSelectedInterpreter() {
		DefaultInterpreterEntry entry = new DefaultInterpreterEntry(
				getNatureId(), LocalEnvironment.ENVIRONMENT_ID);
		return ScriptRuntime.getDefaultInterpreterInstall(entry);
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.preferences.ImprovedAbstractConfigurationBlock#createOverlayKeys()
	 */
	protected List createOverlayKeys() {
		ArrayList keys = new ArrayList(1);

		keys.add(new OverlayPreferenceStore.OverlayKey(
				OverlayPreferenceStore.STRING, getPreferenceKey()));

		return keys;
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.preferences.ImprovedAbstractConfigurationBlock#performDefaults()
	 */
	public void performDefaults() {
		super.performDefaults();
		viewer.performDefaults();
	}

	private IInterpreterInstall[] getInterpreterInstalls() {
		List interpreters = new ArrayList();
		IInterpreterInstallType[] types = ScriptRuntime
				.getInterpreterInstallTypes(getNatureId());
		for (int i = 0; i < types.length; i++) {
			IInterpreterInstall[] installs = types[i].getInterpreterInstalls();
			for (int j = 0; j < installs.length; j++) {
				interpreters.add(installs[j]);
			}
		}

		return (IInterpreterInstall[]) interpreters
				.toArray(new IInterpreterInstall[interpreters.size()]);
	}
}
