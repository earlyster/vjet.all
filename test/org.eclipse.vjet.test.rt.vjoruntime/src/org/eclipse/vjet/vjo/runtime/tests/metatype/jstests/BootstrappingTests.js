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
vjo.ctype('org.eclipse.vjet.vjo.runtime.tests.metatype.jstests.BootstrappingTests') //< public
.needs('org.eclipse.vjet.vjo.runtime.tests.metatype.testData.BootstrappingTestsData')
.needs('org.eclipse.vjet.vjo.runtime.tests.metatype.jstests.LazyTester')  
.needs('vjo.reflect.Field')
.props({
	//>public void main() 
	main : function(){
		
		var tempClass = this.vj$.BootstrappingTestsData.clazz;
		var type01 = tempClass.getFields()[0].getType();
		var type02 = tempClass.getConstructors()[0].getParameterTypes()[0];
		
		if(!(type01 instanceof vjo.Class )){
			throw "Instance of vjo.Clas is expected";
		}
		
		if(!(type01 === type02)){
          	throw "Class Instance is not singleton , [param1:"+type01+"]&[param2:"+type02+"]";
        }
        
        this.vj$.LazyTester.compareWithXTypeA(type01);
	}
})
.endType();


