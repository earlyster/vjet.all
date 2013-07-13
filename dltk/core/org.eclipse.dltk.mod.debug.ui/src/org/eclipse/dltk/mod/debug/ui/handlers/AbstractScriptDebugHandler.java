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
package org.eclipse.dltk.mod.debug.ui.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.dltk.mod.debug.ui.DLTKDebugUILanguageManager;
import org.eclipse.dltk.mod.debug.ui.IDLTKDebugUILanguageToolkit;
import org.eclipse.dltk.mod.ui.DLTKExecuteExtensionHelper;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

public abstract class AbstractScriptDebugHandler extends AbstractHandler
		implements IExecutableExtension, IElementUpdater {

	private String natureId;

	public final Object execute(ExecutionEvent event) throws ExecutionException {
		Object result = handleEvent(event);

		if (requiresRefresh()) {
			refresh(event);
		}

		return result;
	}

	public final void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) {
		natureId = DLTKExecuteExtensionHelper.getNatureId(config, propertyName,
				data);
	}

	public void updateElement(UIElement element, Map parameters) {
		// default does nothing
	}

	protected final IDLTKDebugUILanguageToolkit getToolkit() {
		return DLTKDebugUILanguageManager.getLanguageToolkit(natureId);
	}

	protected abstract Object handleEvent(ExecutionEvent event)
			throws ExecutionException;

	protected boolean requiresRefresh() {
		return true;
	}

	private void refresh(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		ICommandService service = (ICommandService) window
				.getService(ICommandService.class);
		service.refreshElements(event.getCommand().getId(), null);
	}

}
