/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.vjet.dsf.jst.validation.vjo;

import org.eclipse.vjet.dsf.jst.IJstParseController;
import org.eclipse.vjet.dsf.jst.ts.JstTypeSpaceMgr;
import org.eclipse.vjet.dsf.jstojava.controller.JstParseController;
import org.eclipse.vjet.dsf.jstojava.loader.DefaultJstTypeLoader;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.vjo.lib.TsLibLoader;

/**
 * Syntax space loader
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
public class SingleTypeSpaceLoader {
	
	
	private JstTypeSpaceMgr singleTypeSpace = initSingleTypeSpace();

	private static SingleTypeSpaceLoader tsl = new SingleTypeSpaceLoader();
	
	private SingleTypeSpaceLoader(){
	    
	}
	
	/**
	 * Get single type space loader
	 * 
	 * @return {@link SingleTypeSpaceLoader}
	 */
	public static synchronized SingleTypeSpaceLoader getInstance(){
	    return tsl;
	}
	
	private JstTypeSpaceMgr initSingleTypeSpace(){
	    JstTypeSpaceMgr ts = null;
        try {
            IJstParseController controller = new JstParseController(
                    new VjoParser());
            ts = new JstTypeSpaceMgr(controller, new DefaultJstTypeLoader());
            ts.initialize();
            TsLibLoader.loadDefaultLibs(ts);
        }catch(Exception e){
        }
        return ts;
	}

    /**
     * Return JstTypeSPaceMgr
     * @return {@link JstTypeSpaceMgr}
     */
    public JstTypeSpaceMgr getSingleTypeSpace() {
        return singleTypeSpace;
    }
}
