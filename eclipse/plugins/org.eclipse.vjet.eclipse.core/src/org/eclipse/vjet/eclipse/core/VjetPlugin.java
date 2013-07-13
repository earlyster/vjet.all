/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.dltk.mod.internal.core.ModelManager;
import org.eclipse.vjet.dsf.jstojava.controller.JstParseController;
import org.eclipse.vjet.dsf.jstojava.resolver.FunctionParamsMetaRegistry;
import org.eclipse.vjet.dsf.jstojava.resolver.OTypeResolverRegistry;
import org.eclipse.vjet.dsf.jstojava.resolver.ThisObjScopeResolverRegistry;
import org.eclipse.vjet.dsf.jstojava.resolver.TypeConstructorRegistry;
import org.eclipse.vjet.dsf.jstojava.resolver.TypeResolverRegistry;
import org.eclipse.vjet.eclipse.core.builder.TypeSpaceBuilder;
import org.eclipse.vjet.eclipse.core.parser.VjoParserToJstAndIType;
import org.eclipse.vjet.eclipse.core.ts.EclipseTypeSpaceLoader;
import org.eclipse.vjet.eclipse.core.ts.JstLibResolver;
import org.eclipse.vjet.eclipse.core.ts.TypeSpaceLoadJob;
import org.eclipse.vjet.eclipse.core.typeconstruct.FunctionParamMappingExtensionRegistry;
import org.eclipse.vjet.eclipse.core.typeconstruct.FunctionParamResolverExtension;
import org.eclipse.vjet.eclipse.core.typeconstruct.FunctionReturnTypeResolverExtension;
import org.eclipse.vjet.eclipse.core.typeconstruct.FunctionReturnTypeResolverExtensionRegistry;
import org.eclipse.vjet.eclipse.core.typeconstruct.OTypeResolverExtension;
import org.eclipse.vjet.eclipse.core.typeconstruct.OTypeResolverExtensionRegistry;
import org.eclipse.vjet.eclipse.core.typeconstruct.ThisScopeResolverExtension;
import org.eclipse.vjet.eclipse.core.typeconstruct.ThisScopeResolverExtensionRegistry;
import org.eclipse.vjet.eclipse.core.typeconstruct.TypeConstructResolverExtension;
import org.eclipse.vjet.eclipse.core.typeconstruct.TypeConstructResolverExtensionRegistry;
import org.eclipse.vjet.eclipse.core.validation.DefaultValidator;
import org.eclipse.vjet.eclipse.internal.formatter.DefaultCodeFormatterConstants;
import org.eclipse.vjet.vjo.lib.IResourceResolver;
import org.eclipse.vjet.vjo.lib.LibManager;
import org.eclipse.vjet.vjo.tool.typespace.TypeSpaceMgr;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class VjetPlugin extends Plugin {

	// The shared instance
	private static VjetPlugin plugin;

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.vjet.eclipse.core";
	public static final String VJO_SUBFIX = ".js";
	public final static String VJETVALIDATION = "VJETVALIDATION";
	private TypeSpaceMgr m_typeSpaceMgr = TypeSpaceMgr.getInstance();
	public static final String SDK_CONTAINER = "org.eclipse.vjet.eclipse.core"
			+ ".SDK_CONTAINER";
	public static final String ID_DEFAULT_SDK = "DEFUALT_SDK";
	public static final String JS_DEFAULT_SDK = "org.eclipse.vjet.eclipse.core.JSNATIVE_CONTAINER";
	public static final String JS_DEFAULT_SDK_LABEL = "JS Native Types";
	public static final String DES_VJET_SDK = "VJET SDK";

	public static final String JSNATIVESDK_ID = PLUGIN_ID
			+ ".JSNATIVE_CONTAINER";
	


	public static final String BROWSERSDK_LABEL = "Browser SDK";

	public static final String BROWSERSDK_ID = "org.eclipse.vjet.eclipse.core.BROWSER_CONTAINER";

	public static final String VJOLIB_ID = "org.eclipse.vjet.eclipse.core.VJO_CONTAINER";

	public static final String VJETTL_ID = "org.eclipse.vjet.eclipse.core.VJETTL";
	
	public static final String VJOLIB_LABEL = "VJO LIB";

	public static final String BUILDER_ID = PLUGIN_ID + ".builder";

	public static final boolean DEBUG = Boolean
			.valueOf(Platform.getDebugOption("org.eclipse.dltk.mod.core/debug")).booleanValue(); //$NON-NLS-1$

	public static final boolean DEBUG_SCRIPT_BUILDER = Boolean
			.valueOf(
					Platform.getDebugOption("org.eclipse.vjet.eclipse.core/debugScriptBuilder")).booleanValue(); //$NON-NLS-1$

	public static final boolean TRACE_SCRIPT_BUILDER = Boolean
			.valueOf(
					Platform.getDebugOption("org.eclipse.vjet.eclipse.core/traceScriptBuilder")).booleanValue(); //$NON-NLS-1$

	public static final boolean TRACE_TYPESPACE = Boolean
			.valueOf(
					Platform.getDebugOption("org.eclipse.vjet.eclipse.core/typespace")).booleanValue(); //$NON-NLS-1$

	public static final boolean TRACE_PARSER = Boolean
			.valueOf(
					Platform.getDebugOption("org.eclipse.vjet.eclipse.core/traceParser")).booleanValue(); //$NON-NLS-1$



	// *************** Possible IDs for configurable options. ********************
	public static final String INSERT  = "insert"; //$NON-NLS-1$

	public static final String DO_NOT_INSERT = "do not insert"; //$NON-NLS-1$
	
	public static final String SPACE = "space"; //$NON-NLS-1$

	public static final String TAB = "tab"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_SOURCE = PLUGIN_ID + ".compiler.source"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_COMPLIANCE = PLUGIN_ID + ".compiler.compliance"; //$NON-NLS-1$

	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_LOCAL_VARIABLE_ATTR = PLUGIN_ID + ".compiler.debug.localVariable"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_LINE_NUMBER_ATTR = PLUGIN_ID + ".compiler.debug.lineNumber"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_SOURCE_FILE_ATTR = PLUGIN_ID + ".compiler.debug.sourceFile"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_CODEGEN_UNUSED_LOCAL = PLUGIN_ID + ".compiler.codegen.unusedLocal"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_CODEGEN_TARGET_PLATFORM = PLUGIN_ID + ".compiler.codegen.targetPlatform"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_CODEGEN_INLINE_JSR_BYTECODE = PLUGIN_ID + ".compiler.codegen.inlineJsrBytecode"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_DOC_COMMENT_SUPPORT = PLUGIN_ID + ".compiler.doc.comment.support"; //$NON-NLS-1$
	/**
	 * Possible  configurable option ID.
	 * @see #getDefaultOptions()
	 */
	public static final String COMPILER_PB_ASSERT_IDENTIFIER = PLUGIN_ID + ".compiler.problem.assertIdentifier"; //$NON-NLS-1$

	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String ABORT = "abort"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String ERROR = "error"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String WARNING = "warning"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String IGNORE = "ignore"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String VERSION_1_1 = "1.1"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String VERSION_1_2 = "1.2"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String VERSION_1_3 = "1.3"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String VERSION_1_4 = "1.4"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String VERSION_1_5 = "1.5"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String VERSION_1_6 = "1.6"; //$NON-NLS-1$
	/**
	 * Possible  configurable option value.
	 * @see #getDefaultOptions()
	 */
	public static final String VERSION_1_7 = "1.7"; //$NON-NLS-1$
	
	private TypeSpaceLoadJob m_loadJob = new TypeSpaceLoadJob();

	private EclipseTypeSpaceLoader loader = new EclipseTypeSpaceLoader();

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static VjetPlugin getDefault() {
		return plugin;
	}

	/**
	 * The constructor
	 */
	public VjetPlugin() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

		IResourceResolver jstLibResolver = JstLibResolver.getInstance()
				.setSdkEnvironment(PiggyBackClassPathUtil.getSdkEnvironment());

		LibManager.getInstance().setResourceResolver(jstLibResolver);

		m_typeSpaceMgr.setTypeLoader(loader);
		JstParseController controller = VjoParserToJstAndIType
				.getJstParseController();
		m_typeSpaceMgr.init(controller);

		TypeSpaceBuilder.addGroupEventListeners(m_typeSpaceMgr.getController()
				.getJstTypeSpaceMgr());

		if (VjetPlugin.TRACE_TYPESPACE) {
			addTraceGroupEventListeners();
		}
		
		
		setPluginInstance(this);
		DefaultValidator.getValidator();
		m_loadJob.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				loader.setStarted(true);
			}
		});

		initTypeCostructorRegistry();
		initFunctionParamsRegistry();
		initThisObjScopeResolverRegistry();
		initFunctionReturnTypeRegistry();
		initOTypeRegistry();

		m_loadJob.schedule();

	}

	private void initTypeCostructorRegistry() {

		TypeConstructorRegistry registry = TypeConstructorRegistry
				.getInstance();

		TypeConstructResolverExtensionRegistry extensionRegistry = new TypeConstructResolverExtensionRegistry();
		Collection<TypeConstructResolverExtension> extensions = extensionRegistry
				.getResolverExtensions();
		for (TypeConstructResolverExtension extension : extensions) {
			try {
				registry.addResolver(extension.getKey(),
						extension.createResolver());
			} catch (CoreException e) {
				VjetPlugin
						.getDefault()
						.getLog()
						.log(new Status(IStatus.ERROR, VjetPlugin.PLUGIN_ID,
								"Error intializing the " + extension.toString()
										+ " resolver.", e));
			}
		}

	}

	private void initFunctionParamsRegistry() {

		FunctionParamsMetaRegistry registry = FunctionParamsMetaRegistry
				.getInstance();

		FunctionParamMappingExtensionRegistry extensionRegistry = new FunctionParamMappingExtensionRegistry();
		Collection<FunctionParamResolverExtension> extensions = extensionRegistry
				.getResolverExtensions();
		for (FunctionParamResolverExtension extension : extensions) {
			try {
				registry.addMapping(extension.createResolver());
			} catch (CoreException e) {
				VjetPlugin
						.getDefault()
						.getLog()
						.log(new Status(IStatus.ERROR, VjetPlugin.PLUGIN_ID,
								"Error intializing the " + extension.toString()
										+ " resolver.", e));
			}
		}

	}

	private void initThisObjScopeResolverRegistry() {

		ThisObjScopeResolverRegistry registry = ThisObjScopeResolverRegistry
				.getInstance();

		ThisScopeResolverExtensionRegistry extensionRegistry = new ThisScopeResolverExtensionRegistry();
		Collection<ThisScopeResolverExtension> extensions = extensionRegistry
				.getResolverExtensions();
		for (ThisScopeResolverExtension extension : extensions) {
			try {
				registry.addResolver(extension.getKey(),
						extension.createResolver());
			} catch (CoreException e) {
				VjetPlugin
						.getDefault()
						.getLog()
						.log(new Status(IStatus.ERROR, VjetPlugin.PLUGIN_ID,
								"Error intializing the " + extension.toString()
										+ " resolver.", e));
			}
		}

	}

	private void initFunctionReturnTypeRegistry() {

		TypeResolverRegistry registry = TypeResolverRegistry.getInstance();

		FunctionReturnTypeResolverExtensionRegistry extensionRegistry = new FunctionReturnTypeResolverExtensionRegistry();
		Collection<FunctionReturnTypeResolverExtension> extensions = extensionRegistry
				.getResolverExtensions();
		for (FunctionReturnTypeResolverExtension extension : extensions) {
			try {
				registry.addResolver(extension.getKey(),
						extension.createResolver());
			} catch (CoreException e) {
				VjetPlugin
						.getDefault()
						.getLog()
						.log(new Status(IStatus.ERROR, VjetPlugin.PLUGIN_ID,
								"Error intializing the functionreturntype "
										+ extension.toString() + " resolver.",
								e));
			}
		}

	}

	private void initOTypeRegistry() {

		OTypeResolverRegistry registry = OTypeResolverRegistry.getInstance();

		OTypeResolverExtensionRegistry extensionRegistry = new OTypeResolverExtensionRegistry();
		Collection<OTypeResolverExtension> extensions = extensionRegistry
				.getResolverExtensions();
		for (OTypeResolverExtension extension : extensions) {
			try {
				registry.addResolver(extension.getKey(),
						extension.createResolver());
			} catch (CoreException e) {
				VjetPlugin
						.getDefault()
						.getLog()
						.log(new Status(IStatus.ERROR, VjetPlugin.PLUGIN_ID,
								"Error intializing the otypedef "
										+ extension.toString() + " resolver.",
								e));
			}
		}

	}

	private void addTraceGroupEventListeners() {
		TypeSpaceBuilder.addGroupTraceEventListeners(m_typeSpaceMgr
				.getController().getJstTypeSpaceMgr());
	}

	// Modify by Oliver, 2009-12-01, fix findbugs bug.
	private static void setPluginInstance(VjetPlugin pluginPar) {
		plugin = pluginPar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		setPluginInstance(null);
		super.stop(context);
		loader.setStarted(false);
	}

	public static void error(String message) {
		error(message, IStatus.ERROR);
	}

	public static void error(String message, int status) {
		plugin.getLog().log(
				new Status(status, PLUGIN_ID, IStatus.OK, message, null));
	}

	public static void error(String message, Throwable t) {
		error(message, t, IStatus.ERROR);
	}

	public static void error(String message, Throwable t, int status) {
		plugin.getLog().log(
				new Status(status, PLUGIN_ID, IStatus.OK, message, t));
	}

	public static Map getOptions() {
		// TODO Auto-generated method stub
		return DefaultCodeFormatterConstants.getJavaConventionsSettings();
		
//		return DefaultCodeFormatterConstants.getEclipseDefaultSettings();
	}

//	public static IBuildpathEntry newSdkLibraryEntry(IPath path,
//			IAccessRule[] accessRules, IBuildpathAttribute[] extraAttributes,
//			IPath[] include, IPath[] exclude, boolean isExported,
//			boolean externalLib) {
//
//		if (path == null || path.segment(0) == null)
//			Assert.isTrue(false, "Library path cannot be null"); //$NON-NLS-1$
//		return new SerBuildPathEntry(IProjectFragment.K_BINARY,
//				IBuildpathEntry.BPE_LIBRARY, path, isExported, include, // inclusion
//				// patterns
//				exclude, // exclusion patterns
//				accessRules, false, // no access rules to combine
//				extraAttributes, externalLib);
//	}

}
