/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core.validation;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticRulePolicy;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoValidationDriver;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoValidationResult;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.IScriptProblem;
import org.eclipse.vjet.vjo.tool.typespace.TypeSpaceMgr;

/**
 * Basic validation
 *
 * @author <a href="mailto:liama@ebay.com">liama</a>
 * @since JDK 1.5
 */
public class BasicValidator extends AbstractValidator{

	private static BasicValidator validator = null;
	
	/**
	 * Add single invoke method
	 * @return BasicValidator
	 */
	public synchronized static BasicValidator getInstance(){
		if(validator == null){
			return new BasicValidator();
		}
		return validator;
	}
	


	
	/**
     * 
     * Do validate with IScriptUnit
     * @param jstType {@link IScriptUnit}
     * @return list
     */
	public List<IScriptProblem> doValidate(IJstType scriptUnit) {

		List<IJstType> typeList = new LinkedList<IJstType>();
		typeList.add(scriptUnit);

		// initPolicySettings();

		VjoValidationDriver driver = new VjoValidationDriver();
		driver.setTypeSpaceMgr(TypeSpaceMgr.getInstance().getController()
				.getJstTypeSpaceMgr());

		VjoValidationResult result = driver.validateComplete(typeList,
				scriptUnit.getPackage().getGroupName(),VjoValidationDriver.VjoValidationMode.validateType);

		List<IScriptProblem> problems = new LinkedList<IScriptProblem>();
		for (VjoSemanticProblem prob : result.getAllProblems()) {
			problems.add(prob);
		}

		return problems;
	}

	/**
	 * Get rule policy
	 * @param severity
	 * @return
	 */
	public VjoSemanticRulePolicy getRulePolicy(String severity) {
		if ("error".equalsIgnoreCase(severity)) {
			return VjoSemanticRulePolicy.GLOBAL_ERROR_POLICY;
		} else if ("warning".equalsIgnoreCase(severity)) {
			return VjoSemanticRulePolicy.GLOBAL_WARNING_POLICY;
		} else if ("ignore".equalsIgnoreCase(severity)) {
			return VjoSemanticRulePolicy.GLOBAL_IGNORE_POLICY;
		}
		return VjoSemanticRulePolicy.GLOBAL_ERROR_POLICY;
	}

    /* (non-Javadoc)
     * @see org.eclipse.vjet.eclipse.core.validation.IValidator#deriveResources(java.lang.Object)
     */
    public Set<IResource> deriveResources(Object object) {
        return null;
    }
}
