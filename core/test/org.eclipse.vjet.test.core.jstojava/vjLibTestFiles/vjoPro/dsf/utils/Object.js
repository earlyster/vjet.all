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
vjo.ctype("vjoPro.dsf.utils.Object").
/**
* Provides OO features for the general JS objects.
*/
props({
/**
* Hitches a method to a specified JS object.
*
* @param {Object} control
*        the reference of the JS object
* @param {String} method
*        the name of the method
* @return {Object}
*        the reference of the wrapped method
*/
//> public Function hitch(::Object,{Function|String});
hitch : function(poControl, psMethod) {
var fcn;
if(typeof psMethod == "string")
{
fcn = poControl[psMethod];
} else
{
fcn = psMethod;
}
return function(){return fcn.apply(poControl, arguments);};
},

/**
* Builds the inheritance hierarchy between two classes.
*
* @param {Object} subClass
*        the class which acts as the sub class
* @param {Object} baseClass
*        the class which acts as the base class
*
*/
//>public void extend(Function, Function);
extend : function(psSubClass, psBaseClass) {
function inheritance() {}
psSubClass.prototype = new inheritance();
psSubClass.prototype.constructor = psSubClass;
}
})
.endType();
