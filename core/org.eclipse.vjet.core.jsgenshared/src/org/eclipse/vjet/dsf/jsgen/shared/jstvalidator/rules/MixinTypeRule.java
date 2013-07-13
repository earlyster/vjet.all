/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.rules;

import org.eclipse.vjet.dsf.jsgen.shared.ids.ScopeIds;
import org.eclipse.vjet.dsf.jsgen.shared.ids.TypeProbIds;
import org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.BaseJstRuleSpec;
import org.eclipse.vjet.dsf.jsgen.shared.jstvalidator.ValidationCtx;
import org.eclipse.vjet.dsf.jsgen.shared.validation.common.BaseJstValidationRule;
import org.eclipse.vjet.dsf.jsgen.shared.validation.common.IJstValidationRuleSpec;
import org.eclipse.vjet.dsf.jsgen.shared.validation.common.JstProcessingState;
import org.eclipse.vjet.dsf.jst.IJstType;

public class MixinTypeRule extends BaseJstValidationRule {

	@Override
	public IJstValidationRuleSpec getSpec() {
		return new BaseJstRuleSpec().addProblem(TypeProbIds.NoMixinAllowedForMixin)
		.addScope(ScopeIds.GLOBAL)
		.setState(JstProcessingState.DECLARATION);
	}

	@Override
	public void validate(ValidationCtx ctx, IJstType type) {
		
		if(type.isMixin()){
			
			if(type.getMixinsRef().size()>0){
//				ctx.getProblems().add(problem(TypeProbIds.NoMixinAllowedForMixin,type,ctx));
			}
		}
		
		
		
	}


	
	
	
	

}
