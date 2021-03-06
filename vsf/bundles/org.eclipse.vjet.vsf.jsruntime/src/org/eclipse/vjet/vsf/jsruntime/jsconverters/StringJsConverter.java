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
package org.eclipse.vjet.vsf.jsruntime.jsconverters;

import java.util.List;

import org.eclipse.vjet.dsf.common.converter.BaseConverter;
import org.eclipse.vjet.dsf.common.converter.IConversionResult;
import org.eclipse.vjet.dsf.common.converter.IConverter;
import org.eclipse.vjet.dsf.json.JsonObject;

public class StringJsConverter extends BaseConverter<String> {

	private static final List<Class> VALID_CONVERSION_TYPES ;
	
	static {
		final Class[] types = {
			String.class} ;
			
		VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
	}	
	

//	private static String escape(String s) {
//		String xs = s;
//		// Pattern.compile("\\\"").matcher(s).replaceAll("\\\"");
//		xs = xs.replaceAll("\\\"", "\\\\\"");
//		xs = xs.replaceAll("\\\'", "\\\\\'");
//		return xs;
//	}

	public IConversionResult<String> convert(Object toBeConverted) {
		if (toBeConverted instanceof String) {
//			if (toBeConverted.equals("event") || toBeConverted.equals("request")
//					|| toBeConverted.equals("message")) {
//				return setResult(toBeConverted,(String) toBeConverted);
//			} else {
			String escapedValue = JsonObject.quote((String) toBeConverted);
			return setResult(toBeConverted,escapedValue);
			//}
		}
		return setResult(toBeConverted, IConverter.UnconvertableValueConversionError);
	}

	public Class<String> getTargetType() {
		return String.class;
	}

	public List<Class> getValidConversionTypes() {
		return VALID_CONVERSION_TYPES;
	}

}
