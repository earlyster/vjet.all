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
vjo.ctype('syntax.declare.innerType.AccessOuterType') //< public
.props({
    staticP1:"staticp1", //< private String
    StaticInnerType1:
vjo.ctype() //< private
    .props({
        innerStaticFunc:function(){
            vjo.sysout.println('innerStaticFunc function called');
            this.vj$.AccessOuterType.staticP1;
            this.vj$.AccessOuterType.staticOuterFunc();
        }
    })
    .protos({
        innerInstanceFunc:function(){
            vjo.sysout.println('innerInstanceFunc function called');
            this.vj$.AccessOuterType.staticOuterFunc();
        }
    })
    .endType(),
    staticOuterFunc:function(){
        vjo.sysout.println('staticOuterFunc function called');
    }
})
.protos({
    instanceP1:"instanceP1", //< private String
    InstanceInnerClass:
vjo.ctype() //< public
//    .props({
//        innerStaticFunc:function(){
//            vjo.sysout.println('innerStaticFunc function called');
//            this.vj$.AccessOuterType.staticP1;
//            this.vj$.AccessOuterType.staticOuterFunc();
//        }
//    })
    .protos({
        innerInstanceFunc:function(){
            this.vj$.outer.instanceP1;
        }
    })
    .endType(),
    instanceOuterFunc:function(){
        vjo.sysout.println('instanceOuterFunc function called');
    }
})
.endType();