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
vjo.ctype('vjoPro.samples.dom.HTMLandDomEx6') //< public
.needs(['vjoPro.dsf.utils.URL','vjoPro.dsf.document.Element'])
.props({
/**
* @return void
* @access public
* @param {String} psUrlId
* @param {String} psArgNameId
*
*/
//> public void readArgument(String psUrlId,String psArgNameId)
readArgument : function(psUrlId, psArgNameId) {
var sUrl = vjoPro.dsf.document.Element.get(psUrlId).value;
var sArgName = vjoPro.dsf.document.Element.get(psArgNameId).value;
alert(vjoPro.dsf.utils.URL.getArg(sUrl, sArgName));
},

/**
* @return void
* @access public
* @param {String} psUrlId
* @param {String} psArgNameId
* @param {String} psArgValId
*
*/
//> public void addArgument(String psUrlId,String psArgNameId,String psArgValId)
addArgument : function(psUrlId, psArgNameId, psArgValId) {
var E = vjoPro.dsf.document.Element.get(psUrlId);
var sArgName = vjoPro.dsf.document.Element.get(psArgNameId).value;
var sArgVal = vjoPro.dsf.document.Element.get(psArgValId).value;
E.value = vjoPro.dsf.utils.URL.addArg(E.value, sArgName, sArgVal);
}

})
.endType();
