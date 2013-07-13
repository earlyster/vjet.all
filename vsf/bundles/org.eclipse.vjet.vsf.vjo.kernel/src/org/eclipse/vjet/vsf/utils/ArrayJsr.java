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
package org.eclipse.vjet.vsf.utils;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ArrayJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.Array", ArrayJsr.class, "Array");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public ArrayJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ArrayJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Object[]> copy(Object[] poSrcArr){
        return call(S, Object[].class, "copy").with(poSrcArr);
    }

    public static JsFunc<Object[]> remove(Object[] poSrcArr, int piIndex, String psValue){
        return call(S, Object[].class, "remove").with(poSrcArr, piIndex, psValue);
    }

    public static JsFunc<Object[]> remove(IValueBinding<Object[]> poSrcArr, IValueBinding<Integer> piIndex, IValueBinding<String> psValue){
        return call(S, Object[].class, "remove").with(poSrcArr, piIndex, psValue);
    }

    public static JsFunc<Object[]> insert(Object[] poSrcArr, int piIndex, String psValue){
        return call(S, Object[].class, "insert").with(poSrcArr, piIndex, psValue);
    }

    public static JsFunc<Object[]> insert(IValueBinding<Object[]> poSrcArr, IValueBinding<Integer> piIndex, IValueBinding<String> psValue){
        return call(S, Object[].class, "insert").with(poSrcArr, piIndex, psValue);
    }

    public static JsFunc<Object[]> shift(Object[] poSrcArr, int piIndex){
        return call(S, Object[].class, "shift").with(poSrcArr, piIndex);
    }

    public static JsFunc<Object[]> shift(IValueBinding<Object[]> poSrcArr, IValueBinding<Integer> piIndex){
        return call(S, Object[].class, "shift").with(poSrcArr, piIndex);
    }

    public static JsFunc<Boolean> contains(Object[] poSrcArr, Object poObject){
        return call(S, Boolean.class, "contains").with(poSrcArr, poObject);
    }
    
    public static JsTypeRef<ArrayJsr> prototype = new JsTypeRef<ArrayJsr>(S);
}