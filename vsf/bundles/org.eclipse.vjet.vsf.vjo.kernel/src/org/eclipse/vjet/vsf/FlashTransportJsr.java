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
package org.eclipse.vjet.vsf;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.ErrorJsr;
import org.eclipse.vjet.vsf.ITransportJsr;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.SvcConfigJsr;
import org.eclipse.vjet.vsf.SvcErrJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class FlashTransportJsr extends JsObj implements ITransportJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.FlashTransport", FlashTransportJsr.class, "FlashTransport");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ITransportJsr.ResourceSpec.getInstance())
        .addDependentComponent(ErrorJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance())
        .addDependentComponent(SvcConfigJsr.ResourceSpec.getInstance())
        .addDependentComponent(SvcErrJsr.ResourceSpec.getInstance());

    public FlashTransportJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected FlashTransportJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> handleRequest(MessageJsr message, Object callback){
        return call("handleRequest").with(message, callback);
    }

    public JsFunc<Void> handleRequest(IValueBinding<? extends MessageJsr> message, IValueBinding<Object> callback){
        return call("handleRequest").with(message, callback);
    }
    
    public static JsTypeRef<FlashTransportJsr> prototype = new JsTypeRef<FlashTransportJsr>(S);
}