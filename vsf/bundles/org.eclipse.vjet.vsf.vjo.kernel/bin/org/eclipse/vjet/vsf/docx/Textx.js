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
/**
* Utility class for HTML <code>Textarea</code> element.
*/
vjo.ctype("org.eclipse.vjet.vsf.docx.Textx")
.needs("org.eclipse.vjet.vsf.docx.Elementx")
.needs('org.eclipse.vjet.vsf.Element')
.props({
	/**
	* Clears the content in specified textarea.
	*  
	* @param {String} id 
	*        the id of the textarea to be cleared
	*/
	//> public void autoClear(String);
	autoClear : function(psId) {
		var o = org.eclipse.vjet.vsf.Element.get(psId);
		if(o)
		{
			if(o.defaultValue == o.value)
			{
				o.value = "";
			}
		}
	}
})
.endType();


