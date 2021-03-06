package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.IndexOutOfBoundsExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IllegalArgumentExceptionJsr;
import org.eclipse.vjet.vjo.java.util.NoSuchElementExceptionJsr;
import org.eclipse.vjet.vjo.java.util.AbstractListJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class SubListJsr<E> extends AbstractListJsr<E> {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.SubList", SubListJsr.class, "SubList");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(IndexOutOfBoundsExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IllegalArgumentExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(NoSuchElementExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.IteratorJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ListJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ConcurrentModificationExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractListJsr.ResourceSpec.getInstance());

    protected SubListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
}