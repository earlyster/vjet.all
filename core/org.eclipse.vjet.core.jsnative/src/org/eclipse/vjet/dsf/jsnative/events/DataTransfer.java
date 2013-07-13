/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative.events;

import org.eclipse.vjet.dsf.jsnative.Element;
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.JsArray;
import org.eclipse.vjet.dsf.jsnative.anno.OverLoadFunc;
import org.eclipse.vjet.dsf.jsnative.anno.Property;
import org.eclipse.vjet.dsf.jsnative.file.File;
import org.eclipse.vjet.dsf.jsnative.file.FileList;
import org.mozilla.mod.javascript.IWillBeScriptable;

/*
 * interface DataTransfer {
           attribute DOMString dropEffect;
           attribute DOMString effectAllowed;

  readonly attribute DataTransferItems items;

  void setDragImage(in Element image, in long x, in long y);
  void addElement(in Element element);

  /* old interface 
  readonly attribute DOMStringList types;
  DOMString getData(in DOMString format);
  void setData(in DOMString format, in DOMString data);
  void clearData(in optional DOMString format);
  readonly attribute FileList files;
};
 */
public interface DataTransfer extends IWillBeScriptable {

	@Property String getDropEffect();
	@Property void setDropEffect();
	@Property String getEffectAllowed();
	@Property void setEffectAllowed(String effectAllowed);
//	@Property @JsArray(DataTransfer.class)
//	DataTransferItems getItems();
	@Function void setDragImage(Element element);
	@Function void addElement(Element element);
	
	/* old interface */
	@Property String[] getTypes();
	@Property @JsArray(File.class) FileList getFiles();
	@Function String getData(String format);
	@Function void setData(String format, String data);
	@OverLoadFunc void clearData(String format);
	@OverLoadFunc void clearData();
	
	
	
}
