/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *

 *******************************************************************************/
package org.eclipse.dltk.mod.internal.ui.dnd;

import org.eclipse.jface.util.DelegatingDragAdapter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DragSourceEvent;

public class DLTKViewerDragAdapter extends DelegatingDragAdapter {

	private StructuredViewer fViewer;

	public DLTKViewerDragAdapter(StructuredViewer viewer) {
		super();
		fViewer= viewer;
	}

	public void dragStart(DragSourceEvent event) {
		IStructuredSelection selection= (IStructuredSelection)fViewer.getSelection();
		if (selection.isEmpty()) {
			event.doit= false;
			return;
		}
		super.dragStart(event);
	}
}
