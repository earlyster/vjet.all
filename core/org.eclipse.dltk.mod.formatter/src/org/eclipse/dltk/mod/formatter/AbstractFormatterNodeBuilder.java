/*******************************************************************************
 * Copyright (c) 2008, 2012 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.mod.formatter;

import java.util.Stack;

public class AbstractFormatterNodeBuilder {

	private final Stack stack = new Stack();

	protected void start(IFormatterContainerNode root) {
		stack.clear();
		stack.push(root);
	}

	protected IFormatterContainerNode peek() {
		return (IFormatterContainerNode) stack.peek();
	}

	protected void push(IFormatterContainerNode node) {
		addChild(node);
		stack.push(node);
	}

	protected void addChild(IFormatterNode node) {
		IFormatterContainerNode parentNode = peek();
		if (!node.isEmpty()) {
			advanceParent(parentNode, node.getStartOffset());
		}
		parentNode.addChild(node);
	}

	private void advanceParent(IFormatterContainerNode parentNode, final int pos) {
		if (parentNode.getEndOffset() < pos) {
			parentNode.addChild(createTextNode(parentNode.getDocument(),
					parentNode.getEndOffset(), pos));
		}
	}

	protected void checkedPop(IFormatterContainerNode expected, int bodyEnd) {
		if (stack.pop() != expected) {
			throw new IllegalStateException();
		}
		if (bodyEnd > 0 && expected.getEndOffset() < bodyEnd) {
			expected.addChild(createTextNode(expected.getDocument(), expected
					.getEndOffset(), bodyEnd));
		}
	}

	/**
	 * @return
	 */
	protected IFormatterTextNode createTextNode(IFormatterDocument document,
			int startIndex, int endIndex) {
		return new FormatterTextNode(document, startIndex, endIndex);
	}
}
