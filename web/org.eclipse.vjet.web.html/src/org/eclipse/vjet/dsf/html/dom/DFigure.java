/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.html.dom;

import java.util.Collection;

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
import org.eclipse.vjet.dsf.html.events.EventType;
import org.eclipse.vjet.dsf.html.events.ISimpleJsEventHandler;
import org.eclipse.vjet.dsf.html.js.IJsFunc;

/**
<a href='http://dev.w3.org/html5/spec/Overview.html#the-figure-element'>W3C figure</a>
<p>
The figure element represents some flow content, optionally with a caption, 
that is self-contained and is typically referenced as a single unit from the 
main flow of the document.
<p>
The element can thus be used to annotate illustrations, diagrams, photos, code 
listings, etc, that are referred to from the main content of the document, but 
that could, without affecting the flow of the document, be moved away from that 
primary content, e.g. to the side of the page, to dedicated pages, or to an 
appendix.
<p>
The first legend element child of the element, if any, represents the caption 
of the figure element's contents. If there is no child legend element, then 
there is no caption.
<p>
The remainder of the element's contents, if any, represents the content.
<p>
<p>In <a href="#l4">listing 4</a> we see the primary core interface
API declaration.
</p>
<figure id="l4">
 <legend>Listing 4. The primary core interface API declaration.</legend>
 <pre><code>interface PrimaryCore {
  boolean verifyDataLine();
  void sendData(in sequence&lt;byte> data);
  void initSelfDestruct();
}</code></pre>
</figure>
<p>The API is designed to use UTF-8.</p>
 */
public class DFigure extends BaseHtml50Element {
	private static final long serialVersionUID = 1L;

	//
	// Constructor(s)
	//
	public DFigure() {
		super(HtmlTypeEnum.FIGURE);
	}
	
	public DFigure(final DHtmlDocument doc) {
		super(doc, HtmlTypeEnum.FIGURE);
	}
	
//	public DFigure(final String jif) {
//		this() ;
//		jif(jif) ;
//	}
	
	public DFigure(final String className) {
		this() ;
		setHtmlClassName(className) ;
	}
	
	public DFigure(final CssClassConstant ccc) {
		this(ccc.getName()) ;
	}

	public DFigure(BaseHtmlElement... elems) {
		this() ;
		add(elems) ;
	}
	
	//
	// Framework
	//
	@Override
	public HtmlTypeEnum htmlType() {
		return HtmlTypeEnum.FIGURE ;
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
	public DFigure add(final DNode newChild) throws DOMException {
		super.add(newChild) ;
		return this ;
	}
	
	@Override
	public DFigure add(BaseHtmlElement... elems) throws DOMException {
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
	public DFigure add(final String value) throws DOMException {
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
	public DFigure addRaw(final String value) throws DOMException {
		super.addRaw(value) ;
		return this ;
	}
	
	/**
	 * This double dispatch approach provides the control point for the node
	 * to have customized behavior.
	 */
	@Override
	public DFigure dsfAccept(final IDNodeVisitor visitor) {
		super.dsfAccept(visitor) ;
		return this;
	}
	
	/**
	 * Broadcasts the event to any registered IDsfEventListner's.
	 * The listeners are broadcast to in the order they were maintained.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DFigure dsfBroadcast(final DsfEvent event) // must not be null
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
	public DFigure setDsfRelationshipVerifier(
		final IDNodeRelationshipVerifier relationshipVerifier)
	{
		super.setDsfRelationshipVerifier(relationshipVerifier) ;
		return this;
	}
	
	@Override
	public DFigure cloned() {
		return (DFigure)super.cloned() ;
	}
	
    /**
     * set namespace for this node.
     * update the nodename based on the given namespace
     * @param namespace
     * @return
     */
    @Override
    public DFigure setDsfNamespace(DNamespace namespace){
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
	public DFigure setHtmlAccessKey(final String accessKey) {
		super.setHtmlAccessKey(accessKey) ;
		return this ;
	}
		
	/**
	 * set class name, overwrite current class(es)
	 */
	@Override
	public DFigure setHtmlClassName(final String className) {
		super.setHtmlClassName(className) ;
		return this ;
	}
	@Override
	public DFigure setHtmlClassName(final CssClassConstant ccc) {
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
	public DFigure setHtmlContentEditable(final String editable) {
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
	public DFigure setHtmlContextMenu(final String contextMenu) {
		super.setHtmlContextMenu(contextMenu) ;
		return this ;
	}
	
	/**
	 * The dir attribute specifies the element's text directionality. The attribute 
	 * is an enumerated attribute with the keyword ltr mapping to the state ltr, 
	 * and the keyword rtl  mapping to the state rtl. The attribute has no defaults.
	 */
	@Override
	public DFigure setHtmlDir(final String dir) {
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
	public DFigure setHtmlDraggable(final String draggable) {  // true, false, auto
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
	public DFigure setHtmlDraggable(final boolean draggable) {  // true, false
		super.setHtmlDraggable(draggable) ;
		return this ;
	}
	
	/** 
	 * This attribute is a boolean attribute. When specified on an element, it 
	 * indicates that the element is not yet, or is no longer, relevant. User 
	 * agents should not render elements that have the hidden attribute specified.
	 */
	@Override
	public DFigure setHtmlHidden(final String hidden) {
		super.setHtmlHidden(hidden);
		return this ;
	}
	/** 
	 * This attribute is a boolean attribute. When specified on an element, it 
	 * indicates that the element is not yet, or is no longer, relevant. User 
	 * agents should not render elements that have the hidden attribute specified.
	 */
	@Override
	public DFigure setHtmlHidden(final boolean hidden) {
		super.setHtmlHidden(hidden);
		return this ;
	}
	
	/**
	 * The id attribute represents its element's unique identifier. The value must 
	 * be unique in the element's home subtree and must contain at least one character. 
	 * The value must not contain any space characters
	 */
	@Override
	public DFigure setHtmlId(String id) {
		super.setHtmlId(id) ;
		return this ;
	}
	/**
	 * The id attribute represents its element's unique identifier. The value must 
	 * be unique in the element's home subtree and must contain at least one character. 
	 * The value must not contain any space characters
	 */	
	@Override
	public DFigure setHtmlId(CssIdConstant id) {
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
	public DFigure setHtmlItem(final String item) {
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
	public DFigure setHtmlItemProp(final String itemProp) {
		super.setHtmlItemProp(itemProp) ;
		return this ;
	}	
	
	/**
	 * The lang attribute (in no namespace) specifies the primary language for 
	 * the element's contents and for any of the element's attributes that contain 
	 * text. Its value must be a valid BCP 47 language code, or the empty string.
	 */
	@Override
	public DFigure setHtmlLang(final String lang) {
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
	public DFigure setHtmlSpellCheck(final String spellCheck) {
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
	public DFigure setHtmlSpellCheck(final boolean spellCheck) {
		super.setHtmlSpellCheck(spellCheck) ;
		return this ;
	}	

	@Override
	public DFigure setHtmlStyleAsString(final String styleString) {
		super.setHtmlStyleAsString(styleString) ;
		return this;
	}
	/** Set the style.
	 * This will make a copy of the contents, so further changes to the
	 * style object will not be reflected.
	 */
	@Override
	public DFigure setHtmlStyle(final CSSStyleDeclaration style) {
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
	public DFigure setHtmlSubject(final String subject) {
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
	public DFigure setHtmlTabIndex(final String tabIndex) {  // HTML 5.0
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
	public DFigure setHtmlTabIndex(final int tabIndex) {  // HTML 5.0
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
	public DFigure setHtmlTitle(final String title) {
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
	public DFigure setHtmlOnAbort(final String script) {
		super.setHtmlOnAbort(script) ;
		return this ;
	}
	
	/**
	 * The onblur event occurs when an object loses focus.
	 * not supported on BODY
	 */
	@Override
	public DFigure setHtmlOnBlur(final String onBlur) {
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
	public DFigure setHtmlOnCanPlay(final String script) {
		super.setHtmlOnCanPlay(script) ;
		return this ;
	}
	
	/**
	 *  The user agent estimates that if playback were to be started now, the 
	 *  media resource could be rendered at the current playback rate all the way 
	 *  to its end without having to stop for further buffering. 
	 */
	@Override
	public DFigure setHtmlOnCanPlayThrough(final String script) {
		super.setHtmlOnCanPlayThrough(script) ;
		return this ;
	}
	
	// onchange
	@Override
	public DFigure setHtmlOnChange(final String script) {
		super.setHtmlOnChange(script) ;
		return this ;
	}
	
	// onclick
	@Override
	public DFigure setHtmlOnClick(final String script) {
		super.setHtmlOnClick(script) ;
		return this ;
	}

	// oncontextmenu
	@Override
	public DFigure setHtmlOnContextMenu(final String script) {
		super.setHtmlOnContextMenu(script) ;
		return this ;
	}
	
	// ondblclick
	@Override
	public DFigure setHtmlOnDblClick(final String script) {
		super.setHtmlOnDblClick(script) ;
		return this ;
	}
	
	// ondrag
	@Override
	public DFigure setHtmlOnDrag(final String script) {
		super.setHtmlOnDrag(script) ;
		return this ;
	}
	
	// ondragend
	@Override
	public DFigure setHtmlOnDragEnd(final String script) {
		super.setHtmlOnDragEnd(script) ;
		return this ;
	}
	
	// ondragenter
	@Override
	public DFigure setHtmlOnDragEnter(final String script) {
		super.setHtmlOnDragEnter(script) ;
		return this ;
	}
	
	// ondragleave
	@Override
	public DFigure setHtmlOnDragLeave(final String script) {
		super.setHtmlOnDragLeave(script) ;
		return this ;
	}
	
	// ondragover
	@Override
	public DFigure setHtmlOnDragOver(final String script) {
		super.setHtmlOnDragOver(script) ;
		return this ;
	}
	
	// ondragstart
	@Override
	public DFigure setHtmlOnDragStart(final String script) {
		super.setHtmlOnDragStart(script) ;
		return this ;
	}
	
	// ondrop
	@Override
	public DFigure setHtmlOnDrop(final String script) {
		super.setHtmlOnDrop(script) ;
		return this ;
	}
	
	// ondurationchange
	@Override
	public DFigure setHtmlOnDurationChange(final String script) {
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
	public DFigure setHtmlOnEmptied(final String script) {
		super.setHtmlOnEmptied(script) ;
		return this ;
	}
	
	/**
	 * Playback has stopped because the end of the media resource was reached. 
	 */
	@Override
	public DFigure setHtmlOnEnded(final String script) {
		super.setHtmlOnEnded(script) ;
		return this ;
	}
	
	/**
	 * An error occurs while fetching the media data. 
	 * not supported on BODY
	 */
	@Override
	public DFigure setHtmlOnError(final String script) {
		super.setHtmlOnError(script) ;
		return this ;
	}

	/**
	 * onfocus - not supported on BODY
	 */
	@Override
	public DFigure setHtmlOnFocus(final String script) {
		super.setHtmlOnFocus(script) ;
		return this ;
	}
	
	/**
	 * onformchange
	 */
	@Override
	public DFigure setHtmlOnFormChange(final String script) {
		super.setHtmlOnFormChange(script) ;
		return this ;
	}
	
	/**
	 * onforminput
	 */
	@Override
	public DFigure setHtmlOnFormInput(final String script) {
		super.setHtmlOnFormInput(script) ;
		return this ;
	}
	
	/**
	 * oninput
	 */
	@Override
	public DFigure setHtmlOnInput(final String script) {
		super.setHtmlOnInput(script) ;
		return this ;
	}
	
	/**
	 * oninvalid
	 */
	@Override
	public DFigure setHtmlOnInvalid(final String script) {
		super.setHtmlOnInvalid(script) ;
		return this ;
	}
	
	/**
	 * onkeydown
	 */
	@Override
	public DFigure setHtmlOnKeyDown(final String script) {
		super.setHtmlOnKeyDown(script) ;
		return this ;
	}

	/**
	 * onkeypress
	 */
	@Override
	public DFigure setHtmlOnKeyPress(final String script) {
		super.setHtmlOnKeyPress(script) ;
		return this ;
	}
	
	/**
	 * onkeyup
	 */
	@Override
    public DFigure setHtmlOnKeyUp(final String script) {
    	super.setHtmlOnKeyUp(script);
    	return this ;
	}
    
	/**
	 * onload
	 */
	@Override
    public DFigure setHtmlOnLoad(final String script) {
    	super.setHtmlOnLoad(script) ;
    	return this ;
	}
    
	/**
	 * onloadeddata
	 */
	@Override
    public DFigure setHtmlOnLoadedData(final String script) {
    	super.setHtmlOnLoadedData(script) ;
    	return this ;
	}   
    
	/**
	 * onloadedmetadata
	 */
	@Override
    public DFigure setHtmlOnLoadedMetadata(final String script) {
    	super.setHtmlOnLoadedMetadata(script) ;
    	return this ;
	}  
	
	/**
	 * onloadstart
	 */
	@Override
    public DFigure setHtmlOnLoadStart(final String script) {
    	super.setHtmlOnLoadStart(script) ;
    	return this ;
	} 
    
	/**
	 * onmousedown
	 */
	@Override
	public DFigure setHtmlOnMouseDown(final String script){
		super.setHtmlOnMouseDown(script) ;
		return this ;
	}
	
	/**
	 * onmousemove
	 */
	@Override
	public DFigure setHtmlOnMouseMove(final String script) {
		super.setHtmlOnMouseMove(script) ;
		return this ;
	}
	
	/**
	 * onmouseout
	 */
	@Override
	public DFigure setHtmlOnMouseOut(final String script) {
		super.setHtmlOnMouseOut(script) ;
		return this ;
	}
	
	/**
	 * onmouseover
	 */
	@Override
	public DFigure setHtmlOnMouseOver(final String script) {
		super.setHtmlOnMouseOver(script) ;
		return this ;
	}
	
	/**
	 * onmouseup
	 */
	@Override
	public DFigure setHtmlOnMouseUp(final String script) {
		super.setHtmlOnMouseUp(script) ;
		return this ;
	}
    
	/**
	 * onmousewheel
	 */
	@Override
	public DFigure setHtmlOnMouseWheel(final String script) {
		super.setHtmlOnMouseWheel(script) ;
		return this ;
	}
    
	/**
	 * onpause
	 */
	@Override
	public DFigure setHtmlOnPause(final String script) {
		super.setHtmlOnPause(script) ;
		return this ;
	}  
    
	/**
	 * onplay
	 */
	@Override
	public DFigure setHtmlOnPlay(final String script) {
		super.setHtmlOnPlay(script) ;
		return this ;
	}
    
	/**
	 * onplaying
	 */
	@Override
	public DFigure setHtmlOnPlaying(final String script) {
		super.setHtmlOnPlaying(script) ;
		return this ;
	}
	
	/**
	 * onprogress
	 */
	@Override
	public DFigure setHtmlOnProgress(final String script) {
		super.setHtmlOnProgress(script) ;
		return this ;
	}
    
	/**
	 * onratechange
	 */
	@Override
	public DFigure setHtmlOnRateChange(final String script) {
		super.setHtmlOnRateChange(script) ;
		return this ;
	}
    
	/**
	 * onreadystatechange
	 */
	@Override
	public DFigure setHtmlOnReadyStateChange(final String script) {
		super.setHtmlOnReadyStateChange(script) ;
		return this ;
	}

	/**
	 * onscroll
	 */
	@Override
	public DFigure setHtmlOnScroll(final String script) {
		super.setHtmlOnScroll(script) ;
		return this ;
	}
	
	/**
	 * onseeked
	 */
	@Override
	public DFigure setHtmlOnSeeked(final String script) {
		super.setHtmlOnSeeked(script) ;
		return this ;
	}
    
	/**
	 * onseeking
	 */
	@Override
	public DFigure setHtmlOnSeeking(final String script) {
		super.setHtmlOnSeeking(script) ;
		return this ;
	}
	
	/**
	 * onselect
	 */
	@Override
	public DFigure setHtmlOnSelect(final String script) {
		super.setHtmlOnSelect(script) ;
		return this ;
	}
	
	/**
	 * onshow
	 */
	@Override
	public DFigure setHtmlOnShow(final String script) {
		super.setHtmlOnShow(script) ;
		return this ;
	}
	
	/**
	 * onstalled
	 */
	@Override
	public DFigure setHtmlOnStalled(final String script) {
		super.setHtmlOnStalled(script) ;
		return this ;
	}
	
	/**
	 * onsubmit
	 */
	@Override
	public DFigure setHtmlOnSubmit(final String script) {
		super.setHtmlOnSubmit(script) ;
		return this ;
	}
	
	/**
	 * onsuspend
	 */
	@Override
	public DFigure setHtmlOnSuspend(final String script) {
		super.setHtmlOnSuspend(script) ;
		return this ;
	}
	
	/**
	 * ontimeupdate
	 */
	@Override
	public DFigure setHtmlOnTimeUpdate(final String script) {
		super.setHtmlOnTimeUpdate(script) ;
		return this ;
	}
	
	/**
	 * onvolumechange
	 */
	@Override
	public DFigure setHtmlOnVolumeChange(final String script) {
		super.setHtmlOnVolumeChange(script) ;
		return this ;
	}
	
	/**
	 * onwaiting
	 */
	@Override
	public DFigure setHtmlOnWaiting(final String script) {
		super.setHtmlOnWaiting(script) ;
		return this ;
	}
	
	//
	// Framework - Event Wiring
	//
	@Override
	public DFigure add(
		final EventType eventType, 
		final ISimpleJsEventHandler handler)
	{
		super.add(eventType, handler) ;
		return this ;
	}
	
	@Override
	public DFigure add(
		final EventType eventType, 
		final IJsFunc func)
	{
		super.add(eventType, func) ;
		return this ;
	}
	
	@Override
	public DFigure add(
		final EventType eventType, 
		final String jsText)
	{
		super.add(eventType, jsText) ;
		return this ;
	}
	
//	@Override
//	public DFigure add(final IDomActiveListener listener){
//		super.add(listener) ;
//		return this ;
//	}
//	
//	@Override
//	public DFigure add(
//		final EventType eventType, final IDomActiveListener listener)
//	{
//		super.add(eventType, listener) ;
//		return this ;
//	}
//	
//	@Override
//	public DFigure removeListener(
//		final EventType eventType, final IDomActiveListener listener)
//	{
//		super.removeListener(eventType, listener) ;
//		return this ;
//	}
	
	//
	// Helpers
	//
	@Override
	public DFigure addBr() {
		super.addBr() ;
		return this ;
	}
	
	@Override
	public DFigure addBr(final int howMany){
		super.addBr(howMany) ;
		return this ;
	}

	/**
	 * Adds a class to the end, does not overwrite, and the classes are space
	 * delimited.
	 */
	@Override
	public DFigure addHtmlClassName(final String className) {
		super.addHtmlClassName(className) ;
		return this ;
	}
	
	@Override
	public DFigure addHtmlClassName(final CssClassConstant ccc) {
		super.addHtmlClassName(ccc) ;
		return this ;
	}
	
	@Override
	public DFigure jif(final String jif) { 
		super.jif(jif) ;
		return this ;
	}
	
	//
	// Child Hooks (Flow Content)
	//
	public DA _a() {
		 return _a(-1) ;
	}
	public DFigure _a_() {
		_a() ;
		return this ;
	}
	public DA _a(final int count) {
		 return (DA)getOrCreate(DA.class, count) ;
	}
	public DFigure _a_(final int count) {
		_a(count) ;
		return this ;
	}
	public DA _a(final String jif) {
		return _a().jif(jif) ;
	}
	public DFigure _a_(final String jif) {
		_a().jif(jif) ;
		return this ;
	}
	public DA _aText(final String value) {
		return _a().setHtmlExtTextValue(value) ;
	}
	public DFigure _aText_(final String textValue) {
		_aText(textValue) ;
		return this ;
	}
	public DA _a(final String value, final String url) {
		return _a().setHtmlExtTextValue(value).setHtmlHref(url) ;
	}
	public DFigure _a_(final String value, final String url) {
		_a(value, url) ;
		return this ;
	}

	public DAbbr _abbr() {
		 return _abbr(-1) ;
	}
	public DFigure _abbr_() {
		_abbr() ;
		return this ;
	}
	public DAbbr _abbr(final int count) {
		 return (DAbbr)getOrCreate(DAbbr.class, count) ;
	}
	public DFigure _abbr_(final int count) {
		 _abbr(count) ;
		 return this ;
	}
	public DAbbr _abbr(final String jif) {
		return _abbr().jif(jif) ;
	}
	public DFigure _abbr_(final String jif) {
		_abbr(jif) ;
		return this ;
	}
	public DAbbr _abbrText(final String textValue) {
		return _abbr().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _abbrText_(final String textValue) {
		_abbrText(textValue) ;
		return this ;
	}
	public DAbbr _abbr(BaseHtmlElement... elements) {
		final DAbbr answer = _abbr() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _abbr_(BaseHtmlElement... elements) {
		_abbr(elements) ;
		return this ;
	}

	public DAddress _address() {
		 return _address(-1) ;
	}
	public DFigure _address_() {
		_address() ;
		return this ;
	}
	public DAddress _address(final int count) {
		 return (DAddress)getOrCreate(DAddress.class, count) ;
	}
	public DFigure _address_(final int count) {
		 _address(count) ;
		 return this ;
	}
	public DAddress _address(final String jif) {
		return _address().jif(jif) ;
	}
	public DFigure _address_(final String jif) {
		_address(jif) ;
		return this ;
	}
	public DAddress _address(BaseHtmlElement... elements) {
		final DAddress answer = _address() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _address_(BaseHtmlElement... elements) {
		_address(elements) ;
		return this ;
	}

	public DArea _area() {
		 return _area(-1) ;
	}
	public DFigure _area_() {
		 _area(-1) ;
		 return this ;
	}
	public DArea _area(final int count) {
		 return (DArea)getOrCreate(DArea.class, count) ;
	}
	public DFigure _area_(final int count) {
		 _area(count) ;
		 return this;
	}
	public DArea _area(final String jif) {
		return _area().jif(jif) ;
	}
	public DFigure _area_(final String jif) {
		_area(jif) ;
		return this ;
	}

	public DArticle _article() {
		 return _article(-1) ;
	}
	public DFigure _article_() {
		 _article() ;
		 return this ;
	}
	public DArticle _article(final int count) {
		 return (DArticle)getOrCreate(DArticle.class, count) ;
	}
	public DFigure _article_(final int count) {
		_article(count) ;
		return this ;
	}
	public DArticle _article(final String jif) {
		return _article().jif(jif) ;
	}
	public DFigure _article_(final String jif) {
		_article(jif) ;
		return this ;
	}
	public DArticle _articleText(final String textValue) {
		return _article().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _articleText_(final String textValue) {
		_articleText(textValue) ;
		return this ;
	}
	public DArticle _article(BaseHtmlElement... elements) {
		final DArticle answer = _article() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _article_(BaseHtmlElement... elements) {
		_article(elements) ;
		return this ;
	}

	public DAside _aside() {
		 return _aside(-1) ;
	}
	public DFigure _aside_() {
		_aside() ;
		return this ;
	}
	public DAside _aside(final int count) {
		 return (DAside)getOrCreate(DAside.class, count) ;
	}
	public DFigure _aside_(final int count) {
		 _aside(count) ;
		 return this ;
	}
	public DAside _aside(final String jif) {
		return _aside().jif(jif) ;
	}
	public DFigure _aside_(final String jif) {
		_aside(jif) ;
		return this ;
	}
	public DAside _asideText(final String textValue) {
		return _aside().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _asideText_(final String textValue) {
		_asideText(textValue) ;
		return this ;
	}
	public DAside _aside(BaseHtmlElement... elements) {
		final DAside answer = _aside() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _aside_(BaseHtmlElement... elements) {
		_aside(elements) ;
		return this ;
	}

	public DAudio _audio() {
		 return _audio(-1) ;
	}
	public DFigure _audio_() {
		_audio() ;
		return this ;
	}
	public DAudio _audio(final int count) {
		 return (DAudio)getOrCreate(DAudio.class, count) ;
	}
	public DFigure _audio_(final int count) {
		_audio(count) ;
		return this ;
	}
	public DAudio _audio(final String jif) {
		return _audio().jif(jif) ;
	}
	public DFigure _audio_(final String jif) {
		_audio(jif) ;
		return this ;
	}

	public DB _b() {
		 return _b(-1) ;
	}
	public DFigure _b_() {
		_b() ;
		return this ;
	}
	public DB _b(final int count) {
		 return (DB)getOrCreate(DB.class, count) ;
	}
	public DFigure _b_(final int count) {
		_b(count) ;
		return this ;
	}
	public DB _b(final String jif) {
		return _b().jif(jif) ;
	}
	public DFigure _b_(final String jif) {
		_b(jif) ;
		return this ;
	}
	public DB _bText(final String textValue) {
		return _b().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _bText_(final String textValue) {
		_bText(textValue) ;
		return this ;
	}
	public DB _b(BaseHtmlElement... elements) {
		final DB answer = _b() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _b_(BaseHtmlElement... elements) {
		_b(elements) ;
		return this ;
	}

	public DBdo _bdo() {
		 return _bdo(-1) ;
	}
	public DFigure _bdo_() {
		_bdo() ;
		return this ;
	}
	public DBdo _bdo(final int count) {
		 return (DBdo)getOrCreate(DBdo.class, count) ;
	}
	public DFigure _bdo_(final int count) {
		_bdo(count) ;
		return this ;
	}
	public DBdo _bdo(final String jif) {
		return _bdo().jif(jif);
	}
	public DFigure _bdo_(final String jif) {
		_bdo(jif) ;
		return this ;
	}
	public DBdo _bdo(BaseHtmlElement... elements) {
		final DBdo answer = _bdo() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _bdo_(BaseHtmlElement... elements) {
		_bdo(elements) ;
		return this ;
	}

	public DBlockQuote _blockquote() {
		 return _blockquote(-1) ;
	}
	public DFigure _blockquote_() {
		_blockquote() ;
		return this ;
	}
	public DBlockQuote _blockquote(final int count) {
		 return (DBlockQuote)getOrCreate(DBlockQuote.class, count) ;
	}
	public DFigure _blockquote_(final int count) {
		_blockquote(count) ;
		return this ;
	}
	public DBlockQuote _blockquote(final String jif) {
		return _blockquote().jif(jif) ;
	}
	public DFigure _blockquote_(final String jif) {
		_blockquote(jif) ;
		return this ;
	}
	public DBlockQuote _blockquoteText(final String textValue) {
		return _blockquote().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _blockquoteText_(final String textValue) {
		_blockquoteText(textValue) ;
		return this ;
	}
	public DBlockQuote _blockquote(BaseHtmlElement... elements) {
		final DBlockQuote answer = _blockquote() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _blockquote_(BaseHtmlElement... elements) {
		_blockquote(elements) ;
		return this ;
	}

	public DBr _br() {
		 return _br(-1) ;
	}
	public DFigure _br_() {
		_br() ;
		return this ;
	}
	public DBr _br(final int count) {
		 return (DBr)getOrCreate(DBr.class, count) ;
	}
	public DFigure _br_(final int count) {
		 _br(count) ;
		 return this ;
	}
	public DBr _br(final String jif) {
		return _br().jif(jif) ;
	}
	public DFigure _br_(final String jif) {
		_br(jif) ;
		return this ;
	}

	public DButton _button() {
		 return _button(-1) ;
	}
	public DFigure _button_() {
		_button() ;
		return this ;
	}
	public DButton _button(final int count) {
		 return (DButton)getOrCreate(DButton.class, count) ;
	}
	public DFigure _button_(final int count) {
		_button(count) ;
		return this ;
	}
	public DButton _button(final String jif) {
		return _button().jif(jif) ;
	}
	public DFigure _button_(final String jif) {
		_button(jif) ;
		return this ;
	}
	public DButton _buttonText(final String textValue) {
		return _button().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _buttonText_(final String textValue) {
		_buttonText(textValue) ;
		return this ;
	}
	public DButton _button(BaseHtmlElement... elements) {
		final DButton answer = _button() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _button_(BaseHtmlElement... elements) {
		_button(elements) ;
		return this ;
	}

	public DCanvas _canvas() {
		 return _canvas(-1) ;
	}
	public DFigure _canvas_() {
		_canvas() ;
		return this ;
	}
	public DCanvas _canvas(final int count) {
		 return (DCanvas)getOrCreate(DCanvas.class, count) ;
	}
	public DFigure _canvas_(final int count) {
		_canvas(count) ;
		return this ;
	}
	public DCanvas _canvas(final String jif) {
		return _canvas().jif(jif) ;
	}
	public DFigure _canvas_(final String jif) {
		_canvas(jif) ;
		return this ;
	}
	

	public DCite _cite() {
		 return _cite(-1) ;
	}
	public DFigure _cite_() {
		_cite() ;
		return this ;
	}
	public DCite _cite(final int count) {
		 return (DCite)getOrCreate(DCite.class, count) ;
	}
	public DFigure _cite_(final int count) {
		 _cite(count) ;
		 return this ;
	}
	public DCite _cite(final String jif) {
		return _cite().jif(jif) ;
	}
	public DFigure _cite_(final String jif) {
		_cite(jif) ;
		return this;
	}
	public DCite _citeText(final String textValue) {
		return _cite().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _citeText_(final String textValue) {
		_citeText(textValue) ;
		return this ;
	}
	public DCite _cite(BaseHtmlElement... elements) {
		final DCite answer = _cite() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _cite_(BaseHtmlElement... elements) {
		_button(elements) ;
		return this ;
	}

	public DCode _code() {
		 return _code(-1) ;
	}
	public DFigure _code_() {
		_code() ;
		return this ;
	}
	public DCode _code(final int count) {
		 return (DCode)getOrCreate(DCode.class, count) ;
	}
	public DFigure _code_(final int count) {
		_code(count) ;
		return this ;
	}
	public DCode _code(final String jif) {
		return _code().jif(jif) ;
	}
	public DFigure _code_(final String jif) {
		_code(jif) ;
		return this ;
	}
	public DCode _codeText(final String textValue) {
		return _code().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _codeText_(final String textValue) {
		_codeText(textValue) ;
		return this;
	}
	public DCode _code(BaseHtmlElement... elements) {
		final DCode answer = _code() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _code_(BaseHtmlElement... elements) {
		_code(elements) ;
		return this ;
	}

	public DCommand _command() {
		 return _command(-1) ;
	}
	public DFigure _command_() {
		_command() ;
		return this ;
	}
	public DCommand _command(final int count) {
		 return (DCommand)getOrCreate(DCommand.class, count) ;
	}
	public DFigure _command_(final int count) {
		_command(count) ;
		return this ;
	}
	public DCommand _command(final String jif) {
		return _command().jif(jif) ;
	}
	public DFigure _command_(final String jif) {
		_command(jif) ;
		return this ;
	}

	public DDataList _datalist() {
		 return _datalist(-1) ;
	}
	public DFigure _datalist_() {
		_datalist() ;
		return this ;
	}
	public DDataList _datalist(final int count) {
		 return (DDataList)getOrCreate(DDataList.class, count) ;
	}
	public DFigure _datalist_(final int count) {
		_datalist(count) ;
		return this ;
	}
	public DDataList _datalist(final String jif) {
		return _datalist().jif(jif) ;
	}
	public DFigure _datalist_(final String jif) {
		_datalist(jif) ;
		return this ;
	}
	public DDataList _datalist(BaseHtmlElement... elements) {
		final DDataList answer = _datalist() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _datalist_(BaseHtmlElement... elements) {
		_datalist(elements) ;
		return this ;
	}

	public DDel _del() {
		 return _del(-1) ;
	}
	public DFigure _del_() {
		 _del() ;
		 return this ;
	}
	public DDel _del(final int count) {
		 return (DDel)getOrCreate(DDel.class, count) ;
	}
	public DFigure _del_(final int count) {
		_del(count) ;
		return this ;
	}
	public DDel _del(final String jif) {
		return _del().jif(jif) ;
	}
	public DFigure _del_(final String jif) {
		_del(jif) ;
		return this ;
	}
	public DDel _delText(final String textValue) {
		return _del().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _delText_(final String textValue) {
		_delText(textValue) ;
		return this ;
	}
	

	public DDetails _details() {
		 return _details(-1) ;
	}
	public DFigure _details_() {
		_details() ;
		return this ;
	}
	public DDetails _details(final int count) {
		 return (DDetails)getOrCreate(DDetails.class, count) ;
	}
	public DFigure _details_(final int count) {
		_details(count) ;
		return this ;
	}
	public DDetails _details(final String jif) {
		return _details().jif(jif) ;
	}
	public DFigure _details_(final String jif) {
		_details(jif) ;
		return this ;
	}
	public DDetails _details(BaseHtmlElement... elements) {
		final DDetails answer = _details() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _details_(BaseHtmlElement... elements) {
		_details(elements) ;
		return this ;
	}

	public DDfn _dfn() {
		 return _dfn(-1) ;
	}
	public DFigure _dfn_() {
		_dfn() ;
		return this ;
	}
	public DDfn _dfn(final int count) {
		 return (DDfn)getOrCreate(DDfn.class, count) ;
	}
	public DFigure _dfn_(final int count) {
		_dfn(count) ;
		return this ;
	}
	public DDfn _dfn(final String jif) {
		return _dfn().jif(jif) ;
	}
	public DFigure _dfn_(final String jif) {
		_dfn().jif(jif) ;
		return this ;
	}
	public DDfn _dfnText(final String textValue) {
		return _dfn().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _dfnText_(final String textValue) {
		_dfnText(textValue) ;
		return this ;
	}
	public DDfn _dfn(BaseHtmlElement... elements) {
		final DDfn answer = _dfn() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _dfn_(BaseHtmlElement... elements) {
		_dfn(elements) ;
		return this ;
	}

	public DDiv _div() {
		 return _div(-1) ;
	}
	public DFigure _div_() {
		_div() ;
		return this ;
	}
	public DDiv _div(final int count) {
		 return (DDiv)getOrCreate(DDiv.class, count) ;
	}
	public DFigure _div_(final int count) {
		_div(count) ;
		return this ;
	}
	public DDiv _div(final String jif) {
		return _div().jif(jif) ;
	}
	public DFigure _div_(final String jif) {
		_div(jif) ;
		return this ;
	}
	public DDiv _div(BaseHtmlElement... elements) {
		final DDiv answer = _div() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _div_(BaseHtmlElement... elements) {
		_div(elements) ;
		return this ;
	}

	public DDl _dl() {
		 return _dl(-1) ;
	}
	public DFigure _dl_() {
		_dl() ;
		return this ;
	}
	public DDl _dl(final int count) {
		 return (DDl)getOrCreate(DDl.class, count) ;
	}
	public DFigure _dl_(final int count) {
		_dl(count) ;
		return this ;
	}
	public DDl _dl(final String jif) {
		return _dl().jif(jif) ;
	}
	public DFigure _dl_(final String jif) {
		_dl().jif(jif) ;
		return this ;
	}
	public DDl _dl(BaseHtmlElement... elements) {
		final DDl answer = _dl() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _dl_(BaseHtmlElement... elements) {
		_dl(elements) ;
		return this ;
	}

	public DEm _em() {
		 return _em(-1) ;
	}
	public DFigure _em_() {
		_em() ;
		return this ;
	}
	public DEm _em(final int count) {
		 return (DEm)getOrCreate(DEm.class, count) ;
	}
	public DFigure _em_(final int count) {
		_em(count) ;
		return this ;
	}
	public DEm _em(final String jif) {
		return _em().jif(jif) ;
	}
	public DFigure _em_(final String jif) {
		_em(jif) ;
		return this ;
	}
	public DEm _emText(final String textValue) {
		return _em().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _emText_(final String textValue) {
		_emText(textValue) ;
		return this ;
	}
	public DEm _em(BaseHtmlElement... elements) {
		final DEm answer = _em() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _em_(BaseHtmlElement... elements) {
		_em(elements) ;
		return this ;
	}

	public DEmbed _embed() {
		 return _embed(-1) ;
	}
	public DFigure _embed_() {
		_embed() ;
		return this ;
	}
	public DEmbed _embed(final int count) {
		 return (DEmbed)getOrCreate(DEmbed.class, count) ;
	}
	public DFigure _embed_(final int count) {
		_embed(count) ;
		return this ;
	}
	public DEmbed _embed(final String jif) {
		return _embed().jif(jif) ;
	}
	public DFigure _embed_(final String jif) {
		_embed(jif) ;
		return this ;
	}

	public DFieldSet _fieldset() {
		 return _fieldset(-1) ;
	}
	public DFigure _fieldset_() {
		_fieldset() ;
		return this ;
	}
	public DFieldSet _fieldset(final int count) {
		 return (DFieldSet)getOrCreate(DFieldSet.class, count) ;
	}
	public DFigure _fieldset_(final int count) {
		_fieldset(count) ;
		return this ;
	}
	public DFieldSet _fieldset(final String jif) {
		return _fieldset().jif(jif) ;
	}
	public DFigure _fieldset_(final String jif) {
		_fieldset(jif) ;
		return this ;
	}
	public DFieldSet _fieldsetLegend(final String legend) {
		return _fieldset().add(new DLegend(legend)) ;
	}
	public DFigure _fieldsetLegend_(final String legend) {
		_fieldsetLegend(legend) ;
		return this ;
	}
	public DFieldSet _fieldset(BaseHtmlElement... elements) {
		final DFieldSet answer = _fieldset() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _fieldset_(BaseHtmlElement... elements) {
		_fieldset(elements) ;
		return this ;
	}

	public DFigure _figure() {
		 return _figure(-1) ;
	}
	public DFigure _figure_() {
		_figure() ;
		return this ;
	}
	public DFigure _figure(final int count) {
		 return (DFigure)getOrCreate(DFigure.class, count) ;
	}
	public DFigure _figure_(final int count) {
		_figure(count) ;
		return this ;
	}
	public DFigure _figure(final String jif) {
		return _figure().jif(jif) ;
	}
	public DFigure _figure_(final String jif) {
		_figure(jif) ;
		return this ;
	}
	public DFigure _figure(BaseHtmlElement... elements) {
		final DFigure answer = _figure() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _figure_(BaseHtmlElement... elements) {
		_figure(elements) ;
		return this ;
	}
		
	public DFooter _footer() {
		 return _footer(-1) ;
	}
	public DFigure _footer_() {
		_footer() ;
		return this ;
	}
	public DFooter _footer(final int count) {
		 return (DFooter)getOrCreate(DFooter.class, count) ;
	}
	public DFigure _footer_(final int count) {
		_footer(count) ;
		return this ;
	}
	public DFooter _footer(final String jif) {
		return _footer().jif(jif) ;
	}
	public DFigure _footer_(final String jif) {
		_footer(jif) ;
		return this ;
	}
	public DFooter _footerText(final String textValue) {
		return _footer().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _footerText_(final String textValue) {
		_footerText(textValue) ;
		return this ;
	}
	public DFooter _footer(BaseHtmlElement... elements) {
		final DFooter answer = _footer() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _footer_(BaseHtmlElement... elements) {
		_footer(elements) ;
		return this ;
	}

	public DForm _form() {
		 return _form(-1) ;
	}
	public DFigure _form_() {
		_form() ;
		return this ;
	}
	public DForm _form(final int count) {
		 return (DForm)getOrCreate(DForm.class, count) ;
	}
	public DFigure _form_(final int count) {
		_form(count) ;
		return this ;
	}
	public DForm _form(final String jif) {
		return _form().jif(jif) ;
	}
	public DFigure _form_(final String jif) {
		_form(jif) ;
		return this ;
	}
	public DForm _form(BaseHtmlElement... elements) {
		final DForm answer = _form() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _form_(BaseHtmlElement... elements) {
		_form(elements) ;
		return this ;
	}

	public DH1 _h1() {
		 return _h1(-1) ;
	}
	public DFigure _h1_() {
		_h1() ;
		return this ;
	}
	public DH1 _h1(final int count) {
		 return (DH1)getOrCreate(DH1.class, count) ;
	}
	public DFigure _h1_(final int count) {
		_h1(count);
		return this ;
	}
	public DH1 _h1(final String jif) {
		return _h1().jif(jif) ;
	}
	public DFigure _h1_(final String jif) {
		_h1(jif) ;
		return this ;
	}
	public DH1 _h1Text(final String textValue) {
		return _h1().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _h1Text_(final String textValue) {
		_h1Text(textValue) ;
		return this ;
	}
	public DH1 _h1(BaseHtmlElement... elements) {
		final DH1 answer = _h1() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _h1_(BaseHtmlElement... elements) {
		_h1(elements) ;
		return this ;
	}

	public DH2 _h2() {
		 return _h2(-1) ;
	}
	public DFigure _h2_() {
		_h2() ;
		return this ;
	}
	public DH2 _h2(final int count) {
		 return (DH2)getOrCreate(DH2.class, count) ;
	}
	public DFigure _h2_(final int count) {
		_h2(count);
		return this ;
	}
	public DH2 _h2(final String jif) {
		return _h2().jif(jif) ;
	}
	public DFigure _h2_(final String jif) {
		_h2(jif) ;
		return this ;
	}
	public DH2 _h2Text(final String textValue) {
		return _h2().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _h2Text_(final String textValue) {
		_h2Text(textValue) ;
		return this ;
	}
	public DH2 _h2(BaseHtmlElement... elements) {
		final DH2 answer = _h2() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _h2_(BaseHtmlElement... elements) {
		_h2(elements) ;
		return this ;
	}

	public DH3 _h3() {
		 return _h3(-1) ;
	}
	public DFigure _h3_() {
		_h3() ;
		return this ;
	}
	public DH3 _h3(final int count) {
		 return (DH3)getOrCreate(DH3.class, count) ;
	}
	public DFigure _h3_(final int count) {
		_h3(count);
		return this ;
	}
	public DH3 _h3(final String jif) {
		return _h3().jif(jif) ;
	}
	public DFigure _h3_(final String jif) {
		_h3(jif) ;
		return this ;
	}
	public DH3 _h3Text(final String textValue) {
		return _h3().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _h3Text_(final String textValue) {
		_h3Text(textValue) ;
		return this ;
	}
	public DH3 _h3(BaseHtmlElement... elements) {
		final DH3 answer = _h3() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _h3_(BaseHtmlElement... elements) {
		_button(elements) ;
		return this ;
	}
	
	public DH4 _h4() {
		 return _h4(-1) ;
	}
	public DFigure _h4_() {
		_h4() ;
		return this ;
	}
	public DH4 _h4(final int count) {
		 return (DH4)getOrCreate(DH4.class, count) ;
	}
	public DFigure _h4_(final int count) {
		_h4(count);
		return this ;
	}
	public DH4 _h4(final String jif) {
		return _h4().jif(jif) ;
	}
	public DFigure _h4_(final String jif) {
		_h4(jif) ;
		return this ;
	}
	public DH4 _h4Text(final String textValue) {
		return _h4().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _h4Text_(final String textValue) {
		_h4Text(textValue) ;
		return this ;
	}
	public DH4 _h4(BaseHtmlElement... elements) {
		final DH4 answer = _h4() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _h4_(BaseHtmlElement... elements) {
		_h4(elements) ;
		return this ;
	}
	
	public DH5 _h5() {
		 return _h5(-1) ;
	}
	public DFigure _h5_() {
		_h5() ;
		return this ;
	}
	public DH5 _h5(final int count) {
		 return (DH5)getOrCreate(DH5.class, count) ;
	}
	public DFigure _h5_(final int count) {
		_h5(count);
		return this ;
	}
	public DH5 _h5(final String jif) {
		return _h5().jif(jif) ;
	}
	public DFigure _h5_(final String jif) {
		_h5(jif) ;
		return this ;
	}
	public DH5 _h5Text(final String textValue) {
		return _h5().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _h5Text_(final String textValue) {
		_h5Text(textValue) ;
		return this ;
	}
	public DH5 _h5(BaseHtmlElement... elements) {
		final DH5 answer = _h5() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _h5_(BaseHtmlElement... elements) {
		_h5(elements) ;
		return this ;
	}
	
	public DH6 _h6() {
		 return _h6(-1) ;
	}
	public DFigure _h6_() {
		_h6() ;
		return this ;
	}
	public DH6 _h6(final int count) {
		 return (DH6)getOrCreate(DH6.class, count) ;
	}
	public DFigure _h6_(final int count) {
		_h6(count);
		return this ;
	}
	public DH6 _h6(final String jif) {
		return _h6().jif(jif) ;
	}
	public DFigure _h6_(final String jif) {
		_h6(jif) ;
		return this ;
	}
	public DH6 _h6Text(final String textValue) {
		return _h6().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _h6Text_(final String textValue) {
		_h6Text(textValue) ;
		return this ;
	}
	public DH6 _h6(BaseHtmlElement... elements) {
		final DH6 answer = _h6() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _h6_(BaseHtmlElement... elements) {
		_h6(elements) ;
		return this ;
	}
	
	public DHeader _header() {
		 return _header(-1) ;
	}
	public DFigure _header_() {
		_header() ;
		return this ;
	}
	public DHeader _header(final int count) {
		 return (DHeader)getOrCreate(DHeader.class, count) ;
	}
	public DFigure _header_(final int count) {
		_header(count) ;
		return this ;
	}
	public DHeader _header(final String jif) {
		return _header().jif(jif) ;
	}
	public DFigure _header_(final String jif) {
		_header(jif) ;
		return this ;
	}
	public DHeader _header(BaseHtmlElement... elements) {
		final DHeader answer = _header() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _header_(BaseHtmlElement... elements) {
		_header(elements) ;
		return this ;
	}

	public DHGroup _hgroup() {
		 return _hgroup(-1) ;
	}
	public DFigure _hgroup_() {
		_hgroup() ;
		return this ;
	}
	public DHGroup _hgroup(final int count) {
		 return (DHGroup)getOrCreate(DHGroup.class, count) ;
	}
	public DFigure _hgroup_(final int count) {
		_hgroup(count) ;
		return this ;
	}
	public DHGroup _hgroup(final String jif) {
		return _hgroup().jif(jif) ;
	}
	public DFigure _hgroup_(final String jif) {
		_hgroup(jif) ;
		return this ;
	}
	public DHGroup _hgroup(BaseHtmlElement... elements) {
		final DHGroup answer = _hgroup() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _hgroup_(BaseHtmlElement... elements) {
		_hgroup(elements) ;
		return this ;
	}

	public DHr _hr() {
		 return _hr(-1) ;
	}
	public DFigure _hr_() {
		_hr() ;
		return this ;
	}
	public DHr _hr(final int count) {
		 return (DHr)getOrCreate(DHr.class, count) ;
	}
	public DFigure _hr_(final int count) {
		_hr(count) ;
		return this ;
	}
	public DHr _hr(final String jif) {
		return _hr().jif(jif) ;
	}
	public DFigure _hr_(final String jif) {
		_hr(jif) ;
		return this ;
	}

	public DI _i() {
		 return _i(-1) ;
	}
	public DFigure _i_() {
		_i() ;
		return this ;
	}
	public DI _i(final int count) {
		 return (DI)getOrCreate(DI.class, count) ;
	}
	public DFigure _i_(final int count) {
		_i(count) ;
		return this ;
	}
	public DI _i(final String jif) {
		return _i().jif(jif) ;
	}
	public DFigure _i_(final String jif) {
		_i(jif) ;
		return this ;
	}
	public DI _iText(final String textValue) {
		return _i().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _iText_(final String textValue) {
		_iText(textValue) ;
		return this ;
	}
	public DI _i(BaseHtmlElement... elements) {
		final DI answer = _i() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _i_(BaseHtmlElement... elements) {
		_i(elements) ;
		return this ;
	}

	public DIFrame _iframe() {
		 return _iframe(-1) ;
	}
	public DFigure _iframe_() {
		_iframe() ;
		return this ;
	}
	public DIFrame _iframe(final int count) {
		 return (DIFrame)getOrCreate(DIFrame.class, count) ;
	}
	public DFigure _iframe_(final int count) {
		_iframe(count) ;
		return this ;
	}
	public DIFrame _iframe(final String jif) {
		return _iframe().jif(jif) ;
	}
	public DFigure _iframe_(final String jif) {
		_iframe(jif) ;
		return this ;
	}

	public DImg _img() {
		 return _img(-1) ;
	}
	public DFigure _img_() {
		_img() ;
		return this ;
	}
	public DImg _img(final int count) {
		 return (DImg)getOrCreate(DImg.class, count) ;
	}
	public DFigure _img_(final int count) {
		_img(count) ;
		return this ;
	}
	public DImg _img(final String jif) {
		return _img().jif(jif) ;
	}
	public DFigure _img_(final String jif) {
		_img(jif) ;
		return this ;
	}
	public DImg _img(final String srcUrl, final String alt) {
		return _img().setHtmlSrc(srcUrl).setHtmlAlt(alt) ;
	}
	public DFigure _img_(final String srcUrl, final String alt) {
		_img(srcUrl, alt) ;
		return this ;
	}

	public DInput _input() {
		 return _input(-1) ;
	}
	public DFigure _input_() {
		_input() ;
		return this ;
	}
	public DInput _input(final int count) {
		 return (DInput)getOrCreate(DInput.class, count) ;
	}
	public DFigure _input_(final int count) {
		_input(count) ;
		return this ;
	}
	public DInput _input(final String jif) {
		return _input().jif(jif) ;
	}
	public DFigure _input_(final String jif) {
		_input(jif) ;
		return this ;
	}
	public DInput _inputValue(final String value) {
		return _input().setHtmlValue(value) ;
	}
	public DFigure _inputValue_(final String value) {
		_inputValue(value) ;
		return this ;
	}

	public DIns _ins() {
		 return _ins(-1) ;
	}
	public DFigure _ins_() {
		_ins() ;
		return this ;
	}
	public DIns _ins(final int count) {
		 return (DIns)getOrCreate(DIns.class, count) ;
	}
	public DFigure _ins_(final int count) {
		_ins(count) ;
		return this ;
	}
	public DIns _ins(final String jif) {
		return _ins().jif(jif) ;
	}
	public DFigure _ins_(final String jif) {
		_ins(jif) ;
		return this ;
	}
	public DIns _insText(final String textValue) {
		return _ins().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _insText_(final String textValue) {
		_insText(textValue) ;
		return this ;
	}

	public DKbd _kbd() {
		 return _kbd(-1) ;
	}
	public DFigure _kbd_() {
		_kbd() ;
		return this ;
	}
	public DKbd _kbd(final int count) {
		 return (DKbd)getOrCreate(DKbd.class, count) ;
	}
	public DFigure _kbd_(final int count) {
		_kbd(count) ;
		return this ;
	}
	public DKbd _kbd(final String jif) {
		return _kbd().jif(jif) ;
	}
	public DFigure _kbd_(final String jif) {
		_kbd(jif) ;
		return this ;
	}
	public DKbd _kbdText(final String textValue) {
		return _kbd().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _kbdText_(final String textValue) {
		_kbdText(textValue) ;
		return this ;
	}
	public DKbd _kbd(BaseHtmlElement... elements) {
		final DKbd answer = _kbd() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _kbd_(BaseHtmlElement... elements) {
		_kbd(elements) ;
		return this ;
	}

	public DKeyGen _keygen() {
		 return _keygen(-1) ;
	}
	public DFigure _keygen_() {
		_keygen() ;
		return this ;
	}
	public DKeyGen _keygen(final int count) {
		 return (DKeyGen)getOrCreate(DKeyGen.class, count) ;
	}
	public DFigure _keygen_(final int count) {
		_keygen(count) ;
		return this ;
	}
	public DKeyGen _keygen(final String jif) {
		return _keygen().jif(jif) ;
	}
	public DFigure _keygen_(final String jif) {
		_keygen(jif) ;
		return this ;
	}

	public DLabel _label() {
		 return _label(-1) ;
	}
	public DFigure _label_() {
		_label() ;
		return this ;
	}
	public DLabel _label(final int count) {
		 return (DLabel)getOrCreate(DLabel.class, count) ;
	}
	public DFigure _label_(final int count) {
		_label(count) ;
		return this ;
	}
	public DLabel _label(final String jif) {
		return _label().jif(jif) ;
	}
	public DFigure _label_(final String jif) {
		_label(jif) ;
		return this ;
	}
	public DLabel _labelText(final String textValue) {
		return _label().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _labelText_(final String textValue) {
		_labelText(textValue) ;
		return this;
	}
	public DLabel _label(BaseHtmlElement... elements) {
		final DLabel answer = _label() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _label_(BaseHtmlElement... elements) {
		_label(elements) ;
		return this ;
	}

	public DMap _map() {
		 return _map(-1) ;
	}
	public DFigure _map_() {
		_map() ;
		return this ;
	}
	public DMap _map(final int count) {
		 return (DMap)getOrCreate(DMap.class, count) ;
	}
	public DFigure _map_(final int count) {
		_map(count) ;
		return this ;
	}
	public DMap _map(final String jif) {
		return _map().jif(jif) ;
	}
	public DFigure _map_(final String jif) {
		_map(jif) ;
		return this ;
	}
	public DMap _map(BaseHtmlElement... elements) {
		final DMap answer = _map() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _map_(BaseHtmlElement... elements) {
		_map(elements) ;
		return this ;
	}

	public DMark _mark() {
		 return _mark(-1) ;
	}
	public DFigure _mark_() {
		_mark() ;
		return this ;
	}
	public DMark _mark(final int count) {
		 return (DMark)getOrCreate(DMark.class, count) ;
	}
	public DFigure _mark_(final int count) {
		_mark(count) ;
		return this ;
	}
	public DMark _mark(final String jif) {
		return _mark().jif(jif) ;
	}
	public DFigure _mark_(final String jif) {
		_mark(jif) ;
		return this ;
	}
	public DMark _mark(BaseHtmlElement... elements) {
		final DMark answer = _mark() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _mark_(BaseHtmlElement... elements) {
		_mark(elements) ;
		return this ;
	}

	public DMenu _menu() {
		 return _menu(-1) ;
	}
	public DFigure _menu_() {
		_menu() ;
		return this ;
	}
	public DMenu _menu(final int count) {
		 return (DMenu)getOrCreate(DMenu.class, count) ;
	}
	public DFigure _menu_(final int count) {
		_menu(count) ;
		return this ;
	}
	public DMenu _menu(final String jif) {
		return _menu().jif(jif) ;
	}
	public DFigure _menu_(final String jif) {
		_menu(jif) ;
		return this ;
	}
	public DMenu _menu(BaseHtmlElement... elements) {
		final DMenu answer = _menu() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _menu_(BaseHtmlElement... elements) {
		_menu(elements) ;
		return this ;
	}

	public DMeter _meter() {
		 return _meter(-1) ;
	}
	public DFigure _meter_() {
		_meter() ;
		return this ;
	}
	public DMeter _meter(final int count) {
		 return (DMeter)getOrCreate(DMeter.class, count) ;
	}
	public DFigure _meter_(final int count) {
		_meter(count) ;
		return this ;
	}
	public DMeter _meter(final String jif) {
		return _meter().jif(jif) ;
	}
	public DFigure _meter_(final String jif) {
		_meter(jif) ;
		return this ;
	}
	public DMeter _meter(final String min, final String max) {
		return _meter().setHtmlMin(min).setHtmlMax(max) ;
	}
	public DFigure _meter_(final String min, final String max) {
		_meter(min, max) ;
		return this ;
	}
	public DMeter _meter(final String min, final String max, final String 

value) {
		return _meter(min, max).setHtmlValue(value) ;
	}
	public DFigure _meter_(final String min, final String max, final String value) 

{
		_meter(min, max, value) ;
		return this ;
	}
	public DMeter _meter(final double min, final double max) {
		return _meter().setHtmlMin(min).setHtmlMax(max) ;
	}
	public DFigure _meter_(final double min, final double max) {
		_meter(min, max) ;
		return this ;
	}
	public DMeter _meter(final double min, final double max, final double 

value) {
		return _meter(min, max).setHtmlValue(value) ;
	}
	public DFigure _meter_(final double min, final double max, final double value) 

{
		_meter(min, max, value) ;
		return this ;
	}
	public DMeter _meter(BaseHtmlElement... elements) {
		final DMeter answer = _meter() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _meter_(BaseHtmlElement... elements) {
		_meter(elements) ;
		return this ;
	}

	public DNav _nav() {
		 return _nav(-1) ;
	}
	public DFigure _nav_() {
		_nav() ;
		return this ;
	}
	public DNav _nav(final int count) {
		 return (DNav)getOrCreate(DNav.class, count) ;
	}
	public DFigure _nav_(final int count) {
		_nav(count) ;
		return this ;
	}
	public DNav _nav(final String jif) {
		return _nav().jif(jif) ;
	}
	public DFigure _nav_(final String jif) {
		_nav(jif) ;
		return this ;
	}
	public DNav _nav(BaseHtmlElement... elements) {
		final DNav answer = _nav() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _nav_(BaseHtmlElement... elements) {
		_nav(elements) ;
		return this ;
	}

	public DNoScript _noscript() {
		 return _noscript(-1) ;
	}
	public DFigure _noscript_() {
		_noscript() ;
		return this ;
	}
	public DNoScript _noscript(final int count) {
		 return (DNoScript)getOrCreate(DNoScript.class, count) ;
	}
	public DFigure _noscript_(final int count) {
		_noscript(count) ;
		return this ;
	}
	public DNoScript _noscript(final String jif) {
		return _noscript().jif(jif) ;
	}
	public DFigure _noscript_(final String jif) {
		_noscript(jif) ;
		return this ;
	}

	public DObject _object() {
		 return _object(-1) ;
	}
	public DFigure _object_() {
		_object() ;
		return this ;
	}
	public DObject _object(final int count) {
		 return (DObject)getOrCreate(DObject.class, count) ;
	}
	public DFigure _object_(final int count) {
		_object(count) ;
		return this ;
	}
	public DObject _object(final String jif) {
		return _object().jif(jif) ;
	}
	public DFigure _object_(final String jif) {
		_object(jif) ;
		return this ;
	}
	public DObject _object(DParam... elements) {
		final DObject answer = _object() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _object_(DParam... elements) {
		_object(elements) ;
		return this ;
	}

	public DOl _ol() {
		 return _ol(-1) ;
	}
	public DFigure _ol_() {
		_ol() ;
		return this ;
	}
	public DOl _ol(final int count) {
		 return (DOl)getOrCreate(DOl.class, count) ;
	}
	public DFigure _ol_(final int count) {
		_ol(count) ;
		return this ;
	}
	public DOl _ol(final String jif) {
		return _ol().jif(jif) ;
	}
	public DFigure _ol_(final String jif) {
		_ol(jif) ;
		return this ;
	}
	public DOl _ol(final Collection<Object> collection) {
		return _ol(collection, "1" /* arabic - 1, 2, 3, ...*/) ;
	}
	public DFigure _ol_(final Collection<Object> collection) {
		_ol(collection) ;
		return this ;
	}
	public DOl _ol(final Collection<Object> collection, final String htmlType) 

{
		DOl ol = _ol() ;
		for (Object listElement : collection) {
			final DLi li = new DLi(listElement.toString()) ;
			if (htmlType != null) {
				li.setHtmlType(htmlType);
			}
			ol.add(li) ;
		}	
		return ol ;
	}
	public DFigure _ol_(final Collection<Object> collection, final String 

htmlType) {
		_ol(collection, htmlType) ;
		return this ;
	}
	public DOl _ol(DLi... elements) {
		final DOl answer = _ol() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _ol_(DLi... elements) {
		_ol(elements) ;
		return this ;
	}

	public DOutput _output() {
		 return _output(-1) ;
	}
	public DFigure _output_() {
		_output() ;
		return this ;
	}
	public DOutput _output(final int count) {
		 return (DOutput)getOrCreate(DOutput.class, count) ;
	}
	public DFigure _output_(final int count) {
		_output(count) ;
		return this ;
	}
	public DOutput _output(final String jif) {
		return _output().jif(jif) ;
	}
	public DFigure _output_(final String jif) {
		_output(jif) ;
		return this ;
	}
	public DOutput _output(BaseHtmlElement... elements) {
		final DOutput answer = _output() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _output_(BaseHtmlElement... elements) {
		_output(elements) ;
		return this ;
	}

	public DP _p() {
		 return _p(-1) ;
	}
	public DFigure _p_() {
		_p() ;
		return this ;
	}
	public DP _p(final int count) {
		 return (DP)getOrCreate(DP.class, count) ;
	}
	public DFigure _p_(final int count) {
		_p(count) ;
		return this ;
	}
	public DP _p(final String jif) {
		return _p().jif(jif) ;
	}
	public DFigure _p_(final String jif) {
		_p(jif) ;
		return this ;
	}
	public DP _pText(final String textValue) {
		return _p().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _pText_(final String textValue) {
		_pText(textValue) ;
		return this ;
	}
	public DP _p(BaseHtmlElement... elements) {
		final DP answer = _p() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _p_(BaseHtmlElement... elements) {
		_p(elements) ;
		return this ;
	}

	public DPre _pre() {
		 return _pre(-1) ;
	}
	public DFigure _pre_() {
		_pre() ;
		return this ;
	}
	public DPre _pre(final int count) {
		 return (DPre)getOrCreate(DPre.class, count) ;
	}
	public DFigure _pre_(final int count) {
		_pre(count) ;
		return this ;
	}
	public DPre _pre(final String jif) {
		return _pre().jif(jif) ;
	}
	public DFigure _pre_(final String jif) {
		_pre(jif) ;
		return this ;
	}
	public DPre _preText(final String textValue) {
		return _pre().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _preText_(final String textValue) {
		_preText(textValue) ;
		return this ;
	}
	public DPre _pre(BaseHtmlElement... elements) {
		final DPre answer = _pre() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _pre_(BaseHtmlElement... elements) {
		_pre(elements) ;
		return this ;
	}

	public DProgress _progress() {
		 return _progress(-1) ;
	}
	public DFigure _progress_() {
		_progress() ;
		return this ;
	}
	public DProgress _progress(final int count) {
		 return (DProgress)getOrCreate(DProgress.class, count) ;
	}
	public DFigure _progress_(final int count) {
		_progress(count) ;
		return this ;
	}
	public DProgress _progress(final String jif) {
		return _progress().jif(jif) ;
	}
	public DFigure _progress_(final String jif) {
		_progress(jif) ;
		return this ;
	}
	public DProgress _progress(final double max, final double value) {
		return _progress().setHtmlMax(max).setHtmlValue(value) ;
	}
	public DFigure _progress_(final double max, final double value) {
		_progress(max, value) ;
		return this ;
	}
	public DProgress _progress(final String max, final String value) {
		return _progress().setHtmlMax(max).setHtmlValue(value) ;
	}
	public DFigure _progress_(final String max, final String value) {
		_progress(max, value) ;
		return this ;
	}
	public DProgress _progress(BaseHtmlElement... elements) {
		final DProgress answer = _progress() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _progress_(BaseHtmlElement... elements) {
		_progress(elements) ;
		return this ;
	}

	public DQ _q() {
		 return _q(-1) ;
	}
	public DFigure _q_() {
		_q();
		return this ;
	}
	public DQ _q(final int count) {
		 return (DQ)getOrCreate(DQ.class, count) ;
	}
	public DFigure _q_(final int count) {
		_q(count) ;
		return this ;
	}
	public DQ _q(final String jif) {
		return _q().jif(jif) ;
	}
	public DFigure _q_(final String jif) {
		_q(jif) ;
		return this ;
	}
	public DQ _qText(final String textValue) {
		return _q().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _qText_(final String textValue) {
		_qText(textValue) ;
		return this ;
	}
	public DQ _q(BaseHtmlElement... elements) {
		final DQ answer = _q() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _q_(BaseHtmlElement... elements) {
		_q(elements) ;
		return this ;
	}

	public DRuby _ruby() {
		 return _ruby(-1) ;
	}
	public DFigure _ruby_() {
		_ruby() ;
		return this ;
	}
	public DRuby _ruby(final int count) {
		 return (DRuby)getOrCreate(DRuby.class, count) ;
	}
	public DFigure _ruby_(final int count) {
		_ruby(count) ;
		return this ;
	}
	public DRuby _ruby(final String jif) {
		return _ruby().jif(jif) ;
	}
	public DFigure _ruby_(final String jif) {
		_ruby(jif) ;
		return this ;
	}
	public DRuby _ruby(BaseHtmlElement... elements) {
		final DRuby answer = _ruby() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _ruby_(BaseHtmlElement... elements) {
		_ruby(elements) ;
		return this ;
	}

	public DSamp _samp() {
		 return _samp(-1) ;
	}
	public DFigure _samp_() {
		_samp() ;
		return this ;
	}
	public DSamp _samp(final int count) {
		 return (DSamp)getOrCreate(DSamp.class, count) ;
	}
	public DFigure _samp_(final int count) {
		_samp(count) ;
		return this ;
	}
	public DSamp _samp(final String jif) {
		return _samp().jif(jif) ;
	}
	public DFigure _samp_(final String jif) {
		_samp(jif) ;
		return this ;
	}
	public DSamp _sampText(final String textValue) {
		return _samp().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _sampText_(final String textValue) {
		_sampText(textValue) ;
		return this ;
	}
	public DSamp _samp(BaseHtmlElement... elements) {
		final DSamp answer = _samp() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _samp_(BaseHtmlElement... elements) {
		_samp(elements) ;
		return this ;
	}

	public DScript _script() {
		 return _script(-1) ;
	}
	public DFigure _script_() {
		_script();
		return this ;
	}
	public DScript _script(final int count) {
		 return (DScript)getOrCreate(DScript.class, count) ;
	}
	public DFigure _script_(final int count) {
		_script(count) ;
		return this ;
	}
	public DScript _script(final String jif) {
		return _script().jif(jif) ;
	}
	public DFigure _script_(final String jif) {
		_script(jif) ;
		return this ;
	}
	public DScript _scriptText(final String text) {
		return _script().setHtmlText(text) ;
	}
	public DFigure _scriptText_(final String text) {
		_scriptText(text) ;
		return this ;
	}
	public DScript _scriptText(final String text, final String type) {
		return _scriptText(text).setHtmlType(type) ;
	}
	public DFigure _scriptText_(final String text, final String type) {
		_scriptText(text, type) ;
		return this ;
	}

	public DSection _section() {
		 return _section(-1) ;
	}
	public DFigure _section_() {
		_section() ;
		return this ;
	}
	public DSection _section(final int count) {
		 return (DSection)getOrCreate(DSection.class, count) ;
	}
	public DFigure _section_(final int count) {
		_section(count) ;
		return this ;
	}
	public DSection _section(final String jif) {
		return _section().jif(jif) ;
	}
	public DFigure _section_(final String jif) {
		_section(jif) ;
		return this ;
	}
	public DSection _section(BaseHtmlElement... elements) {
		final DSection answer = _section() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _section_(BaseHtmlElement... elements) {
		_section(elements) ;
		return this ;
	}
	

	public DSelect _select() {
		 return _select(-1) ;
	}
	public DFigure _select_() {
		_select();
		return this ;
	}
	public DSelect _select(final int count) {
		 return (DSelect)getOrCreate(DSelect.class, count) ;
	}
	public DFigure _select_(final int count) {
		_select(count);
		return this ;
	}
	public DSelect _select(final String jif) {
		return _select().jif(jif) ;
	}
	public DFigure _select_(final String jif) {
		_select(jif) ;
		return this ;
	}
	public DSelect _select(BaseHtmlElement... elements) {
		final DSelect answer = _select() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _select_(BaseHtmlElement... elements) {
		_select(elements) ;
		return this ;
	}

	public DSmall _small() {
		 return _small(-1) ;
	}
	public DFigure _small_() {
		_small() ;
		return this ;
	}
	public DSmall _small(final int count) {
		 return (DSmall)getOrCreate(DSmall.class, count) ;
	}
	public DFigure _small_(final int count) {
		_small(count) ;
		return this ;
	}
	public DSmall _small(final String jif) {
		return _small().jif(jif) ;
	}
	public DFigure _small_(final String jif) {
		_small(jif) ;
		return this ;
	}
	public DSmall _smallText(final String textValue) {
		return _small().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _smallText_(final String textValue) {
		_smallText(textValue) ;
		return this ;
	}
	public DSmall _small(BaseHtmlElement... elements) {
		final DSmall answer = _small() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _small_(BaseHtmlElement... elements) {
		_small(elements) ;
		return this ;
	}

	public DSpan _span() {
		 return _span(-1) ;
	}
	public DFigure _span_() {
		_span() ;
		return this ;
	}
	public DSpan _span(final int count) {
		 return (DSpan)getOrCreate(DSpan.class, count) ;
	}
	public DFigure _span_(final int count) {
		_span(count) ;
		return this ;
	}
	public DSpan _span(final String jif) {
		return _span().jif(jif) ;
	}
	public DFigure _span_(final String jif) {
		_span(jif) ;
		return this ;
	}
	public DSpan _span(BaseHtmlElement... elements) {
		final DSpan answer = _span() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _span_(BaseHtmlElement... elements) {
		_span(elements) ;
		return this ;
	}

	public DStrong _strong() {
		 return _strong(-1) ;
	}
	public DFigure _strong_() {
		_strong() ;
		return this ;
	}
	public DStrong _strong(final int count) {
		 return (DStrong)getOrCreate(DStrong.class, count) ;
	}
	public DFigure _strong_(final int count) {
		_strong(count) ;
		return this ;
	}
	public DStrong _strong(final String jif) {
		return _strong().jif(jif);
	}
	public DFigure _strong_(final String jif) {
		_strong(jif) ;
		return this ;
	}
	public DStrong _strongText(final String textValue) {
		return _strong().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _strongText_(final String textValue) {
		_strongText(textValue) ;
		return this ;
	}
	public DStrong _strong(BaseHtmlElement... elements) {
		final DStrong answer = _strong() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _strong_(BaseHtmlElement... elements) {
		_strong(elements) ;
		return this ;
	}

	public DStyle _style() {
		 return _style(-1) ;
	}
	public DFigure _style_() {
		_style() ;
		return this ;
	}
	public DStyle _style(final int count) {
		 return (DStyle)getOrCreate(DStyle.class, count) ;
	}
	public DFigure _style_(final int count) {
		_style(count) ;
		return this ;
	}
	public DStyle _style(final String jif) {
		return _style().jif(jif) ;
	}
	public DFigure _style_(final String jif) {
		_style(jif) ;
		return this ;
	}
	public DStyle _styleText(final String styleText) {
		return _style().add(styleText) ;
	}
	public DFigure _styleText_(final String styleText) {
		_styleText(styleText) ;
		return this ;
	}

	public DSub _sub() {
		 return _sub(-1) ;
	}
	public DFigure _sub_() {
		_sub();
		return this ;
	}
	public DSub _sub(final int count) {
		 return (DSub)getOrCreate(DSub.class, count) ;
	}
	public DFigure _sub_(final int count) {
		_sub(count) ;
		return this ;
	}
	public DSub _sub(final String jif) {
		return _sub().jif(jif) ;
	}
	public DFigure _sub_(final String jif) {
		_sub(jif) ;
		return this ;
	}
	public DSub _subText(final String textValue) {
		return _sub().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _subText_(final String textValue) {
		_subText(textValue) ;
		return this ;
	}
	public DSub _sub(BaseHtmlElement... elements) {
		final DSub answer = _sub() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _sub_(BaseHtmlElement... elements) {
		_sub(elements) ;
		return this ;
	}

	public DSup _sup() {
		 return _sup(-1) ;
	}
	public DFigure _sup_() {
		_sup(); 
		return this ;
	}
	public DSup _sup(final int count) {
		 return (DSup)getOrCreate(DSup.class, count) ;
	}
	public DFigure _sup_(final int count) {
		_sup(count) ;
		return this ;
	}
	public DSup _sup(final String jif) {
		return _sup().jif(jif) ;
	}
	public DFigure _sup_(final String jif) {
		_sup(jif) ;
		return this ;
	}
	public DSup _supText(final String textValue) {
		return _sup().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _supText_(final String textValue) {
		_supText(textValue) ;
		return this ;
	}
	public DSup _sup(BaseHtmlElement... elements) {
		final DSup answer = _sup() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _sup_(BaseHtmlElement... elements) {
		_sup(elements) ;
		return this ;
	}
	
	public DTable _table() {
		 return _table(-1) ;
	}
	public DFigure _table_() {
		_table() ;
		return this ;
	}
	public DTable _table(final int count) {
		 return (DTable)getOrCreate(DTable.class, count) ;
	}
	public DFigure _table_(final int count) {
		_table(count);
		return this ;
	}
	public DTable _table(final String jif) {
		return _table().jif(jif) ;
	}
	public DFigure _table_(final String jif) {
		_table(jif) ;
		return this ;
	}
	public DTable _table(DTr... rows) {
		final DTable table = _table() ;
		for(DTr row: rows) table.add(row) ;
		return table ;
	}
	public DFigure _table_(DTr... rows) {
		_table(rows) ;
		return this ;
	}
	public DTable _table(BaseHtmlElement... elements) {
		final DTable answer = _table() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _table_(BaseHtmlElement... elements) {
		_table(elements) ;
		return this ;
	}

	public DTextArea _textarea() {
		 return _textarea(-1) ;
	}
	public DFigure _textarea_() {
		_textarea() ;
		return this ;
	}
	public DTextArea _textarea(final int count) {
		 return (DTextArea)getOrCreate(DTextArea.class, count) ;
	}
	public DFigure _textarea_(final int count) {
		_textarea(count);
		return this ;
	}
	public DTextArea _textarea(final String jif) {
		return _textarea().jif(jif) ;
	}
	public DFigure _textarea_(final String jif) {
		_textarea(jif) ;
		return this ;
	}

	public DTime _time() {
		 return _time(-1) ;
	}
	public DFigure _time_() {
		_time();
		return this;
	}
	public DTime _time(final int count) {
		 return (DTime)getOrCreate(DTime.class, count) ;
	}
	public DFigure _time_(final int count) {
		_time(count) ;
		return this ;
	}
	public DTime _time(final String jif) {
		return _time().jif(jif) ;
	}
	public DFigure _time_(final String jif) {
		_time(jif) ;
		return this ;
	}
	public DTime _timeDateTime(final String dateTime) {
		return _time().setHtmlDateTime(dateTime) ;
	}
	public DFigure _timeDateTime_(final String dateTime) {
		_timeDateTime(dateTime);
		return this ;
	}
	public DTime _time(BaseHtmlElement... elements) {
		final DTime answer = _time() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _time_(BaseHtmlElement... elements) {
		_time(elements) ;
		return this ;
	}

	public DUl _ul() {
		 return _ul(-1) ;
	}
	public DFigure _ul_() {
		_ul() ;
		return this ;
	}
	public DUl _ul(final int count) {
		 return (DUl)getOrCreate(DUl.class, count) ;
	}
	public DFigure _ul_(final int count) {
		_ul(count) ;
		return this ;
	}
	public DUl _ul(final Collection<Object> collection) {
		return _ul(collection, "circle") ;
	}
	public DFigure _ul_(final Collection<Object> collection) {
		_ul(collection) ;
		return this ;
	}
	public DUl _ul(final Collection<Object> collection, final String htmlType) 

{
		DUl ul = _ul() ;
		for (Object listElement : collection) {
			final DLi li = new DLi(listElement.toString()) ;
			if (htmlType != null) {
				li.setHtmlType(htmlType);
			}
			ul.add(li) ;
		}	
		return ul ;
	}
	public DFigure _ul_(final Collection<Object> collection, final String 

htmlType) {
		_ul(collection, htmlType) ;
		return this ;
	}
	public DUl _ul(DLi... elements) {
		final DUl answer = _ul() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _ul_(DLi... elements) {
		_ul(elements) ;
		return this ;
	}

	public DVar _var() {
		 return _var(-1) ;
	}
	public DFigure _var_() {
		_var() ;
		return this ;
	}
	public DVar _var(final int count) {
		 return (DVar)getOrCreate(DVar.class, count) ;
	}
	public DFigure _var_(final int count) {
		_var(count) ;
		return this ;
	}
	public DVar _var(final String jif) {
		return _var().jif(jif) ;
	}
	public DFigure _var_(final String jif) {
		_var(jif) ;
		return this ;
	}
	public DVar _varText(final String textValue) {
		return _var().setHtmlExtTextValue(textValue) ;
	}
	public DFigure _varText_(final String textValue) {
		_varText(textValue) ;
		return this ;
	}
	public DVar _var(BaseHtmlElement... elements) {
		final DVar answer = _var() ;
		answer.add(elements) ;
		return answer ;
	}
	public DFigure _var_(BaseHtmlElement... elements) {
		_var(elements) ;
		return this ;
	}

	public DVideo _video() {
		 return _video(-1) ;
	}
	public DFigure _video_() {
		_video();
		return this ;
	}
	public DVideo _video(final int count) {
		 return (DVideo)getOrCreate(DVideo.class, count) ;
	}
	public DFigure _video_(final int count) {
		_video(count) ;
		return this ;
	}
	public DVideo _video(final String jif) {
		return _video().jif(jif) ;
	}
	public DFigure _video_(final String jif) {
		_video(jif) ;
		return this ;
	}

	public DWbr _wbr() {
		 return _wbr(-1) ;
	}
	public DFigure _wbr_() {
		_wbr() ;
		return this ;
	}
	public DWbr _wbr(final int count) {
		 return (DWbr)getOrCreate(DWbr.class, count) ;
	}
	public DFigure _wbr_(final int count) {
		_wbr(count);
		return this ;
	}
	public DWbr _wbr(final String jif) {
		return _wbr().jif(jif) ;
	}
	public DFigure _wbr_(final String jif) {
		_wbr(jif) ;
		return this ;
	}

	public DFigCaption _figcaption() {
		 return _figcaption(-1) ;
	}
	public DFigure _figcaption_() {
		_figcaption() ;
		return this ;
	}
	public DFigCaption _figcaption(final int count) {
		 return (DFigCaption)getOrCreate(DFigCaption.class, count) ;
	}
	public DFigure _figcaption_(final int count) {
		_figcaption(count) ;
		return this ;
	}
	public DFigCaption _figcaption(final String jif) {
		return _figcaption().jif(jif) ;
	}
	public DFigure _figcaption_(final String jif) {
		_figcaption(jif) ;
		return this ;
	}
}


