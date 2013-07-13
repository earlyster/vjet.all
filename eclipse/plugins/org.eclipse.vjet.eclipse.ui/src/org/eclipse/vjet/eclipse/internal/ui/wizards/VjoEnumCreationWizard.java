/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.wizards;

import org.eclipse.vjet.eclipse.core.VjoNature;

/**
 * VJET wizard for creating a new vjo enumeration type.
 * 
 */
public class VjoEnumCreationWizard extends VjoClassCreationWizard {

	private static final String ETYPE = "etype";
//	private static final String VALUES = "values";
	private static final String VALUES = "values";

	public VjoEnumCreationWizard() {
		super();
		setWindowTitle(VjetWizardMessages.EnumCreationWizard_title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.vjet.eclipse.internal.ui.wizards.VjoClassCreationWizard#createVjoSourceModulePage()
	 */
	protected VjoSourceModulePage createVjoSourceModulePage() {

		return new VjoSourceModulePage() {

			@Override
			protected String getPageDescription() {
				return VjetWizardMessages.EnumCreationWizard_page_description;
			}

			@Override
			protected String getPageTitle() {
				return VjetWizardMessages.EnumCreationWizard_page_title;
			}

			@Override
			protected String getRequiredNature() {
				return VjoNature.NATURE_ID;
			}

			@Override
			protected String getPageType() {
				return ETYPE;
			}
		};
	}

	@Override
	protected String getClassType() {
		return ETYPE;
	}

	@Override
	protected String getInheritance() {
		return EMPTY;
	}

	@Override
	protected String getBlockName() {
//		return VALUES;
		return PROPS;
	}

	/**
	 * Initializes data for creating new class. This method is used only for
	 * wizard engine.
	 */
	public void initializeData() {
		VjoClassCreationPage page = (VjoClassCreationPage) super
				.createVjoSourceModulePage();
		page.initializeSuperClassField();
		page.setAbstractButton(false);
		page.setMethodStubGeneration(false);
		page.setConstructorStubGeneration(false);
	}
}
