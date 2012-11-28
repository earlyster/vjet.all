/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.validation.vjo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoSemanticProblem;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.VjoValidationResult;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstParseController;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.IScriptProblem;
import org.eclipse.vjet.dsf.jst.IScriptUnit;
import org.eclipse.vjet.dsf.jst.IWritableScriptUnit;
import org.eclipse.vjet.dsf.jst.declaration.JstBlock;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.ts.IJstTypeLoader;
import org.eclipse.vjet.dsf.jst.ts.JstTypeSpaceMgr;
import org.eclipse.vjet.dsf.jstojava.controller.JstParseController;
import org.eclipse.vjet.dsf.jstojava.loader.DefaultJstTypeLoader;
import org.eclipse.vjet.dsf.jstojava.loader.OnDemandAllTypeLoader;
import org.eclipse.vjet.dsf.jstojava.parser.VjoParser;
import org.eclipse.vjet.dsf.ts.event.group.AddGroupEvent;
import org.eclipse.vjet.dsf.ts.type.TypeName;
import org.eclipse.vjet.vjo.lib.LibManager;
import org.eclipse.vjet.vjo.lib.TsLibLoader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import org.eclipse.vjet.dsf.common.resource.ResourceUtil;

public class BasicValidationScriptUnitTest {
	
	protected JstTypeSpaceMgr mgr;

	protected IJstParseController getController() {
		return new JstParseController(new VjoParser());
	}
	
	protected IJstTypeLoader getLoader() {
		return new DefaultJstTypeLoader();
	}
	
	protected IScriptUnit lookUpTarget(final String path)
		throws Exception{
		final File testFile = new File(ResourceUtil.getResource(this.getClass(), path).getFile());
		
		return lookUpTarget(testFile);
	}
	
	protected IScriptUnit lookUpTarget(final String path, StringBuilder sb)
		throws Exception{
		final File targetFile = new File(ResourceUtil.getResource(
				this.getClass(), path).getFile());
		
		if(sb != null){
			try{
				final BufferedInputStream is = new BufferedInputStream(new FileInputStream(targetFile));
				final byte[] buf = new byte[1024];
				int readBytes = 0;
				while((readBytes = is.read(buf)) >= 0){
					sb.append(new String(buf, 0, readBytes));
				}
			}
			catch(FileNotFoundException ex){
				Assert.fail(ex.toString());
			}
			catch(IOException ex){
				Assert.fail(ex.toString());
			}
		}
		
		return lookUpTarget(targetFile);
	}
	
	private IScriptUnit lookUpTarget(final File targetFile){
		
		final VjoParser p = new VjoParser(); 
		JstParseController c = new JstParseController(p);
		
		final IWritableScriptUnit target =(IWritableScriptUnit)c.parse("test", targetFile.getAbsolutePath(),
				VjoParser.getContent(targetFile));
		
		final IJstType targetType = target.getType();
		
		JstTypeSpaceMgr mgr = new JstTypeSpaceMgr(c, new OnDemandAllTypeLoader(
				"test", targetType));
		mgr.initialize();
		TsLibLoader.loadDefaultLibs(mgr);
		
		c.resolve("test", target);
		
		mgr.processEvent(new AddGroupEvent("test", null,
				Collections.EMPTY_LIST, Collections.EMPTY_LIST));
		
		IJstType findType = target.getType();
		if(targetType.getName()!=null){
			findType = mgr.getQueryExecutor().findType(new TypeName("test", targetType.getName()));
		}
		final IJstType finalTypeSpaceType = findType;
		
		
		return new IScriptUnit(){

			public IJstNode getNode(int startOffset) {
				return target.getNode(startOffset);
			}

			public List<IScriptProblem> getProblems() {
				return target.getProblems();
			}

			public JstBlock getSyntaxRoot() {
				return target.getSyntaxRoot();
			}
			
			public List<JstBlock> getJstBlockList() {
				return target.getJstBlockList();
			}

			public IJstType getType() {
				return finalTypeSpaceType != null ? finalTypeSpaceType : targetType;
			}
		};
	}
	
	protected void printResult(VjoValidationResult result){
		Assert.assertNotNull(result);
		
		System.out.println();
		for(VjoSemanticProblem problem : result.getAllProblems()){
			System.out.println(problem.toString());
		}
	}
	
	@BeforeClass
	public static void beforeClass() {
		JstCache.getInstance().clear();

	}
	
	@Before
	public void startUp(){
//		new DefaultJstLibProvider();
		LibManager.getInstance().clear();
		JstCache.getInstance().clear();
		mgr = new JstTypeSpaceMgr(getController(), getLoader()).initialize();
		TsLibLoader.loadDefaultLibs(mgr);
		mgr.initialize();
	}
	
	@After
	public void tearDown(){
		mgr.close();
		
	}
	

}
