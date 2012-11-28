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
vjo.ctype("org.eclipse.vjet.vjo.java.lang.ClassUtil")
.props({
    //> public  vjo.Class  getSuperclass(vjo.Class clazz)
    getSuperclass: function(clazz) {
        var tp = vjo.getType(clazz.getName());
        if(tp) {
            var supName = tp.prototype.vj$._class;
            if(!supName) return null;
            if(supName==="vjo.Object") {
	            return new vjo.Class("vjo.Class", "ctype");
            } else if(supName==="vjo.Enum") {
                return new vjo.Class("vjo.Enum", "ctype");
            }else {
    		    var qname = supName;
    	    	var idx = qname.indexOf(' '), idx2 = qname.indexOf('<');
    		    if (idx>0) {
    			  	if (idx2>0) idx = Math.min(idx,idx2);
    		    } else {
    		    	idx = idx2;
    		    }
    			if (idx>0) {
    			    qname = qname.substring(0,idx);
    			}
    			var names = qname.split('.');
    			var name = names[names.length-1];
                return tp.vj$[name].clazz;
            }
        } else {
        	return null;
        }
   },

    //> public E[] getEnumConstants(vjo.Class<E> clazz)
   getEnumConstants: function(clazz) {
       var tp = vjo.getType(clazz.getName());
       if(tp) {
           return tp._enums;
       } else {
           return [];
       }
    }
})
.endType();