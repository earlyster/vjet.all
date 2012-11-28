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
vjo.ctype("dsf.jslang.feature.tests.Ecma3_1RegExpTests")
.inherits("dsf.jslang.feature.tests.BaseTest")
.protos({

/**
*  File Name:          regress__305064.js
*/
test_regress__305064 : function() {
var SECTION = "regress__305064";
//var BUGNUMBER = 305064;
var summary = 'CharacterClassEscape \\s';
var actual = '';
var expect = '';

//-----------------------------------------------------------------------------
//test();
//-----------------------------------------------------------------------------

//function test()
//{
//enterFunc ('test');
//printBugNumber(BUGNUMBER);
//printStatus (summary);

/** List from ES 3.1 Recommendation for String.trim (bug 305064) **/
var whitespace = [
{s : '\u0009', t : 'HORIZONTAL TAB'},
{s : '\u000B', t : 'VERTICAL TAB'},
{s : '\u000C', t : 'FORMFEED'},
{s : '\u0020', t : 'SPACE'},
{s : '\u00A0', t : 'NO-BREAK SPACE'},
{s : '\u1680', t : 'OGHAM SPACE MARK'},
{s : '\u180E', t : 'MONGOLIAN VOWEL SEPARATOR'},
{s : '\u2000', t : 'EN QUAD'},
{s : '\u2001', t : 'EM QUAD'},
{s : '\u2002', t : 'EN SPACE'},
{s : '\u2003', t : 'EM SPACE'},
{s : '\u2004', t : 'THREE-PER-EM SPACE'},
{s : '\u2005', t : 'FOUR-PER-EM SPACE'},
{s : '\u2006', t : 'SIX-PER-EM SPACE'},
{s : '\u2007', t : 'FIGURE SPACE'},
{s : '\u2008', t : 'PUNCTUATION SPACE'},
{s : '\u2009', t : 'THIN SPACE'},
{s : '\u200A', t : 'HAIR SPACE'},
{s : '\u202F', t : 'NARROW NO-BREAK SPACE'},
{s : '\u205F', t : 'MEDIUM MATHEMATICAL SPACE'},
{s : '\u3000', t : 'IDEOGRAPHIC SPACE'},
{s : '\u000A', t : 'LINE FEED OR NEW LINE'},
{s : '\u000D', t : 'CARRIAGE RETURN'},
{s : '\u2028', t : 'LINE SEPARATOR'},
{s : '\u2029', t : 'PARAGRAPH SEPARATOR'},
{s : '\u200B', t : 'ZERO WIDTH SPACE (category Cf)'}
];

for (var i = 0; i < whitespace.length; ++i)
{
var v = whitespace[i];
this.TestCase(SECTION, 'Is ' + v.t + ' a space',true, !!(/\s/.test(v.s)));
//reportCompare(true, !!(/\s/.test(v.s)), 'Is ' + v.t + ' a space');
}

//exitFunc ('test');
//}

}

}).endType();
