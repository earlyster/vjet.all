vjo.ctype('autoEdit.indentTest') //< public
.props({
	abc : 1,
	c	: ""
})
.protos({
	//>public String y()
	y : function() {
		do{
		} while(true)
		
		return "aa";
	},
	
	i : "",
	
	//>public void z()
	z : function() {
		var a = "hello ";
		var sentence = a + "world";
	}	
})
.endType();