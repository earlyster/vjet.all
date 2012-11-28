/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.comment.parser;

import org.eclipse.vjet.dsf.jst.util.bootstrap.JsBuilderDef;

public class TestDefs {

	static JsBuilderDef CTYPE;

	static {
		CTYPE = new JsBuilderDef("vjo", "ctype")
				.anyOrder(
					new JsBuilderDef()
					.mtd("a", 0, 1)
					.mtd("b", 0, 1))
				.mtd("d", 0,1);
	}

}
