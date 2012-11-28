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
vjo.ctype("com.ebay.dsf.jstojava.codegen.data.Nested")
.props({
	//> public String
	m_outer : "OUTER:String value",
	/**
	 *  A nested type
	 */
	//> public
	A : vjo.ctype()
		.props({
			//> public String
			s_OfA : "A:s_OfA",
			/**
			 * AA nested type
			 */
			//> public 
			AA : vjo.ctype()
			.props({
				//> public String 
				s_ofAA : "AA:s_ofAA"
			})
			.protos({
				//> public String 
				m_ofAA : "AA:m_ofAA"
			})
			.endType()
		})
	    .protos({
		    //> public String m_inner1
		    m_inner1 : "A:m_inner1",
		    //> public int m_inner2
		    m_inner2 : 100,
		    //> public vjo.Object doItOfA(String)
			doItOfA : function (p1) {
				//call static doIt method on outer Nested1
				this.vjo.Nested1.doIt();
			}
	     })
	     .endType(),
	
	//> public String doIt()
	doIt : function () {
		vjo.sysout.println("Nested1:doIt");	
	},
	main : function (args) {
		var a = new this.A();
		a.doIt();
	} 
})
.endType();