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
vjo.ctype('engine.javaone.Cat') //< public
.satisfies('engine.javaone.IMate')
.props({
	SPECIES:"Cat", //<final String
	maxage:100 //<public Number
})
.protos({
    m_name:null, //< protected String
	m_weight:0, //<protected double
	m_male:true, //<protected boolean
	m_gene:7, //<protected int
	m_spouse:null, //<private Cat
    //> public constructs(String name, double weight, boolean male)
    constructs:function(name, weight, male){
    	this.m_name=name;
        this.m_weight=weight;
        this.m_male=male;
    },
    //> public String getName()
    getName:function(){
        return this.m_name;
    },
    //> public double getWeight()
    getWeight:function(){
        return this.m_weight;
    },
    //> public boolean isMale()
    isMale:function(){
        return this.m_male;
    },
    //> public int getGene()
    getGene:function(){
        return this.m_gene;
    },
    //> public boolean marryTo(IMate spouse)
    marryTo:function(spouse) {
    	this.m_spouse = spouse;
    	spouse.m_spouse = this;
    	return true;
    },
    //> public Cat getSpouse()
    getSpouse:function() {
    	return this.m_spouse;
    }
})
.endType();