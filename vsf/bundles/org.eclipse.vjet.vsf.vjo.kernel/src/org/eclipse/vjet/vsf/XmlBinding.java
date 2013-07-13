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

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.vsf.IBinding;
import org.eclipse.vjet.vsf.Message;

//NativeJsProxy for vjo.dsf.XmlBinding.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class XmlBinding extends NativeJsProxy implements IBinding {

    /** for framework use only */
    @AExclude
    public XmlBinding(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected XmlBinding(Object ...args){
        super(args);
    }

    public XmlBinding() {
        super();
    }

    public String serialize(Message message) {
        return callWithName("serialize", String.class, message);
    }

    public void deserialize(Message message) {
        callWithName("deserialize", message);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<XmlBinding> prototype = NativeJsTypeRef.get(XmlBinding.class);

    public final INativeJsFuncProxy<XmlBinding> serialize = NativeJsFuncProxy.create(this, "serialize");

    public final INativeJsFuncProxy<XmlBinding> deserialize = NativeJsFuncProxy.create(this, "deserialize");
}