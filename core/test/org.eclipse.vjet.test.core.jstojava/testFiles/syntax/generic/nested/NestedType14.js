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
vjo.ctype('syntax.generic.nested.NestedType14') //< public NestedType14<T>
.protos({
	 InstanceInnerType:vjo.ctype() //< private
    .protos({
    	
    	s : null,//<T
    	
    	//>public T getV2() 
    	getV2 : function(){
    		return this.vj$.outer.view(this.s);
    	}
     }).endType(),
     
    //>public T view(T) 
    view : function(t){
    	var s = new this.InstanceInnerType();//<InstanceInnerType
    	return s.getV2();
    },
    
        //>public T view2(T) 
    view2 : function(t){
    	var s = new this.InstanceInnerType();//<InstanceInnerType
    	return s.s;
    }
})
.endType();