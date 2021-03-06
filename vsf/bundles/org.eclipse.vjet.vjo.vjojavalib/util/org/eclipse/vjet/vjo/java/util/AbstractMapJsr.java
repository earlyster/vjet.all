package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.UnsupportedOperationExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.NullPointerExceptionJsr;
import org.eclipse.vjet.vjo.java.util.AbstractSetJsr;
import org.eclipse.vjet.vjo.java.lang.ClassCastExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.ObjectUtilJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public abstract class AbstractMapJsr<K,V> extends JsObj implements org.eclipse.vjet.vjo.java.util.MapJsr<K,V> {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.AbstractMap", AbstractMapJsr.class, "AbstractMap");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(UnsupportedOperationExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(NullPointerExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractSetJsr.ResourceSpec.getInstance())
        .addDependentComponent(ClassCastExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(ObjectUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.IteratorJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.SetJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.AbstractCollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.MapJsr.ResourceSpec.getInstance());

    protected AbstractMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static class SimpleEntryJsr<K,V> extends JsObj implements EntryJsr<K,V> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.AbstractMap.SimpleEntry", SimpleEntryJsr.class, "AbstractMap");

        protected SimpleEntryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
}