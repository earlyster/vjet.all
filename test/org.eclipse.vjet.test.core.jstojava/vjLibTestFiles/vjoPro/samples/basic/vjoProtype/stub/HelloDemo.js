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
vjo.ctype('vjoPro.samples.basic.vjoProtype.stub.HelloDemo') //< public
.props({
/**
* @return boolean
* @access public
* @param {String} firstName
* @param {String} lastName
*/
//> public boolean staticFunc(String firstName,String lastName)
staticFunc:function(firstName,lastName){
alert(firstName + " " + lastName);
return false;
}
}).protos({
m_radius:4,
m_bool:true,
m_str:"Hello World",
/**
* @return void
* @access public
* @param {String} greeting
*/
//> public constructs(String greeting)
constructs:function(greeting){
alert(greeting);
},

/**
* @return int
* @access public
* @param {int} arg1
* @param {int} arg2
*/
//> public int compute(int arg1,int arg2)
compute:function(arg1,arg2){
return arg1+arg2;
}

})

.inits(
// TODO USE THIS IF YOU need to do STATIC INIT
function(){

}

)
.endType();
