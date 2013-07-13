package org.eclipse.vjet.vjo.java.util;

import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vjo.java.lang.ComparableJsr;
import org.eclipse.vjet.vjo.java.lang.NullPointerExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.UnsupportedOperationExceptionJsr;
import org.eclipse.vjet.vjo.java.util.NoSuchElementExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.ClassCastExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IndexOutOfBoundsExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.IllegalArgumentExceptionJsr;
import org.eclipse.vjet.vjo.java.lang.SystemJsr;
import org.eclipse.vjet.vjo.java.lang.reflect.ArrayJsr;
import org.eclipse.vjet.vjo.java.util.RandomAccessJsr;
import org.eclipse.vjet.vjo.java.util.ListJsr;
import org.eclipse.vjet.vjo.java.util.MapJsr;
import org.eclipse.vjet.vjo.java.util.AbstractSetJsr;
import org.eclipse.vjet.vjo.java.util.IteratorJsr;
import org.eclipse.vjet.vjo.java.util.AbstractListJsr;
import org.eclipse.vjet.vjo.java.util.AbstractMapJsr;
import org.eclipse.vjet.vjo.java.lang.ObjectUtilJsr;
import org.eclipse.vjet.vjo.java.util.RandomJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CollectionsJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("org.eclipse.vjet.vjo.java.util.Collections", CollectionsJsr.class, "Collections");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ComparableJsr.ResourceSpec.getInstance())
        .addDependentComponent(NullPointerExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(UnsupportedOperationExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(NoSuchElementExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(ClassCastExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IndexOutOfBoundsExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(IllegalArgumentExceptionJsr.ResourceSpec.getInstance())
        .addDependentComponent(SystemJsr.ResourceSpec.getInstance())
        .addDependentComponent(ArrayJsr.ResourceSpec.getInstance())
        .addDependentComponent(RandomAccessJsr.ResourceSpec.getInstance())
        .addDependentComponent(ListJsr.ResourceSpec.getInstance())
        .addDependentComponent(MapJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractSetJsr.ResourceSpec.getInstance())
        .addDependentComponent(IteratorJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractListJsr.ResourceSpec.getInstance())
        .addDependentComponent(AbstractMapJsr.ResourceSpec.getInstance())
        .addDependentComponent(ObjectUtilJsr.ResourceSpec.getInstance())
        .addDependentComponent(RandomJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ArraysJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ComparatorJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.CollectionJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.SetJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.SortedSetJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.SortedMapJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.EnumerationJsr.ResourceSpec.getInstance())
        .addDependentComponent(org.eclipse.vjet.vjo.java.util.ArrayListJsr.ResourceSpec.getInstance());

    protected CollectionsJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static interface SelfComparableJsr extends ComparableJsr<org.eclipse.vjet.vjo.java.util.CollectionsJsr.SelfComparableJsr> {
    }
    public static class UnmodifiableCollectionJsr<E> extends JsObj implements CollectionJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableCollection", UnmodifiableCollectionJsr.class, "Collections");

        protected UnmodifiableCollectionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class UnmodifiableSetJsr<E> extends UnmodifiableCollectionJsr<E> implements SetJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableSet", UnmodifiableSetJsr.class, "Collections");

        protected UnmodifiableSetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class UnmodifiableSortedSetJsr<E> extends UnmodifiableSetJsr<E> implements SortedSetJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableSortedSet", UnmodifiableSortedSetJsr.class, "Collections");

        protected UnmodifiableSortedSetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class UnmodifiableListJsr<E> extends UnmodifiableCollectionJsr<E> implements ListJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableList", UnmodifiableListJsr.class, "Collections");

        protected UnmodifiableListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class UnmodifiableRandomAccessListJsr<E> extends UnmodifiableListJsr<E> implements RandomAccessJsr {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableRandomAccessList", UnmodifiableRandomAccessListJsr.class, "Collections");

        protected UnmodifiableRandomAccessListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class UnmodifiableMapJsr<K,V> extends JsObj implements MapJsr<K,V> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableMap", UnmodifiableMapJsr.class, "Collections");

        protected UnmodifiableMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }

        public static class UnmodifiableEntrySetJsr<K,V> extends UnmodifiableSetJsr<org.eclipse.vjet.vjo.java.util.MapJsr.EntryJsr> {
            private static final long serialVersionUID = 1L;

            private static final JsObjData S = 
                new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet", UnmodifiableEntrySetJsr.class, "Collections");

            protected UnmodifiableEntrySetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
                super(cmpMeta, isInstance, args);
            }

            public static class UnmodifiableEntryJsr<K,V> extends JsObj implements EntryJsr<K,V> {
                private static final long serialVersionUID = 1L;

                private static final JsObjData S = 
                    new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry", UnmodifiableEntryJsr.class, "Collections");

                protected UnmodifiableEntryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
                    super(cmpMeta, isInstance, args);
                }
            }
        }
    }
    public static class UnmodifiableSortedMapJsr<K,V> extends UnmodifiableMapJsr<K,V> implements SortedMapJsr<K,V> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.UnmodifiableSortedMap", UnmodifiableSortedMapJsr.class, "Collections");

        protected UnmodifiableSortedMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class CheckedCollectionJsr<E> extends JsObj implements CollectionJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedCollection", CheckedCollectionJsr.class, "Collections");

        protected CheckedCollectionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class CheckedSetJsr<E> extends CheckedCollectionJsr<E> implements SetJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedSet", CheckedSetJsr.class, "Collections");

        protected CheckedSetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class CheckedSortedSetJsr<E> extends CheckedSetJsr<E> implements SortedSetJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedSortedSet", CheckedSortedSetJsr.class, "Collections");

        protected CheckedSortedSetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class CheckedListJsr<E> extends CheckedCollectionJsr<E> implements ListJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedList", CheckedListJsr.class, "Collections");

        protected CheckedListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class CheckedRandomAccessListJsr<E> extends CheckedListJsr<E> implements RandomAccessJsr {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedRandomAccessList", CheckedRandomAccessListJsr.class, "Collections");

        protected CheckedRandomAccessListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class CheckedMapJsr<K,V> extends JsObj implements MapJsr<K,V> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedMap", CheckedMapJsr.class, "Collections");

        protected CheckedMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }

        public static class CheckedEntrySetJsr<K,V> extends JsObj implements SetJsr<org.eclipse.vjet.vjo.java.util.MapJsr.EntryJsr> {
            private static final long serialVersionUID = 1L;

            private static final JsObjData S = 
                new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedMap.CheckedEntrySet", CheckedEntrySetJsr.class, "Collections");

            protected CheckedEntrySetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
                super(cmpMeta, isInstance, args);
            }

            public static class CheckedEntryJsr<K,V> extends JsObj implements EntryJsr<K,V> {
                private static final long serialVersionUID = 1L;

                private static final JsObjData S = 
                    new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry", CheckedEntryJsr.class, "Collections");

                protected CheckedEntryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
                    super(cmpMeta, isInstance, args);
                }
            }
        }
    }
    public static class CheckedSortedMapJsr<K,V> extends CheckedMapJsr<K,V> implements SortedMapJsr<K,V> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CheckedSortedMap", CheckedSortedMapJsr.class, "Collections");

        protected CheckedSortedMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class SingletonSetJsr<E> extends AbstractSetJsr<E> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.SingletonSet", SingletonSetJsr.class, "Collections");

        protected SingletonSetJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class SingletonListJsr<E> extends AbstractListJsr<E> implements RandomAccessJsr {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.SingletonList", SingletonListJsr.class, "Collections");

        protected SingletonListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class SingletonMapJsr<K,V> extends AbstractMapJsr<K,V> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.SingletonMap", SingletonMapJsr.class, "Collections");

        protected SingletonMapJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }

        public static class ImmutableEntryJsr<K,V> extends JsObj implements MapJsr<K,V> {
            private static final long serialVersionUID = 1L;

            private static final JsObjData S = 
                new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.SingletonMap.ImmutableEntry", ImmutableEntryJsr.class, "Collections");

            protected ImmutableEntryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
                super(cmpMeta, isInstance, args);
            }
        }
    }
    public static class CopiesListJsr<E> extends AbstractListJsr<E> implements RandomAccessJsr {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.CopiesList", CopiesListJsr.class, "Collections");

        protected CopiesListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class ReverseComparatorJsr<T> extends JsObj implements ComparatorJsr<org.eclipse.vjet.vjo.java.lang.ComparableJsr> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.ReverseComparator", ReverseComparatorJsr.class, "Collections");

        protected ReverseComparatorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
    public static class ReverseComparatorWithComparatorJsr<T> extends JsObj implements ComparatorJsr<T> {
        private static final long serialVersionUID = 1L;

        private static final JsObjData S = 
            new JsObjData("org.eclipse.vjet.vjo.java.util.Collections.ReverseComparatorWithComparator", ReverseComparatorWithComparatorJsr.class, "Collections");

        protected ReverseComparatorWithComparatorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
            super(cmpMeta, isInstance, args);
        }
    }
}