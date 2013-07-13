/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.vjet.eclipse.internal.ui.text.completion;

import org.eclipse.vjet.eclipse.core.search.matching.ICategoryRequestor;
import org.eclipse.dltk.mod.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;

/**
 * 
 * 
 */
public class VjoTypeCompletionProposalComputer extends
		AbstractVjoCompletionProposalComputer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.vjet.eclipse.internal.ui.text.completion.AbstractVjoCompletionProposalComputer#getRequestorCategory()
	 */
	@Override
	protected String getRequestorCategory() {
		return ICategoryRequestor.TYPE_CATEGORY;
	}

	@Override
	protected TemplateCompletionProcessor createTemplateProposalComputer(
			ScriptContentAssistInvocationContext context) {
		return null;
	}
}
