/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.cml.vjetv;





import java.io.File;
import junit.framework.TestCase;

import org.eclipse.vjet.dsf.jstojava.cml.vjetv.core.ArgumentsParser;
import org.eclipse.vjet.dsf.jstojava.cml.vjetv.model.impl.HeadlessParserConfigure;
import org.junit.Assert;
import org.junit.Test;



/**
 * Class/Interface description
 *
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
public class VjetvBugFixTests extends TestCase {
    HeadlessParserConfigure m_conf = null;

    public final static String BLANK = ArgumentsParser.BLANK;

    ArgumentsParser m_parser = new ArgumentsParser();
    
    private static String currentPath = System.getProperty("user.dir");


    @Test
    //@Category( { P1, FAST, UNIT })
    //@Description("Test line is null")
    public void testBug11711() {
        String command = "@testBp" + File.separator + "ArgFile1.txt";
        m_conf = new HeadlessParserConfigure();
        m_parser.parser(command.split(BLANK), m_conf);
        m_parser.initEnv(m_conf);
        Assert.assertEquals(2, m_conf.getValidatedJSFiles().size());
    }
    
    // REMOVING TESTS DUE TO .jar dependency issue
//    @Test
//    //@Category( { P1, FAST, UNIT })
//    //@Description("Test null parameter")
//    public void testBug11712() {
//        ArrayList<File> lists = new ArrayList<File>();
//        lists.add(new File(currentPath + "/testBp/testJS.jar"));
//        Assert.assertEquals(false, FileOperator.isJarJsPathValid(
//                "access/inherits/false", lists, false));
//    }
//    
//    @Test
//    //@Category( { P1, FAST, UNIT })
//    //@Description("Test null parameter")
//    public void testBug11714() {
//        ArrayList<File> lists = new ArrayList<File>();
//        lists.add(new File(currentPath + "/testBp/testJS.jar"));
//        Assert.assertEquals(false, FileOperator.isJarJsPathValid(
//                "access/inherits/false", lists, false));
//    }
//    
//    @Test
//    //@Category( { P1, FAST, UNIT })
//    //@Description("Test print null parameter")
//    public void testBug11713() {
//        ArrayList<File> lists = new ArrayList<File>();
//        lists.add(new File(currentPath + "/testBp/testJS.jar"));
//        Assert.assertEquals(true, FileOperator.isJarJsPathValid(
//                "access/inherits/Person.js", lists, false));
//    }
    
}
