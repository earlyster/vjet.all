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
vjo.ctype('vjo.reflect.Method')
.protos({
	m_class : undefined, //< private vjo.Class
	m_name : undefined, //< private String 
	m_rtnType : undefined, //< private vjo.Class 
	m_paramTypes : undefined, //< private vjo.Class[]
	m_modifiers : 0x0000, //< private int
	
	//> public constructs(vjo.Class declaringClass, String name, vjo.Class[] parameterTypes, vjo.Class returnType, int modifiers)
	constructs : function (declaringClass, 
		name, 
		parameterTypes, 
		returnType, 
		modifiers) {
		
		this.m_class = declaringClass;
		this.m_name = name;
		this.m_rtnType = returnType;
		this.m_paramTypes = parameterTypes;
		this.m_modifiers = modifiers;
		
	},
	
	//>public vjo.Class getDeclaringClass()
	getDeclaringClass : function () {
		return this.m_class;
	},
	
	//>public String getName() 
	getName : function () {
		return this.m_name;
	},
	
	//> public int getModifiers()
	getModifiers : function ()
	{
		return this.m_modifiers;
	},
	
	//> public vjo.Class getType()
	getReturnType : function (){
		return this.m_rtnType;
	},
	
	//> public vjo.Class[] getParameterTypes()
	getParameterTypes : function () {
		return (this.m_paramTypes)?this.m_paramTypes.slice():[];
	}

})
.endType();