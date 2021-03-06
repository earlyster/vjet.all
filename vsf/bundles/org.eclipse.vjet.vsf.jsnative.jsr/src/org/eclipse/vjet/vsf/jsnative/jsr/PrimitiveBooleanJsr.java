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
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class PrimitiveBooleanJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("PrimitiveBoolean", PrimitiveBooleanJsr.class, "PrimitiveBoolean");

    public PrimitiveBooleanJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected PrimitiveBooleanJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
    
    public static JsTypeRef<PrimitiveBooleanJsr> prototype = new JsTypeRef<PrimitiveBooleanJsr>(S);
}