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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.dltk.mod.debug.ui.IDLTKDebugUILanguageToolkit;
import org.eclipse.dltk.mod.ui.util.SWTFactory;

/**
 * Handler for the 'preferences' menu option in the 'Variables' view.
 * 
 * <p>
 * Use the following from with your <code>plugin.xml</code> to add:
 * </p>
 * 
 * <pre>
 * &lt;extension point=&quot;org.eclipse.ui.commands&quot;&gt;
 *     &lt;command
 *       id=&quot;command_id&quot;
 *       description=&quot;...&quot;
 *       name=&quot;...&quot; /&gt;      
 * &lt;/extension&gt;
 * 
 * &lt;extension point=&quot;org.eclipse.ui.menus&quot;&gt;
 *   &lt;menuContribution locationURI=&quot;menu:org.eclipse.debug.ui.VariableView&quot;&gt;
 *     &lt;menu
 *       label=&quot;...&quot;
 *       id=&quot;org.perlipse.debug.ui.menu.VariableView&quot; /&gt;
 *   &lt;/menuContribution&gt;
 *   &lt;menuContribution locationURI=&quot;menu:menu_id&quot;&gt;
 *         &lt;command
 *       commandId=&quot;command_id&quot; /&gt;              
 *   &lt;/menuContribution&gt;  
 * &lt;/extension&gt;
 * 
 * &lt;extension point=&quot;org.eclipse.ui.handlers&quot;&gt;
 *   &lt;handler
 *     commandId=&quot;command_id&quot;
 *     class=&quot;org.eclipse.dltk.mod.debug.ui.handlers.VariablesViewOptionsHandler:nature_id&quot; /&gt;
 * &lt;/extension&gt;
 * </pre>
 * 
 * @see IDLTKDebugUILanguageToolkit#getVariablesViewPreferencePages()
 */
public class VariablesViewOptionsHandler extends AbstractScriptDebugHandler {

	protected Object handleEvent(ExecutionEvent event) {
		String[] prefPages = getToolkit().getVariablesViewPreferencePages();

		SWTFactory.showPreferencePage(prefPages[0], prefPages);

		return null;
	}

	protected boolean requiresRefresh() {
		return false;
	}

}
