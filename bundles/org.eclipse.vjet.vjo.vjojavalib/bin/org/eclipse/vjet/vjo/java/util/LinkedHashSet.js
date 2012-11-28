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
vjo.ctype('org.eclipse.vjet.vjo.java.util.LinkedHashSet<E>') //< public
.needs('org.eclipse.vjet.vjo.java.lang.Math')
.needs('org.eclipse.vjet.vjo.java.util.Collection','')
.inherits('org.eclipse.vjet.vjo.java.util.HashSet<E>')
.satisfies('org.eclipse.vjet.vjo.java.util.Set<E>')
.satisfies('org.eclipse.vjet.vjo.java.lang.Cloneable')
.satisfies('org.eclipse.vjet.vjo.java.io.Serializable')
.props({
    serialVersionUID:-2851667679971038690 //< private final long
})
.protos({
    //> public constructs()
    //> public constructs(int initialCapacity,float loadFactor)
    //> public constructs(int initialCapacity)
    //> public constructs(Collection<? extends E> c)
    constructs:function(){
        if(arguments.length===2){
            this.constructs_2_0_LinkedHashSet_ovld(arguments[0],arguments[1]);
        }else if(arguments.length===1){
            if(typeof arguments[0]=="number"){
                this.constructs_1_0_LinkedHashSet_ovld(arguments[0]);
            }else if(vjo.java.util.Collection.clazz.isInstance(arguments[0])){
                this.constructs_1_1_LinkedHashSet_ovld(arguments[0]);
            }
        }else if(arguments.length===0){
            this.constructs_0_0_LinkedHashSet_ovld();
        }
    },
    //> private constructs_2_0_LinkedHashSet_ovld(int initialCapacity,float loadFactor)
    constructs_2_0_LinkedHashSet_ovld:function(initialCapacity,loadFactor){
        this.base(initialCapacity,loadFactor,true);
    },
    //> private constructs_1_0_LinkedHashSet_ovld(int initialCapacity)
    constructs_1_0_LinkedHashSet_ovld:function(initialCapacity){
        this.base(initialCapacity,.75,true);
    },
    //> private constructs_0_0_LinkedHashSet_ovld()
    constructs_0_0_LinkedHashSet_ovld:function(){
        this.base(16,.75,true);
    },
    //> private constructs_1_1_LinkedHashSet_ovld(Collection<? extends E> c)
    constructs_1_1_LinkedHashSet_ovld:function(c){
        this.base(this.vj$.Math.max(2*c.size(),11),.75,true);
        this.addAll(c);
    }
})
.endType();