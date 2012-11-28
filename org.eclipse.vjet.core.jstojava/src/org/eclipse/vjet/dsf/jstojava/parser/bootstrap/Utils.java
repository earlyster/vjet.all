/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.parser.bootstrap;

import java.io.PrintWriter;

import org.eclipse.vjet.dsf.jsgen.shared.generate.CodeStyle;
import org.eclipse.vjet.dsf.jsgen.shared.generate.DefaultJsrFilters;
import org.eclipse.vjet.dsf.jsgen.shared.generate.GeneratorConfig;
import org.eclipse.vjet.dsf.jsgen.shared.generate.JsrGenerator;
import org.eclipse.vjet.dsf.jst.declaration.JstType;

public class Utils {

	static JstType removeGuts(JstType type3) {
		type3.clearMethods();
		type3.clearProperties();
		type3.clearEmbeddedTypes();
		return type3;
	}

	static JsrGenerator createGenerator(PrintWriter pw2) {
		GeneratorConfig genconfig = new GeneratorConfig(new DefaultJsrFilters());
		
		genconfig.getJsrGenConfig().setGenResouceSpec(false);
		JsrGenerator gen2 = new JsrGenerator(pw2, CodeStyle.PRETTY, genconfig);
		
		return gen2;
	}

}
