/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.jsnative.anno.BrowserSupport;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;
import org.eclipse.vjet.dsf.jsnative.anno.Constructor;
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.eclipse.vjet.dsf.jsnative.global.String;

/**
 * DOMException describes DOM exception. 
 *
 */
public interface DOMException {
	
	/**
	 * An integer indicating the type of error generated.
	 * @return
	 */
	@Property short getCode();

	
	// ExceptionCode
    public static final short INDEX_SIZE_ERR            = 1;
    public static final short DOMSTRING_SIZE_ERR        = 2;
    public static final short HIERARCHY_REQUEST_ERR     = 3;
    public static final short WRONG_DOCUMENT_ERR        = 4;
    public static final short INVALID_CHARACTER_ERR     = 5;
    public static final short NO_DATA_ALLOWED_ERR       = 6;
    public static final short NO_MODIFICATION_ALLOWED_ERR = 7;
    public static final short NOT_FOUND_ERR             = 8;
    public static final short NOT_SUPPORTED_ERR         = 9;
    public static final short INUSE_ATTRIBUTE_ERR       = 10;
    public static final short INVALID_STATE_ERR         = 11;
    public static final short SYNTAX_ERR                = 12;
    public static final short INVALID_MODIFICATION_ERR  = 13;
    public static final short NAMESPACE_ERR             = 14;
    public static final short INVALID_ACCESS_ERR        = 15;
    public static final short VALIDATION_ERR = 16; // historical
    public static final short TYPE_MISMATCH_ERR = 17;
    public static final short SECURITY_ERR = 18;
    public static final short NETWORK_ERR = 19;
    public static final short ABORT_ERR = 20;
    public static final short URL_MISMATCH_ERR = 21;
    public static final short QUOTA_EXCEEDED_ERR = 22;
    public static final short TIMEOUT_ERR = 23;
    public static final short INVALID_NODE_TYPE_ERR = 24;
    public static final short DATA_CLONE_ERR = 25;
	
    @Constructor void DOMException();
    
	@Constructor void DOMException(int errorCode);
	
	/**
     * Only for Rhino support
     * @param type
     * @return
     */
	@BrowserSupport({BrowserType.RHINO_1P})
    @Function Object valueOf(String type);
}
