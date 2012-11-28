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
/**
* A helper class for <code>VjCookieJar</code> to parse the bit flag from the 
* flag string.
*
* @see org.eclipse.vjet.vsf.cookie.VjCookieJar
*/
vjo.ctype("org.eclipse.vjet.vsf.utils.Bit")
.needs("org.eclipse.vjet.vsf.cookie.VjCookieJar")
.props({
	CJ : org.eclipse.vjet.vsf.cookie.VjCookieJar,
	/**
	* Gets the multi-bit value from a particular position given a number of bits.
	* 
	* @param {String} dec
	*        A bit string contains series of flags
	* @param {int} pos
	*        Flag position in the bit string
	* @param {int} bit
	*        The bit length of the flag
	* @return {int} 
	*        The flag value in binary format
	*/
    //> public int getMulti(String,int,int);
	getMulti: function(piDec, piPos, piBits) {
		var r = "",i,CJ=this.CJ;
		for(i=0;i<piBits;i++){
			r = CJ.getBitFlag(piDec,piPos+i) + r ;
		}
        return parseInt(r,2);
    },
    
    /** 
    * Sets the multi-bit flag at particular position given a number of bits
    *
    * @param {String} dec
	*        A bit string contains series of flags
 	* @param {int} pos
	*        Flag position in the bit string
	* @param {int} bit
	*        The bit length of the flag
	* @param {int} value
	*        The value of the flag in decimal format
	* @return {int} 
	*        The new bits string
	*/
    //> public String setMulti(String,int,int,Number);
    setMulti: function(piDec, piPos, piBits, piVal) {
		var i=0,CJ=this.CJ, v, l, e;
		//convert to binary and take piBits out of it
		v = piVal.toString(2).substring(0,piBits);
        l = v.length;
		if(l<piBits){
            e = piBits-l;
			for(var j=0;j<e;j++){
                v = "0"+v;
            }
			l = l+e;
		}
		for(i=0;i<l;i++){
			piDec = CJ.setBitFlag(piDec,piPos+i,v.substring(l-i-1,l-i));
		}
		return piDec;
    }
}).endType();