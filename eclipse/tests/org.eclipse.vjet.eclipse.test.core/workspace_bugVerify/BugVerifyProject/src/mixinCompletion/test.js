vjo.mtype("mixinCompletion.test")
.props({
	m1 : 0, //< private int
	m2 : 1, //< public int
	
	//> public void stM()
	stM: function() {
	}
})
.protos({
	m3 : 0, //< private int
	m4 : 5, //< public int
	
	//> public void fooM()
	fooM : function() {
		this.doM();
	},
	
	//> private void doM()
	doM: function() {
	}
	
});