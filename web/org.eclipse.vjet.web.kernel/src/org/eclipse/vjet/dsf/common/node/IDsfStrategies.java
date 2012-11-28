/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.common.node;

import java.util.Map;

import org.eclipse.vjet.dsf.common.node.visitor.IDNodeHandlingStrategy;
import org.eclipse.vjet.dsf.common.phase.PhaseId;

public interface IDsfStrategies 
	extends Map<PhaseId, IDNodeHandlingStrategy>, Iterable<IDNodeHandlingStrategy>
{
	// empty on purpose
}
