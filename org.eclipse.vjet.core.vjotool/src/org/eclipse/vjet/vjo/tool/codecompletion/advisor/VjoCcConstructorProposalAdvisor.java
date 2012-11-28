/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.tool.codecompletion.advisor;

import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.vjo.tool.codecompletion.StringUtils;
import org.eclipse.vjet.vjo.tool.codecompletion.VjoCcCtx;

/**
 * when cursor after new .., calculate all the enable class, but the client side
 * will look it as constructor.
 * 
 * 
 * @deprecated this class has been replaced by VjoCcConstructorGenProposalAdvisor
 * 
 */
public class VjoCcConstructorProposalAdvisor extends VjoCcCTypeProposalAdvisor {
	public static final String ID = VjoCcConstructorProposalAdvisor.class
			.getName();

	public void advise(VjoCcCtx ctx) {
		IJstType type = ctx.getActingType();
		String token = ctx.getActingToken();
		IJstMethod method = type.getConstructor();
		if (StringUtils.isBlankOrEmpty(token) && method != null) {// show its own constructor;
			appendData(ctx, type);
		} else {
			super.advise(ctx);
		}
	}

}
