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
vjo.ctype('variableAdvisor.TestType') //< public
.props({
    Str:"", //< String
    //> public void main(String arguments)
    main:function(arguments){
        var vvv;
        var x;
    },
    
    //> public String staticFunc1(String)
    //> public String staticFunc1(String , int)
    //> public String staticFunc1(String a, int b, double c)
    staticFunc1 : function(s1, n1){ 
            return "";
    },
})
.protos({
    state:null, //< String
    //> protected void setState(String s)
    setState:function(s){
        this.state=s;
        this.vj$.A.stat;
    },
    //> protected String getState()
    getState:function(){
        return this.state;
    },
    getState1:function(){
        return this.state;
    }
    method1 : function(){ 
       var arr = new Array(3,5,7,9,0);//<Array
       for (var i in arr) {
           arr
       }
    }
    method2 : function(){ 
       var a, b, c;
       for (var i in arr) {
           arr
       }
    }
    
})
.endType();