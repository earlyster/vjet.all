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
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.mozilla.mod.javascript.IWillBeScriptable;
/*
 * interface MediaError {
  const unsigned short MEDIA_ERR_ABORTED = 1;
  const unsigned short MEDIA_ERR_NETWORK = 2;
  const unsigned short MEDIA_ERR_DECODE = 3;
  const unsigned short MEDIA_ERR_SRC_NOT_SUPPORTED = 4;
  readonly attribute unsigned short code;
};
 */
@Alias("MediaError")
@JsMetatype
public interface MediaError extends IWillBeScriptable{

	@AJavaOnly @ARename(name="'MEDIA_ERR_ABORTED'")
	short MEDIA_ERR_ABORTED = 1 ;
	@AJavaOnly @ARename(name="'MEDIA_ERR_NETWORK'")
	short MEDIA_ERR_NETWORK = 2 ;
	@AJavaOnly @ARename(name="'MEDIA_ERR_DECODE'")
	short MEDIA_ERR_DECODE = 3 ;
	@AJavaOnly @ARename(name="'MEDIA_ERR_SRC_NOT_SUPPORTED'")
	short MEDIA_ERR_SRC_NOT_SUPPORTED = 4 ;
	
	@Property short getCode();
}
