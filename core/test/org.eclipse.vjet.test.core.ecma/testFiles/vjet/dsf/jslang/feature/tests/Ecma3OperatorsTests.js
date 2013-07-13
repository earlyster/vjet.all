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
vjo.ctype("vjet.dsf.jslang.feature.tests.Ecma3OperatorsTests")
.inherits("vjet.dsf.jslang.feature.tests.BaseTestEcma3")
.protos({

constructs: function() {
this.base();
},

/*
*
* Date:    08 May 2003
* SUMMARY: JS should evaluate RHS before binding LHS implicit variable
*
* See http://bugzilla.mozilla.org/show_bug.cgi?id=204919
*
*/
//-----------------------------------------------------------------------------
test_11_13_1__001: function() {
//var gTestfile = '11.13.1-001.js';
var UBound = 0;
//var BUGNUMBER = 204919;
var summary = 'JS should evaluate RHS before binding LHS implicit variable';
var TEST_PASSED = 'ReferenceError';
var TEST_FAILED = 'Generated an error, but NOT a ReferenceError!';
var TEST_FAILED_BADLY = 'Did not generate ANY error!!!';
var status = '';
var statusitems = [];
var actual = '';
var actualvalues = [];
var expect= '';
var expectedvalues = [];
var x = null;

/*
* global scope -
*/
status = inSection(1);
try
{
x = x;
actual = TEST_FAILED_BADLY;
}
catch(e)
{
if (e instanceof ReferenceError)
actual = TEST_PASSED;
else
actual = TEST_FAILED;
}
expect = TEST_PASSED;
addThis();


/*
* function scope -
*/
status = inSection(2);
try
{
(function() {y = y;})();
actual = TEST_FAILED_BADLY;
}
catch(e)
{
if (e instanceof ReferenceError)
actual = TEST_PASSED;
else
actual = TEST_FAILED;
}
expect = TEST_PASSED;
addThis();


/*
* eval scope -
*/
status = inSection(3);
try
{
eval('z = z');
actual = TEST_FAILED_BADLY;
}
catch(e)
{
if (e instanceof ReferenceError)
actual = TEST_PASSED;
else
actual = TEST_FAILED;
}
expect = TEST_PASSED;
addThis();




//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------



function inSection(x) {
var SECT_PREFIX = 'Section ';
var SECT_SUFFIX = ' of test - ';
return SECT_PREFIX + x + SECT_SUFFIX;
}

function addThis()
{
statusitems[UBound] = status;
actualvalues[UBound] = actual;
expectedvalues[UBound] = expect;
UBound++;
}


//function test()
//{
//enterFunc('test');
//printBugNumber(BUGNUMBER);
//printStatus(summary);

for (var i=0; i<UBound; i++)
{
this.reportCompare(expectedvalues[i], actualvalues[i], statusitems[i]);
}

//exitFunc ('test');
//}

},

//-----------------------------------------------------------------------------
test_11_13_1__002: function() {
//var BUGNUMBER = 312354;
var summary = '11.13.1 Simple Assignment should return type of RHS';
var actual = '';
var expect = '';

// XXX this test should really test each property of the native
// objects, but I'm too lazy. Patches accepted.

//printBugNumber(BUGNUMBER);
//printStatus (summary);

var re = /x/g;
var y = re.lastIndex = "7"; //<@SUPRESSTYPECHECK

expect = "string";
actual = typeof y;

this.reportCompare(expect, actual, summary);


},

/*
*
* Date:    14 April 2003
* SUMMARY: |delete x.y| should return |true| if |x| has no property |y|
* See http://bugzilla.mozilla.org/show_bug.cgi?id=201987
*
*/
//-----------------------------------------------------------------------------
test_11_4_1__001: function() {
//var gTestfile = '11.4.1-001.js';
var UBound = 0;
//var BUGNUMBER = 201987;
var summary = '|delete x.y| should return |true| if |x| has no property |y|';
var status = '';
var statusitems = [];
var actual = '';
var actualvalues = [];
var expect= '';
var expectedvalues = [];


status = inSection(1);
var x = {};
actual = delete x.y;
expect = true;
addThis();

status = inSection(2);
actual = delete {y:12}.y;
expect = true;
addThis();

status = inSection(3);
actual = delete "".y;
expect = true;
addThis();

status = inSection(4);
actual = delete /abc/.y;
expect = true;
addThis();

status = inSection(5);
actual = delete (new Date()).y;
expect = true;
addThis();

status = inSection(6);
var x = 99;
actual = delete x.y;
expect = true;
addThis();



//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------


function inSection(x) {
var SECT_PREFIX = 'Section ';
var SECT_SUFFIX = ' of test - ';
return SECT_PREFIX + x + SECT_SUFFIX;
}

function addThis()
{
statusitems[UBound] = status;
actualvalues[UBound] = actual;
expectedvalues[UBound] = expect;
UBound++;
}


//function test()
//{
//enterFunc('test');
//printBugNumber(BUGNUMBER);
//printStatus(summary);

for (var i=0; i<UBound; i++)
{
this.reportCompare(expectedvalues[i], actualvalues[i], statusitems[i]);
}

//exitFunc ('test');
//}

},

//-----------------------------------------------------------------------------
test_11_4_1__002: function() {
//var BUGNUMBER = 423300;
var summary = '11.4.1 - The delete Operator - delete f()';
var actual = '';
var expect = '';


//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------

function f() {}

//function test()
//{
//enterFunc ('test');
//printBugNumber(BUGNUMBER);
//printStatus (summary);

expect = true;

try
{
actual = delete f();
}
catch(ex)
{
actual = ex + '';
}

this.reportCompare(expect, actual, summary);

//exitFunc ('test');
//}

},

//-----------------------------------------------------------------------------
test_order__01: function() {
//var BUGNUMBER = 433672;
var summary = 'operator evaluation order';
var actual = '';
var expect = '';

function makeObject(label)
{
var o = (function (){});

o.label    = label;
o.valueOf  = (function() { actual += this.label + ' valueOf, ';  return Object.prototype.valueOf.call(this); });
o.toString = (function() { actual += this.label + ' toString, '; return Object.prototype.toString.call(this); });

return o;
}

operators = [
{section: '11.5.1', operator: '*'},
{section: '11.5.2', operator: '/'},
{section: '11.5.3', operator: '%'},
{section: '11.6.1', operator: '+'},
{section: '11.6.2', operator: '-'},
{section: '11.7.1', operator: '<<'},
{section: '11.7.2', operator: '>>'},
{section: '11.7.3', operator: '>>>'},
{section: '11.8.1', operator: '<'},
{section: '11.8.2', operator: '>'},
{section: '11.8.3', operator: '<='},
{section: '11.8.4', operator: '>='},
{section: '11.10', operator: '&'},
{section: '11.10', operator: '^'},
{section: '11.10', operator: '|'},
{section: '11.13.2', operator: '*='},
{section: '11.13.2', operator: '/='},
{section: '11.13.2', operator: '%='},
{section: '11.13.2', operator: '+='},
{section: '11.13.2', operator: '<<='},
{section: '11.13.2', operator: '>>='},
{section: '11.13.2', operator: '>>>='},
{section: '11.13.2', operator: '&='},
{section: '11.13.2', operator: '^='},
{section: '11.13.2', operator: '|='},
];

//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------

//function test()
//{
//enterFunc ('test');
//printBugNumber(BUGNUMBER);
//printStatus (summary);

for (var i = 0; i < operators.length; i++)
{
expect = 'left valueOf, left toString, right valueOf, right toString, ';
actual = '';

var left  = makeObject('left');
var right = makeObject('right');

eval('left ' + operators[i].operator + ' right');

this.reportCompare(expect, actual, summary + ': ' + operators[i].section + ' ' + operators[i].operator);

}

//exitFunc ('test');
//}

}


})
.endType();






