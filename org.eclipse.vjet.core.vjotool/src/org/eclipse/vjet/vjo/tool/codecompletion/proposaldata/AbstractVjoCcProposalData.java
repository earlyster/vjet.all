/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.tool.codecompletion.proposaldata;

import org.eclipse.vjet.vjo.tool.codecompletion.IVjoCcProposalData;

public abstract class AbstractVjoCcProposalData implements IVjoCcProposalData {

	private boolean accurateMatch = true;
	
	public boolean isAccurateMatch() {
		return accurateMatch;
	}
	
	public void setAccurateMatch(boolean match) {
		this.accurateMatch = match;
	}

}
