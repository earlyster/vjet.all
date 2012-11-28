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

vjo.ctype('org.eclipse.vjet.vjo.java.lang.UnsupportedOperationException') //< public
.needs('org.eclipse.vjet.vjo.java.lang.Throwable')
.inherits('org.eclipse.vjet.vjo.java.lang.RuntimeException')
.props({
    serialVersionUID:-1242599979055084673 //< final long
})
.protos({
    //> public constructs()
    //> public constructs(String message)
    //> public constructs(String message,Throwable cause)
    //> public constructs(Throwable cause)
    constructs:function(){
        if(arguments.length===0){
            this.constructs_0_0_UnsupportedOperationException_ovld();
        }else if(arguments.length===1){
            if(arguments[0] instanceof String || typeof arguments[0]=="string"){
                this.constructs_1_0_UnsupportedOperationException_ovld(arguments[0]);
            }else if(vjo.java.lang.Throwable.clazz.isInstance(arguments[0])){
                this.constructs_1_1_UnsupportedOperationException_ovld(arguments[0]);
            }
        }else if(arguments.length===2){
            this.constructs_2_0_UnsupportedOperationException_ovld(arguments[0],arguments[1]);
        }
    },
    //> private constructs_0_0_UnsupportedOperationException_ovld()
    constructs_0_0_UnsupportedOperationException_ovld:function(){
        this.base();
    },
    //> private constructs_1_0_UnsupportedOperationException_ovld(String message)
    constructs_1_0_UnsupportedOperationException_ovld:function(message){
        this.base(message);
    },
    //> private constructs_2_0_UnsupportedOperationException_ovld(String message,Throwable cause)
    constructs_2_0_UnsupportedOperationException_ovld:function(message,cause){
        this.base(message,cause);
    },
    //> private constructs_1_1_UnsupportedOperationException_ovld(Throwable cause)
    constructs_1_1_UnsupportedOperationException_ovld:function(cause){
        this.base(cause);
    }
})
.endType();