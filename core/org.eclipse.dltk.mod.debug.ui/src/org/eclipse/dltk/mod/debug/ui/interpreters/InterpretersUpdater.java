/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.debug.ui.interpreters;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.mod.core.environment.EnvironmentManager;
import org.eclipse.dltk.mod.core.environment.IEnvironment;
import org.eclipse.dltk.mod.debug.ui.DLTKDebugUIPlugin;
import org.eclipse.dltk.mod.internal.debug.ui.interpreters.InterpretersMessages;
import org.eclipse.dltk.mod.internal.launching.InterpreterDefinitionsContainer;
import org.eclipse.dltk.mod.launching.IInterpreterInstall;
import org.eclipse.dltk.mod.launching.IInterpreterInstallType;
import org.eclipse.dltk.mod.launching.ScriptRuntime;
import org.eclipse.dltk.mod.launching.ScriptRuntime.DefaultInterpreterEntry;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * Processes add/removed/changed Interpreters.
 */
public class InterpretersUpdater {

	// The interpreters defined when this updated is instantiated
	private InterpreterDefinitionsContainer fOriginalInterpreters;

	/**
	 * Constructs a new Interpreter updater to update Interpreter install
	 * settings.
	 */
	public InterpretersUpdater() {
		saveCurrentAsOriginal();
	}

	private void saveCurrentAsOriginal() {
		fOriginalInterpreters = new InterpreterDefinitionsContainer();

		final DefaultInterpreterEntry[] entries = ScriptRuntime
				.getDefaultInterpreterIDs();
		for (int i = 0; i < entries.length; i++) {
			final DefaultInterpreterEntry entry = entries[i];

			IInterpreterInstall def = ScriptRuntime
					.getDefaultInterpreterInstall(entry);

			if (def != null) {
				fOriginalInterpreters
						.setDefaultInterpreterInstallCompositeID(entry,
								ScriptRuntime
										.getCompositeIdFromInterpreter(def));
			}
		}

		final IInterpreterInstallType[] types = ScriptRuntime
				.getInterpreterInstallTypes();
		for (int i = 0; i < types.length; i++) {
			IInterpreterInstall[] installs = types[i].getInterpreterInstalls();
			if (installs != null) {
				for (int j = 0; j < installs.length; j++) {
					fOriginalInterpreters.addInterpreter(installs[j]);
				}
			}
		}
	}

	/**
	 * Updates Interpreter settings and returns whether the update was
	 * successful.
	 * 
	 * @param interpreters
	 *            new installed InterpreterEnvironments
	 * @param defaultInterpreters
	 *            new default Interpreter
	 * @return whether the update was successful
	 */
	public boolean updateInterpreterSettings(String langNatureId,
			IInterpreterInstall[] interpreters,
			IInterpreterInstall[] defaultInterpreters) {
		// Create a Interpreter definition container
		InterpreterDefinitionsContainer container = new InterpreterDefinitionsContainer();

		// Default interpreter id for natureId
		Set envs = new HashSet();
		if (defaultInterpreters != null) {
			for (int i = 0; i < defaultInterpreters.length; i++) {
				final String defaultId = ScriptRuntime
						.getCompositeIdFromInterpreter(defaultInterpreters[i]);
				IEnvironment environment = defaultInterpreters[i]
						.getEnvironment();
				DefaultInterpreterEntry entry = new DefaultInterpreterEntry(
						langNatureId, environment.getId());
				container.setDefaultInterpreterInstallCompositeID(entry,
						defaultId);
				envs.add(environment);
			}
		}
		IEnvironment[] environments = EnvironmentManager.getEnvironments();
		for (int i = 0; i < environments.length; i++) {
			if (!envs.contains(environments[i])) {
				DefaultInterpreterEntry entry = new DefaultInterpreterEntry(
						langNatureId, environments[i].getId());
				container.setDefaultInterpreterInstallCompositeID(entry, null);
			}
		}
		// container.setDefaultInterpreterInstallCompositeID(langNatureId,
		// null);

		// Interpreters for natureId
		for (int i = 0; i < interpreters.length; i++) {
			container.addInterpreter(interpreters[i]);
		}

		// Default interpreters for other languages
		final DefaultInterpreterEntry[] entries = fOriginalInterpreters
				.getInterpreterNatures();
		for (int i = 0; i < entries.length; i++) {
			final DefaultInterpreterEntry entry = entries[i];
			if (!langNatureId.equals(entry.getNature())) {
				final String defaultId = fOriginalInterpreters
						.getDefaultInterpreterInstallCompositeID(entry);
				container.setDefaultInterpreterInstallCompositeID(entry,
						defaultId);
			}
		}

		// Save interpreters from other languages to the container
		final Iterator it = fOriginalInterpreters.getInterpreterList()
				.iterator();
		while (it.hasNext()) {
			final IInterpreterInstall install = (IInterpreterInstall) it.next();
			if (!langNatureId.equals(install.getInterpreterInstallType()
					.getNatureId())) {
				container.addInterpreter(install);
			}
		}

		// Generate XML for the interpreter definitions and save it as the new
		// value of the Interpreter preference
		saveInterpreterDefinitions(container);

		saveCurrentAsOriginal();

		return true;
	}

	private void saveInterpreterDefinitions(
			final InterpreterDefinitionsContainer container) {
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				try {
					monitor.beginTask(
							InterpretersMessages.InterpretersUpdater_0, 100);
					final String xml = container.getAsXML();
					monitor.worked(40);
					ScriptRuntime.getPreferences().setValue(
							ScriptRuntime.PREF_INTERPRETER_XML, xml);
					monitor.worked(30);
					ScriptRuntime.savePreferences();
					monitor.worked(30);
				} catch (IOException ioe) {
					DLTKDebugUIPlugin.log(ioe);
				} catch (ParserConfigurationException e) {
					DLTKDebugUIPlugin.log(e);
				} catch (TransformerException e) {
					DLTKDebugUIPlugin.log(e);
				} finally {
					monitor.done();
				}

			}
		};
		try {
			DLTKDebugUIPlugin.getDefault().getWorkbench().getProgressService()
					.busyCursorWhile(runnable);
		} catch (InvocationTargetException e) {
			DLTKDebugUIPlugin.log(e);
		} catch (InterruptedException e) {
			DLTKDebugUIPlugin.log(e);
		}
	}
}
