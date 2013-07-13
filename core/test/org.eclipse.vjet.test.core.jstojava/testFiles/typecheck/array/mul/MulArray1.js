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
vjo.ctype('typecheck.array.mul.MulArray1') //< public
.props({
})
.protos({

//> public void multiDimentionalArray()
multiDimentionalArray:function(){
	
    var x = [0,1,2,3,4,5];  //< int[]
    var y = [x];
    y[0][1];
    y[1][0];
    
    var multiArr1 = new Array();
    for(var i = 0; i < 4; i++)
	       multiArr1[i] = new Array(3);
	    multiArr1[1][1];
	    multiArr1[4][4];
     
    var multiArr2 = new Array(); //< String[][]
    multiArr2=
    [
     new Array( "Venus" , "Mars" , "Earth" ) ,
	 new Array( "Virgo" , "Leo" , "Galaxy" ) ,
	 new Array( "Eve" , "Adam" , "Paradise" )
	];
	multiArr2[0][0];
	multiArr2[4][4];
}
})
.endType();