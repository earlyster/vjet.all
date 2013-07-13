/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.report;

import java.io.PrintStream;
import java.util.ListIterator;

import org.eclipse.vjet.af.common.error.ErrorArgsInterface;
import org.eclipse.vjet.af.common.error.ErrorFilter;
import org.eclipse.vjet.af.common.error.ErrorId;
import org.eclipse.vjet.af.common.error.ErrorList;
import org.eclipse.vjet.af.common.error.ErrorNamedArgs;
import org.eclipse.vjet.af.common.error.ErrorObject;
import org.eclipse.vjet.af.common.error.ErrorSeverity;
import org.eclipse.vjet.dsf.jstojava.report.ErrorReportPolicy.ReportLevel;


public class DefaultErrorReporter implements ErrorReporter {
	
	public static final String MESSAGE = "message";
	public static final String RESOURCE = "resource";
	public static final String LINE = "line";
	public static final String BEGIN = "begin";
	public static final String END = "end";
	public static final String COLUMN = "column";
	private static final ErrorId s_errorId = new ErrorId("javatojs.error.reporter");
	private static final ErrorFilter s_errorFilter = new ErrorFilter() {
		public boolean matches(ErrorObject errorObject) {
			return errorObject.isError();
		}};
	private static final ErrorFilter s_warningFilter = new ErrorFilter() {
		public boolean matches(ErrorObject errorObject) {
			return errorObject.isWarning();
		}};

	private ErrorList m_errors;
	private PrintStream m_err;
	private boolean m_reportErrors;
	private boolean m_reportWarnings;
	
	
	public DefaultErrorReporter() {
		this(System.err);
	}

	public DefaultErrorReporter(PrintStream err) {
		m_err = err;
		m_reportErrors = true;
		m_reportWarnings = true;
	}

	public void report(ReportLevel level, String message, String resource, int line, int column) {
		if (level == ReportLevel.IGNORE) {
			return;
		}
		if (level == ReportLevel.WARNING) {
			warning(message, resource, line, column);
		} else if (level == ReportLevel.ERROR) {
			error(message, resource, line, column);
		}
		
	}

	public void error(String message, String resource, int line, int column) {
		if (!m_reportErrors || message == null) {
			return;
		}
		ErrorNamedArgs args = new ErrorNamedArgs();
		args.add(MESSAGE, message);
		if (resource != null) {
			args.add(RESOURCE, resource);
		}
		args.add(LINE, String.valueOf(line));
		args.add(COLUMN, String.valueOf(column));
		addError(new ErrorObject(s_errorId, ErrorSeverity.ERROR, args));
	}
	
	public void error(String message, String resource, int beginPos, int endPos, int line, int column) {
		if (!m_reportErrors || message == null) {
			return;
		}
		ErrorNamedArgs args = new ErrorNamedArgs();
		args.add(MESSAGE, message);
		if (resource != null) {
			args.add(RESOURCE, resource);
		}
		args.add(BEGIN,String.valueOf(beginPos));
		args.add(END,String.valueOf(endPos));
		args.add(LINE, String.valueOf(line));
		args.add(COLUMN, String.valueOf(column));
		addError(new ErrorObject(s_errorId, ErrorSeverity.ERROR, args));
	}
	public void warning(String message, String resource, int beginPos, int endPos, int line, int column) {
		if (!m_reportWarnings || message == null) {
			return;
		}
		ErrorNamedArgs args = new ErrorNamedArgs();
		args.add(MESSAGE, message);
		if (resource != null) {
			args.add(RESOURCE, resource);
		}
		args.add(BEGIN,String.valueOf(beginPos));
		args.add(END,String.valueOf(endPos));
		args.add(LINE, String.valueOf(line));
		args.add(COLUMN, String.valueOf(column));
		addError(new ErrorObject(s_errorId, ErrorSeverity.WARNING, args));
	}


	public void warning(String message, String resource, int line, int column) {
		if (!m_reportWarnings || message == null) {
			return;
		}
		ErrorNamedArgs args = new ErrorNamedArgs();
		args.add(MESSAGE, message);
		if (resource != null) {
			args.add(RESOURCE, resource);
		}
		args.add(LINE, String.valueOf(line));
		args.add(COLUMN, String.valueOf(column));
		addError(new ErrorObject(s_errorId, ErrorSeverity.WARNING, args));
	}
	
	public boolean hasErrors() {
		if (m_errors == null) {
			return false;
		}
		return m_errors.hasAnyErrors(s_errorFilter);
	}
	
	public boolean hasWarnings() {
		if (m_errors == null) {
			return false;
		}
		return m_errors.hasAnyErrors(s_warningFilter);
	}

	public void reportErrors() {
		ErrorList errors = getErrors();
		ListIterator iter = errors.listIterator();
		while (iter.hasNext()) {
			ErrorObject eo = (ErrorObject) iter.next();
			m_err.println(formatAsString(eo));
		}
	}

	public void reportWarnings() {
		ErrorList errors = getWarnings();
		ListIterator iter = errors.listIterator();
		while (iter.hasNext()) {
			ErrorObject eo = (ErrorObject) iter.next();
			m_err.println(formatAsString(eo));
		}
	}
	
	public void reportAll() {
		reportErrors();
		reportWarnings();
	}

	public void setReportErrors(boolean value) {
		m_reportErrors = value;
	}

	public void setReportWarnings(boolean value) {
		m_reportWarnings = value;
	}
		
	public ErrorList getErrors() {
		if (m_errors == null) {
			return new ErrorList();
		}
		return m_errors.getAllErrors(s_errorFilter);
	}
	
	public ErrorList getWarnings() {
		if (m_errors == null) {
			return new ErrorList();
		}
		return m_errors.getAllErrors(s_warningFilter);
	}
	
	private synchronized void addError(final ErrorObject error){
		if (m_errors == null){
			m_errors = new ErrorList();
		}
		
		m_errors.add(error);
	}
	
	private String formatAsString(ErrorObject eo) {
		StringBuilder msg = new StringBuilder();
		msg.append(eo.getSeverity().getName() + " : ");
		ErrorArgsInterface params = eo.getParameters();
		msg.append(params.getValueByName(MESSAGE));
//		msg.append(", resource = ");
//		msg.append(params.getValueByName(RESOURCE));
//		msg.append(", line = ");
//		msg.append(params.getValueByName(LINE));
//		msg.append(", column = ");
//		msg.append(params.getValueByName(COLUMN));
		return msg.toString();
	}
}
