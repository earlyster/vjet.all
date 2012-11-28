/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.html.dom;

import org.w3c.dom.DOMException;

import org.eclipse.vjet.dsf.common.event.AbortDsfEventProcessingException;
import org.eclipse.vjet.dsf.common.event.DsfEvent;
import org.eclipse.vjet.dsf.common.node.IDNodeRelationshipVerifier;
import org.eclipse.vjet.dsf.common.node.visitor.IDNodeVisitor;
import org.eclipse.vjet.dsf.css.CssClassConstant;
import org.eclipse.vjet.dsf.css.CssIdConstant;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.dsf.dom.support.DNamespace;
import org.eclipse.vjet.dsf.dom.util.TextChildOperationUtil;
import org.eclipse.vjet.dsf.html.events.EventType;
import org.eclipse.vjet.dsf.html.events.ISimpleJsEventHandler;
import org.eclipse.vjet.dsf.html.js.IJsFunc;

/**
* http://www.w3.org/TR/REC-html40/struct/text.html#edef-del
* <p>
* Example:
* <pre>
* <P>
*   A Sheriff can employ <DEL>3</DEL><INS>5</INS> deputies.
* </P>
* </pre>
*/
public class DDel extends DCommonMod
	/* implements IDTransitional, IAttrs */
{
	private static final long serialVersionUID = 3905801976649625913L;

	//
	// Constructor(s)
	//
	public DDel() {
		super(HtmlTypeEnum.DEL);
	}

	public DDel(final DHtmlDocument doc) {
		super(doc, HtmlTypeEnum.DEL);
	}
	
//	public DDel(final String jif) {
//		this() ;
//		jif(jif) ;
//	}
	
	/**
	 * The extension Constructor that creates an instance with DText child with 
	 * the passed in value.  If the passed in value is null, no DText child is created.
	 */
	public DDel(final String textValue) {
		this() ;
		setHtmlExtTextValue(textValue) ;
	}

	public DDel(BaseHtmlElement... elems) {
		this() ;
		add(elems) ;
	}
	
	//
	// Overrides from DCommonMod
	//
	@Override
	public DDel setHtmlCite(final String cite) {
		super.setHtmlCite(cite) ;
		return this ;
	}	
	@Override
	public DDel setHtmlDateTime(final String dateTime) {
		super.setHtmlDateTime(dateTime) ;
		return this ;
	}
	
	//
	// Framework
	//
	@Override
	public HtmlTypeEnum htmlType() {
		return HtmlTypeEnum.DEL ;
	}
			
	//
	// Extensions
	//
	public DDel setHtmlExtTextValue(final String value) {
		TextChildOperationUtil.setTextValue(this, value) ;
		return this ;		
	}
	public String getHtmlExtTextValue() {
		return TextChildOperationUtil.getTextValue(this) ;
	}
	
	//
	// Overrides from DElement
	//
	/**
	 * Shorthand of appendChild(Node) but takes a DNode arg.
	 * Returns "this" DNode vs. the added child - this is nice for
	 * cascade style programming. 
	 * <code>
	 * node.add(anotherNode).addRaw("&nbsp;") ;
	 * vs.
	 * node.add(anotherNode);
	 * node.addRaw("&nbsp;");
	 * @param newChild node to be appended.  Throws DOMException if value is null.
	 * @return this
	 * @throws DOMException
	 */
	@Override
	public DDel add(final DNode newChild) throws DOMException {
		super.add(newChild) ;
		return this ;
	}
	
	@Override
	public DDel add(BaseHtmlElement... elems) throws DOMException {
		super.add(elems) ;
		return this ;
	}
	
	/**
	 * Shorthand for add(new DText(value))
	 * <br><code>
	 * ex: node.add("Address")
	 * </code>
	 * @param value to be added as a DText node.  Throws DOMException if value is null.
	 * @return this
	 * @throws DOMException
	 */
	@Override
	public DDel add(final String value) throws DOMException {
		super.add(value) ;
		return this ;
	}
	
	/**
	 * Shorthand for add(new DRawString(value))
	 * <br>
	 * The value will be emitted as is without any escaping.
	 * <br>
	 * ex: node.addRaw("&npbsp;")
	 * @param  value to be added without any escaping. Throws DOMException if value is null.
	 */
	@Override
	public DDel addRaw(final String value) throws DOMException {
		super.addRaw(value) ;
		return this ;
	}
	
	/**
	 * This double dispatch approach provides the control point for the node
	 * to have customized behavior.
	 */
	@Override
	public DDel dsfAccept(final IDNodeVisitor visitor) {
		super.dsfAccept(visitor) ;
		return this;
	}
	
	/**
	 * Broadcasts the event to any registered IDsfEventListner's.
	 * The listeners are broadcast to in the order they were maintained.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DDel dsfBroadcast(final DsfEvent event) // must not be null
		throws AbortDsfEventProcessingException
	{
		super.dsfBroadcast(event) ;
		return this;
	}
	
	/**
	 * Set the relationship verifier for this instance
	 * <br>
	 * The verifier can be used to assert a newly added attribute, child, facet 
	 * or parent.
	 */
	@Override
	public DDel setDsfRelationshipVerifier(
		final IDNodeRelationshipVerifier relationshipVerifier)
	{
		super.setDsfRelationshipVerifier(relationshipVerifier) ;
		return this;
	}
	
	@Override
	public DDel cloned() {
		return (DDel)super.cloned() ;
	}
	
    /**
     * set namespace for this node.
     * update the nodename based on the given namespace
     * @param namespace
     * @return
     */
    @Override
    public DDel setDsfNamespace(DNamespace namespace){
    	super.setDsfNamespace(namespace) ;
    	return this ;
    }
	
	//
	// Overrides from BaseHtmlElement
	//
	/**
	 * The accesskey attribute's value is used by the user agent as a guide for 
	 * creating a keyboard shortcut that activates or focuses the element.
	 */
	@Override
	public DDel setHtmlAccessKey(final String accessKey) {
		super.setHtmlAccessKey(accessKey) ;
		return this ;
	}
		
	/**
	 * set class name, overwrite current class(es)
	 */
	@Override
	public DDel setHtmlClassName(final String className) {
		super.setHtmlClassName(className) ;
		return this ;
	}
	@Override
	public DDel setHtmlClassName(final CssClassConstant ccc) {
		super.setHtmlClassName(ccc) ;
		return this ;
	}

	/**
	 * The contenteditable  attribute is an enumerated attribute whose keywords 
	 * are the empty string, true, and false. The empty string and the true keyword 
	 * map to the true state. The false keyword maps to the false state. In 
	 * addition, there is a third state, the inherit state, which is the missing 
	 * value default (and the invalid value default).
	 */
	@Override
	public DDel setHtmlContentEditable(final String editable) {
		super.setHtmlContentEditable(editable) ;
		return this ;
	}
	
	/**
	 * The contextmenu  attribute gives the element's context menu. The value 
	 * must be the ID of a menu element in the DOM. If the node that would be 
	 * obtained by the invoking the getElementById() method using the attribute's 
	 * value as the only argument is null or not a menu element, then the element 
	 * has no assigned context menu. Otherwise, the element's assigned context 
	 * menu is the element so identified.
	 */
	@Override
	public DDel setHtmlContextMenu(final String contextMenu) {
		super.setHtmlContextMenu(contextMenu) ;
		return this ;
	}
	
	/**
	 * The dir attribute specifies the element's text directionality. The attribute 
	 * is an enumerated attribute with the keyword ltr mapping to the state ltr, 
	 * and the keyword rtl  mapping to the state rtl. The attribute has no defaults.
	 */
	@Override
	public DDel setHtmlDir(final String dir) {
		super.setHtmlDir(dir) ;
		return this ;
	}
	
	/**
	 * The draggable attribute is an enumerated attribute. It has three states. 
	 * The first state is true and it has the keyword true. The second state is 
	 * false and it has the keyword false. The third state is auto; it has no 
	 * keywords but it is the missing value default.
	 */
	@Override
	public DDel setHtmlDraggable(final String draggable) {  // true, false, auto
		super.setHtmlDraggable(draggable) ;
		return this ;
	}
	/**
	 * The draggable attribute is an enumerated attribute. It has three states. 
	 * The first state is true and it has the keyword true. The second state is 
	 * false and it has the keyword false. The third state is auto; it has no 
	 * keywords but it is the missing value default.
	 */
	@Override
	public DDel setHtmlDraggable(final boolean draggable) {  // true, false
		super.setHtmlDraggable(draggable) ;
		return this ;
	}
	
	/** 
	 * This attribute is a boolean attribute. When specified on an element, it 
	 * indicates that the element is not yet, or is no longer, relevant. User 
	 * agents should not render elements that have the hidden attribute specified.
	 */
	@Override
	public DDel setHtmlHidden(final String hidden) {
		super.setHtmlHidden(hidden);
		return this ;
	}
	/** 
	 * This attribute is a boolean attribute. When specified on an element, it 
	 * indicates that the element is not yet, or is no longer, relevant. User 
	 * agents should not render elements that have the hidden attribute specified.
	 */
	@Override
	public DDel setHtmlHidden(final boolean hidden) {
		super.setHtmlHidden(hidden);
		return this ;
	}
	
	/**
	 * The id attribute represents its element's unique identifier. The value must 
	 * be unique in the element's home subtree and must contain at least one character. 
	 * The value must not contain any space characters
	 */
	@Override
	public DDel setHtmlId(String id) {
		super.setHtmlId(id) ;
		return this ;
	}
	/**
	 * The id attribute represents its element's unique identifier. The value must 
	 * be unique in the element's home subtree and must contain at least one character. 
	 * The value must not contain any space characters
	 */	
	@Override
	public DDel setHtmlId(CssIdConstant id) {
		super.setHtmlId(id) ;
		return this ;
	}
	
	/**
	 * An element with the item attribute specified creates a new item, a group 
	 * of name-value pairs.  The attribute, if specified, must have a value that 
	 * is an unordered set of unique space-separated tokens representing the 
	 * types (if any) of the item.
	 */
	@Override
	public DDel setHtmlItem(final String item) {
		super.setHtmlItem(item) ;
		return this ;
	}
	
	/**
	 * An element with the itemprop  attribute specified adds one or more name-value 
	 * pairs to its corresponding item. The itemprop attribute, if specified, must 
	 * have a value that is an unordered set of unique space-separated tokens 
	 * representing the names of the name-value pairs that it adds. The attribute's 
	 * value must have at least one token.
	 */
	@Override
	public DDel setHtmlItemProp(final String itemProp) {
		super.setHtmlItemProp(itemProp) ;
		return this ;
	}	
	
	/**
	 * The lang attribute (in no namespace) specifies the primary language for 
	 * the element's contents and for any of the element's attributes that contain 
	 * text. Its value must be a valid BCP 47 language code, or the empty string.
	 */
	@Override
	public DDel setHtmlLang(final String lang) {
		super.setHtmlLang(lang) ;
		return this ;
	}
	
	/**
	 * The spellcheck  attribute is an enumerated attribute whose keywords are 
	 * the empty string, true and false. The empty string and the true keyword 
	 * map to the true state. The false keyword maps to the false state. In 
	 * addition, there is a third state, the default state, which is the missing 
	 * value default (and the invalid value default).
	 */
	@Override
	public DDel setHtmlSpellCheck(final String spellCheck) {
		super.setHtmlSpellCheck(spellCheck);
		return this ;
	}
	/**
	 * The spellcheck  attribute is an enumerated attribute whose keywords are 
	 * the empty string, true and false. The empty string and the true keyword 
	 * map to the true state. The false keyword maps to the false state. In 
	 * addition, there is a third state, the default state, which is the missing 
	 * value default (and the invalid value default).
	 */
	@Override
	public DDel setHtmlSpellCheck(final boolean spellCheck) {
		super.setHtmlSpellCheck(spellCheck) ;
		return this ;
	}	

	@Override
	public DDel setHtmlStyleAsString(final String styleString) {
		super.setHtmlStyleAsString(styleString) ;
		return this;
	}
	/** Set the style.
	 * This will make a copy of the contents, so further changes to the
	 * style object will not be reflected.
	 */
	@Override
	public DDel setHtmlStyle(final CSSStyleDeclaration style) {
		super.setHtmlStyle(style) ;
		return this;
	}	
	
	/**
	 * The subject  attribute may be specified on any HTML element to associate 
	 * the element with an element with an item attribute. If the subject 
	 * attribute is specified, the attribute's value must be the ID of an element 
	 * with an item attribute, in the same Document as the element with the 
	 * subject attribute.
	 */
	@Override
	public DDel setHtmlSubject(final String subject) {
		super.setHtmlSubject(subject) ;
		return this ;
	}	
	
	/**
	 * The tabindex content attribute specifies whether the element is focusable, 
	 * whether it can be reached using sequential focus navigation, and the relative 
	 * order of the element for the purposes of sequential focus navigation. The 
	 * name "tab index" comes from the common use of the "tab" key to navigate 
	 * through the focusable elements. The term "tabbing" refers to moving forward 
	 * through the focusable elements that can be reached using sequential focus 
	 * navigation.
	 */
	@Override
	public DDel setHtmlTabIndex(final String tabIndex) {  // HTML 5.0
		super.setHtmlTabIndex(tabIndex) ;
		return this ;
	}
	/**
	 * The tabindex content attribute specifies whether the element is focusable, 
	 * whether it can be reached using sequential focus navigation, and the relative 
	 * order of the element for the purposes of sequential focus navigation. The 
	 * name "tab index" comes from the common use of the "tab" key to navigate 
	 * through the focusable elements. The term "tabbing" refers to moving forward 
	 * through the focusable elements that can be reached using sequential focus 
	 * navigation.
	 */
	@Override
	public DDel setHtmlTabIndex(final int tabIndex) {  // HTML 5.0
		super.setHtmlTabIndex(tabIndex) ;
		return this ;
	}
	
	/**
	 * The title attribute represents advisory information for the element, such 
	 * as would be appropriate for a tooltip. On a link, this could be the title 
	 * or a description of the target resource; on an image, it could be the image 
	 * credit or a description of the image; on a paragraph, it could be a footnote 
	 * or commentary on the text; on a citation, it could be further information 
	 * about the source; and so forth. The value is text.
	 * <p>If this attribute is omitted from an element, then it implies that the 
	 * title attribute of the nearest ancestor HTML element with a title attribute 
	 * set is also relevant to this element.
	 */
	@Override
	public DDel setHtmlTitle(final String title) {
		super.setHtmlTitle(title) ;
		return this ;
	}
	
	//
	// HTML 5.0 API - Events
	//
	/**
	 * The user agent stops fetching the media data before it is completely downloaded.
	 */
	@Override
	public DDel setHtmlOnAbort(final String script) {
		super.setHtmlOnAbort(script) ;
		return this ;
	}
	
	/**
	 * The onblur event occurs when an object loses focus.
	 * not supported on BODY
	 */
	@Override
	public DDel setHtmlOnBlur(final String onBlur) {
		super.setHtmlOnBlur(onBlur) ;
		return this ;
	}
	
	/**
	 * The user agent can resume playback of the media data, but estimates that 
	 * if playback were to be started now, the media resource could not be rendered 
	 * at the current playback rate up to its end without having to stop for 
	 * further buffering of content.
	 */
	@Override
	public DDel setHtmlOnCanPlay(final String script) {
		super.setHtmlOnCanPlay(script) ;
		return this ;
	}
	
	/**
	 *  The user agent estimates that if playback were to be started now, the 
	 *  media resource could be rendered at the current playback rate all the way 
	 *  to its end without having to stop for further buffering. 
	 */
	@Override
	public DDel setHtmlOnCanPlayThrough(final String script) {
		super.setHtmlOnCanPlayThrough(script) ;
		return this ;
	}
	
	// onchange
	@Override
	public DDel setHtmlOnChange(final String script) {
		super.setHtmlOnChange(script) ;
		return this ;
	}
	
	// onclick
	@Override
	public DDel setHtmlOnClick(final String script) {
		super.setHtmlOnClick(script) ;
		return this ;
	}

	// oncontextmenu
	@Override
	public DDel setHtmlOnContextMenu(final String script) {
		super.setHtmlOnContextMenu(script) ;
		return this ;
	}
	
	// ondblclick
	@Override
	public DDel setHtmlOnDblClick(final String script) {
		super.setHtmlOnDblClick(script) ;
		return this ;
	}
	
	// ondrag
	@Override
	public DDel setHtmlOnDrag(final String script) {
		super.setHtmlOnDrag(script) ;
		return this ;
	}
	
	// ondragend
	@Override
	public DDel setHtmlOnDragEnd(final String script) {
		super.setHtmlOnDragEnd(script) ;
		return this ;
	}
	
	// ondragenter
	@Override
	public DDel setHtmlOnDragEnter(final String script) {
		super.setHtmlOnDragEnter(script) ;
		return this ;
	}
	
	// ondragleave
	@Override
	public DDel setHtmlOnDragLeave(final String script) {
		super.setHtmlOnDragLeave(script) ;
		return this ;
	}
	
	// ondragover
	@Override
	public DDel setHtmlOnDragOver(final String script) {
		super.setHtmlOnDragOver(script) ;
		return this ;
	}
	
	// ondragstart
	@Override
	public DDel setHtmlOnDragStart(final String script) {
		super.setHtmlOnDragStart(script) ;
		return this ;
	}
	
	// ondrop
	@Override
	public DDel setHtmlOnDrop(final String script) {
		super.setHtmlOnDrop(script) ;
		return this ;
	}
	
	// ondurationchange
	@Override
	public DDel setHtmlOnDurationChange(final String script) {
		super.setHtmlOnDurationChange(script) ;
		return this ;
	}
	
	/**
	 *  A media element whose networkState was previously not in the 
	 *  NETWORK_EMPTY state has just switched to that state (either because of a
	 *  fatal error during load that's about to be reported, or because the 
	 *  load() method was invoked while the resource selection algorithm was 
	 *  already running, in which case it is fired synchronously during the 
	 *  load() method call). 
	 */
	@Override
	public DDel setHtmlOnEmptied(final String script) {
		super.setHtmlOnEmptied(script) ;
		return this ;
	}
	
	/**
	 * Playback has stopped because the end of the media resource was reached. 
	 */
	@Override
	public DDel setHtmlOnEnded(final String script) {
		super.setHtmlOnEnded(script) ;
		return this ;
	}
	
	/**
	 * An error occurs while fetching the media data. 
	 * not supported on BODY
	 */
	@Override
	public DDel setHtmlOnError(final String script) {
		super.setHtmlOnError(script) ;
		return this ;
	}

	/**
	 * onfocus - not supported on BODY
	 */
	@Override
	public DDel setHtmlOnFocus(final String script) {
		super.setHtmlOnFocus(script) ;
		return this ;
	}
	
	/**
	 * onformchange
	 */
	@Override
	public DDel setHtmlOnFormChange(final String script) {
		super.setHtmlOnFormChange(script) ;
		return this ;
	}
	
	/**
	 * onforminput
	 */
	@Override
	public DDel setHtmlOnFormInput(final String script) {
		super.setHtmlOnFormInput(script) ;
		return this ;
	}
	
	/**
	 * oninput
	 */
	@Override
	public DDel setHtmlOnInput(final String script) {
		super.setHtmlOnInput(script) ;
		return this ;
	}
	
	/**
	 * oninvalid
	 */
	@Override
	public DDel setHtmlOnInvalid(final String script) {
		super.setHtmlOnInvalid(script) ;
		return this ;
	}
	
	/**
	 * onkeydown
	 */
	@Override
	public DDel setHtmlOnKeyDown(final String script) {
		super.setHtmlOnKeyDown(script) ;
		return this ;
	}

	/**
	 * onkeypress
	 */
	@Override
	public DDel setHtmlOnKeyPress(final String script) {
		super.setHtmlOnKeyPress(script) ;
		return this ;
	}
	
	/**
	 * onkeyup
	 */
	@Override
    public DDel setHtmlOnKeyUp(final String script) {
    	super.setHtmlOnKeyUp(script);
    	return this ;
	}
    
	/**
	 * onload
	 */
	@Override
    public DDel setHtmlOnLoad(final String script) {
    	super.setHtmlOnLoad(script) ;
    	return this ;
	}
    
	/**
	 * onloadeddata
	 */
	@Override
    public DDel setHtmlOnLoadedData(final String script) {
    	super.setHtmlOnLoadedData(script) ;
    	return this ;
	}   
    
	/**
	 * onloadedmetadata
	 */
	@Override
    public DDel setHtmlOnLoadedMetadata(final String script) {
    	super.setHtmlOnLoadedMetadata(script) ;
    	return this ;
	}  
	
	/**
	 * onloadstart
	 */
	@Override
    public DDel setHtmlOnLoadStart(final String script) {
    	super.setHtmlOnLoadStart(script) ;
    	return this ;
	} 
    
	/**
	 * onmousedown
	 */
	@Override
	public DDel setHtmlOnMouseDown(final String script){
		super.setHtmlOnMouseDown(script) ;
		return this ;
	}
	
	/**
	 * onmousemove
	 */
	@Override
	public DDel setHtmlOnMouseMove(final String script) {
		super.setHtmlOnMouseMove(script) ;
		return this ;
	}
	
	/**
	 * onmouseout
	 */
	@Override
	public DDel setHtmlOnMouseOut(final String script) {
		super.setHtmlOnMouseOut(script) ;
		return this ;
	}
	
	/**
	 * onmouseover
	 */
	@Override
	public DDel setHtmlOnMouseOver(final String script) {
		super.setHtmlOnMouseOver(script) ;
		return this ;
	}
	
	/**
	 * onmouseup
	 */
	@Override
	public DDel setHtmlOnMouseUp(final String script) {
		super.setHtmlOnMouseUp(script) ;
		return this ;
	}
    
	/**
	 * onmousewheel
	 */
	@Override
	public DDel setHtmlOnMouseWheel(final String script) {
		super.setHtmlOnMouseWheel(script) ;
		return this ;
	}
    
	/**
	 * onpause
	 */
	@Override
	public DDel setHtmlOnPause(final String script) {
		super.setHtmlOnPause(script) ;
		return this ;
	}  
    
	/**
	 * onplay
	 */
	@Override
	public DDel setHtmlOnPlay(final String script) {
		super.setHtmlOnPlay(script) ;
		return this ;
	}
    
	/**
	 * onplaying
	 */
	@Override
	public DDel setHtmlOnPlaying(final String script) {
		super.setHtmlOnPlaying(script) ;
		return this ;
	}
	
	/**
	 * onprogress
	 */
	@Override
	public DDel setHtmlOnProgress(final String script) {
		super.setHtmlOnProgress(script) ;
		return this ;
	}
    
	/**
	 * onratechange
	 */
	@Override
	public DDel setHtmlOnRateChange(final String script) {
		super.setHtmlOnRateChange(script) ;
		return this ;
	}
    
	/**
	 * onreadystatechange
	 */
	@Override
	public DDel setHtmlOnReadyStateChange(final String script) {
		super.setHtmlOnReadyStateChange(script) ;
		return this ;
	}

	/**
	 * onscroll
	 */
	@Override
	public DDel setHtmlOnScroll(final String script) {
		super.setHtmlOnScroll(script) ;
		return this ;
	}
	
	/**
	 * onseeked
	 */
	@Override
	public DDel setHtmlOnSeeked(final String script) {
		super.setHtmlOnSeeked(script) ;
		return this ;
	}
    
	/**
	 * onseeking
	 */
	@Override
	public DDel setHtmlOnSeeking(final String script) {
		super.setHtmlOnSeeking(script) ;
		return this ;
	}
	
	/**
	 * onselect
	 */
	@Override
	public DDel setHtmlOnSelect(final String script) {
		super.setHtmlOnSelect(script) ;
		return this ;
	}
	
	/**
	 * onshow
	 */
	@Override
	public DDel setHtmlOnShow(final String script) {
		super.setHtmlOnShow(script) ;
		return this ;
	}
	
	/**
	 * onstalled
	 */
	@Override
	public DDel setHtmlOnStalled(final String script) {
		super.setHtmlOnStalled(script) ;
		return this ;
	}
	
	/**
	 * onsubmit
	 */
	@Override
	public DDel setHtmlOnSubmit(final String script) {
		super.setHtmlOnSubmit(script) ;
		return this ;
	}
	
	/**
	 * onsuspend
	 */
	@Override
	public DDel setHtmlOnSuspend(final String script) {
		super.setHtmlOnSuspend(script) ;
		return this ;
	}
	
	/**
	 * ontimeupdate
	 */
	@Override
	public DDel setHtmlOnTimeUpdate(final String script) {
		super.setHtmlOnTimeUpdate(script) ;
		return this ;
	}
	
	/**
	 * onvolumechange
	 */
	@Override
	public DDel setHtmlOnVolumeChange(final String script) {
		super.setHtmlOnVolumeChange(script) ;
		return this ;
	}
	
	/**
	 * onwaiting
	 */
	@Override
	public DDel setHtmlOnWaiting(final String script) {
		super.setHtmlOnWaiting(script) ;
		return this ;
	}
	
	//
	// Framework - Event Wiring
	//
	@Override
	public DDel add(
		final EventType eventType, 
		final ISimpleJsEventHandler handler)
	{
		super.add(eventType, handler) ;
		return this ;
	}
	
	@Override
	public DDel add(
		final EventType eventType, 
		final IJsFunc func)
	{
		super.add(eventType, func) ;
		return this ;
	}
	
	@Override
	public DDel add(
		final EventType eventType, 
		final String jsText)
	{
		super.add(eventType, jsText) ;
		return this ;
	}
	
//	@Override
//	public DDel add(final IDomActiveListener listener){
//		super.add(listener) ;
//		return this ;
//	}
//	
//	@Override
//	public DDel add(
//		final EventType eventType, final IDomActiveListener listener)
//	{
//		super.add(eventType, listener) ;
//		return this ;
//	}
//	
//	@Override
//	public DDel removeListener(
//		final EventType eventType, final IDomActiveListener listener)
//	{
//		super.removeListener(eventType, listener) ;
//		return this ;
//	}
	
	//
	// Helpers
	//
	@Override
	public DDel addBr() {
		super.addBr() ;
		return this ;
	}
	
	@Override
	public DDel addBr(final int howMany){
		super.addBr(howMany) ;
		return this ;
	}

	/**
	 * Adds a class to the end, does not overwrite, and the classes are space
	 * delimited.
	 */
	@Override
	public DDel addHtmlClassName(final String className) {
		super.addHtmlClassName(className) ;
		return this ;
	}
	
	@Override
	public DDel addHtmlClassName(final CssClassConstant ccc) {
		super.addHtmlClassName(ccc) ;
		return this ;
	}
	
	@Override
	public DDel jif(final String jif) { 
		super.jif(jif) ;
		return this ;
	}
	
 	//
	// Child Hooks (phrasing content - interactive content)
	//
	public DAbbr _abbr() {
		 return _abbr(-1) ;
	}
	public DAbbr _abbr(final int count) {
		 return (DAbbr)getOrCreate(DAbbr.class, count) ;
	}
	public DAbbr _abbr(final String textValue) {
		return _abbr().setHtmlExtTextValue(textValue) ;
	}

	public DArea _area() {
		 return _area(-1) ;
	}
	public DArea _area(final int count) {
		 return (DArea)getOrCreate(DArea.class, count) ;
	}

	public DB _b() {
		 return _b(-1) ;
	}
	public DB _b(final int count) {
		 return (DB)getOrCreate(DB.class, count) ;
	}
	public DB _b(final String textValue) {
		return _b().setHtmlExtTextValue(textValue) ;
	}

	public DBdo _bdo() {
		 return _bdo(-1) ;
	}
	public DBdo _bdo(final int count) {
		 return (DBdo)getOrCreate(DBdo.class, count) ;
	}

	public DBr _br() {
		 return _br(-1) ;
	}
	public DBr _br(final int count) {
		 return (DBr)getOrCreate(DBr.class, count) ;
	}

	public DCanvas _canvas() {
		 return _canvas(-1) ;
	}
	public DCanvas _canvas(final int count) {
		 return (DCanvas)getOrCreate(DCanvas.class, count) ;
	}
	public DCanvas _canvas(final int height, final int width) {
		return _canvas().setHtmlHeight(height).setHtmlWidth(width) ;
	}
	public DCanvas _canvas(final String height, final String width) {
		return _canvas().setHtmlHeight(height).setHtmlWidth(width) ;
	}

	public DCite _cite() {
		 return _cite(-1) ;
	}
	public DCite _cite(final int count) {
		 return (DCite)getOrCreate(DCite.class, count) ;
	}
	public DCite _cite(final String textValue) {
		return _cite().setHtmlExtTextValue(textValue) ;
	}

	public DCode _code() {
		 return _code(-1) ;
	}
	public DCode _code(final int count) {
		 return (DCode)getOrCreate(DCode.class, count) ;
	}
	public DCode _code(final String textValue) {
		return _code().setHtmlExtTextValue(textValue) ;
	}

	public DCommand _command() {
		 return _command(-1) ;
	}
	public DCommand _command(final int count) {
		 return (DCommand)getOrCreate(DCommand.class, count) ;
	}

	public DDataList _datalist() {
		 return _datalist(-1) ;
	}
	public DDataList _datalist(final int count) {
		 return (DDataList)getOrCreate(DDataList.class, count) ;
	}

	public DDel _del() {
		 return _del(-1) ;
	}
	public DDel _del(final int count) {
		 return (DDel)getOrCreate(DDel.class, count) ;
	}
	public DDel _del(final String textValue) {
		return _del().setHtmlExtTextValue(textValue) ;
	}

	public DDfn _dfn() {
		 return _dfn(-1) ;
	}
	public DDfn _dfn(final int count) {
		 return (DDfn)getOrCreate(DDfn.class, count) ;
	}
	public DDfn _dfn(final String textValue) {
		return _dfn().setHtmlExtTextValue(textValue) ;
	}

	public DEm _em() {
		 return _em(-1) ;
	}
	public DEm _em(final int count) {
		 return (DEm)getOrCreate(DEm.class, count) ;
	}
	public DEm _em(final String textValue) {
		return _em().setHtmlExtTextValue(textValue) ;
	}

	public DI _i() {
		 return _i(-1) ;
	}
	public DI _i(final int count) {
		 return (DI)getOrCreate(DI.class, count) ;
	}
	public DI _i(final String textValue) {
		return _i().setHtmlExtTextValue(textValue) ;
	}

	public DIns _ins() {
		 return _ins(-1) ;
	}
	public DIns _ins(final int count) {
		 return (DIns)getOrCreate(DIns.class, count) ;
	}
	public DIns _ins(final String textValue) {
		return _ins().setHtmlExtTextValue(textValue) ;
	}

	public DKbd _kbd() {
		 return _kbd(-1) ;
	}
	public DKbd _kbd(final int count) {
		 return (DKbd)getOrCreate(DKbd.class, count) ;
	}
	public DKbd _kbd(final String textValue) {
		return _kbd().setHtmlExtTextValue(textValue) ;
	}

	public DMap _map() {
		 return _map(-1) ;
	}
	public DMap _map(final int count) {
		 return (DMap)getOrCreate(DMap.class, count) ;
	}

	public DMark _mark() {
		 return _mark(-1) ;
	}
	public DMark _mark(final int count) {
		 return (DMark)getOrCreate(DMark.class, count) ;
	}

	public DMeter _meter() {
		 return _meter(-1) ;
	}
	public DMeter _meter(final int count) {
		 return (DMeter)getOrCreate(DMeter.class, count) ;
	}
	public DMeter _meter(final String min, final String max) {
		return _meter().setHtmlMin(min).setHtmlMax(max) ;
	}
	public DMeter _meter(final String min, final String max, final String value) {
		return _meter(min, max).setHtmlValue(value) ;
	}
	public DMeter _meter(final double min, final double max) {
		return _meter().setHtmlMin(min).setHtmlMax(max) ;
	}
	public DMeter _meter(final double min, final double max, final double value) {
		return _meter(min, max).setHtmlValue(value) ;
	}

	public DNoScript _noscript() {
		 return _noscript(-1) ;
	}
	public DNoScript _noscript(final int count) {
		 return (DNoScript)getOrCreate(DNoScript.class, count) ;
	}

	public DOutput _output() {
		 return _output(-1) ;
	}
	public DOutput _output(final int count) {
		 return (DOutput)getOrCreate(DOutput.class, count) ;
	}

	public DProgress _progress() {
		 return _progress(-1) ;
	}
	public DProgress _progress(final int count) {
		 return (DProgress)getOrCreate(DProgress.class, count) ;
	}
	public DProgress _progress(final double max, final double value) {
		return _progress().setHtmlMax(max).setHtmlValue(value) ;
	}
	public DProgress _progress(final String max, final String value) {
		return _progress().setHtmlMax(max).setHtmlValue(value) ;
	}

	public DQ _q() {
		 return _q(-1) ;
	}
	public DQ _q(final int count) {
		 return (DQ)getOrCreate(DQ.class, count) ;
	}
	public DQ _q(final String textValue) {
		return _q().setHtmlExtTextValue(textValue) ;
	}

	public DRuby _ruby() {
		 return _ruby(-1) ;
	}
	public DRuby _ruby(final int count) {
		 return (DRuby)getOrCreate(DRuby.class, count) ;
	}

	public DSamp _samp() {
		 return _samp(-1) ;
	}
	public DSamp _samp(final int count) {
		 return (DSamp)getOrCreate(DSamp.class, count) ;
	}
	public DSamp _samp(final String textValue) {
		return _samp().setHtmlExtTextValue(textValue) ;
	}

	public DScript _script() {
		 return _script(-1) ;
	}
	public DScript _script(final int count) {
		 return (DScript)getOrCreate(DScript.class, count) ;
	}
	public DScript _script(final String text) {
		return _script().setHtmlText(text) ;
	}
	public DScript _script(final String text, final String type) {
		return _script(text).setHtmlType(type) ;
	}

	public DSmall _small() {
		 return _small(-1) ;
	}
	public DSmall _small(final int count) {
		 return (DSmall)getOrCreate(DSmall.class, count) ;
	}
	public DSmall _small(final String textValue) {
		return _small().setHtmlExtTextValue(textValue) ;
	}

	public DSpan _span() {
		 return _span(-1) ;
	}
	public DSpan _span(final int count) {
		 return (DSpan)getOrCreate(DSpan.class, count) ;
	}

	public DStrong _strong() {
		 return _strong(-1) ;
	}
	public DStrong _strong(final int count) {
		 return (DStrong)getOrCreate(DStrong.class, count) ;
	}
	public DStrong _strong(final String textValue) {
		return _strong().setHtmlExtTextValue(textValue) ;
	}

	public DSub _sub() {
		 return _sub(-1) ;
	}
	public DSub _sub(final int count) {
		 return (DSub)getOrCreate(DSub.class, count) ;
	}
	public DSub _sub(final String textValue) {
		return _sub().setHtmlExtTextValue(textValue) ;
	}

	public DSup _sup() {
		 return _sup(-1) ;
	}
	public DSup _sup(final int count) {
		 return (DSup)getOrCreate(DSup.class, count) ;
	}
	public DSup _sup(final String textValue) {
		return _sup().setHtmlExtTextValue(textValue) ;
	}

	public DTime _time() {
		 return _time(-1) ;
	}
	public DTime _time(final int count) {
		 return (DTime)getOrCreate(DTime.class, count) ;
	}
	public DTime _time(final String dateTime) {
		return _time().setHtmlDateTime(dateTime) ;
	}

	public DVar _var() {
		 return _var(-1) ;
	}
	public DVar _var(final int count) {
		 return (DVar)getOrCreate(DVar.class, count) ;
	}
	public DVar _var(final String textValue) {
		return _var().setHtmlExtTextValue(textValue) ;
	}

	public DWbr _wbr() {
		 return _wbr(-1) ;
	}
	public DWbr _wbr(final int count) {
		 return (DWbr)getOrCreate(DWbr.class, count) ;
	}
}
