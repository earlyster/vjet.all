/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative.file;

import org.eclipse.vjet.dsf.jsnative.anno.OverLoadFunc;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/*
 *   interface Blob {
      
      readonly attribute unsigned long long size;
      readonly attribute DOMString type;
      
      //slice Blob into byte-ranged chunks
      
      Blob slice(in optional long long start,
                 in optional long long end,
                 in [TreatUndefinedAs=EmptyString] optional DOMString contentType); 
    
    };
    
 */
public interface Blob {

	@Property long getSize();
	@Property String getType();
	@OverLoadFunc Blob slice(long start, long end, String content);
	@OverLoadFunc Blob slice(long start, long end);
	@OverLoadFunc Blob slice(long start);
}
