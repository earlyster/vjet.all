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

import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.mozilla.mod.javascript.IWillBeScriptable;
@Alias("DOMInput")
@JsMetatype
public interface DomInput extends IWillBeScriptable {

//	@Property DomReader getCharacterStream();
//	@Property void setCharacterStream(DomReader charStream);
	@Property DomInputStream getByteStream();
	@Property void setByteStream(DomInputStream byteStream);
	@Property String getStringData();
	@Property void setStringData(String stringData);	
	@Property String getSystemId();
	@Property void setSystemId(String systemId);	
	@Property String getEncoding();
	@Property void setEncoding(String encoding);
	@Property String getPublicId();
	@Property void setPublicId(String publicId);	
	@Property String getBaseURI();
	@Property void setBaseURI(String baseURI);	
	@Property boolean getCertified();
	@Property void setCertified(boolean certified);	
}
