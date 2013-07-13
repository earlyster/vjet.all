/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.templates;

import org.eclipse.dltk.mod.ui.templates.ScriptTemplateAccess;
import org.eclipse.dltk.mod.ui.templates.ScriptTemplatePreferencePage;
import org.eclipse.dltk.mod.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.jface.text.IDocument;
import org.eclipse.vjet.eclipse.internal.ui.text.IJavaScriptPartitions;
import org.eclipse.vjet.eclipse.internal.ui.text.SimpleVjoSourceViewerConfiguration;
import org.eclipse.vjet.eclipse.internal.ui.text.VjoTextTools;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;

/**
 * Javascript templates preference page
 */
public class VjetTemplatePreferencePage extends
		ScriptTemplatePreferencePage {
	/*
	 * @see org.eclipse.dltk.mod.ui.templates.ScriptTemplatePreferencePage#createSourceViewerConfiguration()
	 */
	protected ScriptSourceViewerConfiguration createSourceViewerConfiguration() {
		return new SimpleVjoSourceViewerConfiguration(getTextTools()
				.getColorManager(), getPreferenceStore(), null,
				IJavaScriptPartitions.JS_PARTITIONING, false);
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.templates.ScriptTemplatePreferencePage#getTemplateAccess()
	 */
	protected ScriptTemplateAccess getTemplateAccess() {
		return VjoTemplateAccess.getInstance();
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.templates.ScriptTemplatePreferencePage#setDocumentParticioner(org.eclipse.jface.text.IDocument)
	 */
	protected void setDocumentParticioner(IDocument document) {
		getTextTools().setupDocumentPartitioner(document,
				IJavaScriptPartitions.JS_PARTITIONING);
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.templates.ScriptTemplatePreferencePage#setPreferenceStore()
	 */
	protected void setPreferenceStore() {
		setPreferenceStore(VjetUIPlugin.getDefault().getPreferenceStore());
	}

	private VjoTextTools getTextTools() {
		return VjetUIPlugin.getDefault().getTextTools();
	}
}
