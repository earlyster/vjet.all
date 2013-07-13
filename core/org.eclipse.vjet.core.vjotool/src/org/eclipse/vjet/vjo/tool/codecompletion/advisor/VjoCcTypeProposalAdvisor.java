/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.tool.codecompletion.advisor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstRefType;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstPackage;
import org.eclipse.vjet.dsf.jst.ts.JstTypeSpaceMgr;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstCommentCompletion;
import org.eclipse.vjet.dsf.ts.ITypeSpace;
import org.eclipse.vjet.vjo.tool.codecompletion.IVjoCcAdvisor;
import org.eclipse.vjet.vjo.tool.codecompletion.StringUtils;
import org.eclipse.vjet.vjo.tool.codecompletion.VjoCcCtx;

/**
 * advise all JstTypes in type space example1: needs('<cursor>') example2:
 * function() { xxx<cursor> }
 * 
 * need attributes: 1. ctx.actingToken
 * 
 * 
 * 
 */
public class VjoCcTypeProposalAdvisor extends AbstractVjoCcAdvisor implements
		IVjoCcAdvisor {
	public static final String ID = VjoCcTypeProposalAdvisor.class.getName();

	private boolean fullNameCheck = true;

	public void advise(VjoCcCtx ctx) {
		JstTypeSpaceMgr tsMrg = ctx.getJstTypeSpaceMgr();
		ITypeSpace<IJstType, IJstNode> tsds = tsMrg.getTypeSpace();
		List<IJstType> types = tsds.getVisibleTypes(tsds.getGroup(ctx.getGroupName()));
		IJstType otype = ctx.getActingType();
		boolean fullNameCheck = ctx.ifContainsFullNameCheck();
		String token = ctx.getActingPackageToken();
		Object info = ctx.getInfo(VjoCcCtx.INFO_KEY_IN_TYPE_SCOPE);
		boolean hideSelf = false;
		if (info != null && (info instanceof Boolean)) {
			hideSelf = true;
		}
		List<String> nameList = new ArrayList<String>();
		Iterator<IJstType> it = types.iterator();
		while(it.hasNext()){
			IJstType type = it.next();
			if(type.isFakeType() && !type.isMetaType()){
				continue;
			}
			
			if(!(ctx.getCompletion() instanceof JstCommentCompletion) && type.isMetaType()){
				continue;
			}
			if (nameList.contains(type.getName())) {
				continue;
			}

			// use the current edited content instead of the one in type space
			if (isSameType(type, otype)) {
				if (hideSelf) {
					continue;
				} else {
					type = otype;
				}
			} else {
				// check if hide inner type
				if (ctx.containsFieldAdvisors()) {
					IJstType calledType = ctx.getCalledType();
					if (calledType != null) {
						String cTypeName = calledType.getName();
						IJstType tempType = calledType;
						if (calledType instanceof IJstRefType) {
							tempType = ((IJstRefType) calledType).getReferencedNode();
							cTypeName = tempType
									.getName();
						}
						if (type.getName() == null
								|| (type.getName().contains(cTypeName) && type.getParentNode() == tempType)) {
							continue;
						}
					}
				}
			}
			if (!mtypeCheck(ctx, type)) {
				continue;
			}
			String sTypeName = type.getSimpleName();
			if (VjoCcAdvisorConstances.UNEXIST_TYPES.contains(sTypeName)) {
				continue;
			}
			if (StringUtils.isBlankOrEmpty(sTypeName)) {
				continue;
			}
			boolean exactMatch = exactMatch(sTypeName, token);
			boolean basicMatch = exactMatch;
			if (!exactMatch) {
				basicMatch = basicMatch(sTypeName, token);
			}
			if (exactMatch || basicMatch) {
				appendData(ctx, type, (exactMatch && basicMatch));
				nameList.add(type.getName());
			} else {
				if (fullNameCheck && isInPackage(type.getName(), token)) {
					appendData(ctx, type);
					nameList.add(type.getName());
				}
			}
		}

	}

	private boolean isInPackage(String typeName, String packageName) {
		if (!typeName.startsWith(packageName)) {
			return false;
		}
		String s = typeName.substring(packageName.length());
		return s != null && s.indexOf(".") == -1;
	}

	private boolean mtypeCheck(VjoCcCtx ctx, IJstType type) {
		return ctx.isMtypeEabled() || !type.isMixin();
	}

	private boolean isSameType(IJstType type, IJstType otype) {
		if (type == null || otype == null) {
			return false;
		}
		String oname = otype.getName();
		String name = type.getName();
		if (!StringUtils.compare(oname, name)) {
			return false;
		}

		String ogroupName = null;
		JstPackage pck = otype.getPackage();
		if (pck != null) {
			ogroupName = pck.getGroupName();
		}
		String groupName = null;
		if (type.getPackage()!=null) {
			groupName = type.getPackage().getGroupName();
		}
		return StringUtils.compare(ogroupName, groupName);
	}
	

	/**
	 * if false, when adivse, only compare the token and the simple typename if
	 * true, when adivse, need compare the token with simple typename and full
	 * type name(package name + class simple name). true has the similar feature
	 * with the package advisor.
	 * 
	 * @return
	 */
	protected boolean ifContainsFullNameCheck() {
		return fullNameCheck;
	}

}
