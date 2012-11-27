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
package org.eclipse.dltk.mod.core.tests.parser;

import org.eclipse.dltk.mod.ast.parser.ISourceParser;
import org.eclipse.dltk.mod.core.DLTKLanguageManager;
import org.eclipse.dltk.mod.core.tests.model.AbstractModelTests;
import org.eclipse.dltk.mod.core.tests.model.TestConstants;
import org.eclipse.dltk.mod.core.tests.model.TestSourceParser;

public class SourceParserTests extends AbstractModelTests {

	private static final String PARSER_NAME = "Test Source Parser";
	private static final String PARSER_ID = "org.eclipse.dltk.mod.core.tests.sourceParser";
	private static final int PARSER_PRIORITY = 1;

	public SourceParserTests(String name) {
		super("org.eclipse.dltk.mod.core.tests", name);
	}

	public void testGetSourceParser() {
		ISourceParser parser = null;

		parser = DLTKLanguageManager
				.getSourceParser(TestConstants.NATURE_ID);

		assertNotNull(parser);
		assertTrue((parser instanceof TestSourceParser));

		/*
		 * these tests are 'dependent' upon the two test tests above working -
		 * this could be broken out into its own top level test
		 */
		testParserConfig(parser);
	}

	private void testParserConfig(ISourceParser parser) {
		// these are configured to the same value in plugin.xml
		assertEquals(PARSER_NAME, parser.getName());
		assertEquals(PARSER_NAME, parser.getDescription());

		assertEquals(PARSER_ID, parser.getId());
		assertEquals(TestConstants.NATURE_ID, parser.getNatureId());

		assertEquals(PARSER_PRIORITY, parser.getPriority());
	}

}
