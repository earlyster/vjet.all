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
vjo.ctype('syntax.declare.innerType.Anonymous4')
.props({
	//>public void outerFunction() 
	outerStaticFunction : function(){
	},
	
	s2 : "VSF" //< public String
})
.protos({
	
	//>public void outerInstanceFunction() 
	outerInstanceFunction : function(){
	},

	s1 : "DDSF",//<public String

	//>public void foo() 
	foo : function(){
		 var anon = vjo.make( this.vj$.Anonymous4, 'AnonymousType') // vjo.make()
		 .protos({
		
		 innerInstanceProperties : "DD",//<String
		 
		 getAnonTypeProp : function () {
	     	
		 },
		 getSourceTypeProp : function () {
		 this.vj$.Anonymous4.s2 = "SF"; 
		 this.vj$.Anonymous4.outerStaticFunction();  
		 this.outerInstanceFunction();
		 }
		 })
		 .props({
			 fow : "SDF",//< String
		 
			 //>public void anonStaticMethod() 
			 anonStaticMethod : function(){      
			  this.vj$.Anonymous4.outerStaticFunction();     
			 this.outerInstanceFunction();
			 }
		 })
		 .endType();
		 anon.getAnonTypeProp();
		 anon.getSourceTypeProp();
	}
})
.endType();