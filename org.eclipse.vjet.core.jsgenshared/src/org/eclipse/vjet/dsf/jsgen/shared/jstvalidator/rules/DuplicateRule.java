/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.rules;

import org.eclipse.vjet.dsf.jsgen.shared.ids.FieldProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.ScopeIds;
import org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.BaseJstRuleSpec;
import org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.ValidationCtx;
import org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.library.UniquenessValidator;
import org.eclipse.vjet.dsf.jsgen.shared.validation.common.BaseJstValidationRule;
import org.eclipse.vjet.dsf.jsgen.shared.validation.common.IJstValidationRuleSpec;
import org.eclipse.vjet.dsf.jsgen.shared.validation.common.JstProcessingState;
import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstType;

public class DuplicateRule extends BaseJstValidationRule {

	private static BaseJstRuleSpec SPEC = new BaseJstRuleSpec().addProblem(
			FieldProbIds.DuplicateField).addScope(ScopeIds.PROPS).addScope(
			ScopeIds.PROTOS).addScope(ScopeIds.METHOD).setState(JstProcessingState.IMPLEMENTATION);

	@Override
	public IJstValidationRuleSpec getSpec() {
		return SPEC;
	}

	@Override
	public void validate(ValidationCtx ctx, IJstType type) {

		UniquenessValidator.assertUniqueMembers(ctx, type
				.getInstanceProperties(), type.getInstanceMethods());
		UniquenessValidator.assertUniqueMembers(ctx,
				type.getStaticProperties(), type.getStaticMethods());
		
	}
	
	@Override
	public void validate(ValidationCtx ctx, IJstMethod method){
		UniquenessValidator.assertUniqueParams(ctx, method);
	}

}
