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
package org.eclipse.dltk.mod.debug.ui.launchConfigurations;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.dltk.mod.debug.ui.messages.DLTKLaunchConfigurationsMessages;
import org.eclipse.dltk.mod.internal.launching.LaunchConfigurationUtils;
import org.eclipse.dltk.mod.launching.ScriptLaunchConfigurationConstants;
import org.eclipse.dltk.mod.ui.preferences.FieldValidators;
import org.eclipse.dltk.mod.ui.util.SWTFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public abstract class RemoteLaunchConfigurationTab extends
		ScriptLaunchConfigurationTab {

	private static int DEFAULT_PORT = 10000;
	private static String DEFAULT_IDEKEY = "idekey"; //$NON-NLS-1$

	protected Text port;
	protected Text ideKey;
	protected Text remoteWorkingDir;
	protected Button stripSourceFolders;

	public RemoteLaunchConfigurationTab(String mode) {
		super(mode);
	}

	/*
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return DLTKLaunchConfigurationsMessages.remoteTab_title;
	}

	/*
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
		return DebugUITools.getImage(IDebugUIConstants.IMG_LCL_DISCONNECT);
	}

	/*
	 * @see
	 * org.eclipse.dltk.mod.debug.ui.launchConfigurations.ScriptLaunchConfigurationTab
	 * #doInitializeForm(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	protected void doInitializeForm(ILaunchConfiguration config) {
		port.setText(LaunchConfigurationUtils.getString(config,
				ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_PORT, Integer
						.toString(getDefaultPort())));

		ideKey.setText(LaunchConfigurationUtils.getString(config,
				ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_SESSION_ID,
				getDefaultIDEKey()));

		remoteWorkingDir
				.setText(LaunchConfigurationUtils
						.getString(
								config,
								ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_REMOTE_WORKING_DIR,
								getDefaultRemoteWorkingDir()));
		stripSourceFolders
				.setSelection(LaunchConfigurationUtils
						.getBoolean(
								config,
								ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_STRIP_SOURCE_FOLDERS,
								getDefaultStripSourceFolders()));
	}

	/**
	 * Override this method to configure other default port.
	 */
	protected int getDefaultPort() {
		return DEFAULT_PORT;
	}

	/**
	 * Override this method to configure other default ide key.
	 */
	protected String getDefaultIDEKey() {
		return DEFAULT_IDEKEY;
	}

	/**
	 * Override this method to configure other default remote working dir.
	 */
	protected String getDefaultRemoteWorkingDir() {
		return "";//$NON-NLS-1$
	}

	protected boolean getDefaultStripSourceFolders() {
		return false;
	}

	/*
	 * @see
	 * org.eclipse.dltk.mod.debug.ui.launchConfigurations.ScriptLaunchConfigurationTab
	 * #doPerformApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	protected void doPerformApply(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(
				ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_PORT, port
						.getText().trim());
		config.setAttribute(
				ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_SESSION_ID,
				ideKey.getText().trim());
		config
				.setAttribute(
						ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_REMOTE_WORKING_DIR,
						remoteWorkingDir.getText().trim());
		config
				.setAttribute(
						ScriptLaunchConfigurationConstants.ATTR_DLTK_DBGP_STRIP_SOURCE_FOLDERS,
						stripSourceFolders.getSelection());
	}

	protected boolean validate() {
		return super.validate() && validatePort() && validateIdeKey()
				&& validateRemoteWorkingDir();
	}

	protected boolean validatePort() {
		IStatus result = FieldValidators.PORT_VALIDATOR
				.validate(port.getText());

		if (!result.isOK()) {
			setErrorMessage(result.getMessage());
			return false;
		}

		return true;
	}

	protected boolean validateIdeKey() {
		String key = ideKey.getText().trim();
		if (key.length() == 0) {
			setErrorMessage(DLTKLaunchConfigurationsMessages.remoteError_ideKeyEmpty);
			return false;
		}

		return true;
	}

	protected boolean validateRemoteWorkingDir() {
		// XXX: what validation should be done on this?
		return true;
	}

	/*
	 * @see
	 * org.eclipse.dltk.mod.debug.ui.launchConfigurations.ScriptLaunchConfigurationTab
	 * #doCreateControl(org.eclipse.swt.widgets.Composite)
	 */
	protected void doCreateControl(Composite composite) {
		Group group = SWTFactory
				.createGroup(
						composite,
						DLTKLaunchConfigurationsMessages.remoteTab_connectionProperties,
						2, 1, GridData.FILL_HORIZONTAL);

		SWTFactory.createLabel(group,
				DLTKLaunchConfigurationsMessages.remoteTab_connectionPort, 1);
		port = SWTFactory.createText(group, SWT.BORDER, 1, EMPTY_STRING);
		port.addModifyListener(getWidgetListener());

		SWTFactory.createLabel(group,
				DLTKLaunchConfigurationsMessages.remoteTab_connectionIdeKey, 1);
		ideKey = SWTFactory.createText(group, SWT.BORDER, 1, EMPTY_STRING);
		ideKey.addModifyListener(getWidgetListener());

		SWTFactory.createHorizontalSpacer(composite, 1);

		group = SWTFactory.createGroup(composite,
				DLTKLaunchConfigurationsMessages.remoteTab_remoteSourceMapping,
				1, 1, GridData.FILL_HORIZONTAL);

		SWTFactory.createLabel(group,
				DLTKLaunchConfigurationsMessages.remoteTab_remoteWorkingDir, 1);

		remoteWorkingDir = SWTFactory.createText(group, SWT.BORDER, 1,
				EMPTY_STRING);
		remoteWorkingDir.addModifyListener(getWidgetListener());

		stripSourceFolders = createCheckButton(group,
				DLTKLaunchConfigurationsMessages.remoteTab_scriptSourceFolders);
		stripSourceFolders.addSelectionListener(getWidgetListener());

	}
}
