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
///**
//* Utility class for HTML <code>IFrame</code> element.
//*/
//vjo.ctype("org.eclipse.vjet.vsf.docx.Framex")
//.needs(["org.eclipse.vjet.vsf.docx.Elementx",
//	"org.eclipse.vjet.vsf.client.Browser"])
//.props({
//	E : org.eclipse.vjet.vsf.docx.Elementx,
//	/**
//	* Resizes iframe's size.
//	*
//	* @param {String} iframeId 
//	*        the id of the iframe to be resized
//	*/
//	//> public void resize(String);
//	resize : function(psIframeId) {
//		var f;
//		f = this.E.get(psIframeId);
//		if(f && typeof(f.document)!="unknown")
//		{
//			var oDoc=f.document ? f.document : f.contentDocument, 
//					db = oDoc.body,
//					es = f.style,
//					c = org.eclipse.vjet.vsf.client.Browser,
//					w = "100%",
//					h = db.offsetHeight,
//					oh;
//			if(c.bSafari)
//			{
//				oh = db.offsetHeight;
//				w = oDoc.width;
//				h = document.doctype !==null ? oDoc.height+15 : oDoc.height+1;
//	                
//			}
//			else if (c.bFirefox)
//			{
//				w =	oDoc.width;
//				h = oDoc.height;
//			}
//			else if(c.bWin || c.bOpera )
//			{
//				w = db.scrollWidth;
//				h = c.bNav && document.doctype !==null ? db.scrollHeight+30 : db.scrollHeight;
//			}
//			//es.width = w+"px";
//			es.height = h+"px";
//		}	
//	}
//})
//.endType();
//
