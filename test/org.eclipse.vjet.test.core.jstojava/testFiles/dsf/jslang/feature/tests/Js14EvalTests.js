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
vjo.ctype("dsf.jslang.feature.tests.Js14EvalTests")
.inherits("dsf.jslang.feature.tests.BaseTest")
.protos({

//>void assertEquals(Object o1, Object o2)
assertEquals : function(o1,o2){
},

constructs:function(){
this.base();
},

/** @Test
File Name:         eval__001.js
Original Description: (SEE REVISED DESCRIPTION FURTHER BELOW)

The global eval function may not be accessed indirectly and then called.
This feature will continue to work in JavaScript 1.3 but will result in an
error in JavaScript 1.4. This restriction is also in place for the With and
Closure constructors.

http://scopus.mcom.com/bugsplat/show_bug.cgi?id=324451

Author:          christine@netscape.com
Date:               11 August 1998


REVISION:    05  February 2001
Author:          pschwartau@netscape.com

Indirect eval IS NOT ILLEGAL per ECMA3!!!  See

http://bugzilla.mozilla.org/show_bug.cgi?id=38512

------- Additional Comments From Brendan Eich 2001-01-30 17:12 -------
ECMA-262 Edition 3 doesn't require implementations to throw EvalError,
see the short, section-less Chapter 16.  It does say an implementation that
doesn't throw EvalError must allow assignment to eval and indirect calls
of the evalnative method.
*/
test_eval__001: function () {
var SECTION = "eval__001.js";
//var VERSION = "JS1_4";
//var TITLE   = "Calling eval indirectly should NOT fail in version 140";
//var BUGNUMBER="38512";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

var MY_EVAL = eval;
var RESULT = "";
var EXPECT = "abcdefg";

MY_EVAL( "RESULT = EXPECT" );

this.TestCase(
SECTION,
"Call eval indirectly",
EXPECT,
RESULT );

//test();
},

/** @Test
File Name:         eval__002.js
Original Description: (SEE REVISED DESCRIPTION FURTHER BELOW)

The global eval function may not be accessed indirectly and then called.
This feature will continue to work in JavaScript 1.3 but will result in an
error in JavaScript 1.4. This restriction is also in place for the With and
Closure constructors.

http://scopus.mcom.com/bugsplat/show_bug.cgi?id=324451

Author:          christine@netscape.com
Date:               11 August 1998


REVISION:    05  February 2001
Author:          pschwartau@netscape.com

Indirect eval IS NOT ILLEGAL per ECMA3!!!  See

http://bugzilla.mozilla.org/show_bug.cgi?id=38512

------- Additional Comments From Brendan Eich 2001-01-30 17:12 -------
ECMA-262 Edition 3 doesn't require implementations to throw EvalError,
see the short, section-less Chapter 16.  It does say an implementation that
doesn't throw EvalError must allow assignment to eval and indirect calls
of the evalnative method.
*/
test_eval__002: function () {
var SECTION = "eval__002.js";
//var VERSION = "JS1_4";
//var TITLE   = "Calling eval indirectly should NOT fail in version 140";
//var BUGNUMBER="38512";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

var MY_EVAL = eval;
var RESULT = "";
var EXPECT = 1 + "testString"

EvalTest();

//test();

function EvalTest()
{
MY_EVAL( "RESULT = EXPECT" );

this.assertEquals(EXPECT, RESULT);
}
},

/** @Test
File Name:         eval__003.js
Original Description: (SEE REVISED DESCRIPTION FURTHER BELOW)

The global eval function may not be accessed indirectly and then called.
This feature will continue to work in JavaScript 1.3 but will result in an
error in JavaScript 1.4. This restriction is also in place for the With and
Closure constructors.

http://scopus.mcom.com/bugsplat/show_bug.cgi?id=324451

Author:          christine@netscape.com
Date:               11 August 1998


REVISION:    05  February 2001
Author:          pschwartau@netscape.com

Indirect eval IS NOT ILLEGAL per ECMA3!!!  See

http://bugzilla.mozilla.org/show_bug.cgi?id=38512

------- Additional Comments From Brendan Eich 2001-01-30 17:12 -------
ECMA-262 Edition 3 doesn't require implementations to throw EvalError,
see the short, section-less Chapter 16.  It does say an implementation that
doesn't throw EvalError must allow assignment to eval and indirect calls
of the evalnative method.
*/
test_eval__003: function () {
var SECTION = "eval__003.js";
//var VERSION = "JS1_4";
//var TITLE   = "Calling eval indirectly should NOT fail in version 140";
//var BUGNUMBER="38512";

//startTest();
//writeHeaderToLog( SECTION + " "+ TITLE);

var MY_EVAL = eval;
var RESULT = "";
var EXPECT= "";
var h = function f(x,y){var g = function(z){return Math.exp(z);}; return g(x+y);};

new EvalTest();

//test();

function EvalTest()
{
with( this ) {
MY_EVAL( "RESULT = h(-1, 1)" );
EXPECT = 1;  //The base e to the power (-1 + 1),  i.e. the power 0,  equals 1 ....

assertEquals(EXPECT, RESULT );
}
}
}
})
.endType();
