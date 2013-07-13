/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.dltk.mod.compiler.problem.DefaultProblem;
import org.eclipse.dltk.mod.core.DLTKCore;
import org.eclipse.vjet.af.common.error.ErrorList;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.core.validation.utils.ProblemUtility;

public class ValidationEntry {

	public static List<DefaultProblem> validate(String fileName,
			IJstType jstType, ErrorList errors, ErrorList warnings) {

		List<DefaultProblem> probs = new ArrayList<DefaultProblem>();

		if (errors != null) {
			probs.addAll(ProblemUtility.reportErrors(fileName,
					errors));
		}

		if (probs.size() == 0) { // if syntax error, no need to do semantics
									// check.
			probs.addAll(validator(jstType));
		}

		if (warnings != null) {
			probs.addAll(ProblemUtility.reportWarnings(fileName, warnings));
		}

		return probs;

	}


	public static List<DefaultProblem> validator(IJstType jstType) {
		// Modify by Eric.ma for remvoe extension point
		List<DefaultProblem> probs = new ArrayList<DefaultProblem>();
		try {
			probs.addAll(BasicValidator.getInstance().validate(jstType));
		} catch (CoreException e1) {
			DLTKCore.error(e1.toString(), e1);
		}
		// End of modified
		return probs;
	}

//	private static boolean isValidVJOType(IJstType unit) {
//		if (unit.getJstBlockList().size() == 1) {
//			for (BaseJstNode jstNode : unit.getJstBlockList().get(0)
//					.getChildren()) {
//				return innerSFindIdentifer(jstNode);
//			}
//		}
//		return false;
//	}

//	private static boolean innerSFindIdentifer(IJstNode node) {
//		if (node != null && node instanceof JstIdentifier) {
//			if (node.toString().matches("ctype")) {
//				return true;
//			}
//		}
//		for (IJstNode jstNode : node.getChildren()) {
//			if (innerSFindIdentifer(jstNode)) {
//				return true;
//			} else {
//				continue;
//			}
//		}
//		return false;
//	}

	/**
	 * @return the enableVjetValidation
	 */
	public static boolean isEnableVjetValidation() {
		// TODO add 
	    Preferences ps = VjetPlugin.getDefault().getPluginPreferences();
	    return ps.getBoolean(VjetPlugin.VJETVALIDATION);
	}
}
