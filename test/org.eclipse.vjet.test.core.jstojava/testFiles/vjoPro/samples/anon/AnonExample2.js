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
vjo.ctype('vjoPro.samples.anon.AnonExample2')
.needs('vjoPro.samples.anon.Util')
.protos({
value:'-', //< public String

//> public void constructs(String val)
constructs:function(val)
{
this.value = val;
document.writeln('AnonExample2 constructs called');
},

//> public String getVal()
getVal:function()
{
return this.value;
},

makeAnon : function () {
//snippet.anon.begin
var anon = vjo.make(this,this.vj$.Util,'Inner')
//snippet.anon.end
.protos({
getAnonVal : function () {
document.writeln(this.getVal());
},
getOuterVal : function () {
document.writeln(this.vj$.parent.getVal());
},
doIt: function() {
document.writeln(this.vj$.AnonExample2.doIt());
document.writeln(this.vj$.Util.doIt());
}
})
.endType();

anon.getAnonVal();
anon.getOuterVal();
anon.doIt();
}
})
.props({

//> public void main(String[] args)
main:function(args) {
var anonEx = new this.vj$.AnonExample2('AnonExample2 - Outer');//<AnonExample2
anonEx.makeAnon();
},

doIt:function() {
return 'Static Outer doIt';
}

})
.endType();
