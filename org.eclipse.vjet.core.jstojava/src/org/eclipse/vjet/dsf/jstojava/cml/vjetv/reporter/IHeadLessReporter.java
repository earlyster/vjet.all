/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.cml.vjetv.reporter;

import java.io.File;

import org.eclipse.vjet.dsf.jstojava.cml.vjetv.model.IHeadLessLauncherResult;
import org.eclipse.vjet.dsf.jstojava.cml.vjetv.model.IHeadlessLauncherConfigure;

/**
 * Class/Interface description
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
public interface IHeadLessReporter {

    /**
     * Generate reporter
     * 
     * @param result
     *            {@link IHeadLessLauncherResult}
     * @param conf
     *            {@link IHeadlessLauncherConfigure}
     * @param valdiateFile
     *            {@link File}
     */
    public void generateReport(IHeadLessLauncherResult result,
            IHeadlessLauncherConfigure conf);

    /**
     * Print current message
     * 
     * @param message
     *            {@link String}
     */
    public void printCurrentStates(String message);

    /**
     * print summary information
     * 
     * @param result
     *            {@link IHeadLessLauncherResult}
     */
    public void printSummaryInformation(IHeadLessLauncherResult result);

}
