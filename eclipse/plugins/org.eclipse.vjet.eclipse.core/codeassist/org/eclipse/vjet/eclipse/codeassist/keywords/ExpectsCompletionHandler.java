/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.codeassist.keywords;

import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstCompletion;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstExpectsOnTypeCompletion;
import org.eclipse.vjet.eclipse.core.IJSType;
import org.eclipse.vjet.vjo.tool.typespace.TypeSpaceMgr;
import org.eclipse.dltk.mod.compiler.env.ISourceModule;
import org.eclipse.dltk.mod.core.CompletionProposal;
import org.eclipse.dltk.mod.core.DLTKCore;
import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.core.ModelException;

/**
 * Provides package/type completion proposals inside "expects" block
 * 
 * 
 */
public class ExpectsCompletionHandler extends BaseCompletionHandler {
	public void complete(ISourceModule module, int position,
			JstCompletion completion, List<CompletionProposal> list) {
		super.complete(module, position, completion, list);
	}

	public Class getCompletionClass() {
		return JstExpectsOnTypeCompletion.class;
	}

	@Override
	protected boolean checkType(IType type, IType currentType) {
		try {
			//TODO check correct if type is module
			String name = type.getFullyQualifiedName().replace('/', '.');
			String groupName = type.getScriptProject().getElementName();
			
			IJstType jstType = TypeSpaceMgr.findType(groupName, name);
			
			if (!(type instanceof IJSType) || !((IJSType) type).isInterface())
				return false;
			
			if(jstType == null ||  jstType.isMixin())
				return false;
			
		} catch (ModelException e) {
			DLTKCore.error(e.toString(), e);
		}
		return super.checkType(type, currentType);
	}
}
