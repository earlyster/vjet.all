/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.common;

import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.ValidationCtx;

public interface IJstValidator {

	List<IJstValidationRule> getRules();
	IJstValidationPolicy getValidationPolicy();
	IJstProblemFactory getProblemFactory();
	void validate(ValidationCtx p);
	
}
