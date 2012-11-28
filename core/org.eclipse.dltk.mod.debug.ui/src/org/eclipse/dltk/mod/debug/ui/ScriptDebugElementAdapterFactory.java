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
package org.eclipse.dltk.mod.debug.ui;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider;
import org.eclipse.debug.ui.actions.IWatchExpressionFactoryAdapter;
import org.eclipse.dltk.mod.debug.core.model.IScriptDebugTarget;
import org.eclipse.dltk.mod.debug.core.model.IScriptVariable;
import org.eclipse.dltk.mod.internal.debug.ui.variables.ScriptVariableLabelProvider;
import org.eclipse.dltk.mod.ui.DLTKUILanguageManager;
import org.eclipse.jface.preference.IPreferenceStore;

public class ScriptDebugElementAdapterFactory implements IAdapterFactory {

	private static ScriptDebugElementAdapterFactory instance;
	// assume only 1 plugin installed
	private final HashMap variableLabelProviders = new HashMap(1, 1);

	// private static final IElementLabelProvider fgLPVariable = new
	// ScriptVariableLableProvider();
	// private static final IElementContentProvider fgCPVariable = new
	// JavaVariableContentProvider();
	// private static final IElementLabelProvider fgLPExpression = new
	// ExpressionLabelProvider();
	// private static final IElementContentProvider fgCPExpression = new
	// JavaExpressionContentProvider();

	private static final IWatchExpressionFactoryAdapter watchExpressionFactory = new ScriptWatchExpressionFilter();

	public synchronized static ScriptDebugElementAdapterFactory getInstance() {
		if (instance == null) {
			instance = new ScriptDebugElementAdapterFactory();
		}

		return instance;
	}

	private ScriptDebugElementAdapterFactory() {
		// private constructor
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IElementLabelProvider.class.equals(adapterType)) {
			if (adaptableObject instanceof IScriptVariable) {
				return getVariableLabelProvider((IDebugElement) adaptableObject);
			}
		}
		/*
		 * if (adaptableObject instanceof JavaInspectExpression) { return
		 * fgLPExpression; } }
		 */

		/*
		 * if (IElementContentProvider.class.equals(adapterType)) { if
		 * (adaptableObject instanceof IJavaVariable) { return fgCPVariable; }
		 * if (adaptableObject instanceof JavaInspectExpression) { return
		 * fgCPExpression; } }
		 */

		if (IWatchExpressionFactoryAdapter.class.equals(adapterType)) {
			if (adaptableObject instanceof IScriptVariable) {
				return watchExpressionFactory;
			}
			/*
			 * if (adaptableObject instanceof JavaInspectExpression) { return
			 * fgCPExpression; }
			 */
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { IElementLabelProvider.class,
		// IElementContentProvider.class,
				IWatchExpressionFactoryAdapter.class };
	}

	public void dispose() {
		disposeVariableLabelProviders();
	}

	private void disposeVariableLabelProviders() {
		synchronized (variableLabelProviders) {
			for (Iterator i = variableLabelProviders.values().iterator(); i
					.hasNext();) {
				((ScriptVariableLabelProvider) i.next()).dispose();
			}
			variableLabelProviders.clear();
		}
	}

	private IPreferenceStore getPreferenceStore(IDebugElement element) {
		String natureId = ((IScriptDebugTarget) element.getDebugTarget())
				.getLanguageToolkit().getNatureId();
		return DLTKUILanguageManager.getLanguageToolkit(natureId)
				.getPreferenceStore();
	}

	private Object getVariableLabelProvider(IDebugElement toAdapt) {
		final String id = toAdapt.getModelIdentifier();
		Object provider;
		synchronized (variableLabelProviders) {
			provider = variableLabelProviders.get(id);
			if (provider == null) {
				provider = new ScriptVariableLabelProvider(
						getPreferenceStore(toAdapt));
				variableLabelProviders.put(id, provider);
			}
		}
		return provider;
	}
}
