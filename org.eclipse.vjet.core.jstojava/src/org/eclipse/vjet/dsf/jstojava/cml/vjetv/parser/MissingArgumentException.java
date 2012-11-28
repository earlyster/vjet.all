/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.cml.vjetv.parser;

/**
 * Class/Interface description
 * 
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
public class MissingArgumentException extends ParseException {
    /** The option requiring additional arguments */
    private Option option;

    /**
     * Construct a new <code>MissingArgumentException</code> with the
     * specified detail message.
     * 
     * @param message
     *            the detail message
     */
    public MissingArgumentException(String message) {
        super(message);
    }

    /**
     * Construct a new <code>MissingArgumentException</code> with the
     * specified detail message.
     * 
     * @param option
     *            the option requiring an argument
     * @since 1.2
     */
    public MissingArgumentException(Option option) {
        this("Missing argument for option: " + option.getKey());
        this.option = option;
    }

    /**
     * Return the option requiring an argument that wasn't provided on the
     * command line.
     * 
     * @return the related option
     * @since 1.2
     */
    public Option getOption() {
        return option;
    }
}
