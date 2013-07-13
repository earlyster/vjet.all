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
vjo.ctype('org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.Bug3944')
.needs('org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.Bug3944Extn')
.protos({
	m_val : 'm_val',
	m_a : null,
	m_b : null,
	constructs : function (a,b) {
		this.m_a = a;
		this.m_b = b;
	},
	getVal : function () {
		return this.m_val;
	},
	getVal2 : function () {
		return this.m_val;
	}, 
	getBaseType1 : function () {
		return this.vj$.Bug3944Extn.doIt();
	},
	N1 : vjo.ctype()
	.protos({
		getOuter : function () {
			return this.vj$.outer.m_val;
		},
		N2 : vjo.ctype()
		.protos({
			getOuter : function () {
				return this.vj$.outer.vj$.outer.m_val;
			}
		})
		.endType()
	})
	.endType()
})
.endType();