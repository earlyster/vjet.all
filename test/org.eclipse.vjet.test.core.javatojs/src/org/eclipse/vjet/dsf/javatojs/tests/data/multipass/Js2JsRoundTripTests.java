/*******************************************************************************
 * Copyright (c) 2005-2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.javatojs.tests.data.multipass;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.eclipse.vjet.dsf.test.utils.BaseRoundTripTest;

@RunWith(value=Parameterized.class)
public class Js2JsRoundTripTests extends BaseRoundTripTest {
	
	@Parameters
	public static Collection data() {
		
		return Arrays.asList( new Object[][] {
				{"Base.vjo"},
				{"D.vjo"},
				{"Dependent.vjo"},
				{"E.vjo"},
				{"F.vjo"},
				{"G.vjo"},
				
		});
	}
	
	public Js2JsRoundTripTests(String inputFileName) {
		super(inputFileName);
	}

}
