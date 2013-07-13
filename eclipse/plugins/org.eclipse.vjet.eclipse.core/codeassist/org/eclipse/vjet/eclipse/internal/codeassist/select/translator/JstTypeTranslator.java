/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.vjet.eclipse.internal.codeassist.select.translator;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.eclipse.codeassist.CodeassistUtils;
import org.eclipse.vjet.eclipse.core.IVjoSourceModule;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.IScriptProject;
import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.core.ScriptProject;

/**
 * 
 * 
 */
public class JstTypeTranslator extends DefaultNodeTranslator {

	public IModelElement[] convert(IJstNode jstNode) {
		IJstType jstType = (IJstType) jstNode;
		if (CodeassistUtils.isNativeType(jstType)) {
			IType type= CodeassistUtils.findNativeSourceType(jstType);
			return type != null ? new IModelElement[] { type }
			: new IModelElement[0];
		} else {
			IType rootDLTKType = CodeassistUtils
					.findType(jstType);
			if (rootDLTKType == null)
				return null;

//			IType type = this.getType(rootDLTKType, jstType.getName());
			return rootDLTKType != null ? new IModelElement[] { rootDLTKType }
			: new IModelElement[0];
		}
	}

	@Override
	public IModelElement[] convert(IVjoSourceModule module, IJstNode jstNode) {
		IJstType jstType = (IJstType) jstNode;
		IScriptProject sProject = null;
		if (module != null) {
			sProject = module.getScriptProject();
		}
		IModelElement mElement = null;
		if (sProject != null && (!CodeassistUtils.isNativeType(jstType) // type
																		// in
																		// workspace
				|| CodeassistUtils // type in external source type
						.isBinaryType(jstType))) {
			mElement = CodeassistUtils.findType((ScriptProject) sProject,
					jstType);
		}
		if (mElement == null) {
			IModelElement[] elements = convert(jstNode);
			if(elements!=null && elements.length>0){
				mElement = elements[0];
			}else if(jstNode!=null){
				VjetPlugin.error("could not convert " + jstNode.getClass().getName());
			}
			
		}
		return mElement != null ? new IModelElement[] { mElement }
		: new IModelElement[0];
		
	}

	/**
	 * get corresponding type, including inner type
	 * 
	 * @param rootType
	 * @param dltkTypeName
	 * @return
	 */
	private IType getType(IType rootType, String dltkTypeName) {
		try {
			if (rootType.getFullyQualifiedName(".").equals(dltkTypeName))
				return rootType;
			else {
				IType[] types = rootType.getTypes();
				for (int i = 0; i < types.length; i++) {
					IType type = this.getType(types[i], dltkTypeName);
					if (type != null)
						return type;
				}
			}
		} catch (ModelException e) {
			VjetPlugin.error(e.getLocalizedMessage(), e);
		}
		return null;
	}
}
