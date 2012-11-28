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
vjo.ctype("dsf.dom.html.level2.BodyTests")
.protos({

/**
* Color of active links (after mouse-button down, but before mouse-button up).
* The value of attribute alink of the body element is read and checked against the expected value.
* @author Netscape
* @author Sivakiran Tummala
* @see http://www.w3.org/TR/1998/REC-DOM-Level-1-19981001/level-one-html#ID-59424581
*/
//>public void body01()
body01 : function() {
var nodeList;
var testNode;
var valink;
var doc = window.document;
var assertEquals = null;
nodeList = doc.getElementsByTagName("body");
assertEquals(1,nodeList.length);
testNode = nodeList.item(0);
valink = testNode.aLink;

assertEquals("#0000ff",valink);

}

})
.endType();
