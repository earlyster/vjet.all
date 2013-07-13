/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.jstvalidator;

import java.util.Locale;

import org.eclipse.vjet.dsf.jsgen.shared.validation.common.IJstProblemFactory;
import org.eclipse.vjet.dsf.jsgen.shared.validation.common.IProblemMessageProvider;
import org.eclipse.vjet.dsf.jst.IScriptProblem;
import org.eclipse.vjet.dsf.jst.JstProblemId;
import org.eclipse.vjet.dsf.jst.ProblemSeverity;

public class DefaultJstProblemFactory implements IJstProblemFactory {

	
	private IProblemMessageProvider m_message;

	public DefaultJstProblemFactory(IProblemMessageProvider message){
		m_message = message;
	}
	
	public IScriptProblem createProblem(char[] originatingFileName,
			JstProblemId problemId, String[] problemArguments,
			String[] messageArguments, ProblemSeverity severity, int startPosition,
			int endPosition, int lineNumber, int columnNumber) {
		return new DefaultJstProblem(messageArguments,problemId,getLocalizedMessage(problemId, messageArguments),originatingFileName,startPosition,endPosition,lineNumber,columnNumber,severity);
	}

	public Locale getLocale() {
		return Locale.getDefault();
	}

	public String getLocalizedMessage(JstProblemId id, String[] messageArguments) {
		return m_message.getMessage(id, getLocale());
	}



}
