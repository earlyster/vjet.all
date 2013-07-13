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
vjo.ctype("vjoPro.dsf.document.Positioning")
.props({
/**
* Gets the number of pixels that the content is scrolled to the left and
* top. This function will return an Array structure which has two elements -
* the first one is the pixel number of scorlled content to left, and the
* other one is the number to top.
*
* Examples:
* <code>
*    var offsets = getScrollLeftTop();
*    alert("The left offset is: " + offsets[0]);
*    alert("The top offset is: " + offsets[1]);
* </code>
*
* @return {Object}
*         an array structure that contains number of pixels of scorlled
*         content to left and top
*/
//> public Object getScrollLeftTop();
getScrollLeftTop : function() {
var d = document, rv = [0,0], db = d.body, de = d.documentElement;
if (db)
{
rv[0] += db.scrollLeft;
rv[1] += db.scrollTop;
}
if (de)
{
//using xhtml1-transitional.dtd de scrolltop needs to be appended
rv[0] += de.scrollLeft;
rv[1] += de.scrollTop;
}
return rv;
},

/**
* Gets the number of pixels that the upper left corner of the current
* element is offset to the left within the offsetParent node.
*
* @param {Object} elem
*        an element to be got the number of pixels
* @return {int}
*        the number of pixels of the element's offset to the left
*/
//> public int getOffsetLeft(HTMLElement);
getOffsetLeft : function(poElem) {
var e = poElem;
var l = 0;//<Number
while (e)
{
l += e.offsetLeft;
e = e.offsetParent;
}
return l;
},

/**
* Gets the number of pixels that the upper left corner of the current
* element is offset to the top within the offsetParent node.
*
* @param {Object} elem
*        an element to be got the number of pixels
* @return {int}
*        the number of pixels of the element's offset to the top
*/
//> public int getOffsetTop(HTMLElement);
getOffsetTop : function(poElem)	{
var e = poElem;
var t = 0;//<Number
while (e)
{
t += e.offsetTop;
e = e.offsetParent;
}
return t;
},

//> public int getClientWidth();
getClientWidth : function()	{
var s = self, d = document, de =  d.documentElement;
var w;//<Number
if (s.innerWidth)
{
w = s.innerWidth;
}
else if (de && de.clientWidth)
{
w = de.clientWidth;
}
else
{
w = d.body.clientWidth;
}
return w;
},

//> public int getClientHeight();
getClientHeight : function() {
var s = self, d = document, de =  d.documentElement;
var h;//<Number
if (s.innerHeight)
{
h = s.innerHeight;
}
else if (de && de.clientHeight)
{
h = de.clientHeight;
}
else
{
h = d.body.clientHeight;
}
return h;
}

})
.endType();
