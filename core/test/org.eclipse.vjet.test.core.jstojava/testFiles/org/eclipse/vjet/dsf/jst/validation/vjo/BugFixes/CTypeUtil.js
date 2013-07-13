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
vjo.ctype('org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.CTypeUtil') //< public
.props({
  //>public void staticFunc() 
  staticFunc : function(){
   			var a = true;
    		if(a && document){
        		//document exists
      		}
  },
  //> public void main(String... arguments)
        main: function() {
                vjo.sysout.println("test");
                var patt1=new RegExp("e"); //Bug5004
                var a = new Function ("return \"Hello World\""); //Bug5006
                alert(a());
                var err1 = new Error(); //Bug5017
                alert(err1);
                var arr  = [96,"dog",-99,"mouse",NaN,Object,new Object]; //Bug5075
                alert(arr);
        } 
  
})
.protos({
list:null,
  //>public void instanceFunc() 
  instanceFunc : function(){
   var elem=window.event.target || window.event.srcElement;
   this.vj$.CTypeUtil.staticFunc();
   var d = new Date();
  },
  
  //public int getIsle(int val1, String val2)
  getIsle : function(val1, val2){
  	if (val1 == 0)
  	{
		return 0;
	 }
	 else if (val1 == 1)
	 {
	 	return 0;
	 }
  },
  
  test: function() {
                this.list = []; //< Array
                this.list.push("");
  },
  
  //>public void foo() 
   foo : function(){
                var func = function(){};  //< void function()
   }
  
})
.inits(function(){
       // eval("alert('a')");
       
       
       
})
.endType();