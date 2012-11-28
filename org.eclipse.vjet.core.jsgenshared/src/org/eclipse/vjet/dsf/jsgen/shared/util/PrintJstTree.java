/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.util;

import org.eclipse.vjet.dsf.jst.BaseJstNode;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstRefType;
import org.eclipse.vjet.dsf.jst.declaration.JstAnnotation;
import org.eclipse.vjet.dsf.jst.declaration.JstArg;
import org.eclipse.vjet.dsf.jst.declaration.JstArray;
import org.eclipse.vjet.dsf.jst.declaration.JstBlock;
import org.eclipse.vjet.dsf.jst.declaration.JstConstructor;
import org.eclipse.vjet.dsf.jst.declaration.JstDoc;
import org.eclipse.vjet.dsf.jst.declaration.JstFunctionRefType;
import org.eclipse.vjet.dsf.jst.declaration.JstGlobalFunc;
import org.eclipse.vjet.dsf.jst.declaration.JstGlobalProp;
import org.eclipse.vjet.dsf.jst.declaration.JstGlobalVar;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstModifiers;
import org.eclipse.vjet.dsf.jst.declaration.JstName;
import org.eclipse.vjet.dsf.jst.declaration.JstObjectLiteralType;
import org.eclipse.vjet.dsf.jst.declaration.JstPackage;
import org.eclipse.vjet.dsf.jst.declaration.JstParamType;
import org.eclipse.vjet.dsf.jst.declaration.JstProperty;
import org.eclipse.vjet.dsf.jst.declaration.JstProxyMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstProxyProperty;
import org.eclipse.vjet.dsf.jst.declaration.JstRawBlock;
import org.eclipse.vjet.dsf.jst.declaration.JstRefType;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.jst.declaration.JstTypeReference;
import org.eclipse.vjet.dsf.jst.declaration.JstTypeWithArgs;
import org.eclipse.vjet.dsf.jst.declaration.JstVar;
import org.eclipse.vjet.dsf.jst.declaration.JstVars;
import org.eclipse.vjet.dsf.jst.declaration.JstWildcardType;
import org.eclipse.vjet.dsf.jst.expr.ArrayAccessExpr;
import org.eclipse.vjet.dsf.jst.expr.ArrayCreationExpr;
import org.eclipse.vjet.dsf.jst.expr.AssignExpr;
import org.eclipse.vjet.dsf.jst.expr.BoolExpr;
import org.eclipse.vjet.dsf.jst.expr.CastExpr;
import org.eclipse.vjet.dsf.jst.expr.ConditionalExpr;
import org.eclipse.vjet.dsf.jst.expr.FieldAccessExpr;
import org.eclipse.vjet.dsf.jst.expr.FuncExpr;
import org.eclipse.vjet.dsf.jst.expr.InfixExpr;
import org.eclipse.vjet.dsf.jst.expr.JstArrayInitializer;
import org.eclipse.vjet.dsf.jst.expr.JstInitializer;
import org.eclipse.vjet.dsf.jst.expr.ListExpr;
import org.eclipse.vjet.dsf.jst.expr.MtdInvocationExpr;
import org.eclipse.vjet.dsf.jst.expr.ObjCreationExpr;
import org.eclipse.vjet.dsf.jst.expr.ParenthesizedExpr;
import org.eclipse.vjet.dsf.jst.expr.PostfixExpr;
import org.eclipse.vjet.dsf.jst.expr.PrefixExpr;
import org.eclipse.vjet.dsf.jst.expr.PtyGetter;
import org.eclipse.vjet.dsf.jst.expr.TextExpr;
import org.eclipse.vjet.dsf.jst.meta.BaseJsCommentMetaNode;
import org.eclipse.vjet.dsf.jst.stmt.BlockStmt;
import org.eclipse.vjet.dsf.jst.stmt.BreakStmt;
import org.eclipse.vjet.dsf.jst.stmt.CatchStmt;
import org.eclipse.vjet.dsf.jst.stmt.ContinueStmt;
import org.eclipse.vjet.dsf.jst.stmt.DispatchStmt;
import org.eclipse.vjet.dsf.jst.stmt.DoStmt;
import org.eclipse.vjet.dsf.jst.stmt.ExprStmt;
import org.eclipse.vjet.dsf.jst.stmt.ForInStmt;
import org.eclipse.vjet.dsf.jst.stmt.ForStmt;
import org.eclipse.vjet.dsf.jst.stmt.IfStmt;
import org.eclipse.vjet.dsf.jst.stmt.JstBlockInitializer;
import org.eclipse.vjet.dsf.jst.stmt.JstStmt;
import org.eclipse.vjet.dsf.jst.stmt.LabeledStmt;
import org.eclipse.vjet.dsf.jst.stmt.PtySetter;
import org.eclipse.vjet.dsf.jst.stmt.RtnStmt;
import org.eclipse.vjet.dsf.jst.stmt.SwitchStmt;
import org.eclipse.vjet.dsf.jst.stmt.TextStmt;
import org.eclipse.vjet.dsf.jst.stmt.ThisStmt;
import org.eclipse.vjet.dsf.jst.stmt.ThrowStmt;
import org.eclipse.vjet.dsf.jst.stmt.TryStmt;
import org.eclipse.vjet.dsf.jst.stmt.TypeDeclStmt;
import org.eclipse.vjet.dsf.jst.stmt.WhileStmt;
import org.eclipse.vjet.dsf.jst.stmt.WithStmt;
import org.eclipse.vjet.dsf.jst.stmt.SwitchStmt.CaseStmt;
import org.eclipse.vjet.dsf.jst.term.ArrayLiteral;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.term.JstLiteral;
import org.eclipse.vjet.dsf.jst.term.JstProxyIdentifier;
import org.eclipse.vjet.dsf.jst.term.NV;
import org.eclipse.vjet.dsf.jst.term.ObjLiteral;
import org.eclipse.vjet.dsf.jst.term.RegexpLiteral;
import org.eclipse.vjet.dsf.jst.term.SimpleLiteral;
import org.eclipse.vjet.dsf.jst.traversal.IJstNodeVisitor;

public class PrintJstTree implements IJstNodeVisitor {

	private int m_indentLevel;

	public void visit(BaseJstNode node) {
		printNode(node);

	}

	public void visit(JstAnnotation node) {

		printNode(node);

	}

	public void visit(JstArg node) {
		printNode(node);

	}

	public void visit(JstArrayInitializer node) {
		printNode(node);

	}

	public void visit(JstBlock node) {
		printNode(node);
		m_indentLevel++;
		visitChildren(node);
		m_indentLevel--;
	}

	public void visit(JstBlockInitializer node) {
		printNode(node);

	}

	public void visit(JstRawBlock node) {
		printNode(node);

	}

	public void visit(JstDoc node) {
		printNode(node);

	}

	public void visit(JstIdentifier node) {
		IJstNode binding =node.getJstBinding();
		if(binding!=null){
			
			printNode(binding);
		}
		printNode(node);

	}

	public void visit(JstInitializer node) {
		printNode(node);

	}

	public void visit(JstLiteral node) {
		printNode(node);

	}

	public void visit(ArrayLiteral node) {
		printNode(node);

	}

	public void visit(ObjLiteral node) {
		printNode(node);
		m_indentLevel++;
		visitChildren(node);
		m_indentLevel--;

	}

	public void visit(RegexpLiteral node) {
		printNode(node);

	}

	public void visit(SimpleLiteral node) {
		printNode(node);
		m_indentLevel++;
		visitChildren(node);
		m_indentLevel--;

	}

	public void visit(JstMethod node) {
		printNode(node);
		m_indentLevel++;
		visitChildren(node);
		m_indentLevel--;

	}

	public void visit(JstConstructor node) {
		printNode(node);

	}

	public void visit(JstModifiers node) {
		printNode(node);

	}

	public void visit(JstName node) {
			printNode(node);

	}

	public void visit(JstPackage node) {
			printNode(node);

	}

	public void visit(JstProperty node) {
			printNode(node);

	}

	public void visit(JstType node) {
			
			printNode(node);
			m_indentLevel++;
			visitChildren(node);
			m_indentLevel--;
			

	}

	public void visit(JstArray node) {
			printNode(node);

	}

	public void visit(JstFunctionRefType node) {
			printNode(node);

	}

	public void visit(JstObjectLiteralType node) {
			printNode(node);

	}

	public void visit(JstRefType node) {
			printNode(node);

	}

	public void visit(IJstRefType node) {
			printNode(node);

	}

	public void visit(JstTypeReference node) {
			printNode(node);

	}

	public void visit(JstVar node) {
			printNode(node);

	}

	public void visit(JstVars node) {
		
			System.out.println(printIndent() +"["+node.getClass().getSimpleName()+":"+node.toString().replaceAll("\\s+", " ") +" vars type:"+ node.getType().getName() +" ]"); //KEEPME 
		
			m_indentLevel++;
			visitChildren(node);
			m_indentLevel--;

	}

	public void visit(NV node) {
			printNode(node);
			m_indentLevel++;
			visitChildren(node);
			m_indentLevel--;

	}

	public void visit(JstStmt node) {
			printNode(node);

	}

	public void visit(BoolExpr node) {
			printNode(node);

	}

	public void visit(InfixExpr node) {
			printNode(node);

	}

	public void visit(ParenthesizedExpr node) {
			printNode(node);

	}

	public void visit(PostfixExpr node) {
			printNode(node);

	}

	public void visit(PrefixExpr node) {
			printNode(node);

	}

	public void visit(ArrayAccessExpr node) {
			printNode(node);

	}

	public void visit(ArrayCreationExpr node) {
			printNode(node);

	}

	public void visit(AssignExpr node) {
			printNode(node);
			visitChildren(node);

	}

	public void visit(CastExpr node) {
			printNode(node);

	}

	public void visit(ConditionalExpr node) {
			printNode(node);

	}

	public void visit(FieldAccessExpr node) {
		System.out.print(printIndent() +"["+node.getClass().getSimpleName()+":"+node.toString().replaceAll("\\s+", " ") ); //KEEPME 
		if(node.getType()!=null){
		System.out.print(",Type = " +node.getType().getName()); //KEEPME 
		}
		System.out.println(" ]"); //KEEPME 
		
		visitChildren(node);

	}

	public void visit(FuncExpr node) {
			printNode(node);

	}

	public void visit(ObjCreationExpr node) {
			printNode(node);
			visitChildren(node);

	}

	public void visit(MtdInvocationExpr node) {
			printNode(node);
			m_indentLevel++;
			visitChildren(node);
			m_indentLevel--;

	}

	public void visit(ExprStmt node) {
			printNode(node);

	}

	public void visit(CaseStmt node) {
			printNode(node);

	}

	public void visit(BlockStmt node) {
			printNode(node);

	}

	public void visit(CatchStmt node) {
			printNode(node);

	}

	public void visit(ForInStmt node) {
			printNode(node);

	}

	public void visit(ForStmt node) {
			printNode(node);

	}

	public void visit(IfStmt node) {
			printNode(node);

	}

	public void visit(DispatchStmt node) {
			printNode(node);

	}

	public void visit(SwitchStmt node) {
			printNode(node);

	}

	public void visit(TryStmt node) {
			printNode(node);

	}

	public void visit(WhileStmt node) {
			printNode(node);

	}

	public void visit(DoStmt node) {
			printNode(node);

	}

	public void visit(WithStmt node) {
			printNode(node);

	}

	public void visit(BreakStmt node) {
			printNode(node);

	}

	public void visit(ContinueStmt node) {
			printNode(node);

	}

	public void visit(LabeledStmt node) {
			printNode(node);

	}

	public void visit(RtnStmt node) {
			printNode(node);

	}

	public void visit(TypeDeclStmt node) {
			printNode(node);

	}

	public void visit(ListExpr node) {
			printNode(node);

	}

	public void visit(ThisStmt node) {
			printNode(node);

	}

	public void visit(TextExpr node) {
			printNode(node);

	}

	public void visit(TextStmt node) {
			printNode(node);

	}

	public void visit(ThrowStmt node) {
			printNode(node);

	}

	public void visit(PtyGetter node) {
			printNode(node);

	}

	public void visit(PtySetter node) {
			printNode(node);

	}

	public void visit(JstProxyMethod node) {
			printNode(node);

	}

	public void visit(JstProxyProperty node) {
			printNode(node);

	}

	public void visit(JstParamType node) {
			printNode(node);

	}

	public void visit(JstWildcardType node) {
			printNode(node);

	}

	public void visit(JstTypeWithArgs node) {
			printNode(node);

	}
	
//	public void visit(JstPrototypeType node) {
//		printNode(node);
//	
//	}
	
	private void printNode(IJstNode node){
		String space = printIndent();
		
		
		System.out.print(space +"["+node.getClass().getSimpleName()+":"+node.toString().replaceAll("\\s+", " ") ); //KEEPME 
		
		
		System.out.println(" ]"); //KEEPME 
		
	
		
		
	}

	private String printIndent() {
		String space = "";
		for(int i=0;i<m_indentLevel;i++){
			space += "\t";
		}
		return space;
	}
	
	private void visitChildren(IJstNode node){
		for(IJstNode child : node.getChildren()){
			child.accept(this);
		}
	}

	@Override
	public void visit(JstGlobalVar node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(JstGlobalFunc node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(JstGlobalProp node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(JstProxyIdentifier node) {
		printNode(node);
		visitChildren(node);
	}

	@Override
	public void visit(BaseJsCommentMetaNode<?> node) {
		printNode(node);
	}
}
