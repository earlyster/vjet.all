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
vjo.ctype('astjst.ECMAOperators') //> public
.protos({

	//> public void testPostfixIncrementOp()
	testPostfixIncrementOp: function() {
		var foo = 0; //< Number
		
		foo++;
	},
	
	//> public void testPostfixDecrementOp()
	testPostfixDecrementOp: function() {
		var foo = 0; //< Number
		
		foo--;
	},
	
	//> public void testPrefixIncrementOp()
	testPrefixIncrementOp: function() {
		var foo = 0; //< Number
		
		++foo;
	},
	
	//> public void testPrefixDecrementOp()
	testPrefixDecrementOp: function() {
		var foo = 0; //< Number
		
		--foo;
	
	},
	
	//> public void testUnaryPlusOp()
	testUnaryPlusOp: function() {
		var foo = 0; //< Number
			
		+foo;
	},
	
	//> public void testUnaryMinusOp()
	testUnaryMinusOp: function() {
		var foo = 0; //< Number
		
		-foo;
	},
	
	//> public void testArithmeticOp()
	testArithemticOp: function() {
		var num1 = 0; //< Number
		var num2 = 0; //< Number
		var result = 0; //< Number
		
		result = num1 * num2
		result = num1 / num2
		result = num1 % num2
		
		result = num1 + num2
		result = num1 - num2
			
	},
	
	//> public void testRelationalOp()
	testRelationalOp: function() {
		var num1 = 0 	//< Number
		var num2 = 0 	//< Number
		var result = false //< Boolean
		
		result = num1 < num2
		result = num1 > num2
		result = num1 <= num2
		result = num1 >= num2
		result = num1 == num2
		result = num1 != num2		
		
		result = num1 === num2
		result = num1 !== num2		
		
	},
	
	//> public void testCompoundAssignmentOp()
	testCompoundAssignmentOp: function() {
		var num1 = 0 //< Number
		var num2 = 0 //< Number
		
		num1 += num2
		num1 -= num2
		num1 *= num2
		num1 /= num2
		num1 %= num2
		
		num1 &= num2
		num1 ^= num2
		num1 |= num2
		
		num1 <<= num2
		num1 >>= num2
		num1 >>>= num2
		
	}
})
.endType();