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
vjo.ctype("vjoPro.samples.fundamentals.SubordinateTypeUsages1")
.protos({
//> public void print(int copies, boolean color)
print: function(copies, color) {
alert("print called with " + copies + " copies and color="+color);
},

//> public vjoPro.samples.fundamentals.SubordinateTypeUsages1 getPrint()
getPrint: function() {
return this;
},

//> void doPrint(vjoPro.samples.fundamentals.SubordinateTypeUsages1 p)
doPrint: function(p) {
alert("doPrint called with " + p);
//invoke the method being received as parameter
p(4, false);
}
})
.props({
//> void showMessage(String msg)
showMessage: function(msg) {
alert(msg);
}

})
.endType();
