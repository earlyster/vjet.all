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
vjo.ctype('vjo.reflect.Constructor')
.protos({
	m_class : undefined, //< private vjo.Class
	m_paramTypes : undefined, //< private vjo.Class[]
	m_modifiers : 0x0000, //< private int

	//> public constructs(vjo.Class declaringClass, vjo.Class[] parameterTypes,  int modifiers)
	constructs : function (declaringClass, 
		parameterTypes, 
		modifiers) {
		
		this.m_class = declaringClass;
		this.m_paramTypes = parameterTypes;
		this.m_modifiers = modifiers;
		
	},

	//>public vjo.Class getDeclaringClass()
	getDeclaringClass : function () {
		return this.m_class;
	},
	
	//> public int getModifiers()
	getModifiers : function ()
	{
		return this.m_modifiers;
	},
	
	//> public vjo.Class[] getParameterTypes()
	getParameterTypes : function () {
		return (this.m_paramTypes)?this.m_paramTypes.slice():[];
	}

})
.endType();