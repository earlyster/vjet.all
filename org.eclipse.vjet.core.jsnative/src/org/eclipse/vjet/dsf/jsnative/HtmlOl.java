/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative;

import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.javatojs.anno.ARename;
import org.eclipse.vjet.dsf.jsnative.anno.Alias;
import org.eclipse.vjet.dsf.jsnative.anno.DOMSupport;
import org.eclipse.vjet.dsf.jsnative.anno.DomLevel;
import org.eclipse.vjet.dsf.jsnative.anno.JsMetatype;
import org.eclipse.vjet.dsf.jsnative.anno.Property;

/**
 * http://www.w3.org/TR/REC-html40/struct/lists.html#edef-OL
 *
 */
@Alias("HTMLOListElement")
@DOMSupport(DomLevel.ONE)
@JsMetatype
public interface HtmlOl extends HtmlElement {

	/** value = "1" -- arabic - 1, 2, 3, ...*/
	@AJavaOnly @ARename(name="'1'")
	String TYPE_1 = "1" ;	// arabic - 1, 2, 3, ...
	/** value = "a" -- lower alpha - a, b, c, ...*/
	@AJavaOnly @ARename(name="'a'")
	String TYPE_a = "a" ;	// lower alpha - a, b, c, ...
	/** value = "A" -- upper alpha - A, B, C, ...*/
	@AJavaOnly @ARename(name="'A'")
	String TYPE_A = "A" ;	// upper alpha - A, B, C, ...
	/** value = "i" -- lower Roman - i, ii, iii, ...*/
	@AJavaOnly @ARename(name="'i'")
	String TYPE_i = "i" ;	// lower Roman - i, ii, iii, ... // ignoreHtmlKeyword
	/** value = "I" -- upper Roman - I, II, III, ...*/
	@AJavaOnly @ARename(name="'I'")
	String TYPE_I = "I" ;	// upper Roman - I, II, III, ... // ignoreHtmlKeyword
	
	@Property boolean getCompact();
	@Property void setCompact(boolean compact);

	@Property int getStart();
	@Property void setStart(int start);

	@Property String getType();
	@Property void setType(String type);
	
	/**
	 * Returns the onblur event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onblur.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	Object getOnBlur();
	
	/**
	 * Sets the onblur event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onblur.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onblur")
	void setOnBlur(Object functionRef);
	
	/**
	 * Returns the onfocus event handler code on the current element.
	 * @see http://www.w3schools.com/jsref/jsref_onfocus.asp 
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	Object getOnFocus();
	
	/**
	 * Sets the onfocus event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onfocus.asp 
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onfocus")
	void setOnFocus(Object functionRef);
	
	/**
	 * Returns the onkeydown event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onkeydown.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeydown")
	Object getOnKeyDown();
	
	/**
	 * Sets the onkeydown event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onkeydown.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeydown")
	void setOnKeyDown(Object functionRef);
	
	/**
	 * Returns the onkeypress event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onkeypress.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	Object getOnKeyPress();
	
	/**
	 * Sets the onkeypress event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onkeypress.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeypress")
	void setOnKeyPress(Object functionRef);
	
	/**
	 * Returns the onkeyup event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onkeyup.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	Object getOnKeyUp();
	
	/**
	 * Sets the onkeyup event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onkeyup.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onkeyup")
	void setOnKeyUp(Object functionRef);
	
	/**
	 * Returns the onresize event handler code on the current element.
	 * @see http://www.w3schools.com/jsref/jsref_onresize.asp 
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onresize")
	Object getOnResize();
	
	/**
	 * Sets the onresize event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onresize.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onresize")
	void setOnResize(Object functionRef);
	
	/**
	 * Returns the onclick event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onclick.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	Object getOnClick();
	
	/**
	 * Sets the onclick event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onclick.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onclick")
	void setOnClick(Object functionRef);
	
	/**
	 * Returns the ondblclick event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_ondblclick.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	Object getOnDblClick();
	
	/**
	 * Sets the ondblclick event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_ondblclick.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="ondblclick")
	void setOnDblClick(Object functionRef);
	
	/**
	 * Returns the onmousedown event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onmousedown.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	Object getOnMouseDown();
	
	/**
	 * Sets the onmousedown event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onmousedown.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousedown")
	void setOnMouseDown(Object functionRef);
	
	/**
	 * Returns the onmouseup event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onmouseup.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	Object getOnMouseUp();
	
	/**
	 * Sets the onmouseup event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onmouseup.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseup")
	void setOnMouseUp(Object functionRef);
	
	/**
	 * Returns the onmousemove event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onmousemove.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	Object getOnMouseMove();
	
	/**
	 * Sets the onmousemove event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onmousemove.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmousemove")
	void setOnMouseMove(Object functionRef);
	
	/**
	 * Returns the onmouseout event handler code on the current element.
	 * @see http://www.w3schools.com/jsref/jsref_onmouseout.asp 
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	Object getOnMouseOut();
	
	/**
	 * Sets the onmouseout event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onmouseout.asp 
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseout")
	void setOnMouseOut(Object functionRef);
	
	/**
	 * Returns the onmouseover event handler code on the current element. 
	 * @see http://www.w3schools.com/jsref/jsref_onmouseover.asp 
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	Object getOnMouseOver();
	
	/**
	 * Sets the onmouseover event handler code on the current element. 
	 * @param functionRef
	 * @see http://www.w3schools.com/jsref/jsref_onmouseover.asp
	 */
	@DOMSupport(DomLevel.ZERO)
	@Property(name="onmouseover")
	void setOnMouseOver(Object functionRef);

}
