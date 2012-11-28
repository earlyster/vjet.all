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
vjo.ctype('vjoPro.samples.server.ServerEx10') //< public
.protos({
m_id:null,
/**
* @access public
* @param {int} psId
*/
//> public constructs(int psId)
constructs:function(psId){
this.m_id = psId;
},
/**
* @access public
* @param {ServerEx6Jsr} poServerEx6
*/
//> public void doSomething(vjoPro.samples.server.ServerEx6Jsr  poServerEx6)
doSomething:function(poServerEx6){
alert("Employee ID: "+poServerEx6.getName());
}
})
.endType();
