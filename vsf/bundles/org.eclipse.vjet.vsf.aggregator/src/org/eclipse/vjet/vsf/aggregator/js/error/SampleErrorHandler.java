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
package org.eclipse.vjet.vsf.aggregator.js.error;


import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.error.SampleErrorHandlerJsr;
import org.eclipse.vjet.vsf.jsruntime.error.IErrorHandler;

public class SampleErrorHandler implements IErrorHandler {

	public IComponentSpec getJsResource() {
		return SampleErrorHandlerJsr.ResourceSpec.getInstance();
	}

	public IJsObjectRef getJsObj() {
		return new SampleErrorHandlerJsr();
	}

}
