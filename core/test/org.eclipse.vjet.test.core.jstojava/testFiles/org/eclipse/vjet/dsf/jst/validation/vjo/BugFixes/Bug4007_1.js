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
vjo.ctype('org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.Bug4007_1') //< public
.protos({
	x : 10,  //< public int
	
	s : 10,  //< public int
	
	c : undefined, //< public String
	
	//> public String
	d : undefined,
	
	//> Number a()
	a:function(){
	   
	   this.x ="String";
	   
	   this.s = 'String';
	   
	   this.c=this.b();
	   
	   this.d = 20;
	},
	
	//> org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.Bug4007_1 b()
	b:function(){
		return new org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.Bug4007_1();
	}
})
.endType();