package org.eclipse.vjet.vjo.java.lang;

import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.IntegerJsr;
import org.eclipse.vjet.vjo.java.lang.NumberFormatExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.UtilJsr;
import org.eclipse.vjet.vjo.java.lang.NumberUtilJsr;
import org.eclipse.vjet.vjo.java.lang.ComparableJsr;
import org.eclipse.vjet.vjo.java.lang.NumberJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public final class ShortJsr extends NumberJsr implements ComparableJsr<org.eclipse.vjet.vjo.java.lang.ShortJsr> {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.lang.Short", ShortJsr.class, "Short");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(IntegerJsr.ResourceSpec.getInstance())
        .addDependentComponent(NumberFormatExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(UtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(NumberUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(ComparableJsr.ResourceSpec.getInstance())
        .addDependentComponent(NumberJsr.ResourceSpec.getInstance());

    protected ShortJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

}