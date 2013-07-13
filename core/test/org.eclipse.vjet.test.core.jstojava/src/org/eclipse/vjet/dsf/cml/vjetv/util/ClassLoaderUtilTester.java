/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.cml.vjetv.util;

import org.eclipse.vjet.dsf.jstojava.cml.vjetv.util.ClassLoaderUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class/Interface description
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
public class ClassLoaderUtilTester {

    @Test
    public void test1() {
        Assert.assertNotNull(ClassLoaderUtil.getExtClassLoader());
    }

    @Test
    public void test2() {
        Assert.assertNotNull(ClassLoaderUtil.getSystemClassLoader());
    }

    @Test
    public void test5() {
        Assert.assertTrue(ClassLoaderUtil.getExtClassPath().length > 0);
    }

    @Test
    public void test6() {
        Assert.assertTrue(ClassLoaderUtil.getExtURLs().length > 0);
    }

    @Test
    public void test7() {
        Assert.assertTrue(ClassLoaderUtil.getSystemClassPath().length > 0);
    }

    @Test
    public void test8() {
        Assert.assertTrue(ClassLoaderUtil.getSystemURLs().length > 0);
    }

}
