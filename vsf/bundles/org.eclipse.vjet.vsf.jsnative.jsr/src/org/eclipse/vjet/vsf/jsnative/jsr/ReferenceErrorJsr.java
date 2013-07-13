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
package org.eclipse.vjet.vsf.jsnative.jsr;
import org.eclipse.vjet.vsf.jsnative.jsr.ErrorJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ReferenceErrorJsr extends ErrorJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("ReferenceError", ReferenceErrorJsr.class, "ReferenceError");

    public ReferenceErrorJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ReferenceErrorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
    
    public static JsTypeRef<ReferenceErrorJsr> prototype = new JsTypeRef<ReferenceErrorJsr>(S);
}