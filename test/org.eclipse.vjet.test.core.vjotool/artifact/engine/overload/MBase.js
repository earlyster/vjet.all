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
vjo.mtype('engine.overload.MBase') //< public
.props({
	
	//>private void mpvtStaticCompute(int i, String s, Date d)
	//>private void mpvtStaticCompute(int i, String s)
	//>private void mpvtStaticCompute(int i)
	//>private void mpvtStaticCompute() 
	mpvtStaticCompute : function(){
	},
	
	//>public void mpubStaticCompute(int i, String s, Date d)
	//>public void mpubStaticCompute(int i, String s)
	//>public void mpubStaticCompute(int i)
	//>public void mpubStaticCompute() 
	mpubStaticCompute : function(){
	},
	
	//>public void func() 
	mfunc : function(){
		var mbase = new this.vj$.MBase(); //< MBase
		mbase.mpubCompute();
		this.mpubStaticCompute();
	}	
  
})
.protos({
	
	//>private void mpvtCompute(int i, String s, Date d)
	//>private void mpvtCompute(int i, String s)
	//>private void mpvtCompute(int i)
	//>private void mpvtCompute() 
	mpvtCompute : function(){
	},
	
	//>public void mpubCompute(int i, String s, Date d)
	//>public void mpubCompute(int i, String s)
	//>public void mpubCompute(int i)
	//>public void mpubCompute() 
	mpubCompute : function(){
	}
		
})
.endType();