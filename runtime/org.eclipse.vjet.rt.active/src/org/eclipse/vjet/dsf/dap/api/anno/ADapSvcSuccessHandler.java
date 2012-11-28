/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.dap.api.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.vjet.dsf.service.IServiceSpec;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ADapSvcSuccessHandler {
	Class<? extends IServiceSpec> svcSpec();
	String svcName() default "";
	String op() default "";
}
