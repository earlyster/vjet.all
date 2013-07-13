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

import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstVars;
import org.eclipse.vjet.eclipse.codeassist.CodeassistUtils;
import org.eclipse.vjet.eclipse.core.IVjoSourceModule;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.internal.codeassist.select.JstNodeDLTKElementResolver;
import org.eclipse.dltk.mod.core.IMember;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.ModelException;


/**
 * JstVars translator
 * 
 * 
 * 
 */
public class JstVarsTranslator extends DefaultNodeTranslator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.vjet.eclipse.internal.codeassist.select.translator.DefaultNodeTranslator#convert(org.eclipse.vjet.dsf.jst.IJstNode)
	 */
	@Override
	public IModelElement[] convert(IVjoSourceModule module, IJstNode node) {
		JstVars jstVars = (JstVars) node;
		if (jstVars.getSource() == null) {
			return null;
		}
		IJstNode declaringBlock = CodeassistUtils.findDeclaringMethod(jstVars);
		if(declaringBlock==null){
			declaringBlock = CodeassistUtils.findDeclaringBlock(jstVars);
		}

		IModelElement element =null;
		IModelElement[] elementFromAry = JstNodeDLTKElementResolver.lookupAndConvert(declaringBlock);
		if(elementFromAry!=null && elementFromAry.length==1){
			element = elementFromAry[0];
		}

		if(declaringBlock instanceof JstMethod){
			IJstMethod jstMethod = (JstMethod)declaringBlock;
			if ( jstMethod!=null  ) {//get the first signature method
				if(!jstMethod.getOverloaded().isEmpty()){
					IModelElement[] convert = JstNodeDLTKElementResolver.convert(module, jstMethod.getOverloaded().get(0));
					if(convert!=null && convert.length>0){
						element = convert[0];
					}
				}else{
					IModelElement[] convert = JstNodeDLTKElementResolver.convert(module, jstMethod);
					if(convert!=null && convert.length>0){
						element = convert[0];
					}
				}
			}
		}
		if (element == null ) {
			return null;
		}
		try {
			IMember dltkMethod = (IMember) element;
			// TODO support selection engine for var x,y,z;
			String localVarName = CodeassistUtils.getFirstVariableName(jstVars);
			IModelElement[] children = dltkMethod.getChildren();
			for (int i = 0; i < children.length; i++) {
				if (IModelElement.FIELD == children[i].getElementType()
						&& children[i].getElementName().equals(localVarName)) {
					return new IModelElement[]{children[i]};
				}
			}

		} catch (ModelException e) {
			VjetPlugin.error(e.getLocalizedMessage(), e);
		}
		return null;
	}
}