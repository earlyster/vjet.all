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
package org.eclipse.dltk.mod.debug.ui.actions;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.internal.ui.editor.EditorUtility;
import org.eclipse.dltk.mod.internal.ui.editor.ScriptEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;


public class ToggleGlobalVariablesHandler extends AbstractHandler {

	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		IEvaluationContext context = (IEvaluationContext) arg0.getApplicationContext();

			
		Object editor = context.getVariable(ISources.ACTIVE_EDITOR_NAME);
		if (editor instanceof ScriptEditor)
		{
			IEditorInput input =  ((IEditorPart) editor).getEditorInput();
			IScriptProject project = EditorUtility.getScriptProject(input);
			
			
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
