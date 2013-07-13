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
/* @com.ebay.dsf.resource.utils.CodeGen("VjoGenerator") */

//> public
vjo.ctype('org.eclipse.vjet.dsf.jst.validation.vjo.typecheck.compatibletypes.CorrectTypecheckTester')
.props({
// Define your static members here
s_name : undefined, //< public String
s_sex : undefined, //< public Boolean
//> public String getName1()
getName1:function() {
//get the static property using this keyword
document.writeln('Hello ' + this.s_name);
return this.s_name;
}
})
.protos({
// Define your instance members here
i_name:undefined, //< public String
//> public void constructs(String p_name)
constructs:function(p_name) {
// This is a constructor
this.i_name = p_name;
},
//> public String getName2()
getName2: function() {
document.writeln('Hello ' + this.i_name);
return this.i_name;
}
})
.inits(
function(){
// Do your static initialization here
this.s_name = 'World !';
this.s_sex = new Boolean(true);
}
)
.endType(); 