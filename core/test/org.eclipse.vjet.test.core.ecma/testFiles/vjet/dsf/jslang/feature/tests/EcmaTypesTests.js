/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mozilla Communicator client code, released
 * March 31, 1998.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by the Initial Developer are Copyright (C) 1998
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */
vjo.ctype("vjet.dsf.jslang.feature.tests.EcmaTypesTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTest")
.protos({

constructs: function() {
this.base();
},

/**
File Name:          8.1.js
ECMA Section:       The undefined type
Description:

The Undefined type has exactly one value, called undefined. Any variable
that has not been assigned a value is of type Undefined.

Author:             christine@netscape.com
Date:               12 november 1997
*/
test_8_1: function() {
var SECTION = "8.1";
var VERSION = "ECMA_1";
//startTest();
var TITLE   = "The undefined type";

//writeHeaderToLog( SECTION + " "+ TITLE);

this.TestCase( SECTION,
"var x; typeof x",
"undefined",
eval("var x; typeof x") );

this.TestCase( SECTION,
"var x; typeof x == 'undefined",
true,
eval("var x; typeof x == 'undefined'") );

this.TestCase( SECTION,
"var x; x == void 0",
true,
eval("var x; x == void 0") );
//test();
},

/**
File Name:          8.4.js
ECMA Section:       The String type
Description:

The String type is the set of all finite ordered sequences of zero or more
Unicode characters. Each character is regarded as occupying a position
within the sequence. These positions are identified by nonnegative
integers. The leftmost character (if any) is at position 0, the next
character (if any) at position 1, and so on. The length of a string is the
number of distinct positions within it. The empty string has length zero
and therefore contains no characters.

Author:             christine@netscape.com
Date:               12 november 1997
*/
test_8_4: function() {
var SECTION = "8.4";
var VERSION = "ECMA_1";
//startTest();
var TITLE   = "The String type";

//writeHeaderToLog( SECTION + " "+ TITLE);

this.TestCase( SECTION,
"var s = ''; s.length",
0,
eval("var s = ''; s.length") );

this.TestCase( SECTION,
"var s = ''; s.charAt(0)",
"",
eval("var s = ''; s.charAt(0)") );


for ( var i = 0x0041, TEST_STRING = "", EXPECT_STRING = ""; i < 0x007B; i++ ) {
TEST_STRING += ("\\u"+ DecimalToHexString( i ) );
EXPECT_STRING += String.fromCharCode(i);
}

this.TestCase( SECTION,
"var s = '" + TEST_STRING+ "'; s",
EXPECT_STRING,
eval("var s = '" + TEST_STRING+ "'; s") );

this.TestCase( SECTION,
"var s = '" + TEST_STRING+ "'; s.length",
0x007B-0x0041,
eval("var s = '" + TEST_STRING+ "'; s.length") );

//test();

function DecimalToHexString( n ) {
n = Number( n );
var h = "";

for ( var i = 3; i >= 0; i-- ) {
if ( n >= Math.pow(16, i) ){
var t = Math.floor( n  / Math.pow(16, i));
n -= t * Math.pow(16, i);
if ( t >= 10 ) {
if ( t == 10 ) {
h += "A";
}
if ( t == 11 ) {
h += "B";
}
if ( t == 12 ) {
h += "C";
}
if ( t == 13 ) {
h += "D";
}
if ( t == 14 ) {
h += "E";
}
if ( t == 15 ) {
h += "F";
}
} else {
h += String( t );
}
} else {
h += "0";
}
}
return h;
}

},

/**
File Name:          8.6.2.1-1.js
ECMA Section:       8.6.2.1 Get (Value)
Description:

When the [[Get]] method of O is called with property name P, the following
steps are taken:

1.  If O doesn't have a property with name P, go to step 4.
2.  Get the value of the property.
3.  Return Result(2).
4.  If the [[Prototype]] of O is null, return undefined.
5.  Call the [[Get]] method of [[Prototype]] with property name P.
6.  Return Result(5).

This tests [[Get]] (Value).

Author:             christine@netscape.com
Date:               12 november 1997
*/
test_8_6_2_1__1: function() {
var SECTION = "8.6.2.1-1";
var VERSION = "ECMA_1";
//startTest();

//writeHeaderToLog( SECTION + " [[Get]] (Value)");

this.TestCase( SECTION,  "var OBJ = new MyObject(true); OBJ.valueOf()",              true,           eval("var OBJ = new MyObject(true); OBJ.valueOf()") );

this.TestCase( SECTION,  "var OBJ = new MyObject(Number.POSITIVE_INFINITY); OBJ.valueOf()",              Number.POSITIVE_INFINITY,           eval("var OBJ = new MyObject(Number.POSITIVE_INFINITY); OBJ.valueOf()") );

this.TestCase( SECTION,  "var OBJ = new MyObject('string'); OBJ.valueOf()",              'string',           eval("var OBJ = new MyObject('string'); OBJ.valueOf()") );

//test();

function MyObject( value ) {
this.valueOf = new Function( "return this.value" );
this.value = value;
}

}

})
.endType();

