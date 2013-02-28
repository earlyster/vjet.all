/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticValidator;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoValidationCtx;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.VjoSemanticRuleRepo;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.rulectx.BaseVjoSemanticRuleCtx;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.util.AccessControlUtil;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.visitor.IVjoValidationPostAllChildrenListener;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.visitor.IVjoValidationVisitorEvent;
import org.eclipse.vjet.dsf.jst.IInferred;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstProperty;
import org.eclipse.vjet.dsf.jst.IJstRefType;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.declaration.JstConstructor;
import org.eclipse.vjet.dsf.jst.declaration.JstDeferredType;
import org.eclipse.vjet.dsf.jst.declaration.JstInferredType;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstMixedType;
import org.eclipse.vjet.dsf.jst.declaration.JstObjectLiteralType;
import org.eclipse.vjet.dsf.jst.declaration.JstProperty;
import org.eclipse.vjet.dsf.jst.expr.FieldAccessExpr;
import org.eclipse.vjet.dsf.jst.expr.PrefixExpr;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.vjo.lib.LibManager;

public class VjoFieldAccessExprValidator 
	extends VjoSemanticValidator 
	implements IVjoValidationPostAllChildrenListener {
	
	private static List<Class<? extends IJstNode>> s_targetTypes;
	
	static{
		s_targetTypes = new ArrayList<Class<? extends IJstNode>>();
		s_targetTypes.add(FieldAccessExpr.class);
	}
	
	public List<Class<? extends IJstNode>> getTargetNodeTypes(){
		return s_targetTypes;
	}
	
	/**
	 * <p>
	 * 	event handler for post all children visit event
	 * </p>
	 */
	@Override
	public void onPostAllChildrenEvent(final IVjoValidationVisitorEvent event){
		
		final IJstNode jstNode = event.getVisitNode();		
		//double check if visit node is FieldAccessExpr, otherwise skip
		if(!(jstNode instanceof FieldAccessExpr)){
			return;
		}
		
		final VjoValidationCtx ctx = event.getValidationCtx();
		final FieldAccessExpr expr = (FieldAccessExpr)jstNode;
		final IExpr qualifier = expr.getExpr();
		
		IJstType qualifierType = qualifier.getResultType();
		if (qualifierType == null) {
			return; //skip validation
		}
		
		
		// when type is mixed type how does this work before?
		boolean inferred = false;
		if(qualifierType instanceof JstInferredType){
			qualifierType = ((JstInferredType) qualifierType).getType();
			inferred = true;
		}
		
		final JstIdentifier id = expr.getName();
		final IJstType fieldType = id.getResultType();
		final String fieldName = id.getName();
		VjoSemanticRuleRepo ruleRepo = VjoSemanticRuleRepo.getInstance();
		
		if (fieldType == null) { 
			
			if (
					!(inferred && ("Object".equals(qualifierType.getName()) || "Function".equals(qualifierType.getName()) ) ) &&
					!"Undefined".equals(qualifierType.getName()) 
					&& !"Undefined[]".equals(qualifierType.getName()) 
					&& !"ERROR_UNDEFINED_TYPE".equals(qualifierType.getName())
					&& !isDynamicType(qualifierType)) {
				
				if (qualifierType instanceof IJstRefType) {
					//NONE_STATIC_PROPERTY_SHOULD_NOT_BE_ACCESSED_FROM_STATIC_SCOPE
					if (qualifierType.getProperty(fieldName, false, true) != null) {					
						satisfyRule(ctx, 
							ruleRepo.NONE_STATIC_PROPERTY_SHOULD_NOT_BE_ACCESSED_FROM_STATIC_SCOPE,
							new BaseVjoSemanticRuleCtx
								(expr, ctx.getGroupId(), new String[]{fieldName, expr.toExprText()}));
						return;
					}//bugfix by roy, method accessing instead of property accessing
					else if (qualifierType.getMethod(fieldName, false, true) != null) {					
						satisfyRule(ctx, 
								ruleRepo.NONE_STATIC_PROPERTY_SHOULD_NOT_BE_ACCESSED_FROM_STATIC_SCOPE,
								new BaseVjoSemanticRuleCtx
									(expr, ctx.getGroupId(), new String[]{fieldName, expr.toExprText()}));
						return;
					}
					if("RegExp".equals(((IJstRefType)qualifierType).getReferencedNode().getSimpleName()) &&
						LibManager.JS_NATIVE_LIB_NAME.equals(qualifierType.getPackage().getGroupName())){
						final Pattern regexGroupRefPtn = Pattern.compile("\\$[0-9]+");
						final Matcher regexGroupRefMch = regexGroupRefPtn.matcher(fieldName);
						if(regexGroupRefMch.matches()){
							return; //OK
						}
					}
				}
				else {
					//STATIC_PROPERTY_SHOULD_NOT_BE_ACCESSED_FROM_NONE_STATIC_SCOPE
					if (qualifierType.getProperty(fieldName, true, true) != null) {					
						satisfyRule(ctx, 
							ruleRepo.STATIC_PROPERTY_SHOULD_NOT_BE_ACCESSED_FROM_NONE_STATIC_SCOPE,
							new BaseVjoSemanticRuleCtx
								(expr, ctx.getGroupId(), new String[]{fieldName, expr.toExprText()}));
						return;
					}//bugfix by roy, method accessing instead of property accessing
					else if (qualifierType.getMethod(fieldName, true, true) != null) {					
						satisfyRule(ctx, 
							ruleRepo.STATIC_PROPERTY_SHOULD_NOT_BE_ACCESSED_FROM_NONE_STATIC_SCOPE,
							new BaseVjoSemanticRuleCtx
								(expr, ctx.getGroupId(), new String[]{fieldName, expr.toExprText()}));
						return;
					}
				}
				
				if ("prototype".equals(fieldName)){
					return; //OK ??? to be removed
				}
				if (qualifierType instanceof JstObjectLiteralType &&
					"ObjLiteral".equals(qualifierType.getSimpleName())){
					return; //OK ???
				}
				
				
				
				
				
				//PROPERTY_SHOULD_BE_DEFINED
				if(!ctx.getMissingImportTypes().contains(qualifierType)){
					if(expr.getParentNode() != null 
							&& expr.getParentNode() instanceof PrefixExpr
							&& PrefixExpr.Operator.TYPEOF.equals(((PrefixExpr)expr.getParentNode()).getOperator())){
						return;//tolerated
					}
					if("Vj$Type".equals(qualifierType.getSimpleName())){
						final String missingTypeName = id.getName();
						if(missingTypeName != null){
							for(IJstType missingType: ctx.getMissingImportTypes()){
								if(missingTypeName.equals(missingType.getName())){
									return;//tolerated;
								}
							}
						}
					}
					satisfyRule(ctx, ruleRepo.PROPERTY_SHOULD_BE_DEFINED,
						new BaseVjoSemanticRuleCtx
							(expr, ctx.getGroupId(), new String[]{fieldName, expr.toExprText()}));
				}
			}
			return;
		}
		
		IJstNode fieldBinding = id.getJstBinding();
		if (fieldBinding != null 
				&& fieldBinding instanceof IJstProperty) {
			final IJstProperty property = (IJstProperty)fieldBinding;
			final IJstType callerType = expr.getOwnerType();
			final IJstType fieldOwnerType = (qualifierType instanceof IJstRefType) ?
					((IJstRefType)qualifierType).getReferencedNode() : qualifierType;
			final boolean visible = AccessControlUtil.isVisible(property, fieldOwnerType, callerType);
			if (!visible) {
				satisfyRule(ctx, ruleRepo.PROPERTY_SHOULD_BE_VISIBLE,
					new BaseVjoSemanticRuleCtx
						(expr, ctx.getGroupId(), new String[]{fieldName, expr.toExprText()}));
				return;
			}
			else{
				ctx.getPropertyStatesTable().reference(property);
			}
		}
		else if(fieldBinding != null
				&& fieldBinding instanceof JstMethod
				&& !(fieldBinding instanceof JstConstructor)){//should not validate MtdInvocationExpr as ObjCreationExpr whose qualifier type becomes this.vj$ type
			final JstMethod method = (JstMethod)fieldBinding;
			final IJstType callerType = expr.getOwnerType();
			final IJstType fieldOwnerType = (qualifierType instanceof IJstRefType) ?
					((IJstRefType)qualifierType).getReferencedNode() : qualifierType;
			final boolean visible = AccessControlUtil.isVisible(method, fieldOwnerType, callerType);
			if (!visible) {
				satisfyRule(ctx, ruleRepo.PROPERTY_SHOULD_BE_VISIBLE,
					new BaseVjoSemanticRuleCtx
						(expr, ctx.getGroupId(), new String[]{fieldName, expr.toExprText()}));
				return;
			}
			else{
				ctx.getMethodInvocationTable().reference(method);
			}
		}
	}

	private boolean isDynamicType(IJstType qualifierType) {
		if(qualifierType instanceof JstMixedType){
			JstMixedType mt = (JstMixedType)qualifierType;
			for(IJstType t: mt.getMixedTypes()){
				if(t.getModifiers().isDynamic()){
					return true;
				}
			}
		}
		return qualifierType.getModifiers().isDynamic();
	}
}
